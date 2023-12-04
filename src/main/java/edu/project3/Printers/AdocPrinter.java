package edu.project3.Printers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class AdocPrinter extends PrinterBase {
    public static final String EXTENSION = ".adoc";
    private static final String TABLE_SYMBOLS = "|===";

    private final File file;

    public AdocPrinter(String path, String fileName) {
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

            writeLine(TABLE_SYMBOLS);
            int[] columnSizes = getColumnSizes(table.getColumnTitles(), table.getRows());
            writeLine(buildRowString(columnSizes, table.getColumnTitles()));
            for (List<String> row : table.getRows()) {
                writeLine(buildRowString(columnSizes, row));
            }
            writeLine(TABLE_SYMBOLS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeLine(String line) throws IOException {
        Files.write(file.toPath(), (line + LINE_SEPARATOR).getBytes(), StandardOpenOption.APPEND);
    }
}
