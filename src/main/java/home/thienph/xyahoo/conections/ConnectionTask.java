package home.thienph.xyahoo.conections;

import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.SocketConnection;

final class ConnectionTask implements Runnable {
   private final String primaryHost;
   private final String backupHost;
   private final int primaryPort;
   private final int backupPort;

   ConnectionTask(String var1, String var2, int var3, int var4) {
      this.primaryHost = var1;
      this.backupHost = var2;
      this.primaryPort = var3;
      this.backupPort = var4;
   }

   public final void run() {
      ConnectionManager.isConnecting = true;
      ConnectionManager.isConnected = true;

      try {
         connectToHost(this.primaryHost, this.primaryPort);
      } catch (Exception var4) {
         try {
            connectToHost(this.backupHost, this.backupPort);
         } catch (Exception var3) {
            ConnectionManager.isConnected = false;

            try {
               if (ConnectionManager.packetHandler != null) {
                  ConnectionManager.disconnect();
                  ConnectionManager.packetHandler.onConnect();
                  return;
               }
            } catch (Exception var2) {
               var3.printStackTrace();
            }
         }
      }
   }

   private static void connectToHost(String var0, int var1) throws IOException {
      System.out.println("Connecting to " + var0);

      try {
         ConnectionManager.setSocketConnection((SocketConnection)Connector.open("socket://" + var0 + ":" + var1));
      } catch (Exception var3) {
         System.out.println("sc " + var3.toString());
         throw new IOException();
      }

      try {
         ConnectionManager.getSocketConnection().setSocketOption((byte)2, 1);
      } catch (Exception var2) {
         System.out.println("kp " + var2.toString());
      }

      ConnectionManager.setOutputStream(ConnectionManager.getSocketConnection().openDataOutputStream());
      ConnectionManager.inputStream = ConnectionManager.getSocketConnection().openInputStream();
      (ConnectionManager.writerThread = new Thread(ConnectionManager.getPacketWriter())).start();
      (ConnectionManager.readerThread = new Thread(new PacketReaderThread())).start();
      ConnectionManager.isConnecting = false;
      ConnectionManager.packetHandler.shutdown();
      System.out.println("Connected!");
   }
}
