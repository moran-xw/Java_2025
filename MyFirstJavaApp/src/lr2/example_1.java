package lr2;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class example_1 {

    public static void main(String[] args) {
        // Создание Scanner для чтения размера массива из консоли
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива:");
        int size = scanner.nextInt();
        System.out.println("Размер массива: " + size);

        // Создание массива и объект Random для генерации случайных чисел
        int[] nums = new int[size];
        Random random = new Random();

        // Заполнение массива случайными числами и вывод на экран
        System.out.println("Сгенерированный массив:");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100); // числа от 0 до 99 (можно поменять диапазон)
            System.out.println("nums[" + i + "] = " + nums[i]);
        }

        // Находим минимальное значение в массиве
        int minValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minValue) {
                minValue = nums[i];
            }
        }

        // Собираем все индексы, где встречается минимальное значение
        ArrayList<Integer> minIndices = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == minValue) {
                minIndices.add(i);
            }
        }

        // Выводим результат
        System.out.println("\nМинимальное значение в массиве: " + minValue);
        System.out.print("Индекс(ы) элемента(ов) с минимальным значением: ");
        for (int idx : minIndices) {
            System.out.print(idx + " ");
        }
        System.out.println();

        scanner.close();
    }
}
