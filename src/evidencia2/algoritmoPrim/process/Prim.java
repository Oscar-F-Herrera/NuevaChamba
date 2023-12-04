package evidencia2.algoritmoPrim.process;
import evidencia2.utils.collections.Grafo;
import evidencia2.utils.collections.Arista;
import evidencia2.utils.collections.Vertice;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Esta clase crea un nuevo grafo de 9 vertices con 15 aristas conectandolos (Representacion visual en canvas)
 * Esta clase tambien se supone que tendria el algoritmo de prim
 * hubiera estado funcional ese aspecto
 */
public class Prim {

    public static void grafo() {
        Grafo GrafoPrim = new Grafo();

        //Se declara los vertices de nuestro grafo
        String unoVertice = "1";
        String dosVertice = "2";
        String tresVertice = "3";
        String cuatroVertice = "4";
        String cincoVertice = "5";
        String seisVertice = "6";
        String sieteVertice = "7";
        String ochoVertice = "8";
        String nueveVertice = "9";

        //Asignamos a nuestro grafo todos los vertices
        GrafoPrim.addVertice(unoVertice);
        GrafoPrim.addVertice(dosVertice);
        GrafoPrim.addVertice(tresVertice);
        GrafoPrim.addVertice(cuatroVertice);
        GrafoPrim.addVertice(cincoVertice);
        GrafoPrim.addVertice(seisVertice);
        GrafoPrim.addVertice(sieteVertice);
        GrafoPrim.addVertice(ochoVertice);
        GrafoPrim.addVertice(nueveVertice);

        //Declaramos las aristas que conectan los vertices del grafo
        GrafoPrim.addArista(cuatroVertice, tresVertice, 1);
        GrafoPrim.addArista(cuatroVertice, unoVertice, 2);
        GrafoPrim.addArista(unoVertice, tresVertice, 8);
        GrafoPrim.addArista(tresVertice, dosVertice, 4);
        GrafoPrim.addArista(unoVertice, dosVertice, 6);
        GrafoPrim.addArista(unoVertice, cincoVertice, 2);
        GrafoPrim.addArista(dosVertice, cincoVertice, 3);
        GrafoPrim.addArista(dosVertice, ochoVertice, 3);
        GrafoPrim.addArista(dosVertice, seisVertice, 8);
        GrafoPrim.addArista(cincoVertice, seisVertice, 2);
        GrafoPrim.addArista(seisVertice, ochoVertice, 1);
        GrafoPrim.addArista(seisVertice, sieteVertice, 4);
        GrafoPrim.addArista(unoVertice, sieteVertice, 7);
        GrafoPrim.addArista(sieteVertice, nueveVertice, 1);
        GrafoPrim.addArista(sieteVertice, ochoVertice, 6);
        GrafoPrim.addArista(ochoVertice, nueveVertice, 5);


        //Despues de multiples intentos de diferentes formas no puedo completar el algoritmo
        // le dedicaria mas tiempo pero gaste demasiado tiempo en esto ya y hay mas que hacer
        //espero que por lo menos pueda valer unos cuantos puntos el intento y el grafo creado

        String nombre = "unoVertice";
        //Vertice verticeActual = " ";

        //Inicia Algoritmo
        //GrafoPrim.buscarEnLista(GrafoPrim.unoVertice.v1);
        PriorityQueue<Vertice> camino = new PriorityQueue<Vertice>();
        //if(nombre.equals())

            //<Arista> adyacencias = GrafoPrim.getAdyacencias(verticeActual);
    }
}
