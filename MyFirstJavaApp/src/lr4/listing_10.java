package lr4;

public class listing_10 {
    public static int m() {
        try {
            System.out.println("0");
            return 55;
        } finally {
            System.out.println("1");
            return 20;
        }
    }
    public static void main(String[] args) {
        System.out.println(m());
    }
}