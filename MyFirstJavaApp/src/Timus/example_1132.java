package Timus.example_1132;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class example_1132 {
    // a^e mod m
    static long modPow(long a, long e, long m) {
        long res = 1;
        a %= m;
        while (e > 0) {
            if ((e & 1) == 1) res = (res * a) % m;
            a = (a * a) % m;
            e >>= 1;
        }
        return res;
    }

    // Tonelli-Shanks: finds a square root of 'a' mod prime 'p', or -1 if none
    static long modSqrt(long a, long p) {
        if (a == 0) return 0;
        if (p == 2) return a;
        if (modPow(a, (p - 1) / 2, p) != 1) return -1;  // no root

        // write p-1 = q * 2^s, q odd
        long q = p - 1;
        int s = 0;
        while ((q & 1) == 0) {
            q >>= 1;
            s++;
        }

        if (s == 1) {
            // p ≡ 3 mod 4
            return modPow(a, (p + 1) / 4, p);
        }

        // find z, quadratic non-residue mod p
        long z = 2;
        while (modPow(z, (p - 1) / 2, p) != p - 1) {
            z++;
        }

        long c = modPow(z, q, p);
        long x = modPow(a, (q + 1) / 2, p);
        long t = modPow(a, q, p);
        int m = s;

        while (t != 1) {
            long tt = t;
            int i = 0;
            while (tt != 1) {
                tt = (tt * tt) % p;
                i++;
                if (i == m) return -1;
            }
            long b = modPow(c, 1L << (m - i - 1), p);
            x = (x * b) % p;
            c = (b * b) % p;
            t = (t * c) % p;
            m = i;
        }
        return x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(in.readLine().trim());
        StringBuilder out = new StringBuilder();
        for (int ti = 0; ti < K; ti++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            long a = Long.parseLong(st.nextToken());
            long p = Long.parseLong(st.nextToken());
            long r = modSqrt(a % p, p);
            if (r < 0) {
                out.append("No root\n");
            } else {
                long r2 = p - r;
                if (r2 == r) {
                    out.append(r).append('\n');
                } else {
                    long lo = Math.min(r, r2);
                    long hi = Math.max(r, r2);
                    out.append(lo).append(' ').append(hi).append('\n');
                }
            }
        }
        System.out.print(out);
    }
}
