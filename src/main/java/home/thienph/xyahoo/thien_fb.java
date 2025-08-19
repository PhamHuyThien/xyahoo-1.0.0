package home.thienph.xyahoo;

final class thien_fb
implements IAction {
    private ChatRoomScreen a;

    thien_fb(ChatRoomScreen chatRoomScreen2) {
        this.a = chatRoomScreen2;
    }

    public final void action() {
        if (!GameManager.o.equals("")) {
            this.a.A.insertText(GameManager.o);
        }
    }
}
