package edu.hw8.Task1;

import java.util.ArrayList;
import java.util.List;

public class AnswerRepository {
    private final List<String> answers;

    public AnswerRepository() {
        answers = new ArrayList<>(List.of(
            "Не переходи на личности там, где их нет",
            "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами",
            "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.",
            "Чем ниже интеллект, тем громче оскорбления."
        ));
    }

    public void addAnswer(String answer) {
        answers.add(answer);
    }

    public String findFirstAnswerByKeyWord(String keyWord) {
        return answers.stream()
            .filter(
                quote -> quote.toLowerCase().contains(keyWord.toLowerCase())
            )
            .findFirst()
            .orElse("Кто обзывается, тот так и называется.");
    }
}

