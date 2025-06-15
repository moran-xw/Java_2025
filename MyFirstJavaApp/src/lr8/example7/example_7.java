package lr8.example7;

import java.io.FileWriter;
import java.io.IOException;

public class example_7 {
    public static void main(String[] args) {
        // Заголовки столбцов
        String[] header = { "Товар", "Характеристики", "Стоимость" };
        // Данные
        String[][] data = {
                { "Книга",     "Жанр: Фантастика; Автор: Иванов И. И.", "500.0"  },
                { "Компьютер", "Процессор: Intel Core i5; ОЗУ: 8 ГБ",    "25000.0"}
        };

        String csvPath = "src/lr8/example7/example7.xlsx";

        try (FileWriter fw = new FileWriter(csvPath)) {
            // Записываем заголовок
            writeRow(fw, header);

            // Записываем данные
            for (String[] row : data) {
                writeRow(fw, row);
            }

            System.out.println("Данные сохранены в xlsx: " + csvPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Пишет одну строку CSV, экранируя кавычки
    private static void writeRow(FileWriter fw, String[] cols) throws IOException {
        for (int i = 0; i < cols.length; i++) {
            String cell = cols[i].replace("\"", "\"\""); // экранируем двойные кавычки
            fw.write("\"" + cell + "\"" + (i + 1 < cols.length ? "," : ""));
        }
        fw.write("\n");
    }
}
