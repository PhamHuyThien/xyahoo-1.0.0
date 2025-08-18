package home.thienph.xyahoo;

final class thien_do
implements thien_ae {
    private thien_dm a;
    private final thien_ae b;

    thien_do(thien_dm thien_dm2, thien_ae thien_ae2) {
        this.a = thien_dm2;
        this.b = thien_ae2;
    }

    public final void a() {
        thien_dm thien_dm2 = this.a;
        thien_dm2.a.c();
        thien_dm2 = this.a;
        thien_dm2.a.b(TextConstant.sendSmsFailed(), this.b);
    }
}
