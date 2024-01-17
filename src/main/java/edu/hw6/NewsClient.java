package edu.hw6;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewsClient {
    private final static String URL = "https://hacker-news.firebaseio.com/v0/";
    private static final int TIMEOUT = 10;

    private final HttpClient client;

    public NewsClient(HttpClient client) {
        if (client == null) {
            throw new NullPointerException();
        }

        this.client = client;
    }

    public long[] hackerNewsTopStories() {
        var request = HttpRequest.newBuilder()
            .uri(URI.create(URL + "topstories.json"))
            .timeout(Duration.ofSeconds(TIMEOUT))
            .GET()
            .build();

        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String[] newsData = response.body().split(",");
            if (newsData.length > 0) {
                newsData[0] = newsData[0].substring(1);

                int lastIndex = newsData.length - 1;
                newsData[lastIndex] = newsData[lastIndex].substring(0, newsData[lastIndex].length() - 1);
            }

            return Arrays.stream(newsData).mapToLong(Long::parseLong).toArray();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String news(long id) {
        var request = HttpRequest.newBuilder()
            .uri(URI.create(URL + String.format("item/%d.json", id)))
            .timeout(Duration.ofSeconds(TIMEOUT))
            .GET()
            .build();

        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Pattern pattern = Pattern.compile("\"title\":\"(.+?)\"");
            Matcher matcher = pattern.matcher(response.body());

            return matcher.find() ? matcher.group(1) : "";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
