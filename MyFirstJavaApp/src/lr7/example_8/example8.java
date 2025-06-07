package lr7.example_8;

import java.io.*;
import java.util.Scanner;

public class example8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Создание объекта Person");
        Person person = new Person("Ivan Ivanov", 30, "Ivan@mail.ru");

        System.out.print("Введите имя файла для сохранения объекта: ");
        String fileName = scanner.nextLine();

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(person);
            System.out.println("Объект успешно сохранен в файл '" + fileName + "'");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении объекта: " + e.getMessage());
            scanner.close();
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Person restoredPerson = (Person) ois.readObject();
            System.out.println("\nОбъект успешно восстановлен из файла");
            System.out.println("Данные восстановленного объекта:");
            System.out.println(restoredPerson);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при восстановлении объекта: " + e.getMessage());
        }

        scanner.close();
    }
}