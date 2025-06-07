package lr5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class example_11 {
    public static List<Integer> getListIntegerLessNum(List<Integer> integers, int num) {
        return integers.stream().filter(x -> x < num).toList();
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

        List<Integer> integersAfter = getListIntegerLessNum(numbers, num);

        System.out.println("\n" + "Список чисел, которые меньше заданного: " + "\n");

        for (Integer i : integersAfter) {
            System.out.println(i);
        }
    }
}
