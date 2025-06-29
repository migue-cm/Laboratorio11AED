package hashO;

import hash.*;


public class MainHashO {
    public static void main(String[] args) {
        HashO hashTable = new HashO(5); // Tamaño pequeño para forzar colisiones

        // Insertar registros (algunos con la misma clave hash)
        hashTable.insert(new Register(1, "Ana"));
        hashTable.insert(new Register(6, "Luis")); // 1 y 6 → indice 1 (colision)
        hashTable.insert(new Register(11, "Maria")); // otra colisión en indice 1
        hashTable.insert(new Register(3, "Carlos"));
        hashTable.insert(new Register(8, "Sofia")); // 3 y 8 → índice 3 (colision)

        // Mostrar la tabla
        hashTable.printTable();

        // Buscar registros
        System.out.println("\nBuscando clave 6: " + hashTable.search(6));
        System.out.println("Buscando clave 99: " + hashTable.search(99));

        // Eliminar registros
        hashTable.delete(6);
        hashTable.delete(99); // No existe

        // Mostrar tabla final
        hashTable.printTable();
    }
}

