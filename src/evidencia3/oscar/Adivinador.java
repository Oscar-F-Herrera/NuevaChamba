package evidencia3.oscar;

import java.io.*;
import java.util.Scanner;

public class Adivinador {
    //Atributos
    private static Tree tree;
    private Stream stream;
    private Scanner scanner;

    /**
     * Constructor de la clase Adivinador
     * Inicializa un objeto Adivinador con un flujo de datos y un escáner
     * Carga un árbol desde un archivo si está disponible; de lo contrario, crea un nuevo árbol
     */
    public Adivinador(){
        stream = new Stream();
        scanner = new Scanner(System.in);

        if (stream.hasFile()) {
            stream.readFromSave();
            System.out.println("Árbol cargado desde el archivo");
        } else {
            tree = new Tree();
            tree.initialize();
            System.out.println("Un nuevo árbol ha sido creado");
        }

        System.out.println();
    }

    /**
     * Método que inicia y controla la lógica del juego de adivinanza
     * Realiza la escritura del árbol en el archivo de guardado, saluda al usuario y ejecuta el bucle principal del juego
     * El bucle permite al usuario realizar preguntas, adivinar animales y aprender de sus respuestas
     */
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
            System.out.println("\nCreo saber en que animal piensas...");
            sleep(2000);

            System.out.println("¿Tu animal es un " + current + "?");

            response = getResponse();
            checkResponse(response);

            if (response == 1) {
                System.out.println("\n¡Vamos! así es como gana la evolución");
            } else {
                System.out.println("\nFelicidades, me ganaste ésta vez");
                learn(last);
            }

            tree.reset();

            System.out.println("\n¿Te gustaría volver a jugar?");

            if (getResponse() == 0) {
                System.out.println("\nEspero verte pronto, ¡Que te vaya bien!");
                break;
            }

            System.out.println();
            welcome();
        }
    }

    /**
     * Método que imprime un mensaje de bienvenida al usuario y proporciona instrucciones para jugar
     * El mensaje se presenta con pausas para mejorar la experiencia del usuario
     */
    public void welcome(){
        try{
            System.out.println("Hola, soy el que adivina, el adivinador");
            Thread.sleep(1500);
            System.out.println("Piensa en un animal y yo intentaré adivinarlo");
            Thread.sleep(1500);
            System.out.println("Pero por favor, solo responde \"si\" o \"no\"\n");
        }catch(InterruptedException e){
            System.err.println(e);
        }
    }

    /**
     * Método que realiza una pregunta al usuario basada en el String proporcionada y espera su respuesta
     * Imprime la pregunta y devuelve la respuesta obtenida
     *
     * @param question String que representa la pregunta al usuario
     * @return Entero que indica la respuesta del usuario
     *         1 si la respuesta es afirmativa ("si"), 0 si es negativa ("no"), -1 si no hay pregunta para hacer
     */
    public int inquire(String question){
        if(question != null){
            System.out.print(question + "\n");
            return getResponse();
        }else
            System.out.println("No tengo preguntas que hacer");

        return -1;
    }

    /**
     * Método que permite al programa aprender de una respuesta incorrecta proporcionada por el usuario
     * Solicita una nueva pregunta y el animal correcto, y confirma la información antes de agregarla al árbol
     * Luego, guarda el nuevo estado del árbol en el archivo de guardado
     *
     * @param last Entero que representa la respuesta anterior del usuario
     */
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

    /**
     * Método privado que pausa tantito la ejecución en milisegundos
     *
     * @param milliseconds Tiempo de pausa en milisegundos
     */
    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    /**
     * Método que solicita y obtiene la respuesta del usuario, validando que sea "si" o "no"
     * También permite salir del programa si el usuario ingresa "salir"
     *
     * @return Entero que indica la respuesta del usuario.
     */
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

    /**
     * Método que solicita y obtiene el nombre del animal en el que el usuario está pensando
     *
     * @return Cadena que representa el nombre del animal proporcionado por el usuario
     */
    public String getAnimal(){
        String targetAnimal;

        System.out.println("¿En qué animal estabas pensando?");
        scanner.nextLine();
        targetAnimal = scanner.next().toLowerCase();

        return targetAnimal.substring(0,1).toUpperCase() + targetAnimal.substring(1);
    }

    /**
     * Método que solicita y obtiene la pregunta que el usuario desea agregar al árbol para diferenciar su animal
     *
     * @return Cadena que representa la pregunta proporcionada por el usuario
     */
    public String getQuestion(){
        String question;

        System.out.println("¿Que pregunta tengo que hacer para diferenciar a tu animal del que te respondí?");
        scanner.nextLine();
        question = format(scanner.nextLine()).toLowerCase();

        return question.substring(0,1).toUpperCase()+question.substring(1);
    }

    /**
     * Método que verifica si la respuesta del usuario es incorrecta y, en ese caso, imprime un mensaje y cierra el programa
     *
     * @param response Entero que representa la respuesta del usuario
     */
    public void checkResponse(int response){
        if(response == -1){
            System.out.println("Respuesta incorrecta, cerrando el programa");
            System.exit(response);
        }
    }

    /**
     * Método que elimina espacios en blanco adicionales y realiza un recorte de los extremos de una cadena dada
     *
     * @param string Cadena que se formateará.
     * @return Cadena formateada sin espacios en blanco adicionales al principio o al final
     */
    public String format(String string){
        return string.replaceAll("\\s+"," ") .trim();
    }

    /**
     * Clase que gestiona la entrada y salida de datos para guardar el árbol en un archivo
     */
    private record Stream(String SAVE_FILE) {

        /**
         * Constructor de la clase Stream
         * Inicializa un objeto Stream con el nombre predeterminado del archivo de guardado
         */
        public Stream() {
            this("tree_save.txt");
        }

        /**
         * Lee el árbol desde el archivo de guardado
         */
        public void readFromSave() {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_FILE))) {
                tree = (Tree) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e);
            }
        }

        /**
         * Escribe el árbol en el archivo de guardado
         */
        public void writeToSave() {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_FILE))) {
                oos.writeObject(tree);
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        /**
         * Verifica si el archivo de guardado existe
         *
         * @return true si el archivo de guardado existe, false de lo contrario
         */
        public boolean hasFile() {
            return new File(SAVE_FILE).isFile();
        }
    }
}
