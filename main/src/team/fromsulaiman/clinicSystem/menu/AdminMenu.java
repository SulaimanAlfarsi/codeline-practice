package team.fromsulaiman.clinicSystem.menu;

import team.fromsulaiman.clinicSystem.service.AppointmentService;
import team.fromsulaiman.clinicSystem.service.DoctorService;
import team.fromsulaiman.clinicSystem.service.PatientService;
import team.fromsulaiman.clinicSystem.util.InputHelper;

public class AdminMenu {
    private InputHelper inputHelper;
    private DoctorService doctorService;
    private PatientService patientService;
    private AppointmentService appointmentService;

    public AdminMenu(
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
            System.out.println("\n===== Admin Menu =====");
            System.out.println("1. Add Doctor");
            System.out.println("2. View Doctors");
            System.out.println("3. View Patients");
            System.out.println("4. View Appointments");
            System.out.println("5. Complete Appointment");
            System.out.println("6. Cancel Appointment");
            System.out.println("0. Back");

            int choice = inputHelper.readInt("Choose option: ");

            switch (choice) {
                case 1:
                    addDoctor();
                    break;
                case 2:
                    doctorService.viewAllDoctors();
                    break;
                case 3:
                    patientService.viewAllPatients();
                    break;
                case 4:
                    appointmentService.viewAllAppointments();
                    break;
                case 5:
                    completeAppointment();
                    break;
                case 6:
                    cancelAppointment();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void addDoctor() {
        String name = inputHelper.readText("Doctor name: ");
        String phone = inputHelper.readText("Doctor phone: ");
        String specialization = inputHelper.readText("Specialization: ");

        doctorService.addDoctor(name, phone, specialization);
    }

    private void completeAppointment() {
        String id = inputHelper.readText("Appointment ID: ");
        appointmentService.completeAppointment(id);
    }

    private void cancelAppointment() {
        String id = inputHelper.readText("Appointment ID: ");
        appointmentService.cancelAppointment(id);
    }
}