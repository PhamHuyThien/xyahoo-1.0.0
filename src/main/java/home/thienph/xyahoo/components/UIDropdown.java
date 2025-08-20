package home.thienph.xyahoo.components;

import home.thienph.xyahoo.actions.IAction;
import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.utils.TextRenderer;

import javax.microedition.lcdui.Graphics;

public final class UIDropdown
extends UIControlBase {
    public String[] options;
    private int selectIndex;
    private int actionDelay = 0;
    public IAction changeHandler;
    private String displayText = "";

    public UIDropdown(String[] stringArray, int n, int n2, int n3, int n4) {
        this.options = stringArray;
        this.baseX = n;
        this.baseY = n2;
        this.width = n3;
        this.height = n4;
        this.updateDisplayText();
    }

    public final int getSelectedIndex() {
        return this.selectIndex;
    }

    public final void setSelectedIndex(int n) {
        this.selectIndex = n;
        this.updateDisplayText();
    }

    public final boolean handleSoftKey(int n) {
        if (n == 14) {
            this.selectPrevious();
            return false;
        }
        if (n == 15) {
            this.selectNext();
            return false;
        }
        return true;
    }

    private void selectPrevious() {
        --this.selectIndex;
        if (this.selectIndex < 0) {
            this.selectIndex = this.options.length - 1;
        }
        if (this.changeHandler != null) {
            this.changeHandler.action();
        }
        this.updateDisplayText();
    }

    private void selectNext() {
        ++this.selectIndex;
        if (this.selectIndex >= this.options.length) {
            this.selectIndex = 0;
        }
        if (this.changeHandler != null) {
            this.changeHandler.action();
        }
        this.updateDisplayText();
    }

    public final boolean handleKeyInput(int n) {
        if (this.options.length == 0) {
            return true;
        }
        if (n == 14) {
            this.selectPrevious();
            return false;
        }
        if (n == 15) {
            this.selectNext();
            return false;
        }
        return true;
    }

    public final void handleKeyPress(int n, int n2) {
        this.parentScreen.selectControl(this);
        ++this.selectIndex;
        if (this.selectIndex >= this.options.length) {
            this.selectIndex = 0;
        }
        if (this.changeHandler != null) {
            this.changeHandler.action();
        }
        this.updateDisplayText();
    }

    private void updateDisplayText() {
        if (this.options.length != 0) {
            this.displayText = TextRenderer.wrapText(this.options[this.selectIndex], this.width - 35, TextRenderer.charWidth);
        }
    }

    public final void draw(Graphics graphics) {
        boolean bl = this.isSelected();
        if (bl) {
            graphics.setColor(2580);
            graphics.fillRect(this.baseX + 2, this.baseY + 2, this.width - 3, this.height - 3);
        }
        int n = this.baseY + 3 + (TextRenderer.useCustomFont ? 0 : 1);
        graphics.setColor(0xFFFFFF);
        if (this.options.length == 0) {
            TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(TextConstant.noItem(), this.baseX + (this.width >> 1), n, 2, graphics, TextRenderer.charWidth, TextRenderer.fontHeight);
        } else {
            TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(this.displayText, this.baseX + (this.width >> 1), n, 2, graphics, TextRenderer.charWidth, TextRenderer.fontHeight);
        }
        n = this.height - 2;
        int n2 = this.baseY + 1;
        graphics.setColor(bl ? 14675958 : 9478569);
        UIButton.drawBorder(graphics, this.baseX + 1, n2, this.width - 2, n);
        n = this.baseY + (this.height >> 1);
        graphics.drawImage(BuddyListControl.groupIcons[2], this.baseX + 9, n, 3);
        graphics.drawImage(BuddyListControl.groupIcons[3], this.baseX + this.width - 9, n, 3);
    }

    public final void setChangeHandler(IAction IAction2) {
        this.changeHandler = IAction2;
        if (this.actionTertiary != null) {
            this.actionTertiary.actionHandler = IAction2;
        }
    }

    public final void update() {
        if (this.actionDelay > 0) {
            --this.actionDelay;
            if (this.actionDelay == 0 && this.changeHandler != null) {
                this.changeHandler.action();
            }
        }
    }

    public final void drawBackground(Graphics graphics) {
    }

    public final String getSelectedItem() {
        if (this.selectIndex < 0 || this.selectIndex >= this.options.length) {
            return null;
        }
        return this.options[this.selectIndex];
    }

    public final void setSelectedItem(String string) {
        int n = 0;
        while (n < this.options.length) {
            if (this.options[n].equals(string)) {
                this.selectIndex = n;
                return;
            }
            ++n;
        }
    }
}
