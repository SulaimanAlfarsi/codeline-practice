package team.fromsulaiman.clinicSystem.service;

import team.fromsulaiman.clinicSystem.model.Doctor;
import team.fromsulaiman.clinicSystem.util.IdGenerator;

import java.util.ArrayList;

public class DoctorService {
    private ArrayList<Doctor> doctors = new ArrayList<>();

    public void addDoctor(String name, String phone, String specialization) {
        String id = IdGenerator.generateDoctorId();
        Doctor doctor = new Doctor(id, name, phone, specialization);
        doctors.add(doctor);
        System.out.println("Doctor added successfully. ID: " + id);
    }

    public Doctor findById(String id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId().equalsIgnoreCase(id)) {
                return doctor;
            }
        }
        return null;
    }

    public void viewAllDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }

        for (Doctor doctor : doctors) {
            doctor.displayInfo();
            System.out.println("--------------------");
        }
    }
}