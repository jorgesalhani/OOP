package Classroom.Topic01.Ex4;
import Classroom.Topic01.Utils.EntradaTeclado;

public class Main {

    public String buildTreeColumnRigth(int n) {
        String result = "";
        int blankLeft = 0;
        for (int i = n; i > 0; i--) {
            result += " ".repeat(blankLeft);
            result += "*".repeat(i);
            result += "\n";
            blankLeft++;
        }
        return result;        
    }
    public static void main(String[] args) {
        System.out.print("No. Lines: ");
        try {
            int n = EntradaTeclado.leInt();
            Main myMain = new Main();
            String result = myMain.buildTreeColumnRigth(n);
            System.out.println(result);

        } catch(Exception err) {
            System.out.println(err);
        }

    }
}
