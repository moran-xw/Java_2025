package lr4;

import java.util.Scanner;

public class example_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Вычисление суммы элементов типа byte");
        System.out.print("Введите элементы массива через пробел (каждое в диапазоне -128..127): ");
        String[] parts = sc.nextLine().trim().split("\\s+");
        int sum = 0;
        for (String p : parts) {
            try {
                byte b = Byte.parseByte(p);
                sum += b;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: «" + p + "» не является корректным значением типа byte");
                sc.close();
                return;
            }
        }
        System.out.println("Сумма = " + sum);
        sc.close();
    }
}


