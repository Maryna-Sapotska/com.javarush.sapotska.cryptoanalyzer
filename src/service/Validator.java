package service;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;


public class Validator {
    public void validateForWriting(String filePath){
        Path path = validatePath(filePath);
        if (Files.exists(path)){
            if (Files.isDirectory(path)){
                System.out.println("Файл является директорией");
            }
            if (!Files.isWritable(path)){
                System.out.println("Файл " + filePath + " не подходит для записи");
            }
        }
    }

    private Path validatePath(String fileName){
        try {
            return Path.of(fileName);
        } catch (InvalidPathException e){
            System.out.println("Такого файла не существует");
            throw new RuntimeException(e);
        }
    }

    public void validateForReading(String filePath){
        Path path = validatePath(filePath);
        if (Files.notExists(path)){
                System.out.println("Файл " + filePath + " не существует");
        }
        if (Files.exists(Path.of(filePath))){
            System.out.println("Файл " + filePath + " существует");
        }
    }
}
