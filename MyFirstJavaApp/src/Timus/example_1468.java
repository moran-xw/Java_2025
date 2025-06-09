package Timus.example_1468;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class example_1468 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = in.readLine().trim();
            if (line.equals("0 0")) break;
            String[] parts = line.split("\\s+");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            int k = Integer.parseInt(parts[2]);

            StringBuilder result = new StringBuilder();
            int integerPart = a / b;
            int rem = a % b;

            // digits for bases up to 36
            char[] digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
            // integer part
            result.append(toBase(integerPart, k, digits));

            if (rem != 0) {
                result.append('.');
                // map remainder → position in result
                Map<Integer,Integer> seen = new HashMap<>();
                StringBuilder frac = new StringBuilder();
                int pos = 0;
                while (rem != 0 && !seen.containsKey(rem)) {
                    seen.put(rem, pos++);
                    rem *= k;
                    int d = rem / b;
                    frac.append(digits[d]);
                    rem %= b;
                }
                if (rem == 0) {
                    // terminate cleanly
                    result.append(frac);
                } else {
                    // repeat detected
                    int start = seen.get(rem);
                    result.append(frac.substring(0, start));
                    result.append('(')
                            .append(frac.substring(start))
                            .append(')');
                }
            }

            System.out.println(result);
        }
    }

    // converts a non-negative integer to base-k string
    private static String toBase(int value, int base, char[] digits) {
        if (value == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (value > 0) {
            sb.append(digits[value % base]);
            value /= base;
        }
        return sb.reverse().toString();
    }
}
