package Timus.example_1068;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class example_1068 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите целое число N (|N| ≤ 10000): ");
        String line = in.readLine().trim();
        int N = Integer.parseInt(line);

        long sum;
        if (N >= 1) {
            sum = (long) N * (N + 1) / 2;
        } else {
            int count = 1 - N + 1;               // число членов от N до 1
            sum = (long) (N + 1) * count / 2;    // (первый + последний) * count / 2
        }

        System.out.println("Результат: " + sum);
    }
}
