package service;

import java.util.List;

public class Cipher {

    protected static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public void encrypt(String path, String filePath, int shift) {
        FileHandler fileHandler = new FileHandler();
        List<String> lines = fileHandler.readFile(path);
        StringBuilder encryptList = new StringBuilder();
        for (int m = 0; m < lines.size(); m++) {
            String text = lines.get(m);
            for (int i = 0; i < text.length(); i++) {
                for (int j = 0; j < ALPHABET.length; j++) {
                    if (text.charAt(i) == ALPHABET[j]) {
                        encryptList.append(ALPHABET[(j + shift) % ALPHABET.length]);
                    }
                }
            }
            String result = encryptList.toString();
            fileHandler.writeFile(result, filePath);
        }
    }

    public void decipher(String encryptedText, String filePath, int shift) {
        FileHandler fileHandler = new FileHandler();
        List<String> lines = fileHandler.readFile(encryptedText);
        StringBuilder encryptList = new StringBuilder();
        for (int m = 0; m < lines.size(); m++) {
            String text = lines.get(m);
            for (int i = 0; i < text.length(); i++) {
                for (int j = 0; j < ALPHABET.length; j++) {
                    if (text.charAt(i) == ALPHABET[j]) {
                        encryptList.append(ALPHABET[(j + ALPHABET.length - shift) % ALPHABET.length]);
                    }
                }
            }
            String result = encryptList.toString();
            fileHandler.writeFile(result, filePath);
        }
    }

    public void bruteForce(String encryptedText, String filePath) {
        FileHandler fileHandler = new FileHandler();
        List<String> lines = fileHandler.readFile(encryptedText);
        StringBuilder encryptList = new StringBuilder();
        for (int m = 0; m < lines.size(); m++) {
            String text = lines.get(m);
            int shift = ALPHABET.length;
            while (shift > 0) {
                shift--;
                for (int i = 0; i < text.length(); i++) {
                    for (int j = 0; j < ALPHABET.length; j++) {
                        if (text.charAt(i) == ALPHABET[j]) {
                            encryptList.append(ALPHABET[(j + shift) % ALPHABET.length]);
                        }
                    }
                }
                encryptList.append("\n");
                encryptList.append("\n");
                for (int n = 0; n < lines.size(); n++) {
                    String result = encryptList.toString();
                    fileHandler.writeFile(result, filePath);
                }
            }
        }
    }
}
