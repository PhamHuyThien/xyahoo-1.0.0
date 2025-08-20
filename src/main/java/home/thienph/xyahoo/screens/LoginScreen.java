package home.thienph.xyahoo.screens;

import home.thienph.xyahoo.actions.*;
import home.thienph.xyahoo.components.*;
import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.data.data.PopupSideElementData;
import home.thienph.xyahoo.data.data.UIAction;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.main.*;
import home.thienph.xyahoo.utils.TextRenderer;
import home.thienph.xyahoo.utils.TextRendererHelper;
import home.thienph.xyahoo.utils.UIFormBuilder;

import javax.microedition.lcdui.Graphics;
import java.util.Vector;

public final class LoginScreen extends FormScreen
{
    public TextField usernameField;
    public TextField passwordField;
    public TextField commentField;
    private Vector menuItems;
    public PopupSideElementData menuPopupSide;
    public static UIAction callButton;
    private int J;
    private static FormScreen settingsScreen;
    
    static {
        LoginScreen.callButton = new UIAction("Gọi 0969728701", new CallAction());
    }
    
    public final void draw(final Graphics graphics) {
        super.draw(graphics);
        TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(GameManager.serverMessage, this.J, Screen.formHeight - 2 - TextRenderer.fontHeight, graphics);
    }
    
    public LoginScreen() {
        this.J = Screen.e - TextRenderer.computeTextWidth(GameManager.serverMessage, TextRenderer.charWidth) - 5;
        final TextField f = new TextField("", 250, 0);
        f.isEditable = false;
        f.setBounds(0, Screen.formHeight - GameManager.topMargin - (TextRenderer.fontHeight << 1) + 5, Screen.e - 1, TextRenderer.fontHeight + 6);
        f.actionPrimary = new UIAction(TextConstant.exit(), new thien_dh(this, f));
        f.actionTertiary = new UIAction(TextConstant.send(), new thien_cs(this, f));
        this.commentField = f;


        final String username = Xuka.readUserID();
        final String c = Xuka.c();
        super.title = " X Yahoo! ";
        FormScreen.calculateFormDimensions(70, 150);
        super.currentY = Screen.formHeight - (TextRenderer.extraSpacing * 3 + TextRendererHelper.defaultFontSize + ((GameCanvas.screenHeight > 170) ? 55 : 20) + GameManager.topMargin) >> 1;
        UIFormBuilder.addImage(this, TextRendererHelper.getLogo(), false);
        super.currentY += ((GameCanvas.screenHeight > 170) ? 18 : 7);
        this.usernameField = UIFormBuilder.addTextField(this, "Tên: ", 0, -1);
        super.currentY += 5;
        this.passwordField = UIFormBuilder.addTextField(this, String.valueOf(TextConstant.password()) + ":", 2, -1);
        this.usernameField.lineSpacing = -5;
        this.passwordField.lineSpacing = -5;
        if (GameCanvas.screenHeight > 170) {
            super.currentY += 10;
            super.contentHeight = FormScreen.formXOffset;
            UIFormBuilder.addWrappedLabels(TextConstant.socialNetworkLicenseNo(), this, -1, 16777215, false, false);
        }
        this.selectControl(this.usernameField);

        //
        final Vector vectorSupport = new Vector();
        vectorSupport.addElement(HomeScreen.infoAction);
        vectorSupport.addElement(new UIAction(TextConstant.comment(), new CommentAction(this)));
        vectorSupport.addElement(LoginScreen.callButton);
        //
        final UIAction uiActionSupport = new UIAction(TextConstant.support(), null);
        uiActionSupport.popupSideElementData = new PopupSideElementData(vectorSupport);
        //
        this.menuItems = new Vector();
        this.menuItems.addElement(new UIAction(TextConstant.register(), new RegisterAction(this)));
        this.menuItems.addElement(new UIAction(TextConstant.forgetPassword(), new ForgetPasswordAction(this)));
        this.menuItems.addElement(uiActionSupport);
        this.menuItems.addElement(new UIAction(TextConstant.settings(), new SettingLoginAction(this)));
        this.menuItems.addElement(new UIAction(TextConstant.exit(), new ExitAction(this)));
        this.menuPopupSide = new PopupSideElementData(this.menuItems);

        super.leftCommand = new UIAction("Menu", new MenuLoginAction(this));
        super.centerCommand = new UIAction(TextConstant.signIn(), new LoginScreenAction(this));

        if (username != null) {
            this.usernameField.setText(username);
        }
        if (c != null) {
            this.passwordField.setText(c);
        }
        if (username != null && username.length() > 0 && c != null && c.length() > 0 && GameManager.autoLogin) {
            super.centerCommand.actionHandler.action();
        }
    }
    
    public static void openSettings() {
        if (LoginScreen.settingsScreen == null) {
            System.gc();
            (LoginScreen.settingsScreen = new FormScreen()).title = TextConstant.settings();
            final FormScreen k = LoginScreen.settingsScreen;
            k.currentY += 20;
            final UIDropdown keyboardSpeed = UIFormBuilder.addDropdown(LoginScreen.settingsScreen, TextConstant.typingSpeed(), new String[] { "1", "2", "3", "4", "5", "6", "7" });
            final UICheckBox checkBoxSound = UIFormBuilder.addCheckBox(LoginScreen.settingsScreen, TextConstant.sound(), (IAction)null);
            final UICheckBox checkBoxVibrate = UIFormBuilder.addCheckBox(LoginScreen.settingsScreen, TextConstant.vibrate(), (IAction)null);
            final UICheckBox checkBoxAutoLogin = UIFormBuilder.addCheckBox(LoginScreen.settingsScreen, TextConstant.autoLogin(), (IAction)null);
            final UICheckBox checkBoxAutoLoginYahoo = UIFormBuilder.addCheckBox(LoginScreen.settingsScreen, String.valueOf(TextConstant.autoLogin()) + " Yahoo!", (IAction)null);
            final UIButton btnDeleteData = UIFormBuilder.addButton(LoginScreen.settingsScreen, "Xóa dữ liệu cá nhân", 0, new thien_ct(), LoginScreen.settingsScreen.contentHeight, LoginScreen.settingsScreen.currentY + 5, 0);
            btnDeleteData.baseX = Screen.e - btnDeleteData.width >> 1;
            checkBoxVibrate.isChecked = GameManager.vibrateEnabled;
            checkBoxSound.isChecked = !GameManager.soundEnabled;
            checkBoxAutoLogin.isChecked = GameManager.autoLogin;
            checkBoxAutoLoginYahoo.isChecked = GameManager.autoLoginYahoo;
            keyboardSpeed.setSelectedIndex(TextField.multiTapSpeedIndex);
            LoginScreen.settingsScreen.selectControl(keyboardSpeed);
            LoginScreen.settingsScreen.leftCommand = new UIAction(TextConstant.close(), new thien_cu(checkBoxVibrate, checkBoxVibrate.isChecked, checkBoxSound, checkBoxSound.isChecked, checkBoxAutoLogin, checkBoxAutoLogin.isChecked, checkBoxAutoLoginYahoo, checkBoxAutoLoginYahoo.isChecked, keyboardSpeed, keyboardSpeed.getSelectedIndex()));
            LoginScreen.settingsScreen.centerCommand = new UIAction(TextConstant.save(), new thien_cv(checkBoxAutoLogin, checkBoxAutoLoginYahoo, keyboardSpeed, checkBoxVibrate, checkBoxSound));
        }
        GameManager.getInstance().showScreen(LoginScreen.settingsScreen);
        LoginScreen.settingsScreen.startSlide(-1);
        GameManager.getInstance().goToLastScreen();
    }
    
    public final void recoverPassword() {
        GameManager.instance.closeTopDialog();
        GameManager.instance.showConfirmDialog(String.valueOf(TextConstant.willSendBackPassword()) + GameManager.recoveryPhone + this.usernameField.getText() + Xuka.refCode + " => " + GameManager.instance.getRecoveryInfo().substring(6), new thien_cw(this));
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
        GameManager.getInstance().showCenterDialog(String.valueOf(TextConstant.signingAs()) + this.usernameField.getText(), null, null, new UIAction(TextConstant.cancel(), new thien_cy(this))).setExtraOption(true);
        GameManager.getInstance().handleConnectionStatus();
        GameManager.getInstance().loginAction = new LoginAction(this);
    }

    public static void removeCommentField(LoginScreen loginScreen) {
        if (loginScreen.commentField != null) {
            loginScreen.removeControl(loginScreen.commentField);
        }
    }
    
    public static FormScreen getSettingsScreen() {
        return LoginScreen.settingsScreen;
    }
}

