package Timus.example_1592;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class example_1592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        final int PERIOD = 12 * 3600; // 43200 секунд
        int[] count = new int[PERIOD];
        long sumA = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().trim().split(":");
            int h = Integer.parseInt(parts[0]) % 12;
            int m = Integer.parseInt(parts[1]);
            int s = Integer.parseInt(parts[2]);
            int sec = h * 3600 + m * 60 + s;
            count[sec]++;
            sumA += sec;
        }

        // префиксная сумма по count
        int[] prefix = new int[PERIOD];
        prefix[0] = count[0];
        for (int t = 1; t < PERIOD; t++) {
            prefix[t] = prefix[t - 1] + count[t];
        }

        // f(T) = N*T + PERIOD*(N - prefix[T])  (минимизировать)
        long bestCost = Long.MAX_VALUE;
        int bestT = 0;
        for (int T = 0; T < PERIOD; T++) {
            long cost = (long)n * T + (long)PERIOD * (n - prefix[T]);
            if (cost < bestCost) {
                bestCost = cost;
                bestT = T;
            }
        }

        int hh = (bestT / 3600) % 12;
        if (hh == 0) hh = 12;
        int mm = (bestT % 3600) / 60;
        int ss = bestT % 60;
        System.out.printf("%d:%02d:%02d%n", hh, mm, ss);
    }
}
