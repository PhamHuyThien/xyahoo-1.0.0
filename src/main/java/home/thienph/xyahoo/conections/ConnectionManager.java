package home.thienph.xyahoo.conections;

import home.thienph.xyahoo.data.networks.Packet;

import javax.microedition.io.SocketConnection;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.util.Hashtable;

public final class ConnectionManager {
    private static DataOutputStream outputStream;
    public static InputStream inputStream;
    public static PacketHandler ConnectionListener;
    private static SocketConnection socket;
    public static boolean isConnected;
    public static boolean isConnecting;
    private static PacketWriter packetQueue;
    private static Thread connectorThread;
    public static Thread readerThread;
    public static Thread writerThread;
    public static int dataUsage;
    public static int zeroDataUsage;
    private static int headerSize;
    private static Hashtable callbacks;

    static {
        headerSize = 4;
        packetQueue = new PacketWriter();
        callbacks = new Hashtable();
    }

    public static boolean isConnected() {
        return isConnected;
    }

    public static void registerCallback(int n, PacketHandler packetHandler2) {
        Integer n2 = new Integer(n);
        if (ConnectionManager.callbacks.containsKey(n2)) {
            ConnectionManager.callbacks.remove(n2);
        }
        ConnectionManager.callbacks.put(n2, packetHandler2);
    }

    public static void connect(String string, String string2, int n, int n2) {
        if (isConnected || isConnecting) {
            return;
        }
        socket = null;
        connectorThread = new Thread(new ConnectionTask(string, string2, n, n2));
        connectorThread.start();
    }

    public static void sendPacket(Packet packet2) {
        packetQueue.enqueue(packet2);
    }

    public static void disconnect() {
        ConnectionManager.cleanup();
    }

    private static void cleanup() {
        try {
            isConnected = false;
            isConnecting = false;
            if (socket != null) {
                socket.close();
                socket = null;
            }
            if (outputStream != null) {
                outputStream.close();
                outputStream = null;
            }
            if (inputStream != null) {
                inputStream.close();
                inputStream = null;
            }
            writerThread = null;
            readerThread = null;
            System.gc();
            return;
        } catch (Exception exception) {
            System.err.println("ConnectionManager.cleanup Exception: " + exception);
            exception.printStackTrace();
        }
    }

    static void setSocketConnection(SocketConnection socketConnection) {
        socket = socketConnection;
    }

    static SocketConnection getSocketConnection() {
        return socket;
    }

    static void setOutputStream(DataOutputStream dataOutputStream) {
        outputStream = dataOutputStream;
    }

    static PacketWriter getPacketWriter() {
        return packetQueue;
    }

    static DataOutputStream getOutputStream() {
        return outputStream;
    }

    static Hashtable getCallbacks() {
        return callbacks;
    }

    static void resetConnection() {
        ConnectionManager.cleanup();
    }

    static int getHeaderSize() {
        return headerSize;
    }
}
