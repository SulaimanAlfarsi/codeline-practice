package team.fromsulaiman.clinicSystem.model;

public class Appointment {
    private String id;
    private Doctor doctor;
    private Patient patient;
    private String date;
    private String time;
    private AppointmentStatus status;

    public Appointment(String id, Doctor doctor, Patient patient, String date, String time) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.time = time;
        this.status = AppointmentStatus.BOOKED;
    }

    public String getId() {
        return id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void cancel() {
        this.status = AppointmentStatus.CANCELLED;
    }

    public void complete() {
        if (status == AppointmentStatus.CANCELLED) {
            System.out.println("Cannot complete a cancelled appointment.");
            return;
        }

        this.status = AppointmentStatus.COMPLETED;
    }

    public void displayInfo() {
        System.out.println("Appointment ID: " + id);
        System.out.println("Doctor: " + doctor.getName());
        System.out.println("Patient: " + patient.getName());
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Status: " + status);
    }
}