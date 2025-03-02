package lr1;

import java.util.Scanner;

public class Example14 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите любое число: ");
        int f1 = in.nextInt();
        int f2 = f1 - 1;
        int f3 = f1 + 1;
        int f4 = (f1+f2+f3) * (f1+f2+f3);

        System.out.println(f2 + " " + f1 + " " + f3 + " " + f4);
        in.close();
    }
}
