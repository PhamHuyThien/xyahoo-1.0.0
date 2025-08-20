package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.TextField;
import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.BuddyListScreen;
import home.thienph.xyahoo.screens.Screen;

public final class thien_gk implements IAction {
   private final TextField textField;
   private final TextField textField2;
   private final Screen screen;

   public thien_gk(BuddyListScreen var1, TextField var2, TextField var3, Screen var4) {
      this.textField = var2;
      this.textField2 = var3;
      this.screen = var4;
   }

   public final void action() {
      String var1 = this.textField.getText().trim().toLowerCase();
      String var2 = this.textField2.getText().trim();
      String var13;
      boolean var15;
      if (var1.equals("")) {
         this.screen.selectControl(this.textField);
      } else if (var2.equals("")) {
         this.screen.selectControl(this.textField2);
      } else {
         thien_s var10000 = GameManager.getInstance().buddyListScreen.buddyList.getDataModel();
         String var4 = var2;
         thien_s var3 = var10000;
         int var5 = var10000.a.size() - 1;

         while (true) {
            if (var5 < 0) {
               var13 = null;
               break;
            }

            thien_t var6;
            if ((var6 = (thien_t)var3.a.elementAt(var5)).a().toLowerCase().equals(var4.toLowerCase())) {
               var13 = var6.a();
               break;
            }

            var5--;
         }

         String var8 = var13;
         if (var13 != null) {
            var2 = var8;
         }

         var10000 = GameManager.getInstance().buddyListScreen.buddyList.getDataModel();
         var4 = var1;
         var3 = var10000;
         var5 = var10000.a.size() - 1;

         label46:
         while (true) {
            if (var5 < 0) {
               var15 = false;
               break;
            }

            thien_t var12;
            for (int var7 = (var12 = (thien_t)var3.a.elementAt(var5)).a.size() - 1; var7 >= 0; var7--) {
               if (((thien_r)var12.a.elementAt(var7)).a.equals(var4)) {
                  var15 = true;
                  break label46;
               }
            }

            var5--;
         }

         if (var15) {
            GameManager.getInstance().showSimpleDialog(TextConstant.thisIdAlreadyAdded());
         } else {
            MessageHandler.b(var1, var2, 1);
            GameManager.getInstance().removeScreen(this.screen);
            GameManager.getInstance().switchToScreen(GameManager.currentScreen);
         }
      }
   }
}
