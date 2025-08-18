package home.thienph.xyahoo;

final class thien_gk implements thien_ae {
   private final thien_at a;
   private final thien_at b;
   private final thien_an c;

   thien_gk(thien_ff var1, thien_at var2, thien_at var3, thien_an var4) {
      this.a = var2;
      this.b = var3;
      this.c = var4;
   }

   public final void a() {
      String var1 = this.a.c().trim().toLowerCase();
      String var2 = this.b.c().trim();
      String var13;
      boolean var15;
      if (var1.equals("")) {
         this.c.c(this.a);
      } else if (var2.equals("")) {
         this.c.c(this.b);
      } else {
         thien_s var10000 = thien_di.b().j.x.b();
         String var4 = var2;
         thien_s var3 = var10000;
         int var5 = var10000.a.size() - 1;

         while (true) {
            if (var5 < 0) {
               var13 = null;
               break;
            }

            thien_t var6;
            if ((var6 = (thien_t)var3.a.elementAt(var5)).a().toLowerCase().equals(var4.toLowerCase())) {
               var13 = var6.a();
               break;
            }

            var5--;
         }

         String var8 = var13;
         if (var13 != null) {
            var2 = var8;
         }

         var10000 = thien_di.b().j.x.b();
         var4 = var1;
         var3 = var10000;
         var5 = var10000.a.size() - 1;

         label46:
         while (true) {
            if (var5 < 0) {
               var15 = false;
               break;
            }

            thien_t var12;
            for (int var7 = (var12 = (thien_t)var3.a.elementAt(var5)).a.size() - 1; var7 >= 0; var7--) {
               if (((thien_r)var12.a.elementAt(var7)).a.equals(var4)) {
                  var15 = true;
                  break label46;
               }
            }

            var5--;
         }

         if (var15) {
            thien_di.b().b(thien_as.A());
         } else {
            MessageHandler.b(var1, var2, 1);
            thien_di.b().c(this.c);
            thien_di.b().d(thien_di.e);
         }
      }
   }
}
