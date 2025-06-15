package lr8.example7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class example_8 {
    public static void main(String[] args) {
        String csvPath = "src/lr8/example7/example7.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // простой CSV-парсер: разделяем по запятым вне кавычек
                String[] fields = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                for (int i = 0; i < fields.length; i++) {
                    String cell = fields[i];
                    // убираем обрамляющие кавычки и экранирование
                    if (cell.startsWith("\"") && cell.endsWith("\"")) {
                        cell = cell.substring(1, cell.length() - 1).replace("\"\"", "\"");
                    }
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
