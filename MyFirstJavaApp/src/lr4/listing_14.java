package lr4;

public class listing_14 {
    public static void m(int x)  throws ArithmeticException {
        int h = 10 / x;
    }

    public static void main(String[] args) {
        try {
            int l = args.length;
            System.out.println("размер массива= " + l);
            m(l);
        } catch (ArithmeticException e){
            System.out.println("Ошибка: деление на ноль");
        }
    }
}
