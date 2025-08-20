package home.thienph.xyahoo;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import java.io.IOException;
import java.util.Vector;

public final class HomeScreen extends FormScreen {
   public static HomeScreen instance;
   private Vector J;
   PopupSideElementData E;
   TextField F = null;
   boolean G;
   public UIGridMenu menuHome;
   static UIAction uiActionInfo = new UIAction(TextConstant.info(), new AppInfoAction());

   private void f() {
      String[] menuNames = new String[]{"Yahoo!", "Tiến Lên", "Games", "Tài Khoản"};
      int menuLength = (menuNames).length;

      try {
         Image[] menuImages = new Image[menuLength];

         for (byte var4 = 0; var4 < menuLength; var4++) {
            menuImages[var4] = Image.createImage("/Icn" + var4 + ".png");
         }

         this.menuHome = new UIGridMenu(
            0, Screen.headerHeight + 7, Screen.e - 3, Screen.formHeight - 3 - GameManager.topMargin, menuLength, menuNames, null, null, menuImages[0].getWidth(), menuImages[0].getHeight(), true, 1
         );
         UIGridMenu var6 = this.menuHome;
         this.menuHome.images = menuImages;
         System.gc();
      } catch (IOException var5) {
      }

      this.addControl(this.menuHome);
      this.selectControl(this.menuHome);
      UIGridMenu var10000 = this.menuHome;
      UIAction var7 = new UIAction(TextConstant.select(), new SelectMenuHomeAction(this));
      var10000.actionTertiary = var7;
   }

   public HomeScreen() {
      super.title = "X Yahoo!";
      instance = this;
      UIAction settingAction = new UIAction(TextConstant.settings(), new HomeSettingAction(this));
      UIAction var2 = new UIAction(TextConstant.comment(), new HomeCommentAction(this));
      UIAction var3 = new UIAction(TextConstant.signOut(), new HomeSignOutAction(this));
      Vector var4 = new Vector();
      var4.addElement(uiActionInfo);
      var4.addElement(var2);
      var4.addElement(LoginScreen.callButton);
      (var2 = new UIAction(TextConstant.support(), null)).popupSideElementData = new PopupSideElementData(var4);
      this.J = new Vector();
      this.J.addElement(var2);
      this.J.addElement(settingAction);
      this.J.addElement(var3);
      this.E = new PopupSideElementData(this.J);
      super.leftCommand = new UIAction("Menu", new OpenMenuHomeAction(this));
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
      if ((var2 = GameManager.instance.findScreenById(var0)) != null) {
         GameManager.instance.closeTopDialog();
         var2.startSlide(1);
         GameManager.instance.switchToScreen(var2);
      } else {
         MessageHandler.a(var1);
      }
   }

   public final void openMenu(int menuId) {
      GameManager var2 = GameManager.instance;
      System.gc();
      switch (menuId) {
         case 0:
            var2.displayYahooLogin();
            return;
         case 1:
            if (GameManager.isTestMode) {
               var2.showRoomList();
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
      this.menuHome.handleFocus();
   }

   public final void drawOverlay(Graphics var1) {
      this.menuHome.drawScrollbar(var1);
   }

   static void a(HomeScreen var0) {
      var0.removeControl(var0.F);
      var0.selectControl(var0.menuHome);
      var0.F.setText("");
      var0.G = false;
   }
}
