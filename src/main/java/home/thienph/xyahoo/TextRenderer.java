package home.thienph.xyahoo;

import java.util.Hashtable;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class TextRenderer {
   public static boolean useCustomFont = true;
   private static Hashtable fontCache;
   public static Integer colorPrimary = new Integer(16726823);
   public static Integer colorSecondary = new Integer(0);
   public static Integer colorWhite = new Integer(16777215);
   public static Integer colorHighlight = new Integer(3981823);
   public static int fontHeight;
   public static String[] emoticons;
   private static int emoticonCount = (
      emoticons = new String[]{
         ":-BD",
         ":D",
         ">:)",
         "X-(",
         ":((",
         ":))",
         "B-)",
         ":\">",
         ";;)",
         ":-SS",
         ":-*",
         ":-W",
         ":-?",
         ";))",
         "~X(",
         ":-H",
         ":)",
         ":-/",
         ":@)",
         "3:-O",
         ":(|)",
         "~:>",
         "@};-",
         "~O)",
         ":|",
         ":-O",
         ":(",
         ";)",
         ":X",
         ":>",
         ":P",
         "=P~",
         "=((",
         "B-(",
         ":-\"",
         ":-&",
         ":-S",
         "O:-)",
         "#-O",
         "I-)",
         "8-X",
         "(*)"
      }
   ).length;
   public static int lineSpacing;
   public static int extraSpacing;
   private Image fontImage;
   public static byte[] charWidth = new byte[]{
      3,
      7,
      5,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      3,
      3,
      3,
      3,
      7,
      4,
      4,
      7,
      4,
      5,
      4,
      7,
      6,
      9,
      9,
      8,
      7,
      4,
      4,
      3,
      3,
      7,
      9,
      12,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      6,
      7,
      7,
      3,
      4,
      7,
      3,
      11,
      7,
      7,
      7,
      7,
      5,
      7,
      5,
      7,
      8,
      10,
      7,
      8,
      6,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      4,
      4,
      4,
      5,
      3,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      7,
      9,
      9,
      9,
      9,
      9,
      9,
      7,
      7,
      7,
      7,
      7,
      9,
      9,
      9,
      9,
      9,
      9,
      8,
      8,
      8,
      8,
      8,
      8,
      8,
      8,
      8,
      8,
      7,
      6,
      8,
      8,
      3,
      7,
      8,
      7,
      10,
      8,
      9,
      8,
      9,
      8,
      8,
      7,
      8,
      10,
      14,
      8,
      9,
      7
   };
   private static String allChars = " 0123456789.':!?()+-*/#$%Đ_=[];,^&@><abcdefghijklmnopqrstuvwxyzáàảãạăắằẳẵặâấầẩẫậéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđABCDEFGHIJKLMNOPQRSTUVWXYZÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẪẬÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴ|\"/";
   private static String charMap = " 0123456789.':!?()+-*/#$%Đ_=[];,^&@><abcdefghijklmnopqrstuvwxyzáàảãạăắằẳẵặâấầẩẫậéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđABCDEFGHIJKLMNOPQRSTUVWXYZAAAAAAAAAAAAAAAAAEEEEEEEEEEEIIIIIOOOOOOOOOOOOOOOOOUUUUUUUUUUUYYYYY '";
   private static TextRenderer instance;
   private static int charIndex;
   private int lineWidthCache;

   public static String truncate(String var0, int var1) {
      return var0.length() > var1 ? var0.substring(0, var1) + ".." : var0;
   }

   public static int findEmoticonIndex(String var0) {
      for (int var1 = 0; var1 < emoticonCount; var1++) {
         if (var0.toUpperCase().indexOf(emoticons[var1]) != -1) {
            return var1;
         }
      }

      return 100;
   }

   public static String replaceEmoticons(String var0, boolean var1) {
      int var2 = 0;
      int var4 = 10;

      for (int var5 = 0; var5 < emoticonCount; var5++) {
         int var3;
         while ((var3 = var0.toUpperCase().indexOf(emoticons[var5])) != -1) {
            var2 = var5 + 30000;
            var0 = var0.substring(0, var3) + (char)var2 + var0.substring(var3 + emoticons[var5].length());
            if (--var4 <= 0) {
               break;
            }
         }

         if (var4 <= 0) {
            break;
         }
      }

      return var4 == 10 && !var1 ? null : var0;
   }

   public static void initFont() {
      try {
         Image.createImage("/Numbers.png");
      } catch (Exception var0) {
      }

      if (useCustomFont) {
         fontHeight = 14;
         fontCache = new Hashtable();
         getFontRenderer(colorPrimary);
         getFontRenderer(colorSecondary);
         getFontRenderer(colorWhite);
      } else {
         fontHeight = thien_aq.a();
      }

      lineSpacing = fontHeight + 2;
      extraSpacing = fontHeight + 6;
   }

   private TextRenderer(String var1, int var2) {
      if (useCustomFont) {
         try {
            if (this.fontImage == null) {
               this.fontImage = Image.createImage(var1);
            }

            if (var2 != 16777215) {
               this.fontImage = createImage(this.fontImage, var2);
               return;
            }
         } catch (Exception var3) {
         }
      }
   }

   public static TextRenderer getFontRenderer(Integer var0) {
      if (!useCustomFont) {
         return instance != null ? instance : (instance = new TextRenderer(null, 0));
      } else {
         TextRenderer var1;
         if ((var1 = (TextRenderer) fontCache.get(var0)) != null) {
            return var1;
         } else {
            if (fontCache.size() < 10) {
               fontCache.put(var0, new TextRenderer("/Font.png", var0.intValue()));
            }

            return (TextRenderer) fontCache.get(colorWhite);
         }
      }
   }

   public static int computeTextWidth(String var0, byte[] var1) {
      return useCustomFont ? computeTextWidth(var0, 0, var0.length(), var1) : thien_aq.a(var0);
   }

   private static int computeTextWidth(String var0, int var1, int var2, byte[] var3) {
      byte var4 = 0;
      var2 = var1 + var2;
      if (var1 != 0 && var2 > var0.length()) {
         var2 = var0.length();
      }

      char var5;
      for (int var6 = var1; var6 < var2 && (var5 = var0.charAt(var6)) != '\n'; var6++) {
         var4 += var3[mapChar(var5)];
      }

      return var4;
   }

   public final void drawText(String var1, int var2, int var3, Graphics var4) {
      if (!useCustomFont) {
         thien_aq.a(var4, var1, var2, var3, 0);
      } else {
         int var5 = var2;
         var3 = var3;
         int var7 = var1.length();

         for (int var8 = 0; var8 < var7; var8++) {
            char var6;
            if ((var6 = var1.charAt(var8)) == 10) {
               var5 = var2;
               var3 += fontHeight;
            } else if ((var6 = (char) mapChar((char)var6)) >= 0) {
               var4.drawRegion(this.fontImage, 0, var6 * fontHeight, 15, fontHeight, 0, var5, var3, 0);
               var5 += charWidth[var6];
            }
         }
      }
   }

   public final void drawText(String var1, int var2, int var3, int var4, Graphics var5, byte[] var6, int var7) {
      if (!useCustomFont) {
         thien_aq.a(var5, var1, var2, var3, var4 == 1 ? 2 : 1);
      } else {
         int var8 = var2;
         var3 = var3;
         int var10 = var1.length();
         if (var4 != 0) {
            this.lineWidthCache = computeTextWidth(var1, 0, var10, var6);
            if (var4 == 1) {
               var8 = var2 - this.lineWidthCache;
            } else {
               var8 = var2 - (this.lineWidthCache >> 1);
            }
         }

         for (int var11 = 0; var11 < var10; var11++) {
            char var9;
            if ((var9 = var1.charAt(var11)) == 10) {
               if (var4 == 0) {
                  var8 = var2;
               } else {
                  this.lineWidthCache = computeTextWidth(var1, var11 + 1, this.lineWidthCache - var11 - 1, var6);
                  if (var4 == 1) {
                     var8 = var2 - this.lineWidthCache;
                  } else {
                     var8 = var2 - (this.lineWidthCache >> 1);
                  }
               }

               var3 += var7;
            } else if ((var9 = (char) mapChar((char)var9)) >= 0) {
               var5.drawRegion(this.fontImage, 0, var9 * var7, 15, var7, 0, var8, var3, 0);
               var8 += var6[var9];
            }
         }
      }
   }

   private static int mapChar(char var0) {
      int var1;
      if ((var1 = charMap.indexOf(var0)) != -1) {
         return var1;
      } else {
         return (var1 = charMap.indexOf((charIndex = allChars.indexOf(var0)) != -1 ? charMap.charAt(charIndex) : 32)) != -1 ? var1 : 0;
      }
   }

   public static String wrapText(String var0, int var1, byte[] var2) {
      if (var0.length() == 0) {
         return "...";
      } else {
         Vector var3 = new Vector();
         int var4 = 0;
         int var5 = 0;
         byte var6 = 0;
         int var7 = -1;

         while (var4 < var0.length()) {
            char var8;
            if ((var8 = var0.charAt(var4)) == ' ') {
               var7 = var4;
            }

            if ((var6 += var2[mapChar(var8)]) <= var1 && var8 != '\n') {
               var4++;
            } else {
               if (var8 != '\n' && var7 != -1) {
                  var4 = var7;
               }

               var3.addElement(var0.substring(var5, var4));
               if (var0.charAt(var4) == ' ' || var8 == '\n') {
                  var4++;
               }

               var5 = var4;
               var6 = 0;
               var7 = -1;
            }
         }

         if (var4 > var5) {
            var3.addElement(var0.substring(var5, var4));
         }

         String[] var10 = new String[var3.size()];

         for (int var11 = 0; var11 < var10.length; var11++) {
            var10[var11] = (String)var3.elementAt(var11);
         }

         return var10[0];
      }
   }

   private static Image createImage(Image var0, int var1) {
      int[] var2 = new int[var0.getWidth() * var0.getHeight()];
      Image var4 = Image.createRGBImage(new int[]{var1}, 1, 1, false);
      int[] var3 = new int[1];
      var4.getRGB(var3, 0, 1, 0, 0, 1, 1);
      var1 = var3[0];
      var0.getRGB(var2, 0, var0.getWidth(), 0, 0, var0.getWidth(), var0.getHeight());

      for (int var6 = 0; var6 < var2.length; var6++) {
         if (var2[var6] == -1) {
            var2[var6] = var1;
         }
      }

      return Image.createRGBImage(var2, var0.getWidth(), var0.getHeight(), true);
   }

   public static String[] splitText(String var0, int var1, byte[] var2) {
      Vector var3 = new Vector();
      String[] var9;
      int var4 = (var9 = splitString(var0, '\n')).length;

      for (int var5 = 0; var5 < var4; var5++) {
         String var6;
         if ((var6 = var9[var5]).length() > 0) {
            String[] var11;
            int var7 = (var11 = wrapLine(var6, var1, var2)).length;

            for (int var8 = 0; var8 < var7; var8++) {
               var3.addElement(var11[var8]);
            }
         } else {
            var3.addElement("");
         }
      }

      String[] var10 = new String[var3.size()];
      var3.copyInto(var10);
      return var10;
   }

   public static String[] wrapLine(String var0, int var1, byte[] var2) {
      Vector var3 = new Vector();
      String var4 = "";
      int var5 = 0;

      int var6;
      for (var6 = var0.indexOf(32); var6 >= 0; var6 = var0.indexOf(32, var5)) {
         String var7 = var0.substring(var5, var6 + 1);
         if (computeTextWidth(var4 + var7, var2) >= var1) {
            var3.addElement(var4);
            var4 = "";
         }

         var4 = var4 + var7;
         var5 = var6 + 1;
      }

      if (var6 == -1) {
         String var8 = var0.substring(var5);
         if (computeTextWidth(var4 + var8, var2) >= var1) {
            var3.addElement(var4);
            var4 = "";
         }

         var3.addElement(var4 + var8);
      }

      String[] var9 = new String[var3.size()];
      var3.copyInto(var9);
      return var9;
   }

   public static String[] splitString(String var0, char var1) {
      int var2 = 0;
      int var3 = var0.indexOf(var1);

      Vector var4;
      for (var4 = new Vector(); var3 > 0; var3 = var0.indexOf(var1, var2)) {
         if (var0.charAt(var3 - 1) == '\r') {
            var4.addElement(var0.substring(var2, var3 - 1));
         } else {
            var4.addElement(var0.substring(var2, var3));
         }

         var2 = var3 + 1;
      }

      if (var2 < var0.length()) {
         var4.addElement(var0.substring(var2));
      }

      String[] var5 = new String[var4.size()];
      var4.copyInto(var5);
      return var5;
   }
}
