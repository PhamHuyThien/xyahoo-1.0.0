package home.thienph.xyahoo;

import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class thien_ca extends FormScreen {
   public static thien_ca D;
   private Vector J;
   PopupSideElementData E;
   TextField F = null;
   boolean G;
   public UIGridMenu H;
   static UIAction uiActionInfo = new UIAction(TextConstant.info(), new AppInfoAction());

   private void f() {
      String[] var1;
      int var2 = (var1 = new String[]{"Yahoo!", "Tiến Lên", "Games", "Tài Khoản"}).length;

      try {
         Image[] var3 = new Image[var2];

         for (byte var4 = 0; var4 < var2; var4++) {
            var3[var4] = Image.createImage("/Icn" + var4 + ".png");
         }

         this.H = new UIGridMenu(
            0, Screen.headerHeight + 7, Screen.e - 3, Screen.formHeight - 3 - GameManager.g, var2, var1, null, null, var3[0].getWidth(), var3[0].getHeight(), true, 1
         );
         UIGridMenu var6 = this.H;
         this.H.images = var3;
         System.gc();
      } catch (IOException var5) {
      }

      this.addControl(this.H);
      this.selectControl(this.H);
      UIGridMenu var10000 = this.H;
      UIAction var7 = new UIAction(TextConstant.select(), new thien_cc(this));
      var10000.actionTertiary = var7;
   }

   public thien_ca() {
      super.title = "X Yahoo!";
      D = this;
      UIAction var1 = new UIAction(TextConstant.settings(), new thien_cd(this));
      UIAction var2 = new UIAction(TextConstant.comment(), new thien_ce(this));
      UIAction var3 = new UIAction(TextConstant.signOut(), new thien_ch(this));
      Vector var4;
      (var4 = new Vector()).addElement(uiActionInfo);
      var4.addElement(var2);
      var4.addElement(LoginScreen.callButton);
      (var2 = new UIAction(TextConstant.support(), null)).popupSideElementData = new PopupSideElementData(var4);
      this.J = new Vector();
      this.J.addElement(var2);
      this.J.addElement(var1);
      this.J.addElement(var3);
      this.E = new PopupSideElementData(this.J);
      super.leftCommand = new UIAction("Menu", new thien_cj(this));
      this.f();
   }

   public final boolean handleInput(boolean[] var1, boolean[] var2, int[] var3) {
      if (this.G) {
         if (var1[12]) {
            var1[12] = false;
         } else if (var1[13]) {
            var1[13] = false;
         }
      }

      return super.handleInput(var1, var2, var3);
   }

   public static void f(int var0, int var1) {
      Screen var2;
      if ((var2 = GameManager.instance.d(var0)) != null) {
         GameManager.instance.c();
         var2.startSlide(1);
         GameManager.instance.d(var2);
      } else {
         MessageHandler.a(var1);
      }
   }

   public final void e(int var1) {
      GameManager var2 = GameManager.instance;
      System.gc();
      switch (var1) {
         case 0:
            var2.y();
            return;
         case 1:
            if (GameManager.a) {
               var2.x();
               return;
            }

            MessageHandler.a(5009);
            return;
         case 2:
            f(8888193, 5029);
         default:
            return;
         case 3:
            f(5000, 5018);
      }
   }

   public final void draw(Graphics var1) {
      super.draw(var1);
   }

   public final void updateLayout() {
      this.H.handleFocus();
   }

   public final void drawOverlay(Graphics var1) {
      this.H.drawScrollbar(var1);
   }

   static void a(thien_ca var0) {
      var0.removeControl(var0.F);
      var0.selectControl(var0.H);
      var0.F.setText("");
      var0.G = false;
   }
}
