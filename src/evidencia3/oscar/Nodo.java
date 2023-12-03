package evidencia3.oscar;

/**
 * Clase que representa un nodo en un árbol binario
 *
 * @author Oscar Herrera
 */
public class Nodo {
    //Atributos
    String data;
    Nodo left;
    Nodo right;

    //Constructor

    /**
     * Constructor de la clase Nodo
     *
     * @param data Un string que representa ya sea una pregunta o el nombre de un animal
     */
    public Nodo(String data) {
        this.data = data;
        left = null;
        right = null;
    }
}
