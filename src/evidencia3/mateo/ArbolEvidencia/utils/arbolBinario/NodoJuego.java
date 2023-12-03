package evidencia3.mateo.ArbolEvidencia.utils.arbolBinario;

/**
 * Esta clase crea el objeto de nodo cual permite que el programa funcione y utilize el arbol y nodos del programa
 */
public class NodoJuego {

    private static NodoJuego Root = null;
    public NodoJuego CurrentNode = null;
    private NodoJuego NextLeft; //Si
    private NodoJuego NextRight; //No
    private String tipoNodo;
    private String data;
    private NodoJuego NodoAnterior;
    private Boolean correcto;

    /**
     * Constructor de un nodo del arbol
     */
    public NodoJuego(){
        this.data = data;
        this.tipoNodo = tipoNodo;
        this.correcto = correcto;

    }

    /**
     *
     * @return regresa que tipo de nodo es el nodo
     * NodoPregunta, Nodo Respuesta
     */
    public String getTipoNodo() {
        return tipoNodo;
    }

    /**
     * Este metodo obtiene el tipo de nodo de un nodo del arbol
     * @param tipoNodo el tipo de nodo del arbol
     */
    public void setTipoNodo(String tipoNodo) {
        this.tipoNodo = tipoNodo;
    }

    /**
     * Este metodo obtiene la informacion de un nodo
     * @return la informacion de un nodo
     */
    public String getData() {
        return data;
    }

    /**
     * Este metodo fija cual es la informacion de un nodo
     * @param data
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * este metodo es deprecado ya no se usa
     * @return
     */
    public Boolean getCorrecto() {
        return correcto;
    }

    /**
     * este metodo ya no se usa tampoco
     */
    public void setCorrecto(Boolean correcto) {
        this.correcto = correcto;
    }

    /**
     * Este metodo obtiene el nodo hijo isquierdo de un nodo
     * @param currentNode el nodo que es actual que esta viendo el programa
     * @return el hijo nodo isquierdo
     */
    public NodoJuego getNextLeft(NodoJuego currentNode) {
        return NextLeft;
    }

    /**
     * Este metodo fija el nodo isquierdo hijo del nodo actual
     * @param nextLeft
     */
    public void setNextLeft(NodoJuego nextLeft) {
        NextLeft = nextLeft;
    }

    /**
     * Este metodo obtiene el nodo hijo de la derecha del nodo actual
     * @param currentNode nodo actual
     * @return nodo hijo derecho
     */
    public NodoJuego getNextRight(NodoJuego currentNode) {
        return NextRight;
    }

    /**
     * este metodo fija el hijo derecho del nodo
     * @param nextRight hijo derecho
     */
    public void setNextRight(NodoJuego nextRight) {
        NextRight = nextRight;
    }

    /**
     * este metodo obtiene el nodo padre del nodo actual
     * @return el nodo padre
     */
    public NodoJuego getNodoAnterior() {
        return NodoAnterior;
    }

    /**
     * este metodo fija cual es el nodo padre del nodo actual
     * @param nodoAnterior el nodo padre
     */
    public void setNodoAnterior(NodoJuego nodoAnterior) {
        NodoAnterior = nodoAnterior;
    }

    /**
     * este metodo fija cual es el nodo raiz
     * @return raiz
     */
    public static NodoJuego getRoot() {
        return Root;
    }

    /**
     * este metodo fija la raiz del arbol
     * @param root raiz
     */
    public static void setRoot(NodoJuego root) {
        Root = root;
    }

    /**
     * este metodo obtiene cual es el nodo actual que se esta usando
     * @return nodo actual
     */
    public NodoJuego getCurrentNode() {
        return CurrentNode;
    }

    /**
     * este nodo fija cual es el nodo actual que esta usando el programa
     * @param currentNode nodo actual
     */
    public void setCurrentNode(NodoJuego currentNode) {
        CurrentNode = currentNode;
    }
}