package patientapp;

/*
 * Patient.java
 *
 * Description: Represents a patient with personal, address, phone, and
 * emergency contact information. Provides constructors, accessors,
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
public class Patient {
    private String firstName;
    private String middleName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String emergencyContactName;
    private String emergencyContactPhone;

    // Constructs a Patient with all fields set to empty strings.
    public Patient() {
        firstName = "";
        middleName = "";
        lastName = "";
        street = "";
        city = "";
        state = "";
        zip = "";
        phoneNumber = "";
        emergencyContactName = "";
        emergencyContactPhone = "";
    }

    // Constructs a Patient with only the first, middle, and last name set;
    // all other fields default to empty strings.
    public Patient(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.street = "";
        this.city = "";
        this.state = "";
        this.zip = "";
        this.phoneNumber = "";
        this.emergencyContactName = "";
        this.emergencyContactPhone = "";
    }

    // Constructs a Patient with every field initialized to the given values.
    public Patient(String firstName, String middleName, String lastName,
                   String street, String city, String state, String zip,
                   String phoneNumber, String emergencyContactName, String emergencyContactPhone) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhone = emergencyContactPhone;
    }

    // Returns the patient's first name.
    public String getFirstName() {
        return firstName;
    }

    // Sets the patient's first name.
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Returns the patient's middle name.
    public String getMiddleName() {
        return middleName;
    }

    // Sets the patient's middle name.
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    // Returns the patient's last name.
    public String getLastName() {
        return lastName;
    }

    // Sets the patient's last name.
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Returns the patient's street address.
    public String getStreet() {
        return street;
    }

    // Sets the patient's street address.
    public void setStreet(String street) {
        this.street = street;
    }

    // Returns the patient's city.
    public String getCity() {
        return city;
    }

    // Sets the patient's city.
    public void setCity(String city) {
        this.city = city;
    }

    // Returns the patient's state.
    public String getState() {
        return state;
    }

    // Sets the patient's state.
    public void setState(String state) {
        this.state = state;
    }

    // Returns the patient's zip code.
    public String getZip() {
        return zip;
    }

    // Sets the patient's zip code.
    public void setZip(String zip) {
        this.zip = zip;
    }

    // Returns the patient's phone number.
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Sets the patient's phone number.
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Returns the emergency contact's name.
    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    // Sets the emergency contact's name.
    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    // Returns the emergency contact's phone number.
    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    // Sets the emergency contact's phone number.
    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }

    // Builds and returns the patient's full name as "First Middle Last".
    public String buildFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    // Builds and returns the patient's full address as "Street City State Zip".
    public String buildAddress() {
        return street + " " + city + " " + state + " " + zip;
    }

    // Builds and returns the emergency contact info as "Name Phone".
    public String buildEmergencyContact() {
        return emergencyContactName + " " + emergencyContactPhone;
    }

    // Returns a formatted string of all patient information using the build methods.
    public String toString() {
        return "Name: " + buildFullName() + "\n" +
               "Address: " + buildAddress() + "\n" +
               "Phone Number: " + phoneNumber + "\n" +
               "Emergency Contact: " + buildEmergencyContact();
    }

    // Checks whether the patient's phone number follows the ###-###-#### format.
    private boolean isValidFormat(String phone) {
        if (phone == null || phone.length() != 12) {
            return false;
        }
        for (int i = 0; i < phone.length(); i++) {
            char currentChar = phone.charAt(i);
            if (i == 3 || i == 7) {
                if (currentChar != '-') {
                    return false;
                }
            } else {
                if (!Character.isDigit(currentChar)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Returns true if the patient's phone number is in valid ###-###-#### format.
    public boolean isValidPhoneNumber() {
        return isValidFormat(phoneNumber);
    }

    // Returns true if the emergency contact's phone number is in valid ###-###-#### format.
    public boolean isValidEmergencyPhoneNumber() {
        return isValidFormat(emergencyContactPhone);
    }

    // Returns the patient's name formatted as "Last, First Middle".
    public String getLastFirstMiddle() {
        return lastName + ", " + firstName + " " + middleName;
    }

    // Returns true if the given city and state match this patient's city and state.
    public boolean hasSameCityState(String city, String state) {
        return this.city.equalsIgnoreCase(city) && this.state.equalsIgnoreCase(state);
    }

    // Updates the patient's street, city, state, and zip code all at once.
    public void updateAddress(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    // Returns a formatted summary of the patient's name, phone, and emergency contact.
    public String getContactSummary() {
        return "Patient: " + buildFullName() + " | Phone: " + phoneNumber +
               " | Emergency: " + buildEmergencyContact();
    }
}