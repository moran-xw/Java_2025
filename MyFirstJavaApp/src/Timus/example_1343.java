package Timus.example_1343;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;

public class example_1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Введите длину уже заданного префикса (k): ");
        int k = Integer.parseInt(in.readLine().trim());

        System.out.print("Введите префикс (k цифр): ");
        String prefix = in.readLine().trim();
        int rem = 12 - k;

        long prefixVal = Long.parseLong(prefix);
        long pow = 1;
        for (int i = 0; i < rem; i++) {
            pow *= 10;
        }
        long base = prefixVal * pow;

        long result = -1;
        // пробуем только нечетные суффиксы, пропускаем те, что заканчиваются на 5
        for (long suf = 1; suf < pow; suf += 2) {
            if (suf % 10 == 5) continue;
            long candidate = base + suf;
            if (BigInteger.valueOf(candidate).isProbablePrime(10)) {
                result = candidate;
                break;
            }
        }

        if (result > 0) {
            System.out.println("Найден 12-значный простой: " + result);
        } else {
            System.out.println("Решение не найдено");
        }
    }
}
