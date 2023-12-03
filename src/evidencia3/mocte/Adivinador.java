package evidencia3.mocte;

import java.io.*;
import java.util.Scanner;

public class Adivinador {
    private static Tree tree;
    private Stream stream;
    private Scanner scanner;

    public Adivinador(){
        stream = new Stream();
        scanner = new Scanner(System.in);

        if (stream.hasFile()) {
            stream.readFromSave();
            System.out.println("Conciencia cargada desde el archivo");
        } else {
            tree = new Tree();
            tree.initialize();
            System.out.println("Una nueva Conciencia ha sido creada");
        }

        System.out.println();
    }

    public void play() {
        stream.writeToSave();

        sleep(2000);
        welcome();
        sleep(2000);

        for (;;) {
            String current = tree.getData(tree.getCurrentNode());
            int response, last = -1;

            while (!tree.hasLeaf()) {
                response = inquire(current);
                last = response;
                checkResponse(response);
                tree.advanceCurrent(response);
                current = tree.getData(tree.getCurrentNode());
            }

            sleep(2000);
            System.out.println("\nCreo que ya sé que es...");
            sleep(2000);

            System.out.println("¿Acaso tu animal es un " + current + "?");

            response = getResponse();
            checkResponse(response);

            if (response == 1) {
                System.out.println("\nMe desperte bien C, como dicen los chavos");
            } else {
                System.out.println("\nQuizás la proxima...");
                learn(last);
            }

            tree.reset();

            System.out.println("\nLo intentamos otra vez?");

            if (getResponse() == 0) {
                System.out.println("\nBye bye!");
                break;
            }

            System.out.println();
            welcome();
        }
    }

    public void welcome(){
        try{
            System.out.println("Hola, soy MomosBot 4000");
            Thread.sleep(1500);
            System.out.println("Hay que jugar a las adivinanzas!");
            Thread.sleep(1500);
            System.out.println("Solo recuerda responder con \"si\" o \"no\"\n");
        }catch(InterruptedException e){
            System.err.println(e);
        }
    }

    public int inquire(String question){
        if(question != null){
            System.out.print(question + "\n");
            return getResponse();
        }else
            System.out.println("No tengo preguntas que hacer");

        return -1;
    }

    public void learn(int last){
        String question = "", targetAnimal = "";
        boolean listening = true;

        while(listening){
            targetAnimal = getAnimal();

            question = getQuestion();

            System.out.println("\nConfirma que la pregunta esté correcta");
            System.out.println("\""+question.toUpperCase()+"\" es aplicable a"
                    +" un(a) "+targetAnimal.toUpperCase()+"?");

            if(getResponse()==1){
                listening=false;
            }
        }

        System.out.println();

        tree.addNode(question,targetAnimal,last);

        stream.writeToSave();
        System.out.println("Nuevo animal agragado");
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    public int getResponse(){
        String input;

        input = scanner.next();

        while(!input.matches("si") && !input.matches("no") && !input.matches("salir")){
            System.out.println("Respuesta inválida");
            input=scanner.next();
        }

        if(input.equalsIgnoreCase("si")){
            return 1;
        }else if(input.equalsIgnoreCase("no")){
            return 0;
        }else if(input.equalsIgnoreCase("salir")){
            System.out.println("Cerrando el programa");
            System.exit(0);
        }else
            System.out.println("Error de respuesta");

        return -1;
    }

    public String getAnimal(){
        String targetAnimal;

        System.out.println("¿En qué animal estabas pensando?");
        scanner.nextLine();
        targetAnimal = scanner.next().toLowerCase();

        return targetAnimal.substring(0,1).toUpperCase() + targetAnimal.substring(1);
    }

    public String getQuestion(){
        String question;

        System.out.println("¿Que pregunta puede diferenciar a tu animal del que te respondí?");
        scanner.nextLine();
        question = format(scanner.nextLine()).toLowerCase();

        return question.substring(0,1).toUpperCase()+question.substring(1);
    }

    public void checkResponse(int response){
        if(response == -1){
            System.out.println("Respuesta incorrecta, cerrando el programa");
            System.exit(response);
        }
    }

    public String format(String string){
        return string.replaceAll("\\s+"," ") .trim();
    }

    private record Stream(String SAVE_FILE) {

        public Stream() {
            this("memoria.txt");
        }

        public void readFromSave() {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_FILE))) {
                tree = (Tree) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e);
            }
        }

        public void writeToSave() {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_FILE))) {
                oos.writeObject(tree);
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        public boolean hasFile() {
            return new File(SAVE_FILE).isFile();
        }
    }
}
