package ejercicio2;

public class MainE2 {
	 // Main para probar
    public static void main(String[] args) {
        HashSondeoLineal hash = new HashSondeoLineal(6);

        int[] valores = {12, 18, 24, 30};
        for (int val : valores) {
            hash.insert(val);
        }

        hash.printTable();
    }
}
