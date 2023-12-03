package evidencia3.mateo.ArbolEvidencia.utils.arbolBinario;

/**
 * Esta es una clase que no se usa pero decidi no borrarla, toda la funcionalidad deesta clase esta en la clase NodoJuego
 *
 */
public class ArbolJuego {
    private ArbolJuego root;
    private ArbolJuego leftofRoot; //Si
    private ArbolJuego rightofRoot; //No

    /**
     * Constructor con raiz de la clase ArbolJuego
     */
    public ArbolJuego(){
        this.root = root;
    }

    /**
     * Este metodo obtiene la raiz de el arbol
     * @return regresa la raiz del arbol
     */
    public ArbolJuego getRoot() {
        return root;
    }

    /**
     * Este metodo pone cual nodo es la raiz
     */
    public void setRoot() {
        this.root = root;
    }

    /**
     * Este metodo no se usa pero teoricamente sacaria el nodo hijo a la isquierda de la raiz
     * @param currentNode cual es el nodo actual del arbol
     * @return
     */
    public ArbolJuego getLeftofRoot(ArbolJuego currentNode) {
        return leftofRoot;
    }

    /**
     * Este metodo no se usa pero teoricamente sacaria el nodo hijo a la derecha de la raiz
     * @param currentNode el nodo actual que esta viendo el programa
     * @return
     */
    public ArbolJuego getRightofRoot(ArbolJuego currentNode) {
        return rightofRoot;
    }

    /**
     * Este metodo no se usa pero teoricamente pondria cual es el nodo a la derecha de la raiz
     * @param rightofRoot el nodo hijo a la derecha de la raiz
     */
    public void setRightofRoot(ArbolJuego rightofRoot) {
        this.rightofRoot = rightofRoot;
    }
}
