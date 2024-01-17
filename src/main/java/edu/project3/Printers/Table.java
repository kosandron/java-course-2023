package edu.project3.Printers;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final String title;
    private final List<String> columnTitles;
    private final List<List<String>> rows;

    public Table(String title, List<String> columnTitles) {
        this.title = title;
        this.columnTitles = columnTitles;
        rows = new ArrayList<>();
    }

    public void addRow(List<String> row) {
        if (columnTitles.size() != row.size()) {
            return;
        }

        rows.add(row);
    }

    public String getTableTitle() {
        return title;
    }

    public List<String> getColumnTitles() {
        return columnTitles;
    }

    public List<List<String>> getRows() {
        return rows;
    }
}
