package patientapp;

import java.text.DecimalFormat;

/*
 * Procedure.java
 *
 * Description: Represents a medical procedure with a name, date,
 * practitioner name, and charge amount. Provides constructors, accessors,
 * mutators, and utility methods used by PatientDriverApp.
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
public class Procedure {
    private String procedureName;
    private String date;
    private String practitionerName;
    private double charges;

    // Constructs a Procedure with all fields set to empty/default values.
    public Procedure() {
        procedureName = "";
        date = "";
        practitionerName = "";
        charges = 0.0;
    }

    // Constructs a Procedure with only the name and date set;
    // practitioner name and charges default to empty/zero.
    public Procedure(String procedureName, String date) {
        this.procedureName = procedureName;
        this.date = date;
        this.practitionerName = "";
        this.charges = 0.0;
    }

    // Constructs a Procedure with every field initialized to the given values.
    public Procedure(String procedureName, String date, String practitionerName, double charges) {
        this.procedureName = procedureName;
        this.date = date;
        this.practitionerName = practitionerName;
        this.charges = charges;
    }

    // Returns the procedure's name.
    public String getProcedureName() {
        return procedureName;
    }

    // Sets the procedure's name.
    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    // Returns the procedure's date.
    public String getDate() {
        return date;
    }

    // Sets the procedure's date.
    public void setDate(String date) {
        this.date = date;
    }

    // Returns the practitioner's name.
    public String getPractitionerName() {
        return practitionerName;
    }

    // Sets the practitioner's name.
    public void setPractitionerName(String practitionerName) {
        this.practitionerName = practitionerName;
    }

    // Returns the procedure's charge amount.
    public double getCharges() {
        return charges;
    }

    // Sets the procedure's charge amount.
    public void setCharges(double charges) {
        this.charges = charges;
    }

    // Returns a formatted string of all procedure information.
    public String toString() {
        return "Procedure: " + procedureName + "\n" +
               "Date: " + date + "\n" +
               "Practitioner: " + practitionerName + "\n" +
               "Charges: " + getFormattedCharge();
    }

    // Returns true if the procedure's charge is $1000.00 or more.
    public boolean isExpensiveProcedure() {
        return charges >= 1000.00;
    }

    // Applies a discount (0-100 percent) to the procedure's charge.
    // Invalid percentages (outside 0-100) are ignored.
    public void applyDiscount(double percent) {
        if (percent >= 0 && percent <= 100) {
            charges = charges - (charges * percent / 100);
        }
    }

    // Returns "Low" (< $500), "Medium" (< $1000), or "High" (>= $1000)
    // based on the procedure's charge amount.
    public String getChargeCategory() {
        if (charges < 500.00) {
            return "Low";
        } else if (charges < 1000.00) {
            return "Medium";
        } else {
            return "High";
        }
    }

    // Returns true if the given practitioner name matches this procedure's practitioner.
    public boolean isPerformedBy(String practitionerName) {
        return this.practitionerName.equalsIgnoreCase(practitionerName);
    }

    // Returns the charge formatted with a dollar sign, commas, and two decimals.
    public String getFormattedCharge() {
        DecimalFormat formatter = new DecimalFormat("$#,##0.00");
        return formatter.format(charges);
    }
}