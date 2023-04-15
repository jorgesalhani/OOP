import Classroom.Topic01.Utils.EntradaTeclado;
import java.util.ArrayList;

public class Main {

    public ArrayList<Double> readWhileNotZero() {
        ArrayList<Double> listInput = new ArrayList<Double>();
        double maxim = 0.0f;
        double minim = 0.0f;
        try {
            System.out.println("Number: [0 to end] ");
            double input = EntradaTeclado.leDouble();
            maxim = input;
            minim = input;
            while (input != 0.0f) {
                listInput.add(input);
                input = EntradaTeclado.leDouble();
                if (input >= maxim) maxim = input;
                if (input < minim) minim = input;
            }
        } catch (Exception err) {
            System.out.println(err);
        }

        System.out.printf("Max: %.2f%n", maxim);
        System.out.printf("Min: %.2f%n", minim);
        return listInput;
    }

    public void printInputList(ArrayList<Double> inputList) {
        System.out.print("{");
        for (int i = 0; i < inputList.size(); i++) {
            System.out.print(inputList.get(i));
            if (i < inputList.size()-1) System.out.print(", ");
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        Main myMain = new Main();
        ArrayList<Double> inputList = myMain.readWhileNotZero();
        myMain.printInputList(inputList);

    }
}
