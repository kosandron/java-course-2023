package edu.hw8.Task1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Client {
    private static final Logger LOGGER = LogManager.getLogger();
    private SocketChannel channel;
    private ByteBuffer buffer;

    public void start() {
        try {
            channel = SocketChannel.open(new InetSocketAddress(Settings.HOST_NAME, Settings.PORT));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        buffer = ByteBuffer.allocate(Settings.MESSAGE_SIZE);
    }

    public void stop() {
        try {
            channel.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        buffer = null;
    }

    public String sendMessage(String message) {
        LOGGER.info("Вася: " + message);

        buffer = ByteBuffer.allocate(Settings.MESSAGE_SIZE);
        buffer.put(message.getBytes());
        String response = null;
        try {
            buffer.flip();
            channel.write(buffer);

            buffer.flip();
            buffer.clear();
            channel.read(buffer);
            response = buffer.toString();
            LOGGER.info("Сервер: " + response);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }

        return response;
    }
}
