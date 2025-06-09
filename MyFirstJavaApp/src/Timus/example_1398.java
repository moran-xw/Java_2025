package Timus.example_1398;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class example_1398 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String bishopPos = in.readLine().trim();
        String pawnPos   = in.readLine().trim();
        int bx = bishopPos.charAt(0) - 'a' + 1;
        int by = bishopPos.charAt(1) - '0';
        int px = pawnPos.charAt(0) - 'a' + 1;
        int py = pawnPos.charAt(1) - '0';

        int movesToPromote = 8 - py;

        // 1) Может ли белый захватить пешку до продвижения?
        for (int i = 1; i <= movesToPromote; i++) {
            int pawnRow = py + (i - 1);
            if (Math.abs(bx - px) == Math.abs(by - pawnRow)) {
                System.out.println("WHITE");
                return;
            }
        }

        // 2) Может ли пешка оказаться заблокирована (DRAW)?
        // на k-том ходе чёрных пешка движется на row = py + k
        for (int k = 1; k <= movesToPromote; k++) {
            int blockRow = py + k;
            if (bx == px && by == blockRow) {
                System.out.println("DRAW");
                return;
            }
        }

        // 3) После продвижения пешки и её превращения — следующая очередь белых:
        // сможет ли слон захватить ферзя на (px,8)?
        if (Math.abs(bx - px) == Math.abs(by - 8)) {
            System.out.println("WHITE");
        } else {
            System.out.println("BLACK");
        }
    }
}
