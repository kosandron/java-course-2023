package edu.project3.Analysers;

import edu.project3.Log;
import edu.project3.Printers.Table;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RequestCodeAnalyser implements Analyzer {
    @Override
    public Table analyze(List<Log> logs) {
        Table table = new Table("Коды ответа", List.of("Код", "Категория", "Количество"));
        SortedMap<Integer, Integer> codes =
            logs.stream().collect(Collectors.toMap(Log::status, log -> 1, Integer::sum, TreeMap::new));
        for (var code : codes.entrySet()) {
            table.addRow(List.of(
                code.getKey().toString(),
                getDescription(code.getKey()),
                code.getValue().toString()
            ));
        }

        return table;
    }

    @SuppressWarnings("MagicNumber")
    private String getDescription(int status) {
        return switch (status / 100) {
            case 1 -> "Информационный";
            case 2 -> "Успешный";
            case 3 -> "Перенаправление";
            case 4 -> "Клиентская ошибка";
            case 5 -> "Серверная ошибка";
            default -> "Неизвестно";
        };
    }
}
