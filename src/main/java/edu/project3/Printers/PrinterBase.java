package edu.project3.Printers;

import java.util.List;

public abstract class PrinterBase {
    public final static String LINE_SEPARATOR = "\n";
    public final static String COLUMN_SEPARATOR = "|";

    public abstract void addTable(Table table);

    protected int[] getColumnSizes(List<String> titles, List<List<String>> rows) {
        int[] columnSizes = titles.stream().mapToInt(String::length).toArray();
        for (List<String> row : rows) {
            for (int i = 0; i < row.size(); i++) {
                columnSizes[i] = Math.max(columnSizes[i], row.get(i).length()) + COLUMN_SEPARATOR.length();
            }
        }

        return columnSizes;
    }

    protected String buildRowString(int[] columnSizes, List<String> row) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < row.size(); i++) {
            int spacesCount = (columnSizes[i] - row.get(i).length());
            stringBuilder.append(COLUMN_SEPARATOR);
            stringBuilder.append(" ".repeat(spacesCount));
            stringBuilder.append(row.get(i));
        }
        return stringBuilder.toString();
    }
}
