package home.thienph.xyahoo;

final class thien_ex
implements IAction {
    thien_ex(ChatRoomScreen chatRoomScreen2) {
    }

    public final void action() {
        GameManager.getInstance().showEmoticonPicker(0);
    }
}
