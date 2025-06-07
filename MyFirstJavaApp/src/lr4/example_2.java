package lr4;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class example_2 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int[][] matrix = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9},
                    {10, 11, 12},
                    {13, 14, 15},
                    {16, 17, 18},
                    {19, 20, 21}
            };
            System.out.println("Введите номер столбца: ");
            int numberColumn = in.nextInt();
            int[] arr = matrix[numberColumn];

            System.out.println(Arrays.toString(arr));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: нет столбца с таким номером");
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: ввод строки вместо числа");
        }
    }
}
