package lr7.listing9;

import java.io.File;
import java.util.Scanner;

public class example_5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название файла: ");
        String fileName = in.nextLine();

        File file = new File(fileName);

        if (file.exists()) {
            long fileSize = file.length();
            System.out.println("Размер файла '" + fileName + "' составляет " + fileSize + " байт.");
        } else {
            System.out.println("Файл '" + fileName + "' не найден.");
        }

        in.close();
    }
}