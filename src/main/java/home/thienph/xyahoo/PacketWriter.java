package home.thienph.xyahoo;

import java.io.IOException;
import java.util.Vector;

final class PacketWriter implements Runnable {
    private final Vector outgoingQueue = new Vector();

    public PacketWriter() {
    }

    public final void enqueue(Packet var1) {
        this.outgoingQueue.addElement(var1);
    }

    private static byte[] intToByteArray(int var0) {
        byte[] var1 = new byte[4];

        for (int var2 = 3; var2 >= 0; var2--) {
            var1[var2] = (byte) var0;
            var0 >>= 8;
        }

        return var1;
    }

    public final void run() {
        while (ConnectionManager.isConnected()) {
            try {
                while (this.outgoingQueue.size() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Packet packet = (Packet) this.outgoingQueue.elementAt(0);
                    this.outgoingQueue.removeElementAt(0);
                    ByteBuffer payload = packet.getPayload();
                    int packetLength = 8 + payload.getLength();
                    byte[] packetByteLength = intToByteArray(packetLength);
                    ConnectionManager.getOutputStream().write(packetByteLength, 0, 4);
                    ConnectionManager.getOutputStream().write(intToByteArray(packet.getCommandId()), 0, 4);
                    ConnectionManager.getOutputStream().write(intToByteArray(packet.getType()), 0, 4);
                    ConnectionManager.getOutputStream().write(payload.getBuffer(), 0, packetLength - 8);
                    ConnectionManager.dataUsage += packetLength + 4;
                    ConnectionManager.getOutputStream().flush();
                    long totalTime = 100L - (System.currentTimeMillis() - currentTimeMillis);
                    if (totalTime > 0L) {
                        Thread.sleep(totalTime);
                    }
                }
                Thread.sleep(50L);
            } catch (IOException e) {
                System.err.println("PacketWriter.run IOException: " + e);
                e.printStackTrace();
                ConnectionManager.disconnect();
            } catch (Exception e) {
                System.err.println("PacketWriter.run Exception: " + e);
                e.printStackTrace();
            }
        }

        if (ConnectionManager.isConnected && ConnectionManager.ConnectionListener != null) {
            ConnectionManager.ConnectionListener.onDisconnect();
        }
    }
}
