package edu.project3;

import edu.project3.Models.Outputformat;
import java.time.LocalDate;
import java.util.List;

public class Settings {
    private final List<String> pathes;
    private final LocalDate from;
    private final LocalDate to;
    private final Outputformat format;

    public Settings(List<String> pathes, LocalDate from, LocalDate to, Outputformat outputformat) {
        this.pathes = pathes;
        this.from = from;
        this.to = to;
        this.format = outputformat;
    }

    public List<String> path() {
        return this.pathes;
    }

    public LocalDate fromDate() {
        return this.from;
    }

    public LocalDate toDate() {
        return this.to;
    }

    public Outputformat outputformat() {
        return this.format;
    }
}
