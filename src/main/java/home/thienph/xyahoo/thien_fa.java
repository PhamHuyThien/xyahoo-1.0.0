package home.thienph.xyahoo;

final class thien_fa
implements IAction {
    private ChatRoomScreen a;

    thien_fa(ChatRoomScreen chatRoomScreen2) {
        this.a = chatRoomScreen2;
    }

    public final void action() {
        String string = this.a.z.getSelectedMessage();
        if (!string.equals("")) {
            GameManager.statusMessage = string;
        }
    }
}
