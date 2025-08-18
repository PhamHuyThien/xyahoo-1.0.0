package home.thienph.xyahoo;

import java.io.InputStream;

final class PacketReaderThread
implements Runnable {
    PacketReaderThread() {
    }

    public final void run() {
        try {
            while (ConnectionManager.isConnected()) {
                Object packet;
                int headerSize;
                Object inputStream = ConnectionManager.inputStream;
                int packetLength = ConnectionManager.getMaxRetry();
                byte[] headerBuffer = new byte[packetLength];
                int n3 = 0;
                while (n3 >= 0 && n3 < packetLength) {
                    headerSize = ((InputStream) inputStream).read(headerBuffer, n3, packetLength - n3);
                    n3 += headerSize;
                }
                if (n3 == -1) {
                    packet = null;
                } else {
                    int packetType;
                    headerSize = PacketReaderThread.readIntFromBytes(headerBuffer);
                    n3 = 0;
                    while (n3 >= 0 && n3 < 4) {
                        packetType = ((InputStream) inputStream).read(headerBuffer, n3, packetLength - n3);
                        n3 += packetType;
                    }
                    if (n3 == -1) {
                        packet = null;
                    } else {
                        int packetSubtype;
                        packetType = PacketReaderThread.readIntFromBytes(headerBuffer);
                        n3 = 0;
                        while (n3 >= 0 && n3 < 4) {
                            packetSubtype = ((InputStream) inputStream).read(headerBuffer, n3, packetLength - n3);
                            n3 += packetSubtype;
                        }
                        if (n3 == -1) {
                            packet = null;
                        } else {
                            packetSubtype = PacketReaderThread.readIntFromBytes(headerBuffer);
                            int n6 = headerSize - 8;
                            byte[] payload = new byte[n6];
                            n3 = 0;
                            while (n3 >= 0 && n3 < n6) {
                                int n7 = ((InputStream) inputStream).read(payload, n3, n6 - n3);
                                if (n7 <= 0) continue;
                                n3 += n7;
                            }
                            if (n3 == -1) {
                                packet = null;
                            } else {
                                ConnectionManager.connectionId += packetLength + n6;
                                packet = inputStream = new Packet(packetType, packetSubtype, payload);
                            }
                        }
                    }
                }
                if (packet != null) {
                    Integer n8 = new Integer(((Packet) inputStream).getType());
                    ConnectionManager.ConnectionListener = (PacketHandler) ConnectionManager.getCallbacks().get(n8);
                    if (ConnectionManager.ConnectionListener == null) continue;
                    ConnectionManager.ConnectionListener.dispatch((Packet) inputStream);
                    continue;
                }
                break;
            }
        }
        catch (Exception exception) {}
        try {
            if (ConnectionManager.isConnected && ConnectionManager.ConnectionListener != null) {
                ConnectionManager.ConnectionListener.onDisconnect();
            }
            if (ConnectionManager.getSocketConnection() != null) {
                ConnectionManager.resetConnection();
                return;
            }
        }
        catch (Exception exception) {}
    }

    private static int readIntFromBytes(byte[] byArray) {
        int n = 0;
        int n2 = 0;
        while (n2 < 4) {
            n <<= 8;
            n |= 0xFF & byArray[n2];
            ++n2;
        }
        return n;
    }
}
