package Classroom.Topic01.Ex3;

public class Main {
    
    public String buildTreeColumn(int colLength) {
        String result = "";
        for (int i = 0; i < colLength; i++) {
            result += "*";
        }
        return result;
    }
    
    public static void main(String[] args) {
        int lines = 2;
        Main myMain = new Main();
        for (int i = lines; i > 0; i--) {
            String result = myMain.buildTreeColumn(i);
            System.out.println(result);
        }
    }
}
