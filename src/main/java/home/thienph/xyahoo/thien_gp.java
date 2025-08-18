package home.thienph.xyahoo;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class thien_gp
extends Screen {
    public thien_b w;
    public static String x;
    public static String y;
    public static int z;
    public static String A;
    private static boolean D;
    private boolean E;
    private boolean F;
    private Vector G;
    thien_am B;
    private TextField H;
    public boolean C;
    private thien_ai I;
    private TextField J;
    private thien_ai K;
    private TextField L;
    private thien_x M;
    private thien_ai N;
    private thien_z O;
    private int P;
    private int Q;
    private UIAction R;
    private UIAction S;
    private UIAction T;
    private int U;
    private FormScreen V;
    private thien_z W;
    private TextField X;

    public thien_gp() {
        String string = Xuka.d();
        String string2 = Xuka.e();
        this.title = "Yahoo!";
        int n = thien_ca.D.H.images[0].getHeight();
        this.P = Screen.e - thien_ca.D.H.images[0].getWidth() >> 1;
        int n2 = (thien_w.f + 6 << 2) + 28 + n + 5;
        this.Q = n2 <= Screen.formHeight - GameManager.g ? GameManager.f - 10 + (Screen.formHeight - GameManager.g - n2 >> 1) : GameManager.f + 5;
        n = this.Q + n - 3;
        this.I = new thien_ai("Yahoo! ID:", FormScreen.formXOffset, n, thien_w.f);
        this.I.width = FormScreen.formMarginLeft;
        this.J = new TextField();
        this.J.setBounds(FormScreen.formStartX, n, FormScreen.formWidth, thien_w.f + 6);
        this.J.setInputType(0);
        this.K = new thien_ai(String.valueOf(TextConstant.password()) + ":", FormScreen.formXOffset, n += this.J.height + 7, thien_w.f);
        this.K.width = FormScreen.formMarginLeft;
        this.L = new TextField();
        this.L.setBounds(FormScreen.formStartX, n, FormScreen.formWidth, thien_w.f + 6);
        this.L.setInputType(2);
        this.L.isShiftMode = true;
        this.J.setText(string);
        this.J.lineSpacing = -5;
        this.L.setText(string2);
        this.L.lineSpacing = -5;
        this.N = new thien_ai("Domain:", FormScreen.formXOffset, n += this.L.height + 7, thien_w.f);
        this.N.width = FormScreen.formMarginLeft;
        this.O = new thien_z(new String[]{"@yahoo", "@ymail", "@rocketmail"}, FormScreen.formStartX, n, FormScreen.formWidth, thien_w.f + 6);
        this.O.c(Xuka.readDomainYahoo());
        int n3 = Screen.e - (thien_w.a(TextConstant.invisible(), thien_w.j) + 13 + 4) >> 1;
        this.M = new thien_x(TextConstant.invisible(), n3, n += 6 + this.O.height, thien_w.a(TextConstant.invisible(), thien_w.j) + 13 + 4, thien_w.f + 4);
        this.M.a = Xuka.readFlag("statusYahoo", false);
        int cfr_ignored_0 = this.M.height;
        this.H = new TextField();
        this.H.isShiftMode = true;
        this.H.setBounds(0, Screen.formHeight - GameManager.g - thien_w.f - 11, Screen.e - 6, thien_w.f + 6);
        this.w = new thien_b(1, 1, Screen.e - 3, Screen.formHeight - 2 - GameManager.g, true);
        this.addControl(this.w);
        this.selectControl(this.w);
        this.w.c = true;
        this.w.d = Xuka.readFlag("hideOffline", true);
        this.G = new Vector();
        this.G.addElement(new UIAction(TextConstant.showHideOffline(), new thien_gq(this)));
        this.G.addElement(new UIAction(TextConstant.status(), new thien_gv(this)));
        this.G.addElement(new UIAction(TextConstant.inviteYahoo(), new thien_gw(this)));
        this.G.addElement(new UIAction(TextConstant.signOutYahoo(), new thien_gx(this)));
    }

    public final void e() {
        if (this.C || this.F) {
            this.C = false;
            MessageHandler.b(x, 2);
            this.a(false);
        }
        GameManager.instance.c(this.V);
        this.V = null;
    }

    public final void a(boolean bl) {
        this.F = bl;
        if (bl) {
            if (this.B == null) {
                this.B = new thien_am(this.G);
                this.R = new UIAction("Menu", new thien_gy(this));
            }
            this.leftCommand = this.R;
            this.centerCommand = null;
            this.removeControl(this.I);
            this.removeControl(this.J);
            this.removeControl(this.K);
            this.removeControl(this.L);
            this.removeControl(this.M);
            this.removeControl(this.N);
            this.removeControl(this.O);
            this.addControl(this.w);
            this.selectControl(this.w);
        } else {
            if (this.S == null) {
                this.S = new UIAction(TextConstant.signIn(), new thien_gz(this));
                this.T = new UIAction(TextConstant.close(), new thien_gr(this));
            }
            this.centerCommand = this.S;
            this.leftCommand = this.T;
            this.i();
            this.removeControl(this.w);
            this.addControl(this.I);
            this.addControl(this.J);
            this.addControl(this.K);
            this.addControl(this.L);
            this.addControl(this.N);
            this.addControl(this.O);
            this.addControl(this.M);
            this.selectControl(this.J);
        }
        this.scrollTargetY = 0;
        this.scrollY = 0;
        thien_gp thien_gp2 = this;
        thien_gp2.w.handleFocus();
        System.gc();
    }

    public final void drawBackground(Graphics graphics) {
        if (!this.F) {
            graphics.drawImage(thien_ca.D.H.images[0], this.P, this.Q, 0);
        }
        super.drawBackground(graphics);
    }

    protected final void f() {
        this.J.setText(this.J.getText().trim().toLowerCase());
        String string = this.J.getText();
        String string2 = this.L.getText();
        if (string.equals("")) {
            this.selectControl(this.J);
            return;
        }
        if (string2.equals("")) {
            this.selectControl(this.L);
            return;
        }
        x = string;
        y = string;
        z = this.M.a ? 12 : 0;
        D = this.M.a;
        String string3 = Xuka.readCustomStr(x, true);
        A = string3 == null ? "" : string3;
        Xuka.saveYahooID(string);
        Xuka.saveYahooPW(string2);
        int n = this.O.a();
        Xuka.saveDomainYahoo(this.O.a());
        if (n == 1 || n == 2) {
            x = String.valueOf(x) + this.O.b() + ".com";
        }
        this.w.e = true;
        this.a(true);
        thien_gp thien_gp2 = this;
        this.U = GameManager.a(true);
        if (thien_gp2.U != -1) {
            thien_s thien_s2 = GameManager.a(true, x);
            if (thien_s2 != null) {
                GameManager.instance.k.w.a(thien_s2, -1);
            } else {
                thien_gp2.U = -1;
            }
        }
        MessageHandler.login(string, string2, z, 2, this.U);
    }

    public final void updateLayout() {
        this.w.handleFocus();
    }

    public final void drawOverlay(Graphics graphics) {
        this.w.drawScrollbar(graphics);
    }

    public final void g() {
        if (this.w.l != null) {
            this.w.l.removeAllElements();
        }
        this.w.l = null;
        this.w.k = null;
    }

    private void i() {
        this.selectControl(this.w);
        this.removeControl(this.H);
        this.E = false;
    }

    public final boolean handleInput(boolean[] blArray, boolean[] blArray2, int[] nArray) {
        Object object;
        if (nArray[0] > 32 && !this.E && this.F) {
            object = this;
            ((thien_gp)object).H.setText("");
            ((Screen)object).addControl(((thien_gp)object).H);
            ((Screen)object).selectControl(((thien_gp)object).H);
            ((thien_gp)object).E = true;
        }
        object = "";
        if (this.E) {
            if (blArray[12]) {
                blArray[12] = false;
                this.w.handleKeyInput(12);
            } else if (blArray[13]) {
                blArray[13] = false;
                this.w.handleKeyInput(13);
            } else if (blArray[16]) {
                blArray[16] = false;
                this.w.handleKeyInput(16);
            }
            object = this.H.getText();
        }
        boolean bl = super.handleInput(blArray, blArray2, nArray);
        if (this.E) {
            if (this.H.getText().equals("")) {
                this.i();
            }
            if (!this.H.getText().equals(object)) {
                this.w.d(this.H.getText());
            }
        }
        return bl;
    }

    public final void h() {
        Xuka.setXpamFlag(x);
        GameManager.getInstance().a(String.valueOf(TextConstant.inviteYourYahoo()) + "?", new thien_gs(this));
    }

    static void a(thien_gp thien_gp2) {
        if (D) {
            GameManager.instance.a("Vui l\u00f2ng tho\u00e1t Yahoo! v\u00e0 b\u1ecf ch\u1ecdn \u0111\u0103ng nh\u1eadp \u1ea9n", (Image)null, 1);
            return;
        }
        if (GameManager.z) {
            GameManager.instance.a("Vui l\u00f2ng ch\u1edd 10s", (Image)null, 1);
            return;
        }
        if (thien_gp2.V == null) {
            System.gc();
            thien_gp2.V = new FormScreen();
            thien_gp2.V.title = TextConstant.status();
            FormScreen cfr_ignored_0 = thien_gp2.V;
            FormScreen.calculateFormDimensions(70, 150);
            thien_gp2.V.x += 20;
            thien_gp2.W = UIFormBuilder.addDropdown(thien_gp2.V, TextConstant.status(), new String[]{TextConstant.available(), TextConstant.invisible2()});
            thien_gp2.X = UIFormBuilder.addTextFieldWithLabel(thien_gp2.V, TextConstant.statusMessage(), 0, -1);
            thien_gp2.V.selectControl(thien_gp2.W);
            thien_gp2.V.centerCommand = new UIAction("OK", new thien_gt(thien_gp2));
            thien_gp2.V.leftCommand = new UIAction(TextConstant.cancel(), new thien_gu(thien_gp2));
        }
        thien_gp2.W.c(z == 0 ? 0 : 1);
        GameManager.getInstance().b(thien_gp2.V);
        thien_gp2.X.setText(A);
        GameManager.getInstance().j();
    }

    static TextField b(thien_gp thien_gp2) {
        return thien_gp2.X;
    }

    static thien_z c(thien_gp thien_gp2) {
        return thien_gp2.W;
    }

   static void a(thien_gp var0, String var1) {
      MessageHandler.a(var1, 2);
      A = var1;
      Xuka.saveCustomStr(x, var1, true);
   }

    static FormScreen d(thien_gp thien_gp2) {
        return thien_gp2.V;
    }
}
