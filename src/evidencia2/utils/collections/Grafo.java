package evidencia2.utils.collections;

import java.util.ArrayList;
import java.util.HashMap;

public class Grafo {

    private final HashMap<Vertice, ArrayList<Arista>> vertices = new HashMap<>();

    public Grafo() {
    }

    public void addVertice(String nombre) {
        vertices.put(new Vertice(nombre), new ArrayList<Arista>());
    }

    public void addArista(String v1, String v2, double peso) {
        Vertice origen = buscarEnLista(v1);
        Vertice destino = buscarEnLista(v2);

        Arista arista = new Arista(origen, destino, peso);

        vertices.get(origen).add(arista);
    }

    public ArrayList<Arista> getAdyacencias(Vertice vertice){
        return vertices.get(vertice);
    }

    @Override
    public String toString() {
        return "grafo";
    }

    public Vertice buscarEnLista(String nombre){
        for (Vertice vertice : vertices.keySet()) {
            if (vertice.getNombre().equals(nombre)){
                return vertice;
            }
        }

        addVertice(nombre);
        return buscarEnLista(nombre);
    }

}
