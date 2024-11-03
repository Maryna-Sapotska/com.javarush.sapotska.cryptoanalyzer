package service;

import java.util.ArrayList;
import java.util.List;

public class Cipher {

    protected static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public String encrypt(String path, String filePath, int shift) {
        FileHandler fileHandler = new FileHandler();
        List<String> lines = fileHandler.readFile(path);
        ArrayList<String> resultList = new ArrayList<>();
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
        fileHandler.writeFile(String.valueOf(resultList), filePath);
        return resultList.toString();
    }

    public String decipher(String encryptedText, String filePath, int shift) {
        FileHandler fileHandler = new FileHandler();
        List<String> lines = fileHandler.readFile(encryptedText);
        ArrayList<String> resultList = new ArrayList<>();
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
        fileHandler.writeFile(String.valueOf(resultList), filePath);
        return resultList.toString();
    }

    public String bruteForce(String encryptedText, String filePath) {
        FileHandler fileHandler = new FileHandler();
        List<String> lines = fileHandler.readFile(encryptedText);
        ArrayList<String> resultList = new ArrayList<>();
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
        fileHandler.writeFile(String.valueOf(resultList), filePath);
        return resultList.toString();
    }
}
