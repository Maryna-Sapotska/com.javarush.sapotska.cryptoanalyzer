package service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cipher {
    public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};
    // нужно реализовать метод, куда будет попадать текст и куда мы его будем записывать
    // проверяю есть ли символы из файла в моем алфавите
    // если да, то запрашиваю код цезаря
    // если нет, выкидываю
    // надо создать метод, который будет реализовывать логику прокрутки алфавита и шифровать
    // надо создать второй массив с зашифрованным текстом

    public static String encrypt(String path, int shift) throws IOException {
        List<String> lines = FileHandler.readFile(path);
        List<String> resultList = new ArrayList<>();
        for (int m = 0; m < lines.size(); m++) {
            StringBuilder encryptList = new StringBuilder();
            String text = lines.get(m);
            for (int i = 0; i < text.length(); i++) {
                for (int j = 0; j < ALPHABET.length; j++) {
                    if (text.charAt(i) == ALPHABET[j]) {
                        encryptList.append(ALPHABET[(j + shift) % ALPHABET.length]);
                    }
                }
            }
            resultList.add(encryptList.toString());
        }

        System.out.println(resultList);
        return resultList.toString();

       /* try (InputStream inputStream = Files.newInputStream(Path.of(text));
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
             BufferedWriter writer = new BufferedWriter(new FileWriter("encrypt.txt"))) {
            String line = reader.readLine();
            for (int i = 0; i < line.length(); i++) {
                for (int j = 0; j < ALPHABET.length; j++) {
                    if (line.charAt(i) == ALPHABET[j]) {
                        writer.write(ALPHABET[j + shift] % ALPHABET.length);
                        writer.flush();
                    }
                }

            }
        }
        return*/
    }

    public static String decipher(String encryptedText, int shift){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            for (int j = 0; j < ALPHABET.length; j++) {
                if (encryptedText.charAt(i) == ALPHABET[j]) {
                    result.append(ALPHABET[j + shift] % ALPHABET.length);
                }
            }
        }
        return result.toString();

    }


}
