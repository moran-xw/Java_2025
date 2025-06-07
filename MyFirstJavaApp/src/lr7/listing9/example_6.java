package lr7.listing9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class example_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();
        System.out.print("Введите слово для поиска: ");
        String searchWord = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean found = false;
            int lineNumber = 0;

            System.out.println("\nСтроки, содержащие слово '" + searchWord + "':");

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.contains(searchWord)) {
                    System.out.println("Строка " + lineNumber + ": " + line);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Слово '" + searchWord + "' не найдено в файле.");
            }

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        scanner.close();
    }
}
