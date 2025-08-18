package home.thienph.xyahoo;

public final class thien_eu extends thien_hh {
   private static thien_eu a = null;
   private static thien_et b;

   public final void b() {
      b.p();
   }

   public final void c() {
      b.q();
   }

   protected final void a(Packet var1, int var2) {
      switch (var2) {
         case -5:
            b.B();
            return;
         case 3:
            String var20 = MessageHandler.readString(var1);
            MessageHandler.readString(var1);
            String var22 = MessageHandler.readString(var1);
            b.b(var20, var22);
            return;
         case 5:
            String var17 = MessageHandler.readString(var1);
            int var19 = MessageHandler.readInt(var1);
            String var21 = MessageHandler.readString(var1);
            MessageHandler.readString(var1);
            MessageHandler.readString(var1);
            MessageHandler.readString(var1);
            b.a(var17, var19, 2);
            b.a(var17, var21, 2);
            return;
         case 6:
            thien_s var16 = new thien_s();
            int var3 = MessageHandler.readInt(var1);

            for (int var4 = 0; var4 < var3; var4++) {
               String var5 = MessageHandler.readString(var1);
               thien_t var6 = new thien_t(var5);
               int var18 = MessageHandler.readInt(var1);

               for (int var7 = 0; var7 < var18; var7++) {
                  String var23 = MessageHandler.readString(var1);
                  int var24 = MessageHandler.readInt(var1);
                  String var25 = MessageHandler.readString(var1);
                  MessageHandler.readString(var1);
                  String var26 = MessageHandler.readString(var1);
                  MessageHandler.readString(var1);
                  var6.a(new thien_r(var23, var26, var24, var25, new int[0], 0, 0));
               }

               var16.a.addElement(var6);
            }

            b.a(var16);
            return;
         case 27:
            String var15 = MessageHandler.readString(var1);
            String var13 = MessageHandler.readString(var1);
            System.out.println("fromUser = " + var15 + "; toUser = " + var13);
            b.i(var15);
            return;
         case 32:
            String var8 = MessageHandler.readString(var1);
            MessageHandler.readString(var1);
            String var9 = MessageHandler.readString(var1);
            String var10 = MessageHandler.readString(var1);
            b.a(var8, var9, var10);
            return;
         case 34:
            int var12;
            if ((var12 = MessageHandler.readInt(var1)) == -1) {
               b.t();
               return;
            }

            if (var12 == -2 || var12 == 34) {
               b.s();
               return;
            }
            break;
         case 55:
            return;
         case 56:
            int var11 = MessageHandler.readInt(var1);
            b.b(var11);
            return;
         case 77:
            String var14 = MessageHandler.readString(var1);
            MessageHandler.readString(var1);
            MessageHandler.readString(var1);
            b.l(var14);
      }
   }

   public static thien_eu a() {
      if (a == null) {
         a = new thien_eu();
      }

      return a;
   }

   public static void a(thien_et var0) {
      b = var0;
   }

   public final void d() {
   }
}
