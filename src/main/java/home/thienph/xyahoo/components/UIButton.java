package home.thienph.xyahoo.components;

import home.thienph.xyahoo.actions.IAction;
import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.data.data.UIAction;
import home.thienph.xyahoo.utils.TextRenderer;

import javax.microedition.lcdui.Graphics;

public final class UIButton
extends UIControlBase {
    private String buttonText;
    private int clickDelay;
    public IAction actionHandler;
    private static int tempHeight;
    private static int tempY;
    private static int tempX;
    private static int tempBottom;

    public UIButton() {
    }

    public UIButton(String string, int n, int n2, int n3, int n4) {
        this.clickDelay = 0;
        this.buttonText = string;
        this.baseX = n;
        this.baseY = n2;
        this.width = n3;
        this.height = n4;
        this.actionTertiary = new UIAction(TextConstant.select(), null);
    }

    public final boolean handleKeyInput(int n) {
        if (n == 16) {
            this.clickDelay = 2;
            return false;
        }
        return true;
    }

    public final void handleKeyPress(int n, int n2) {
        if (this.isSelected()) {
            this.actionHandler.action();
            return;
        }
        this.parentScreen.selectControl(this);
    }

    public final void draw(Graphics graphics) {
        boolean bl = this.isSelected();
        graphics.setColor(bl ? 11918844 : 1124399);
        graphics.fillRect(this.baseX + 2, this.baseY + 2, this.width - 3, this.height - 3 >> 1);
        graphics.setColor(bl ? 9291764 : 728097);
        graphics.fillRect(this.baseX + 2, this.baseY + 1 + (this.height - 3 >> 1), this.width - 3, 2 + (this.height - 3 >> 1));
        graphics.setColor(bl ? 0 : 0xFFFFFF);
        TextRenderer.getFontRenderer(bl ? TextRenderer.colorSecondary : TextRenderer.colorWhite).drawText(this.buttonText, this.baseX + (this.width >> 1), this.baseY + 3, 2, graphics, TextRenderer.charWidth, TextRenderer.fontHeight);
        graphics.setColor(bl ? 14675958 : 9478569);
        UIButton.drawBorder(graphics, this.baseX + 1, this.baseY + 1, this.width - 2, this.height - 2);
    }

    public final void update() {
        if (this.clickDelay > 0) {
            --this.clickDelay;
            if (this.clickDelay == 0 && this.actionHandler != null) {
                this.actionHandler.action();
            }
        }
    }

    public static void drawBorder(Graphics graphics, int n, int n2, int n3, int n4) {
        tempY = n + ++n3 - 2;
        tempBottom = n2 + ++n4 - 2;
        tempX = n + 1;
        graphics.fillRect(tempX, tempBottom, 1, 1);
        graphics.fillRect(tempY, tempBottom, 1, 1);
        tempBottom = n2 + 1;
        graphics.fillRect(tempX, tempBottom, 1, 1);
        graphics.fillRect(tempY, tempBottom, 1, 1);
        tempHeight = n4 - 4;
        tempY = n2 + 2;
        graphics.fillRect(n, tempY, 1, tempHeight);
        graphics.fillRect(n + n3 - 1, tempY, 1, tempHeight);
        tempHeight = n + 2;
        tempY = n3 - 4;
        graphics.fillRect(tempHeight, n2, tempY, 1);
        graphics.fillRect(tempHeight, n2 + n4 - 1, tempY, 1);
    }

    public static void drawRoundedButton(Graphics graphics, int n, int n2, int n3, int n4, int n5) {
        graphics.setColor(11320516);
        graphics.fillRoundRect(n, n2, n3, n4, 8, 8);
        graphics.setColor(2580);
        graphics.fillRoundRect(n + 1, n2 + 1, n3 - 2, n4 - 2, 8, 8);
    }

    public final boolean handleSoftKey(int n) {
        return true;
    }
}
