package Classroom.Topic01.Ex1;
import java.lang.Math;

public class Main {

    public float findSqrtRec(float value, float x_i, float precision) {
        float result = 0.0f;
        result = (x_i + (value / x_i)) / 2.0f;
        float difference = Math.abs(result - x_i);

        if (difference <= precision) {
            return result;
        }
        return findSqrtRec(value, result, precision);
    }

    public float firstGuess(float value) throws Exception {
        if (value < 0) {
            throw new Exception("Value must be positive!");
        }
        float guess = 0.0f;
        guess = (value + 1 / value) / 2.0f;

        return guess;
    }

    public static void main(String[] args) {
        Main myMain = new Main();
        try {
            float value = 100.0f;
            float precision = 0.0001f;
            float guess = myMain.firstGuess(value);
            System.out.println(guess);
            float result = myMain.findSqrtRec(value, guess, precision);

            System.out.println(result);
        } catch(Exception err) {
            System.out.println(err);
        }
    }
}
