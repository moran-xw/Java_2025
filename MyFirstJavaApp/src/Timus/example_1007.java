package Timus.example_1007;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class example_1007 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Введите N (длину оригинального кода): ");
        String line;
        int N = 0;  // инициализируем здесь
        while ((line = in.readLine()) != null) {
            line = line.trim();
            if (!line.isEmpty()) {
                N = Integer.parseInt(line);
                break;
            }
        }
        int mod = N + 1;

        System.out.println("Теперь вводите закодированные строки (по одной на строку):");
        while ((line = in.readLine()) != null) {
            String w = line.trim();
            if (w.isEmpty()) continue;

            int L = w.length();
            if (L == N) {
                System.out.println("Обрабатываем строку длины N = " + N + ":");
                int sum = 0;
                for (int i = 0; i < N; i++) {
                    if (w.charAt(i) == '1') sum += (i + 1);
                }
                int r = sum % mod;
                if (r == 0) {
                    System.out.println("Корректная строка: " + w);
                } else {
                    StringBuilder sb = new StringBuilder(w);
                    sb.setCharAt(r - 1, '0');
                    System.out.println("Исправленная строка (сброс бита в позиции " + r + "): " + sb);
                }

            } else if (L == N - 1) {
                System.out.println("Обрабатываем строку длины N-1 = " + L + ":");
                int s0 = 0;
                int[] cntSuffix = new int[N + 2];
                int ones = 0;
                for (int i = L - 1; i >= 0; i--) {
                    if (w.charAt(i) == '1') {
                        ones++;
                        s0 += (i + 1);
                    }
                    cntSuffix[i + 1] = ones;
                }
                for (int k = 1; k <= N; k++) {
                    int s = s0 + cntSuffix[k];
                    if (s % mod == 0) {
                        System.out.println("Вставляем '0' на позицию " + k + ": " +
                                w.substring(0, k - 1) + '0' + w.substring(k - 1));
                        break;
                    } else if ((s + k) % mod == 0) {
                        System.out.println("Вставляем '1' на позицию " + k + ": " +
                                w.substring(0, k - 1) + '1' + w.substring(k - 1));
                        break;
                    }
                }

            } else if (L == N + 1) {
                System.out.println("Обрабатываем строку длины N+1 = " + L + ":");
                for (int k = 0; k < L; k++) {
                    String cand = w.substring(0, k) + w.substring(k + 1);
                    int sum = 0;
                    for (int i = 0; i < N; i++) {
                        if (cand.charAt(i) == '1') sum += (i + 1);
                    }
                    if (sum % mod == 0) {
                        System.out.println("Удаляем символ на позиции " + (k + 1) + ": " + cand);
                        break;
                    }
                }

            } else {
                System.out.println("Ошибка: длина строки " + L +
                        " не равна N, N-1 или N+1");
            }
        }
    }
}
