package home.thienph.xyahoo;

import java.util.Date;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class ChatMessageList extends UIControlBase {
   private int targetScrollPosition;
   private int scrollVelocity;
   private int scrollAcceleration;
   private int currentScrollPosition;
   private int totalContentHeight;
   private Vector messageList;
   private int visibleLineCount;
   private int startLineIndex;
   private int selectedLineIndex = -1;
   private int currentMessageLineCount;
   private int currentStringLength;
   private int totalLineCount;
   private Integer currentTextColor;
   private int currentBackgroundColor;
   private boolean isDragging;
   private int lastDragX;
   private int lastDragY;

   static {
      new Date();
   }

   public final boolean isAtBottom() {
      return this.currentScrollPosition > this.totalContentHeight - 20;
   }

   public ChatMessageList(int var1, int var2, int var3, int var4) {
      super(1, 1, var3, var4, true);
      super.isEnabled = true;
      super.isVisible = false;
      this.visibleLineCount = var4 / TextRenderer.lineSpacing + 2;
      this.messageList = new Vector();
      super.actionTertiary = new UIAction("Chat", null);
   }

   public final void addMessage(String var1, int var2) {
      int var3;
      while ((var3 = var1.indexOf("http://")) > 0 || (var3 = var1.indexOf("vtp://")) > 0) {
         this.addMessage(var1.substring(0, var3), var2);
         if ((var3 = (var1 = var1.substring(var3)).indexOf(" ")) == -1) {
            break;
         }

         this.addMessage(var1.substring(0, var3), var2);
         var1 = var1.substring(var3);
      }

      if (!var1.startsWith("http://") && !var1.startsWith("vtp://")) {
         String[] var8 = TextRenderer.splitText(var1, super.width - 100, TextRenderer.charWidth);
         this.currentMessageLineCount = var8.length;

         for (int var5 = 0; var5 < this.currentMessageLineCount; var5++) {
            var8[var5] = (char)(var2 + 31000) + var8[var5];
         }

         for (int var6 = 0; var6 < this.currentMessageLineCount; var6++) {
            this.messageList.addElement(var8[var6]);
         }

         this.totalLineCount = this.messageList.size();
         this.totalContentHeight = (this.totalLineCount - this.visibleLineCount + 2) * TextRenderer.lineSpacing + 8;
         this.handleFocus();
      } else {
         var1 = '祼' + var1;
         this.messageList.addElement(var1);
         this.totalLineCount = this.messageList.size();
      }
   }

   public final void addUserMessage(String var1, String var2, int var3) {
      if ((var2 = ContentFilter.filterProfanity(var2)).startsWith("http")) {
         this.addUserMessage(var1, TextConstant.clickHere(), var3);
         var2 = '祼' + var2;
         this.messageList.addElement(var2);
         this.totalLineCount = this.messageList.size();
      } else {
         var2 = TextRenderer.replaceEmoticons(var2, true);
         String[] var4 = TextRenderer.splitText((char)(var3 + 31000) + var1 + ": 紀" + var2, super.width - 8, TextRenderer.charWidth);
         this.currentMessageLineCount = var4.length;

         for (int var7 = 0; var7 < this.currentMessageLineCount; var7++) {
            this.messageList.addElement(var4[var7]);
         }

         this.totalLineCount = this.messageList.size();
         this.totalContentHeight = (this.totalLineCount - this.visibleLineCount + 2) * TextRenderer.lineSpacing + 8;
         this.handleFocus();
      }
   }

   public final boolean handleKeyInput(int var1) {
      if (var1 == 12) {
         if (this.selectedLineIndex > 0) {
            this.selectedLineIndex--;
         }

         this.targetScrollPosition = this.targetScrollPosition - TextRenderer.lineSpacing;
         if (this.targetScrollPosition < -TextRenderer.lineSpacing) {
            this.targetScrollPosition = -TextRenderer.lineSpacing;
         }

         if (thien_ar.a) {
            thien_ar.a(true);
         }
      } else if (var1 == 13) {
         if (this.selectedLineIndex < this.totalLineCount - 1) {
            this.selectedLineIndex++;
         }

         this.targetScrollPosition = this.targetScrollPosition + TextRenderer.lineSpacing;
         if (this.targetScrollPosition > this.totalContentHeight) {
            this.targetScrollPosition = this.totalContentHeight;
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
      var1.translate(0, -this.currentScrollPosition);
      if (this.selectedLineIndex != -1) {
         int var4 = super.width - 3;
         this.currentTextColor = TextRenderer.colorWhite;
         this.currentBackgroundColor = 16777215;
         var1.setColor(2580);
         var1.fillRoundRect(3, this.selectedLineIndex * TextRenderer.lineSpacing + 34, var4, TextRenderer.lineSpacing, 5, 5);
      }

      this.currentMessageLineCount = this.startLineIndex + this.visibleLineCount;

      for (int var12 = this.startLineIndex - 1; var12 < this.currentMessageLineCount; var12++) {
         if (var12 >= 0) {
            try {
               if (var12 >= this.totalLineCount) {
                  break;
               }

               String var5 = (String)this.messageList.elementAt(var12);
               byte var6 = 0;
               this.currentBackgroundColor = 16777215;
               this.currentTextColor = TextRenderer.colorWhite;
               int var2 = 0;
               if (var5.charAt(0) >= 31000) {
                  if ((var2 = var5.charAt(0) - 31000) == 0 || var2 == 100) {
                     this.currentTextColor = TextRenderer.colorHighlight;
                     this.currentBackgroundColor = 3981823;
                  } else if (var2 == 1) {
                     this.currentTextColor = TextRenderer.colorPrimary;
                     this.currentBackgroundColor = 16726823;
                  } else if (var2 == 2) {
                     this.currentTextColor = TextRenderer.colorWhite;
                     this.currentBackgroundColor = 16777215;
                  }

                  var6 = 1;
               }

               int var3 = 8;
               String var10 = "";
               this.currentStringLength = var5.length();

               for (int var13 = var6; var13 < this.currentStringLength; var13++) {
                  char var7;
                  if ((var7 = var5.charAt(var13)) == 32000) {
                     var1.setColor(this.currentBackgroundColor);
                     TextRenderer.getFontRenderer(this.currentTextColor).drawText(var10, var3, var12 * TextRenderer.lineSpacing + 34, var1);
                     var3 += TextRenderer.computeTextWidth(var10, TextRenderer.charWidth);
                     var10 = "";
                     this.currentBackgroundColor = 16777215;
                     this.currentTextColor = TextRenderer.colorWhite;
                  } else if (var7 >= 30000) {
                     var1.setColor(((Integer)this.currentTextColor).intValue());
                     TextRenderer.getFontRenderer(this.currentTextColor).drawText(var10, var3, var12 * TextRenderer.lineSpacing + 34, var1);
                     var3 += TextRenderer.computeTextWidth(var10, TextRenderer.charWidth);
                     var10 = "";
                     var7 -= 30000;
                     var1.drawRegion(GameManager.smileyIcons, var7 * 18, 0, 18, 18, 0, var3 + 10, var12 * TextRenderer.lineSpacing + (TextRenderer.lineSpacing >> 1) + 34, 3);
                     var3 += 20;
                  } else {
                     var10 = var10 + var7;
                  }
               }

               var1.setColor(this.currentBackgroundColor);
               TextRenderer.getFontRenderer(this.currentTextColor).drawText(var10, var3, var12 * TextRenderer.lineSpacing + 34, var1);
            } catch (Exception var8) {
            }
         }
      }

      var1.translate(0, this.currentScrollPosition);
      var1.translate(0, -6);
      var1.translate(-var1.getTranslateX(), -var1.getTranslateY());
      var1.setClip(-1000, -1000, 2000, 2000);
   }

   public final void update() {
      if (this.currentScrollPosition != this.targetScrollPosition) {
         this.scrollVelocity = this.targetScrollPosition - this.currentScrollPosition << 2;
         this.scrollAcceleration = this.scrollAcceleration + this.scrollVelocity;
         this.currentScrollPosition = this.currentScrollPosition + (this.scrollAcceleration >> 3);
         this.scrollAcceleration &= 15;
         if (this.currentScrollPosition > this.totalContentHeight) {
            this.currentScrollPosition = this.totalContentHeight;
         }

         if (this.currentScrollPosition < 0) {
            this.currentScrollPosition = 0;
         }

         this.startLineIndex = this.currentScrollPosition / TextRenderer.lineSpacing - 1;
         if (this.startLineIndex < 0) {
            this.startLineIndex = 0;
         }
      }
   }

   public final void handleFocus() {
      if (super.baseY + this.messageList.size() * (TextRenderer.lineSpacing + 2) >= super.height) {
         thien_ar.a = true;
         thien_ar.a(this.messageList.size());
      } else {
         thien_ar.a = false;
      }
   }

   public final void drawScrollbar(Graphics var1) {
      if (thien_ar.a) {
         thien_ar.a(var1, this.selectedLineIndex);
      }
   }

   public final void onDrag(int var1, int var2) {
      this.lastDragX = var1;
      this.lastDragY = var2;
   }

   public final void handleKeyPress(int var1, int var2) {
      if (this.isDragging) {
         this.isDragging = false;
         this.targetScrollPosition = this.targetScrollPosition - (var2 - this.lastDragY << 3);
         if (this.targetScrollPosition < 0) {
            this.targetScrollPosition = 0;
         } else if (this.targetScrollPosition > this.totalContentHeight) {
            this.targetScrollPosition = this.totalContentHeight;
         }
      }

      if (thien_ar.a) {
         thien_ar.a(true);
      }
   }

   public final void handlePointerRelease(int var1, int var2) {
      if (UIBuddyListControl.c(var1 - this.lastDragX) > 1 || UIBuddyListControl.c(var2 - this.lastDragY) > 1) {
         this.isDragging = true;
         this.targetScrollPosition = this.targetScrollPosition - (var2 - this.lastDragY);
         if (this.targetScrollPosition < 0) {
            this.targetScrollPosition = 0;
         } else if (this.targetScrollPosition > this.totalContentHeight) {
            this.targetScrollPosition = this.totalContentHeight;
         }

         this.currentScrollPosition = this.targetScrollPosition;
         this.startLineIndex = this.currentScrollPosition / TextRenderer.lineSpacing - 1;
         if (this.startLineIndex < 0) {
            this.startLineIndex = 0;
         }

         this.lastDragX = var1;
         this.lastDragY = var2;
      }

      if (thien_ar.a) {
         thien_ar.a(true);
      }
   }

   public final void drawBackground(Graphics var1) {
   }

   public final void scrollToBottom() {
      this.startLineIndex = this.totalLineCount - this.visibleLineCount;
      this.selectedLineIndex = this.totalLineCount - 1;
      this.targetScrollPosition = this.totalContentHeight;
   }

   public final String getSelectedLine() {
      return this.selectedLineIndex == -1 ? "" : (String)this.messageList.elementAt(this.selectedLineIndex);
   }

   public final String getSelectedMessage() {
      if (this.selectedLineIndex == -1) {
         return "";
      } else {
         int var1 = this.selectedLineIndex;
         int var2 = this.selectedLineIndex;

         for (var1 = var1; ((String)this.messageList.elementAt(var2)).charAt(0) < 31000; var2--) {
            if (var2 <= 0) {
               var2 = 0;
               break;
            }
         }

         while (true) {
            if (((String)this.messageList.elementAt(var1)).charAt(0) >= 31000) {
               if (--var1 < 0) {
                  var1 = 0;
               }
               break;
            }

            if (var1 >= this.messageList.size() - 1) {
               var1 = this.messageList.size() - 1;
               break;
            }

            var1++;
         }

         if (var1 < var2) {
            var1 = var2;
         }

         String var3 = "";

         for (int var7 = var2; var7 <= var1; var7++) {
            var3 = var3 + (String)this.messageList.elementAt(var7) + " ";
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
