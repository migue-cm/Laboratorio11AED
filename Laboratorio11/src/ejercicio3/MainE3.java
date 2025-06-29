package ejercicio3;

public class MainE3 {
	    public static void main(String[] args) {
	        HashAbierto hash = new HashAbierto(5);

	        // Insertar valores
	        hash.insert(10, "Juan");
	        hash.insert(15, "Ana");
	        hash.insert(20, "Luis");
	        hash.insert(25, "Rosa");

	        // Mostrar tabla
	        hash.printTable();

	        // Buscar clave 20
	        String result1 = hash.search(20);
	        System.out.println("\nBuscar clave 20 → Resultado: " + (result1 != null ? result1 : "No encontrado"));

	        // Buscar clave 30
	        String result2 = hash.search(30);
	        System.out.println("Buscar clave 30 → Resultado: " + (result2 != null ? result2 : "No encontrado"));
	    }
	}

