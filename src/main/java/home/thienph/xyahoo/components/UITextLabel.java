package home.thienph.xyahoo.components;

import home.thienph.xyahoo.constants.UIColorConstant;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.Screen;
import home.thienph.xyahoo.utils.TextRenderer;

import javax.microedition.lcdui.Graphics;

public final class UITextLabel extends UIControlBase {
    private String processedText;
    private boolean hasEmoticons;
    public int textColor = 0xFFFFFF;
    public Integer fontRenderer = TextRenderer.colorWhite;
    private int textLength;
    private boolean visible;

    public UITextLabel() {
        this.visible = true;
    }

    private UITextLabel(String string) {
        this.isVisible = false;
        this.processedText = TextRenderer.replaceEmoticons(string, false);
        if (this.processedText == null) {
            this.hasEmoticons = false;
            this.processedText = string;
        } else {
            this.hasEmoticons = true;
        }
        this.textLength = this.processedText.length();
    }

    public UITextLabel(String string, int n, int n2, int n3, int n4) {
        this(string);
        this.baseX = n;
        this.baseY = n2;
        this.width = TextRenderer.computeTextWidth(string, TextRenderer.charWidth);
        this.height = n3;
        this.selectedIndex = n4;
        this.textLength = this.processedText.length();
    }

    public UITextLabel(String string, int n, int n2, int n3) {
        this(string, n, n2, n3, -1);
    }

    public final boolean handleKeyInput(int n) {
        return true;
    }

    public final void draw(Graphics graphics) {
        if (this.visible) {
            return;
        }
        boolean bl = this.isSelected();
        if (!this.hasEmoticons) {
            if (bl) {
                graphics.setColor(2580);
                graphics.fillRoundRect(this.baseX - 1, this.baseY + 2, this.width + 7, this.height, 8, 8);
            }
            this.drawText(graphics, this.processedText, this.baseX + 2, this.baseY + 2);
        }
        if (this.textLength == 0) {
            graphics.setColor(UIColorConstant.getPrimaryColor());
            graphics.fillRect(this.baseX, this.baseY + (this.height >> 1), Screen.e - this.baseX - 5, 1);
            return;
        }
        if (!this.hasEmoticons) {
            return;
        }
        if (bl) {
            graphics.setColor(2580);
            graphics.fillRoundRect(this.baseX - 1, this.baseY + 2, Screen.e - this.baseX - 2, this.height, 8, 8);
        }
        String string = "";
        int n = 0;
        int n2 = this.baseY + 2;
        int n3 = 0;
        while (n3 < this.textLength) {
            int n4 = this.processedText.charAt(n3);
            if (n4 >= 30000) {
                this.drawText(graphics, string, this.baseX + 2 + n, n2);
                string = "";
                graphics.drawRegion(GameManager.smileyIcons, (n4 -= 30000) * 18, 0, 18, 18, 0, this.baseX + 2 + (n += TextRenderer.computeTextWidth(string, TextRenderer.charWidth)) + 10, this.baseY + (TextRenderer.fontHeight >> 1), 3);
                n += 20;
            } else {
                string = String.valueOf(string) + (char)n4;
            }
            ++n3;
        }
        this.drawText(graphics, string, this.baseX + 2 + n, n2);
    }

    private void drawText(Graphics graphics, String string, int n, int n2) {
        graphics.setColor(this.textColor);
        TextRenderer.getFontRenderer(this.fontRenderer).drawText(string, n, n2, graphics);
    }

    public final void drawBackground(Graphics graphics) {
    }

    public final void update() {
    }

    public final boolean handleSoftKey(int n) {
        return true;
    }
}
