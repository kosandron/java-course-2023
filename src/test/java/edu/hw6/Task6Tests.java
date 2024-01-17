package edu.hw6;

import org.junit.jupiter.api.Test;
import java.net.ServerSocket;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6Tests {
    @Test
    void freePortTest() {
        assertThat(PortScanner.isTcpPortUsed(1024)).isFalse();
        assertThat(PortScanner.isUdpPortUsed(1024)).isFalse();
    }

    @Test
    void closePortTest() {
        try(ServerSocket serverSocket = new ServerSocket(211)) {
            assertThat(PortScanner.isTcpPortUsed(211)).isTrue();
            serverSocket.close();
            assertThat(PortScanner.isTcpPortUsed(211)).isFalse();
        } catch (Exception e) {
        }
    }
}
