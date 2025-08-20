package home.thienph.xyahoo.components;

import home.thienph.xyahoo.data.data.UIAction;
import home.thienph.xyahoo.screens.Screen;

import javax.microedition.lcdui.Graphics;

public abstract class UIControlBase {
    public boolean isVisible;
    public boolean isEnabled;
    public int baseX;
    public int baseY;
    public int width;
    public int height;
    public int zIndex;
    public Screen parentScreen;
    public UIAction actionPrimary;
    public UIAction actionSecondary;
    public UIAction actionTertiary;
    public int selectedIndex = -1;
    public boolean hasFocus = false;

    public UIControlBase() {
        this.isVisible = true;
    }

    public UIControlBase(int n, int n2, int n3, int n4, boolean bl) {
        this.baseX = n;
        this.baseY = n2;
        this.width = n3;
        this.height = n4;
        this.isVisible = true;
    }

    public final boolean isSelected() {
        if (this.parentScreen == null) {
            return false;
        }
        return this.parentScreen.isSelectedControl(this);
    }

    public final void setBounds(int n, int n2, int n3, int n4) {
        this.baseX = n;
        this.baseY = n2;
        this.width = n3;
        this.height = n4;
    }

    public abstract void draw(Graphics var1);

    public abstract void update();

    public abstract boolean handleKeyInput(int var1);

    public void drawBackground(Graphics graphics) {
    }

    public abstract boolean handleSoftKey(int var1);

    public void handleFocus() {
    }

    public void drawScrollbar(Graphics graphics) {
    }

    public void handleKeyPress(int n, int n2) {
    }

    public void handlePointerRelease(int n, int n2) {
    }

    public void onDrag(int n, int n2) {
    }
}
