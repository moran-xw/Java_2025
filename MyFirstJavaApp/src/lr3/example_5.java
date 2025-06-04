package lr3;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class example_5 {

    public static void main(String[] args) {
        // 1. Заполняем HashMap десятью парами <Integer, String>
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "zero");
        map.put(1, "apple");
        map.put(2, "banana");
        map.put(3, "kiwi");
        map.put(4, "strawberry");
        map.put(5, "pear");
        map.put(6, "pineapple");
        map.put(7, "fig");
        map.put(8, "watermelon");
        map.put(9, "grape");

        // 2. Найти и вывести все строки, у которых ключ > 5
        System.out.println("Строки, у которых ключ > 5:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                System.out.println("  Key = " + entry.getKey() + " -> Value = \"" + entry.getValue() + "\"");
            }
        }

        // 3. Если ключ = 0, вывести ВСЕ строки через запятую
        if (map.containsKey(0)) {
            String allValuesJoined = map.values()
                    .stream()
                    .collect(Collectors.joining(", "));
            System.out.println("\nПоскольку есть запись с ключом = 0, выводим все строки через запятую:");
            System.out.println("  " + allValuesJoined);
        }

        // 4. Перемножить все ключи, у которых длина строки > 5
        long product = 1;
        boolean found = false;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > 5) {
                product *= entry.getKey();
                found = true;
            }
        }
        if (found) {
            System.out.println("\nПроизведение ключей, у которых длина строки > 5:");
            System.out.println("  product = " + product);
        } else {
            System.out.println("\nНет ни одной строки длины более 5, для которой нужно перемножить ключи.");
        }
    }
}
