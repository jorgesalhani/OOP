package Classroom.Topic01.Ex5;
import Classroom.Topic01.Utils.EntradaTeclado;;

public class Main {
    public boolean checkIsPrime(int n) {
        int i = 3;
        if (n == 1 || (n % (i-1) == 0 && n != 2)) return false;
        while (i <= Math.sqrt(n)) {
            if (n % i == 0) return false;
            i += 2;
        }
        return true;
    }

    public String getMessageIsPrime(boolean isPrime) {
        String message = (isPrime ? "Prime" : "Not Prime");
        return message;
    }

    public static void main(String[] args) {
        try {
            System.out.print("n is prime? n: ");
            int n = EntradaTeclado.leInt();
            Main myMain = new Main();
            boolean isPrime = myMain.checkIsPrime(n);
            System.out.println(myMain.getMessageIsPrime(isPrime));

        } catch(Exception err) {
            System.out.println(err);
        }

    }
}
