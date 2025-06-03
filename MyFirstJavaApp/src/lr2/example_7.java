package lr2;

// Интерфейс, определяющий базовые операции с банковским счётом
interface Account {
    /**
     * Метод для создания нового банковского счёта с начальным балансом.
     * @param initialBalance начальный баланс (>= 0)
     */
    void openAccount(double initialBalance);

    /**
     * Метод для депозита (пополнения) счёта.
     * @param amount сумма для пополнения (> 0)
     * @return true, если депозит прошёл успешно; false — если сумма некорректна
     */
    boolean deposit(double amount);

    /**
     * Метод для снятия денег со счёта.
     * @param amount сумма для снятия (> 0 и <= текущий баланс)
     * @return true, если снятие прошло успешно; false — если недостаточно средств или сумма некорректна
     */
    boolean withdraw(double amount);

    /**
     * Метод для получения текущего баланса счёта.
     * @return текущий баланс (>= 0)
     */
    double getBalance();
}

// Класс BankAccount, реализующий интерфейс Account
class BankAccount implements Account {
    // Поле для хранения текущего баланса
    private double balance;
    // Флаг, показывает, открыт ли счёт
    private boolean isOpen = false;

    @Override
    public void openAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным");
        }
        this.balance = initialBalance;
        this.isOpen = true;
        System.out.println("Счёт открыт с балансом: " + this.balance);
    }

    @Override
    public boolean deposit(double amount) {
        if (!isOpen) {
            System.out.println("Ошибка: счёт не открыт");
            return false;
        }
        if (amount <= 0) {
            System.out.println("Ошибка: сумма депозита должна быть больше нуля");
            return false;
        }
        balance += amount;
        System.out.println("Успешный депозит: +" + amount + ". Новый баланс: " + balance);
        return true;
    }

    @Override
    public boolean withdraw(double amount) {
        if (!isOpen) {
            System.out.println("Ошибка: счёт не открыт");
            return false;
        }
        if (amount <= 0) {
            System.out.println("Ошибка: сумма для снятия должна быть больше нуля");
            return false;
        }
        if (amount > balance) {
            System.out.println("Ошибка: недостаточно средств. Текущий баланс: " + balance);
            return false;
        }
        balance -= amount;
        System.out.println("Успешное снятие: -" + amount + ". Остаток: " + balance);
        return true;
    }

    @Override
    public double getBalance() {
        if (!isOpen) {
            System.out.println("Ошибка: счёт не открыт");
            return 0.0;
        }
        return balance;
    }
}

// Публичный класс example_7 с методом main для демонстрации работы
public class example_7 {
    public static void main(String[] args) {
        System.out.println("=== Начинаем работу с банковским счётом ===\n");

        // 1. Создаём объект BankAccount и открываем счёт с начальным балансом 1000.0
        BankAccount account = new BankAccount();
        account.openAccount(1000.0);
        System.out.println();

        // 2. Делаем несколько операций депозита
        account.deposit(500.0);
        account.deposit(-50.0);    // некорректный депозит
        System.out.println();

        // 3. Пробуем снять деньги
        account.withdraw(200.0);
        account.withdraw(2000.0);  // недостаточно средств
        account.withdraw(-100.0);  // некорректная сумма
        System.out.println();

        // 4. Проверяем текущий баланс
        System.out.println("Текущий баланс: " + account.getBalance());
        System.out.println();

        // 5. Если нужно, можно ещё раз пополнить и снять
        account.deposit(250.0);
        account.withdraw(300.0);
        System.out.println();

        // 6. Ещё раз выводим итоговый баланс
        System.out.println("Итоговый баланс: " + account.getBalance());
        System.out.println("\n=== Работа с банковским счётом завершена ===");
    }
}
