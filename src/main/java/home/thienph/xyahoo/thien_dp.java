package home.thienph.xyahoo;

final class thien_dp implements IAction {
   thien_dp(GameManager var1) {
   }

   public final void action() {
      ContactListUI var1 = GameManager.G.contactListUI;
      MessageHandler.b((GameManager.G.contactListUI.a < 0 ? null : (thien_u)var1.c.elementAt(var1.a)).d);
   }
}

