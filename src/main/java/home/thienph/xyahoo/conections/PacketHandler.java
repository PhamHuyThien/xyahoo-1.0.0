package home.thienph.xyahoo.conections;

import home.thienph.xyahoo.data.networks.Packet;

public abstract class PacketHandler {
   protected abstract void handle(Packet var1, int commandId);

   public final void dispatch(Packet packet) {
      int commandId = packet.getCommandId();

      try {
         this.handle(packet, commandId);
      } catch (Exception e) {
         System.err.println("PacketHandler.dispatch Exception: " + e);
         e.printStackTrace();
      }
   }

   public abstract void onConnect();

   public abstract void onDisconnect();

   public abstract void shutdown();
}
