package lr4;

public class listing_5 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");
        } catch (RuntimeException e) {  // Исправлена ошибка
            System.out.println("3 " + e);
        }
        System.out.println("2");
    }
}