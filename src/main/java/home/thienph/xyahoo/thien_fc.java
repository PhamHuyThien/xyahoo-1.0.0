package home.thienph.xyahoo;

final class thien_fc
implements IAction {
    private ChatRoomScreen a;
    private final boolean b;

    thien_fc(ChatRoomScreen chatRoomScreen2, boolean bl) {
        this.a = chatRoomScreen2;
        this.b = bl;
    }

    public final void action() {
        if (this.b) {
            MessageHandler.h(this.a.subtitle);
        }
        GameManager.getInstance().c(this.a);
    }
}
