package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.UIImageView;

public final class thien_ah implements IAction {
    private UIImageView uiImageView;

    public thien_ah(UIImageView UIImageView2) {
        this.uiImageView = UIImageView2;
    }

    public final void action() {
        this.uiImageView.handleKeyPress(0, 0);
    }
}
