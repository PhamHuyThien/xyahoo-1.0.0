package home.thienph.xyahoo.components;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.Screen;
import home.thienph.xyahoo.main.GameCanvas;
import home.thienph.xyahoo.utils.TextRenderer;

import javax.microedition.lcdui.Graphics;

public final class PopupDialogLayout {
    public UIAction leftAction;
    public UIAction centerAction;
    public UIAction rightAction;
    private String[] lines;
    public boolean showExtraOption = false;
    private int lineCount;
    private int centerX;
    private int startY;
    private int width;
    private int height;
    private int contentHeight;
    private int popupHeight;
    private int popupWidth;
    private int posY;
    private int contentStartY;

    public PopupDialogLayout(String string, UIAction UIAction2, UIAction UIAction3, UIAction UIAction4) {
        this.lines = TextRenderer.splitText(string, GameCanvas.screenWidth - 30, TextRenderer.charWidth);
        this.leftAction = UIAction2;
        this.rightAction = UIAction4;
        this.centerAction = UIAction3;
        this.calculateLayout();
    }

    public PopupDialogLayout(String[] stringArray, UIAction UIAction2, UIAction UIAction3, UIAction UIAction4) {
        this.lines = stringArray;
        this.leftAction = UIAction2;
        this.rightAction = UIAction4;
        this.centerAction = UIAction3;
        this.calculateLayout();
    }

    public final void setExtraOption(boolean bl) {
        this.showExtraOption = bl;
        this.calculateLayout();
    }

    private void calculateLayout() {
        this.lineCount = this.lines.length;
        this.contentHeight = this.lineCount * (TextRenderer.fontHeight + 2) + (this.showExtraOption ? 20 : 0);
        this.popupHeight = this.contentHeight + (TextRenderer.fontHeight << 1) - 1;
        if (this.popupHeight < 30) {
            this.popupHeight = 30;
        }
        if (this.popupHeight > GameCanvas.screenHeight - 35) {
            this.popupHeight = this.contentHeight = GameCanvas.screenHeight - 35;
        }
        int n = 0;
        while (n < this.lineCount) {
            int n2 = TextRenderer.computeTextWidth(this.lines[n], TextRenderer.charWidth) + 10;
            if (this.popupWidth < n2) {
                this.popupWidth = n2;
            }
            ++n;
        }
        this.popupWidth += 60;
        if (this.popupWidth < 100) {
            this.popupWidth = 100;
        }
        if (this.popupWidth > GameCanvas.screenWidth - 15) {
            this.popupWidth = GameCanvas.screenWidth - 15;
        }
        this.posY = GameCanvas.screenHeight - this.popupHeight >> 1;
        this.contentStartY = this.posY + (this.popupHeight - this.contentHeight >> 1) + 1;
        this.startY = this.posY + 1;
        this.width = this.popupWidth - 2;
        this.height = this.popupHeight - 2;
    }

    public final void paint(Graphics graphics) {
        int n;
        this.centerX = (GameCanvas.screenWidth - this.popupWidth >> 1) + 1;
        graphics.setClip(this.centerX, this.startY, this.width, this.height);
        int n2 = this.popupWidth / 50 + 1;
        while (--n2 >= 0) {
            n = this.popupHeight / 50 + 1;
            while (--n >= 0) {
                graphics.drawImage(GameManager.dialogBackground, this.centerX + n2 * 50, this.startY + n * 50, 0);
            }
        }
        if (this.popupWidth > 110) {
            graphics.drawRegion(GameManager.dialogTop, 0, 0, 55, 20, 0, this.centerX, this.startY, 0);
            graphics.drawRegion(GameManager.dialogTop, 87, 0, 55, 20, 0, this.centerX + this.width - 55, this.startY, 0);
            graphics.setClip(this.centerX + 55, this.startY, this.width - 110, 20);
            n = n2 = (this.width - 110 >> 5) + 1;
            while (--n >= 0) {
                graphics.drawRegion(GameManager.dialogTop, 55, 0, 32, 20, 0, this.centerX + 55 + n * 32, this.startY, 0);
            }
        }
        graphics.setClip(-1000, -1000, 5000, 5000);
        graphics.setColor(0xDDF3FF);
        UIButton.a(graphics, this.centerX - 1, this.posY, this.popupWidth - 1, this.popupHeight - 1);
        graphics.drawRect(this.centerX - 1, this.posY, this.popupWidth - 1, this.popupHeight - 1);
        UIButton.a(graphics, this.centerX - 2, this.posY - 1, this.popupWidth + 1, this.popupHeight + 1);
        graphics.setClip(-1000, -1000, 5000, 5000);
        this.centerX = GameCanvas.screenWidth >> 1;
        graphics.setColor(0xFFFFFF);
        n2 = 0;
        while (n2 < this.lineCount) {
            TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(this.lines[n2], this.centerX, this.contentStartY + n2 * (TextRenderer.fontHeight + 2), 2, graphics, TextRenderer.charWidth, TextRenderer.fontHeight);
            ++n2;
        }
        if (this.showExtraOption) {
            GameManager.instance.drawLoadingAnimation(graphics, this.centerX, this.contentStartY + this.lineCount * TextRenderer.fontHeight + TextRenderer.fontHeight + 3);
        }
        Screen.drawFooter(graphics);
        graphics.setColor(0xFFFFFF);
        n2 = GameCanvas.screenHeight - (GameManager.topMargin >> 1) - (TextRenderer.fontHeight >> 1) + (TextRenderer.useCustomFont ? 0 : 2);
        if (this.leftAction != null) {
            TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(this.leftAction.label, 4, n2, graphics);
        }
        if (this.centerAction != null) {
            TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(this.centerAction.label, this.centerX, n2, 2, graphics, TextRenderer.charWidth, TextRenderer.fontHeight);
        }
        if (this.rightAction != null) {
            TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(this.rightAction.label, GameCanvas.screenWidth - 4, n2, 1, graphics, TextRenderer.charWidth, TextRenderer.fontHeight);
        }
    }
}
