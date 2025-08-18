package home.thienph.xyahoo;

import javax.microedition.lcdui.Image;

public final class thien_eh
extends FormScreen {
    private static String[] H = new String[]{"admin", "administrator", "root", "system", "xuka", "yahoo"};
    public TextField D;
    private thien_z I;
    public TextField E;
    private TextField J;
    private String K;
    public String F;
    public String G;

    public thien_eh() {
        this.title = TextConstant.register();
        this.leftCommand = new UIAction(TextConstant.close(), new thien_ei(this));
        this.centerCommand = new UIAction(TextConstant.register(), new thien_ej(this));
    }

    public final void b(String[] stringArray) {
        this.clearControls();
        this.D = null;
        this.I = null;
        this.E = null;
        this.J = null;
        System.gc();
        FormScreen.calculateFormDimensions(70, 150);
        this.initLayout();
        this.x = Screen.formHeight - (thien_w.i * 3 + thien_aq.a + (GameCanvas.screenHeight > 170 ? 55 : 20) + thien_di.g) >> 1;
        thien_y.a((FormScreen)this, thien_aq.c(), false);
        this.x += GameCanvas.screenHeight > 170 ? 18 : 7;
        this.D = thien_y.a((FormScreen)this, "T\u00ean: ", 0, -1);
        this.x += 5;
        this.I = stringArray != null ? thien_y.a((FormScreen)this, TextConstant.suggestedId(), stringArray) : null;
        this.E = thien_y.a((FormScreen)this, String.valueOf(TextConstant.password()) + ":", 2, -1);
        this.x += 5;
        this.J = thien_y.a((FormScreen)this, String.valueOf(TextConstant.retype()) + ":", 2, -1);
        if (stringArray != null) {
            this.D.setText(this.K);
            this.E.setText(this.F);
            this.J.setText(this.F);
        }
        this.selectControl(this.D);
    }

    protected final void f() {
        thien_di thien_di2 = thien_di.getInstance();
        thien_di2.b(thien_di2.l);
        thien_di2.d(thien_di2.l);
        thien_di2.l.startSlide(1);
        thien_di2.c(this);
    }

    public final void g() {
        int n = thien_fe.a(this.D.getText());
        if (n == 1) {
            thien_di.getInstance().a("ID" + TextConstant.lengthMustBeFrom6To64(), (Image)null, 1);
            this.selectControl(this.D);
            return;
        }
        if (n == 2) {
            thien_di.getInstance().a(TextConstant.idCantStartWithNumber(), (Image)null, 1);
            this.selectControl(this.D);
            return;
        }
        if (n == 3) {
            thien_di.getInstance().a(TextConstant.getIdCantStartWithNumber(), (Image)null, 1);
            this.selectControl(this.D);
            return;
        }
        n = 0;
        while (n < H.length) {
            if (H[n].equals(this.D.getText())) {
                thien_di.getInstance().a(TextConstant.cannotUseThisName(), (Image)null, 1);
                this.D.setText("");
                this.selectControl(this.D);
                return;
            }
            ++n;
        }
        if (this.E.getText().length() < 6 || this.E.getText().length() > 64) {
            thien_di.getInstance().a(String.valueOf(TextConstant.password()) + TextConstant.lengthMustBeFrom6To64(), (Image)null, 1);
            this.selectControl(this.E);
            return;
        }
        if (this.J.getText().equals("") || !this.E.getText().equals(this.J.getText())) {
            thien_di.getInstance().a(TextConstant.typePasswordAgain(), (Image)null, 1);
            this.selectControl(this.J);
            return;
        }
        this.D.setText(this.D.getText().toLowerCase());
        if (this.K != null && this.K.equals(this.D.getText())) {
            if (this.I != null) {
                this.G = this.I.b();
                if (this.G == null) {
                    this.G = this.K;
                }
            } else {
                this.G = this.K;
            }
        } else {
            this.G = this.D.getText();
        }
        thien_di.getInstance().a(TextConstant.registering(), null, new UIAction(TextConstant.cancel(), new thien_ek(this)), null).a(true);
        thien_di.getInstance().i = new thien_el(this);
    }

    static void a(thien_eh thien_eh2, String string) {
        thien_eh2.K = string;
    }
}
