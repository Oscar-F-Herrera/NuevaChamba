package evidencia2.utils.collections;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase que representa un grafo no dirigido utilizando una estructura de lista de adyacencia
 */
public class Grafo {

    private final HashMap<Vertice, ArrayList<Arista>> vertices = new HashMap<>();

    /**
     * Constructor para crear un grafo vacío
     */
    public Grafo() {
    }

    /**
     * Agrega un nuevo vértice al grafo con nombre
     *
     * @param nombre El nombre del vértice que se agregará
     */
    public void addVertice(String nombre) {
        vertices.put(new Vertice(nombre), new ArrayList<Arista>());
    }

    /**
     * Agrega una arista entre dos vértices con un peso
     *
     * @param v1 El nombre del vértice de origen
     * @param v2 El nombre del vértice de destino
     * @param peso El peso de la arista
     */
    public void addArista(String v1, String v2, double peso) {
        Vertice origen = buscarEnLista(v1);
        Vertice destino = buscarEnLista(v2);

        Arista arista = new Arista(origen, destino, peso);

        vertices.get(origen).add(arista);
    }

    /**
     * Obtiene una lista de aristas adyacentes al vértice especificado
     *
     * @param vertice El vértice del cual se desean obtener las aristas adyacentes
     * @return Una lista de aristas adyacentes al vértice
     */
    public ArrayList<Arista> getAdyacencias(Vertice vertice){
        return vertices.get(vertice);
    }

    /**
     * Devuelve la representación en String del grafo
     *
     * @return Una cadena que representa el grafo
     */
    @Override
    public String toString() {
        return "grafo";
    }

    /**
     * Busca un vértice en la lista de vértices por su nombre
     * Si no se encuentra, se agrega un nuevo vértice con ese nombre y se vuelve a buscar
     *
     * @param nombre El nombre del vértice a buscar o agregar
     * @return El vértice encontrado o recién creado
     */
    public Vertice buscarEnLista(String nombre){
        for (Vertice vertice : vertices.keySet()) {
            if (vertice.getNombre().equals(nombre)){
                return vertice;
            }
        }

        addVertice(nombre);
        return buscarEnLista(nombre);
    }

    public ArrayList<Vertice> getVertices() {
        ArrayList<Vertice> listaVertices = new ArrayList<>();
        for (Vertice vertice : vertices.keySet()) {
            listaVertices.add(vertice);
        }
        return listaVertices;
    }

}
