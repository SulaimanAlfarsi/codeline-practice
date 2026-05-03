package team.fromsulaiman.clinicSystem.storage;

import team.fromsulaiman.clinicSystem.model.Appointment;

import java.util.ArrayList;
import java.util.List;

public class AppointmentFileStorage implements FileStorage<Appointment> {

    @Override
    public void save(List<Appointment> items) {
        System.out.println("Saving appointments to file coming soon...");
    }

    @Override
    public List<Appointment> load() {
        System.out.println("Loading appointments from file coming soon...");
        return new ArrayList<>();
    }
}