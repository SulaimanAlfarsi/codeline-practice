package team.fromsulaiman.clinicSystem.menu;


import team.fromsulaiman.clinicSystem.service.AppointmentService;
import team.fromsulaiman.clinicSystem.service.DoctorService;
import team.fromsulaiman.clinicSystem.service.PatientService;
import team.fromsulaiman.clinicSystem.util.InputHelper;

public class MainMenu {
    private InputHelper inputHelper;
    private DoctorService doctorService;
    private PatientService patientService;
    private AppointmentService appointmentService;

    public MainMenu() {
        inputHelper = new InputHelper();
        doctorService = new DoctorService();
        patientService = new PatientService();
        appointmentService = new AppointmentService();
    }

    public void start() {
        while (true) {
            System.out.println("\n===== Clinic Appointment System =====");
            System.out.println("1. Admin Menu");
            System.out.println("2. Patient Menu");
            System.out.println("3. Doctor Menu");
            System.out.println("0. Exit");

            int choice = inputHelper.readInt("Choose option: ");

            switch (choice) {
                case 1:
                    AdminMenu adminMenu = new AdminMenu(
                            doctorService,
                            patientService,
                            appointmentService
                    );
                    adminMenu.show();
                    break;
                case 2:
                    PatientMenu patientMenu = new PatientMenu(
                            doctorService,
                            patientService,
                            appointmentService
                    );
                    patientMenu.show();
                    break;
                case 3:
                    System.out.println("Doctor menu coming soon...");
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}