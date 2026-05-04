package team.fromsulaiman.inventoryCli.util;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileManager {

    public static List<String> readLines(String filePath) {
        try {
            Path path = Path.of(filePath);

            if (!Files.exists(path)) {
                Files.createDirectories(path.getParent());
                Files.createFile(path);
            }

            return Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Could not read file: " + filePath);
            return List.of();
        }
    }

    public static void writeLines(String filePath, List<String> lines) {
        try {
            Path path = Path.of(filePath);

            if (!Files.exists(path.getParent())) {
                Files.createDirectories(path.getParent());
            }

            Files.write(path, lines);
        } catch (IOException e) {
            System.out.println("Could not write file: " + filePath);
        }
    }
}