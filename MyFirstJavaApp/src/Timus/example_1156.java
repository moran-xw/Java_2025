package Timus.example_1156;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class example_1156 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = 2 * N;

        List<Integer>[] adj = new List[T+1];
        for (int i = 1; i <= T; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        int[] color = new int[T+1];
        Arrays.fill(color, -1);
        List<int[]> comps = new ArrayList<>();
        List<List<Integer>> part0 = new ArrayList<>();
        List<List<Integer>> part1 = new ArrayList<>();

        for (int i = 1; i <= T; i++) {
            if (color[i] != -1) continue;
            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);
            color[i] = 0;
            List<Integer> c0 = new ArrayList<>();
            List<Integer> c1 = new ArrayList<>();
            c0.add(i);
            boolean ok = true;
            while (!q.isEmpty() && ok) {
                int u = q.poll();
                for (int v : adj[u]) {
                    if (color[v] == -1) {
                        color[v] = color[u] ^ 1;
                        if (color[v] == 0) c0.add(v);
                        else c1.add(v);
                        q.add(v);
                    } else if (color[v] == color[u]) {
                        ok = false;
                        break;
                    }
                }
            }
            if (!ok) {
                System.out.println("IMPOSSIBLE");
                return;
            }
            comps.add(new int[]{c0.size(), c1.size()});
            part0.add(c0);
            part1.add(c1);
        }

        int K = comps.size();
        boolean[][] dp = new boolean[K+1][N+1];
        dp[0][0] = true;
        for (int i = 0; i < K; i++) {
            int a = comps.get(i)[0], b = comps.get(i)[1];
            for (int s = 0; s <= N; s++) {
                if (!dp[i][s]) continue;
                if (s + a <= N) dp[i+1][s+a] = true;
                if (s + b <= N) dp[i+1][s+b] = true;
            }
        }
        if (!dp[K][N]) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        boolean[] choose0 = new boolean[K];
        int cur = N;
        for (int i = K; i > 0; i--) {
            int a = comps.get(i-1)[0], b = comps.get(i-1)[1];
            if (cur >= a && dp[i-1][cur-a]) {
                choose0[i-1] = true;
                cur -= a;
            } else {
                choose0[i-1] = false;
                cur -= b;
            }
        }

        List<Integer> tour1 = new ArrayList<>();
        List<Integer> tour2 = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            if (choose0[i]) {
                tour1.addAll(part0.get(i));
                tour2.addAll(part1.get(i));
            } else {
                tour1.addAll(part1.get(i));
                tour2.addAll(part0.get(i));
            }
        }

        Collections.sort(tour1);
        Collections.sort(tour2);

        for (int i = 0; i < N; i++) {
            if (i > 0) System.out.print(' ');
            System.out.print(tour1.get(i));
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            if (i > 0) System.out.print(' ');
            System.out.print(tour2.get(i));
        }
        System.out.println();
    }
}
