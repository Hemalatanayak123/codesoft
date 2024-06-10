package hemalata;

import java.util.Scanner;

public class StudentGradeSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input of how many subjects are there
        System.out.println("Enter the amount of subjects:");
        int totalSubjects = sc.nextInt();

        int totalMarks = 0;

        // Taking and adding all the marks
        for (int i = 1; i <= totalSubjects; i++) {
            System.out.println("Enter the marks obtained in subject " + i + ":");
            int marks = sc.nextInt();
            totalMarks += marks;
        }

        // Calculating Percentage
        double averagePercentage = (double) totalMarks / totalSubjects;

        // Calculating Grades
        String grade = calculateGrade(averagePercentage);

        // Displaying all the Data
        System.out.println("Total marks obtained: " + totalMarks);
        System.out.printf("Percentage obtained: %.2f%%\n", averagePercentage);
        System.out.println("Grade obtained: " + grade);

        sc.close();
    }

    public static String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B+";
        } else if (percentage >= 60) {
            return "B";
        } else if (percentage >= 50) {
            return "C";
        } else if (percentage >= 40) {
            return "D";
        } else {
            return "F";
        }
    }
}
