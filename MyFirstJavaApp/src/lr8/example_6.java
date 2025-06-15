package lr8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class example_6 {
    public static void main(String[] args) {
        String urlStr = "http://fat.urfu.ru/index.html";
        try {
            // 1) считываем HTML
            HttpURLConnection conn = (HttpURLConnection) new URL(urlStr).openConnection();
            conn.setRequestProperty("User-Agent", "Java");
            StringBuilder html = new StringBuilder();
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "CP1251"))) // сайт в CP1251
            {
                String line;
                while ((line = in.readLine()) != null) {
                    html.append(line).append('\n');
                }
            }
            conn.disconnect();

            String page = html.toString();

            // 2) затираем всё до нужного <table>…</table> (имитируем ваш селектор)
            // Здесь берём содержимое пятой строки таблицы, третьего столбца
            Pattern tbl = Pattern.compile(
                    "<tr>\\s*(?:.*?\\n){4}.*?<td>\\s*<table.*?</table>",
                    Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
            Matcher mt = tbl.matcher(page);
            if (!mt.find()) {
                System.out.println("Не удалось найти главный блок");
                return;
            }
            String block = mt.group();

            // 3) из этого блока ищем все подряд вхождения <div class="blocktitle">…</div>
            Pattern titleRe = Pattern.compile(
                    "<div[^>]*class\\s*=\\s*\"blocktitle\"[^>]*>(.*?)</div>",
                    Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
            Pattern dateRe = Pattern.compile(
                    "<div[^>]*class\\s*=\\s*\"blockdate\"[^>]*>(.*?)</div>",
                    Pattern.CASE_INSENSITIVE|Pattern.DOTALL);

            Matcher mtTitle = titleRe.matcher(block);
            Matcher mtDate  = dateRe.matcher(block);

            while (mtTitle.find() && mtDate.find()) {
                String title = stripTags(mtTitle.group(1)).trim();
                String date  = stripTags(mtDate.group(1)).trim();
                System.out.println("Тема: " + title);
                System.out.println("Дата: " + date + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Убираем все HTML-теги из строки
    private static String stripTags(String s) {
        return s.replaceAll("<[^>]+>", "");
    }
}
