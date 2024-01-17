package edu.hw6;

import org.junit.jupiter.api.Test;
import java.net.http.HttpClient;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Tests {
    @Test
    public void getNewsTitle() {
        // Arrange
        NewsClient client = new NewsClient(HttpClient.newBuilder().build());

        // Act, Assert
        assertThat(client.news(37570037)).isEqualTo("JDK 21 Release Notes");
    }

    @Test
    public void getNewsTitles() {
        // Arrange
        NewsClient client = new NewsClient(HttpClient.newBuilder().build());

        // Act
        long[] id = client.hackerNewsTopStories();

        // Assert
        assertThat(id.length).isGreaterThan(0);
        for (int i = 0; i < Math.min(id.length, 3); i++) {
            assertThat(client.news(id[i])).isNotNull().isNotEmpty();
        }
    }
}
