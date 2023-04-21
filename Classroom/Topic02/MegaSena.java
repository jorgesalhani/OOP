package Classroom.Topic02;

public class MegaSena {
    public static void main(String[] args) {
        Random r = new Random(10);     // Solution 3: def a constructor
        Random r0 = new Random();        // New constructor with no param
        for (int i = 0; i < 6; i++) {
            int k = r.getIntRand(60) + 1;
            System.out.println(k);
            // r.xi = 10;                // Solution 1: inform seed
            r.setSeed(10);          // Solution 2: method set

            int k0 = r0.getIntRand(k) + 1;
            System.out.println(k0);
        }
    }
}
