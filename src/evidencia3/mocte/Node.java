package evidencia3.mocte;
import java.io.Serializable;

public class Node implements Serializable{
    String data;
    Node izq;
    Node der;

    public Node(String data) {
        this.data = data;
        izq = null;
        der = null;
    }
}