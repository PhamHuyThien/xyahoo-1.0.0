package home.thienph.xyahoo;

import javax.microedition.lcdui.Graphics;
import java.util.Vector;

public final class LoginScreen extends FormScreen
{
    TextField usernameField;
    TextField passwordField;
    TextField chatBoxField;
    private Vector menuItems;
    thien_am mainMenu;
    public static UIAction callButton;
    private int J;
    private static FormScreen settingsScreen;
    
    static {
        LoginScreen.callButton = new UIAction("Gọi 0969728701", new CallAction());
    }
    
    public final void draw(final Graphics graphics) {
        super.draw(graphics);
        thien_w.a(thien_w.d).a(thien_di.b, this.J, Screen.formHeight - 2 - thien_w.f, graphics);
    }
    
    public LoginScreen() {
        this.J = Screen.e - thien_w.a(thien_di.b, thien_w.j) - 5;
        final TextField f;
        (f = new TextField("", 250, 0)).isEditable = false;
        f.setBounds(0, Screen.formHeight - thien_di.g - (thien_w.f << 1) + 5, Screen.e - 1, thien_w.f + 6);
        f.actionPrimary = new UIAction(TextConstant.exit(), new thien_dh(this, f));
        f.actionTertiary = new UIAction(TextConstant.send(), new thien_cs(this, f));
        this.chatBoxField = f;
        final Vector vector;
        (vector = new Vector()).addElement(thien_ca.I);
        vector.addElement(new UIAction(TextConstant.comment(), new thien_da(this)));
        vector.addElement(LoginScreen.callButton);
        final UIAction obj;
        (obj = new UIAction(TextConstant.support(), null)).icon = new thien_am(vector);
        final String b = Xuka.readUserID();
        final String c = Xuka.c();
        super.centerCommand = new UIAction(TextConstant.signIn(), new thien_db(this));
        super.title = " X Yahoo! ";
        FormScreen.calculateFormDimensions(70, 150);
        super.x = Screen.formHeight - (thien_w.i * 3 + thien_aq.a + ((GameCanvas.screenHeight > 170) ? 55 : 20) + thien_di.g) >> 1;
        UIFormBuilder.addImage(this, thien_aq.c(), false);
        super.x += ((GameCanvas.screenHeight > 170) ? 18 : 7);
        this.usernameField = UIFormBuilder.addTextField(this, "Tên: ", 0, -1);
        super.x += 5;
        this.passwordField = UIFormBuilder.addTextField(this, String.valueOf(TextConstant.password()) + ":", 2, -1);
        this.usernameField.lineSpacing = -5;
        this.passwordField.lineSpacing = -5;
        if (GameCanvas.screenHeight > 170) {
            super.x += 10;
            super.w = FormScreen.formXOffset;
            UIFormBuilder.addWrappedLabels(TextConstant.socialNetworkLicenseNo(), this, -1, 16777215, false, false);
        }
        this.selectControl(this.usernameField);
        (this.menuItems = new Vector()).addElement(new UIAction(TextConstant.register(), new thien_dc(this)));
        this.menuItems.addElement(new UIAction(TextConstant.forgetPassword(), new thien_dd(this)));
        this.menuItems.addElement(obj);
        this.menuItems.addElement(new UIAction(TextConstant.settings(), new thien_de(this)));
        this.menuItems.addElement(new UIAction(TextConstant.exit(), new thien_df(this)));
        this.mainMenu = new thien_am(this.menuItems);
        super.leftCommand = new UIAction("Menu", new thien_dg(this));
        if (b != null) {
            this.usernameField.setText(b);
        }
        if (c != null) {
            this.passwordField.setText(c);
        }
        if (b != null && b.length() > 0 && c != null && c.length() > 0 && thien_di.r) {
            super.centerCommand.actionHandler.action();
        }
    }
    
    public static void openSettings() {
        if (LoginScreen.settingsScreen == null) {
            System.gc();
            (LoginScreen.settingsScreen = new FormScreen()).title = TextConstant.settings();
            final FormScreen k = LoginScreen.settingsScreen;
            k.x += 20;
            final thien_z a = UIFormBuilder.addDropdown(LoginScreen.settingsScreen, TextConstant.typingSpeed(), new String[] { "1", "2", "3", "4", "5", "6", "7" });
            final thien_x a2 = UIFormBuilder.addLink(LoginScreen.settingsScreen, TextConstant.sound(), (IAction)null);
            final thien_x a3 = UIFormBuilder.addLink(LoginScreen.settingsScreen, TextConstant.vibrate(), (IAction)null);
            final thien_x a4 = UIFormBuilder.addLink(LoginScreen.settingsScreen, TextConstant.autoLogin(), (IAction)null);
            final thien_x a5 = UIFormBuilder.addLink(LoginScreen.settingsScreen, String.valueOf(TextConstant.autoLogin()) + " Yahoo!", (IAction)null);
            final thien_v a6 = UIFormBuilder.addButton(LoginScreen.settingsScreen, "Xóa dữ liệu cá nhân", 0, new thien_ct(), LoginScreen.settingsScreen.w, LoginScreen.settingsScreen.x + 5, 0);
            a6.baseX = Screen.e - a6.width >> 1;
            a3.a = thien_di.q;
            a2.a = !thien_di.p;
            a4.a = thien_di.r;
            a5.a = thien_di.s;
            a.c(TextField.multiTapSpeedIndex);
            LoginScreen.settingsScreen.selectControl(a);
            LoginScreen.settingsScreen.leftCommand = new UIAction(TextConstant.close(), new thien_cu(a3, a3.a, a2, a2.a, a4, a4.a, a5, a5.a, a, a.a()));
            LoginScreen.settingsScreen.centerCommand = new UIAction(TextConstant.save(), new thien_cv(a4, a5, a, a3, a2));
        }
        thien_di.getInstance().b(LoginScreen.settingsScreen);
        LoginScreen.settingsScreen.startSlide(-1);
        thien_di.getInstance().j();
    }
    
    public final void recoverPassword() {
        thien_di.instance.c();
        thien_di.instance.a(String.valueOf(TextConstant.willSendBackPassword()) + thien_di.D + this.usernameField.getText() + Xuka.refCode + " => " + thien_di.instance.w().substring(6), new thien_cw(this));
    }
    
    public final void login() {
        GameCanvas.resetKeys();
        if (this.usernameField.getText().equals("")) {
            this.selectControl(this.usernameField);
            return;
        }
        if (this.passwordField.getText().equals("")) {
            this.selectControl(this.passwordField);
            return;
        }
        MessageHandler.i(Xuka.version);
        MessageHandler.b();
        thien_di.getInstance().a(String.valueOf(TextConstant.signingAs()) + this.usernameField.getText(), null, null, new UIAction(TextConstant.cancel(), new thien_cy(this))).a(true);
        thien_di.getInstance().d();
        thien_di.getInstance().i = new thien_cz(this);
    }
    
    static void closeChatBox(LoginScreen LoginScreen) {
        if ((LoginScreen = LoginScreen).chatBoxField != null) {
            LoginScreen.removeControl(LoginScreen.chatBoxField);
        }
    }
    
    static FormScreen getSettingsScreen() {
        return LoginScreen.settingsScreen;
    }
}
