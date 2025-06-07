package lr7.listing9;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class example_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();
        System.out.println("Введите текст для записи в файл: ");
        StringBuilder text = new StringBuilder();
        String line;


        line = scanner.nextLine();
        text.append(line).append("\n");


        String contentToWrite = text.toString();
        int charactersCount = contentToWrite.length();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(contentToWrite);
            System.out.println("Текст успешно записан в файл '" + fileName + "'.");
            System.out.println("Количество записанных символов: " + charactersCount);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }

        scanner.close();
    }
}
