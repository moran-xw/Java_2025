package lr2;

import java.util.Scanner;

public class example_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод количества строк и столбцов
        System.out.print("Введите число строк: ");
        int rows = scanner.nextInt();
        System.out.print("Введите число столбцов: ");
        int cols = scanner.nextInt();

        int[][] arr = new int[rows][cols];
        int value = 1;

        // Заполняем первую строку слева направо
        for (int j = 0; j < cols; j++) {
            arr[0][j] = value++;
        }
        for (int i = 1; i < rows; i++) {
            if (i % 2 == 1) {
                // Нечётная строка: спускаемся вниз по последнему столбцу
                arr[i][cols - 1] = value++;
                // Заполняем строку справа налево, начиная со столбца cols-2 до 0
                for (int j = cols - 2; j >= 0; j--) {
                    arr[i][j] = value++;
                }
            } else {
                // Чётная строка: спускаемся вниз по первому столбцу
                arr[i][0] = value++;
                // Заполняем строку слева направо, начиная со столбца 1 до cols-1
                for (int j = 1; j < cols; j++) {
                    arr[i][j] = value++;
                }
            }
        }

        // Печатаем результат в виде матрицы
        System.out.println("\nЗаполненный «змейкой» массив:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Выводим значения с табуляцией для лучшей читаемости
                System.out.printf("%4d", arr[i][j]);
            }
            System.out.println();
        }

        scanner.close();
    }
}

