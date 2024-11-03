import service.Cipher;
import service.Validator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


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
                System.out.println("Укажите путь, куда нужно сохранить файл: ");
                Scanner console1 = new Scanner(System.in);
                String filePath = console1.nextLine();
                System.out.println("Укажите ключ: ");
                int key = scanner.nextInt();
                Validator validator = new Validator();
                validator.validateForReading(text);
                Cipher cipher = new Cipher();
                cipher.encrypt(text, filePath, key);
                break;
            case 2:
                System.out.println("Укажите путь к файлу: ");
                Scanner scanner1 = new Scanner(System.in);
                String encryptedText = scanner1.nextLine();
                System.out.println("Укажите путь, куда нужно сохранить файл: ");
                Scanner console2 = new Scanner(System.in);
                String outPath = console2.nextLine();
                System.out.println("Укажите ключ: ");
                int shift = scanner1.nextInt();
                Validator devalidator = new Validator();
                devalidator.validateForReading(encryptedText);
                Cipher decipher = new Cipher();
                decipher.decipher(encryptedText, outPath, shift);
                break;
            case 3:
                System.out.println("Укажите путь к файлу: ");
                Scanner scanner2 = new Scanner(System.in);
                String encryptedTextBF = scanner2.nextLine();
                System.out.println("Укажите путь, куда нужно сохранить файл: ");
                Scanner console3 = new Scanner(System.in);
                String filePathBF = console3.nextLine();
                Validator validatorBF = new Validator();
                validatorBF.validateForReading(encryptedTextBF);
                Cipher decipherBF = new Cipher();
                decipherBF.bruteForce(encryptedTextBF, filePathBF);
                break;
            case 0:
                break;

        }

    }

}