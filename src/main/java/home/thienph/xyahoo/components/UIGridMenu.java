package home.thienph.xyahoo.components;

import home.thienph.xyahoo.actions.thien_ar;
import home.thienph.xyahoo.screens.Screen;
import home.thienph.xyahoo.managers.ImageCacheManager;
import home.thienph.xyahoo.utils.TextRenderer;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class UIGridMenu
extends UIControlBase {
    public Image[] images;
    private int[] iconIds;
    private int[] itemIds;
    private Vector itemLabels;
    private int horizontalSpacing;
    private int textVerticalOffset;
    private int itemCount;
    private int startX;
    private int startY;
    private int itemHeight;
    private int maxScrollRows;
    public int selectedCol = 0;
    public int selectedRow = 0;
    private int scrollOffsetY = 0;
    public int columns = 0;
    private int rows = 0;
    private int iconWidth;
    private int iconHeight;
    private boolean useCustomImages;
    private int layoutMode; //chế độ layout (1 hoặc 2), 75%
    private int bounceOffset = 0;
    private int lastDragY;

    public UIGridMenu(int maxScrollRows, int n2, int n3, int n4, int n5, String[] stringArray, int[] nArray, int[] nArray2, int n6, int n7, boolean bl, int n8) {
        this.baseX = 0;
        this.baseY = n2;
        this.width = n3;
        this.height = n4;
        this.isEnabled = true;
        this.itemCount = n5;
        this.itemLabels = new Vector();
        maxScrollRows = 0;
        n2 = stringArray.length;
        while (maxScrollRows < n2) {
            String[] stringArray2 = TextRenderer.splitString(stringArray[maxScrollRows], '-');
            this.itemLabels.addElement(stringArray2);
            ++maxScrollRows;
        }
        this.itemIds = nArray;
        this.iconIds = nArray2;
        this.iconWidth = n6;
        this.iconHeight = n7;
        this.useCustomImages = bl;
        this.hasFocus = true;
        this.layoutMode = 1;
        UIGridMenu UIGridMenu2 = this;
        this.columns = UIGridMenu2.width / (UIGridMenu2.iconWidth + 25);
        UIGridMenu2.rows = UIGridMenu2.itemCount % UIGridMenu2.columns == 0 ? UIGridMenu2.itemCount / UIGridMenu2.columns : UIGridMenu2.itemCount / UIGridMenu2.columns + 1;
        UIGridMenu2.horizontalSpacing = (UIGridMenu2.width - UIGridMenu2.columns * UIGridMenu2.iconWidth) / (UIGridMenu2.columns + 1);
        if (UIGridMenu2.layoutMode == 1) {
            UIGridMenu2.textVerticalOffset = 32;
        } else if (UIGridMenu2.layoutMode == 2) {
            UIGridMenu2.textVerticalOffset = 32;
        }
        UIGridMenu2.itemHeight = UIGridMenu2.textVerticalOffset + UIGridMenu2.iconHeight + 6;
        UIGridMenu2.startX = (UIGridMenu2.width - UIGridMenu2.columns * (UIGridMenu2.iconWidth + UIGridMenu2.horizontalSpacing) >> 1) + (UIGridMenu2.horizontalSpacing >> 1);
        UIGridMenu2.startY = UIGridMenu2.baseY;
        n2 = UIGridMenu2.startY + UIGridMenu2.rows * UIGridMenu2.itemHeight - UIGridMenu2.height;
        UIGridMenu2.maxScrollRows = UIGridMenu2.itemHeight - n2 % UIGridMenu2.itemHeight < 28 ? n2 / UIGridMenu2.itemHeight + 1 : n2 / UIGridMenu2.itemHeight;
        UIGridMenu2.scrollOffsetY = 0;
        UIGridMenu2.selectedCol = 0;
        UIGridMenu2.selectedRow = 0;
    }

    private boolean isSelectedItem(int n, int n2) {
        return n == this.selectedRow && n2 == this.selectedCol;
    }

    private boolean isValidItem(int n, int n2) {
        return n * this.columns + n2 <= this.itemCount - 1;
    }

    public final int getSelectedItemId() {
        return this.itemIds[this.selectedRow * this.columns + this.selectedCol];
    }

    private void drawMenuItem(Graphics graphics, Image image, int n, int n2, boolean bl, int n3) {
        int n4 = this.iconWidth - image.getWidth() >> 1;
        if (bl) {
            String[] stringArray = (String[])this.itemLabels.elementAt(n3);
            UIButton.drawRoundedButton(graphics, n - 10, n2 - 6, this.iconWidth + 20, this.iconHeight + 24 + (stringArray.length > 1 ? TextRenderer.fontHeight - 3 : 0), 8);
        }
        graphics.drawImage(image, n + n4, n2, 20);
    }

    public final boolean handleSoftKey(int n) {
        if (n == 13 || n == 12 || n == 14 || n == 15) {
            this.handleKeyInput(n);
            return false;
        }
        return true;
    }

    public final boolean handleKeyInput(int n) {
        int n2 = 1;
        switch (n) {
            case 14: {
                if (this.selectedCol <= 0) break;
                --this.selectedCol;
                n2 = 0;
                break;
            }
            case 15: {
                if (this.selectedCol >= this.columns - 1 || !this.isValidItem(this.selectedRow, this.selectedCol + 1)) break;
                ++this.selectedCol;
                n2 = 0;
                break;
            }
            case 12: {
                if (this.selectedRow > 0) {
                    --this.selectedRow;
                    if (this.scrollOffsetY < 0) {
                        this.scrollOffsetY += this.itemHeight;
                    }
                } else {
                    this.selectedRow = this.rows - 1;
                    n = this.maxScrollRows;
                    if (!this.isValidItem(this.selectedRow, this.selectedCol)) {
                        --this.selectedRow;
                        --n;
                    }
                    if (this.startY + this.selectedRow * this.itemHeight > Screen.formHeight - Screen.topMargin - 30) {
                        this.scrollOffsetY -= n * this.itemHeight;
                    }
                }
                this.updateBounceEffect();
                n2 = 0;
                if (!thien_ar.a) break;
                thien_ar.a(true);
                break;
            }
            case 13: {
                n = this.selectedCol;
                while (n >= 0) {
                    if (this.selectedRow == this.rows - 1) {
                        this.selectedRow = 0;
                        this.scrollOffsetY = 0;
                        break;
                    }
                    if (this.isValidItem(this.selectedRow + 1, n)) {
                        ++this.selectedRow;
                        this.selectedCol = n;
                        n = Screen.formHeight - Screen.topMargin - 30;
                        n2 = this.rows * this.itemHeight;
                        if (this.startY + this.selectedRow * this.itemHeight <= n || n2 + this.scrollOffsetY <= n) break;
                        this.scrollOffsetY -= this.itemHeight;
                        break;
                    }
                    --n;
                }
                this.updateBounceEffect();
                n2 = 0;
                if (!thien_ar.a) break;
                thien_ar.a(true);
            }
        }
        return n2 != 0;
    }

    private void updateBounceEffect() {
        this.bounceOffset = 0;
        if (this.selectedRow == 0) {
            return;
        }
        int n = (this.selectedRow + 1) * this.itemHeight + this.scrollOffsetY + 5;
        if (this.height - n > 20 && this.selectedRow == this.rows - 1 && this.scrollOffsetY < 0) {
            this.bounceOffset = 30;
            return;
        }
        if (this.height - n < 0) {
            this.bounceOffset = this.height - n;
        }
    }

    public final void draw(Graphics var1) {
      var1.translate(-var1.getTranslateX(), -var1.getTranslateY());

      try {
         Graphics var2 = var1;
         UIGridMenu var15 = this;
         int var3 = 0;
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;

         for (int var7 = 0; var7 < var15.itemCount; var7++) {
            var5 = var7 / var15.columns;
            var6 = var7 % var15.columns;
            var3 = var15.startX + var6 * (var15.iconWidth + var15.horizontalSpacing);
            var4 = var15.startY + var5 * var15.itemHeight + var15.scrollOffsetY + var15.bounceOffset + 5;
            boolean var19 = var15.isSelectedItem(var5, var6);
            if (var4 + var15.iconHeight + 10 > var15.baseY && var4 < Screen.formHeight) {
               if (var15.useCustomImages) {
                  var15.drawMenuItem(var2, var15.images[var7], var3, var4, var19, var7);
               } else {
                  var15.drawMenuItem(var2, ImageCacheManager.getImage(var15.iconIds[var7]), var3, var4, var19, var7);
               }

               String[] var20 = (String[])var15.itemLabels.elementAt(var7);
               var6 = 0;

               for (int var8 = var20.length; var6 < var8; var6++) {
                  String var10002 = var20[var6];
                  int var10003 = var3 - 1;
                  int var13 = var4 + var15.iconHeight + 1;
                  int var12 = var10003;
                  String var11 = var10002;
                  var2.setColor(16777215);
                  TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(var11, var12 + (var15.iconWidth - TextRenderer.computeTextWidth(var11, TextRenderer.charWidth) >> 1), var13, var2);
                  var4 += TextRenderer.fontHeight - 2;
               }
            }
         }
      } catch (Exception var14) {
      }
   }

    public final void handleFocus() {
        if (this.startY + this.rows * this.itemHeight > Screen.formHeight) {
            thien_ar.a = true;
            thien_ar.a(this.rows);
            return;
        }
        thien_ar.a = false;
    }

    public final void drawScrollbar(Graphics graphics) {
        if (thien_ar.a) {
            thien_ar.a(graphics, this.selectedRow);
        }
    }

    public final void onDrag(int n, int n2) {
        this.lastDragY = n2;
    }

    public final void handleKeyPress(int n, int n2) {
        n2 += Screen.headerHeight;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        while (n7 < this.itemCount) {
            n5 = n7 / this.columns;
            n6 = n7 % this.columns;
            n3 = this.startX + n6 * (this.iconWidth + this.horizontalSpacing);
            n4 = this.startY + n5 * this.itemHeight + this.scrollOffsetY + 5;
            if (n > n3 - 4 && n < n3 + this.iconWidth + 4 && n2 > n4 + 14 && n2 < n4 + this.iconHeight + 28) {
                if (this.isSelectedItem(n5, n6)) {
                    this.actionTertiary.actionHandler.action();
                    break;
                }
                this.selectedRow = n5;
                this.selectedCol = n6;
                break;
            }
            ++n7;
        }
        if (thien_ar.a) {
            thien_ar.a(true);
        }
    }

    public final void handlePointerRelease(int n, int n2) {
        n = n2 - this.lastDragY;
        if (BuddyListControl.absoluteValue(n) > 10) {
            if (n > 0) {
                this.scrollOffsetY += n;
                if (this.scrollOffsetY > 0) {
                    this.scrollOffsetY = 0;
                }
            } else {
                this.scrollOffsetY += n;
                if (this.scrollOffsetY < -this.maxScrollRows * this.itemHeight) {
                    this.scrollOffsetY = -this.maxScrollRows * this.itemHeight;
                }
            }
            this.lastDragY = n2;
        }
        if (thien_ar.a) {
            thien_ar.a(true);
        }
    }

    public final void update() {
    }
}
