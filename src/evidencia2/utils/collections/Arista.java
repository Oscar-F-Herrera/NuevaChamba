package evidencia2.utils.collections;

/**
 * Clase que funciona de base para crear aristas en una estructura de grafo
 */
public class Arista {

    //Atributos
    private final Vertice v1;
    private final Vertice v2;
    private final double peso;

    //Métodos

    /**
     * Constructor de la arista
     *
     * @param v1 El vértice de origen
     * @param v2 El vértice de destino
     * @param peso El peso de la arista
     */
    public Arista(Vertice v1, Vertice v2, double peso) {
        this.v1 = v1;
        this.v2 = v2;
        this.peso = peso;
    }

    /**
     * Obtiene el vértice de origen de la arista
     *
     * @return El vértice de origen
     */
    public Vertice getV1() {
        return v1;
    }

    /**
     * Obtiene el vértice de destino de la arista
     *
     * @return El vértice de destino
     */
    public Vertice getV2() {
        return v2;
    }

    /**
     * Obtiene el peso de la arista
     *
     * @return El peso de la arista
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Devuelve la representación en String de la arista
     *
     * @return Una cadena que describe la arista, incluyendo sus vértices y peso.
     */
    @Override
    public String toString() {
        return "Arista de " + v1.getNombre() + " y " + v2.getNombre() + " con un peso de " + peso;
    }

}
