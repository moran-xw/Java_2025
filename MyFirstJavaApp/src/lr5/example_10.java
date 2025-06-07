package lr5;

import java.util.List;

public class example_10 {
    public static List<String> getListStringWithoutNumSymbols(List<String> strings) {
        return strings.stream().filter(x -> x.matches("[а-яА-Я]+")).toList();
    }

    public static void main(String[] args) {
        String string = "Напишите фун%кцию, которая прин2имает на вход список строк и~ " +
                "возвращает но12вый спи_сок, содерж!ащий толь8ко т@е строки, кот-орые содержат " +
                "только буквы (без цифр и+ символов).";
        List<String> strings = List.of(string.split(" "));

        System.out.println("Строка после сплитования: " + "\n");
        for (String e : strings) {
            System.out.println(e);
        }

        List<String> stringsAfter = getListStringWithoutNumSymbols(strings);

        System.out.println("\n" + "Строки, которые содержат только буквы: " + "\n");
        for (String e : stringsAfter) {
            System.out.println(e);
        }
    }
}