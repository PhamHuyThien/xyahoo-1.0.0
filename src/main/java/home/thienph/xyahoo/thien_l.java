package home.thienph.xyahoo;

final class thien_l
implements IAction {
    private final String a;
    private final String b;

    thien_l(String string, String string2) {
        this.a = string;
        this.b = string2;
    }

    public final void action() {
        GameManager.instance.c();
        GameManager.instance.b(TextConstant.pleaseWait());
        Xuka.startThread(this.a, this.b, null, null, true);
    }
}
