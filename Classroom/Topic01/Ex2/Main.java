package Classroom.Topic01.Ex2;
import java.lang.Math;
import Classroom.Topic01.Utils.EntradaTeclado;

public class Main {
    
    public double[] solveSqrEquation(double a, double b, double c) throws Exception{
        double delta = b*b - 4*a*c;
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
            System.out.println("ax^2 + bx + c = 0");
            System.out.print("a ");
            double a = EntradaTeclado.leDouble();
            System.out.print("b ");
            double b = EntradaTeclado.leDouble();
            System.out.print("c ");
            double c = EntradaTeclado.leDouble();

            System.out.format("%.2fx^2 + %.2fx + %.2f = 0%n", a, b, c);

            double[] results = myMain.solveSqrEquation(a,b,c);
            for (int i = 0; i < results.length; i++) {
                System.out.println(results[i]);
            }
        } catch(Exception err) {
            System.out.println(err);
        }
    }
}
