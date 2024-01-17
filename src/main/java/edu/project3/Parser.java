package edu.project3;

import edu.project3.Models.Outputformat;
import java.time.LocalDate;

public final class Parser {
    private Parser() {
    }

    public static Settings parse(String[] args) {
        SettingsBuilder settingsBuilder = new SettingsBuilder();

        String previousWord = "";
        for (String arg : args) {
            if (arg.startsWith("--")) {
                previousWord = arg;
                continue;
            }

            switch (previousWord) {
                case "--path" -> settingsBuilder.withPath(arg);
                case "--from" -> settingsBuilder.withFromDate(LocalDate.parse(arg));
                case "--to" -> settingsBuilder.withToDate(LocalDate.parse(arg));
                case "--format" -> settingsBuilder.withOutputFormat(Outputformat.valueOf(arg.toUpperCase()));
                default -> {
                }
            }
        }

        return settingsBuilder.build();
    }
}
