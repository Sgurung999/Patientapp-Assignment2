package patientapp;

import java.util.Scanner;
import java.text.DecimalFormat;

/*
 * PatientDriverApp.java
 *
 * Description: Driver class that reads a patient's information from the
 * keyboard, creates Procedure objects using all three Procedure
 * constructors, and displays the patient, procedure table, and summary
 * information (totals, average, highest charge, expensive count).
 *
 * I pledge that I have completed this assignment without
 * collaborating with anyone else, in conformance with the Montgomery
 * College Honor Code.
 *
 * Course: CMSC-203-21305
 * Due Date: 09/21/2026
 * Platform/Compiler: Eclipse / Java (JDK 21)
 * Author: Samik Gurung
 */
public class PatientDriverApp {

    // Reads a patient's information, creates the three procedures, and
    // displays the patient, the procedure table, and the summary information.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Patient patient = inputPatient(input);
        displayPatient(patient);

        Procedure procedure1 = createProcedure1();
        Procedure procedure2 = createProcedure2();
        Procedure procedure3 = createProcedure3();

        displayProcedureTable(procedure1, procedure2, procedure3);
        displaySummary(procedure1, procedure2, procedure3);

        System.out.println("The program was developed by a Student: Samik Gurung 09/21/26");

        input.close();
    }

    // Prompts the user for all patient fields and returns a fully built Patient object.
    public static Patient inputPatient(Scanner input) {
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter middle name: ");
        String middleName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        System.out.print("Enter street address: ");
        String street = input.nextLine();

        System.out.print("Enter city: ");
        String city = input.nextLine();

        System.out.print("Enter state: ");
        String state = input.nextLine();

        System.out.print("Enter zip: ");
        String zip = input.nextLine();

        System.out.print("Enter phone number (###-###-####): ");
        String phoneNumber = input.nextLine();

        System.out.print("Enter emergency contact name: ");
        String emergencyContactName = input.nextLine();

        System.out.print("Enter emergency contact phone (###-###-####): ");
        String emergencyContactPhone = input.nextLine();

        return new Patient(firstName, middleName, lastName, street, city, state, zip,
                phoneNumber, emergencyContactName, emergencyContactPhone);
    }

    // Creates a sample Procedure using the constructor that sets all four attributes.
    public static Procedure createProcedure1() {
        return new Procedure("Physical Exam", "07/20/2026", "Dr. Irvine", 250.00);
    }

    // Creates a sample Procedure using the name-and-date constructor,
    // then sets the remaining attributes with setters.
    public static Procedure createProcedure2() {
        Procedure procedure = new Procedure("X-ray", "07/20/2026");
        procedure.setPractitionerName("Dr. Jamison");
        procedure.setCharges(550.43);
        return procedure;
    }

    // Creates a sample Procedure using the no-arg constructor,
    // then sets all attributes with setters.
    public static Procedure createProcedure3() {
        Procedure procedure = new Procedure();
        procedure.setProcedureName("Blood Test");
        procedure.setDate("07/20/2026");
        procedure.setPractitionerName("Dr. Smith");
        procedure.setCharges(1400.75);
        return procedure;
    }

    // Displays the patient's information along with phone validity results.
    public static void displayPatient(Patient patient) {
        System.out.println();
        System.out.println("Patient Information");
        System.out.println("-------------------");
        System.out.println(patient.toString());
        System.out.println("Phone Valid: " + patient.isValidPhoneNumber());
        System.out.println("Emergency Phone Valid: " + patient.isValidEmergencyPhoneNumber());
        System.out.println();
    }

    // Displays a single procedure's information using its toString method.
    public static void displayProcedure(Procedure procedure) {
        System.out.println(procedure.toString());
    }

    // Displays all three procedures in an aligned, tabular format with a header row.
    public static void displayProcedureTable(Procedure p1, Procedure p2, Procedure p3) {
        System.out.printf("%-20s%-13s%-20s%-16s%s%n", "Procedure", "Date", "Practitioner", "Charge", "Category");
        System.out.println("------------------------------------------------------------------------");
        printProcedureRow(p1);
        printProcedureRow(p2);
        printProcedureRow(p3);
        System.out.println();
    }

    // Prints one aligned row of the procedure table for the given procedure.
    private static void printProcedureRow(Procedure p) {
        System.out.printf("%-20s%-13s%-20s%-16s%s%n",
                p.getProcedureName(), p.getDate(), p.getPractitionerName(),
                p.getFormattedCharge(), p.getChargeCategory());
    }

    // Returns the sum of the charges of all three procedures.
    public static double calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3) {
        return p1.getCharges() + p2.getCharges() + p3.getCharges();
    }

    // Returns the average charge across all three procedures.
    public static double calculateAverageCharge(Procedure p1, Procedure p2, Procedure p3) {
        return calculateTotalCharges(p1, p2, p3) / 3;
    }

    // Returns the procedure with the highest charge among the three given procedures.
    public static Procedure findHighestChargeProcedure(Procedure p1, Procedure p2, Procedure p3) {
        Procedure highest = p1;
        if (p2.getCharges() > highest.getCharges()) {
            highest = p2;
        }
        if (p3.getCharges() > highest.getCharges()) {
            highest = p3;
        }
        return highest;
    }

    // Returns the count of how many of the three procedures are considered expensive.
    public static int countExpensiveProcedures(Procedure p1, Procedure p2, Procedure p3) {
        int count = 0;
        if (p1.isExpensiveProcedure()) {
            count++;
        }
        if (p2.isExpensiveProcedure()) {
            count++;
        }
        if (p3.isExpensiveProcedure()) {
            count++;
        }
        return count;
    }

    // Displays the total charges, average charge, highest-charge procedure,
    // and count of expensive procedures.
    public static void displaySummary(Procedure p1, Procedure p2, Procedure p3) {
        DecimalFormat formatter = new DecimalFormat("$#,##0.00");

        double total = calculateTotalCharges(p1, p2, p3);
        double average = calculateAverageCharge(p1, p2, p3);
        Procedure highest = findHighestChargeProcedure(p1, p2, p3);
        int expensiveCount = countExpensiveProcedures(p1, p2, p3);

        System.out.println("Total Charges: " + formatter.format(total));
        System.out.println("Average Charge: " + formatter.format(average));
        System.out.println("Highest Charge Procedure: " + highest.getProcedureName());
        System.out.println("Number of Expensive Procedures: " + expensiveCount);
        System.out.println();
    }
}