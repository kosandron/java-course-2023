package edu.hw6;

import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PortScanner {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static String TABLE_HEADER = "Protocol  Port   Used  Service";
    private final static int MAX_PORT_COUNT = 49151;
    private final static Map<Integer, String> SERVICES = Map.of(
        135, "Microsoft EPMAP",
        138, "NetBIOS Datagram Service",
        201, "AppleTalk Routing Maintenance",
        434, "Mobile IP Agent (RFC 5944)",
        502, "Modbus Protocol",
        1801, "Microsoft Message Queuing",
        2056, "Civilization IV multiplayer",
        3516, "Smartcard Port",
        3724, "Some Blizzard games",
        28000, "Siemens Digital Industries Software license server"
    );

    private enum Protocol {
        UDP, TCP
    }

    private PortScanner() {
    }

    public static boolean isTcpPortUsed(int portNumber) {
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public static void scanTcpPorts() {
        LOGGER.info(TABLE_HEADER);
        for (int portNumber = 0; portNumber <= MAX_PORT_COUNT; portNumber++) {
            boolean isUsed = isTcpPortUsed(portNumber);
            printPort(Protocol.TCP, portNumber, isUsed);
        }
    }

    public static boolean isUdpPortUsed(int portNumber) {
        try (DatagramSocket datagramSocket = new DatagramSocket(portNumber)) {
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public static void scanUdpPorts() {
        LOGGER.info(TABLE_HEADER);
        for (int portNumber = 0; portNumber <= MAX_PORT_COUNT; portNumber++) {
            boolean isUsed = isUdpPortUsed(portNumber);
            printPort(Protocol.UDP, portNumber, isUsed);
        }
    }

    private static void printPort(Protocol protocol, int portNumber, boolean isUsed) {
        String service = SERVICES.getOrDefault(portNumber, "");
        LOGGER.info(String.format(
            "%-4s  %-5d  %-5s  %-25s",
            protocol.toString(),
            portNumber,
            isUsed ? "Yes" : "No",
            service
        ));
    }
}
