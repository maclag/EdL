package application;

import entities.LegalPerson;
import entities.NaturalPerson;
import entities.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main (String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Person> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        System.out.println();
        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c): ");
            int option = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Annual income: ");
            Double annualIncome = sc.nextDouble();
            if (option == 'i') {
                System.out.print("Health expenditures: ");
                Double healthExpenses = sc.nextDouble();
                list.add(new NaturalPerson(name, annualIncome, healthExpenses));
            }
            else if (option == 'c') {
                System.out.print("Number of employees: ");
                Integer employees = sc.nextInt();
                list.add(new LegalPerson(name, annualIncome, employees));
            }
            System.out.println();
        }

        System.out.println("TAXES PAID:");
        for (Person p : list) {
            System.out.println(p.getName() + ": $ " + String.format("%.2f", p.incomeTax()));
        }

        System.out.println();
        double sum = 0.0;
        for (Person p : list) {
            sum += p.incomeTax();
        }
        System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));

        sc.close();
    }
}
