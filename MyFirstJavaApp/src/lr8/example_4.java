package lr8;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class example_4 {
    public static void main(String[] args) {
        String path = "src/lr8/example3/example3-json.json";
        try {
            String content = Files.readString(Paths.get(path), StandardCharsets.UTF_8);

            // Корневой элемент всегда "books"
            System.out.println("Корневой элемент: books");

            // Вырезаем всё между [...] после "books":
            int idx = content.indexOf("\"books\":");
            idx = content.indexOf('[', idx);
            int end = content.indexOf(']', idx);
            String arrayContent = content.substring(idx + 1, end).trim();

            // Разделяем на объекты по "},{" (мы уверены, что формат простой)
            String[] objects = arrayContent.split("\\},\\{");
            for (String obj : objects) {
                // Допиливаем края { } на первом и последнем
                obj = obj.replaceFirst("^\\{?", "").replaceFirst("\\}?$", "");

                String title  = extractValue(obj, "title");
                String author = extractValue(obj, "author");
                String year   = extractValue(obj, "year");

                System.out.println("\nТекущий элемент: book");
                System.out.println("Название книги: " + title);
                System.out.println("Автор: " + author);
                System.out.println("Год издания: " + year);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Вырезает "ключ":"значение" или "ключ":значение (без кавычек у числа)
    private static String extractValue(String src, String key) {
        String pattern = "\"" + key + "\":";
        int p = src.indexOf(pattern);
        if (p < 0) return "";
        p += pattern.length();
        char c = src.charAt(p);
        if (c == '\"') {
            // строковое значение
            int start = p + 1;
            int end = src.indexOf('\"', start);
            return src.substring(start, end);
        } else {
            // числовое, до запятой или конца
            int start = p;
            int end = start;
            while (end < src.length() && Character.isDigit(src.charAt(end))) {
                end++;
            }
            return src.substring(start, end);
        }
    }
}
