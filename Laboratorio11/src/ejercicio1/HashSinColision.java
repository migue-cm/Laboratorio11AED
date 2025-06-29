package ejercicio1;

public class HashSinColision {
    private Integer[] table;
    private int size;

    public HashSinColision(int size) {
        this.size = size;
        table = new Integer[size];
    }

    // Función hash: x % 7
    private int hash(int value) {
        return value % size;
    }

    // Inserta valor si la posición está vacía
    public void insert(int value) {
        int index = hash(value);
        if (table[index] == null) {
            table[index] = value;
            System.out.println("Insertado " + value + " en posición " + index);
        } else {
            System.out.println("Colisión en índice " + index + " para valor " + value + ", no insertado.");
        }
    }

    // Mostrar tabla hash
    public void printTable() {
        System.out.println("\nContenido final de la tabla hash:");
        for (int i = 0; i < size; i++) {
            System.out.println(i + " → " + table[i]);
        }
    }
}

