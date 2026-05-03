package team.fromsulaiman.clinicSystem.menu;

import team.fromsulaiman.clinicSystem.service.AppointmentService;
import team.fromsulaiman.clinicSystem.service.DoctorService;
import team.fromsulaiman.clinicSystem.util.InputHelper;

public class DoctorMenu {
    private InputHelper inputHelper;
    private DoctorService doctorService;
    private AppointmentService appointmentService;

    public DoctorMenu(
            DoctorService doctorService,
            AppointmentService appointmentService
    ) {
        this.inputHelper = new InputHelper();
        this.doctorService = doctorService;
        this.appointmentService = appointmentService;
    }

    public void show() {
        while (true) {
            System.out.println("\n===== Doctor Menu =====");
            System.out.println("1. View My Appointments");
            System.out.println("0. Back");

            int choice = inputHelper.readInt("Choose option: ");

            switch (choice) {
                case 1:
                    viewMyAppointments();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void viewMyAppointments() {
        String doctorId = inputHelper.readText("Doctor ID: ");

        if (doctorService.findById(doctorId) == null) {
            System.out.println("Doctor not found.");
            return;
        }

        appointmentService.viewAppointmentsByDoctor(doctorId);
    }
}