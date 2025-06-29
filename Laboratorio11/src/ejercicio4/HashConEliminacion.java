package ejercicio4;

public class HashConEliminacion {
    private Object[] table;
    private int size;
    private final Object ELIMINADO = new Object(); // Marca especial

    public HashConEliminacion(int size) {
        this.size = size;
        table = new Object[size];
    }

    private int hash(int key) {
        return key % size;
    }

    public void insert(int key) {
        int index = hash(key);
        int start = index;

        while (table[index] != null && table[index] != ELIMINADO) {
            index = (index + 1) % size;
            if (index == start) {
                System.out.println("Tabla llena.");
                return;
            }
        }

        table[index] = key;
        System.out.println("Insertado " + key + " en índice " + index);
    }

    public void delete(int key) {
        int index = hash(key);
        int start = index;

        while (table[index] != null) {
            if (table[index] instanceof Integer && (Integer) table[index] == key) {
                table[index] = ELIMINADO;
                System.out.println("Clave " + key + " eliminada (lógica) en índice " + index);
                return;
            }
            index = (index + 1) % size;
            if (index == start) break;
        }

        System.out.println("Clave " + key + " no encontrada.");
    }

    public boolean search(int key) {
        int index = hash(key);
        int start = index;

        while (table[index] != null) {
            if (table[index] instanceof Integer && (Integer) table[index] == key) {
                return true;
            }
            index = (index + 1) % size;
            if (index == start) break;
        }

        return false;
    }

    public void printTable() {
        System.out.println("\nTabla Hash:");
        for (int i = 0; i < size; i++) {
            if (table[i] == null)
                System.out.println(i + " → vacío");
            else if (table[i] == ELIMINADO)
                System.out.println(i + " → [ELIMINADO]");
            else
                System.out.println(i + " → " + table[i]);
        }
    }
}
