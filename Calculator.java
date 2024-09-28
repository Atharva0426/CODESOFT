import java.util.Scanner;
public class Calculator {
  public static String Grade(double percentage) {
        if (percentage >= 90) {
            return "A";
        } else if (percentage >= 80) {
            return "B";
        } else if (percentage >= 70) {
            return "C";
        } else if (percentage >= 60) {
            return "D";
        } else if (percentage >=50) {
            return "Pass";
        }else{
            return "Better Luck Next Time";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
          int num;
     System.out.print("Enter the number of subjects: ");
        num = scanner.nextInt();
     int[] marks = new int[num];
    
      for (int i = 0; i < num; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();
        }
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
      
      double average = (double) totalMarks / num;
      String grade = Grade(averagePercentage);
       System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + average + "%");
        System.out.println("Grade: " + grade);
    }
}
