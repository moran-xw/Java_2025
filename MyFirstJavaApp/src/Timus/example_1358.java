package Timus.example_1358;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class example_1358 {
    static int N;
    static List<Integer>[] adj;
    static boolean[] used;
    static int[] order;  // entry order
    static int timer = 0;

    static void dfs(int u) {
        used[u] = true;
        order[u] = timer++;
        for (int v : adj[u]) {
            if (!used[v]) {
                dfs(v);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine().trim());
        adj = new List[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < N-1; i++) {
            String[] parts = in.readLine().trim().split("\\s+");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            adj[a].add(b);
            adj[b].add(a);
        }

        used = new boolean[N+1];
        order = new int[N+1];
        // run DFS from node 1 to get a valid planar numbering
        dfs(1);

        // radius so that coords fit |x|,|y| <= 1000
        double R = 900.0;
        // compute and print coordinates for vertices 1..N
        for (int i = 1; i <= N; i++) {
            double angle = 2 * Math.PI * order[i] / N;
            double x = R * Math.cos(angle);
            double y = R * Math.sin(angle);
            // prompt
            System.out.printf("Введите координаты для узла %d: ", i);
            // output
            System.out.printf(Locale.US, "%.6f %.6f%n", x, y);
        }
    }
}
