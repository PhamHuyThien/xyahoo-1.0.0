package home.thienph.xyahoo;

import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class TableListControl
extends UIControlBase {
    public static Image tableImage;
    public static Image playIcon;
    private static Image leftPlayerImage;
    private static Image rightPlayerImage;
    private static Image topPlayerImage;
    private static Image bottomPlayerImage;
    private static int tableWidth;
    private static int tableHeight;
    private static int halfTableHeight;
    private int roomType;
    private int rows;
    private int columns;
    private int selectedRow;
    private int selectedColumn;
    private int horizontalMargin;
    private int startX;
    private int startY;
    private int scrollOffset;
    private int horizontalSpacing;
    private int verticalSpacing;
    private int maxScrollOffset;
    public static TableInfo[] tableList;
    private int totalTables;
    private int lastDragY;

    public TableListControl(int selectedRow, int n2, int n3) {
        this.width = selectedRow;
        this.height = n2;
        this.isEnabled = true;
        this.roomType = n3;
        if (playIcon == null) {
            try {
                playIcon = Image.createImage((String)"/play.png");
                tableImage = Image.createImage((String)"/Table.png");
                topPlayerImage = Image.createImage((String)"/PTop.png");
                bottomPlayerImage = Image.createImage((String)"/PBottom.png");
                leftPlayerImage = Image.createImage((String)"/PLeft.png");
                rightPlayerImage = Image.createImage((String)"/PRight.png");
                tableWidth = tableImage.getWidth();
                tableHeight = tableImage.getHeight();
                halfTableHeight = tableHeight >> 1;
            }
            catch (IOException iOException) {}
        }
        this.actionTertiary = new UIAction("Vào bàn", new thien_az(this));
        this.totalTables = tableList.length;
        this.columns = Screen.e / (tableWidth + 20);
        this.rows = this.totalTables % this.columns == 0 ? this.totalTables / this.columns : this.totalTables / this.columns + 1;
        this.horizontalMargin = (Screen.e - this.columns * 50) / (this.columns + 1);
        this.startX = this.horizontalMargin + 25;
        this.horizontalSpacing = 50 + this.horizontalMargin;
        this.startY = 25;
        this.scrollOffset = 0;
        this.verticalSpacing = tableHeight << 1;
        this.maxScrollOffset = (this.startY + this.rows * this.verticalSpacing + (tableHeight + 15) - n2) / this.verticalSpacing;
        this.selectedColumn = 0;
        this.selectedRow = 0;
        this.handleFocus();
    }

    private boolean isSelectedTable(int n, int n2) {
        return n == this.selectedRow && n2 == this.selectedColumn;
    }

    private boolean isValidTablePosition(int n, int n2) {
        return n * this.columns + n2 <= this.totalTables - 1;
    }

    public final void draw(Graphics graphics) {
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        while (n5 < tableList.length) {
            n3 = n5 / this.columns;
            n4 = n5 % this.columns;
            n = this.startX + n4 * this.horizontalSpacing;
            n2 = this.startY + n3 * this.verticalSpacing + this.scrollOffset;
            if (this.isSelectedTable(n3, n4)) {
                UIButton.a(graphics, n - 35, n2 - 27, tableWidth + 22, tableHeight + 31, 8);
            }
            graphics.drawImage(tableImage, n, n2, 3);
            if (tableList[n5].getPlayerCount() > 0) {
                graphics.drawImage(topPlayerImage, n, n2 - 24, 17);
            }
            if (tableList[n5].getPlayerCount() > 1) {
                graphics.drawImage(bottomPlayerImage, n, n2 + 2, 17);
            }
            if (tableList[n5].getPlayerCount() > 2) {
                graphics.drawImage(leftPlayerImage, n - 32, n2, 6);
            }
            if (tableList[n5].getPlayerCount() > 3) {
                graphics.drawImage(rightPlayerImage, n + 10, n2, 6);
            }
            if (TableListControl.tableList[n5].gameStatus != 1) {
            } else {
                graphics.drawImage(playIcon, n, n2, 3);
            }
            graphics.setColor(0xFFFFFF);
            TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(TableListControl.tableList[n5].tableName, n - 1, n2 + halfTableHeight + 5, 2, graphics, TextRenderer.charWidth, TextRenderer.fontHeight);
            ++n5;
        }
    }

    public final boolean handleKeyInput(int n) {
        boolean bl = true;
        switch (n) {
            case 14: {
                if (this.selectedColumn <= 0) break;
                --this.selectedColumn;
                bl = false;
                break;
            }
            case 15: {
                if (this.selectedColumn >= this.columns - 1 || !this.isValidTablePosition(this.selectedRow, this.selectedColumn + 1)) break;
                ++this.selectedColumn;
                bl = false;
                break;
            }
            case 12: {
                if (this.selectedRow > 0) {
                    --this.selectedRow;
                    if (this.scrollOffset < 0) {
                        this.scrollOffset += this.verticalSpacing;
                    }
                } else {
                    this.selectedRow = this.rows - 1;
                    n = this.maxScrollOffset;
                    if (!this.isValidTablePosition(this.selectedRow, this.selectedColumn)) {
                        --this.selectedRow;
                        --n;
                    }
                    this.scrollOffset -= n * this.verticalSpacing;
                }
                bl = false;
                if (!thien_ar.a) break;
                thien_ar.a(true);
                break;
            }
            case 13: {
                n = this.selectedColumn;
                while (n >= 0) {
                    if (this.selectedRow == this.rows - 1) {
                        this.selectedRow = 0;
                        this.scrollOffset = 0;
                        break;
                    }
                    if (this.isValidTablePosition(this.selectedRow + 1, n)) {
                        ++this.selectedRow;
                        this.selectedColumn = n;
                        n = Screen.formHeight - Screen.topMargin - (tableHeight << 1);
                        if (this.startY + this.selectedRow * this.verticalSpacing <= n) break;
                        this.scrollOffset -= this.verticalSpacing;
                        break;
                    }
                    --n;
                }
                bl = false;
                if (!thien_ar.a) break;
                thien_ar.a(true);
            }
        }
        return bl;
    }

    public final void update() {
    }

    public final boolean handleSoftKey(int n) {
        if (n == 13 || n == 12) {
            this.handleKeyInput(n);
            return false;
        }
        return true;
    }

    public final void handleFocus() {
        thien_ar.a = true;
        thien_ar.a(this.rows);
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
        while (n7 < this.totalTables) {
            n5 = n7 / this.columns;
            n6 = n7 % this.columns;
            n3 = this.startX + n6 * this.horizontalSpacing;
            n4 = this.startY + n5 * this.verticalSpacing + this.scrollOffset;
            if (n > n3 - 25 && n < n3 + tableWidth - 15 && n2 > n4 - 10 && n2 < n4 + tableHeight + 15) {
                if (this.isSelectedTable(n5, n6)) {
                    this.actionTertiary.actionHandler.action();
                    break;
                }
                this.selectedRow = n5;
                this.selectedColumn = n6;
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
        if (UIBuddyListControl.c(n) > 10) {
            if (n > 0) {
                this.scrollOffset += n;
                if (this.scrollOffset > 0) {
                    this.scrollOffset = 0;
                }
            } else {
                this.scrollOffset += n;
                if (this.scrollOffset < -this.maxScrollOffset * this.verticalSpacing) {
                    this.scrollOffset = -this.maxScrollOffset * this.verticalSpacing;
                }
            }
            this.lastDragY = n2;
        }
        if (thien_ar.a) {
            thien_ar.a(true);
        }
    }

    static int getSelectedTableIndex(TableListControl tableListControl2) {
        return tableListControl2.selectedRow * tableListControl2.columns + tableListControl2.selectedColumn;
    }

    static int getRoomType(TableListControl tableListControl2) {
        return tableListControl2.roomType;
    }
}
