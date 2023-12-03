package evidencia3.mocte;

import java.io.Serializable;
public class Tree implements Serializable {
    //Atributos
    private final String INITIAL_Q = "¿Tiene cuernos?";
    private final String[] INITIAL_ANS = {"Perro", "Vaca"};

    private Node root;
    private Node current;
    private Node previous;

    //Constructor
    public Tree() {
        root = null;
        current = root;
        previous = null;
    }

    //Métodos
    public void initialize() {
        root = new Node(INITIAL_Q);
        current = root;
        this.root.izq = new Node(INITIAL_ANS[0]);
        this.root.der = new Node(INITIAL_ANS[1]);
    }

    public Node getCurrentNode(){
        return current;
    }

    public String getData(Node n){
        return n.data;
    }

    public void advanceCurrent(int n) {
        if (n == 1) {
            previous = current;
            current = this.current.der;
        } else {
            previous = current;
            current = this.current.izq;
        }
    }

    public void addNode(String question,String answer,int n){
        Node node = new Node(question);
        Node temp = current;

        current = node;
        current.izq = temp;
        current.der = new Node(answer);

        if(n == 1) {
            previous.der = current;
        }
        else {
            previous.izq = current;
        }

        reset();

        System.out.println("Nuevo nodo agregado");
    }

    public boolean hasLeaf(){
        return (current.izq==null && current.der==null);
    }

    public void reset(){
        current = root;
    }
}