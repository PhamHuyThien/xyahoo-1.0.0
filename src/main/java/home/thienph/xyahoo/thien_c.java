package home.thienph.xyahoo;

final class thien_c
implements IAction {
    private thien_b a;

    thien_c(thien_b thien_b2) {
        this.a = thien_b2;
    }

    public final void action() {
        Object object = this.a.c ? "Y! " + thien_b.a((thien_b)this.a).d : thien_b.a((thien_b)this.a).d;
        ChatRoomScreen chatRoomScreen2 = (ChatRoomScreen) GameManager.instance.c((String)object);
        if (chatRoomScreen2 != null) {
            chatRoomScreen2.startSlide(1);
            GameManager.instance.d((String)object);
            return;
        }
        if (this.a.c) {
            chatRoomScreen2 = new ChatRoomScreen((String)object, this.a.c, false, null);
            new ChatRoomScreen((String)object, this.a.c, false, null).x = thien_b.a((thien_b)this.a).d;
        } else {
            chatRoomScreen2 = new ChatRoomScreen((String)object, this.a.c, false, thien_b.a((thien_b)this.a).j);
            new ChatRoomScreen((String)object, this.a.c, false, thien_b.a((thien_b)this.a).j).y = thien_b.a((thien_b)this.a).e.equals("") ? thien_b.a((thien_b)this.a).d : thien_b.a((thien_b)this.a).e;
            object = thien_b.a((thien_b)this.a).i;
            if (object != null) {
                chatRoomScreen2.b(Integer.toString(((thien_r)object).i));
            }
        }
        chatRoomScreen2.startSlide(1);
        GameManager.instance.displayScreen(chatRoomScreen2);
        GameManager.instance.d(chatRoomScreen2.title);
    }
}
