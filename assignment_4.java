import java.util.Scanner;

public class assignment_4{

    // Method to display all marks
    static void displayMarks(String[] students, int[][] marks, String[] subjects) {

        System.out.println("\n===== All Student Marks =====");

        System.out.printf("%-12s", "Student");

        for (String subject : subjects) {
            System.out.printf("%-10s", subject);
        }

        System.out.println();

        for (int i = 0; i < marks.length; i++) {
            System.out.printf("%-12s", students[i]);

            for (int j = 0; j < marks[i].length; j++) {
                System.out.printf("%-10d", marks[i][j]);
            }

            System.out.println();
        }
    }

    // Method to calculate total marks of one student
    static int calculateTotal(int[] studentMarks) {

        int total = 0;

        for (int mark : studentMarks) {
            total += mark;
        }

        return total;
    }

    // Method to calculate total marks of all students
    static void calculateAllTotals(
            String[] students,
            int[][] marks,
            int[] totals) {

        System.out.println("\n===== Student Totals =====");

        for (int i = 0; i < marks.length; i++) {

            totals[i] = calculateTotal(marks[i]);

            System.out.println(
                students[i] + " Total : " + totals[i]
            );
        }
    }

    // Method to calculate average marks
    static double calculateAverage(int[] studentMarks) {

        int total = calculateTotal(studentMarks);

        return (double) total / studentMarks.length;
    }

    // Method to display averages of all students
    static void displayAverages(
            String[] students,
            int[][] marks) {

        System.out.println("\n===== Student Averages =====");

        for (int i = 0; i < marks.length; i++) {

            double average = calculateAverage(marks[i]);

            System.out.printf(
                "%s Average : %.2f%n",
                students[i],
                average
            );
        }
    }

    // Method to find the highest scorer
    static void findHighestScorer(
            String[] students,
            int[] totals) {

        int highestIndex = 0;

        for (int i = 1; i < totals.length; i++) {

            if (totals[i] > totals[highestIndex]) {
                highestIndex = i;
            }
        }

        System.out.println(
            "\nHighest Scorer: " + students[highestIndex]
        );
    }

    // Method to find subject-wise highest marks
    static void findSubjectHighest(
            int[][] marks,
            String[] subjects) {

        System.out.println("\n===== Subject-Wise Highest Marks =====");

        for (int j = 0; j < subjects.length; j++) {

            int highest = marks[0][j];

            for (int i = 1; i < marks.length; i++) {

                if (marks[i][j] > highest) {
                    highest = marks[i][j];
                }
            }

            System.out.println(
                "Highest " + subjects[j] + " Marks : " + highest
            );
        }
    }

    // Linear Search for a particular mark
    static void searchMarks(
            String[] students,
            int[][] marks,
            int target) {

        boolean found = false;

        System.out.println(
            "\n===== Linear Search Result ====="
        );

        for (int i = 0; i < marks.length; i++) {

            for (int j = 0; j < marks[i].length; j++) {

                if (marks[i][j] == target) {

                    System.out.println(
                        target + " found for " +
                        students[i] +
                        " in subject position " +
                        (j + 1)
                    );

                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println(
                "Mark " + target + " not found."
            );
        }
    }

    // Bubble Sort to rank students from highest to lowest
    static void sortStudentTotals(
            String[] students,
            int[] totals) {

        // Create copies so original data remains unchanged
        String[] sortedStudents = students.clone();
        int[] sortedTotals = totals.clone();

        for (int i = 0; i < sortedTotals.length - 1; i++) {

            for (int j = 0; j < sortedTotals.length - i - 1; j++) {

                if (sortedTotals[j] < sortedTotals[j + 1]) {

                    // Swap totals
                    int tempTotal = sortedTotals[j];
                    sortedTotals[j] = sortedTotals[j + 1];
                    sortedTotals[j + 1] = tempTotal;

                    // Swap student names
                    String tempStudent = sortedStudents[j];
                    sortedStudents[j] = sortedStudents[j + 1];
                    sortedStudents[j + 1] = tempStudent;
                }
            }
        }

        System.out.println("\n===== Student Ranking =====");

        for (int i = 0; i < sortedStudents.length; i++) {

            System.out.println(
                (i + 1) + ". " +
                sortedStudents[i] +
                " - " +
                sortedTotals[i]
            );
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Student names
        String[] students = {
            "Student 1",
            "Student 2",
            "Student 3",
            "Student 4",
            "Student 5"
        };

        // Subject names
        String[] subjects = {
            "Java",
            "Python",
            "DBMS"
        };

        // 2-D array storing marks
        int[][] marks = {
            {78, 82, 75},
            {90, 85, 88},
            {65, 72, 70},
            {88, 91, 85},
            {55, 60, 58}
        };

        // 1-D array to store total marks
        int[] totals = new int[marks.length];

        // Calculate totals initially
        for (int i = 0; i < marks.length; i++) {
            totals[i] = calculateTotal(marks[i]);
        }

        int choice;

        System.out.println(
            "===== Student Marks Management System ====="
        );

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Display All Marks");
            System.out.println("2. Calculate Student Total");
            System.out.println("3. Calculate Student Average");
            System.out.println("4. Find Highest Scorer");
            System.out.println("5. Search Marks");
            System.out.println("6. Sort Student Totals");
            System.out.println("7. Display Subject-Wise Highest Marks");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    displayMarks(students, marks, subjects);
                    break;

                case 2:
                    calculateAllTotals(students, marks, totals);
                    break;

                case 3:
                    displayAverages(students, marks);
                    break;

                case 4:
                    findHighestScorer(students, totals);
                    break;

                case 5:
                    System.out.print(
                        "Enter mark to search: "
                    );

                    int target = sc.nextInt();

                    searchMarks(
                        students,
                        marks,
                        target
                    );

                    break;

                case 6:
                    sortStudentTotals(students, totals);
                    break;

                case 7:
                    findSubjectHighest(marks, subjects);
                    break;

                case 8:
                    System.out.println(
                        "Exiting the program..."
                    );
                    break;

                default:
                    System.out.println(
                        "Invalid choice. Please try again."
                    );
            }

        } while (choice != 8);

        sc.close();
    }
}

