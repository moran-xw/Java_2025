package lr5;

import java.util.List;

public class example_6 {
    public static List<String> filterListSubString(List<String> strings, String subString) {
        return strings.stream().filter(x -> x.trim().contains(subString)).toList();
    }

    public static void main(String[] args) {
        String string = "Напишите функцию, которая принимает на вход список строк и " +
                "возвращает новый список, содержащий только те строки, которые содержат " +
                "заданную подстроку.";
        List<String> strings = List.of(string.split(" "));
        String subString = "котор";

        System.out.println("Строка после сплитования: " + "\n");
        for (String e : strings) {
            System.out.println(e);
        }

        List<String> stringsAfter = filterListSubString(strings, subString);

        System.out.println("\n" + "Строка после преобразования: " + "\n");
        for (String e : stringsAfter) {
            System.out.println(e);
        }

    }
}