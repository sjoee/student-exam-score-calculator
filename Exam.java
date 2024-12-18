import java.util.Scanner;
import java.util.InputMismatchException;

class Exam {
    private int studentId;
    private String studentName;
    private String level;
    private int[] scores;

    public Exam(int studentId, String studentName, String level, int[] scores) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.level = level;
        this.scores = scores;
    }

    public int getTotalScores() {
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return total;
    }

    public double getAverageScores() {
        double average = 0;
        for (int score : scores) {
            average += score;
        }
        return average / scores.length;
    }

    public int getMaxScore() {
        int max = scores[0];
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }
        return max;
    }

    @Override
    public String toString() {
        return "Exam Information:\nStudent ID: " + studentId + "\nStudent Name: " + studentName + "\nLevel: " + level + "\nTotal Scores: " + getTotalScores() + "\nAverage Scores: " + getAverageScores() + "\nMaximum Score: " + getMaxScore();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();

        System.out.print("Enter student name: ");
        scanner.nextLine(); // Consume newline
        String studentName = scanner.nextLine();

        System.out.print("Enter level: ");
        String level = scanner.nextLine();

        System.out.print("Enter scores (separated by spaces): ");
        int[] scores = new int[6];
        for (int i = 0; i < 6; i++) {
            try {
                scores[i] = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid score. Scores must be integers between 0 and 100.");
                System.exit(1);
            }
            if (scores[i] < 0 || scores[i] > 100) {
                System.out.println("Invalid score. Scores must be integers between 0 and 100.");
                System.exit(1);
            }
        }

        Exam exam = new Exam(studentId, studentName, level, scores);
        System.out.println(exam);
    }
}
