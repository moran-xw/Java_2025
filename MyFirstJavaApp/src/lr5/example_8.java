package lr5;

import java.util.List;
import java.util.Scanner;

public class example_8 {
    public static List<String> getListStringMoreNum(List<String> strings, int num) {
        return strings.stream().filter(x -> x.length() > num).toList();
    }

    public static void main(String[] args) {
        String string = "Напишите функцию, которая принимает на вход список строк и " +
                "возвращает новый список, содержащий только те строки, которые имеют " +
                "длину больше заданного значения.";
        List<String> strings = List.of(string.split(" "));
        Scanner in = new Scanner(System.in);

        System.out.println("Введите заданное число: ");
        int len = in.nextInt();

        System.out.println("Строка после сплитования: " + "\n");
        for (String e : strings) {
            System.out.println(e);
        }

        List<String> stringsAfter = getListStringMoreNum(strings, len);

        System.out.println("\n" + "Строки, которые имею длину больше заданного числа: " + "\n");
        for (String e : stringsAfter) {
            System.out.println(e);
        }
    }
}