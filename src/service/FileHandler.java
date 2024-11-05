package service;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileHandler {
    public List<String> readFile(String filePath) throws MyExceptions {
        List<String> line = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.ready()) {
                line.add(reader.readLine().toLowerCase());
            }
            return line;
        } catch (IOException e) {
            System.out.println("Что-то пошло не так. Файл не найден " + e);
            Start start = new Start();
            start.start();
        }
        return line;
    }

    public List<String> writeFile(String content, String filePath) throws MyExceptions {
        Validator validator = new Validator();
        validator.validateForWriting(filePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("Что-то пошло не так. Файл не найден " + e);
            Start start = new Start();
            start.start();
        }
        return Collections.singletonList(content);
    }
}
