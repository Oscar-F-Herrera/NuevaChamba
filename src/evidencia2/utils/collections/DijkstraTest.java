package evidencia2.utils.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Clase de prueba que verifica la funcionalidad del algoritmo de Dijkstra
 */
public class DijkstraTest {

    private Grafo grafo;

    /**
     * Inicializa un grafo con vértices y aristas para su uso en las pruebas.
     */
    @Before
    public void init() {
        final double PESO_NEUTRO = 0;
        grafo = new Grafo();
        // nombres de vertices
        final String CINCO = "5";
        final String CUATRO = "4";
        final String TRES = "3";
        final String OCHO = "8";
        final String QUINCE = "15";
        final String DIEZ = "10";
        final String NUEVE = "9";
        // agregar vertices
        grafo.addVertice(CINCO);
        grafo.addVertice(CUATRO);
        grafo.addVertice(TRES);
        grafo.addVertice(OCHO);
        grafo.addVertice(QUINCE);
        grafo.addVertice(DIEZ);
        grafo.addVertice(NUEVE);

        // agregar aristas
        grafo.addArista(CINCO,OCHO,3);

        grafo.addArista(CINCO,CUATRO,PESO_NEUTRO);

        grafo.addArista(CUATRO,OCHO,4);

        grafo.addArista(CUATRO,TRES,2);

        grafo.addArista(TRES,OCHO,1);

        grafo.addArista(TRES,DIEZ,PESO_NEUTRO);

        grafo.addArista(OCHO,QUINCE,5);

        grafo.addArista(QUINCE,NUEVE,3);

        grafo.addArista(NUEVE,DIEZ,2);

    }

    /**
     * Prueba la funcionalidad del algoritmo de Dijkstra para encontrar la distancia más corta entre dos vertices
     */
    @Test
    public void testSmallestPath(){
        System.out.println("TEST: Dijkstra");
        Vertice inicio = grafo.buscarEnLista("5");
        Vertice destino = grafo.buscarEnLista("10");
        if (calcularDistanciaEntreVertices(grafo,inicio,destino) == 2){
            System.out.println("Passed");
        }
        else {
            System.out.println("Not passed");
        }
        System.out.println("................................");
    }

    /**
     * Calcula la distancia más corta entre dos vértices
     *
     * @param grafo El grafo en el que se realizará el cálculo.
     * @param inicio El vértice de inicio.
     * @param destino El vértice de destino.
     * @return La distancia más corta entre los vértices de inicio y destino.
     */
    public static double calcularDistanciaEntreVertices(Grafo grafo, Vertice inicio, Vertice destino) {

        HashMap<Vertice, Double> distancias = new HashMap<>();

        for (Vertice vertice : grafo.getVertices()) {
            if (vertice.equals(inicio)) {
                distancias.put(vertice, 0.0);
            } else {
                distancias.put(vertice, Double.POSITIVE_INFINITY);
            }
        }

        PriorityQueue<Vertice> colaPrioridad = new PriorityQueue<>(Comparator.comparingDouble(distancias::get));

        colaPrioridad.add(inicio);

        while (!colaPrioridad.isEmpty()) {
            Vertice actual = colaPrioridad.poll();

            ArrayList<Arista> adyacencias = grafo.getAdyacencias(actual);
            for (Arista arista : adyacencias) {
                Vertice vecino = arista.getV2();
                double nuevaDistancia = distancias.get(actual) + arista.getPeso();

                if (nuevaDistancia < distancias.get(vecino)) {
                    distancias.put(vecino, nuevaDistancia);
                    colaPrioridad.add(vecino);
                }
            }
        }

        return distancias.get(destino);
    }

}
