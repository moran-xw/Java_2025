package lr6;

public class example_4 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            final int threadId = i;
            new Thread(() -> System.out.println("Поток №" + threadId)).start();
        }
    }
}

