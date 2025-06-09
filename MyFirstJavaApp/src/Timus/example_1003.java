package Timus.example_1003;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class example_1003 {
    static class DSU {
        int[] parent, rank, parity;
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            parity = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        // find with path compression, track parity to root
        int find(int x) {
            if (parent[x] != x) {
                int p = parent[x];
                parent[x] = find(p);
                parity[x] ^= parity[p];
            }
            return parent[x];
        }
        // get parity from x to its root
        int getParity(int x) {
            find(x);
            return parity[x];
        }
        // union x and y with constraint: parity(x) ^ parity(y) = p
        // returns false if conflict
        boolean unite(int x, int y, int p) {
            int rx = find(x), ry = find(y);
            int px = getParity(x), py = getParity(y);
            if (rx == ry) {
                // check consistency
                return ((px ^ py) == p);
            }
            // attach smaller rank under larger
            if (rank[rx] < rank[ry]) {
                parent[rx] = ry;
                parity[rx] = px ^ py ^ p;
            } else {
                parent[ry] = rx;
                parity[ry] = px ^ py ^ p;
                if (rank[rx] == rank[ry]) rank[rx]++;
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Решение задачи Timus 1003 (Чётность).");
        while (true) {
            System.out.print("Введите N (или -1 для окончания): ");
            String line = in.readLine();
            if (line == null) return;
            int N = Integer.parseInt(line.trim());
            if (N < 0) break;

            System.out.print("Введите число вопросов Q: ");
            int Q = Integer.parseInt(in.readLine().trim());
            int[] L = new int[Q], R = new int[Q], P = new int[Q];
            List<Integer> coords = new ArrayList<>();
            coords.add(0);
            for (int i = 0; i < Q; i++) {
                System.out.print("Вопрос " + (i+1) + " (l r even/odd): ");
                StringTokenizer st = new StringTokenizer(in.readLine());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                String ans = st.nextToken();
                L[i] = l;  R[i] = r;
                P[i] = ans.equals("odd") ? 1 : 0;
                coords.add(l-1);
                coords.add(r);
            }
            // compress coordinates
            Collections.sort(coords);
            Map<Integer,Integer> cid = new HashMap<>();
            int idx = 0;
            for (int x : coords) {
                if (!cid.containsKey(x)) cid.put(x, idx++);
            }
            DSU dsu = new DSU(idx);
            int result = Q;
            for (int i = 0; i < Q; i++) {
                int u = cid.get(L[i]-1);
                int v = cid.get(R[i]);
                if (!dsu.unite(u, v, P[i])) {
                    result = i;
                    break;
                }
            }
            System.out.println("Ответ: первый противоречивый ответ — после вопроса № " + result);
        }
        System.out.println("Конец работы.");
    }
}
