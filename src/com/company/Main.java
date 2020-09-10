package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

//import static jdk.nashorn.internal.runtime.JSType.isNumber;


public class Main {

    public static void main(String[] args) {
        double principal=0.0, interestRate=0.0, term=0.0;
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean do1=false, do2=false, do3=false;
        System.out.print("enter the principal (positive real): ");
        do {
            input = scanner.nextLine();
            input.trim();
            if ((input.isEmpty()) || (!isNumber(input)) || (isNumber(input) && (Double.parseDouble(input) <= 0))) {
                System.out.print("re-enter the principal (positive real): ");
            } else {
                do1 = true;
                principal = Double.parseDouble(input);
                break;
            }
        } while (!do1);

        System.out.print("enter the interest rate (positive real): ");
        do {
            input = scanner.nextLine();
            input.trim();
            if ((input.isEmpty()) || (!isNumber(input)) || (isNumber(input) && (Double.parseDouble(input) <= 0))) {
                System.out.print("re-enter the interest rate (positive real): ");
            } else {
                do2 = true;
                interestRate = Double.parseDouble(input)/100;
                break;
            }
        } while (!do2);

        System.out.print("enter the repayment term in year(s): ");
        do {
            input = scanner.nextLine();
            input.trim();
            if ((input.isEmpty()) || (!isNumber(input)) || (isNumber(input) && (Double.parseDouble(input) <= 0))) {
                System.out.print("re-enter the repayment term in year(s): ");
            } else {
                do3 = true;
                term = Double.parseDouble(input);
                break;
            }
        } while (!do3);

        System.out.print("The mortgage per month is: ");
        System.out.println(calculateMortgage(principal, interestRate, term));
    }

    static double calculateMortgage(double p, double r, double t) {
        int monthsToRepay = (int)(t * 12);
        double yields = Math.pow(1 + r, monthsToRepay);
        return (p * r * yields / (yields - 1));
    }

    static boolean isNumber(String s) {
        if (s != null && s.equals("")==false) {
            s.trim();
            for (int i=0; i<s.length(); i++) {
                if (Character.isDigit(s.charAt(i)) == false) return false;
            }
        }
        return true;
    }
}
