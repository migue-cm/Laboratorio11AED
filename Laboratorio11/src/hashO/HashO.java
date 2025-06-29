package hashO;

import hash.*;
import java.util.*;
import java.util.LinkedList;

public class HashO {
    private LinkedList<Register>[] table;
    private int size;

    // Constructor que inicializa el arreglo de listas
    @SuppressWarnings("unchecked")
    public HashO(int size) {
        this.size = size;
        this.table = new LinkedList[size];

        // Inicializar cada posición con una nueva lista enlazada vacía
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Función hash que determina la posición en la tabla
    private int hash(int key) {
        return key % size;
    }

    // Inserta un registro en la posición adecuada
    public void insert(Register reg) {
        int index = hash(reg.getkey());

        // Verificar si el registro ya existe (opcional)
        for (Register r : table[index]) {
            if (r.getkey() == reg.getkey()) {
                System.out.println("Clave duplicada: " + reg.getkey());
                return;
            }
        }

        table[index].add(reg);
        System.out.println("Insertado: " + reg + " en índice " + index);
    }

    // Buscar un registro por su clave
    public Register search(int key) {
        int index = hash(key);
        for (Register reg : table[index]) {
            if (reg.getkey() == key) {
                return reg;
            }
        }
        return null;
    }

    // Elimina un registro por su clave
    public void delete(int key) {
        int index = hash(key);
        Register toRemove = null;

        for (Register reg : table[index]) {
            if (reg.getkey() == key) {
                toRemove = reg;
                break;
            }
        }

        if (toRemove != null) {
            table[index].remove(toRemove);
            System.out.println("Eliminado: " + toRemove);
        } else {
            System.out.println("Clave no encontrada: " + key);
        }
    }

    // Muestra el contenido de la tabla hash
    public void printTable() {
        System.out.println("\nContenido de la tabla hash:");
        for (int i = 0; i < size; i++) {
            System.out.print(i + " → ");
            for (Register reg : table[i]) {
                System.out.print(reg + " -> ");
            }
            System.out.println("null");
        }
    }
}
