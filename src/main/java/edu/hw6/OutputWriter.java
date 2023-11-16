package edu.hw6;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;

public final class OutputWriter {
    private OutputWriter() {
    }

    public static PrintWriter newOutputWriter(Path path) throws IOException {
        var outputStream = Files.newOutputStream(path);
        var checkedOutputStream = new CheckedOutputStream(outputStream, new CRC32());
        var bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);
        var outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);

        return new PrintWriter(outputStreamWriter);
    }
}
