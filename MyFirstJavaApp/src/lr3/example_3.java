package lr3;

import java.util.Scanner;

public class example_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива (целое положительное число): ");
        int size = scanner.nextInt();
        if (size <= 0) {
            System.out.println("Неверный размер массива.");
            scanner.close();
            return;
        }

        int[] array = new int[size];
        System.out.println("Начинаем ввод элементов массива рекурсивно:");
        inputArrayRecursively(scanner, array, 0);

        System.out.println("\nВвод завершён. Теперь выведем массив рекурсивно:");
        printArrayRecursively(array, 0);

        scanner.close();
    }

    private static void inputArrayRecursively(Scanner scanner, int[] array, int index) {
        if (index >= array.length) {
            // База рекурсии: все элементы введены
            return;
        }

        System.out.print("array[" + index + "] = ");
        array[index] = scanner.nextInt();

        // Рекурсивно вводим следующий элемент
        inputArrayRecursively(scanner, array, index + 1);
    }

    /**
     * Рекурсивно выводит элементы массива в одну строку, разделяя пробелами.
     *
     * @param array массив для вывода
     * @param index текущий индекс (начинается с 0)
     */
    private static void printArrayRecursively(int[] array, int index) {
        if (index >= array.length) {
            // База рекурсии: все элементы выведены, печатаем перевод строки
            System.out.println();
            return;
        }

        System.out.print(array[index] + " ");
        // Рекурсивно выводим следующий элемент
        printArrayRecursively(array, index + 1);
    }
}

