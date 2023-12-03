package edu.hw8;

import edu.hw8.Task1.AnswerRepository;
import edu.hw8.Task1.Client;
import edu.hw8.Task1.Server;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Tests {
    private static final AnswerRepository answerRepository = new AnswerRepository();

    @Test
    void connectivityCheck() {
        Server server = new Server(5);
        new Thread(server).start();

        int clientsCount = 10;
        for (int i = 0; i < clientsCount; i++) {
            Thread client = new Thread(() -> runClient());
            client.start();
        }

        server.stop();
    }

    private void runClient() {
        Client client = new Client();

        client.start();
        String keyWord1 = "личности";
        String response1 = client.sendMessage(keyWord1);

        String keyWord2 = "глупый";
        String response2 = client.sendMessage(keyWord2);

        String keyWord3 = "интеллект";
        String response3 = client.sendMessage(keyWord3);

        String keyWord4 = "оскорбления";
        String response4 = client.sendMessage(keyWord4);

        String notExistedKeyWord = "tulula";
        String response5 = client.sendMessage(notExistedKeyWord);

        assertThat(response1).isEqualTo(answerRepository.findFirstAnswerByKeyWord(keyWord1));
        assertThat(response2).isEqualTo(answerRepository.findFirstAnswerByKeyWord(keyWord2));
        assertThat(response3).isEqualTo(answerRepository.findFirstAnswerByKeyWord(keyWord3));
        assertThat(response4).isEqualTo(answerRepository.findFirstAnswerByKeyWord(keyWord4));
        assertThat(response5).isEqualTo("Кто обзывается, тот так и называется.");

        client.stop();
    }
}
