package Classroom.Topic01.Ex3;
import Classroom.Topic01.Utils.EntradaTeclado;

public class Main {
    
    public String buildTreeColumn(int colLength) {
        String result = "";
        for (int i = 0; i < colLength; i++) {
            result += "*";
        }
        return result;
    }
    
    public static void main(String[] args) {
        try {
            System.out.print("no. lines ");
            int lines = EntradaTeclado.leInt();
            Main myMain = new Main();
            for (int i = lines; i > 0; i--) {
                String result = myMain.buildTreeColumn(i);
                System.out.println(result);
            }
        } catch(Exception err) {
            System.out.println(err);
        }
    }
}
