package ejercicio3;

import java.util.LinkedList;
import hash.*;

public class HashAbierto {
    private LinkedList<Register>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashAbierto(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % size;
    }

    public void insert(int key, String name) {
        int index = hash(key);
        table[index].add(new Register(key, name));
        System.out.println("Insertado: (" + key + ", " + name + ") en índice " + index);
    }

    public String search(int key) {
        int index = hash(key);
        for (Register reg : table[index]) {
            if (reg.getkey() == key) {
                return reg.getName();
            }
        }
        return null;
    }

    public void printTable() {
        System.out.println("\nContenido de la tabla hash:");
        for (int i = 0; i < size; i++) {
            System.out.print(i + " → ");
            for (Register reg : table[i]) {
                System.out.print(reg + " → ");
            }
            System.out.println("null");
        }
    }
}

