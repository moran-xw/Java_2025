package lr1;

import java.util.Scanner;

public class Example9 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите месяц: ");
        String month = in.nextLine();

        System.out.println("Введите количесвто дней в этом мясяце: ");
        int days = in.nextInt();

        System.out.println("В данноми месяце - " + month + ", " + days + " " + "дней.");
        in.close();
    }
}
