package Timus.example_1283;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class example_1283 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите три числа: начальное количество золота, порог и комиссию ЦГБ (%): ");
        StringTokenizer st = new StringTokenizer(in.readLine());
        long gold = Long.parseLong(st.nextToken());
        long threshold = Long.parseLong(st.nextToken());
        int commission = Integer.parseInt(st.nextToken());

        long years = 0;
        while (gold > threshold) {
            long fee = gold * commission / 100;
            gold -= fee;
            years++;
        }

        System.out.println("Гном проживет лет: " + years);
    }
}
