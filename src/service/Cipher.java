package service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cipher {

    protected static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

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
        System.out.println("Укажите путь, куда нужно сохранить файл: ");
        Scanner console = new Scanner(System.in);
        String filePath = console.nextLine();
        FileHandler.writeFile(String.valueOf(resultList), filePath);
        return resultList.toString();
    }

    public static String decipher(String encryptedText, int shift) throws IOException {
        List<String> lines = FileHandler.readFile(encryptedText);
        List<String> resultList = new ArrayList<>();
        for (int m = 0; m < lines.size(); m++) {
            StringBuilder encryptList = new StringBuilder();
            String text = lines.get(m);
            for (int i = 0; i < text.length(); i++) {
                for (int j = 0; j < ALPHABET.length; j++) {
                    if (text.charAt(i) == ALPHABET[j]) {
                        encryptList.append(ALPHABET[(j + ALPHABET.length - shift) % ALPHABET.length]);
                    }
                }
            }
            resultList.add(encryptList.toString());
        }
        System.out.println("Укажите путь, куда нужно сохранить файл: ");
        Scanner console = new Scanner(System.in);
        String filePath = console.nextLine();
        FileHandler.writeFile(String.valueOf(resultList), filePath);
        return resultList.toString();
    }

    public static String bruteForce(String encryptedText) throws IOException {
        List<String> lines = FileHandler.readFile(encryptedText);
        List<String> resultList = new ArrayList<>();
        for (int m = 0; m < lines.size(); m++) {
            String text = lines.get(m);
            int shift = ALPHABET.length;
            while (shift > 0) {
                StringBuilder encryptList = new StringBuilder();
                shift--;
                for (int i = 0; i < text.length(); i++) {
                    for (int j = 0; j < ALPHABET.length; j++) {
                        if (text.charAt(i) == ALPHABET[j]) {
                            encryptList.append(ALPHABET[(j + shift) % ALPHABET.length]);
                        }
                    }
                }
                resultList.add(encryptList.toString());
            }
        }
        System.out.println("Укажите путь, куда нужно сохранить файл: ");
        Scanner console = new Scanner(System.in);
        String filePath = console.nextLine();
        FileHandler.writeFile(String.valueOf(resultList), filePath);
        return resultList.toString();
    }
}
