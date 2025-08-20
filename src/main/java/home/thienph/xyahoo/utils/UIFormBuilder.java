package home.thienph.xyahoo.utils;

import home.thienph.xyahoo.components.UIImageView;
import home.thienph.xyahoo.components.UITextLabel;
import home.thienph.xyahoo.actions.thien_aj;
import home.thienph.xyahoo.actions.thien_ak;
import home.thienph.xyahoo.components.UIButton;
import home.thienph.xyahoo.components.UICheckBox;
import home.thienph.xyahoo.components.UIDropdown;
import home.thienph.xyahoo.screens.FormScreen;
import home.thienph.xyahoo.screens.Screen;
import home.thienph.xyahoo.actions.IAction;
import home.thienph.xyahoo.components.TextField;

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
      UITextLabel var4;
      (var4 = new UITextLabel(var1, FormScreen.formXOffset, var0.currentY, TextRenderer.fontHeight, -1)).width = FormScreen.formMarginLeft;
      var0.addControl(var4, false);
      TextField var5;
      (var5 = new TextField()).selectedIndex = -1;
      var5.setBounds(FormScreen.formStartX, var0.currentY, FormScreen.formWidth, TextRenderer.fontHeight + 6);
      var5.setInputType(var2);
      var0.addControl(var5, true);
      return var5;
   }

   public static TextField addTextFieldWithLabel(FormScreen var0, String var1, int var2, int var3) {
      var0.addControl(new UITextLabel(var1, var0.contentHeight, var0.currentY, TextRenderer.fontHeight, var3));
      var0.currentY += 2;
      TextField var4;
      (var4 = new TextField()).selectedIndex = var3;
      var4.setBounds(var0.contentHeight, var0.currentY, var0.maxContentHeight, TextRenderer.fontHeight + 6);
      var4.setInputType(var2);
      var0.addControl(var4);
      return var4;
   }

   public static UIDropdown addDropdown(FormScreen var0, String var1, String[] var2) {
      return addDropdown(var0, var1, var2, -1);
   }

   public static UIDropdown addDropdown(FormScreen var0, String var1, String[] var2, int var3) {
      var0.addControl(new UITextLabel(var1, var0.contentHeight, var0.currentY, TextRenderer.fontHeight, var3));
      var0.currentY += 2;
      UIDropdown var4;
      (var4 = new UIDropdown(var2, var0.contentHeight, var0.currentY, var0.maxContentHeight, TextRenderer.fontHeight + 6)).selectedIndex = var3;
      var0.addControl(var4);
      return var4;
   }

   public static UITextLabel addLabel(FormScreen var0, int var1) {
      UITextLabel var2;
      (var2 = new UITextLabel("", 5, var0.currentY, 10)).selectedIndex = var1;
      var0.addControl(var2);
      return var2;
   }

   public static UITextLabel[] addWrappedLabels(String var0, FormScreen var1, int var2, int var3, boolean var4, boolean var5) {
      String[] var6;
      UITextLabel[] var7 = new UITextLabel[(var6 = TextRenderer.splitText(var0, Screen.e - (var5 ? 10 : var1.contentHeight + 10), TextRenderer.charWidth)).length];

      for (int var8 = 0; var8 < var6.length; var8++) {
         var7[var8] = new UITextLabel(var6[var8], var5 ? 5 : var1.contentHeight, var1.currentY, TextRenderer.fontHeight + 2);
         var7[var8].selectedIndex = var2;
         var7[var8].isVisible = true;
         var7[var8].textColor = var3;
         var7[var8].fontRenderer = new Integer(var3);
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
      var7.actionHandler = var3;
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
      UICheckBox var10000 = var4 = new UICheckBox(var1, var0.contentHeight, var0.currentY, var5, TextRenderer.fontHeight + 4);
      Object var3 = null;
      UICheckBox var6 = var10000;
      var10000.changeHandler = (IAction)var3;
      var6.actionSecondary.actionHandler = new UIFormBuilder(var6, (IAction)var3);
      if (var0 != null) {
         var0.addControl(var4);
      }

      return var4;
   }

   public static UITextLabel[] addLabelsAuto(FormScreen var0, String var1) {
      return addWrappedLabels(var1, var0, -1, 16777215, true, true);
   }

   public static UIImageView addImage(FormScreen var0, byte[] var1, int var2) {
      Image var3 = Image.createImage(var1, 0, var1.length);
      UIImageView var4;
      (var4 = new UIImageView()).imageData = var1;
      var4.setBounds(Screen.e - var3.getWidth() >> 1, var0.currentY, var3.getWidth(), var3.getHeight());
      var4.setTargetSize(var3.getWidth(), var3.getHeight());
      var4.isVisible = true;
      var4.setImage(var3);
      var4.selectedIndex = var2;
      var0.addControl(var4);
      return var4;
   }

   public static UIImageView addImage(FormScreen var0, int[] var1, int var2, int var3, int var4) {
      UIImageView var5;
      (var5 = new UIImageView()).setBounds(Screen.e - var2 >> 1, var0.currentY, var2, var3);
      var5.setTargetSize(var2, var3);
      var5.isVisible = true;
      var5.setIconPositions(var1);
      var5.selectedIndex = var4;
      var0.addControl(var5);
      return var5;
   }

   public static UIImageView addImage(FormScreen var0, Image var1, boolean var2) {
      UIImageView var3;
      (var3 = new UIImageView()).setBounds(Screen.e - var1.getWidth() >> 1, var0.currentY, var1.getWidth(), var1.getHeight());
      var3.setTargetSize(var1.getWidth(), var1.getHeight());
      var3.isVisible = false;
      var3.setImage(var1);
      var0.addControl(var3);
      return var3;
   }
}
