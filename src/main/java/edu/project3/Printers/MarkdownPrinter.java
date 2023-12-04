package edu.project3.Printers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class MarkdownPrinter extends PrinterBase {
    public static final String EXTENSION = ".md";

    private final File file;

    public MarkdownPrinter(String path, String fileName) {
        file = new File(path + fileName + EXTENSION);

        try {
            if (file.exists()) {
                file.delete();
            }

            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addTable(Table table) {
        try {
            writeLine("#### " + table.getTableTitle());

            int[] columnSizes = getColumnSizes(table.getColumnTitles(), table.getRows());
            writeLine(buildRowString(columnSizes, table.getColumnTitles()) + COLUMN_SEPARATOR);
            writeLine(buildHeaderSeparator(columnSizes));

            for (List<String> row : table.getRows()) {
                writeLine(buildRowString(columnSizes, row) + COLUMN_SEPARATOR);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeLine(String line) throws IOException {
        Files.write(file.toPath(), (line + LINE_SEPARATOR).getBytes(), StandardOpenOption.APPEND);
    }

    private String buildHeaderSeparator(int[] columnSizes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int columnSize : columnSizes) {
            stringBuilder.append(COLUMN_SEPARATOR + ":");
            stringBuilder.append("-".repeat(columnSize - 2));
            stringBuilder.append(":");
        }
        stringBuilder.append(COLUMN_SEPARATOR);

        return stringBuilder.toString();
    }
}

