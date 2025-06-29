package ejercicio4;

public class MainE4 {
	public static void main(String[] args) {
        HashConEliminacion hash = new HashConEliminacion(7);

        hash.insert(5);   // 5 % 7 = 5
        hash.insert(12);  // 12 % 7 = 5 → colision → va a 6
        hash.insert(19);  // 19 % 7 = 5 → colision → 6 ocupada → va a 0

        hash.printTable();

        System.out.println("\nEliminando 12...");
        hash.delete(12);

        hash.printTable();

        System.out.println("\n¿Existe 19?: " + hash.search(19)); // debe seguir funcionando
    }
}
