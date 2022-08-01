package application;

import entities.Contribuidor;
import entities.Fisica;
import entities.Juridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Contribuidor> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();
        double totalTax = 0.0;

        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company? (i/c): ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Annual Income: ");
            double annualIncome = sc.nextDouble();

            if (ch == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenses = sc.nextDouble();

                list.add(new Fisica(name, annualIncome, healthExpenses));
            } else if (ch == 'c') {
                System.out.print("Number of employees: ");
                int workerQuant = sc.nextInt();

                list.add(new Juridica(name, annualIncome, workerQuant));
            }
        }
        System.out.println();
        System.out.println("TAXES PAID:");

        for (Contribuidor cont :
                list) {
            System.out.println(cont.getName() + ": $ " + String.format("%.2f", cont.taxCalc()));
        }

        System.out.println();
        System.out.print("TOTAL TAXES: $ ");

        for (Contribuidor cont :
                list) {
            totalTax += cont.taxCalc();
        }

        System.out.print(totalTax);

        sc.close();

    }
}
