import service.Cipher;
import service.Validator;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Добро пожаловать! Это шифровальщик!");
        System.out.println("Выберите пункт меню:");
        System.out.println("1. Шифрование");
        System.out.println("2. Расшифровка с ключом");
        System.out.println("3. Brute force");
        System.out.println("0. Выход");

        Scanner console = new Scanner(System.in);
        int userChoose = console.nextInt();

        switch (userChoose) {
            case 1:
                System.out.println("Укажите путь к файлу: ");
                Scanner scanner = new Scanner(System.in);
                String text = scanner.nextLine();
                System.out.println("Укажите ключ: ");
                int key = scanner.nextInt();
                Validator.validateForReading(text);
                Cipher.encrypt(text, key);
                break;
            case 2:
                System.out.println("Укажите путь к файлу: ");
                Scanner scanner1 = new Scanner(System.in);
                String encryptedText = scanner1.nextLine();
                System.out.println("Укажите ключ: ");
                int shift = scanner1.nextInt();
                Validator.validateForReading(encryptedText);
                Cipher.decipher(encryptedText, shift);
                break;
            case 3:
                System.out.println("Укажите путь к файлу: ");
                Scanner scanner2 = new Scanner(System.in);
                String encryptedTextBF = scanner2.nextLine();
                Validator.validateForReading(encryptedTextBF);
                Cipher.bruteForce(encryptedTextBF);
                break;
            case 0:
                break;

        }

    }

}