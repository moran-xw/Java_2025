package lr8.example3;

import java.io.FileWriter;
import java.io.IOException;

public class example_3 {
    public static void main(String[] args) {
        // Данные книг
        String[][] books = {
                {"Война и мир",       "Лев Толстой",        "1869"},
                {"Мастер и Маргарита","Михаил Булгаков",    "1967"}
        };

        // Строим JSON
        StringBuilder sb = new StringBuilder();
        sb.append("{\"books\":[");
        for (int i = 0; i < books.length; i++) {
            String[] b = books[i];
            sb.append("{")
                    .append("\"title\":\"").append(escape(b[0])).append("\",")
                    .append("\"author\":\"").append(escape(b[1])).append("\",")
                    .append("\"year\":").append(b[2])
                    .append("}");
            if (i < books.length - 1) sb.append(",");
        }
        sb.append("]}");

        // Записываем в файл
        try (FileWriter file = new FileWriter("src/lr8/example3/example3-json.json")) {
            file.write(sb.toString());
            System.out.println("JSON файл успешно создан!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Экранируем кавычки и обратные слэши, если они вдруг появятся в тексте
    private static String escape(String s) {
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
