package Timus.example_1480;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class example_1480 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine().trim());
        int[][] a = new int[N][N];
        int total = N * N;

        // Разбиваем клетки на два "цвета" по (i+j)%2
        int small = 1, large = total;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((i + j) % 2 == 0) {
                    a[i][j] = small++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((i + j) % 2 != 0) {
                    a[i][j] = large--;
                }
            }
        }

        // Считаем максимум среди сумм соседних по стороне
        int maxSum = 0;
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    int ni = i + dx[k], nj = j + dy[k];
                    if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
                        maxSum = Math.max(maxSum, a[i][j] + a[ni][nj]);
                    }
                }
            }
        }

        // Выводим минимально возможный максимум и саму таблицу
        System.out.println(maxSum);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(a[i][j] + (j + 1 < N ? " " : ""));
            }
            System.out.println();
        }
    }
}
