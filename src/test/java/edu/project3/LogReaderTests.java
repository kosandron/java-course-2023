package edu.project3;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class LogReaderTests {
    @Test
    void extractFromSingleFileTest() {
        Settings settings = Parser.parse("--path src/main/java/edu/project3/files/logs1.txt --format markdown".split("\\s+"));

        List<Log> logs = LogReader.getLogs(settings);

        assertThat(logs)
            .contains(Log.parse("217.168.17.5 - - [17/May/2015:08:05:12 +0000] \"GET /downloads/product_2 HTTP/1.1\" 200 3316 \"-\" \"-\""))
            .contains(Log.parse("188.138.60.101 - - [17/May/2015:08:05:49 +0000] \"GET /downloads/product_2 HTTP/1.1\" 304 0 \"-\" \"Debian APT-HTTP/1.3 (0.9.7.9)\""));
    }

    @Test
    void extractFromMultipleFilesTest() {
        Settings settings = Parser.parse("--path src/main/java/edu/project3/files/logs1.txt src/main/java/edu/project3/files/logs2.txt --format markdown".split("\\s+"));

        List<Log> logs = LogReader.getLogs(settings);

        assertThat(logs)
            .contains(Log.parse("217.168.17.5 - - [17/May/2015:08:05:12 +0000] \"GET /downloads/product_2 HTTP/1.1\" 200 3316 \"-\" \"-\""))
            .contains(Log.parse("188.138.60.101 - - [17/May/2015:08:05:49 +0000] \"GET /downloads/product_2 HTTP/1.1\" 304 0 \"-\" \"Debian APT-HTTP/1.3 (0.9.7.9)\""))
            .contains(Log.parse("91.234.194.89 - - [17/May/2015:08:05:18 +0000] \"GET /downloads/product_2 HTTP/1.1\" 304 0 \"-\" \"Debian APT-HTTP/1.3 (0.9.7.9)\""))
            .contains(Log.parse("31.22.86.126 - - [17/May/2015:08:05:24 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304 0 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.16)\""))
            .contains(Log.parse("98.17.22.55 - - [17/May/2015:08:05:25 +0000] \"GET /load/myProduct HTTP/1.1\" 200 3301 \"-\" \"-\""));
    }

    @Test
    void extractFromWebsiteTest() {
        Settings settings = Parser.parse("--path https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs --format markdown".split("\\s+"));

        List<Log> logs = LogReader.getLogs(settings);

        assertThat(logs.size()).isGreaterThan(0);
        assertThat(logs).contains(Log.parse("114.80.245.62 - - [04/Jun/2015:06:06:58 +0000] \"GET /downloads/product_2 HTTP/1.1\" 200 26318005 \"-\" \"Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.104 Safari/537.36\""));
    }

    @Test
    void extractFromMultipleInputsTest() {
        Settings settings = Parser.parse("--path https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs src/main/java/edu/project3/files/logs2.txt --format markdown".split("\\s+"));

        List<Log> logs = LogReader.getLogs(settings);

        assertThat(logs.size()).isGreaterThan(3);
        assertThat(logs)
            .contains(Log.parse("91.234.194.89 - - [17/May/2015:08:05:18 +0000] \"GET /downloads/product_2 HTTP/1.1\" 304 0 \"-\" \"Debian APT-HTTP/1.3 (0.9.7.9)\""))
            .contains(Log.parse("31.22.86.126 - - [17/May/2015:08:05:24 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304 0 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.16)\""))
            .contains(Log.parse("98.17.22.55 - - [17/May/2015:08:05:25 +0000] \"GET /load/myProduct HTTP/1.1\" 200 3301 \"-\" \"-\""));
    }
}
