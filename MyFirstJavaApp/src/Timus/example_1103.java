package Timus.example_1103;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class example_1103 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine().trim());
        int[][] pts = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            pts[i][0] = Integer.parseInt(st.nextToken());
            pts[i][1] = Integer.parseInt(st.nextToken());
        }
        int target = (N - 3) / 2;
        outer:
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    double x1 = pts[i][0], y1 = pts[i][1];
                    double x2 = pts[j][0], y2 = pts[j][1];
                    double x3 = pts[k][0], y3 = pts[k][1];
                    double D = 2*(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2));
                    if (Math.abs(D) < 1e-9) continue;
                    double ux = ((x1*x1+y1*y1)*(y2-y3)
                            + (x2*x2+y2*y2)*(y3-y1)
                            + (x3*x3+y3*y3)*(y1-y2)) / D;
                    double uy = ((x1*x1+y1*y1)*(x3-x2)
                            + (x2*x2+y2*y2)*(x1-x3)
                            + (x3*x3+y3*y3)*(x2-x1)) / D;
                    double r2 = (x1-ux)*(x1-ux)+(y1-uy)*(y1-uy);
                    int inside = 0;
                    for (int m = 0; m < N; m++) {
                        double dx = pts[m][0]-ux, dy = pts[m][1]-uy;
                        if (dx*dx+dy*dy < r2-1e-9) inside++;
                    }
                    if (inside == target) {
                        System.out.printf(
                                "%d %d%n%d %d%n%d %d%n",
                                pts[i][0], pts[i][1],
                                pts[j][0], pts[j][1],
                                pts[k][0], pts[k][1]
                        );
                        break outer;
                    }
                }
            }
        }
    }
}
