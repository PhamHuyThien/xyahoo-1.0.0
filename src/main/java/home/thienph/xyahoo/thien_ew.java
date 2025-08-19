package home.thienph.xyahoo;

import java.util.Vector;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.Graphics;

public final class thien_ew extends Screen {
   public boolean w;
   public String x;
   public String y;
   private String B;
   public thien_e z;
   TextField A;
   private boolean C;
   private final PopupSideElementData D;
   private final Vector E;

   public thien_ew(String var1, boolean var2, boolean var3, int[] var4) {
      super.isLocked = true;
      this.w = var2;
      this.C = var3;
      super.title = var1;
      this.A = new TextField();
      this.A.isEditable = false;
      this.A.setBounds(1, Screen.formHeight - GameManager.g - 2, Screen.e - 3, TextRenderer.fontHeight + 6);
      this.z = new thien_e(1, 1, Screen.e - 3, Screen.formHeight - GameManager.g - TextRenderer.fontHeight - 7);
      this.addControl(this.z);
      this.addControl(this.A);
      this.selectControl(this.A);
      this.E = new Vector();
      this.E.addElement(new UIAction(TextConstant.smileys(), new thien_ex(this)));
      this.E.addElement(new UIAction(TextConstant.buzz(), new thien_ey(this, var2)));
      if (var3) {
         this.E.addElement(new UIAction(TextConstant.invite(), new thien_ez(this)));
      }

      this.E.addElement(new UIAction("Copy", new thien_fa(this)));
      this.E.addElement(new UIAction(TextConstant.paste(), new thien_fb(this)));
      this.E.addElement(new UIAction(TextConstant.close(), new thien_fc(this, var3)));
      this.D = new PopupSideElementData(this.E);
      super.leftCommand = new UIAction("Menu", new thien_fd(this));
      super.centerCommand = new UIAction("Chat", null);
      if (GameManager.E != null) {
         this.z.a(GameManager.E, 2);
      }
   }

   public static void e() {
      if (thien_ff.E != null) {
         thien_aq.a(thien_ff.E, 1);
      }
   }

   public final void b(String var1) {
      this.B = var1;
      if (this.B != null) {
         thien_aq.a(this.B, 1);
      }

      if (thien_ff.E != null) {
         thien_aq.a(thien_ff.E, 1);
      }
   }

   public final boolean handleInput(boolean[] var1, boolean[] var2, int[] var3) {
      if (var1[16]) {
         var1[16] = false;
         this.A.setText(thien_fe.b(this.A.getText()));
         if (this.A.getText().equals("")) {
            String var8;
            int var10;
            if ((var10 = (var8 = this.z.c()).indexOf("http://")) >= 0) {
               String var9 = var8.substring(var10);

               try {
                  Xuka.instance.platformRequest(var9);
               } catch (ConnectionNotFoundException var4) {
               }

               return false;
            } else {
               this.A.openSystemTextBox();
               return false;
            }
         } else {
            if (this.A.getText().equals("plf")) {
               this.z.a("", Xuka.platformName, 0);
            }

            Object var5 = null;
            if (this.C) {
               GameManager.instance.B = thien_ff.y;
               GameManager.instance.C++;
               if (GameManager.instance.C > 5) {
                  this.z.a("Bạn chỉ có thể chat 5 câu liên tục khi chat nhóm", 1);
                  return false;
               }

               MessageHandler.f(super.subtitle, this.A.getText());
            } else if (this.w) {
               MessageHandler.a((String)(var5 = thien_gp.x), this.x, this.A.getText(), 2);
            } else {
               MessageHandler.a((String)(var5 = thien_ff.y), super.title, this.A.getText(), 1);
            }

            this.z.a(this.w ? thien_gp.y : thien_ff.A, this.A.getText(), 0);
            this.z.b();
            this.A.setText("");
            return false;
         }
      } else if (var1[12] || var2[12]) {
         var1[12] = false;
         this.z.handleSoftKey(12);
         return false;
      } else if (!var1[13] && !var2[13]) {
         return super.handleInput(var1, var2, var3);
      } else {
         var1[13] = false;
         this.z.handleSoftKey(13);
         return false;
      }
   }

   public final void updateLayout() {
      this.z.handleFocus();
   }

   public final void drawOverlay(Graphics var1) {
      this.z.drawScrollbar(var1);
   }

   static PopupSideElementData a(thien_ew var0) {
      return var0.D;
   }
}
