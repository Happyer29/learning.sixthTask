package ru.vsu.cs.yagodintsevNikitaAndreevich;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество членов последовательности:");
        int n = scanner.nextInt();
        System.out.println("Введите X:");
        double x = scanner.nextDouble();

        int res1 = 0, res2 = 0, res3 = 0;
        for(int i = 1; i < n; i++){
            res1 += getSequencesTerm(i, x);
            res2 += Math.abs(getSequencesTerm(i, x)) > Math.exp(1) ? getSequencesTerm(i, x) : 0;
            res3 += Math.abs(getSequencesTerm(i, x)) > Math.exp(1)/10 ? getSequencesTerm(i, x) : 0;
        }

        System.out.println("Результат №1: " + res1);
        System.out.println("Результат №2: " + res2);
        System.out.println("Результат №3: " + res3);
    }

    public static double getSequencesTerm(int n, /*double previousTerm,*/ double x){
        //тк x принадлежит от -бесконечности до +бесконечности следует, что значение x можно не учитывать
        double term = 0;
        if(n == 1){
            return 1;
        }
        else{
            return Math.pow(Math.log(2) * x, n-1) / calculateFactorial(n-1);
        }
    }

    static int calculateFactorial(int n){
        int result = 1;
        for (int i = 1; i <=n; i ++){
            result = result*i;
        }
        return result;
    }
}
