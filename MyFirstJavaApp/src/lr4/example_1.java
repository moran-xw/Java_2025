package lr4;

import java.util.Scanner;

public class example_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите элементы массива через пробел: ");
        String line = scanner.nextLine();
        String[] parts = line.trim().split("\\s+");
        int sum = 0, count = 0;
        for (String p : parts) {
            try {
                int x = Integer.parseInt(p);
                if (x > 0) {
                    sum += x;
                    count++;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: «" + p + "» не является целым числом");
                scanner.close();
                return;
            }
        }
        if (count == 0) {
            System.out.println("Ошибка: в массиве нет положительных элементов");
        } else {
            double avg = (double) sum / count;
            System.out.println("Среднее положительных элементов = " + avg);
        }
        scanner.close();
    }
}

