package home.thienph.xyahoo;

final class thien_fs
implements thien_ae {
    private final thien_cl a;

    thien_fs(thien_ff thien_ff2, thien_cl thien_cl2) {
        this.a = thien_cl2;
    }

    public final void a() {
        GameCanvas.resetKeys();
        String string = this.a.D.c().trim();
        if (string.trim().equals("")) {
            return;
        }
        thien_di.b().c(this.a);
        thien_ff.z = string;
        thien_ff.A = thien_ff.z.equals("") ? thien_ff.y : thien_ff.z;
        MessageHandler.b(string, "", "");
        thien_di.c.l();
    }
}
