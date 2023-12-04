package edu.project3.Analysers;

import edu.project3.Log;
import edu.project3.Printers.Table;
import edu.project3.Settings;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GeneralInfomationAnalyzer implements Analyzer {
    private static final String START_DATE_HEADER = "Начальная дата";
    private static final String END_DATE_HEADER = "Конечная дата";
    private static final String RESULT_COUNT_HEADER = "Количество запросов";
    private static final String NONE = "-";
    private static final String AVERAGE_BODY_SIZE_HEADER = "Средний размер ответа";
    private static final String FILES_HEADER = "Файл (-ы)";
    private final Settings settings;

    public GeneralInfomationAnalyzer(Settings settings) {
        this.settings = settings;
    }

    public Table analyze(List<Log> logs) {
        Table table = new Table("Общая информация", List.of("Метрика", "Значение"));
        for (String file : settings.path()) {
            String fileName = file.substring(file.lastIndexOf('/') + 1);
            table.addRow(List.of(FILES_HEADER, fileName));
        }

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        table.addRow(List.of(
            START_DATE_HEADER,
            settings.fromDate() == LocalDate.MIN ? NONE : settings.fromDate().format(format)
        ));

        table.addRow(List.of(
            END_DATE_HEADER,
            settings.toDate() == LocalDate.MAX ? NONE : settings.toDate().format(format)
        ));

        table.addRow(List.of(
            RESULT_COUNT_HEADER,
            String.valueOf(logs.size())
        ));

        table.addRow(List.of(
            AVERAGE_BODY_SIZE_HEADER,
            String.valueOf(
                (long) logs.stream()
                    .mapToLong(Log::bodyBytesSent)
                    .average()
                    .orElse(0)
            ) + 'b'
        ));

        return table;
    }
}
