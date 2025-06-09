package Timus.example_1607;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class example_1607 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите a, b, c, d (через пробел): ");
        StringTokenizer st = new StringTokenizer(in.readLine().trim());
        int a = Integer.parseInt(st.nextToken()); // стартовая цена Петя
        int b = Integer.parseInt(st.nextToken()); // надбавка Петя
        int c = Integer.parseInt(st.nextToken()); // стартовая цена такси
        int d = Integer.parseInt(st.nextToken()); // скидка такси

        // ведём переговоры, пока предложение Петя < предложение такси
        while (a < c) {
            a += b;          // Петя повышает свой предложенный тариф
            if (a >= c) break;
            c -= d;          // таксист снижает свой тариф
        }

        System.out.println("Итоговая согласованная цена: " + a);
    }
}
