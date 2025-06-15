package lr8.task4;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.OLE2NotOfficeXmlFileException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class task_4 {
    // Путь к вашему файлу, лежащему в src/lr8/task4/example.xlsx
    private static final String EXCEL_PATH = "src/lr8/task4/example.xlsx";

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in, "UTF-8");
        boolean retry;
        do {
            retry = false;
            System.out.println("\n--- Чтение Excel-файла: " + EXCEL_PATH + " ---");
            try (FileInputStream fis = new FileInputStream(EXCEL_PATH);
                 Workbook wb = WorkbookFactory.create(fis)) {

                Sheet sheet;
                try {
                    // здесь ловим ситуацию, когда в книге нет листа с индексом 0
                    sheet = wb.getSheetAt(0);
                } catch (IllegalArgumentException iae) {
                    System.err.println("Ошибка: не найден лист с индексом 0.");
                    System.err.println("Причина: " + iae.getMessage());
                    System.err.println("Рекомендация: убедитесь, что в файле есть хотя бы один лист.");
                    retry = askRetry(console);
                    continue;
                }

                System.out.println("Найден лист: " + sheet.getSheetName());
                for (Row row : sheet) {
                    for (Cell cell : row) {
                        // выводим значение любой ячейки
                        System.out.print(
                                switch (cell.getCellType()) {
                                    case STRING  -> cell.getStringCellValue();
                                    case NUMERIC -> (DateUtil.isCellDateFormatted(cell)
                                            ? cell.getDateCellValue()
                                            : cell.getNumericCellValue());
                                    case BOOLEAN -> cell.getBooleanCellValue();
                                    default      -> "";
                                }
                        );
                        System.out.print("\t");
                    }
                    System.out.println();
                }

            } catch (FileNotFoundException e) {
                System.err.println("Файл не найден: " + e.getMessage());
                System.err.println("Рекомендация: проверьте, что путь указан относительно корня проекта и файл существует.");
                retry = askRetry(console);

            } catch (OLE2NotOfficeXmlFileException e) {
                System.err.println("Неправильный формат файла: " + e.getMessage());
                System.err.println("Рекомендация: убедитесь, что файл — корректный .xls или .xlsx Excel.");
                retry = askRetry(console);

            } catch (EncryptedDocumentException e) {
                System.err.println("Файл защищён паролем, невозможно прочитать без пароля.");
                // без retry, т.к. без пароля дальше нет смысла

            } catch (IOException e) {
                System.err.println("I/O ошибка при чтении: " + e.getMessage());
                System.err.println("Рекомендация: закройте файл в других приложениях или проверьте права доступа.");
                retry = askRetry(console);
            }
        } while (retry);

        console.close();
        System.out.println("Завершили работу.");
    }

    /**
     * Спрашивает у пользователя, хочет ли он попробовать ещё раз.
     * @return true, если пользователь ввёл 'y' или 'д', иначе false.
     */
    private static boolean askRetry(Scanner sc) {
        System.out.print("Попробовать ещё раз? (y/н): ");
        String answer = sc.nextLine().trim().toLowerCase();
        return answer.equals("y") || answer.equals("д");
    }
}
