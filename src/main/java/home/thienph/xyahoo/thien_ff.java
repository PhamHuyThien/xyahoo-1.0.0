package home.thienph.xyahoo;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class thien_ff extends Screen {
   public static int[] w;
   public thien_b x;
   public static String y;
   public static String z;
   public static String A;
   public static int B;
   public static boolean C;
   public static String D = "";
   public static String E;
   public static byte F;
   public static String G;
   public static int H;
   private Vector J;
   public PopupSideElementData I;
   private boolean K;
   private final TextField L;

   public static void e() {
      E = null;
   }

   public final void f() {
      String var1;
      if (!(var1 = this.x.g()).equals(TextConstant.services())) {
         thien_cl var2;
         (var2 = new thien_cl(TextConstant.rename(), TextConstant.typeNewNameForGroup() + "\"" + this.x.g() + "\"")).D.setText(var1);
         var2.a(new thien_fg(this, var2, var1));
         GameManager.getInstance().displayScreen(var2);
         GameManager.getInstance().j();
      }
   }

   public final void g() {
      thien_cl var1;
      (var1 = new thien_cl(TextConstant.chatTo(), TextConstant.enterTheIdYouWantToChat())).a(new thien_fq(this, var1));
      GameManager.getInstance().displayScreen(var1);
      GameManager.getInstance().j();
   }

   public final void a(String var1, int var2) {
      if (var2 == 0) {
         thien_ew var3 = GameManager.getInstance().e(var1);
         GameManager.getInstance().d(var3.title);
      } else {
         if (var2 == 1) {
            this.b(var1);
         }
      }
   }

   public final void h() {
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
      thien_ai var5 = new thien_ai(TextConstant.conferenceSubject(), var3, 10, TextRenderer.fontHeight);
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
      GameManager.getInstance().displayScreen(var1);
      GameManager.getInstance().j();
   }

   public final void b(String var1) {
      GameManager.e = GameManager.getInstance().u();
      Screen var2;
      (var2 = new Screen()).title = TextConstant.addFriend();
      int var3;
      if ((var3 = GameCanvas.screenWidth - 30) > 150) {
         var3 = 180;
      }

      if (var3 < 100) {
         var3 = 100;
      }

      int var4 = GameCanvas.screenWidth - var3 >> 1;
      thien_ai var6 = new thien_ai(TextConstant.addId(), var4, 10, TextRenderer.fontHeight);
      int var5 = 10 + 1 + var6.height;
      TextField var7;
      (var7 = new TextField()).setBounds(var4, var5, var3, TextRenderer.fontHeight + 6);
      var7.setText(var1);
      var5 += 5 + var7.height;
      thien_ai var11 = new thien_ai(TextConstant.toNewGroup(), var4, var5, TextRenderer.fontHeight);
      var5 += 1 + var11.height;
      TextField var8;
      (var8 = new TextField()).setBounds(var4, var5, var3, TextRenderer.fontHeight + 6);
      String var9 = this.x.g();
      var8.setText(var9);
      if (var8.getText().equals("") || var8.getText().equals(TextConstant.services())) {
         var8.setText("Friends");
      }

      var5 += 5 + var8.height;
      thien_ai var10 = new thien_ai(TextConstant.orExisting(), var4, var5, TextRenderer.fontHeight);
      var5 += 1 + var10.height;
      UIDropdown var12;
      (var12 = new UIDropdown(this.x.i(), var4, var5, var3, TextRenderer.fontHeight + 6)).a(var9);
      var12.b = new thien_gj(this, var8, var12);
      var2.addControl(var6);
      var2.addControl(var7);
      var2.addControl(var11);
      var2.addControl(var8);
      var2.addControl(var10);
      var2.addControl(var12);
      var2.selectControl(var7);
      var2.centerCommand = new UIAction("OK", new thien_gk(this, var7, var8, var2));
      var2.leftCommand = new UIAction(TextConstant.cancel(), new thien_gl(this, var2));
      GameManager.instance.a(var2);
      GameManager.getInstance().j();
   }

   public final void i() {
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
      thien_ai var5 = new thien_ai(TextConstant.broadcastMessage2(), var3, 10, TextRenderer.fontHeight);
      int var4 = 10 + 5 + var5.height;
      TextField var6;
      (var6 = new TextField()).setBounds(var3, var4, var2, TextRenderer.fontHeight + 6);
      var4 += 5 + var6.height;
      thien_ai var7 = new thien_ai(TextConstant.toGroup(), var3, var4, TextRenderer.fontHeight);
      var4 += 1 + var7.height;
      UIDropdown var8;
      (var8 = new UIDropdown(this.x.i(), var3, var4, var2, TextRenderer.fontHeight + 6)).a(this.x.g());
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
      GameManager.getInstance().displayScreen(var1);
      GameManager.getInstance().j();
   }

   public final void j() {
      String var1;
      if (!(var1 = this.x.h().d).equals(TextConstant.selectService())) {
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
         thien_ai var6 = new thien_ai(TextConstant.moveId2() + var1, var4, 10, TextRenderer.fontHeight);
         int var5 = 10 + 5 + var6.height;
         thien_ai var7 = new thien_ai(TextConstant.toNewGroup(), var4, var5, TextRenderer.fontHeight);
         var5 += 1 + var7.height;
         TextField var8;
         (var8 = new TextField()).setBounds(var4, var5, var3, TextRenderer.fontHeight + 6);
         String var9 = this.x.g();
         var8.setText(var9);
         if (var8.getText().equals("") || var8.getText().equals(TextConstant.services())) {
            var8.setText("Friends");
         }

         var5 += 5 + var8.height;
         thien_ai var10 = new thien_ai(TextConstant.orExisting(), var4, var5, TextRenderer.fontHeight);
         var5 += 1 + var10.height;
         UIDropdown var11;
         (var11 = new UIDropdown(this.x.i(), var4, var5, var3, TextRenderer.fontHeight + 6)).a(var9);
         var11.b = new thien_fj(this, var8, var11);
         var2.addControl(var6);
         var2.addControl(var7);
         var2.addControl(var8);
         var2.addControl(var10);
         var2.addControl(var11);
         var2.selectControl(var8);
         var2.centerCommand = new UIAction("OK", new thien_fk(this, var8, var2, var9, var1));
         var2.leftCommand = new UIAction(TextConstant.cancel(), new thien_fl(this, var2));
         GameManager.getInstance().displayScreen(var2);
         GameManager.getInstance().j();
      }
   }

   public final void k() {
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
      thien_ai var5 = new thien_ai(TextConstant.statusMessage(), var3, 10, TextRenderer.fontHeight);
      int var4 = 10 + 1 + var5.height;
      TextField var6;
      (var6 = new TextField()).setBounds(var3, var4, var2, TextRenderer.fontHeight + 6);
      var6.setMaxLength(255);
      var6.setText(D);
      var4 += 10 + var6.height;
      thien_ai var7 = new thien_ai(TextConstant.status(), var3, var4, TextRenderer.fontHeight);
      var4 += 1 + var7.height;
      UIDropdown var8 = new UIDropdown(new String[]{TextConstant.available(), TextConstant.invisible2()}, var3, var4, var2, TextRenderer.fontHeight + 6);
      var8.c(B == 1 ? 0 : 1);
      var8.b = new thien_fm(this);
      var1.addControl(var5);
      var1.addControl(var6);
      var1.addControl(var7);
      var1.addControl(var8);
      var1.selectControl(var6);
      var1.centerCommand = new UIAction("OK", new thien_fn(this, var6, var8, var1));
      var1.leftCommand = new UIAction(TextConstant.cancel(), new thien_fo(this, var1));
      GameManager.getInstance().displayScreen(var1);
      GameManager.getInstance().j();
   }

   protected final void l() {
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
      thien_ai var5 = new thien_ai(TextConstant.oldPassword(), var3, 10, TextRenderer.fontHeight);
      int var4 = 10 + 1 + var5.height;
      TextField var6;
      (var6 = new TextField()).setInputType(2);
      var6.setBounds(var3, var4, var2, TextRenderer.fontHeight + 6);
      var4 += var6.height + 6;
      thien_ai var7 = new thien_ai(TextConstant.newPassword(), var3, var4, TextRenderer.fontHeight);
      var4 += 1 + var7.height;
      TextField var8;
      (var8 = new TextField()).setInputType(2);
      var8.setBounds(var3, var4, var2, TextRenderer.fontHeight + 6);
      var4 += var8.height + 6;
      thien_ai var9 = new thien_ai(TextConstant.retype(), var3, var4, TextRenderer.fontHeight);
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
      GameManager.getInstance().displayScreen(var1);
      GameManager.getInstance().j();
   }

   protected final void m() {
      thien_cl var1;
      (var1 = new thien_cl(TextConstant.changeFullname(), TextConstant.changeFullname())).D.setText(z);
      var1.a(new thien_fs(this, var1));
      GameManager.getInstance().displayScreen(var1);
      GameManager.getInstance().j();
   }

   public thien_ff() {
      C = Xuka.readFlag("onrank", false);
      super.isLocked = true;
      super.title = TextConstant.buddies();
      this.L = new TextField();
      this.L.isShiftMode = true;
      this.L.setBounds(0, Screen.formHeight - GameManager.g - TextRenderer.fontHeight - 11, Screen.e - 6, TextRenderer.fontHeight + 6);
      this.x = new thien_b(1, 1, Screen.e - 3, Screen.formHeight - 2 - GameManager.g, true);
      this.x.c = false;
      this.x.n = true;
      this.addControl(this.x);
      this.selectControl(this.x);
      this.J = new Vector();
      this.J.addElement(new UIAction(TextConstant.addFriend(), new thien_ft(this)));
      this.J.addElement(new UIAction(TextConstant.status(), new thien_fu(this)));
      Vector var1;
      (var1 = new Vector()).addElement(new UIAction(TextConstant.showHideOffline(), new thien_fv(this)));
      var1.addElement(new UIAction("Avatar", new thien_fw(this)));
      UIAction var2;
      (var2 = new UIAction(TextConstant.showHide(), null)).popupSideElementData = new PopupSideElementData(var1);
      this.J.addElement(var2);
      (var1 = new Vector()).addElement(new UIAction(TextConstant.changeFullname(), new thien_fx(this)));
      var1.addElement(new UIAction(TextConstant.changePassword(), new thien_fy(this)));
      (var2 = new UIAction(TextConstant.changeUserProfile(), null)).popupSideElementData = new PopupSideElementData(var1);
      this.J.addElement(var2);
      (var1 = new Vector()).addElement(new UIAction(TextConstant.renameMoveId(), new thien_fz(this)));
      var1.addElement(new UIAction(TextConstant.delete(), new thien_ga(this)));
      var1.addElement(new UIAction(TextConstant.ignoreList(), new thien_gc(this)));
      var1.addElement(new UIAction(TextConstant.chatToo(), new thien_gd(this)));
      var1.addElement(new UIAction(TextConstant.conference(), new thien_ge(this)));
      var1.addElement(new UIAction(TextConstant.broadcastMessage(), new thien_gf(this)));
      (var2 = new UIAction(TextConstant.otherTools(), null)).popupSideElementData = new PopupSideElementData(var1);
      this.J.addElement(var2);
      this.J.addElement(new UIAction(TextConstant.close(), new thien_gg(this)));
      this.I = new PopupSideElementData(this.J);
      super.leftCommand = new UIAction("Menu", new thien_gh(this));
   }

   public static void n() {
      MessageHandler.d();
      GameManager.instance.a(GameManager.t);
   }

   public final void o() {
      if (this.x.l != null) {
         this.x.l.removeAllElements();
      }

      this.x.l = null;
      this.x.k = null;
   }

   public final boolean handleInput(boolean[] var1, boolean[] var2, int[] var3) {
      if (var3[0] > 32 && !this.K) {
         this.L.setText("");
         this.addControl(this.L);
         this.selectControl(this.L);
         this.K = true;
      }

      String var4 = "";
      if (this.K) {
         if (var1[12]) {
            var1[12] = false;
            this.x.handleKeyInput(12);
         } else if (var1[13]) {
            var1[13] = false;
            this.x.handleKeyInput(13);
         } else if (var1[16]) {
            var1[16] = false;
            this.x.handleKeyInput(16);
         }

         var4 = this.L.getText();
      }

      super.handleInput(var1, var2, var3);
      if (this.K) {
         if (this.L.getText().equals("")) {
            this.selectControl(this.x);
            this.removeControl(this.L);
            this.K = false;
         }

         if (!this.L.getText().equals(var4)) {
            this.x.d(this.L.getText());
         }
      }

      return true;
   }

   public final void updateLayout() {
      this.x.handleFocus();
   }

   public final void drawOverlay(Graphics var1) {
      this.x.drawScrollbar(var1);
   }
}
