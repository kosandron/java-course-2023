package edu.project3;

import edu.project3.Analysers.Analyzer;
import edu.project3.Analysers.GeneralInfomationAnalyzer;
import edu.project3.Analysers.HttpMethodAnalyser;
import edu.project3.Analysers.RequestCodeAnalyser;
import edu.project3.Analysers.ResourceAnalyser;
import edu.project3.Printers.AdocPrinter;
import edu.project3.Printers.MarkdownPrinter;
import edu.project3.Printers.PrinterBase;
import java.util.List;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        Settings settings =
            Parser.parse("--path src/main/java/edu/project3/files/logsList.txt --format adoc".split("\\s+"));
        if (settings.path().isEmpty()) {
            System.err.println("Path can not be empty!");
        }

        List<Log> logs = LogReader.getLogs(settings);

        List<Analyzer> analyzers = List.of(
            new GeneralInfomationAnalyzer(settings),
            new ResourceAnalyser(),
            new RequestCodeAnalyser(),
            new HttpMethodAnalyser()
        );

        String path = "src/main/java/edu/project3/files/";
        String fileName = "Result";
        PrinterBase printer = switch (settings.outputformat()) {
            case ADOC -> new AdocPrinter(path, fileName);
            case MARKDOWN -> new MarkdownPrinter(path, fileName);
            default -> throw new IllegalArgumentException("Unknown format");
        };

        for (var analyzer : analyzers) {
            printer.addTable(analyzer.analyze(logs));
        }
    }
}
