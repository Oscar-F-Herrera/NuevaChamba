package evidencia2.utils.collections;

public class Arista {

    //Atributos
    private final Vertice v1;
    private final Vertice v2;
    private final double peso;

    //Métodos
    public Arista(Vertice v1, Vertice v2, double peso) {
        this.v1 = v1;
        this.v2 = v2;
        this.peso = peso;
    }

    public Vertice getV1() {
        return v1;
    }

    public Vertice getV2() {
        return v2;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "Arista de " + v1.getNombre() + " y " + v2.getNombre() + " con un peso de " + peso;
    }

}
