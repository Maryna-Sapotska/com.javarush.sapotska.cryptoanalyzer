package service;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;


public class Validator {
    public void validateForWriting(String filePath) {
        Path path = validatePath(filePath);
        if (Files.exists(path)) {
            if (Files.isDirectory(path)) {
                System.out.println("Файл является директорией");
                System.out.println("Укажите верный путь к файлу: ");
            }
            if (isRestrictedFileType(Path.of(filePath))) {
                System.out.println("Файл " + filePath + " не подходит для записи");
            }
        }
    }

    public boolean isRestrictedFileType(Path filePath) {
        String[] restrictedExtensions = {".bash_profile", ".hosts"};
        String fileName = filePath.getFileName().toString().toLowerCase();

        for (String bash : restrictedExtensions) {
            if (fileName.endsWith(bash)) {
                return true;
            }
        }
        return false;
    }

    private Path validatePath(String fileName) throws RuntimeException {
        try {
            return Path.of(fileName);
        } catch (InvalidPathException e) {
            System.out.println("Файл " + fileName + " не существует");
            throw new RuntimeException(e);
        }
    }

    public void validateForReading(String filePath) {
        Path path = validatePath(filePath);

        if (Files.notExists(path)) {
            System.out.println("Файл " + filePath + " не существует");
        }
    }

    public void validateKey(int key) throws MyExceptions {
        try {
            if (key < 0) {
                Start start = new Start();
                start.start();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Введите верный ключ");
        }
    }
}
