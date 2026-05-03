package team.fromsulaiman.clinicSystem.menu;


import team.fromsulaiman.clinicSystem.model.Doctor;
import team.fromsulaiman.clinicSystem.model.Patient;
import team.fromsulaiman.clinicSystem.service.AppointmentService;
import team.fromsulaiman.clinicSystem.service.DoctorService;
import team.fromsulaiman.clinicSystem.service.PatientService;
import team.fromsulaiman.clinicSystem.util.InputHelper;

public class PatientMenu {
    private InputHelper inputHelper;
    private DoctorService doctorService;
    private PatientService patientService;
    private AppointmentService appointmentService;

    public PatientMenu(
            DoctorService doctorService,
            PatientService patientService,
            AppointmentService appointmentService
    ) {
        this.inputHelper = new InputHelper();
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.appointmentService = appointmentService;
    }

    public void show() {
        while (true) {
            System.out.println("\n===== Patient Menu =====");
            System.out.println("1. Register Patient");
            System.out.println("2. View Doctors");
            System.out.println("3. Book Appointment");
            System.out.println("0. Back");

            int choice = inputHelper.readInt("Choose option: ");

            switch (choice) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    doctorService.viewAllDoctors();
                    break;
                case 3:
                    bookAppointment();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void registerPatient() {
        String name = inputHelper.readText("Patient name: ");
        String phone = inputHelper.readText("Patient phone: ");
        int age = inputHelper.readInt("Patient age: ");

        patientService.registerPatient(name, phone, age);
    }

    private void bookAppointment() {
        String patientId = inputHelper.readText("Patient ID: ");
        String doctorId = inputHelper.readText("Doctor ID: ");
        String date = inputHelper.readText("Date, example 2026-05-03: ");
        String time = inputHelper.readText("Time, example 10:30: ");

        Patient patient = patientService.findById(patientId);
        Doctor doctor = doctorService.findById(doctorId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        appointmentService.bookAppointment(doctor, patient, date, time);
    }
}