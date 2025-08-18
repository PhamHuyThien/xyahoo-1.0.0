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
                    long var1 = System.currentTimeMillis();
                    Packet var3 = (Packet) this.outgoingQueue.elementAt(0);
                    this.outgoingQueue.removeElementAt(0);
                    ByteBuffer var4 = var3.getPayload();
                    int var5;
                    byte[] var6 = intToByteArray(var5 = 8 + var4.getLength());
                    ConnectionManager.getOutputStream().write(var6, 0, 4);
                    ConnectionManager.getOutputStream().write(intToByteArray(var3.getCommandId()), 0, 4);
                    ConnectionManager.getOutputStream().write(intToByteArray(var3.getType()), 0, 4);
                    ConnectionManager.getOutputStream().write(var4.getBuffer(), 0, var5 - 8);
                    ConnectionManager.reconnectCount += var5 + 4;
                    ConnectionManager.getOutputStream().flush();
                    long var7;
                    if ((var7 = 100L - (System.currentTimeMillis() - var1)) > 0L) {
                        Thread.sleep(var7);
                    }
                }

                Thread.sleep(50L);
            } catch (IOException var9) {
                var9.printStackTrace();
                ConnectionManager.disconnect();
            } catch (Exception var10) {
            }
        }

        if (ConnectionManager.isConnected && ConnectionManager.ConnectionListener != null) {
            ConnectionManager.ConnectionListener.onDisconnect();
        }
    }
}
