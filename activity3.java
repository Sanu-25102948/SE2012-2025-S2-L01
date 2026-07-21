import java.util.Scanner;

public class activity3 {

    public static String getGrade(double score) {
        if (score >= 90) {
            return "Grade A";
        } else if (score >= 80) {
            return "Grade B";
        } else if (score >= 70) {
            return "Grade C";
        } else if (score >= 60) {
            return "Grade D";
        } else {
            return "Fail";
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        double[][] marks = new double[n][3];

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Student Marks");
            System.out.println("2. Update Student Mark");
            System.out.println("3. Average of a Subject");
            System.out.println("4. Average of a Student");
            System.out.println("5. Total Marks of a Student");
            System.out.println("6. Display Grades Summary");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID (1-" + n + "): ");
                    int studentID = input.nextInt();

                    if (studentID >= 1 && studentID <= n) {
                        System.out.println("Enter marks for 3 subjects:");
                        System.out.print("Mathematics : ");
                        marks[studentID - 1][0] = input.nextDouble();

                        System.out.print("Chemistry : ");
                        marks[studentID - 1][1] = input.nextDouble();

                        System.out.print("Physics : ");
                        marks[studentID - 1][2] = input.nextDouble();
                    } else {
                        System.out.println("Invalid Student ID.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    studentID = input.nextInt();

                    System.out.print("Enter Subject ID (1-Maths, 2-Chemistry, 3-Physics): ");
                    int subjectID = input.nextInt();

                    if (studentID >= 1 && studentID <= n &&
                            subjectID >= 1 && subjectID <= 3) {

                        System.out.print("Enter New Mark: ");
                        double newMark = input.nextDouble();

                        marks[studentID - 1][subjectID - 1] = newMark;

                        System.out.println("Mark Updated Successfully.");
                    } else {
                        System.out.println("Invalid IDs.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Subject ID (1-3): ");
                    subjectID = input.nextInt();

                    if (subjectID >= 1 && subjectID <= 3) {

                        double total = 0;

                        for (int i = 0; i < n; i++) {
                            total += marks[i][subjectID - 1];
                        }

                        double average = total / n;
                        System.out.println("Average Mark = " + average);

                    } else {
                        System.out.println("Invalid Subject ID.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    studentID = input.nextInt();

                    if (studentID >= 1 && studentID <= n) {

                        double total = 0;

                        for (int i = 0; i < 3; i++) {
                            total += marks[studentID - 1][i];
                        }

                        double average = total / 3;
                        System.out.println("Average Mark = " + average);

                    } else {
                        System.out.println("Invalid Student ID.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Student ID: ");
                    studentID = input.nextInt();

                    if (studentID >= 1 && studentID <= n) {

                        double total = 0;

                        for (int i = 0; i < 3; i++) {
                            total += marks[studentID - 1][i];
                        }

                        System.out.println("Total Marks = " + total);

                    } else {
                        System.out.println("Invalid Student ID.");
                    }
                    break;

                case 6:
                    System.out.println("\n-------------------------------------------------------------");
                    System.out.printf("%-12s | %-12s | %-12s | %-12s\n", "Student ID", "Mathematics", "Chemistry", "Physics");
                    System.out.println("-------------------------------------------------------------");

                    for (int i = 0; i < n; i++) {
                        String mathGrade = getGrade(marks[i][0]);
                        String chemGrade = getGrade(marks[i][1]);
                        String physGrade = getGrade(marks[i][2]);

                        System.out.printf("%-12d | %-12s | %-12s | %-12s\n", (i + 1), mathGrade, chemGrade, physGrade);
                    }
                    System.out.println("-------------------------------------------------------------");
                    break;

                case 7:
                    System.out.println("Program Terminated.");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}
