package edu.project3.Analysers;

import edu.project3.Log;
import edu.project3.Models.HttpMethod;
import edu.project3.Printers.Table;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class HttpMethodAnalyser implements Analyzer {
    @Override
    public Table analyze(List<Log> logs) {
        Table table = new Table("Http методы", List.of("Метод", "Количество"));

        TreeMap<HttpMethod, Integer> methods =
            logs.stream().collect(Collectors.toMap(Log::method, log -> 1, Integer::sum, TreeMap::new));

        for (var method : methods.entrySet()) {
            table.addRow(
                List.of(
                    method.getKey().toString(),
                    method.getValue().toString()
                )
            );
        }

        return table;
    }
}
