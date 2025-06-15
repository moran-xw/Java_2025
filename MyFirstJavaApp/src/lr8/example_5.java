package lr8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class example_5 {
    public static void main(String[] args) {
        String urlStr = "https://itlearn.ru/first-steps";
        HttpURLConnection conn = null;
        StringBuilder html = new StringBuilder();
        try {
            URL baseUrl = new URL(urlStr);
            conn = (HttpURLConnection) baseUrl.openConnection();
            conn.setRequestProperty("User-Agent", "Java");
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "UTF-8")))
            {
                String line;
                while ((line = in.readLine()) != null) {
                    html.append(line).append('\n');
                }
            }

            // Простая регулярка для href="…"
            Pattern p = Pattern.compile(
                    "href\\s*=\\s*\"([^\"]*)\"",
                    Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(html);

            while (m.find()) {
                String link = m.group(1);
                // приводим к абсолютному URL
                URL abs = new URL(baseUrl, link);
                System.out.println(abs.toExternalForm());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) conn.disconnect();
        }
    }
}
