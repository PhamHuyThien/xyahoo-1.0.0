package home.thienph.xyahoo.screens;

import home.thienph.xyahoo.actions.*;
import home.thienph.xyahoo.components.TextField;
import home.thienph.xyahoo.components.UITextLabel;
import home.thienph.xyahoo.data.data.UIAction;
import home.thienph.xyahoo.components.BuddyListControl;
import home.thienph.xyahoo.components.UIDropdown;
import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.data.data.PopupSideElementData;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.main.*;
import home.thienph.xyahoo.utils.TextRenderer;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class BuddyListScreen extends Screen {
   public static int[] onlineStatusIcons;
   public BuddyListControl buddyList;
   public static String currentGroupName;
   public static String userFullName;
   public static String userStatusMessage;
   public static int userStatus;
   public static boolean isRankingEnabled;
   public static String tempStatusMessage = "";
   public static String pendingChatTarget;
   public static byte selectedAction;
   public static String lastErrorMessage;
   public static int scrollOffset;
   private Vector menuActions;
   public PopupSideElementData popupMenuData;
   private boolean isSearchActive;
   private final TextField searchField;

   public static void resetPendingChat() {
      pendingChatTarget = null;
   }

   public final void renameGroup() {
      String var1;
      if (!(var1 = this.buddyList.getCurrentGroupName()).equals(TextConstant.services())) {
         thien_cl var2;
         (var2 = new thien_cl(TextConstant.rename(), TextConstant.typeNewNameForGroup() + "\"" + this.buddyList.getCurrentGroupName() + "\"")).textField.setText(var1);
         var2.a(new thien_fg(this, var2, var1));
         GameManager.getInstance().showScreen(var2);
         GameManager.getInstance().goToLastScreen();
      }
   }

   public final void startChatWithUser() {
      thien_cl var1;
      (var1 = new thien_cl(TextConstant.chatTo(), TextConstant.enterTheIdYouWantToChat())).a(new thien_fq(this, var1));
      GameManager.getInstance().showScreen(var1);
      GameManager.getInstance().goToLastScreen();
   }

   public final void handleChatAction(String var1, int var2) {
      if (var2 == 0) {
         ChatRoomScreen var3 = GameManager.getInstance().createChatRoom(var1);
         GameManager.getInstance().switchToScreenByTitle(var3.title);
      } else {
         if (var2 == 1) {
            this.showAddFriendScreen(var1);
         }
      }
   }

   public final void createConference() {
      Screen var1;
      (var1 = new Screen()).title = TextConstant.conference();
      int var2;
      if ((var2 = GameCanvas.screenWidth - 30) > 150) {
         var2 = 180;
      }

      if (var2 < 100) {
         var2 = 100;
      }

      int var3 = GameCanvas.screenWidth - var2 >> 1;
      UITextLabel var5 = new UITextLabel(TextConstant.conferenceSubject(), var3, 10, TextRenderer.fontHeight);
      int var4 = 10 + 1 + var5.height;
      TextField var6;
      (var6 = new TextField()).setBounds(var3, var4, var2, TextRenderer.fontHeight + 6);
      var6.setMaxLength(100);
      var6.setText("");
      var1.addControl(var5);
      var1.addControl(var6);
      var1.selectControl(var6);
      var1.centerCommand = new UIAction("OK", new thien_gb(this, var6, var1));
      var1.leftCommand = new UIAction(TextConstant.cancel(), new thien_gi(this, var1));
      GameManager.getInstance().showScreen(var1);
      GameManager.getInstance().goToLastScreen();
   }

   public final void showAddFriendScreen(String var1) {
      GameManager.currentScreen = GameManager.getInstance().getCurrentScreen();
      Screen screen = new Screen();
      screen.title = TextConstant.addFriend();
      int var3;
      if ((var3 = GameCanvas.screenWidth - 30) > 150) {
         var3 = 180;
      }

      if (var3 < 100) {
         var3 = 100;
      }

      int var4 = GameCanvas.screenWidth - var3 >> 1;
      UITextLabel var6 = new UITextLabel(TextConstant.addId(), var4, 10, TextRenderer.fontHeight);
      int var5 = 10 + 1 + var6.height;
      TextField var7;
      (var7 = new TextField()).setBounds(var4, var5, var3, TextRenderer.fontHeight + 6);
      var7.setText(var1);
      var5 += 5 + var7.height;
      UITextLabel var11 = new UITextLabel(TextConstant.toNewGroup(), var4, var5, TextRenderer.fontHeight);
      var5 += 1 + var11.height;
      TextField var8;
      (var8 = new TextField()).setBounds(var4, var5, var3, TextRenderer.fontHeight + 6);
      String var9 = this.buddyList.getCurrentGroupName();
      var8.setText(var9);
      if (var8.getText().equals("") || var8.getText().equals(TextConstant.services())) {
         var8.setText("Friends");
      }

      var5 += 5 + var8.height;
      UITextLabel var10 = new UITextLabel(TextConstant.orExisting(), var4, var5, TextRenderer.fontHeight);
      var5 += 1 + var10.height;
      UIDropdown var12;
      (var12 = new UIDropdown(this.buddyList.getGroupNames(), var4, var5, var3, TextRenderer.fontHeight + 6)).setSelectedItem(var9);
      var12.changeHandler = new thien_gj(this, var8, var12);
      screen.addControl(var6);
      screen.addControl(var7);
      screen.addControl(var11);
      screen.addControl(var8);
      screen.addControl(var10);
      screen.addControl(var12);
      screen.selectControl(var7);
      screen.centerCommand = new UIAction("OK", new thien_gk(this, var7, var8, screen));
      screen.leftCommand = new UIAction(TextConstant.cancel(), new thien_gl(this, screen));
      GameManager.instance.pushScreen(screen);
      GameManager.getInstance().goToLastScreen();
   }

   public final void broadcastMessage() {
      Screen var1;
      (var1 = new Screen()).title = TextConstant.broadcastMessage();
      int var2;
      if ((var2 = GameCanvas.screenWidth - 30) > 150) {
         var2 = 180;
      }

      if (var2 < 100) {
         var2 = 100;
      }

      int var3 = GameCanvas.screenWidth - var2 >> 1;
      UITextLabel var5 = new UITextLabel(TextConstant.broadcastMessage2(), var3, 10, TextRenderer.fontHeight);
      int var4 = 10 + 5 + var5.height;
      TextField var6;
      (var6 = new TextField()).setBounds(var3, var4, var2, TextRenderer.fontHeight + 6);
      var4 += 5 + var6.height;
      UITextLabel var7 = new UITextLabel(TextConstant.toGroup(), var3, var4, TextRenderer.fontHeight);
      var4 += 1 + var7.height;
      UIDropdown var8;
      (var8 = new UIDropdown(this.buddyList.getGroupNames(), var3, var4, var2, TextRenderer.fontHeight + 6)).setSelectedItem(this.buddyList.getCurrentGroupName());
      var1.addControl(var5);
      var1.addControl(var6);
      var1.addControl(var7);
      var1.addControl(var8);
      var1.selectControl(var6);
      var1.centerCommand = new UIAction("OK", new thien_gm(this, var6, var8, var1));
      Vector var9;
      (var9 = new Vector()).addElement(new UIAction(TextConstant.paste(), new thien_gn(this, var6)));
      var9.addElement(new UIAction(TextConstant.cancel(), new thien_fh(this, var1)));
      PopupSideElementData var10 = new PopupSideElementData(var9);
      var1.leftCommand = new UIAction("Menu", new thien_fi(this, var10));
      GameManager.getInstance().showScreen(var1);
      GameManager.getInstance().goToLastScreen();
   }

   public final void moveUserToGroup() {
      String var1;
      if (!(var1 = this.buddyList.getSelectedItem().displayName).equals(TextConstant.selectService())) {
         Screen var2;
         (var2 = new Screen()).title = TextConstant.moveId3();
         int var3;
         if ((var3 = GameCanvas.screenWidth - 30) > 150) {
            var3 = 180;
         }

         if (var3 < 100) {
            var3 = 100;
         }

         int var4 = GameCanvas.screenWidth - var3 >> 1;
         UITextLabel var6 = new UITextLabel(TextConstant.moveId2() + var1, var4, 10, TextRenderer.fontHeight);
         int var5 = 10 + 5 + var6.height;
         UITextLabel var7 = new UITextLabel(TextConstant.toNewGroup(), var4, var5, TextRenderer.fontHeight);
         var5 += 1 + var7.height;
         TextField var8;
         (var8 = new TextField()).setBounds(var4, var5, var3, TextRenderer.fontHeight + 6);
         String var9 = this.buddyList.getCurrentGroupName();
         var8.setText(var9);
         if (var8.getText().equals("") || var8.getText().equals(TextConstant.services())) {
            var8.setText("Friends");
         }

         var5 += 5 + var8.height;
         UITextLabel var10 = new UITextLabel(TextConstant.orExisting(), var4, var5, TextRenderer.fontHeight);
         var5 += 1 + var10.height;
         UIDropdown var11;
         (var11 = new UIDropdown(this.buddyList.getGroupNames(), var4, var5, var3, TextRenderer.fontHeight + 6)).setSelectedItem(var9);
         var11.changeHandler = new thien_fj(this, var8, var11);
         var2.addControl(var6);
         var2.addControl(var7);
         var2.addControl(var8);
         var2.addControl(var10);
         var2.addControl(var11);
         var2.selectControl(var8);
         var2.centerCommand = new UIAction("OK", new thien_fk(this, var8, var2, var9, var1));
         var2.leftCommand = new UIAction(TextConstant.cancel(), new thien_fl(this, var2));
         GameManager.getInstance().showScreen(var2);
         GameManager.getInstance().goToLastScreen();
      }
   }

   public final void showStatusSettings() {
      Screen var1;
      (var1 = new Screen()).title = TextConstant.status();
      int var2;
      if ((var2 = GameCanvas.screenWidth - 30) > 150) {
         var2 = 180;
      }

      if (var2 < 100) {
         var2 = 100;
      }

      int var3 = GameCanvas.screenWidth - var2 >> 1;
      UITextLabel var5 = new UITextLabel(TextConstant.statusMessage(), var3, 10, TextRenderer.fontHeight);
      int var4 = 10 + 1 + var5.height;
      TextField var6;
      (var6 = new TextField()).setBounds(var3, var4, var2, TextRenderer.fontHeight + 6);
      var6.setMaxLength(255);
      var6.setText(tempStatusMessage);
      var4 += 10 + var6.height;
      UITextLabel var7 = new UITextLabel(TextConstant.status(), var3, var4, TextRenderer.fontHeight);
      var4 += 1 + var7.height;
      UIDropdown var8 = new UIDropdown(new String[]{TextConstant.available(), TextConstant.invisible2()}, var3, var4, var2, TextRenderer.fontHeight + 6);
      var8.setSelectedIndex(userStatus == 1 ? 0 : 1);
      var8.changeHandler = new thien_fm(this);
      var1.addControl(var5);
      var1.addControl(var6);
      var1.addControl(var7);
      var1.addControl(var8);
      var1.selectControl(var6);
      var1.centerCommand = new UIAction("OK", new thien_fn(this, var6, var8, var1));
      var1.leftCommand = new UIAction(TextConstant.cancel(), new thien_fo(this, var1));
      GameManager.getInstance().showScreen(var1);
      GameManager.getInstance().goToLastScreen();
   }

   public final void showChangePassword() {
      Screen var1;
      (var1 = new Screen()).title = TextConstant.changePassword();
      int var2;
      if ((var2 = GameCanvas.screenWidth - 30) > 150) {
         var2 = 180;
      }

      if (var2 < 100) {
         var2 = 100;
      }

      int var3 = GameCanvas.screenWidth - var2 >> 1;
      UITextLabel var5 = new UITextLabel(TextConstant.oldPassword(), var3, 10, TextRenderer.fontHeight);
      int var4 = 10 + 1 + var5.height;
      TextField var6;
      (var6 = new TextField()).setInputType(2);
      var6.setBounds(var3, var4, var2, TextRenderer.fontHeight + 6);
      var4 += var6.height + 6;
      UITextLabel var7 = new UITextLabel(TextConstant.newPassword(), var3, var4, TextRenderer.fontHeight);
      var4 += 1 + var7.height;
      TextField var8;
      (var8 = new TextField()).setInputType(2);
      var8.setBounds(var3, var4, var2, TextRenderer.fontHeight + 6);
      var4 += var8.height + 6;
      UITextLabel var9 = new UITextLabel(TextConstant.retype(), var3, var4, TextRenderer.fontHeight);
      var4 += 1 + var7.height;
      TextField var10;
      (var10 = new TextField()).setInputType(2);
      var10.setBounds(var3, var4, var2, TextRenderer.fontHeight + 6);
      var1.addControl(var5);
      var1.addControl(var6);
      var1.addControl(var7);
      var1.addControl(var8);
      var1.addControl(var9);
      var1.addControl(var10);
      var1.selectControl(var6);
      var1.centerCommand = new UIAction("OK", new thien_fp(this, var6, var8, var10, var1));
      var1.leftCommand = new UIAction(TextConstant.cancel(), new thien_fr(this, var1));
      GameManager.getInstance().showScreen(var1);
      GameManager.getInstance().goToLastScreen();
   }

   public final void showChangeFullName() {
      thien_cl var1;
      (var1 = new thien_cl(TextConstant.changeFullname(), TextConstant.changeFullname())).textField.setText(userFullName);
      var1.a(new thien_fs(this, var1));
      GameManager.getInstance().showScreen(var1);
      GameManager.getInstance().goToLastScreen();
   }

   public BuddyListScreen() {
      isRankingEnabled = Xuka.readFlag("onrank", false);
      super.isLocked = true;
      super.title = TextConstant.buddies();
      this.searchField = new TextField();
      this.searchField.isShiftMode = true;
      this.searchField.setBounds(0, Screen.formHeight - GameManager.topMargin - TextRenderer.fontHeight - 11, Screen.e - 6, TextRenderer.fontHeight + 6);
      this.buddyList = new BuddyListControl(1, 1, Screen.e - 3, Screen.formHeight - 2 - GameManager.topMargin, true);
      this.buddyList.isAutoChatEnabled = false;
      this.buddyList.isScrollable = true;
      this.addControl(this.buddyList);
      this.selectControl(this.buddyList);
      this.menuActions = new Vector();
      this.menuActions.addElement(new UIAction(TextConstant.addFriend(), new thien_ft(this)));
      this.menuActions.addElement(new UIAction(TextConstant.status(), new thien_fu(this)));
      Vector var1;
      (var1 = new Vector()).addElement(new UIAction(TextConstant.showHideOffline(), new thien_fv(this)));
      var1.addElement(new UIAction("Avatar", new thien_fw(this)));
      UIAction var2;
      (var2 = new UIAction(TextConstant.showHide(), null)).popupSideElementData = new PopupSideElementData(var1);
      this.menuActions.addElement(var2);
      (var1 = new Vector()).addElement(new UIAction(TextConstant.changeFullname(), new thien_fx(this)));
      var1.addElement(new UIAction(TextConstant.changePassword(), new thien_fy(this)));
      (var2 = new UIAction(TextConstant.changeUserProfile(), null)).popupSideElementData = new PopupSideElementData(var1);
      this.menuActions.addElement(var2);
      (var1 = new Vector()).addElement(new UIAction(TextConstant.renameMoveId(), new thien_fz(this)));
      var1.addElement(new UIAction(TextConstant.delete(), new thien_ga(this)));
      var1.addElement(new UIAction(TextConstant.ignoreList(), new thien_gc(this)));
      var1.addElement(new UIAction(TextConstant.chatToo(), new thien_gd(this)));
      var1.addElement(new UIAction(TextConstant.conference(), new thien_ge(this)));
      var1.addElement(new UIAction(TextConstant.broadcastMessage(), new thien_gf(this)));
      (var2 = new UIAction(TextConstant.otherTools(), null)).popupSideElementData = new PopupSideElementData(var1);
      this.menuActions.addElement(var2);
      this.menuActions.addElement(new UIAction(TextConstant.close(), new thien_gg(this)));
      this.popupMenuData = new PopupSideElementData(this.menuActions);
      super.leftCommand = new UIAction("Menu", new thien_gh(this));
   }

   public static void n() {
      MessageHandler.d();
      GameManager.instance.a(GameManager.blockedUsers);
   }

   public final void o() {
      if (this.buddyList.displayItems != null) {
         this.buddyList.displayItems.removeAllElements();
      }

      this.buddyList.displayItems = null;
      this.buddyList.contactDataSource = null;
   }

   public final boolean handleInput(boolean[] var1, boolean[] var2, int[] var3) {
      if (var3[0] > 32 && !this.isSearchActive) {
         this.searchField.setText("");
         this.addControl(this.searchField);
         this.selectControl(this.searchField);
         this.isSearchActive = true;
      }

      String var4 = "";
      if (this.isSearchActive) {
         if (var1[12]) {
            var1[12] = false;
            this.buddyList.handleKeyInput(12);
         } else if (var1[13]) {
            var1[13] = false;
            this.buddyList.handleKeyInput(13);
         } else if (var1[16]) {
            var1[16] = false;
            this.buddyList.handleKeyInput(16);
         }

         var4 = this.searchField.getText();
      }

      super.handleInput(var1, var2, var3);
      if (this.isSearchActive) {
         if (this.searchField.getText().equals("")) {
            this.selectControl(this.buddyList);
            this.removeControl(this.searchField);
            this.isSearchActive = false;
         }

         if (!this.searchField.getText().equals(var4)) {
            this.buddyList.setSearchFilter(this.searchField.getText());
         }
      }

      return true;
   }

   public final void updateLayout() {
      this.buddyList.handleFocus();
   }

   public final void drawOverlay(Graphics var1) {
      this.buddyList.drawScrollbar(var1);
   }
}
