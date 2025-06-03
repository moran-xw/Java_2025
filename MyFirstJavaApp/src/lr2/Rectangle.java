package lr2;

public class Rectangle {
    // Поля класса: длина и ширина прямоугольника
    private double length; // длина
    private double width;  // ширина

    /**
     * Конструктор с параметрами для создания прямоугольника.
     * @param length длина прямоугольника
     * @param width  ширина прямоугольника
     */
    public Rectangle(double length, double width) {
        // Проверяем, чтобы длина и ширина были положительными числами
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Длина и ширина должны быть положительными числами");
        }
        this.length = length;
        this.width = width;
    }

    // Геттер для длины
    public double getLength() {
        return length;
    }

    // Сеттер для длины (с проверкой, чтобы длина была > 0)
    public void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Длина должна быть положительным числом");
        }
        this.length = length;
    }

    // Геттер для ширины
    public double getWidth() {
        return width;
    }

    // Сеттер для ширины (с проверкой, чтобы ширина была > 0)
    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Ширина должна быть положительным числом");
        }
        this.width = width;
    }

    /**
     * Метод для вычисления площади прямоугольника.
     * Формула: площадь = длина * ширина
     * @return площадь (double)
     */
    public double calculateArea() {
        return length * width;
    }

    /**
     * Метод для вычисления периметра прямоугольника.
     * Формула: периметр = 2 * (длина + ширина)
     * @return периметр (double)
     */
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    /**
     * Переопределённый метод toString() для удобного вывода информации о прямоугольнике.
     */
    @Override
    public String toString() {
        return "Rectangle { length = " + length + ", width = " + width + " }";
    }
}

