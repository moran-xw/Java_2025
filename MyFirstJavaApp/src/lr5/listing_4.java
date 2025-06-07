package lr5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class listing_4 {
    public static List<Integer> squareList(List<Integer> list) {
        return list.stream().map(x -> x * x).toList();
    }

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();

        System.out.println("Список до: " + "\n");

        for (int i = 0; i < 10; i++) {
            integers.add(random.nextInt(1000));
            System.out.println(integers.get(i));
        }

        List<Integer> integersAfter = squareList(integers);

        System.out.println("\n" + "Список после возведения в квадрат: " + "\n");

        for (Integer i : integersAfter) {
            System.out.println(i);
        }
    }
}
