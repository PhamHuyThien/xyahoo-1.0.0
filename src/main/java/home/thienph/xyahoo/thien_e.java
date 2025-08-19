package home.thienph.xyahoo;

import java.util.Date;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class thien_e extends UIControlBase {
   private int a;
   private int b;
   private int c;
   private int d;
   private int e;
   private Vector f;
   private int g;
   private int h;
   private int i = -1;
   private int j;
   private int k;
   private int l;
   private Integer m;
   private int n;
   private boolean B;
   private int C;
   private int D;

   static {
      new Date();
   }

   public final boolean a() {
      return this.d > this.e - 20;
   }

   public thien_e(int var1, int var2, int var3, int var4) {
      super(1, 1, var3, var4, true);
      super.isEnabled = true;
      super.isVisible = false;
      this.g = var4 / TextRenderer.lineSpacing + 2;
      this.f = new Vector();
      super.actionTertiary = new UIAction("Chat", null);
   }

   public final void a(String var1, int var2) {
      int var3;
      while ((var3 = var1.indexOf("http://")) > 0 || (var3 = var1.indexOf("vtp://")) > 0) {
         this.a(var1.substring(0, var3), var2);
         if ((var3 = (var1 = var1.substring(var3)).indexOf(" ")) == -1) {
            break;
         }

         this.a(var1.substring(0, var3), var2);
         var1 = var1.substring(var3);
      }

      if (!var1.startsWith("http://") && !var1.startsWith("vtp://")) {
         String[] var8 = TextRenderer.splitText(var1, super.width - 100, TextRenderer.charWidth);
         this.j = var8.length;

         for (int var5 = 0; var5 < this.j; var5++) {
            var8[var5] = (char)(var2 + 31000) + var8[var5];
         }

         for (int var6 = 0; var6 < this.j; var6++) {
            this.f.addElement(var8[var6]);
         }

         this.l = this.f.size();
         this.e = (this.l - this.g + 2) * TextRenderer.lineSpacing + 8;
         this.handleFocus();
      } else {
         var1 = '祼' + var1;
         this.f.addElement(var1);
         this.l = this.f.size();
      }
   }

   public final void a(String var1, String var2, int var3) {
      if ((var2 = thien_fe.b(var2)).startsWith("http")) {
         this.a(var1, TextConstant.clickHere(), var3);
         var2 = '祼' + var2;
         this.f.addElement(var2);
         this.l = this.f.size();
      } else {
         var2 = TextRenderer.replaceEmoticons(var2, true);
         String[] var4 = TextRenderer.splitText((char)(var3 + 31000) + var1 + ": 紀" + var2, super.width - 8, TextRenderer.charWidth);
         this.j = var4.length;

         for (int var7 = 0; var7 < this.j; var7++) {
            this.f.addElement(var4[var7]);
         }

         this.l = this.f.size();
         this.e = (this.l - this.g + 2) * TextRenderer.lineSpacing + 8;
         this.handleFocus();
      }
   }

   public final boolean handleKeyInput(int var1) {
      if (var1 == 12) {
         if (this.i > 0) {
            this.i--;
         }

         this.a = this.a - TextRenderer.lineSpacing;
         if (this.a < -TextRenderer.lineSpacing) {
            this.a = -TextRenderer.lineSpacing;
         }

         if (thien_ar.a) {
            thien_ar.a(true);
         }
      } else if (var1 == 13) {
         if (this.i < this.l - 1) {
            this.i++;
         }

         this.a = this.a + TextRenderer.lineSpacing;
         if (this.a > this.e) {
            this.a = this.e;
         }

         if (thien_ar.a) {
            thien_ar.a(true);
         }
      }

      return true;
   }

   public final boolean handleSoftKey(int var1) {
      this.handleKeyInput(var1);
      return true;
   }

   public final void draw(Graphics var1) {
      var1.setClip(super.baseX, super.baseY + 33, super.width, super.height);
      var1.translate(0, 6);
      var1.translate(0, -this.d);
      if (this.i != -1) {
         int var4 = super.width - 3;
         this.m = TextRenderer.colorWhite;
         this.n = 16777215;
         var1.setColor(2580);
         var1.fillRoundRect(3, this.i * TextRenderer.lineSpacing + 34, var4, TextRenderer.lineSpacing, 5, 5);
      }

      this.j = this.h + this.g;

      for (int var12 = this.h - 1; var12 < this.j; var12++) {
         if (var12 >= 0) {
            try {
               if (var12 >= this.l) {
                  break;
               }

               String var5 = (String)this.f.elementAt(var12);
               byte var6 = 0;
               this.n = 16777215;
               this.m = TextRenderer.colorWhite;
               int var2 = 0;
               if (var5.charAt(0) >= 31000) {
                  if ((var2 = var5.charAt(0) - 31000) == 0 || var2 == 100) {
                     this.m = TextRenderer.colorHighlight;
                     this.n = 3981823;
                  } else if (var2 == 1) {
                     this.m = TextRenderer.colorPrimary;
                     this.n = 16726823;
                  } else if (var2 == 2) {
                     this.m = TextRenderer.colorWhite;
                     this.n = 16777215;
                  }

                  var6 = 1;
               }

               int var3 = 8;
               String var10 = "";
               this.k = var5.length();

               for (int var13 = var6; var13 < this.k; var13++) {
                  char var7;
                  if ((var7 = var5.charAt(var13)) == 32000) {
                     var1.setColor(this.n);
                     TextRenderer.getFontRenderer(this.m).drawText(var10, var3, var12 * TextRenderer.lineSpacing + 34, var1);
                     var3 += TextRenderer.computeTextWidth(var10, TextRenderer.charWidth);
                     var10 = "";
                     this.n = 16777215;
                     this.m = TextRenderer.colorWhite;
                  } else if (var7 >= 30000) {
                     var1.setColor(((Integer)this.m).intValue());
                     TextRenderer.getFontRenderer(this.m).drawText(var10, var3, var12 * TextRenderer.lineSpacing + 34, var1);
                     var3 += TextRenderer.computeTextWidth(var10, TextRenderer.charWidth);
                     var10 = "";
                     var7 -= 30000;
                     var1.drawRegion(GameManager.iconChats, var7 * 18, 0, 18, 18, 0, var3 + 10, var12 * TextRenderer.lineSpacing + (TextRenderer.lineSpacing >> 1) + 34, 3);
                     var3 += 20;
                  } else {
                     var10 = var10 + var7;
                  }
               }

               var1.setColor(this.n);
               TextRenderer.getFontRenderer(this.m).drawText(var10, var3, var12 * TextRenderer.lineSpacing + 34, var1);
            } catch (Exception var8) {
            }
         }
      }

      var1.translate(0, this.d);
      var1.translate(0, -6);
      var1.translate(-var1.getTranslateX(), -var1.getTranslateY());
      var1.setClip(-1000, -1000, 2000, 2000);
   }

   public final void update() {
      if (this.d != this.a) {
         this.b = this.a - this.d << 2;
         this.c = this.c + this.b;
         this.d = this.d + (this.c >> 3);
         this.c &= 15;
         if (this.d > this.e) {
            this.d = this.e;
         }

         if (this.d < 0) {
            this.d = 0;
         }

         this.h = this.d / TextRenderer.lineSpacing - 1;
         if (this.h < 0) {
            this.h = 0;
         }
      }
   }

   public final void handleFocus() {
      if (super.baseY + this.f.size() * (TextRenderer.lineSpacing + 2) >= super.height) {
         thien_ar.a = true;
         thien_ar.a(this.f.size());
      } else {
         thien_ar.a = false;
      }
   }

   public final void drawScrollbar(Graphics var1) {
      if (thien_ar.a) {
         thien_ar.a(var1, this.i);
      }
   }

   public final void onDrag(int var1, int var2) {
      this.C = var1;
      this.D = var2;
   }

   public final void handleKeyPress(int var1, int var2) {
      if (this.B) {
         this.B = false;
         this.a = this.a - (var2 - this.D << 3);
         if (this.a < 0) {
            this.a = 0;
         } else if (this.a > this.e) {
            this.a = this.e;
         }
      }

      if (thien_ar.a) {
         thien_ar.a(true);
      }
   }

   public final void handlePointerRelease(int var1, int var2) {
      if (UIBuddyListControl.c(var1 - this.C) > 1 || UIBuddyListControl.c(var2 - this.D) > 1) {
         this.B = true;
         this.a = this.a - (var2 - this.D);
         if (this.a < 0) {
            this.a = 0;
         } else if (this.a > this.e) {
            this.a = this.e;
         }

         this.d = this.a;
         this.h = this.d / TextRenderer.lineSpacing - 1;
         if (this.h < 0) {
            this.h = 0;
         }

         this.C = var1;
         this.D = var2;
      }

      if (thien_ar.a) {
         thien_ar.a(true);
      }
   }

   public final void drawBackground(Graphics var1) {
   }

   public final void b() {
      this.h = this.l - this.g;
      this.i = this.l - 1;
      this.a = this.e;
   }

   public final String c() {
      return this.i == -1 ? "" : (String)this.f.elementAt(this.i);
   }

   public final String d() {
      if (this.i == -1) {
         return "";
      } else {
         int var1 = this.i;
         int var2 = this.i;

         for (var1 = var1; ((String)this.f.elementAt(var2)).charAt(0) < 31000; var2--) {
            if (var2 <= 0) {
               var2 = 0;
               break;
            }
         }

         while (true) {
            if (((String)this.f.elementAt(var1)).charAt(0) >= 31000) {
               if (--var1 < 0) {
                  var1 = 0;
               }
               break;
            }

            if (var1 >= this.f.size() - 1) {
               var1 = this.f.size() - 1;
               break;
            }

            var1++;
         }

         if (var1 < var2) {
            var1 = var2;
         }

         String var3 = "";

         for (int var7 = var2; var7 <= var1; var7++) {
            var3 = var3 + (String)this.f.elementAt(var7) + " ";
         }

         for (int var8 = 0; var8 < var3.length(); var8++) {
            if (var3.charAt(var8) == 32000) {
               var3 = var3.substring(var8 + 1);
            }
         }

         try {
            for (int var9 = 0; var9 < var3.length(); var9++) {
               if (var3.charAt(var9) >= 30000) {
                  var3 = var3.substring(0, var9) + TextRenderer.emoticons[var3.charAt(var9) - 30000] + var3.substring(var9 + 1);
               }
            }
         } catch (Exception var4) {
         }

         return var3;
      }
   }
}
