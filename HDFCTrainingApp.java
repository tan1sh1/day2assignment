import java.util.*;

class Employee {
    int id;
    String name;
    String department;
    TrainingModule module;

    // Default constructor
    Employee() {
        this(0, "Unknown", "Unknown");
    }

    // Parameterized constructor
    Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    void showDetails() {
        System.out.println("Name: " + name + " | ID: " + id + " | Department: " + department);
    }

    // Overloaded showDetails
    void showDetails(String extra) {
        showDetails();
        System.out.println(extra);
    }

    // Overloaded calculateBonus
    int calculateBonus(int base) {
        return base / 10; // 10% of base
    }

    int calculateBonus(int base, int rating) {
        return (base / 10) * rating; // higher rating → higher bonus
    }
}

class TrainingModule {
    String title;
    int durationInHrs;

    TrainingModule(String title, int durationInHrs) {
        this.title = title;
        this.durationInHrs = durationInHrs;
    }

    void showModule() {
        System.out.println("Training Module: " + title + " | Duration: " + durationInHrs + " hrs");
    }
}

class EmployeeUtils {
    static boolean validateID(String id) {
        return id.matches("\\d{5}");
    }
}

class StringAnalyzer {
    void reverseSentence(String sentence) {
        StringBuilder sb = new StringBuilder(sentence);
        System.out.println("Original: " + sentence);
        System.out.println("Reversed: " + sb.reverse().toString());
    }

    void compareStrings(String s1, String s2) {
        System.out.println("String Comparison: " + s1 + " equals " + s2 + " → " + s1.equals(s2));
        System.out.println("String Comparison: " + s1 + " compareTo " + s1 + " → " + s1.compareTo(s1));
    }
}

public class HDFCTrainingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Employee details
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee ID: ");
        String empIdStr = sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        boolean valid = EmployeeUtils.validateID(empIdStr);
        int empId = valid ? Integer.parseInt(empIdStr) : 0;

        Employee emp = new Employee(empId, name, dept);
        emp.showDetails();
        System.out.println("Valid ID: " + valid);

        // Training Module
        TrainingModule tm = new TrainingModule("Java Basics", 10);
        emp.module = tm;
        tm.showModule();

        // Bonus calculation
        System.out.println("Bonus (base 5000): " + emp.calculateBonus(5000));
        System.out.println("Bonus (base 5000, rating 5): " + emp.calculateBonus(5000, 5));

        // String analysis
        StringAnalyzer sa = new StringAnalyzer();
        sa.reverseSentence("Welcome to HDFC Life");
        sa.compareStrings("HDFC", "hdfc");

        // 1D Array scores
        int[] scores = {78, 90, 67, 82, 85};
        int sum = 0, max = scores[0], min = scores[0];
        for (int s : scores) {
            sum += s;
            if (s > max) max = s;
            if (s < min) min = s;
        }
        double avg = (double) sum / scores.length;
        System.out.println("Scores: " + Arrays.toString(scores).replaceAll("[\\[\\],]", ""));
        System.out.println("Average: " + avg + " | Max: " + max + " | Min: " + min);

        // 2D Array multiplication table
        System.out.println("Multiplication Table:");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }

        // Command line args sum
        int argsSum = 0;
        for (String arg : args) {
            argsSum += Integer.parseInt(arg);
        }
        System.out.println("Sum from args: " + argsSum);
    }
}
