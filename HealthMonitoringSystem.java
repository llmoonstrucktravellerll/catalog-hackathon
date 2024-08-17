import java.util.HashMap;
import java.util.Scanner;

// Class representing a Patient
class Patient {
    String name;
    int age;
    String patientID;
    
    public Patient(String name, int age, String patientID) {
        this.name = name;
        this.age = age;
        this.patientID = patientID;
    }

    public String getPatientID() {
        return patientID;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Patient ID: " + patientID;
    }
}

// Class representing the Diagnosis Report
class DiagnosisReport {
    String reportID;
    String patientID;
    String diagnosisDetails;
    
    public DiagnosisReport(String reportID, String patientID, String diagnosisDetails) {
        this.reportID = reportID;
        this.patientID = patientID;
        this.diagnosisDetails = diagnosisDetails;
    }

    @Override
    public String toString() {
        return "Report ID: " + reportID + ", Diagnosis: " + diagnosisDetails;
    }
}

// Main class for Automatic Health Monitoring System
public class HealthMonitoringSystem {
    private static HashMap<String, Patient> patients = new HashMap<>();
    private static HashMap<String, DiagnosisReport> reports = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to the Automatic Health Monitoring System");
            System.out.println("1. Register Patient");
            System.out.println("2. Add Diagnosis Report");
            System.out.println("3. View Patient Reports");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    addDiagnosisReport();
                    break;
                case 3:
                    viewPatientReports();
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Method to register a new patient
    private static void registerPatient() {
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Patient ID: ");
        String patientID = scanner.nextLine();

        Patient patient = new Patient(name, age, patientID);
        patients.put(patientID, patient);
        System.out.println("Patient registered successfully!");
    }

    // Method to add a diagnosis report for a patient
    private static void addDiagnosisReport() {
        System.out.print("Enter Patient ID: ");
        String patientID = scanner.nextLine();

        if (!patients.containsKey(patientID)) {
            System.out.println("Patient not found. Please register the patient first.");
            return;
        }

        System.out.print("Enter Report ID: ");
        String reportID = scanner.nextLine();
        System.out.print("Enter Diagnosis Details: ");
        String diagnosisDetails = scanner.nextLine();

        DiagnosisReport report = new DiagnosisReport(reportID, patientID, diagnosisDetails);
        reports.put(reportID, report);
        System.out.println("Diagnosis report added successfully!");
    }

    // Method to view all reports for a specific patient
    private static void viewPatientReports() {
        System.out.print("Enter Patient ID: ");
        String patientID = scanner.nextLine();

        if (!patients.containsKey(patientID)) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.println("Diagnosis Reports for Patient ID: " + patientID);
        for (DiagnosisReport report : reports.values()) {
            if (report.patientID.equals(patientID)) {
                System.out.println(report);
            }
        }
    }
}
