package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.screens.HomeScreen;

final class thien_cf
implements IAction {
    private HomeCommentAction a;

    thien_cf(HomeCommentAction homeCommentAction2) {
        this.a = homeCommentAction2;
    }

    public final void action() {
        HomeCommentAction homeCommentAction2 = this.a;
        HomeScreen.resetSearchField(homeCommentAction2.homeScreen);
    }
}
