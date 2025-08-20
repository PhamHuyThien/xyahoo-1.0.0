package home.thienph.xyahoo.components;

import home.thienph.xyahoo.actions.IAction;
import home.thienph.xyahoo.actions.thien_ah;
import home.thienph.xyahoo.data.data.UIAction;
import home.thienph.xyahoo.constants.UIColorConstant;
import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.managers.ImageCacheManager;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class UIImageView extends UIControlBase {
    private Image displayImage;
    public byte[] imageData;
    private int targetWidth;
    private int targetHeight;
    public IAction clickHandler;
    private int[] iconPositions = null;

    static {
        String[] invalidChars = new String[]{"/", "\\", "<", ">", "?", ":", "\"", "*", "|"};
    }

    public final void setTargetSize(int n, int n2) {
        this.targetWidth = n;
        this.targetHeight = n2;
    }

    public final void setImage(Image image) {
        Image image2;
        int n = this.targetHeight;
        int n2 = this.targetWidth;
        int n3 = image.getWidth();
        int n4 = image.getHeight();
        if (n3 == n2 && n4 == n) {
            image2 = image;
        } else {
            Image image3 = Image.createImage((int)n2, (int)n);
            Graphics graphics = image3.getGraphics();
            int n5 = 0;
            while (n5 < n) {
                int n6 = 0;
                while (n6 < n2) {
                    graphics.setClip(n6, n5, 1, 1);
                    int n7 = n6 * n3 / n2;
                    int n8 = n5 * n4 / n;
                    graphics.drawImage(image, n6 - n7, n5 - n8, 20);
                    ++n6;
                }
                ++n5;
            }
            image2 = Image.createImage((Image)image3);
        }
        this.displayImage = image2;
    }

    public UIImageView() {
        this.isVisible = false;
        this.actionTertiary = new UIAction(TextConstant.select(), new thien_ah(this));
    }

    public final boolean handleKeyInput(int n) {
        return true;
    }

    public final void handleKeyPress(int n, int n2) {
        if (this.clickHandler != null) {
            this.clickHandler.action();
            return;
        }
    }

    public final void draw(Graphics graphics) {
        if (this.displayImage != null) {
            graphics.drawImage(this.displayImage, this.baseX, this.baseY, 0);
        }
        if (this.iconPositions != null) {
            int n = 0;
            while (n < this.iconPositions.length) {
                int n2 = this.iconPositions[n] >> 24;
                int n3 = this.iconPositions[n] << 8 >> 24;
                short s = (short)this.iconPositions[n];
                Image image = ImageCacheManager.getImage(s);
                if (image != null) {
                    graphics.drawImage(image, this.baseX + (this.width >> 1) + n2, this.baseY + (this.height >> 1) + n3, 0);
                }
                ++n;
            }
        }
    }

    public final void drawBackground(Graphics graphics) {
        super.drawBackground(graphics);
        graphics.setColor(UIColorConstant.getSecondaryColor());
        graphics.drawRect(this.baseX, this.baseY, this.width, this.height);
        graphics.setColor(UIColorConstant.getHighlightColor());
        graphics.drawRect(this.baseX - 1, this.baseY - 1, this.width + 2, this.height + 2);
    }

    public final void update() {
    }

    public final void setIconPositions(int[] nArray) {
        this.iconPositions = nArray;
    }

    public final boolean handleSoftKey(int n) {
        return true;
    }
}
