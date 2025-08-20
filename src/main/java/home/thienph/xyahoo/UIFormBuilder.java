package home.thienph.xyahoo;

import javax.microedition.lcdui.Image;

public class UIFormBuilder implements IAction {
   private final IAction action;

   UIFormBuilder(UICheckBox var1, IAction var2) {
      this.action = var2;
   }

   public final void action() {
      if (this.action != null) {
         this.action.action();
      }
   }

   public static TextField addTextField(FormScreen var0, String var1, int var2) {
      return addTextFieldWithLabel(var0, var1, 0, -1);
   }

   public static TextField addTextField(FormScreen var0, String var1, int var2, int var3) {
      thien_ai var4;
      (var4 = new thien_ai(var1, FormScreen.formXOffset, var0.x, TextRenderer.fontHeight, -1)).width = FormScreen.formMarginLeft;
      var0.addControl(var4, false);
      TextField var5;
      (var5 = new TextField()).selectedIndex = -1;
      var5.setBounds(FormScreen.formStartX, var0.x, FormScreen.formWidth, TextRenderer.fontHeight + 6);
      var5.setInputType(var2);
      var0.addControl(var5, true);
      return var5;
   }

   public static TextField addTextFieldWithLabel(FormScreen var0, String var1, int var2, int var3) {
      var0.addControl(new thien_ai(var1, var0.w, var0.x, TextRenderer.fontHeight, var3));
      var0.x += 2;
      TextField var4;
      (var4 = new TextField()).selectedIndex = var3;
      var4.setBounds(var0.w, var0.x, var0.y, TextRenderer.fontHeight + 6);
      var4.setInputType(var2);
      var0.addControl(var4);
      return var4;
   }

   public static UIDropdown addDropdown(FormScreen var0, String var1, String[] var2) {
      return addDropdown(var0, var1, var2, -1);
   }

   public static UIDropdown addDropdown(FormScreen var0, String var1, String[] var2, int var3) {
      var0.addControl(new thien_ai(var1, var0.w, var0.x, TextRenderer.fontHeight, var3));
      var0.x += 2;
      UIDropdown var4;
      (var4 = new UIDropdown(var2, var0.w, var0.x, var0.y, TextRenderer.fontHeight + 6)).selectedIndex = var3;
      var0.addControl(var4);
      return var4;
   }

   public static thien_ai addLabel(FormScreen var0, int var1) {
      thien_ai var2;
      (var2 = new thien_ai("", 5, var0.x, 10)).selectedIndex = var1;
      var0.addControl(var2);
      return var2;
   }

   public static thien_ai[] addWrappedLabels(String var0, FormScreen var1, int var2, int var3, boolean var4, boolean var5) {
      String[] var6;
      thien_ai[] var7 = new thien_ai[(var6 = TextRenderer.splitText(var0, Screen.e - (var5 ? 10 : var1.w + 10), TextRenderer.charWidth)).length];

      for (int var8 = 0; var8 < var6.length; var8++) {
         var7[var8] = new thien_ai(var6[var8], var5 ? 5 : var1.w, var1.x, TextRenderer.fontHeight + 2);
         var7[var8].selectedIndex = var2;
         var7[var8].isVisible = true;
         var7[var8].a = var3;
         var7[var8].b = new Integer(var3);
         var7[var8].isVisible = var4 && !var0.trim().equals("");
         var1.addControl(var7[var8]);
      }

      return var7;
   }

   public static UIButton addButton(FormScreen var0, String var1, int var2, IAction var3, int var4, int var5, int var6) {
      var2 = TextRenderer.computeTextWidth(var1, TextRenderer.charWidth) + 20;
      if (var2 > 0) {
         var6 = var2;
      }

      UIButton var7;
      (var7 = new UIButton(var1, var4, var5, var6, TextRenderer.fontHeight + 6)).selectedIndex = 0;
      var7.a = var3;
      var7.actionTertiary.actionHandler = var3;
      if (var0 != null) {
         var0.addControl(var7);
      }

      return var7;
   }

   public static thien_aj addCheckBox(FormScreen var0, String var1, int var2, IAction var3, int var4, int var5, int var6) {
      int var7;
      if ((var7 = TextRenderer.computeTextWidth(var1, TextRenderer.charWidth)) < var6) {
         var6 = var7;
      }

      thien_aj var8;
      (var8 = new thien_aj(var1, var4, var5, var6, TextRenderer.fontHeight + 4)).selectedIndex = var2;
      var8.action = var3;
      var8.actionTertiary.actionHandler = new thien_ak(var8);
      if (var0 != null) {
         var0.addControl(var8);
      }

      return var8;
   }

   public static UICheckBox addCheckBox(FormScreen var0, String var1, IAction var2) {
      int var5 = TextRenderer.computeTextWidth(var1, TextRenderer.charWidth) + 13 + 4;
      UICheckBox var4;
      UICheckBox var10000 = var4 = new UICheckBox(var1, var0.w, var0.x, var5, TextRenderer.fontHeight + 4);
      Object var3 = null;
      UICheckBox var6 = var10000;
      var10000.b = (IAction)var3;
      var6.actionSecondary.actionHandler = new UIFormBuilder(var6, (IAction)var3);
      if (var0 != null) {
         var0.addControl(var4);
      }

      return var4;
   }

   public static thien_ai[] addLabelsAuto(FormScreen var0, String var1) {
      return addWrappedLabels(var1, var0, -1, 16777215, true, true);
   }

   public static thien_ag addImage(FormScreen var0, byte[] var1, int var2) {
      Image var3 = Image.createImage(var1, 0, var1.length);
      thien_ag var4;
      (var4 = new thien_ag()).a = var1;
      var4.setBounds(Screen.e - var3.getWidth() >> 1, var0.x, var3.getWidth(), var3.getHeight());
      var4.d(var3.getWidth(), var3.getHeight());
      var4.isVisible = true;
      var4.a(var3);
      var4.selectedIndex = var2;
      var0.addControl(var4);
      return var4;
   }

   public static thien_ag addImage(FormScreen var0, int[] var1, int var2, int var3, int var4) {
      thien_ag var5;
      (var5 = new thien_ag()).setBounds(Screen.e - var2 >> 1, var0.x, var2, var3);
      var5.d(var2, var3);
      var5.isVisible = true;
      var5.a(var1);
      var5.selectedIndex = var4;
      var0.addControl(var5);
      return var5;
   }

   public static thien_ag addImage(FormScreen var0, Image var1, boolean var2) {
      thien_ag var3;
      (var3 = new thien_ag()).setBounds(Screen.e - var1.getWidth() >> 1, var0.x, var1.getWidth(), var1.getHeight());
      var3.d(var1.getWidth(), var1.getHeight());
      var3.isVisible = false;
      var3.a(var1);
      var0.addControl(var3);
      return var3;
   }
}
