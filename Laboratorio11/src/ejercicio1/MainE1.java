package ejercicio1;

public class MainE1 {
    public static void main(String[] args) {
        HashSinColision hash = new HashSinColision(7);

        int[] valores = {3, 10, 17, 24}; // Todos caen en diferentes índices
        for (int val : valores) {
            hash.insert(val);
        }

        hash.printTable();
    }
}
