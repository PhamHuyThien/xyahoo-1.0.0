package home.thienph.xyahoo;

final class thien_bo
        implements IAction {
    private BigTwoGameScreen a;

    thien_bo(BigTwoGameScreen bigTwoGameScreen2) {
        this.a = bigTwoGameScreen2;
    }

    public final void action() {
        this.a.removeControl(BigTwoGameScreen.chatTextField);
        BigTwoGameScreen.isChatVisible = false;
        this.a.selectControl(BigTwoGameScreen.getSelectedControl(this.a));
        if (BigTwoGameScreen.selectedTableType == 1) {
            MessageHandler.a(BigTwoGameScreen.selectedTableType, BigTwoGameScreen.gameRoomId, BigTwoGameScreen.currentGroupName, BigTwoGameScreen.chatTextField.getText());
        }
        BigTwoGameScreen.adjustScrollPosition(this.a);
        BigTwoGameScreen.chatTextField.setText("");
    }
}
