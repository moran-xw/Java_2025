package lr2;

public class example_5 {
    public static void main(String[] args) {
        // Создаём прямоугольник с длиной = 5.0 и шириной = 3.0
        Rectangle rect = new Rectangle(5.0, 3.0);

        // Выводим информацию о прямоугольнике (toString)
        System.out.println("Создан объект: " + rect);

        // Вычисляем и выводим площадь и периметр
        double area = rect.calculateArea();
        double perimeter = rect.calculatePerimeter();
        System.out.println("Площадь = " + area);
        System.out.println("Периметр = " + perimeter);

        // Демонстрация работы геттеров
        System.out.println("\nТекущая длина: " + rect.getLength());
        System.out.println("Текущая ширина: " + rect.getWidth());

        // Изменим длину и ширину через сеттеры и снова выведем результаты
        rect.setLength(7.5);
        rect.setWidth(4.2);
        System.out.println("\nПосле изменения размеров:");
        System.out.println("Новый объект: " + rect);
        System.out.println("Новая площадь = " + rect.calculateArea());
        System.out.println("Новый периметр = " + rect.calculatePerimeter());
    }
}


