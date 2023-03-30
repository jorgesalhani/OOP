package Classroom.Topic01.Ex2;
import java.lang.Math;

public class Main {
    
    public double[] solveSqrEquation(float a, float b, float c) throws Exception{
        float delta = b*b - 4*a*c;
        if (delta < 0) {
            throw new Exception("No real solution found!");
        }

        if (a == 0.0f) {
            throw new Exception("Equation is non quadratic (a = 0)");
        }

        double res1 = (-b + Math.sqrt(delta)) / (2.0f*a);
        double res2 = (-b - Math.sqrt(delta)) / (2.0f*a);
        double[] results = {res1, res2};
        return results;

    }
    public static void main(String[] args) {
        Main myMain = new Main();
        try {
            float a = -2.0f;
            float b = 2.0f;
            float c = 1.0f;

            double[] results = myMain.solveSqrEquation(a,b,c);
            for (int i = 0; i < results.length; i++) {
                System.out.println(results[i]);
            }
        } catch(Exception err) {
            System.out.println(err);
        }
    }
}
