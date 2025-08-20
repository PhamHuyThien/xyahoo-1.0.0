package home.thienph.xyahoo.components;

import home.thienph.xyahoo.data.data.UIAction;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.actions.IAction;
import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.utils.TextRenderer;

import javax.microedition.lcdui.Graphics;

public final class UICheckBox
extends UIControlBase {
    private String labelText;
    private int pressTimer;
    public boolean isChecked;
    public IAction changeHandler;

    public UICheckBox(String string, int n, int n2, int n3, int n4) {
        this.labelText = string;
        this.baseX = n;
        this.baseY = n2;
        this.width = n3;
        this.height = n4;
        this.actionSecondary = new UIAction(TextConstant.select(), null);
    }

    public final boolean handleSoftKey(int n) {
        return this.handleKeyInput(n);
    }

    public final boolean handleKeyInput(int n) {
        if (n == 18) {
            this.pressTimer = 2;
            return false;
        }
        return true;
    }

    private void toggle() {
        boolean bl = this.isChecked = !this.isChecked;
        if (this.changeHandler != null) {
            this.changeHandler.action();
        }
    }

    public final void handleKeyPress(int n, int n2) {
        this.parentScreen.selectControl(this);
        this.toggle();
    }

    public final void update() {
        if (this.pressTimer > 0) {
            --this.pressTimer;
            if (this.pressTimer == 0) {
                this.toggle();
            }
        }
    }

    public final void draw(Graphics graphics) {
        boolean bl = this.isSelected();
        graphics.drawImage(this.isChecked ? GameManager.chatIcons[1] : GameManager.chatIcons[0], this.baseX + 8, this.baseY + (this.height >> 1) + 1, 3);
        if (bl) {
            graphics.setColor(14675958);
            graphics.drawRoundRect(this.baseX + 13 + 4, this.baseY + 1, this.width - 13, this.height, 5, 5);
        }
        graphics.setColor(0xFFFFFF);
        TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(this.labelText, this.baseX + 13 + 5, this.baseY + 3, graphics);
    }

    public final void drawBackground(Graphics graphics) {
    }
}
