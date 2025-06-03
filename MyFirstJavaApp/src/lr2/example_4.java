package lr2;

public class example_4 {
    // Поля класса
    private String name;   // имя человека
    private int age;       // возраст человека
    private String gender; // пол человека

    // Конструктор
    public example_4(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Геттер для имени
    public String getName() {
        return name;
    }

    // Сеттер для имени
    public void setName(String name) {
        this.name = name;
    }

    // Геттер для возраста
    public int getAge() {
        return age;
    }

    // Сеттер для возраста (с проверкой на отрицательное значение)
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        this.age = age;
    }

    // Геттер для пола
    public String getGender() {
        return gender;
    }

    // Сеттер для пола
    public void setGender(String gender) {
        this.gender = gender;
    }

    // Переопределение toString() для удобного вывода
    @Override
    public String toString() {
        return "example_4 { " +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                " }";
    }

    // =========================================================
    // Теперь добавляем метод main, чтобы IDEA могла запустить пример
    // =========================================================
    public static void main(String[] args) {
        // Создадим объект example_4 и сразу распечатаем его параметры
        example_4 person = new example_4("Анна Иванова", 28, "Женский");

        // Выводим созданный объект через toString()
        System.out.println("Создан объект: " + person);

        // Демонстрация работы геттеров
        System.out.println("Имя: " + person.getName());
        System.out.println("Возраст: " + person.getAge());
        System.out.println("Пол: " + person.getGender());

        // Демонстрация работы сеттеров
        person.setAge(29);
        person.setName("Анна Петрова");
        System.out.println("После изменений: " + person);
    }
}

