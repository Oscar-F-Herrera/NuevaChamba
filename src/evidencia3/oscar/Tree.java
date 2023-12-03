package evidencia3.oscar;

import java.io.Serializable;

/**
 * Clase que representa un árbol binario utilizado en el juego de adivinar animales
 *
 * @author Oscar Herrera
 */
public class Tree implements Serializable {
    //Atributos
    private final String INITIAL_Q = "¿Tiene cuernos?";
    private final String[] INITIAL_ANS = {"Perro", "Vaca"};

    private Node root;
    private Node current;
    private Node previous;

    //Constructor
    /**
     * Constructor de la clase Tree
     * Inicializa los nodos raíz, actual y anterior del árbol
     */
    public Tree() {
        root = null;
        current = root;
        previous = null;
    }

    //Métodos
    /**
     * Inicializa el árbol con la pregunta y animales iniciales
     */
    public void initialize() {
        root = new Node(INITIAL_Q);
        current = root;
        this.root.left = new Node(INITIAL_ANS[0]);
        this.root.right = new Node(INITIAL_ANS[1]);
    }

    /**
     * Obtiene el nodo actual en el árbol
     *
     * @return Nodo actual en el árbol
     */
    public Node getCurrentNode(){
        return current;
    }

    /**
     * Obtiene los datos almacenados en un nodo
     *
     * @param n Nodo del cual se obtendrán los datos
     * @return Datos almacenados en el nodo
     */
    public String getData(Node n){
        return n.data;
    }

    /**
     * Avanza al nodo hijo especificado (izquierdo o derecho) y actualiza el nodo anterior
     *
     * @param n Entero que indica si se avanza al hijo izquierdo (0) o derecho (1)
     */
    public void advanceCurrent(int n) {
        if (n == 1) {
            previous = current;
            current = this.current.right;
        } else {
            previous = current;
            current = this.current.left;
        }
    }

    /**
     * Agrega un nuevo nodo al árbol con una pregunta y una respuesta dadas
     *
     * @param question Pregunta para el nuevo nodo
     * @param answer Respuesta para el nuevo nodo
     * @param n Entero que indica si se agrega como hijo izquierdo (0) o derecho (1)
     */
    public void addNode(String question,String answer,int n){
        Node node = new Node(question);
        Node temp = current;

        current = node;
        current.left = temp;
        current.right = new Node(answer);

        if(n == 1) {
            previous.right = current;
        }
        else {
            previous.left = current;
        }

        reset();

        System.out.println("Nuevo nodo agregado");
    }

    /**
     * Verifica si el nodo actual es una hoja
     *
     * @return true si el nodo actual es una hoja, false de lo contrario
     */
    public boolean hasLeaf(){
        return (current.left==null && current.right==null);
    }

    /**
     * Reinicia el nodo actual al nodo raíz del árbol
     */
    public void reset(){
        current = root;
    }
}