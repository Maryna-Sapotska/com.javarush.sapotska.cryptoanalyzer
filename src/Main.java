import service.Cipher;
import service.Decipher;
import service.FileHandler;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
// Логика меню
        // 1. Шифрование
        // 2. Расшифровка с ключом
        // 3. Brute force
        // 4. Статистический анализ
        // 0. Выход
        System.out.println("Добро пожаловать! Это шифровальщик!");
        System.out.println("Выберите пункт меню:");
        System.out.println("1. Шифрование");
        System.out.println("2. Расшифровка с ключом");
        System.out.println("3. Brute force");
        System.out.println("4. Статистический анализ");
        System.out.println("0. Выход");

        Scanner console = new Scanner(System.in);
        int userChoose = console.nextInt();

        switch (userChoose){
            case 1:
                System.out.println("Укажите путь к файлу: ");
                Scanner scanner = new Scanner(System.in);
                String text = scanner.nextLine();
                System.out.println("Укажите ключ: ");
                int key = scanner.nextInt();
                Cipher.encrypt(text, key);
            break;
            case 2:
                System.out.println("Укажите путь к файлу: ");
                String encryptedText = console.nextLine();
                int shift = console.nextInt();
                Cipher.decipher(encryptedText, shift);
        }

    }

}