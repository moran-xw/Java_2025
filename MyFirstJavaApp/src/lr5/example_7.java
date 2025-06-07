package lr5;

import java.util.*;

public class example_7 {
    public static List<Integer> filterListModNumber(List<Integer> integers, int num) {
        return integers.stream().filter(x -> x % num == 0).toList();
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        Scanner in = new Scanner(System.in);

        System.out.println("Введите заданое число: ");
        int num = in.nextInt();

        System.out.println("Список до: " + "\n");

        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(100));
            System.out.println(numbers.get(i));
        }

        List<Integer> integersAfter = filterListModNumber(numbers, num);

        System.out.println("\n" + "Список чисел, которые делятся на заданное без остатка: " + "\n");

        for (Integer i : integersAfter) {
            System.out.println(i);
        }

    }
}