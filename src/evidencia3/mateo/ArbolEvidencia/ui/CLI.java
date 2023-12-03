package evidencia3.mateo.ArbolEvidencia.ui;
import java.util.*;

/**
 * esta clase es la que se encarga de todas las interacciones del usuario
 */
public class CLI {

    /**
     * este metodo da la bienvenida al juego y tambien si se juega otra vez o se cierra el programa
     * @param primeraVezJugando indica si es el primer bucle del programa que utiliza el usuario
     */
    public static void menuInicio(boolean primeraVezJugando){
        String seleccionMenu = " " ;
        boolean procesoFinalizado = false;

        if(primeraVezJugando == true){
            System.out.println("Bienvenido al juego de adivinar animales");
            System.out.println("¿Que desea hacer?");
            System.out.println("a: Iniciar el juego");
            System.out.println("b: Finalizar programa");
            primeraVezJugando = false;
        } else {
            System.out.println("Espero que su partida fuera divertida");
            System.out.println("¿Desea jugar nuevamente?");
            System.out.println("a: Jugar de nuevo");
            System.out.println("Finalizar programa");
        }

        Scanner lector = new Scanner(System.in);

        do{
            seleccionMenu = lector.nextLine();

            switch (seleccionMenu) {
                case "a":
                    procesoFinalizado = true;
                    System.out.print("muy bien, recuerde que solo puede contestar con: ");
                    System.out.print("si y no");
                    System.out.println("sin mayusculas");
                    System.out.println("que se divierta");
                    break;
                case "b":

                    //Aqui se llama el metodo que guarda el arbol binario

                    break;
                default:
                    System.out.println("Favor de introducir una opcion valida");
            }

        } while(procesoFinalizado == false);
    }

    /**
     * este metodo toma lo que escribe el usuario para procesarlo
     * @param input lo que escribe el usuario en la consola
     */
    public static void inputUsuario(String input){

        Scanner inputReader = new Scanner(System.in);
        input = inputReader.nextLine();
    }

    /**
     * este metodo imprime la pregunta de que animal es el que se esta adivinando
     * @param data el dato de animal o pregunta que esta usando el programa actualmente
     */
    public static void printPregunta(String data){
        System.out.println("Acaso tu animal...");
        System.out.println("¿"+data+"?");
    }

    /**
     *  este metodo imprime una adivinacion del animal
     * @param data el dato de animal o pregunta que esta usando el programa actualmente
     */
    public static void printGuess(String data){
        System.out.print("Es el animal en el que estas pensando un...");
        System.out.print("¿"+" "+"?");
    }

    /**
     * este metodo imprime texto de si se adivino correctamente el animal
     */
    public static void printGuessCorrecto(){
        System.out.println("¡El juego ha terminado!");
        System.out.println("Claramente el programa sabia cual seria su animal");
    }

    /**
     * este metodo se encarga de imprimr texto referente a si la adivinacion es incorrecta
     */
    public static void printGuessincorrecto(){
        System.out.println("¡Oh!");
        System.out.println("Entonces...");
    }

    /**
     * este  metodo se encarga de imprimir texto referente a cuando el programa no pudo adivinar el animal
     */
    public static void printGuessincorrectoFinal(){
        System.out.println("¡Caramba!");
        System.out.println("Parece que el programa no pudo averiguar su animal");
    }

    /**
     * este metodo imprime texto en consola sobre no saber que ainmal es el del usuario
     */
    public static void printQueEs(){
        System.out.println("¡Interesante!");
        System.out.println("El programa no tiene registro del animal en el que piensas..");
        System.out.println("¿Cual es?");
    }

    /**
     *  este metodo pregunta que diferencia hay entre lo que tiene y lo que puso el usuario
     * @param data el dato de animal o pregunta que esta usando el programa actualmente
     * @param input lo que escribio el usuario en consola
     */
    public static void printQueDiferencia(String data, String input){
        System.out.println("El programa deveras se pregunta....");
        System.out.println("¿Que diferencia hay entre "+data+"con"+input+"?");
    }

    /**
     * este metodo indica que se hiso la actualizacion de arbol correctamente en texto
     */
    public static void printCambioNodo(){
        System.out.println("El programa ahora es mas inteligente y ya sabe que es un"+" "+", muchas gracias");
    }




}
