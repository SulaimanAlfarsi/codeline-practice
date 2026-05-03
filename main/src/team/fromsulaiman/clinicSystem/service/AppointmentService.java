package team.fromsulaiman.clinicSystem.service;

import team.fromsulaiman.clinicSystem.model.Appointment;
import team.fromsulaiman.clinicSystem.model.Doctor;
import team.fromsulaiman.clinicSystem.model.Patient;
import team.fromsulaiman.clinicSystem.util.IdGenerator;

import java.util.ArrayList;

public class AppointmentService {
    private ArrayList<Appointment> appointments = new ArrayList<>();

    public void bookAppointment(Doctor doctor, Patient patient, String date, String time) {
        String id = IdGenerator.generateAppointmentId();
        Appointment appointment = new Appointment(id, doctor, patient, date, time);
        appointments.add(appointment);
        System.out.println("Appointment booked successfully. ID: " + id);
    }

    public Appointment findById(String id) {
        for (Appointment appointment : appointments) {
            if (appointment.getId().equalsIgnoreCase(id)) {
                return appointment;
            }
        }
        return null;
    }

    public void viewAllAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        for (Appointment appointment : appointments) {
            appointment.displayInfo();
            System.out.println("--------------------");
        }
    }

    public void cancelAppointment(String id) {
        Appointment appointment = findById(id);

        if (appointment == null) {
            System.out.println("Appointment not found.");
            return;
        }

        appointment.cancel();
        System.out.println("Appointment cancelled successfully.");
    }

    public void completeAppointment(String id) {
        Appointment appointment = findById(id);

        if (appointment == null) {
            System.out.println("Appointment not found.");
            return;
        }

        appointment.complete();
        System.out.println("Appointment completed successfully.");
    }
}