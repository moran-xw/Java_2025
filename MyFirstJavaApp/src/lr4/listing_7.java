package lr4;

public class listing_7 {
    public static void main(String[] args) {
        try {
            try {
                System.out.println("0");
                throw new NullPointerException("ошибка");
            } catch (NullPointerException e) {
                System.out.println("1");
                throw new ArithmeticException();
            } catch (ArithmeticException e) {
                System.out.println("2");
            }
            System.out.println("3");
        } catch (ArithmeticException e) { // Исправлена ошибка
            System.out.println("4");
        }
    }
}