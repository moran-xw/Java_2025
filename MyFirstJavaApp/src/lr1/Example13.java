package lr1;

import java.util.Scanner;

public class Example13 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите 1-ое чилсо: ");
        int f1 = in.nextInt();

        System.out.println("Введите 2-ое число: ");
        int f2 = in.nextInt();
        int summa = f1+f2;

        System.out.println("Сумма: " + summa);
        in.close();
    }
}
