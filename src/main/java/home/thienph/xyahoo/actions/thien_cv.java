package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.TextField;
import home.thienph.xyahoo.components.UICheckBox;
import home.thienph.xyahoo.components.UIDropdown;
import home.thienph.xyahoo.main.Xuka;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.LoginScreen;

public final class thien_cv implements IAction {
    private final UICheckBox a;
    private final UICheckBox b;
    private final UIDropdown c;
    private final UICheckBox d;
    private final UICheckBox e;

    public thien_cv(UICheckBox UICheckBox2, UICheckBox UICheckBox3, UIDropdown UIDropdown2, UICheckBox UICheckBox4, UICheckBox UICheckBox5) {
        this.a = UICheckBox2;
        this.b = UICheckBox3;
        this.c = UIDropdown2;
        this.d = UICheckBox4;
        this.e = UICheckBox5;
    }

    public final void action() {
        GameManager.getInstance().loginScreen.startSlide(1);
        GameManager.getInstance().removeScreen(LoginScreen.getSettingsScreen());
        if (GameManager.autoLogin != this.a.isChecked) {
            GameManager.autoLogin = this.a.isChecked;
            Xuka.saveFlag("atlog", GameManager.autoLogin);
        }
        if (GameManager.autoLoginYahoo != this.b.isChecked) {
            GameManager.autoLoginYahoo = this.b.isChecked;
            Xuka.saveFlag("atlogY", GameManager.autoLoginYahoo);
        }
        if (TextField.multiTapSpeedIndex != this.c.getSelectedIndex()) {
            TextField.multiTapSpeedIndex = this.c.getSelectedIndex();
            Xuka.saveCaret(TextField.multiTapSpeedIndex);
        }
        if (GameManager.vibrateEnabled != this.d.isChecked) {
            GameManager.vibrateEnabled = this.d.isChecked;
            Xuka.saveFlag("vibrate", GameManager.vibrateEnabled);
        }
        if (GameManager.soundEnabled != !this.e.isChecked) {
            GameManager.soundEnabled = !this.e.isChecked;
            Xuka.saveFlag("sound", GameManager.soundEnabled);
        }
    }
}
