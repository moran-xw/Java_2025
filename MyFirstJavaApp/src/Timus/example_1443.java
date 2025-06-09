package Timus.example_1443;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class example_1443 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите число колей N: ");
        int N = Integer.parseInt(in.readLine().trim());
        System.out.print("Введите длину пути S (в метрах): ");
        double S = Double.parseDouble(in.readLine().trim());
        System.out.print("Введите длину одного рельса L (в метрах): ");
        double L = Double.parseDouble(in.readLine().trim());

        // сколько целых кусков длины L укладывается на одной колее
        long d = (long) Math.floor(S / L + 1e-12);
        // остаток длины
        double R = S - d * L;

        long rails;
        if (R < 1e-12) {
            // без остатка: на каждой колее d кусков, всего N*d рельсов
            rails = N * d;
        } else {
            // на каждой колее d длинных + 1 остаточный кусок
            // остаточные куски длины R можно резать из рельсов:
            // на один рельс длины L поместится floor(L / R) таких кусков
            int cap = (int) Math.floor(L / R + 1e-12);
            // сколько рельсов нужно, чтобы получить N остаточных кусков:
            long railsForR = (N + cap - 1) / cap;
            rails = N * d + railsForR;
        }

        System.out.println("Минимальное число рельсов: " + rails);
    }
}
