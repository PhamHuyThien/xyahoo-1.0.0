package home.thienph.xyahoo;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class thien_cn extends Screen {
   private thien_b y = GameManager.getInstance().j.buddyList;
   String w;
   String x;
   private boolean z;
   private final TextField A = new TextField();

   public final String[] e() {
      Vector var1 = new Vector();
      Vector var2 = this.y.l;

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

   public thien_cn() {
      this.A.isShiftMode = true;
      this.A.setBounds(0, Screen.formHeight - GameManager.g - TextRenderer.fontHeight - 11, Screen.e - 6, TextRenderer.fontHeight + 6);
      super.title = TextConstant.inviteConference();
      this.addControl(this.y);
      this.selectControl(this.y);
      super.rightCommand = new UIAction("OK", new thien_co(this));
      super.leftCommand = new UIAction(TextConstant.cancel(), new thien_cp(this));
   }

   public final void f() {
      if (this.y.l != null) {
         this.y.l.removeAllElements();
      }

      this.y.l = null;
      this.y.k = null;
   }

   public final void updateLayout() {
      this.y.handleFocus();
   }

   public final void drawOverlay(Graphics var1) {
      this.y.drawScrollbar(var1);
   }

   public final boolean handleInput(boolean[] var1, boolean[] var2, int[] var3) {
      if (var3[0] > 32 && !this.z) {
         this.A.setText("");
         this.addControl(this.A);
         this.selectControl(this.A);
         this.z = true;
      }

      String var4 = "";
      if (this.z) {
         if (var1[12]) {
            var1[12] = false;
            this.y.handleKeyInput(12);
         } else if (var1[13]) {
            var1[13] = false;
            this.y.handleKeyInput(13);
         } else if (var1[16]) {
            var1[16] = false;
            this.y.handleKeyInput(16);
         }

         var4 = this.A.getText();
      }

      super.handleInput(var1, var2, var3);
      if (this.z) {
         if (this.A.getText().equals("")) {
            this.selectControl(this.y);
            this.removeControl(this.A);
            this.z = false;
         }

         if (!this.A.getText().equals(var4)) {
            this.y.d(this.A.getText());
         }
      }

      return true;
   }
}
