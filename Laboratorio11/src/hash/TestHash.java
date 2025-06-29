package hash;

public class TestHash {
    public static void main(String[] args) {
        HashC tabla = new HashC(11); // tamaño arbitrario, puede ajustarse

        // Insertar registros
        tabla.insert(new Register(34, "Ana"));
        tabla.insert(new Register(3, "Luis"));
        tabla.insert(new Register(7, "Sofía"));
        tabla.insert(new Register(30, "Mario"));
        tabla.insert(new Register(11, "Lucía"));
        tabla.insert(new Register(8, "Carlos"));
        tabla.insert(new Register(7, "Pedro")); // clave duplicada, actualiza
        tabla.insert(new Register(23, "Valeria"));
        tabla.insert(new Register(41, "Roberto"));
        tabla.insert(new Register(16, "Elena"));
        tabla.insert(new Register(34, "Raúl")); // clave duplicada, actualiza

        System.out.println("Tabla luego de insertar:");
        tabla.printTable();

        // Eliminar clave 30
        tabla.delete(30);
        System.out.println("Tabla luego de eliminar la clave 30:");
        tabla.printTable();

        // Buscar clave 23
        Register resultado = tabla.search(23);
        if (resultado != null) {
            System.out.println("Registro encontrado: " + resultado);
        } else {
            System.out.println("Clave 23 no encontrada.");
        }
    }
}