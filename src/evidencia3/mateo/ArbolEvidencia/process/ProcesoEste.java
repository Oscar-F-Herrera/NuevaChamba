package evidencia3.mateo.ArbolEvidencia.process;
import evidencia3.mateo.ArbolEvidencia.ui.CLI;
import evidencia3.mateo.ArbolEvidencia.utils.arbolBinario.ArbolJuego;
import evidencia3.mateo.ArbolEvidencia.utils.arbolBinario.NodoJuego;

/**
 * Esta clase es el corazon del juego, aqui pasa el procesamiento de este desde guardar en el archivo el arbol hasta
 * ir de nodo en nodo en el arbol haciendo las preguntas
 */
public class ProcesoEste {

    public static void juegoAnimales(boolean primeraVezJugando) {
        CLI.menuInicio(primeraVezJugando);
        NodoJuego Arbol1 = new NodoJuego();

        String data = " ";
        String input = " ";
        String animalNuevo = " "; //En caso de no adivinar esta variable guarda el animal para meterlo al arbol
        String diferencia = " ";   //En caso de no adivinar esta variable guarda la diferencia para meterla al arbol
        boolean nuevoAnimal = false;
        boolean correcto = false;
        boolean juegoFinalizado = false;

        if (NodoJuego.getRoot() == null) {

            //Obten del archivo el arbol actual

        }

        CLI.printPregunta(data);
        CLI.inputUsuario(input);
        switch (input) {
            case "si":
                Arbol1.getNextLeft(Arbol1.CurrentNode);
                break;
            case "no":
                Arbol1.getNextRight(Arbol1.CurrentNode);
                break;
        }

        do {
            data = Arbol1.CurrentNode.getData();

            if (data == null) {
                juegoFinalizado = true;
                CLI.printGuessincorrectoFinal();
                CLI.printQueEs();
                CLI.inputUsuario(input);
                animalNuevo = input;
                CLI.printQueDiferencia(data,input);
                CLI.inputUsuario(input);
                diferencia = input;
                //Aqui salimos del do while con los datos nuevos en variables separadas para meterlas al arbol
                break;
            }

            CLI.printGuess(data);
            CLI.inputUsuario(input);
            if (data == input) {
                CLI.printGuessCorrecto();
                juegoFinalizado = true;
                primeraVezJugando = false;
                CLI.menuInicio(primeraVezJugando);
            } else {
                CLI.printGuessincorrecto();
            }

            switch (input) {
                case "si":
                    Arbol1.getNextLeft(Arbol1.CurrentNode);
                    break;
                case "no":
                    Arbol1.getNextRight(Arbol1.CurrentNode);
                    break;
            }

        } while (juegoFinalizado == false);


        //Aqui creamos y ponemos el nuevo animal y dato
        if(nuevoAnimal == true){



        }
        CLI.menuInicio(primeraVezJugando);
    }
}
