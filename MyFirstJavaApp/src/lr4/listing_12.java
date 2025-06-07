package lr4;

public class listing_12 {
    public static void m(String str, Double chislo) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("Строка введена неверно");
        }
        if (chislo > 0.001) {
            throw new IllegalArgumentException("Неверное число");
        }
    }

    public static void main(String[] args) {
        try {
            m(null, 0.000001);
        } catch (IllegalArgumentException e) { // Исправлена ошибка
            System.out.println(e);
        }
    }
}