import java.util.InputMismatchException;
import java.util.Scanner;


public class Student_grade_calculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int totalMarks = 0;
        int totalSubjects;
        double avgPercentage;

        System.out.println("Enter Number Of Subjects");
        totalSubjects = sc.nextInt();

        int[] marks = new int[totalSubjects];
        for (int i = 0; i < marks.length; i++) {
            System.out.println(" Enter marks for sub :  " + (i + 1));

            try {
                marks[i] = sc.nextInt();
                if (marks[i] > 100) {
                    throw new IllegalArgumentException("Marks cannot be greater than 100");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter a valid integer.");
                // Consume the invalid input
                sc.next();
                // Decrement i so that the current subject can be re-entered
                i--;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                // Decrement i so that the current subject can be re-entered
                i--;
            }
            totalMarks += marks[i];
        }

        /*
        Divide the total marks by the total number of subjects to get the
        average percentage.
        */

        avgPercentage = (double)(totalMarks / totalSubjects);
        
        char grade;
        if (avgPercentage >= 90) {
            grade = 'A';
        } else if (avgPercentage >= 80) {
            grade = 'B';
        } else if (avgPercentage >= 70) {
            grade = 'C';
        } else if (avgPercentage >= 60) {
            grade = 'D';
        } else if (avgPercentage >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }
        
        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + avgPercentage);
        System.out.println("Grade: " + grade);

        sc.close();

    }
}
