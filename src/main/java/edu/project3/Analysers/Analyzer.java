package edu.project3.Analysers;

import edu.project3.Log;
import edu.project3.Printers.Table;
import java.util.List;

public interface Analyzer {
    Table analyze(List<Log> logs);
}
