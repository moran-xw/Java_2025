package Timus.example_1197;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class example_1197 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Введите число тестов N (1–64): ");
        int T = Integer.parseInt(in.readLine().trim());

        int[][] deltas = {
                { 2,  1}, { 1,  2}, {-1,  2}, {-2,  1},
                {-2, -1}, {-1, -2}, { 1, -2}, { 2, -1}
        };

        for (int t = 0; t < T; t++) {
            System.out.print("Введите позицию коня (буква a–h и цифра 1–8), например e4: ");
            String pos = in.readLine().trim().toLowerCase();
            int x = pos.charAt(0) - 'a' + 1;
            int y = pos.charAt(1) - '0';

            int count = 0;
            for (int[] d : deltas) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx >= 1 && nx <= 8 && ny >= 1 && ny <= 8) {
                    count++;
                }
            }

            System.out.println("Количество доступных клеток: " + count);
        }
    }
}
