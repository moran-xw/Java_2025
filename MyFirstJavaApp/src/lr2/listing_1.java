package lr2;

import java.util.Arrays; // пакет для подключения класса Arrays
import java.util.Random; // пакет для подключения класса Random
import java.util.Scanner; // пакет для подключения класса Scanner

public class listing_1 {

    public static void main(String[] args) {
        // Создание объекта класса Scanner для считывания числа, введённого с консоли
        Scanner id = new Scanner(System.in);
        // Сообщение пользователю "для красоты и понимания"
        System.out.println("Введите размер массива");
        // Чтение размера массива
        int size = id.nextInt();
        System.out.println("Размер массива равен " + size);
        // Создание массива заданного размера
        int[] nums = new int[size];
        // Создание объекта Random для генерации случайных чисел
        Random random = new Random();

        for (int i = 0; i < nums.length; i++) {
            // Присвоение i-тому элементу массива случайного значения от 0 до 199
            nums[i] = random.nextInt(200);
            System.out.println("Элемент массива [" + i + "] = " + nums[i]);
        }

        // Сортировка массива по возрастанию
        Arrays.sort(nums);
        System.out.println("Произведена сортировка массива");

        for (int i = 0; i < nums.length; i++) {
            System.out.println("Элемент массива [" + i + "] после сортировки = " + nums[i]);
        }
    }
}
