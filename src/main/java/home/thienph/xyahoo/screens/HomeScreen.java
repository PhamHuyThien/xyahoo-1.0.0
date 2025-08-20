package home.thienph.xyahoo.screens;

import home.thienph.xyahoo.actions.*;
import home.thienph.xyahoo.components.TextField;
import home.thienph.xyahoo.data.data.UIAction;
import home.thienph.xyahoo.components.UIGridMenu;
import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.data.data.PopupSideElementData;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import java.io.IOException;
import java.util.Vector;

public final class HomeScreen extends FormScreen {
   public static HomeScreen instance;
   private Vector menuActions;
   public PopupSideElementData popupMenuData;
   public TextField searchTextField = null;
   public boolean isInputBlocked;
   public UIGridMenu homeGridMenu;
   static UIAction infoAction = new UIAction(TextConstant.info(), new AppInfoAction());

   private void initializeHomeMenu() {
      String[] menuNames = new String[]{"Yahoo!", "Tiến Lên", "Games", "Tài Khoản"};
      int menuLength = (menuNames).length;

      try {
         Image[] menuImages = new Image[menuLength];

         for (byte var4 = 0; var4 < menuLength; var4++) {
            menuImages[var4] = Image.createImage("/Icn" + var4 + ".png");
         }

         this.homeGridMenu = new UIGridMenu(
            0, Screen.headerHeight + 7, Screen.e - 3, Screen.formHeight - 3 - GameManager.topMargin, menuLength, menuNames, null, null, menuImages[0].getWidth(), menuImages[0].getHeight(), true, 1
         );
         UIGridMenu var6 = this.homeGridMenu;
         this.homeGridMenu.images = menuImages;
         System.gc();
      } catch (IOException var5) {
      }

      this.addControl(this.homeGridMenu);
      this.selectControl(this.homeGridMenu);
      UIGridMenu var10000 = this.homeGridMenu;
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
      var4.addElement(infoAction);
      var4.addElement(var2);
      var4.addElement(LoginScreen.callButton);
      (var2 = new UIAction(TextConstant.support(), null)).popupSideElementData = new PopupSideElementData(var4);
      this.menuActions = new Vector();
      this.menuActions.addElement(var2);
      this.menuActions.addElement(settingAction);
      this.menuActions.addElement(var3);
      this.popupMenuData = new PopupSideElementData(this.menuActions);
      super.leftCommand = new UIAction("Menu", new OpenMenuHomeAction(this));
      this.initializeHomeMenu();
   }

   public final boolean handleInput(boolean[] var1, boolean[] var2, int[] var3) {
      if (this.isInputBlocked) {
         if (var1[12]) {
            var1[12] = false;
         } else if (var1[13]) {
            var1[13] = false;
         }
      }

      return super.handleInput(var1, var2, var3);
   }

   public static void navigateToScreen(int var0, int var1) {
      Screen var2;
      if ((var2 = GameManager.instance.findScreenById(var0)) != null) {
         GameManager.instance.closeTopDialog();
         var2.startSlide(1);
         GameManager.instance.switchToScreen(var2);
      } else {
         MessageHandler.a(var1);
      }
   }

   public final void openMenuByIndex(int menuId) {
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
            navigateToScreen(8888193, 5029);
         default:
            return;
         case 3:
            navigateToScreen(5000, 5018);
      }
   }

   public final void draw(Graphics var1) {
      super.draw(var1);
   }

   public final void updateLayout() {
      this.homeGridMenu.handleFocus();
   }

   public final void drawOverlay(Graphics var1) {
      this.homeGridMenu.drawScrollbar(var1);
   }

   public static void resetSearchField(HomeScreen var0) {
      var0.removeControl(var0.searchTextField);
      var0.selectControl(var0.homeGridMenu);
      var0.searchTextField.setText("");
      var0.isInputBlocked = false;
   }
}
