package Timus.example_1639;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class example_1639 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = in.readLine().trim().split("\\s+");
        int m = Integer.parseInt(parts[0]);
        int n = Integer.parseInt(parts[1]);

        int maxM = m;
        int maxN = n;
        int[][] g = new int[maxM + 1][maxN + 1];

        for (int i = 1; i <= maxM; i++) {
            for (int j = 1; j <= maxN; j++) {
                Set<Integer> mex = new HashSet<>();
                // vertical splits
                for (int x = 1; x < i; x++) {
                    mex.add(g[x][j] ^ g[i - x][j]);
                }
                // horizontal splits
                for (int y = 1; y < j; y++) {
                    mex.add(g[i][y] ^ g[i][j - y]);
                }
                int gr = 0;
                while (mex.contains(gr)) gr++;
                g[i][j] = gr;
            }
        }

        // if grundy != 0, first player wins
        boolean firstWins = g[m][n] != 0;
        String out = firstWins ? "[:=[first]]" : "[:=[second]]";
        System.out.println(out);
    }
}
