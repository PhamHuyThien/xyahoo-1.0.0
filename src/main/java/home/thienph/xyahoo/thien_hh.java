package home.thienph.xyahoo;

public abstract class thien_hh {
   protected abstract void a(Packet var1, int var2);

   public final void a(Packet var1) {
      int var2 = var1.getCommandId();

      try {
         this.a(var1, var2);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("oops = " + var3.toString());
      }
   }

   public abstract void b();

   public abstract void c();

   public abstract void d();
}
