package edu.project3;

import edu.project3.Models.HttpMethod;
import org.junit.jupiter.api.Test;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogParserTests {
    @Test
    void parseLongLogTest() {
        String logString = "123.34.12.63 - 122.32.12.11 [17/Sep/2004:07:35:01 +0000] \"GET /downloads/product_5 HTTP/1.1\" 200 335 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\"";

        Log log = Log.parse(logString);

        assertThat(log.remoteAddress()).isEqualTo("123.34.12.63");
        assertThat(log.remoteUser()).isEqualTo("122.32.12.11");
        assertThat(log.timeLocal()).isEqualTo(OffsetDateTime.of(2004, 9, 17, 7, 35, 1, 0, ZoneOffset.UTC));
        assertThat(log.method()).isEqualTo(HttpMethod.GET);
        assertThat(log.resource()).isEqualTo("/downloads/product_5");
        assertThat(log.request()).isEqualTo("GET /downloads/product_5 HTTP/1.1");
        assertThat(log.status()).isEqualTo(200);
        assertThat(log.bodyBytesSent()).isEqualTo(335);
        assertThat(log.httpReferer()).isEqualTo("-");
        assertThat(log.httpUserAgent()).isEqualTo("Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)");
    }

    @Test
    void wrongFormatLogTest() {
        String logString = "123.34.12.63 - 122.32.12.11 17/Sep/2004:07:35:01 +0000 \"GET /downloads/product_5 HTTP/1.1\" 200 335 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\"";
        assertThrows(IllegalArgumentException.class, () -> Log.parse(logString));
    }
}
