package team.fromsulaiman.clinicSystem.model;

public class Admin extends User {

    public Admin(String id, String name, String phone) {
        super(id, name, phone);
    }

    @Override
    public void displayInfo() {
        System.out.println("Admin ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Phone: " + getPhone());
    }
}