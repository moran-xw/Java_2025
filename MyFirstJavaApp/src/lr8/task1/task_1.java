package lr8.task1;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import java.io.File;
import java.util.Scanner;

public class task_1 {
    // Убедитесь, что movies.xml лежит именно в этой папке
    private static final String XML_PATH = "src/lr8/task1/movies.xml";

    private Document doc;
    private Element moviesRoot;

    public static void main(String[] args) throws Exception {
        new task_1().menuLoop();
    }

    // Конструктор должен называться как класс
    public task_1() throws Exception {
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        doc = db.parse(new File(XML_PATH));
        moviesRoot = (Element) doc.getElementsByTagName("movies").item(0);
    }

    private void menuLoop() throws Exception {
        Scanner sc = new Scanner(System.in, "UTF-8");
        while (true) {
            System.out.println("\n=== Меню ===");
            System.out.println("1) Показать все");
            System.out.println("2) Добавить фильм");
            System.out.println("3) Найти по режиссеру");
            System.out.println("4) Найти по году");
            System.out.println("5) Удалить по названию");
            System.out.println("0) Выход");
            System.out.print("> ");
            String cmd = sc.nextLine().trim();
            switch (cmd) {
                case "1": listAll();               break;
                case "2": addMovie(sc); save();    break;
                case "3": findByDirector(sc);      break;
                case "4": findByYear(sc);          break;
                case "5": deleteByTitle(sc); save(); break;
                case "0": System.out.println("До свидания"); return;
                default : System.out.println("Неверная команда");
            }
        }
    }

    private void listAll() {
        NodeList nl = moviesRoot.getElementsByTagName("movie");
        System.out.println("\nСписок фильмов:");
        for (int i = 0; i < nl.getLength(); i++) {
            Element m = (Element) nl.item(i);
            System.out.printf("— %s (%s) [%s]\n",
                    getText(m,"title"),
                    getText(m,"director"),
                    getText(m,"year"));
        }
    }

    private void addMovie(Scanner sc) {
        System.out.print("Название: ");
        String title = sc.nextLine().trim();
        System.out.print("Режиссер: ");
        String dir   = sc.nextLine().trim();
        System.out.print("Год: ");
        String yr    = sc.nextLine().trim();

        Element mv = doc.createElement("movie");
        appendText(mv,"title",    title);
        appendText(mv,"director", dir);
        appendText(mv,"year",     yr);
        moviesRoot.appendChild(mv);
        System.out.println("Добавлено.");
    }

    private void findByDirector(Scanner sc) {
        System.out.print("Режиссёр (или часть): ");
        String key = sc.nextLine().trim().toLowerCase();
        NodeList nl = moviesRoot.getElementsByTagName("movie");
        System.out.println("\nНайдено:");
        for (int i = 0; i < nl.getLength(); i++) {
            Element m = (Element) nl.item(i);
            if (getText(m,"director").toLowerCase().contains(key)) {
                System.out.printf("— %s [%s]\n",
                        getText(m,"title"), getText(m,"year"));
            }
        }
    }

    private void findByYear(Scanner sc) {
        System.out.print("Год: ");
        String key = sc.nextLine().trim();
        NodeList nl = moviesRoot.getElementsByTagName("movie");
        System.out.println("\nНайдено:");
        for (int i = 0; i < nl.getLength(); i++) {
            Element m = (Element) nl.item(i);
            if (getText(m,"year").equals(key)) {
                System.out.printf("— %s (%s)\n",
                        getText(m,"title"), getText(m,"director"));
            }
        }
    }

    private void deleteByTitle(Scanner sc) {
        System.out.print("Точное название для удаления: ");
        String key = sc.nextLine().trim();
        NodeList nl = moviesRoot.getElementsByTagName("movie");
        for (int i = 0; i < nl.getLength(); i++) {
            Element m = (Element) nl.item(i);
            if (getText(m,"title").equals(key)) {
                moviesRoot.removeChild(m);
                System.out.println("Удалено.");
                return;
            }
        }
        System.out.println("Не найдено.");
    }

    private String getText(Element p, String tag) {
        NodeList nl = p.getElementsByTagName(tag);
        return nl.getLength()>0 ? nl.item(0).getTextContent() : "";
    }

    private void appendText(Element p, String tag, String txt) {
        Element e = doc.createElement(tag);
        e.setTextContent(txt);
        p.appendChild(e);
    }

    private void save() throws TransformerException {
        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        tf.transform(new DOMSource(doc), new StreamResult(new File(XML_PATH)));
        System.out.println("Сохранено.");
    }
}
