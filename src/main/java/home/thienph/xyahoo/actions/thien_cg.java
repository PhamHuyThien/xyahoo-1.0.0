package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.HomeScreen;

final class thien_cg
implements IAction {
    private HomeCommentAction a;

    thien_cg(HomeCommentAction homeCommentAction2) {
        this.a = homeCommentAction2;
    }

    public final void action() {
        HomeCommentAction homeCommentAction2 = this.a;
        HomeScreen.a(homeCommentAction2.homeScreen);
        homeCommentAction2 = this.a;
        MessageHandler.c(homeCommentAction2.homeScreen.F.getText());
    }
}
