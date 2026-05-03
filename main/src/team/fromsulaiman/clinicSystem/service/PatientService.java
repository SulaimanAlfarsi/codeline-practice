package team.fromsulaiman.clinicSystem.service;


import team.fromsulaiman.clinicSystem.model.Patient;
import team.fromsulaiman.clinicSystem.util.IdGenerator;

import java.util.ArrayList;

public class PatientService {
    private ArrayList<Patient> patients = new ArrayList<>();

    public void registerPatient(String name, String phone, int age) {
        if (age <= 0) {
            System.out.println("Age must be greater than zero.");
            return;
        }

        String id = IdGenerator.generatePatientId();
        Patient patient = new Patient(id, name, phone, age);
        patients.add(patient);
        System.out.println("Patient registered successfully. ID: " + id);
    }

    public Patient findById(String id) {
        for (Patient patient : patients) {
            if (patient.getId().equalsIgnoreCase(id)) {
                return patient;
            }
        }
        return null;
    }

    public void viewAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }

        for (Patient patient : patients) {
            patient.displayInfo();
            System.out.println("--------------------");
        }

    }


}