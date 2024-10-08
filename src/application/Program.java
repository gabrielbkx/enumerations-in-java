package application;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

        System.out.print("Enter departaments name: ");
        String departamentName = sc.nextLine();

        System.out.print("Enter worker data: ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();

        System.out.print("Level: ");
        String workerLevel = sc.nextLine();

        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel),
                baseSalary, new Departament(departamentName));

        System.out.print("How many contracts to this worker?: ");
        int n = sc.nextInt();

        for (int i = 0; i <= n; i++){
            System.out.println("Enter contract #" + 1 + " data");
            System.out.print("Date (DD/MM/YYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.println("Valoe per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.println("Duration (hours): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate,valuePerHour,hours);
            worker.addContract(contract);
        }
        System.out.println();
        System.out.print("Enter mounth and year to calculate income (MM/YYYY): ");
        String mounthAndYear = sc.next();
        int month = Integer.parseInt(mounthAndYear.substring(0,2));
        int year = Integer.parseInt(mounthAndYear.substring(3));
        System.out.println("name: " + worker.getName());
        System.out.println("Departament : " + worker.getDepartament().getName());
        System.out.println("Income for " + mounthAndYear + ": " + String.format("%.2f",worker.income(year,month)));
        sc.close();
    }
}
