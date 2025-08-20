package home.thienph.xyahoo.screens;

import home.thienph.xyahoo.actions.*;
import home.thienph.xyahoo.components.*;
import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.data.data.PopupSideElementData;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.main.*;
import home.thienph.xyahoo.utils.TextRenderer;
import home.thienph.xyahoo.utils.UIFormBuilder;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class LoginYahooScreen
extends Screen {
    public UIBuddyListControl w;
    public static String x;
    public static String y;
    public static int z;
    public static String A;
    private static boolean D;
    private boolean E;
    private boolean F;
    private Vector G;
    public PopupSideElementData B;
    private TextField H;
    public boolean C;
    private thien_ai I;
    private TextField J;
    private thien_ai K;
    private TextField L;
    private UICheckBox M;
    private thien_ai N;
    private UIDropdown O;
    private int P;
    private int Q;
    private UIAction R;
    private UIAction S;
    private UIAction T;
    private int U;
    private FormScreen V;
    private UIDropdown W;
    private TextField X;

    public LoginYahooScreen() {
        String string = Xuka.d();
        String string2 = Xuka.e();
        this.title = "Yahoo!";
        int n = HomeScreen.instance.menuHome.images[0].getHeight();
        this.P = Screen.e - HomeScreen.instance.menuHome.images[0].getWidth() >> 1;
        int n2 = (TextRenderer.fontHeight + 6 << 2) + 28 + n + 5;
        this.Q = n2 <= Screen.formHeight - GameManager.topMargin ? GameManager.headerHeight - 10 + (Screen.formHeight - GameManager.topMargin - n2 >> 1) : GameManager.headerHeight + 5;
        n = this.Q + n - 3;
        this.I = new thien_ai("Yahoo! ID:", FormScreen.formXOffset, n, TextRenderer.fontHeight);
        this.I.width = FormScreen.formMarginLeft;
        this.J = new TextField();
        this.J.setBounds(FormScreen.formStartX, n, FormScreen.formWidth, TextRenderer.fontHeight + 6);
        this.J.setInputType(0);
        this.K = new thien_ai(String.valueOf(TextConstant.password()) + ":", FormScreen.formXOffset, n += this.J.height + 7, TextRenderer.fontHeight);
        this.K.width = FormScreen.formMarginLeft;
        this.L = new TextField();
        this.L.setBounds(FormScreen.formStartX, n, FormScreen.formWidth, TextRenderer.fontHeight + 6);
        this.L.setInputType(2);
        this.L.isShiftMode = true;
        this.J.setText(string);
        this.J.lineSpacing = -5;
        this.L.setText(string2);
        this.L.lineSpacing = -5;
        this.N = new thien_ai("Domain:", FormScreen.formXOffset, n += this.L.height + 7, TextRenderer.fontHeight);
        this.N.width = FormScreen.formMarginLeft;
        this.O = new UIDropdown(new String[]{"@yahoo", "@ymail", "@rocketmail"}, FormScreen.formStartX, n, FormScreen.formWidth, TextRenderer.fontHeight + 6);
        this.O.c(Xuka.readDomainYahoo());
        int n3 = Screen.e - (TextRenderer.computeTextWidth(TextConstant.invisible(), TextRenderer.charWidth) + 13 + 4) >> 1;
        this.M = new UICheckBox(TextConstant.invisible(), n3, n += 6 + this.O.height, TextRenderer.computeTextWidth(TextConstant.invisible(), TextRenderer.charWidth) + 13 + 4, TextRenderer.fontHeight + 4);
        this.M.a = Xuka.readFlag("statusYahoo", false);
        int cfr_ignored_0 = this.M.height;
        this.H = new TextField();
        this.H.isShiftMode = true;
        this.H.setBounds(0, Screen.formHeight - GameManager.topMargin - TextRenderer.fontHeight - 11, Screen.e - 6, TextRenderer.fontHeight + 6);
        this.w = new UIBuddyListControl(1, 1, Screen.e - 3, Screen.formHeight - 2 - GameManager.topMargin, true);
        this.addControl(this.w);
        this.selectControl(this.w);
        this.w.isAutoChatEnabled = true;
        this.w.isFilterActive = Xuka.readFlag("hideOffline", true);
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
        GameManager.instance.removeScreen(this.V);
        this.V = null;
    }

    public final void a(boolean bl) {
        this.F = bl;
        if (bl) {
            if (this.B == null) {
                this.B = new PopupSideElementData(this.G);
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
        LoginYahooScreen loginYahooScreen2 = this;
        loginYahooScreen2.w.handleFocus();
        System.gc();
    }

    public final void drawBackground(Graphics graphics) {
        if (!this.F) {
            graphics.drawImage(HomeScreen.instance.menuHome.images[0], this.P, this.Q, 0);
        }
        super.drawBackground(graphics);
    }

    public final void f() {
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
        this.w.isLoading = true;
        this.a(true);
        LoginYahooScreen loginYahooScreen2 = this;
        this.U = GameManager.getChecksumValue(true);
        if (loginYahooScreen2.U != -1) {
            thien_s thien_s2 = GameManager.loadBuddyList(true, x);
            if (thien_s2 != null) {
                GameManager.instance.loginYahooScreen.w.a(thien_s2, -1);
            } else {
                loginYahooScreen2.U = -1;
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
        if (this.w.visibleItems != null) {
            this.w.visibleItems.removeAllElements();
        }
        this.w.visibleItems = null;
        this.w.buddyDataModel = null;
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
            ((LoginYahooScreen)object).H.setText("");
            ((Screen)object).addControl(((LoginYahooScreen)object).H);
            ((Screen)object).selectControl(((LoginYahooScreen)object).H);
            ((LoginYahooScreen)object).E = true;
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
        GameManager.getInstance().showConfirmDialog(String.valueOf(TextConstant.inviteYourYahoo()) + "?", new thien_gs(this));
    }

    public static void a(LoginYahooScreen loginYahooScreen2) {
        if (D) {
            GameManager.instance.showNotification("Vui lòng thoát Yahoo! và bỏ chọn đăng nhập ẩn", (Image)null, 1);
            return;
        }
        if (GameManager.isShowingAnimation) {
            GameManager.instance.showNotification("Vui lòng chờ 10s", (Image)null, 1);
            return;
        }
        if (loginYahooScreen2.V == null) {
            System.gc();
            loginYahooScreen2.V = new FormScreen();
            loginYahooScreen2.V.title = TextConstant.status();
            FormScreen cfr_ignored_0 = loginYahooScreen2.V;
            FormScreen.calculateFormDimensions(70, 150);
            loginYahooScreen2.V.x += 20;
            loginYahooScreen2.W = UIFormBuilder.addDropdown(loginYahooScreen2.V, TextConstant.status(), new String[]{TextConstant.available(), TextConstant.invisible2()});
            loginYahooScreen2.X = UIFormBuilder.addTextFieldWithLabel(loginYahooScreen2.V, TextConstant.statusMessage(), 0, -1);
            loginYahooScreen2.V.selectControl(loginYahooScreen2.W);
            loginYahooScreen2.V.centerCommand = new UIAction("OK", new thien_gt(loginYahooScreen2));
            loginYahooScreen2.V.leftCommand = new UIAction(TextConstant.cancel(), new thien_gu(loginYahooScreen2));
        }
        loginYahooScreen2.W.c(z == 0 ? 0 : 1);
        GameManager.getInstance().showScreen(loginYahooScreen2.V);
        loginYahooScreen2.X.setText(A);
        GameManager.getInstance().goToLastScreen();
    }

    public static TextField b(LoginYahooScreen loginYahooScreen2) {
        return loginYahooScreen2.X;
    }

    public static UIDropdown c(LoginYahooScreen loginYahooScreen2) {
        return loginYahooScreen2.W;
    }

   public static void a(LoginYahooScreen var0, String var1) {
      MessageHandler.a(var1, 2);
      A = var1;
      Xuka.saveCustomStr(x, var1, true);
   }

    public static FormScreen d(LoginYahooScreen loginYahooScreen2) {
        return loginYahooScreen2.V;
    }
}
