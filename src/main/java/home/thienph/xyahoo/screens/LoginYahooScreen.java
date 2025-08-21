package home.thienph.xyahoo.screens;

import home.thienph.xyahoo.actions.*;
import home.thienph.xyahoo.components.*;
import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.data.data.ContactDataSource;
import home.thienph.xyahoo.data.data.PopupSideElementData;
import home.thienph.xyahoo.data.data.UIAction;
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
    public BuddyListControl buddyListControl;
    public static String currentUsername;
    public static String originalUsername;
    public static int loginStatus;
    public static String statusMessage;
    private static boolean isInvisibleMode;
    private boolean isSearchMode;
    private boolean isLoggedIn;
    private Vector menuActions;
    public PopupSideElementData popupMenuData;
    private TextField searchTextField;
    public boolean shouldSignOut;
    private UITextLabel yahooIdLabel;
    private TextField usernameTextField;
    private UITextLabel passwordLabel;
    private TextField passwordTextField;
    private UICheckBox invisibleCheckbox;
    private UITextLabel domainLabel;
    private UIDropdown domainDropdown;
    private int logoXPosition;
    private int logoYPosition;
    private UIAction menuAction;
    private UIAction signInAction;
    private UIAction closeAction;
    private int checksumValue;
    private FormScreen statusFormScreen;
    private UIDropdown statusDropdown;
    private TextField statusMessageTextField;

    public LoginYahooScreen() {
        String string = Xuka.d();
        String string2 = Xuka.e();
        this.title = "Yahoo!";
        int n = HomeScreen.instance.homeGridMenu.images[0].getHeight();
        this.logoXPosition = Screen.e - HomeScreen.instance.homeGridMenu.images[0].getWidth() >> 1;
        int n2 = (TextRenderer.fontHeight + 6 << 2) + 28 + n + 5;
        this.logoYPosition = n2 <= Screen.formHeight - GameManager.topMargin ? GameManager.headerHeight - 10 + (Screen.formHeight - GameManager.topMargin - n2 >> 1) : GameManager.headerHeight + 5;
        n = this.logoYPosition + n - 3;
        this.yahooIdLabel = new UITextLabel("Yahoo! ID:", FormScreen.formXOffset, n, TextRenderer.fontHeight);
        this.yahooIdLabel.width = FormScreen.formMarginLeft;
        this.usernameTextField = new TextField();
        this.usernameTextField.setBounds(FormScreen.formStartX, n, FormScreen.formWidth, TextRenderer.fontHeight + 6);
        this.usernameTextField.setInputType(0);
        this.passwordLabel = new UITextLabel(String.valueOf(TextConstant.password()) + ":", FormScreen.formXOffset, n += this.usernameTextField.height + 7, TextRenderer.fontHeight);
        this.passwordLabel.width = FormScreen.formMarginLeft;
        this.passwordTextField = new TextField();
        this.passwordTextField.setBounds(FormScreen.formStartX, n, FormScreen.formWidth, TextRenderer.fontHeight + 6);
        this.passwordTextField.setInputType(2);
        this.passwordTextField.isShiftMode = true;
        this.usernameTextField.setText(string);
        this.usernameTextField.lineSpacing = -5;
        this.passwordTextField.setText(string2);
        this.passwordTextField.lineSpacing = -5;
        this.domainLabel = new UITextLabel("Domain:", FormScreen.formXOffset, n += this.passwordTextField.height + 7, TextRenderer.fontHeight);
        this.domainLabel.width = FormScreen.formMarginLeft;
        this.domainDropdown = new UIDropdown(new String[]{"@yahoo", "@ymail", "@rocketmail"}, FormScreen.formStartX, n, FormScreen.formWidth, TextRenderer.fontHeight + 6);
        this.domainDropdown.setSelectedIndex(Xuka.readDomainYahoo());
        int n3 = Screen.e - (TextRenderer.computeTextWidth(TextConstant.invisible(), TextRenderer.charWidth) + 13 + 4) >> 1;
        this.invisibleCheckbox = new UICheckBox(TextConstant.invisible(), n3, n += 6 + this.domainDropdown.height, TextRenderer.computeTextWidth(TextConstant.invisible(), TextRenderer.charWidth) + 13 + 4, TextRenderer.fontHeight + 4);
        this.invisibleCheckbox.isChecked = Xuka.readFlag("statusYahoo", false);
        int cfr_ignored_0 = this.invisibleCheckbox.height;
        this.searchTextField = new TextField();
        this.searchTextField.isShiftMode = true;
        this.searchTextField.setBounds(0, Screen.formHeight - GameManager.topMargin - TextRenderer.fontHeight - 11, Screen.e - 6, TextRenderer.fontHeight + 6);
        this.buddyListControl = new BuddyListControl(1, 1, Screen.e - 3, Screen.formHeight - 2 - GameManager.topMargin, true);
        this.addControl(this.buddyListControl);
        this.selectControl(this.buddyListControl);
        this.buddyListControl.isAutoChatEnabled = true;
        this.buddyListControl.isFilterActive = Xuka.readFlag("hideOffline", true);
        this.menuActions = new Vector();
        this.menuActions.addElement(new UIAction(TextConstant.showHideOffline(), new YahooShowHideOfflineAction(this)));
        this.menuActions.addElement(new UIAction(TextConstant.status(), new YahooStatusAction(this)));
        this.menuActions.addElement(new UIAction(TextConstant.inviteYahoo(), new InviteYahooAction(this)));
        this.menuActions.addElement(new UIAction(TextConstant.signOutYahoo(), new LogoutYahooAction(this)));
    }

    public final void cleanup() {
        if (this.shouldSignOut || this.isLoggedIn) {
            this.shouldSignOut = false;
            MessageHandler.b(currentUsername, 2);
            this.switchMode(false);
        }
        GameManager.instance.removeScreen(this.statusFormScreen);
        this.statusFormScreen = null;
    }

    public final void switchMode(boolean bl) {
        this.isLoggedIn = bl;
        if (bl) {
            if (this.popupMenuData == null) {
                this.popupMenuData = new PopupSideElementData(this.menuActions);
                this.menuAction = new UIAction("Menu", new ClickMenuYahooLoginAction(this));
            }
            this.leftCommand = this.menuAction;
            this.centerCommand = null;
            this.removeControl(this.yahooIdLabel);
            this.removeControl(this.usernameTextField);
            this.removeControl(this.passwordLabel);
            this.removeControl(this.passwordTextField);
            this.removeControl(this.invisibleCheckbox);
            this.removeControl(this.domainLabel);
            this.removeControl(this.domainDropdown);
            this.addControl(this.buddyListControl);
            this.selectControl(this.buddyListControl);
        } else {
            if (this.signInAction == null) {
                this.signInAction = new UIAction(TextConstant.signIn(), new ClickLoginYahooAction(this));
                this.closeAction = new UIAction(TextConstant.close(), new CloseYahooLoginAction(this));
            }
            this.centerCommand = this.signInAction;
            this.leftCommand = this.closeAction;
            this.exitSearchMode();
            this.removeControl(this.buddyListControl);
            this.addControl(this.yahooIdLabel);
            this.addControl(this.usernameTextField);
            this.addControl(this.passwordLabel);
            this.addControl(this.passwordTextField);
            this.addControl(this.domainLabel);
            this.addControl(this.domainDropdown);
            this.addControl(this.invisibleCheckbox);
            this.selectControl(this.usernameTextField);
        }
        this.scrollTargetY = 0;
        this.scrollY = 0;
        LoginYahooScreen loginYahooScreen2 = this;
        loginYahooScreen2.buddyListControl.handleFocus();
        System.gc();
    }

    public final void drawBackground(Graphics graphics) {
        if (!this.isLoggedIn) {
            graphics.drawImage(HomeScreen.instance.homeGridMenu.images[0], this.logoXPosition, this.logoYPosition, 0);
        }
        super.drawBackground(graphics);
    }

    public final void performLogin() {
        this.usernameTextField.setText(this.usernameTextField.getText().trim().toLowerCase());
        String string = this.usernameTextField.getText();
        String string2 = this.passwordTextField.getText();
        if (string.equals("")) {
            this.selectControl(this.usernameTextField);
            return;
        }
        if (string2.equals("")) {
            this.selectControl(this.passwordTextField);
            return;
        }
        currentUsername = string;
        originalUsername = string;
        loginStatus = this.invisibleCheckbox.isChecked ? 12 : 0;
        isInvisibleMode = this.invisibleCheckbox.isChecked;
        String string3 = Xuka.readCustomStr(currentUsername, true);
        statusMessage = string3 == null ? "" : string3;
        Xuka.saveYahooID(string);
        Xuka.saveYahooPW(string2);
        int n = this.domainDropdown.getSelectedIndex();
        Xuka.saveDomainYahoo(this.domainDropdown.getSelectedIndex());
        if (n == 1 || n == 2) {
            currentUsername = String.valueOf(currentUsername) + this.domainDropdown.getSelectedItem() + ".com";
        }
        this.buddyListControl.isLoading = true;
        this.switchMode(true);
        LoginYahooScreen loginYahooScreen2 = this;
        this.checksumValue = GameManager.getChecksumValue(true);
        if (loginYahooScreen2.checksumValue != -1) {
            ContactDataSource contactDataSource2 = GameManager.loadBuddyList(true, currentUsername);
            if (contactDataSource2 != null) {
                GameManager.instance.loginYahooScreen.buddyListControl.setDataSource(contactDataSource2, -1);
            } else {
                loginYahooScreen2.checksumValue = -1;
            }
        }
        MessageHandler.login(string, string2, loginStatus, 2, this.checksumValue);
    }

    public final void updateLayout() {
        this.buddyListControl.handleFocus();
    }

    public final void drawOverlay(Graphics graphics) {
        this.buddyListControl.drawScrollbar(graphics);
    }

    public final void clearBuddyList() {
        if (this.buddyListControl.displayItems != null) {
            this.buddyListControl.displayItems.removeAllElements();
        }
        this.buddyListControl.displayItems = null;
        this.buddyListControl.contactDataSource = null;
    }

    private void exitSearchMode() {
        this.selectControl(this.buddyListControl);
        this.removeControl(this.searchTextField);
        this.isSearchMode = false;
    }

    public final boolean handleInput(boolean[] blArray, boolean[] blArray2, int[] nArray) {
        Object object;
        if (nArray[0] > 32 && !this.isSearchMode && this.isLoggedIn) {
            object = this;
            ((LoginYahooScreen)object).searchTextField.setText("");
            ((Screen)object).addControl(((LoginYahooScreen)object).searchTextField);
            ((Screen)object).selectControl(((LoginYahooScreen)object).searchTextField);
            ((LoginYahooScreen)object).isSearchMode = true;
        }
        object = "";
        if (this.isSearchMode) {
            if (blArray[12]) {
                blArray[12] = false;
                this.buddyListControl.handleKeyInput(12);
            } else if (blArray[13]) {
                blArray[13] = false;
                this.buddyListControl.handleKeyInput(13);
            } else if (blArray[16]) {
                blArray[16] = false;
                this.buddyListControl.handleKeyInput(16);
            }
            object = this.searchTextField.getText();
        }
        boolean bl = super.handleInput(blArray, blArray2, nArray);
        if (this.isSearchMode) {
            if (this.searchTextField.getText().equals("")) {
                this.exitSearchMode();
            }
            if (!this.searchTextField.getText().equals(object)) {
                this.buddyListControl.setSearchFilter(this.searchTextField.getText());
            }
        }
        return bl;
    }

    public final void h() {
        Xuka.setXpamFlag(currentUsername);
        GameManager.getInstance().showConfirmDialog(String.valueOf(TextConstant.inviteYourYahoo()) + "?", new thien_gs(this));
    }

    public static void showInviteDialog(LoginYahooScreen loginYahooScreen2) {
        if (isInvisibleMode) {
            GameManager.instance.showNotification("Vui lòng thoát Yahoo! và bỏ chọn đăng nhập ẩn", (Image)null, 1);
            return;
        }
        if (GameManager.isShowingAnimation) {
            GameManager.instance.showNotification("Vui lòng chờ 10s", (Image)null, 1);
            return;
        }
        if (loginYahooScreen2.statusFormScreen == null) {
            System.gc();
            loginYahooScreen2.statusFormScreen = new FormScreen();
            loginYahooScreen2.statusFormScreen.title = TextConstant.status();
            FormScreen cfr_ignored_0 = loginYahooScreen2.statusFormScreen;
            FormScreen.calculateFormDimensions(70, 150);
            loginYahooScreen2.statusFormScreen.currentY += 20;
            loginYahooScreen2.statusDropdown = UIFormBuilder.addDropdown(loginYahooScreen2.statusFormScreen, TextConstant.status(), new String[]{TextConstant.available(), TextConstant.invisible2()});
            loginYahooScreen2.statusMessageTextField = UIFormBuilder.addTextFieldWithLabel(loginYahooScreen2.statusFormScreen, TextConstant.statusMessage(), 0, -1);
            loginYahooScreen2.statusFormScreen.selectControl(loginYahooScreen2.statusDropdown);
            loginYahooScreen2.statusFormScreen.centerCommand = new UIAction("OK", new thien_gt(loginYahooScreen2));
            loginYahooScreen2.statusFormScreen.leftCommand = new UIAction(TextConstant.cancel(), new thien_gu(loginYahooScreen2));
        }
        loginYahooScreen2.statusDropdown.setSelectedIndex(loginStatus == 0 ? 0 : 1);
        GameManager.getInstance().showScreen(loginYahooScreen2.statusFormScreen);
        loginYahooScreen2.statusMessageTextField.setText(statusMessage);
        GameManager.getInstance().goToLastScreen();
    }

    public static TextField getStatusMessageTextField(LoginYahooScreen loginYahooScreen2) {
        return loginYahooScreen2.statusMessageTextField;
    }

    public static UIDropdown getStatusDropdown(LoginYahooScreen loginYahooScreen2) {
        return loginYahooScreen2.statusDropdown;
    }

   public static void a(LoginYahooScreen var0, String var1) {
      MessageHandler.a(var1, 2);
      statusMessage = var1;
      Xuka.saveCustomStr(currentUsername, var1, true);
   }

    public static FormScreen getStatusForm(LoginYahooScreen loginYahooScreen2) {
        return loginYahooScreen2.statusFormScreen;
    }
}
