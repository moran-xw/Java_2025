package lr2;

import java.util.Scanner;

public class example_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Запрос исходного текста
        System.out.println("Введите текст для шифрования");
        String originalText = scanner.nextLine();

        // 2. Запрос ключа (сдвига)
        System.out.println("Введите ключ");
        int key = scanner.nextInt();
        scanner.nextLine(); // потребление перевода строки после nextInt()

        // 3. Шифрование: перебираем каждый символ и сдвигаем его код
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < originalText.length(); i++) {
            char c = originalText.charAt(i);
            char shifted = (char) (c + key);
            encrypted.append(shifted);
        }

        // 4. Вывод зашифрованного текста
        System.out.println("Текст после преобразования: " + encrypted.toString());

        // 5. Спрашиваем, выполнять ли обратное преобразование
        System.out.println("Выполнить обратное преобразование? (y/n)");
        String answer = scanner.nextLine().trim();

        if (answer.equalsIgnoreCase("y")) {
            // 6. Дешифрование: сдвигаем каждый символ обратно
            StringBuilder decrypted = new StringBuilder();
            for (int i = 0; i < encrypted.length(); i++) {
                char c = encrypted.charAt(i);
                char unshifted = (char) (c - key);
                decrypted.append(unshifted);
            }
            System.out.println("Текст после обратного преобразования: " + decrypted.toString());
        } else if (answer.equalsIgnoreCase("n")) {
            System.out.println("До свидания!");
        } else {
            System.out.println("Введите корректный ответ");
        }

        scanner.close();
    }
}
