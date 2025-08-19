package home.thienph.xyahoo;

final class thien_bj implements IAction {
   private thien_bi a;

   thien_bj(thien_bi var1) {
      this.a = var1;
   }

   public final void action() {
      thien_bi var1 = this.a;
      thien_bh var2 = this.a.a;
      BigTwoGameScreen.e();
      MessageHandler.a(BigTwoGameScreen.ah, BigTwoGameScreen.B, BigTwoGameScreen.currentGroupName, true);
   }
}
