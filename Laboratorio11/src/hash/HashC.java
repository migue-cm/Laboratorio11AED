package hash;

public class HashC {

    private static class Element {
        Register register;
        boolean isAvailable;

        public Element() {
            this.register = null;
            this.isAvailable = true;
        }
    }

    private Element[] table;
    private int size;

    public HashC(int size) {
        this.size = size;
        table = new Element[size];
        for (int i = 0; i < size; i++) {
            table[i] = new Element();
        }
    }

    private int hash(int key) {
        return key % size;
    }

    public void insert(Register reg) {
        int key = reg.getkey();
        int index = hash(key);
        int originalIndex = index;

        do {
            if (table[index].register == null || table[index].isAvailable) {
                table[index].register = reg;
                table[index].isAvailable = false;
                return;
            }

            // Si la clave ya existe, actualiza
            if (!table[index].isAvailable && table[index].register.getkey() == key) {
                table[index].register = reg;
                return;
            }

            index = (index + 1) % size;
        } while (index != originalIndex);

        System.out.println("La tabla está llena. No se pudo insertar la clave " + key);
    }
    
    
    //colisones
    public Register search(int key) {
        int index = hash(key);
        int originalIndex = index;

        do {
            if (table[index].register != null && !table[index].isAvailable && table[index].register.getkey() == key) {
                return table[index].register;
            }

            if (table[index].register == null && table[index].isAvailable) {
                return null; // celda vacía y nunca usada: clave no existe
            }

            index = (index + 1) % size;
        } while (index != originalIndex);

        return null; // no se encontró
    }

    public void delete(int key) {
        int index = hash(key);
        int originalIndex = index;

        do {
            if (table[index].register != null && !table[index].isAvailable && table[index].register.getkey() == key) {
                table[index].register = null;
                table[index].isAvailable = true; // Eliminación lógica
                return;
            }

            if (table[index].register == null && table[index].isAvailable) {
                return; // clave no está
            }

            index = (index + 1) % size;
        } while (index != originalIndex);
    }

    public void printTable() {
        System.out.println("Tabla Hash:");
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");
            if (table[i].register != null && !table[i].isAvailable) {
                System.out.println(table[i].register);
            } else {
                System.out.println("Vacío");
            }
        }
        System.out.println();
    }
}
