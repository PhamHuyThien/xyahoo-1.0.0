package home.thienph.xyahoo;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class InviteConferenceScreen extends Screen {
   private UIBuddyListControl buddyListControl = GameManager.getInstance().buddyListScreen.buddyList;
   String w;
   String x;
   private boolean isSearchActive;
   private final TextField searchField = new TextField();

   public final String[] getSelectedBuddyIds() {
      Vector var1 = new Vector();
      Vector var2 = this.buddyListControl.visibleItems;

      for (int var3 = 0; var3 < var2.size(); var3++) {
         thien_u var4;
         if ((var4 = (thien_u)var2.elementAt(var3)).a == 0 && var4.h) {
            var4.h = false;
            var1.addElement(var4.d);
         }
      }

      String[] var5 = new String[var1.size()];

      for (int var6 = 0; var6 < var5.length; var6++) {
         var5[var6] = (String)var1.elementAt(var6);
      }

      return var5;
   }

   public InviteConferenceScreen() {
      this.searchField.isShiftMode = true;
      this.searchField.setBounds(0, Screen.formHeight - GameManager.g - TextRenderer.fontHeight - 11, Screen.e - 6, TextRenderer.fontHeight + 6);
      super.title = TextConstant.inviteConference();
      this.addControl(this.buddyListControl);
      this.selectControl(this.buddyListControl);
      super.rightCommand = new UIAction("OK", new thien_co(this));
      super.leftCommand = new UIAction(TextConstant.cancel(), new thien_cp(this));
   }

   public final void clearBuddyList() {
      if (this.buddyListControl.visibleItems != null) {
         this.buddyListControl.visibleItems.removeAllElements();
      }

      this.buddyListControl.visibleItems = null;
      this.buddyListControl.buddyDataModel = null;
   }

   public final void updateLayout() {
      this.buddyListControl.handleFocus();
   }

   public final void drawOverlay(Graphics var1) {
      this.buddyListControl.drawScrollbar(var1);
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
            this.buddyListControl.handleKeyInput(12);
         } else if (var1[13]) {
            var1[13] = false;
            this.buddyListControl.handleKeyInput(13);
         } else if (var1[16]) {
            var1[16] = false;
            this.buddyListControl.handleKeyInput(16);
         }

         var4 = this.searchField.getText();
      }

      super.handleInput(var1, var2, var3);
      if (this.isSearchActive) {
         if (this.searchField.getText().equals("")) {
            this.selectControl(this.buddyListControl);
            this.removeControl(this.searchField);
            this.isSearchActive = false;
         }

         if (!this.searchField.getText().equals(var4)) {
            this.buddyListControl.d(this.searchField.getText());
         }
      }

      return true;
   }
}
