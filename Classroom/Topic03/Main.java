package Classroom.Topic03;

public class Main {

    public int myWordLength(String word) {
        return word.length();
    }

    public String[] myArray() {
        return new String[] {"A", "B", "C"};
    }

    public void myArrayContent(String[] stringArray) {
        for (int i = 0; i < stringArray.length; i++) {
            System.out.println(stringArray[i]);
        }
    }

    public int mySum(int a, int b) {
        return a+b;
    }

    public double mySum(double a, double b) {
        return a+b;
    }

    @Override
    public String toString() {
        return "MAIN";
    }

    public static void main(String[] args) {
        String myString = new String("BBB");
        Main myMain = new Main();
        System.out.println(myMain.myWordLength(myString));
        String[] myNewArray = myMain.myArray();
        myMain.myArrayContent(myNewArray);

        // Special Methods
        System.out.println("My main: " + myMain.toString());
        // My main: Classroom.Topic03.Main@1dbd16a6
        // But we can redefine...
        System.out.println("My main: " + myMain);
        // Now, do not need .toString()

        System.out.println(myMain.mySum(0, 1));
        System.out.println(myMain.mySum(1.2, 1.4));
    }
}
