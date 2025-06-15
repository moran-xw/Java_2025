package lr8.task3;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class task_3 {
    // URL парсинга и файл вывода
    private static final String NEWS_URL = "http://fat.urfu.ru/index.html";
    private static final String OUTPUT_FILE = "src/lr8/task3/news.txt";

    private static final int MAX_TRIES = 3;
    private static final int RETRY_DELAY_MS = 2000;

    public static void main(String[] args) {
        System.out.println("=== Запуск парсера новостей ===");

        List<String> newsLinks = new ArrayList<>();
        boolean loaded = loadWithRetries(NEWS_URL, newsLinks);

        if (loaded && !newsLinks.isEmpty()) {
            writeToFile(newsLinks, OUTPUT_FILE);
        } else {
            System.err.println("Не удалось получить новости после " + MAX_TRIES + " попыток.");
        }
    }

    private static boolean loadWithRetries(String url, List<String> collector) {
        for (int attempt = 1; attempt <= MAX_TRIES; attempt++) {
            try {
                System.out.println("Попытка " + attempt + " из " + MAX_TRIES + ": подключаемся к " + url);
                Document doc = Jsoup.connect(url)
                        .userAgent("Mozilla/5.0")
                        .timeout(10_000)
                        .get();

                Elements links = doc.select("a[href]");
                for (Element a : links) {
                    collector.add(a.attr("abs:href"));
                }

                System.out.println("Успешно загружено. Ссылок найдено: " + collector.size());
                return true;

            } catch (IOException e) {
                System.err.println("Ошибка на попытке " + attempt + ": " + e.getMessage());
                if (attempt < MAX_TRIES) {
                    System.out.println("Ждём " + (RETRY_DELAY_MS/1000) + " сек. и пробуем снова...");
                    try {
                        Thread.sleep(RETRY_DELAY_MS);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        }
        return false;
    }

    private static void writeToFile(List<String> links, String filePath) {
        File out = new File(filePath);
        out.getParentFile().mkdirs();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(out))) {
            for (int i = 0; i < links.size(); i++) {
                bw.write("Новость №" + (i + 1));
                bw.newLine();
                bw.write("Ссылка: " + links.get(i));
                bw.newLine();
                bw.write("––––––––––––––––––––––––––––––––––––––––");
                bw.newLine();
            }
            System.out.println("Результат сохранён в: " + out.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}
