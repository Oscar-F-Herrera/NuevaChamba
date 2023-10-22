package evidencia2.utils.collections;

import java.util.Objects;

public class Vertice {

    //Atributos
    private final String nombre;

    public Vertice(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertice vertice = (Vertice) o;
        return Objects.equals(nombre, vertice.nombre);
    }
}
