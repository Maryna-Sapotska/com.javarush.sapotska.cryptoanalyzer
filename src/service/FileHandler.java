package service;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHandler {
    public static List<String> readFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        List<String> line = new ArrayList<>();
        while (reader.ready()){
            line.add(reader.readLine());
        }
        return line;
    }





    public static void writeFile(String content, String filePath) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(content);
        /*Path path = Paths.get(filePath);
        byte[] bytes = Files.readAllBytes(path);
        return new String(bytes, StandardCharsets.UTF_8);*/

        //InputStream inputStream = Files.newInputStream(Path.of(filePath));

    }
}
