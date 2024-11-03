package service;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileHandler {
    public static List<String> readFile(String filePath) {
        List<String> line = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.ready()) {
                line.add(reader.readLine().toLowerCase());
            }
            return line;
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e);
        }
        return line;
    }

    public static List<String> writeFile(String content, String filePath) throws IOException {
        Validator.validateForWriting(filePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e);
        }
        return Collections.singletonList(content);
    }
}
