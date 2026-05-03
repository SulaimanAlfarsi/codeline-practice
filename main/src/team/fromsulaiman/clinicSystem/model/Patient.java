package team.fromsulaiman.clinicSystem.model;

public class Patient extends User {
    private int age;

    public Patient(String id, String name, String phone, int age) {
        super(id, name, phone);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void displayInfo() {
        System.out.println("Patient ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Phone: " + getPhone());
        System.out.println("Age: " + age);
    }
}