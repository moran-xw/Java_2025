package Timus.example_1510;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class example_1510 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Введите количество банкнот N: ");
        int N = Integer.parseInt(in.readLine().trim());

        System.out.println("Введите " + N + " достоинств банкнот (по одному в строке):");
        int candidate = 0, count = 0;
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(in.readLine().trim());
            if (count == 0) {
                candidate = x;
                count = 1;
            } else if (candidate == x) {
                count++;
            } else {
                count--;
            }
        }

        System.out.println("Результат: " + candidate);
    }
}
