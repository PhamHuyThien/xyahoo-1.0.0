package home.thienph.xyahoo;

final class thien_ey
implements IAction {
    private ChatRoomScreen a;
    private final boolean b;

    thien_ey(ChatRoomScreen chatRoomScreen2, boolean bl) {
        this.a = chatRoomScreen2;
        this.b = bl;
    }

    public final void action() {
        String string;
        String string2 = string = this.a.w ? LoginYahooScreen.x : BuddyListScreen.currentGroupName;
        if (this.b) {
            MessageHandler.a(string, this.a.x, 2);
        } else {
            MessageHandler.a(string, this.a.title, 1);
        }
        this.a.z.addUserMessage(this.b ? LoginYahooScreen.y : BuddyListScreen.userStatusMessage, this.b ? TextConstant.buzz[0] : TextConstant.buzz(), 0);
        GameManager.getInstance().vibrate();
        this.a.z.scrollToBottom();
    }
}
