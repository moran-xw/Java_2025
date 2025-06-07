package lr7.listing1;

import java.io.File;
import java.io.IOException;

public class listing_1 {
    public static void main(String[] args) {
        File folder = new File("src/lr7/listing1/example_folder");
        if (!folder.exists()) {
            if (folder.mkdir()) {
                System.out.println("Папка создана: " + folder.getAbsolutePath());
            } else {
                System.out.println("Не удалось создать папку: " + folder.getAbsolutePath());
            }
        } else {
            System.out.println("Папка уже существует: " + folder.getAbsolutePath());
        }

        File file = new File(folder.getAbsoluteFile() + File.separator + "example_file.txt");

        try {
            if (file.createNewFile()) {
                System.out.println("Файл создан: " + file.getAbsolutePath());
            } else {
                System.out.println("Не удалось создать файл: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла: " + e.getMessage());
        }

        if (folder.delete()) {
            System.out.println("Папка удалена: " + file.getAbsolutePath());
        } else {
            System.out.println("Не удалось удалить папку: " + folder.getAbsolutePath());
        }
    }
}