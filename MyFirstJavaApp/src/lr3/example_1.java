package lr3;

public class example_1 {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация примеров 1–5 из раздела 1 ===\n");

        System.out.println("----- Пример 1 (listing_1) -----");
        listing_1.m(1);
        System.out.println("\n\n----- Пример 2 (listing_2) -----");
        listing_2.m(1);

        System.out.println("\n\n----- Пример 3 (listing_3) -----");
        listing_3.m(1);

        System.out.println("\n\n----- Пример 4 (listing_4) -----");
        System.out.println("Факториал 5 = " + listing_4.fact(5));


        System.out.println("\n\n----- Пример 5 (listing_5) -----");

        System.out.println("listing_5.fact(5) = " + listing_5.fact(5));


        System.out.println("\n=== Все примеры завершены ===");
    }
}
