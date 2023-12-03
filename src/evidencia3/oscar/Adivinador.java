package evidencia3.oscar;

import evidencia3.oscar.og.Brain;
import evidencia3.oscar.og.ThoughtProcess;

import java.io.*;
import java.util.Scanner;
import java.util.stream.Stream;

public class Adivinador {
    //Atributos
    private static Arbol tree;
    private Stream stream;
    private Scanner scanner;

    public Adivinador(){
        stream = new Stream();
        scanner = new Scanner(System.in);

        if (stream.hasFile()) {
            stream.readFromSave();
            System.out.println(">: Brain Loaded From Save.");
        } else {
            tree = new Arbol();
            tree.initialize();
            System.out.println(">: New Brain Created.");
        }

        System.out.println();
    }

    private record Stream(String SAVE_FILE) {

        public Stream() {
            this("brain_save.txt");
            System.out.println(">: Stream Instantiated.");
        }

        public void readFromSave() {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_FILE))) {
                tree = (Arbol) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e);
            }
        }

        public void writeToSave() {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_FILE))) {
                oos.writeObject(tree);
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        public boolean hasFile() {
            return new File(SAVE_FILE).isFile();
        }
    }
}
