package Classroom.Topic01.Ex7;

import Classroom.Topic01.Utils.EntradaTeclado;

import java.util.ArrayList;

public class Main {
    static double chosenPolinome(double x, ArrayList<Float> coeffs) {
        double result = 0.0f;
        try {
            return (
                coeffs.get(0)*(Math.pow(x, 3)) + 
                coeffs.get(1)*(Math.pow(x, 2)) + 
                coeffs.get(2)*(Math.pow(x, 1)) + 
                coeffs.get(3)*(Math.pow(x, 0))
            );
        } catch(Exception err) {
            System.out.println(err);
        }
        return result;
    }

    static ArrayList<Double> readInterval() {
        ArrayList<Double> inputArray = new ArrayList<Double>();
        try {
            System.out.println("Interval for convergence: [a,b]");
            System.out.print("a: ");
            double a = EntradaTeclado.leDouble();

            System.out.print("b: ");
            double b = EntradaTeclado.leDouble();
            inputArray.add(a);
            inputArray.add(b);
        } catch(Exception err) {
            System.out.println(err);
        }
        return inputArray;
    }

    static double findRootBissectionMethod(ArrayList<Double> interval, double precision, int i) {
        double result = (interval.get(0) + interval.get(1)) / 2;
        int maxIteration = 20;
        try {
            ArrayList<Float> coeffsList = new ArrayList<Float>();
            coeffsList.add(0, 1.0f);
            coeffsList.add(1, 0.0f);
            coeffsList.add(2, -1.0f);
            coeffsList.add(3, -2.0f);
            double partialResult = chosenPolinome(result, coeffsList);
            if (partialResult < 0.0f) interval.set(0, result);
            if (partialResult > 0.0f) interval.set(1, result);
            if (partialResult == 0.0f) return result;
            if (partialResult -  i < maxIteration) {
                i++;
                System.out.println(result);
                result = findRootBissectionMethod(interval, precision, i);
            }
        } catch(Exception err) {
            System.out.println(err);
        }
        return result;

    }
    
    public static void main(String[] args) {
        ArrayList<Double> interval = readInterval();
        double result = findRootBissectionMethod(interval, 0.01, 0);
        System.out.println(result);
    }
}
