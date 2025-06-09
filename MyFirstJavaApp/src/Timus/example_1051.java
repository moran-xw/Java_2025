package Timus.example_1051;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class example_1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Введите два числа M и N (через пробел): ");
        StringTokenizer st = new StringTokenizer(in.readLine().trim());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int result;
        if (M == 1 && N == 1) {
            result = 1;
        } else if (M == 1 || N == 1) {
            // на одномерном ряду всегда остаётся ровно 2 камня (если их больше одного)
            result = 2;
        } else if ((M * N) % 2 == 1) {
            // на прямоугольнике с обеими размерами >1 и нечётным числом камней
            result = 1;
        } else {
            // на прямоугольнике с обеими размерами >1 и чётным числом камней
            result = 2;
        }

        System.out.println("Минимальное число оставшихся камней: " + result);
    }
}
