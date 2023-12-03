package evidencia3.oscar;

/**
 * Clase que representa un árbol binario utilizado en el juego de adivinar animales
 *
 * @author Oscar Herrera
 */
public class Arbol {
    //Atributos
    private final String INITIAL_Q = "¿Tiene cuernos?";
    private final String[] INITIAL_ANS = {"Vaca", "Perro"};

    private Nodo root;
    private Nodo current;
    private Nodo previous;

    //Constructor
    /**
     * Constructor de la clase Arbol
     * Inicializa los nodos raíz, actual y anterior del árbol
     */
    public Arbol() {
        root = null;
        current = root;
        previous = null;
    }

    //Métodos
    /**
     * Inicializa el árbol con la pregunta y animales iniciales
     */
    public void initialize() {
        root = new Nodo(INITIAL_Q);
        current = root;
        this.root.left = new Nodo(INITIAL_ANS[0]);
        this.root.right = new Nodo(INITIAL_ANS[1]);
    }

    /**
     * Obtiene el nodo actual en el árbol
     *
     * @return Nodo actual en el árbol
     */
    public Nodo getCurrentNode(){
        return current;
    }

    /**
     * Obtiene los datos almacenados en un nodo
     *
     * @param n Nodo del cual se obtendrán los datos
     * @return Datos almacenados en el nodo
     */
    public String getData(Nodo n){
        return n.data;
    }

    /**
     * Avanza al nodo hijo especificado (izquierdo o derecho) y actualiza el nodo anterior
     *
     * @param n Entero que indica si se avanza al hijo izquierdo (0) o derecho (1)
     */
    public void advanceCurrent(int n) {
        if (n == 0) {
            previous = current;
            current = this.current.left;
        } else {
            previous = current;
            current = this.current.right;
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
        Nodo node = new Nodo(question);
        Nodo temp = current;

        current = node;
        current.left = temp;
        current.right = new Nodo(answer);

        if(n == 0) {
            previous.left = current;
        }
        else {
            previous.right = current;
        }

        reset();

        System.out.println("Nuevo nodo agregado");
    }

    /**
     * Verifica si el nodo actual es una hoja
     *
     * @return true si el nodo actual es una hoja, false de lo contrario
     */
    public boolean isLeaf(){
        return (current.left == null && current.right == null);
    }

    /**
     * Reinicia el nodo actual al nodo raíz del árbol
     */
    public void reset(){
        current = root;
    }
}