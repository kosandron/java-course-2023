package edu.project3;

import edu.project3.Models.Outputformat;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class ParserTests {
    @Test
    void allFlagsTest() {
        List<String> path = new ArrayList<>(List.of("files/randomPath")) ;
        String fromDate = "2022-07-23";
        String toDate = "2023-11-12";
        String format = "adoc";
        String[] args = {"--path", path.get(0), "--from", fromDate, "--to", toDate, "--format", format};

        Settings settings = Parser.parse(args);

        assertThat(settings.path()).isEqualTo(path);
        assertThat(settings.fromDate().toString()).isEqualTo(fromDate);
        assertThat(settings.toDate().toString()).isEqualTo(toDate);
        assertThat(settings.outputformat()).isEqualTo(Outputformat.ADOC);
    }

    @Test
    void URLTest() {
        List<String> path = new ArrayList<>(List.of("https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs")) ;
        String[] args = {"--path", path.get(0)};

        Settings settings = Parser.parse(args);

        assertThat(settings.path()).isEqualTo(path);
    }

    @Test
    void formatAndPathTest() {
        List<String> path = new ArrayList<>(List.of("files/randomPath.txt")) ;
        String format = "MarkDown";
        String[] args = {"--format", format, "--path", path.get(0)};

        Settings settings = Parser.parse(args);

        assertThat(settings.path()).isEqualTo(path);
        assertThat(settings.outputformat()).isEqualTo(Outputformat.MARKDOWN);
    }
}
