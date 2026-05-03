package team.fromsulaiman.clinicSystem.model;

public class Doctor extends User {
    private String specialization;

    public Doctor(String id, String name, String phone, String specialization) {
        super(id, name, phone);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public void displayInfo() {
        System.out.println("Doctor ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Phone: " + getPhone());
        System.out.println("Specialization: " + specialization);
    }
}