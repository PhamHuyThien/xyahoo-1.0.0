package home.thienph.xyahoo;

public abstract class PacketHandler {
   protected abstract void handle(Packet var1, int commandId);

   public final void dispatch(Packet var1) {
      int var2 = var1.getCommandId();

      try {
         this.handle(var1, var2);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("oops = " + var3.toString());
      }
   }

   public abstract void onConnect();

   public abstract void onDisconnect();

   public abstract void shutdown();
}
