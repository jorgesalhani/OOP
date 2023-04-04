package Classroom.Topic01.Ex1;
import java.lang.Math;
import Classroom.Topic01.Utils.EntradaTeclado;

public class Main {

    public double findSqrtRec(double value, double x_i, double precision) {
        double result = 0.0f;
        result = (x_i + (value / x_i)) / 2.0f;
        double difference = Math.abs(result - x_i);

        if (difference <= precision) {
            return result;
        }
        return findSqrtRec(value, result, precision);
    }

    public double firstGuess(double value) throws Exception {
        if (value < 0) {
            throw new Exception("Value must be positive!");
        }
        double guess = 0.0f;
        guess = (value + 1 / value) / 2.0f;

        return guess;
    }

    public static void main(String[] args) {
        Main myMain = new Main();
        try {
            System.out.print("sqrt ");
            double value = EntradaTeclado.leDouble();
            System.out.print("precision ");
            double precision = EntradaTeclado.leDouble();
            double guess = myMain.firstGuess(value);
            double result = myMain.findSqrtRec(value, guess, precision);

            System.out.println(result);
        } catch(Exception err) {
            System.out.println(err);
        }
    }
}
