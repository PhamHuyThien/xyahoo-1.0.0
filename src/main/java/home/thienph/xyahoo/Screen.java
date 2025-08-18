package home.thienph.xyahoo;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public class Screen {
    public boolean isVisible;
    public static int topMargin;
    public static int leftMargin;
    public static int headerHeight;
    public static int e;
    public static int formHeight;
    public String title;
    public String subtitle = "";
    public String wrappedText = "";
    public Vector controls = new Vector();
    public UIAction leftCommand;
    public UIAction rightCommand;
    public UIAction centerCommand;
    private int selectedIndex = -1;
    public boolean isSliding;
    public int slideOffset;
    private int slideSpeed;
    public boolean isLocked;
    public int scrollTargetY;
    public int scrollY;
    private int scrollVelocity;
    private int scrollDelta;
    public int padding;
    public boolean isScrolling = false;
    private int controlCount;
    public boolean scrollLock = false;
    private String leftLabel = "";
    private String rightLabel = "";
    private String centerLabel = "";
    private String defaultLabel = "";
    public static int footerY;
    private static int keyHoldCounter;
    private boolean isDragging;
    private int lastTouchY;
    private int maxScrollY;

    static {
        keyHoldCounter = 0;
    }

    public final void startSlide(int n) {
        this.isSliding = true;
        if (n == -1) {
            this.slideOffset = e;
            this.slideSpeed = -e >> 2;
            return;
        }
        this.slideOffset = -e;
        this.slideSpeed = e >> 2;
    }

    public final void wrapTitle(int n) {
        this.wrappedText = thien_w.a(this.title, n, thien_w.j);
    }

    public final void setWrappedText(String string) {
        this.wrappedText = thien_w.a(string, GameCanvas.screenWidth - 30, thien_w.j);
    }

    public void draw(Graphics graphics) {
        this.drawBackground(graphics);
        Graphics graphics2 = graphics;
        Screen screen2 = this;
        int n = 0;
        while (n < screen2.controlCount) {
            graphics2.setClip(0, headerHeight, e, formHeight - topMargin);
            graphics2.translate(0, -screen2.scrollY);
            graphics2.translate(0, headerHeight);
            UIControlBase UIControlBase2 = (UIControlBase) screen2.controls.elementAt(n);
            if (UIControlBase2.baseY - screen2.scrollY + UIControlBase2.height > 0 && UIControlBase2.baseY - screen2.scrollY < formHeight - topMargin - 10) {
                UIControlBase2.draw(graphics2);
            }
            if (n == screen2.selectedIndex) {
                UIControlBase2.drawBackground(graphics2);
            }
            graphics2.translate(0, -headerHeight);
            graphics2.translate(0, screen2.scrollY);
            ++n;
        }
        graphics2.translate(-graphics2.getTranslateX(), -graphics2.getTranslateY());
        graphics.setClip(0, 0, 1000, 1000);
        this.drawOverlay(graphics);
        graphics2 = graphics;
        screen2 = this;
        graphics2.setClip(0, 0, 1000, 1000);
        Screen.drawFooter(graphics2);
        screen2.leftLabel = screen2.defaultLabel;
        screen2.rightLabel = screen2.defaultLabel;
        screen2.centerLabel = screen2.defaultLabel;
        if (screen2.leftCommand != null) {
            screen2.leftLabel = screen2.leftCommand.label;
        }
        if (screen2.rightCommand != null) {
            screen2.rightLabel = screen2.rightCommand.label;
        }
        if (screen2.centerCommand != null) {
            screen2.centerLabel = screen2.centerCommand.label;
        }
        if (screen2.selectedIndex != -1) {
            UIControlBase UIControlBase3 = (UIControlBase) screen2.controls.elementAt(screen2.selectedIndex);
            if (UIControlBase3.actionPrimary != null) {
                screen2.leftLabel = UIControlBase3.actionPrimary.label;
            }
            if (UIControlBase3.actionSecondary != null) {
                screen2.rightLabel = UIControlBase3.actionSecondary.label;
            }
            if (UIControlBase3.actionTertiary != null) {
                screen2.centerLabel = UIControlBase3.actionTertiary.label;
            }
        }
        graphics2.setColor(0xFFFFFF);
        thien_w.a(thien_w.d).a(screen2.leftLabel, 4, footerY, graphics2);
        thien_w.a(thien_w.d).a(screen2.rightLabel, 0 + e - 4, footerY, 1, graphics2, thien_w.j, thien_w.f);
        thien_w.a(thien_w.d).a(screen2.centerLabel, 0 + (e >> 1), footerY, 2, graphics2, thien_w.j, thien_w.f);
    }

    public void drawBackground(Graphics graphics) {
    }

    public void addControl(UIControlBase UIControlBase2) {
        if (this.controls.contains(UIControlBase2)) {
            return;
        }
        UIControlBase2.parentScreen = this;
        this.controls.addElement(UIControlBase2);
    }

    public void removeControl(UIControlBase UIControlBase2) {
        this.controls.removeElement(UIControlBase2);
        this.controlCount = this.controls.size();
    }

    public void clearControls() {
        this.controls.removeAllElements();
    }

    public final boolean selectControl(UIControlBase UIControlBase2) {
        this.controlCount = this.controls.size();
        int n = 0;
        while (n < this.controlCount) {
            UIControlBase UIControlBase3 = (UIControlBase)this.controls.elementAt(n);
            if (UIControlBase2.equals(UIControlBase3) && UIControlBase2.isVisible) {
                this.selectedIndex = n;
                this.adjustScrollToSelection();
                return true;
            }
            ++n;
        }
        return false;
    }

    protected final void adjustScrollToSelection() {
        UIControlBase UIControlBase2 = (UIControlBase)this.controls.elementAt(this.selectedIndex);
        int n = UIControlBase2.baseY + headerHeight;
        if (n - headerHeight < this.scrollTargetY + 20 && this.selectedIndex != 0) {
            n = this.selectedIndex - 1;
            while (n >= 0) {
                UIControlBase UIControlBase3 = (UIControlBase)this.controls.elementAt(n);
                if (!UIControlBase3.isVisible) {
                    UIControlBase2 = UIControlBase3;
                    break;
                }
                --n;
            }
            n = UIControlBase2.baseY + headerHeight;
            this.scrollTargetY = n - headerHeight - 15;
            return;
        }
        if (n + UIControlBase2.height > this.scrollTargetY + formHeight + 1 && !this.scrollLock) {
            this.scrollTargetY = n + UIControlBase2.height - formHeight + 15;
            return;
        }
        if (UIControlBase2.baseY < this.scrollY) {
            this.scrollTargetY = UIControlBase2.baseY - 2;
        }
    }

    public final boolean isSelectedControl(UIControlBase UIControlBase2) {
        try {
            UIControlBase UIControlBase3 = (UIControlBase)this.controls.elementAt(this.selectedIndex);
            if (UIControlBase3.equals(UIControlBase2)) {
                return true;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return false;
    }

    public final void updateSlideAnimation() {
        if (this.isSliding) {
            this.slideOffset += this.slideSpeed;
            if (this.slideOffset < 10 && this.slideOffset > -10) {
                this.isSliding = false;
            }
        }
    }

    public boolean handleInput(boolean[] var1, boolean[] var2, int[] var3) {
      boolean var4 = false;
      this.controlCount = this.controls.size();
      if (this.selectedIndex != -1) {
         if (this.scrollY != this.scrollTargetY) {
            this.scrollDelta = this.scrollTargetY - this.scrollY << 2;
            this.scrollVelocity = this.scrollVelocity + this.scrollDelta;
            this.scrollY = this.scrollY + (this.scrollVelocity >> 4);
            this.scrollVelocity &= 15;
         }

         this.scrollY = this.scrollTargetY;
      }

      if (this.selectedIndex != -1) {
         if (var3[0] > 0) {
            ((UIControlBase)this.controls.elementAt(this.selectedIndex)).handleKeyInput(var3[0]);
            var3[0] = 0;

            for (int var8 = 0; var8 < var1.length; var8++) {
               var1[var8] = false;
            }

            return false;
         }

         for (int var6 = 0; var6 < 21; var6++) {
            if (var2[var6] && ++keyHoldCounter > 4) {
               if (((UIControlBase)this.controls.elementAt(this.selectedIndex)).handleSoftKey(var6)) {
                  if (var6 == 12) {
                     int var15 = this.selectedIndex;

                     do {
                        if (--var15 == -1) {
                           var15 = this.controlCount - 1;
                        }
                     } while (!((UIControlBase)this.controls.elementAt(var15)).isVisible);

                     this.selectedIndex = var15;
                  } else if (var6 == 13) {
                     int var14 = this.selectedIndex;

                     do {
                        if (++var14 == this.controlCount) {
                           var14 = 0;
                        }
                     } while (!((UIControlBase)this.controls.elementAt(var14)).isVisible);

                     this.selectedIndex = var14;
                  }

                  this.adjustScrollToSelection();
                  var2[var6] = false;
                  if (thien_ar.a) {
                     thien_ar.a(true);
                  }
               }

               keyHoldCounter = 4;
            } else if (var1[var6]) {
               if (((UIControlBase)this.controls.elementAt(this.selectedIndex)).handleKeyInput(var6)) {
                  if (var6 == 12) {
                     int var13 = this.selectedIndex;

                     do {
                        if (--var13 == -1) {
                           var13 = this.controlCount - 1;
                        }
                     } while (!((UIControlBase)this.controls.elementAt(var13)).isVisible);

                     this.selectedIndex = var13;
                     this.adjustScrollToSelection();
                     if (thien_ar.a) {
                        thien_ar.a(true);
                     }
                  } else if (var6 == 13) {
                     int var12 = this.selectedIndex;

                     do {
                        if (++var12 == this.controlCount) {
                           var12 = 0;
                        }
                     } while (!((UIControlBase)this.controls.elementAt(var12)).isVisible);

                     this.selectedIndex = var12;
                     this.adjustScrollToSelection();
                     if (thien_ar.a) {
                        thien_ar.a(true);
                     }
                  } else {
                     IAction var5 = null;
                     if (var6 == 17) {
                        if (this.leftCommand != null) {
                           var5 = this.leftCommand.actionHandler;
                        }

                        UIControlBase var9;
                        if (this.selectedIndex != -1 && (var9 = (UIControlBase)this.controls.elementAt(this.selectedIndex)).actionPrimary != null) {
                           var5 = var9.actionPrimary.actionHandler;
                        }
                     } else if (var6 == 18) {
                        if (this.rightCommand != null) {
                           var5 = this.rightCommand.actionHandler;
                        }

                        UIControlBase var10;
                        if (this.selectedIndex != -1 && (var10 = (UIControlBase)this.controls.elementAt(this.selectedIndex)).actionSecondary != null) {
                           var5 = var10.actionSecondary.actionHandler;
                        }
                     } else if (var6 == 16) {
                        if (this.centerCommand != null) {
                           var5 = this.centerCommand.actionHandler;
                        }

                        UIControlBase var11;
                        if (this.selectedIndex != -1 && (var11 = (UIControlBase)this.controls.elementAt(this.selectedIndex)).actionTertiary != null) {
                           var5 = var11.actionTertiary.actionHandler;
                        }
                     }

                     if (var5 != null) {
                        var5.action();
                     }
                  }

                  var4 = true;
               } else {
                  var4 = false;
               }

               var1[var6] = false;
            }
         }
      }

      int var7 = this.controlCount;

      while (--var7 >= 0) {
         ((UIControlBase)this.controls.elementAt(var7)).update();
      }

      return var4;
   }

    public final void onTouchPress(int n, int n2) {
        if (this.isDragging && !this.isLocked) {
            this.isDragging = false;
            this.scrollTargetY -= (n2 - this.lastTouchY) * 5;
        }
        int n3 = this.controls.size();
        block0: while (--n3 >= 0) {
            UIControlBase UIControlBase2 = (UIControlBase)this.controls.elementAt(n3);
            int n4 = 0;
            int n5 = 0;
            while (n5 < 2) {
                if (n > UIControlBase2.baseX && n2 + this.scrollY + n4 > UIControlBase2.baseY && n < UIControlBase2.baseX + UIControlBase2.width && n2 + this.scrollY + n4 < UIControlBase2.baseY + UIControlBase2.height) {
                    UIControlBase2.handleKeyPress(n - UIControlBase2.baseX, n2 + this.scrollY - UIControlBase2.baseY);
                    return;
                }
                if (!(UIControlBase2 instanceof TextField)) continue block0;
                n4 -= UIControlBase2.height;
                ++n5;
            }
        }
        if (thien_ar.a) {
            thien_ar.a(true);
        }
    }

    public final void onTouchDrag(int n, int n2) {
        int n3 = this.controls.size();
        while (--n3 >= 0) {
            UIControlBase UIControlBase2 = (UIControlBase)this.controls.elementAt(n3);
            if (n <= UIControlBase2.baseX || n2 + this.scrollY <= UIControlBase2.baseY || n >= UIControlBase2.baseX + UIControlBase2.width || n2 + this.scrollY >= UIControlBase2.baseY + UIControlBase2.height || !UIControlBase2.isEnabled) continue;
            UIControlBase2.handlePointerRelease(n - UIControlBase2.baseX, n2 + this.scrollY - UIControlBase2.baseY);
            return;
        }
        if (!this.isLocked && thien_b.c(n2 - this.lastTouchY) > 1) {
            this.isDragging = true;
            this.scrollTargetY -= n2 - this.lastTouchY;
            if (this.scrollTargetY < 0) {
                this.scrollTargetY = 0;
            } else if (this.scrollTargetY > this.maxScrollY) {
                this.scrollTargetY = this.maxScrollY;
            }
            this.scrollY = this.scrollTargetY;
            this.lastTouchY = n2;
        }
        if (thien_ar.a) {
            thien_ar.a(true);
        }
    }

    public final void onTouchRelease(int n, int n2) {
        int n3 = this.controls.size();
        while (--n3 >= 0) {
            UIControlBase UIControlBase2 = (UIControlBase)this.controls.elementAt(n3);
            if (n <= UIControlBase2.baseX || n2 + this.scrollY <= UIControlBase2.baseY || n >= UIControlBase2.baseX + UIControlBase2.width || n2 + this.scrollY >= UIControlBase2.baseY + UIControlBase2.height || !UIControlBase2.isEnabled) continue;
            UIControlBase2.onDrag(n - UIControlBase2.baseX, n2 + this.scrollY - UIControlBase2.baseY);
            return;
        }
        if (!this.isLocked) {
            this.lastTouchY = n2;
        }
    }

    public final void onTouchMove(int n, int n2) {
        if (!this.isLocked) {
            this.lastTouchY = n2;
        }
    }

    public static void drawFooter(Graphics graphics) {
        if (thien_w.a) {
            graphics.drawImage(thien_di.v, 0, formHeight + 2, 20);
            return;
        }
        int n = formHeight + 3;
        int n2 = topMargin >> 1;
        graphics.setColor(1404853);
        graphics.fillRect(0, n, e, n2);
        graphics.setColor(1334695);
        graphics.fillRect(0, n + n2, e, ++n2);
        graphics.setColor(672643);
        graphics.fillRect(0, n, e, 1);
        graphics.setColor(6796786);
        graphics.fillRect(0, ++n, e, 1);
    }

    public UIControlBase getControlById(int n) {
        int n2 = this.controls.size();
        while (--n2 >= 0) {
            UIControlBase UIControlBase2 = (UIControlBase)this.controls.elementAt(n2);
            if (UIControlBase2.zIndex != n) continue;
            return UIControlBase2;
        }
        return null;
    }

    public void updateLayout() {
        this.controlCount = this.controls.size();
        if (this.controlCount == 1 && ((UIControlBase)this.controls.elementAt((int)0)).hasFocus) {
            ((UIControlBase)this.controls.elementAt(0)).handleFocus();
            return;
        }
        int n = headerHeight;
        int n2 = 0;
        int n3 = this.controlCount;
        while (n2 < n3) {
            n += ((UIControlBase)this.controls.elementAt((int)n2)).height + 2;
            ++n2;
        }
        if (n >= formHeight) {
            thien_ar.a = true;
            thien_ar.a(this.controlCount);
            this.maxScrollY = n - formHeight;
            return;
        }
        thien_ar.a = false;
    }

    public void drawOverlay(Graphics graphics) {
        if (this.controlCount == 1 && ((UIControlBase)this.controls.elementAt((int)0)).hasFocus) {
            ((UIControlBase)this.controls.elementAt(0)).drawScrollbar(graphics);
            return;
        }
        if (thien_ar.a) {
            thien_ar.a(graphics, this.selectedIndex);
        }
    }
}
