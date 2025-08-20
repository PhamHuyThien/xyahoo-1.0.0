package home.thienph.xyahoo.components;

import home.thienph.xyahoo.screens.FormScreen;
import home.thienph.xyahoo.utils.TextRenderer;

import javax.microedition.lcdui.Graphics;

public final class SectionHeaderControl
extends UIControlBase {
    private String sectionTitle;
    private int selectionTimer;
    public FormScreen parentForm;
    public int sectionIndex;
    private int textWidth;
    public boolean isExpanded;

    public SectionHeaderControl() {
    }

    public SectionHeaderControl(String title, int x, int y, int w, int h) {
        this();
        this.selectionTimer = 0;
        this.sectionTitle = title;
        this.baseX = 0;
        this.baseY = 0;
        this.width = w;
        this.height = h < 19 ? h : 19;
    }

    public final boolean handleKeyInput(int n) {
        if (n == 16) {
            this.selectionTimer = 2;
            return false;
        }
        return true;
    }

    public final void handleKeyPress(int n, int n2) {
        this.parentForm.toggleSection(this.sectionIndex);
    }

    public final void draw(Graphics graphics) {
        boolean bl = this.isSelected();
        if (bl) {
            this.textWidth = TextRenderer.computeTextWidth(this.sectionTitle, TextRenderer.charWidth);
            graphics.setColor(2580);
            graphics.fillRoundRect(this.baseX + 19, this.baseY, this.textWidth + 10, this.height, 8, 8);
        }
        graphics.setColor(3981823);
        TextRenderer.getFontRenderer(TextRenderer.colorHighlight).drawText(this.sectionTitle, this.baseX + 23, this.baseY + (this.height - TextRenderer.fontHeight >> 1), graphics);
        graphics.drawImage(BuddyListControl.groupIcons[this.isExpanded ? 0 : 1], this.baseX + 10, this.baseY + (this.height >> 1), 3);
    }

    public final void update() {
        if (this.selectionTimer > 0) {
            --this.selectionTimer;
            if (this.selectionTimer == 0) {
                this.parentForm.toggleSection(this.sectionIndex);
            }
        }
    }

    public final void drawBackground(Graphics graphics) {
    }

    public final boolean handleSoftKey(int n) {
        return true;
    }
}
