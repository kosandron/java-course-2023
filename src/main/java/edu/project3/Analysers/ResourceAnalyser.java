package edu.project3.Analysers;

import edu.project3.Log;
import edu.project3.Printers.Table;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ResourceAnalyser implements Analyzer {
    @Override
    public Table analyze(List<Log> logs) {
        Table table = new Table("Запрашиваемые ресурсы", List.of("Ресурс", "Количество"));

        TreeMap<String, Integer> resources =
            logs.stream().collect(Collectors.toMap(Log::resource, log -> 1, Integer::sum, TreeMap::new));

        for (var resource : resources.entrySet()) {
            table.addRow(List.of(resource.getKey(), resource.getValue().toString()));
        }

        return table;
    }
}
