package home.thienph.xyahoo;

final class thien_bn
implements IAction {
    private BigTwoGameScreen a;

    thien_bn(BigTwoGameScreen bigTwoGameScreen2) {
        this.a = bigTwoGameScreen2;
    }

    public final void action() {
        this.a.removeControl(BigTwoGameScreen.chatTextField);
        BigTwoGameScreen.isChatVisible = false;
        this.a.selectControl(BigTwoGameScreen.getSelectedControl(this.a));
        BigTwoGameScreen.adjustScrollPosition(this.a);
        BigTwoGameScreen.chatTextField.setText("");
    }
}
