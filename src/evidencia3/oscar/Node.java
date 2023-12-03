package evidencia3.oscar;

import java.io.Serializable;

/**
 * Clase que representa un nodo en un árbol binario
 *
 * @author Oscar Herrera
 */
public class Node implements Serializable{
    //Atributos
    String data;
    Node left;
    Node right;

    //Constructor

    /**
     * Constructor de la clase Node
     *
     * @param data Un string que representa ya sea una pregunta o el nombre de un animal
     */
    public Node(String data) {
        this.data = data;
        left = null;
        right = null;
    }
}
