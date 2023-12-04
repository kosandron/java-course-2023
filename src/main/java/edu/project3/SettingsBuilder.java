package edu.project3;

import edu.project3.Models.Outputformat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SettingsBuilder {
    private List<String> pathes;
    private LocalDate from;
    private LocalDate to;
    private Outputformat format;

    public SettingsBuilder() {
        this.pathes = new ArrayList<>();
        this.from = LocalDate.MIN;
        this.to = LocalDate.MAX;
        this.format = Outputformat.MARKDOWN;
    }

    public Settings build() {
        return new Settings(this.pathes, this.from, this.to, this.format);
    }

    public void withPath(String path) {
        this.pathes.add(path);
    }

    public void withFromDate(LocalDate from) {
        this.from = from;
    }

    public void withToDate(LocalDate to) {
        this.to = to;
    }

    public void withOutputFormat(Outputformat format) {
        this.format = format;
    }
}
