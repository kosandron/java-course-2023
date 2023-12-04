package edu.project3;

import edu.project3.Analysers.GeneralInfomationAnalyzer;
import edu.project3.Analysers.HttpMethodAnalyser;
import edu.project3.Analysers.RequestCodeAnalyser;
import edu.project3.Analysers.ResourceAnalyser;
import edu.project3.Printers.Table;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class AnalyzerTests {
    private final List<Log> logs = List.of(
        Log.parse("54.175.76.214 - - [04/Jun/2015:06:06:51 +0000] \"GET /downloads/product_1 HTTP/1.1\" 200 300 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.20.1)\""),
        Log.parse("217.168.17.5 - - [04/Jun/2015:06:06:38 +0000] \"DELETE /downloads/product_5 HTTP/1.1\" 503 100 \"-\" \"Debian APT-HTTP/1.3 (0.8.10.3)\""),
        Log.parse("80.91.33.133 - - [04/Jun/2015:06:06:00 +0000] \"TRACE /downloads/product_5 HTTP/1.1\" 404 500 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.16)\"")
    );

    @Test
    void generalInfomationAnalyzerTest() {
        Settings settings = new SettingsBuilder().build();
        Table table = new GeneralInfomationAnalyzer(settings).analyze(logs);
        assertThat(table.getRows())
            .contains(List.of("Начальная дата", "-"))
            .contains(List.of("Конечная дата", "-"))
            .contains(List.of("Количество запросов", "3"))
            .contains(List.of("Средний размер ответа", "300b"));
    }

    @Test
    void requestCodeAnalyserTest() {
        Table table = new RequestCodeAnalyser().analyze(logs);
        assertThat(table.getRows())
            .contains(List.of("200", "Успешный", "1"))
            .contains(List.of("404", "Клиентская ошибка", "1"))
            .contains(List.of("503", "Серверная ошибка", "1"));
    }

    @Test
    void httpMethodAnalyserTest() {
        Table table = new HttpMethodAnalyser().analyze(logs);
        assertThat(table.getRows())
            .contains(List.of("GET", "1"))
            .contains(List.of("DELETE", "1"))
            .contains(List.of("TRACE", "1"));
    }

    @Test
    void resourceAnalyserTest() {
        Table table = new ResourceAnalyser().analyze(logs);
        assertThat(table.getRows())
            .contains(List.of("/downloads/product_1", "1"))
            .contains(List.of("/downloads/product_5", "2"));
    }
}
