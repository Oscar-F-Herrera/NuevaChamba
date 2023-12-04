package evidencia2.utils.collections;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Esta clase representa un vértice en una estructura de grafo
 */
public class Vertice extends ArrayList {

    //Atributos
    private final String nombre;

    /**
     * Constructor para crear un nuevo vértice con un nombre
     *
     * @param nombre El nombre del vértice
     */
    public Vertice(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre del vértice
     *
     * @return El nombre del vértice
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Calcula el valor hash del vértice basado en su nombre
     *
     * @return El valor hash calculado para el vértice
     */
    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    /**
     * Compara este vértice con otro objeto para ver si son iguales
     *
     * @param o El objeto a comparar
     * @return true si el objeto es igual a este vértice o false si no
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertice vertice = (Vertice) o;
        return Objects.equals(nombre, vertice.nombre);
    }
}
