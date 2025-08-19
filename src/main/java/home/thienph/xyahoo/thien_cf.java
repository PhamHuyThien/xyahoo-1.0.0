package home.thienph.xyahoo;

final class thien_cf
implements IAction {
    private HomeCommentAction a;

    thien_cf(HomeCommentAction homeCommentAction2) {
        this.a = homeCommentAction2;
    }

    public final void action() {
        HomeCommentAction homeCommentAction2 = this.a;
        HomeScreen.a(homeCommentAction2.homeScreen);
    }
}
