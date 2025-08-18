package home.thienph.xyahoo;

final class thien_dp implements IAction {
   thien_dp(GameManager var1) {
   }

   public final void action() {
      thien_al var1 = GameManager.G.w;
      MessageHandler.b((GameManager.G.w.a < 0 ? null : (thien_u)var1.c.elementAt(var1.a)).d);
   }
}

