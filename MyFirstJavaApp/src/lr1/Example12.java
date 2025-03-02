package lr1;

import java.util.Scanner;

public class Example12 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите свой возраст: ");
        int age = in.nextInt();
        int year = 2025 - age;

        System.out.println("Ваш год рождения: " + year);
        in.close();
    }
}
