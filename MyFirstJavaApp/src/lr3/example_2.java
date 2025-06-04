package lr3;

import java.util.Scanner;

public class example_2 {

    public static String convertToBinary(int n) {
        if (n == 0) {
            return "0";
        }
        // Базовый случай: если n == 1, двоичное представление "1"
        if (n == 1) {
            return "1";
        }
        // Рекурсивный случай: получить двоичный для n / 2, затем присоединить младший бит n % 2
        return convertToBinary(n / 2) + (n % 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        // Считываем целое число (может быть отрицательным)
        int number = scanner.nextInt();
        scanner.close();

        // Обрабатываем случай отрицательного числа отдельно
        if (number < 0) {
            // Отрицательное: выводим знак "-" и переводим абсолютное значение
            System.out.println("Двоичное представление: -" + convertToBinary(-number));
        } else {
            // Неотрицательное: просто переводим
            System.out.println("Двоичное представление: " + convertToBinary(number));
        }
    }
}

