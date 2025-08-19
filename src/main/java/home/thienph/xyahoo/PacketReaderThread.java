package home.thienph.xyahoo;

import java.io.IOException;
import java.io.InputStream;

final class PacketReaderThread
implements Runnable {
    PacketReaderThread() {
    }

    public final void run() {
        try {
            while (ConnectionManager.isConnected()) {
                InputStream in = ConnectionManager.inputStream;
                int headerSize = ConnectionManager.getHeaderSize(); // chiều dài header

                // Lấy tổng độ dài packet từ header
                byte[] headerBuffer = readPayload(in, headerSize);
                int packetLength = PacketReaderThread.readIntFromBytes(headerBuffer);

                // Đọc type (4 byte)
                byte[] typeBuffer = readPayload(in, headerSize);
                int packetType = PacketReaderThread.readIntFromBytes(typeBuffer);

                // Đọc subtype (4 byte)
                byte[] subtypeBuffer = readPayload(in, headerSize);
                int packetSubtype = PacketReaderThread.readIntFromBytes(subtypeBuffer);

                // Đọc payload (còn lại sau khi trừ type + subtype)
                int payloadLength = packetLength - 8; // vì type + subtype = 8 byte
                byte[] payload = readPayload(in, payloadLength);

                // Tạo packet
                System.out.println("[IN] command: " + packetType + " type: " + packetSubtype + " length: " + packetLength);
                Packet packet = new Packet(packetType, packetSubtype, payload);

                // Dispatch đến handler
                Integer key = new Integer(packet.getType());
                PacketHandler handler = (PacketHandler) ConnectionManager.getCallbacks().get(key);
                if (handler != null) {
                    handler.dispatch(packet);
                }
            }
        } catch (Exception ignore) {
        }

        // Xử lý disconnect
        try {
            if (ConnectionManager.isConnected && ConnectionManager.ConnectionListener != null) {
                ConnectionManager.ConnectionListener.onDisconnect();
            }
            if (ConnectionManager.getSocketConnection() != null) {
                ConnectionManager.resetConnection();
            }
        } catch (Exception ignore) {
        }
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

    private static byte[] readPayload(InputStream in, int payloadLength) throws IOException {
        byte[] payload = new byte[payloadLength];
        int readBytes = 0;
        while (readBytes < payloadLength) {
            int r = in.read(payload, readBytes, payloadLength - readBytes);
            if (r == -1) return null; // mất kết nối hoặc hết dữ liệu
            readBytes += r;
        }
        return payload;
    }

}
