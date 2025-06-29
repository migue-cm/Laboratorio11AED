package ejercicio2;

public class HashSondeoLineal {
    private Integer[] table;
    private int size;

    public HashSondeoLineal(int size) {
        this.size = size;
        table = new Integer[size];
    }

    // Función hash: x % size
    private int hash(int value) {
        return value % size;
    }

    // Inserción con sondeo lineal
    public void insert(int value) {
        int index = hash(value);
        int start = index;
        int steps = 0;

        while (table[index] != null) {
            System.out.println("Colisión en índice " + index + " al insertar " + value + ". Buscando siguiente...");
            index = (index + 1) % size;
            steps++;

            if (index == start) {
                System.out.println("Tabla llena. No se puede insertar " + value);
                return;
            }
        }

        table[index] = value;
        System.out.println("Insertado " + value + " en posición " + index + " (desplazado " + steps + " veces)");
    }

    // Mostrar la tabla
    public void printTable() {
        System.out.println("\nContenido final de la tabla hash:");
        for (int i = 0; i < size; i++) {
            System.out.println(i + " → " + table[i]);
        }
    }
}

