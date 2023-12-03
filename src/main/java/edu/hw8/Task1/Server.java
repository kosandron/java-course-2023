package edu.hw8.Task1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server implements Runnable {
    private final AnswerRepository answerRepository;
    private final ThreadPoolExecutor threadPool;
    private volatile boolean isRunning = false;

    public Server(int maxClients) {
        this.answerRepository = new AnswerRepository();

        threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(Math.max(1, maxClients));
    }

    public void run() {
        try {
            start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void stop() {
        isRunning = false;
    }

    private void start() throws IOException {
        Selector selector = Selector.open();
        try (ServerSocketChannel serverSocket = ServerSocketChannel.open()) {
            serverSocket.bind(new InetSocketAddress(Settings.HOST_NAME, Settings.PORT));
            serverSocket.configureBlocking(false);
            serverSocket.register(selector, SelectionKey.OP_ACCEPT);

            isRunning = true;
            while (isRunning) {
                selector.select();
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> iter = selectedKeys.iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();

                    if (key.isAcceptable()) {
                        SocketChannel channel = serverSocket.accept();
                        channel.configureBlocking(false);
                        channel.register(selector, SelectionKey.OP_READ);
                    }

                    if (key.isReadable()) {
                        threadPool.execute(() -> {
                            try {
                                sendResponse(key);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
                    }

                    iter.remove();
                }
            }
        }
    }

    private void sendResponse(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(Settings.MESSAGE_SIZE);

        int result = channel.read(buffer);
        if (result == -1) {
            channel.close();
        } else {
            buffer.flip();
            String keyWord = buffer.toString();
            String answer = answerRepository.findFirstAnswerByKeyWord(keyWord);
            buffer.clear();
            buffer.put(answer.getBytes());
            buffer.flip();
            channel.write(buffer);
        }
    }
}
