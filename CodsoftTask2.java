package hms;
import java.util.Scanner;
public class CodsoftTask2 {




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numSubjects;
        double totalMarks = 0;

        // Input: Number of subjects
        System.out.print("Enter the number of subjects: ");
        numSubjects = scanner.nextInt();

        // Input: Marks for each subject
        double[] marks = new double[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + ": ");
            marks[i] = scanner.nextDouble();
            totalMarks += marks[i];
        }

        // Calculate Total Marks
        System.out.println("Total Marks: " + totalMarks);

        // Calculate Average Percentage
        double averagePercentage = totalMarks / numSubjects;
        System.out.println("Average Percentage: " + averagePercentage + "%");

        // Calculate Grade
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.println("Grade: " + grade);
        
        scanner.close();
    }
}
