package team.fromsulaiman.clinicSystem.util;

public class IdGenerator {
    private static int doctorCounter = 1;
    private static int patientCounter = 1;
    private static int appointmentCounter = 1;

    public static String generateDoctorId() {
        return "D-" + doctorCounter++;
    }

    public static String generatePatientId() {
        return "P-" + patientCounter++;
    }

    public static String generateAppointmentId() {
        return "A-" + appointmentCounter++;
    }
}