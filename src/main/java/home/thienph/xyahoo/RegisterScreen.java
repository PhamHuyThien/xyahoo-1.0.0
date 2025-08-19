package home.thienph.xyahoo;

import javax.microedition.lcdui.Image;

public final class RegisterScreen
extends FormScreen {
    private static String[] H = new String[]{"admin", "administrator", "root", "system", "xuka", "yahoo"};
    public TextField fullNameField;
    private UIDropdown I;
    public TextField E;
    private TextField J;
    private String K;
    public String F;
    public String G;

    public RegisterScreen() {
        this.title = TextConstant.register();
        this.leftCommand = new UIAction(TextConstant.close(), new thien_ei(this));
        this.centerCommand = new UIAction(TextConstant.register(), new thien_ej(this));
    }

    public final void b(String[] stringArray) {
        this.clearControls();
        this.fullNameField = null;
        this.I = null;
        this.E = null;
        this.J = null;
        System.gc();
        FormScreen.calculateFormDimensions(70, 150);
        this.initLayout();
        this.x = Screen.formHeight - (TextRenderer.extraSpacing * 3 + thien_aq.a + (GameCanvas.screenHeight > 170 ? 55 : 20) + GameManager.g) >> 1;
        UIFormBuilder.addImage((FormScreen)this, thien_aq.c(), false);
        this.x += GameCanvas.screenHeight > 170 ? 18 : 7;
        this.fullNameField = UIFormBuilder.addTextField((FormScreen)this, "Tên: ", 0, -1);
        this.x += 5;
        this.I = stringArray != null ? UIFormBuilder.addDropdown((FormScreen)this, TextConstant.suggestedId(), stringArray) : null;
        this.E = UIFormBuilder.addTextField((FormScreen)this, String.valueOf(TextConstant.password()) + ":", 2, -1);
        this.x += 5;
        this.J = UIFormBuilder.addTextField((FormScreen)this, String.valueOf(TextConstant.retype()) + ":", 2, -1);
        if (stringArray != null) {
            this.fullNameField.setText(this.K);
            this.E.setText(this.F);
            this.J.setText(this.F);
        }
        this.selectControl(this.fullNameField);
    }

    protected final void f() {
        GameManager gameManager2 = GameManager.getInstance();
        gameManager2.displayScreen(gameManager2.loginScreen);
        gameManager2.d(gameManager2.loginScreen);
        gameManager2.loginScreen.startSlide(1);
        gameManager2.c(this);
    }

    public final void g() {
        int n = thien_fe.a(this.fullNameField.getText());
        if (n == 1) {
            GameManager.getInstance().a("ID" + TextConstant.lengthMustBeFrom6To64(), (Image)null, 1);
            this.selectControl(this.fullNameField);
            return;
        }
        if (n == 2) {
            GameManager.getInstance().a(TextConstant.idCantStartWithNumber(), (Image)null, 1);
            this.selectControl(this.fullNameField);
            return;
        }
        if (n == 3) {
            GameManager.getInstance().a(TextConstant.getIdCantStartWithNumber(), (Image)null, 1);
            this.selectControl(this.fullNameField);
            return;
        }
        n = 0;
        while (n < H.length) {
            if (H[n].equals(this.fullNameField.getText())) {
                GameManager.getInstance().a(TextConstant.cannotUseThisName(), (Image)null, 1);
                this.fullNameField.setText("");
                this.selectControl(this.fullNameField);
                return;
            }
            ++n;
        }
        if (this.E.getText().length() < 6 || this.E.getText().length() > 64) {
            GameManager.getInstance().a(String.valueOf(TextConstant.password()) + TextConstant.lengthMustBeFrom6To64(), (Image)null, 1);
            this.selectControl(this.E);
            return;
        }
        if (this.J.getText().equals("") || !this.E.getText().equals(this.J.getText())) {
            GameManager.getInstance().a(TextConstant.typePasswordAgain(), (Image)null, 1);
            this.selectControl(this.J);
            return;
        }
        this.fullNameField.setText(this.fullNameField.getText().toLowerCase());
        if (this.K != null && this.K.equals(this.fullNameField.getText())) {
            if (this.I != null) {
                this.G = this.I.b();
                if (this.G == null) {
                    this.G = this.K;
                }
            } else {
                this.G = this.K;
            }
        } else {
            this.G = this.fullNameField.getText();
        }
        GameManager.getInstance().a(TextConstant.registering(), null, new UIAction(TextConstant.cancel(), new thien_ek(this)), null).setExtraOption(true);
        GameManager.getInstance().loginAction = new thien_el(this);
    }

    static void a(RegisterScreen registerScreen2, String string) {
        registerScreen2.K = string;
    }
}
