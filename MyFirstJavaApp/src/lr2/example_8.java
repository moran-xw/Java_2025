// example_8.java

// Базовый класс Animal (животное)
class Animal {
    // Общие поля для всех животных
    private String name;
    private int age;

    /**
     * Конструктор Animal
     * @param name имя животного
     * @param age  возраст животного (в годах)
     */
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Геттеры и сеттеры для имени и возраста
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        this.age = age;
    }

    /**
     * Метод, который все потомки должны переопределить,
     * чтобы издать характерный для них звук.
     */
    public void makeSound() {
        System.out.println(name + " издает звук (неопределенный звук).");
    }

    @Override
    public String toString() {
        return "Animal { name = '" + name + "', age = " + age + " }";
    }
}

// Класс Dog (собака), наследует Animal, добавляет поле breed
class Dog extends Animal {
    private String breed; // порода собаки

    /**
     * Конструктор Dog
     * @param name  имя собаки
     * @param age   возраст собаки
     * @param breed порода собаки
     */
    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    // Геттер и сеттер для породы
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * Переопределяем makeSound() для собаки
     */
    @Override
    public void makeSound() {
        System.out.println(getName() + " (собака породы " + breed + ") говорит: Гав-гав!");
    }

    /**
     * Специальный метод для собак — например, команда «апорт».
     */
    public void fetch() {
        System.out.println(getName() + " приносит вам мячик!");
    }

    @Override
    public String toString() {
        return "Dog { name = '" + getName() + "', age = " + getAge() + ", breed = '" + breed + "' }";
    }
}

// Класс Cat (кот), наследует Animal, добавляет поле favoriteFood
class Cat extends Animal {
    private String favoriteFood; // любимая еда кота

    /**
     * Конструктор Cat
     * @param name         имя кота
     * @param age          возраст кота
     * @param favoriteFood любимая еда кота
     */
    public Cat(String name, int age, String favoriteFood) {
        super(name, age);
        this.favoriteFood = favoriteFood;
    }

    // Геттер и сеттер для любимой еды
    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    /**
     * Переопределяем makeSound() для кота
     */
    @Override
    public void makeSound() {
        System.out.println(getName() + " (кот) говорит: Мяу!");
    }

    /**
     * Специальный метод для кота — показывает, что он ест
     */
    public void eat() {
        System.out.println(getName() + " ест свою любимую еду: " + favoriteFood + ".");
    }

    @Override
    public String toString() {
        return "Cat { name = '" + getName() + "', age = " + getAge() + ", favoriteFood = '" + favoriteFood + "' }";
    }
}

// Класс Bird (птица), наследует Animal, добавляет поле canFly
class Bird extends Animal {
    private boolean canFly; // может ли птица летать
    private String species; // вид птицы

    /**
     * Конструктор Bird
     * @param name    имя птицы
     * @param age     возраст птицы
     * @param species вид или порода птицы
     * @param canFly  может ли птица летать (true/false)
     */
    public Bird(String name, int age, String species, boolean canFly) {
        super(name, age);
        this.species = species;
        this.canFly = canFly;
    }

    // Геттеры и сеттеры для поля canFly и species
    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * Переопределяем makeSound() для птицы
     */
    @Override
    public void makeSound() {
        System.out.println(getName() + " (птица-\"" + species + "\") издает звуки: Чирик-чирик!");
    }

    /**
     * Специальный метод, показывающий, может ли птица летать
     */
    public void fly() {
        if (canFly) {
            System.out.println(getName() + " летит в небе!");
        } else {
            System.out.println(getName() + " не может летать.");
        }
    }

    @Override
    public String toString() {
        return "Bird { name = '" + getName() + "', age = " + getAge() +
                ", species = '" + species + "', canFly = " + canFly + " }";
    }
}

// Публичный класс example_8 с методом main для демонстрации работы иерархии Animal
public class example_8 {
    public static void main(String[] args) {
        System.out.println("=== Пример работы с классами Animal, Dog, Cat, Bird ===\n");

        // 1. Создаём объект Dog
        Dog dog = new Dog("Рекс", 3, "Немецкая овчарка");
        System.out.println(dog.toString());
        dog.makeSound();
        dog.fetch();
        System.out.println();

        // 2. Создаём объект Cat
        Cat cat = new Cat("Мурка", 2, "Корм Whiskas");
        System.out.println(cat.toString());
        cat.makeSound();
        cat.eat();
        System.out.println();

        // 3. Создаём объект Bird (птица, которая умеет летать)
        Bird sparrow = new Bird("Семка", 1, "Воробей", true);
        System.out.println(sparrow.toString());
        sparrow.makeSound();
        sparrow.fly();
        System.out.println();

        // 4. Создаём объект Bird (птица, которая НЕ может летать)
        Bird penguin = new Bird("Пингвин", 5, "Пингвин", false);
        System.out.println(penguin.toString());
        penguin.makeSound();
        penguin.fly();
        System.out.println();

        // 5. Показываем смену имени и возраста у животных
        System.out.println("=== Меняем возраст и имя животных ===");
        dog.setName("Шарик");
        dog.setAge(4);
        cat.setName("Барсик");
        cat.setAge(3);
        System.out.println("Новый питомец: " + dog);
        System.out.println("Новый питомец: " + cat);

        System.out.println("\n=== Демонстрация завершена ===");
    }
}
