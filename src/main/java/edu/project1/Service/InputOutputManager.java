package edu.project1.Service;

import edu.project1.Entities.State;

public interface InputOutputManager {
    String tryGo(String openWord);

    void printState(State state);

    int getWordSize();
}
