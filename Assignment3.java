package Main;


import java.util.Scanner;

class InvalidRegistrationException extends Exception {
    public InvalidRegistrationException(String message) {
        super(message);
    }
}

class ExamRegistration {
    private String studentId;
    private String studentName;
    private int age;
    private double examMark;
    private int numberOfSubjects;

    public void registerStudent(Scanner scanner)
            throws InvalidRegistrationException {

        System.out.print("Enter Student ID: ");
        studentId = scanner.nextLine();

        if (studentId.trim().isEmpty()) {
            throw new InvalidRegistrationException(
                    "Student ID cannot be empty."
            );
        }

        System.out.print("Enter Student Name: ");
        studentName = scanner.nextLine();

        System.out.print("Enter Age: ");
        age = Integer.parseInt(scanner.nextLine());

        if (age < 18) {
            throw new InvalidRegistrationException(
                    "Student must be at least 18 years old."
            );
        }

        System.out.print("Enter Exam Mark: ");
        examMark = Double.parseDouble(scanner.nextLine());

        if (examMark < 0 || examMark > 100) {
            throw new InvalidRegistrationException(
                    "Exam mark must be between 0 and 100."
            );
        }

        System.out.print("Enter Number of Subjects: ");
        numberOfSubjects = Integer.parseInt(scanner.nextLine());

        if (numberOfSubjects < 1 || numberOfSubjects > 5) {
            throw new InvalidRegistrationException(
                    "Maximum allowed subjects is 5."
            );
        }

        System.out.println("\nRegistration Successful!");
        System.out.println("Student: " + studentName);
        System.out.println("Registered Subjects: "
                + numberOfSubjects);
    }
}

public class Assignment3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExamRegistration registration = new ExamRegistration();

        System.out.println("===== EXAM REGISTRATION SYSTEM =====");
        System.out.println();

        try {
            registration.registerStudent(scanner);

        } catch (InvalidRegistrationException e) {
            System.out.println("\nRegistration Failed!");
            System.out.println("Error: " + e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println("\nRegistration Failed!");
            System.out.println(
                    "Error: Please enter a valid number."
            );

        } finally {
            System.out.println(
                    "\nRegistration attempt completed."
            );
            scanner.close();
        }
    }
}

