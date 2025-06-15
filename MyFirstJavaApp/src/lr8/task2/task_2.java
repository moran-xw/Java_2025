package lr8.task2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Scanner;

public class task_2 {
    private static final String JSON_PATH = "src/lr8/task2/movies.json";
    private JSONObject root;
    private JSONArray  movies;

    @SuppressWarnings("unchecked")
    public task_2() throws Exception {
        // Читаем JSON
        JSONParser parser = new JSONParser();
        root   = (JSONObject) parser.parse(new FileReader(JSON_PATH));
        movies = (JSONArray) root.get("movies");
    }

    public static void main(String[] args) {
        try {
            new task_2().menuLoop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void menuLoop() throws Exception {
        Scanner sc = new Scanner(System.in, "UTF-8");
        while (true) {
            System.out.println("\n=== JSON Менеджер фильмов ===");
            System.out.println("1) Показать все");
            System.out.println("2) Найти по режиссёру");
            System.out.println("3) Добавить фильм");
            System.out.println("4) Удалить по названию");
            System.out.println("0) Выход");
            System.out.print("> ");
            switch (sc.nextLine().trim()) {
                case "1": listAll();           break;
                case "2": findByDirector(sc);  break;
                case "3": addMovie(sc); save();   break;
                case "4": deleteByTitle(sc); save(); break;
                case "0": System.out.println("Выход."); return;
                default:  System.out.println("Неверная команда");
            }
        }
    }

    private void listAll() {
        System.out.println("\nСписок фильмов:");
        for (Object o : movies) {
            JSONObject m = (JSONObject) o;
            String title    = (String)  m.get("title");
            String director = (String)  m.get("director");
            int    year     = ((Number) m.get("year")).intValue();
            System.out.printf("— %s (%s) [%d]\n", title, director, year);
        }
    }

    private void findByDirector(Scanner sc) {
        System.out.print("Введите режиссёра (или часть): ");
        String key = sc.nextLine().trim().toLowerCase();

        System.out.println("\nРезультаты поиска:");
        boolean found = false;
        for (Object o : movies) {
            JSONObject m = (JSONObject) o;
            String director = ((String) m.get("director")).toLowerCase();
            if (director.contains(key)) {
                String title = (String)  m.get("title");
                int    year  = ((Number) m.get("year")).intValue();
                System.out.printf("— %s [%d]\n", title, year);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Ничего не найдено.");
        }
    }

    @SuppressWarnings("unchecked")
    private void addMovie(Scanner sc) {
        System.out.print("Название: ");
        String title = sc.nextLine().trim();
        System.out.print("Режиссёр: ");
        String dir   = sc.nextLine().trim();
        System.out.print("Год: ");
        int    year  = Integer.parseInt(sc.nextLine().trim());

        JSONObject m = new JSONObject();
        m.put("title",    title);
        m.put("director", dir);
        m.put("year",     year);
        movies.add(m);
        System.out.println("Фильм добавлен.");
    }

    private void deleteByTitle(Scanner sc) {
        System.out.print("Введите точное название для удаления: ");
        String key = sc.nextLine().trim();
        Iterator<?> it = movies.iterator();
        while (it.hasNext()) {
            JSONObject m = (JSONObject) it.next();
            if (key.equals(m.get("title"))) {
                it.remove();
                System.out.println("Удалено.");
                return;
            }
        }
        System.out.println("Не найдено.");
    }

    private void save() throws Exception {
        try (FileWriter fw = new FileWriter(JSON_PATH)) {
            fw.write(root.toJSONString());
        }
        System.out.println("Изменения сохранены.");
    }
}
