package lr2;

// Интерфейс Shape (определяет методы для вычисления площади и периметра)
interface Shape {
    /**
     * Метод для вычисления площади фигуры.
     * @return площадь (double)
     */
    double calculateArea();

    /**
     * Метод для вычисления периметра фигуры.
     * @return периметр (double)
     */
    double calculatePerimeter();
}

// Класс Circle, реализующий Shape
class Circle implements Shape {
    // Поле: радиус круга
    private double radius;

    /**
     * Конструктор круга.
     * @param radius радиус (должен быть > 0)
     */
    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть положительным числом");
        }
        this.radius = radius;
    }

    // Геттер для радиуса
    public double getRadius() {
        return radius;
    }

    // Сеттер для радиуса (с проверкой)
    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть положительным числом");
        }
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle { radius = " + radius + " }";
    }
}

// Класс Square, реализующий Shape
class Square implements Shape {
    // Поле: длина стороны квадрата
    private double side;

    /**
     * Конструктор квадрата.
     * @param side длина стороны (должна быть > 0)
     */
    public Square(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Сторона квадрата должна быть положительным числом");
        }
        this.side = side;
    }

    // Геттер для стороны
    public double getSide() {
        return side;
    }

    // Сеттер для стороны (с проверкой)
    public void setSide(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Сторона квадрата должна быть положительным числом");
        }
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }

    @Override
    public String toString() {
        return "Square { side = " + side + " }";
    }
}

// Класс Triangle, реализующий Shape (по трём сторонам, формула Герона)
class Triangle implements Shape {
    // Поля: длины трёх сторон треугольника
    private double a;
    private double b;
    private double c;

    /**
     * Конструктор треугольника.
     * @param a длина первой стороны (> 0)
     * @param b длина второй стороны (> 0)
     * @param c длина третьей стороны (> 0)
     * @throws IllegalArgumentException, если хотя бы одна сторона <= 0
     *                                  или если стороны не могут образовать треугольник
     */
    public Triangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Все стороны треугольника должны быть положительными числами");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Сумма любых двух сторон должна быть больше третьей");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Геттеры для сторон
    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    // Сеттеры для сторон (с проверкой тех же условий)
    public void setA(double a) {
        if (a <= 0) {
            throw new IllegalArgumentException("Сторона должна быть положительным числом");
        }
        if (a + b <= c || b + c <= a || a + c <= b) {
            throw new IllegalArgumentException("Не выполняется неравенство треугольника после изменения стороны");
        }
        this.a = a;
    }

    public void setB(double b) {
        if (b <= 0) {
            throw new IllegalArgumentException("Сторона должна быть положительным числом");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Не выполняется неравенство треугольника после изменения стороны");
        }
        this.b = b;
    }

    public void setC(double c) {
        if (c <= 0) {
            throw new IllegalArgumentException("Сторона должна быть положительным числом");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Не выполняется неравенство треугольника после изменения стороны");
        }
        this.c = c;
    }

    @Override
    public double calculateArea() {
        // Полупериметр (формула Герона)
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }

    @Override
    public String toString() {
        return "Triangle { a = " + a + ", b = " + b + ", c = " + c + " }";
    }
}

// Публичный класс с методом main — именно он будет запущен
public class example_6 {
    public static void main(String[] args) {
        System.out.println("=== Пример работы с фигурами ===\n");

        // 1. Круг с радиусом 4.5
        Circle circle = new Circle(4.5);
        System.out.println(circle);
        System.out.println("Area = " + circle.calculateArea());
        System.out.println("Perimeter = " + circle.calculatePerimeter());
        System.out.println();

        // 2. Квадрат со стороной 3.0
        Square square = new Square(3.0);
        System.out.println(square);
        System.out.println("Area = " + square.calculateArea());
        System.out.println("Perimeter = " + square.calculatePerimeter());
        System.out.println();

        // 3. Треугольник со сторонами 3.0, 4.0, 5.0
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        System.out.println(triangle);
        System.out.println("Area = " + triangle.calculateArea());
        System.out.println("Perimeter = " + triangle.calculatePerimeter());
        System.out.println();

        // Дополнительный тест: меняем сторону квадрата и пересчитываем
        square.setSide(5.5);
        System.out.println("После изменения стороны квадрата:");
        System.out.println(square);
        System.out.println("Новая площадь = " + square.calculateArea());
        System.out.println("Новый периметр = " + square.calculatePerimeter());
    }
}
