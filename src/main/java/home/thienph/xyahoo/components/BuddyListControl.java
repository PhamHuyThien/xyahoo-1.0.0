package home.thienph.xyahoo.components;

import home.thienph.xyahoo.actions.*;
import home.thienph.xyahoo.data.data.ContactDataSource;
import home.thienph.xyahoo.data.data.ContactEntry;
import home.thienph.xyahoo.data.data.ContactGroup;
import home.thienph.xyahoo.data.data.UIAction;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.main.GameCanvas;
import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.utils.TextRenderer;
import home.thienph.xyahoo.main.Xuka;

import java.io.IOException;
import java.util.Vector;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class BuddyListControl extends UIControlBase {
   public static Image[] statusIcons;
   public static Image[] groupIcons;
   public boolean isAutoChatEnabled;
   public boolean isFilterActive;
   public boolean isLoading;
   private String searchKeyword;
   private boolean hasSearchResults;
   private int targetScrollPos;
   private int scrollDelta;
   private int scrollAccumulator;
   private int currentScrollPos;
   private int maxScrollPos;
   public Vector actionButtons = new Vector();
   public static int[][] iconPositionMap = new int[][]{{0, 13}, {13, 11}, {24, 11}, {35, 11}, {46, 11}, {57, 13}, {70, 8}};
   private int itemHeight;
   private int firstVisibleIndex;
   private int visibleItemCount;
   public int selectedItemIndex;
   public UIAction selectAction = new UIAction(TextConstant.select(), null);
   private UIAction emptyAction = new UIAction("", null);
   public UIAction markAction = new UIAction(TextConstant.mark(), null);
   private boolean isMarkMode = false;
   public ContactDataSource contactDataSource;
   public Vector displayItems;
   public String[] pleaseWait = new String[]{TextConstant.pleaseWait()};
   public boolean isScrollable;
   private DisplayItem selectedDisplayItem;
   private UIAction chatAction;
   private int listWidth;
   private int leftMargin;
   private int rightMargin;
   private int scrollBarWidth;
   private int centerX;
   private int totalItems;
   private int itemSpacing;
   private int halfWidth;
   private int animationCounter;
   private boolean isDragging;
   private int lastTouchX;
   private int lastTouchY;

   public static void loadIcons() {
      statusIcons = new Image[5];
      groupIcons = new Image[4];

      try {
         for (int var0 = 0; var0 < 5; var0++) {
            statusIcons[var0] = Image.createImage("/Stat" + var0 + ".png");
         }

         for (int var2 = 0; var2 < 4; var2++) {
            groupIcons[var2] = Image.createImage("/Nav" + var2 + ".png");
         }
      } catch (IOException var1) {
      }
   }

   public final void setMarkMode(boolean var1) {
      this.isMarkMode = var1;
   }

   public final ContactDataSource getDataModel() {
      return this.contactDataSource;
   }

   public final void setDataSource(ContactDataSource var1, int var2) {
      this.contactDataSource = var1;
      this.selectedItemIndex = -1;
      this.rebuildVisibleItems();
      this.handleFocus();
   }

   public BuddyListControl(int var1, int var2, int var3, int var4, boolean var5) {
      super(1, 1, var3, var4, true);
      System.currentTimeMillis();
      super.isEnabled = true;
      this.isAutoChatEnabled = true;
      this.itemHeight = TextRenderer.fontHeight + 3;
      if (this.itemHeight < statusIcons[0].getHeight()) {
         this.itemHeight = statusIcons[0].getHeight();
      }

      this.listWidth = var3 - 51;
      this.leftMargin = 1;
      this.rightMargin = 50;
      this.scrollBarWidth = 120;
      this.halfWidth = var3 / 2;
   }

   public final void rebuildVisibleItems() {
      this.displayItems = new Vector();
      if (this.contactDataSource != null && this.contactDataSource.groups != null && this.contactDataSource.groups.size() != 0) {
         Vector var1 = this.contactDataSource.groups;
         boolean var2 = false;
         int var3 = var1.size();
         int var4 = 0;

         for (int var5 = 0; var5 < var3; var5++) {
            ContactGroup var10 = (ContactGroup)var1.elementAt(var5);
            DisplayItem var6;
            (var6 = new DisplayItem()).itemType = 1;
            var6.statusCode = var10.getGroupStatus();
            var6.displayName = var10.getGroupName();
            this.displayItems.addElement(var6);
            if (var6.statusCode != 1) {
               Vector var12 = var10.contacts;
               var4 = var10.contacts.size();

               for (int var7 = 0; var7 < var4; var7++) {
                  ContactEntry var8 = (ContactEntry)var12.elementAt(var7);
                  DisplayItem var9;
                  (var9 = new DisplayItem()).additionalData = var8.permissions;
                  var9.displayName = var8.contactId;
                  var9.statusCode = var8.statusCode;
                  var9.statusText = var8.displayName;
                  var9.textColor = var8.getTextColor();
                  var9.fontRenderer = var8.colorObject;
                  var9.fontRenderer = new Integer(var8.getTextColor());
                  if (!this.isFilterActive || var9.statusCode != 0 && var9.statusCode != 0) {
                     if (this.hasSearchResults) {
                        if (var9.displayName.indexOf(this.searchKeyword) == -1 && var9.statusText.indexOf(this.searchKeyword) == -1) {
                           continue;
                        }

                        if (!var2) {
                           this.selectedItemIndex = this.displayItems.size();
                           var2 = true;
                        }
                     }

                     var9.isSelected = var8.isOnline;
                     var9.detailText = var8.statusMessage;
                     var9.sourceEntry = var8;
                     this.displayItems.addElement(var9);
                  }
               }
            }
         }

         if (this.selectedItemIndex < 0) {
            this.selectedItemIndex = 0;
         }

         if (this.selectedItemIndex >= this.displayItems.size()) {
            this.selectedItemIndex = this.displayItems.size() - 1;
         }

         this.visibleItemCount = super.height / this.itemHeight + 1;
         this.maxScrollPos = this.displayItems.size() * this.itemHeight - super.height + 3 + this.itemHeight;
         this.targetScrollPos = this.selectedItemIndex * this.itemHeight - (super.height >> 1);
         this.firstVisibleIndex = this.selectedItemIndex - (this.visibleItemCount >> 1);
         if (this.displayItems.size() - this.selectedItemIndex < this.visibleItemCount >> 1) {
            this.firstVisibleIndex = this.displayItems.size() - this.visibleItemCount;
         }

         if (this.firstVisibleIndex < 0) {
            this.firstVisibleIndex = 0;
         }

         if (((DisplayItem)this.displayItems.elementAt(this.selectedItemIndex)).itemType == 1) {
            super.actionTertiary = this.emptyAction;
         } else if (this.isMarkMode) {
            super.actionTertiary = this.markAction;
         } else {
            super.actionTertiary = this.selectAction;
         }
      } else {
         this.firstVisibleIndex = 0;
         this.visibleItemCount = 0;
         this.maxScrollPos = 0;
      }
   }

   public final boolean handleSoftKey(int var1) {
      if (var1 != 13 && var1 != 12) {
         return true;
      } else {
         this.handleKeyInput(var1);
         return false;
      }
   }

   public final boolean handleKeyInput(int var1) {
      if (this.isLoading) {
         return true;
      } else if (this.displayItems != null && this.displayItems.size() != 0) {
         if (var1 == 12) {
            System.currentTimeMillis();
            this.selectedItemIndex--;
            if (this.selectedItemIndex < 0) {
               this.selectedItemIndex = this.displayItems.size() - 1;
            }
         }

         if (var1 == 13) {
            System.currentTimeMillis();
            this.selectedItemIndex++;
            if (this.selectedItemIndex >= this.displayItems.size()) {
               this.selectedItemIndex = 0;
            }
         }

         if (var1 == 12 || var1 == 13) {
            if (((DisplayItem)this.displayItems.elementAt(this.selectedItemIndex)).itemType == 1) {
               super.actionTertiary = this.emptyAction;
            } else if (this.isMarkMode) {
               super.actionTertiary = this.markAction;
            } else {
               super.actionTertiary = this.selectAction;
            }

            this.targetScrollPos = this.selectedItemIndex * this.itemHeight - (super.height >> 1);
            this.firstVisibleIndex = this.selectedItemIndex - (this.visibleItemCount >> 1);
            if (this.displayItems.size() - this.selectedItemIndex < this.visibleItemCount >> 1) {
               this.firstVisibleIndex = this.displayItems.size() - this.visibleItemCount;
            }

            if (this.firstVisibleIndex < 0) {
               this.firstVisibleIndex = 0;
            }

            GameCanvas.resetKeys();
            if (thien_ar.a) {
               thien_ar.a(true);
            }
         }

         if (var1 == 16) {
            this.handleSelection();
            GameCanvas.resetKeys();
         }

         return true;
      } else {
         return true;
      }
   }

   public static void cleanup() {
   }

   private void handleSelection() {
      if (this.selectedItemIndex != -1) {
         this.selectedDisplayItem = (DisplayItem)this.displayItems.elementAt(this.selectedItemIndex);
         if (this.selectedDisplayItem.itemType == 0) {
            if (this.selectedDisplayItem.statusCode == 8) {
               if (this.selectedDisplayItem.displayName.startsWith("http://")) {
                  try {
                     Xuka.instance.platformRequest(this.selectedDisplayItem.displayName);
                     return;
                  } catch (ConnectionNotFoundException var2) {
                     return;
                  }
               }
            } else if (this.selectedDisplayItem.statusCode == 4) {
               return;
            }

            if (this.isMarkMode) {
               DisplayItem displayItem2 = (DisplayItem)this.displayItems.elementAt(this.selectedItemIndex);
               ((DisplayItem)this.displayItems.elementAt(this.selectedItemIndex)).isSelected = !displayItem2.isSelected;
               displayItem2.sourceEntry.isOnline = !displayItem2.sourceEntry.isOnline;
               return;
            }

            if (this.chatAction == null) {
               this.chatAction = new UIAction("Chat", new thien_c(this));
            }

            if (this.isAutoChatEnabled) {
               this.chatAction.actionHandler.action();
               return;
            }
         } else {
            if (this.selectedDisplayItem.statusCode == 0) {
               this.contactDataSource.setGroupStatus(this.selectedDisplayItem.displayName, 1);
            } else {
               this.contactDataSource.setGroupStatus(this.selectedDisplayItem.displayName, 0);
            }

            this.rebuildVisibleItems();
         }
      }
   }

   public final void draw(Graphics var1) {
      this.centerX = super.width >> 1;
      var1.setClip(super.baseX, super.baseY, super.width + 1, super.height);
      if (this.isLoading) {
         var1.setColor(16777215);
         TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(TextConstant.pleaseWait(), this.centerX, 20, 2, var1, TextRenderer.charWidth, TextRenderer.fontHeight);
         GameManager.instance.drawLoadingAnimation(var1, this.centerX, TextRenderer.fontHeight + 35);
      } else if (this.visibleItemCount == 0) {
         var1.setColor(16777215);
         int var9 = this.pleaseWait.length;

         while (--var9 >= 0) {
            TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(this.pleaseWait[var9], this.centerX, 20 + var9 * TextRenderer.fontHeight, 2, var1, TextRenderer.charWidth, TextRenderer.fontHeight);
         }
      } else {
         var1.translate(2, 2);
         var1.translate(0, -this.currentScrollPos);
         int var2 = this.firstVisibleIndex * this.itemHeight;
         this.centerX = this.firstVisibleIndex + this.visibleItemCount;
         this.totalItems = this.displayItems.size();
         this.itemSpacing = this.itemHeight + 2;
         int var3 = 0;
         int var4 = super.width - 3;

         for (int var5 = this.firstVisibleIndex; var5 <= this.centerX && var5 < this.totalItems; var5++) {
            DisplayItem var6 = (DisplayItem)this.displayItems.elementAt(var5);
            var3 = this.itemHeight;
            if (var5 == this.selectedItemIndex) {
               if (var6.itemType == 0) {
                  var3 <<= 1;
               }

               var1.setColor(2580);
               var1.fillRect(1, var2 + 1, var4, var3);
               var1.setColor(9478569);
               var1.drawRoundRect(0, var2 + 1, var4 + 1, var3, 5, 5);
               if (var3 > this.itemHeight) {
                  var1.setColor(3981823);
                  TextRenderer.getFontRenderer(TextRenderer.colorHighlight).drawText(var6.displayName, 22, var2 + this.itemSpacing, var1);
               }
            }

            var1.setColor(0);
            byte var7;
            if (var6.itemType == 1) {
               var7 = 18;
               var1.drawImage(groupIcons[var6.statusCode], 9, var2 + (this.itemHeight >> 1) + 1, 3);
            } else {
               var7 = 23;
               int var8 = var6.statusCode == 1 ? 1 : 0;
               var1.drawImage(statusIcons[var8], 11, var2 + (this.itemHeight >> 1) + 3, 3);
            }

            String var11 = var6.displayName;
            if (var6.itemType == 1) {
               var11 = TextRenderer.wrapText(var11, super.width - 26, TextRenderer.charWidth);
               var1.setColor(16726823);
               TextRenderer.getFontRenderer(TextRenderer.colorPrimary).drawText(var11, var7, var2 + 2, var1);
            } else {
               var11 = var6.statusText;
               if (var6.detailText != null && !var6.detailText.equals("")) {
                  var11 = var11 + " - " + var6.detailText;
               }

               if (!var6.statusText.equals("")) {
                  var11 = TextRenderer.wrapText(var11, super.width - 26, TextRenderer.charWidth);
               }

               var1.setColor(var6.textColor);
               TextRenderer.getFontRenderer(var6.fontRenderer).drawText(var11, var7, var2 + 3, var1);
               if (this.isMarkMode && var6.statusCode != 3) {
                  var1.drawImage(GameManager.chatIcons[var6.isSelected ? 1 : 0], super.width - 12, var2 + (this.itemHeight >> 1), 3);
               }
            }

            var2 += var3;
         }

         var1.translate(0, this.currentScrollPos);
         var1.translate(-var1.getTranslateX(), -var1.getTranslateY());
         var1.setClip(-1000, -1000, 2000, 2000);
      }
   }

   public final void drawBackground(Graphics var1) {
   }

   public final void update() {
      this.animationCounter++;
      if (this.animationCounter > 1000) {
         this.animationCounter = 0;
      }

      if (this.currentScrollPos != this.targetScrollPos) {
         this.scrollDelta = this.targetScrollPos - this.currentScrollPos << 2;
         this.scrollAccumulator = this.scrollAccumulator + this.scrollDelta;
         this.currentScrollPos = this.currentScrollPos + (this.scrollAccumulator >> 4);
         this.scrollAccumulator &= 15;
         if (this.currentScrollPos > this.maxScrollPos) {
            this.currentScrollPos = this.maxScrollPos;
         }

         if (this.currentScrollPos < 0) {
            this.currentScrollPos = 0;
         }

         this.firstVisibleIndex = this.currentScrollPos / this.itemHeight - 1;
         if (this.firstVisibleIndex < 0) {
            this.firstVisibleIndex = 0;
         }
      }
   }

   public final void handleFocus() {
      if (this.displayItems != null) {
         if (super.baseY + this.displayItems.size() * this.itemHeight >= super.height) {
            thien_ar.a = true;
            thien_ar.a(this.displayItems.size());
         } else {
            thien_ar.a = false;
         }
      }
   }

   public final void drawScrollbar(Graphics var1) {
      if (thien_ar.a) {
         thien_ar.a(var1, this.selectedItemIndex);
      }
   }

   public final void onDrag(int var1, int var2) {
      this.lastTouchX = var1;
      this.lastTouchY = var2;
   }

   public final void handleKeyPress(int var1, int var2) {
      if (this.isDragging) {
         this.isDragging = false;
         this.targetScrollPos = this.targetScrollPos - (var2 - this.lastTouchY) * 5;
         if (this.targetScrollPos < 0) {
            this.targetScrollPos = 0;
         } else if (this.targetScrollPos > this.maxScrollPos) {
            this.targetScrollPos = this.maxScrollPos;
         }
      } else {
         if (this.displayItems == null) {
            return;
         }

         if ((var1 = (var2 + this.currentScrollPos) / this.itemHeight) < 0) {
            var1 = 0;
         }

         if (var1 > this.displayItems.size() - 1) {
            var1 = this.displayItems.size() - 1;
         }

         if (var1 < 0) {
            return;
         }

         if (this.selectedItemIndex == var1) {
            this.handleSelection();
            return;
         }

         if (this.selectedItemIndex > var1) {
            this.selectedItemIndex = var1;
         } else {
            DisplayItem var4;
            if ((var4 = (DisplayItem)this.displayItems.elementAt(this.selectedItemIndex)).statusText != null && !var4.statusText.equals("")) {
               if (this.selectedItemIndex == var1 - 1) {
                  this.handleSelection();
                  return;
               }

               this.selectedItemIndex = var1 - 1;
            } else {
               this.selectedItemIndex = var1;
            }
         }
      }

      if (thien_ar.a) {
         thien_ar.a(true);
      }
   }

   public final void handlePointerRelease(int var1, int var2) {
      if (absoluteValue(var1 - this.lastTouchX) > 1 || absoluteValue(var2 - this.lastTouchY) > 1) {
         this.isDragging = true;
         this.targetScrollPos = this.targetScrollPos - (var2 - this.lastTouchY);
         if (this.targetScrollPos < 0) {
            this.targetScrollPos = 0;
         } else if (this.targetScrollPos > this.maxScrollPos) {
            this.targetScrollPos = this.maxScrollPos;
         }

         this.currentScrollPos = this.targetScrollPos;
         this.firstVisibleIndex = this.currentScrollPos / this.itemHeight - 1;
         if (this.firstVisibleIndex < 0) {
            this.firstVisibleIndex = 0;
         }

         this.lastTouchX = var1;
         this.lastTouchY = var2;
      }

      if (thien_ar.a) {
         thien_ar.a(true);
      }
   }

   public static int absoluteValue(int var0) {
      return var0 > 0 ? var0 : -var0;
   }

   public final boolean updateContactStatus(String var1, int var2) {
      if (this.contactDataSource == null) {
         return false;
      } else {
         int var5 = var2;
         String var4 = var1;
         ContactDataSource var3 = this.contactDataSource;

         for (int var6 = this.contactDataSource.groups.size() - 1; var6 >= 0; var6--) {
            ContactEntry var7;
            if ((var7 = ((ContactGroup)var3.groups.elementAt(var6)).findContactByName(var4)) != null) {
               var7.statusCode = var5;
            }
         }

         if (this.displayItems == null) {
            return false;
         } else {
            if (this.isFilterActive) {
               this.rebuildVisibleItems();
            } else {
               int var10 = this.displayItems.size();

               while (--var10 >= 0) {
                  DisplayItem var11;
                  if ((var11 = (DisplayItem)this.displayItems.elementAt(var10)).itemType == 0 && var11.displayName.equals(var1)) {
                     if (var11.statusCode == var2) {
                        return false;
                     }

                     var11.statusCode = var2;
                     return true;
                  }
               }
            }

            return false;
         }
      }
   }

   public final void updateContactMessage(String var1, String var2, int var3) {
      if (this.contactDataSource != null) {
         String var6 = var2;
         String var5 = var1;
         ContactDataSource var4 = this.contactDataSource;

         for (int var7 = this.contactDataSource.groups.size() - 1; var7 >= 0; var7--) {
            ContactEntry var8;
            if ((var8 = ((ContactGroup)var4.groups.elementAt(var7)).findContactByName(var5)) != null) {
               var8.statusMessage = var6;
            }
         }

         if (this.displayItems != null) {
            if (this.isFilterActive) {
               this.rebuildVisibleItems();
            } else {
               int var11 = this.displayItems.size();

               while (--var11 >= 0) {
                  DisplayItem var12;
                  if ((var12 = (DisplayItem)this.displayItems.elementAt(var11)).itemType == 0 && var12.displayName.equals(var1)) {
                     if (var3 == 1) {
                        var12.detailText = var2;
                     } else if (var3 == 2) {
                        var12.statusText = var2;
                     }
                  }
               }
            }
         }
      }
   }

   public final String getCurrentGroupName() {
      for (int var1 = this.selectedItemIndex; var1 >= 0; var1--) {
         DisplayItem var2;
         if ((var2 = (DisplayItem)this.displayItems.elementAt(var1)).itemType == 1) {
            return var2.displayName;
         }
      }

      return "";
   }

   public final DisplayItem getSelectedItem() {
      return this.selectedItemIndex < 0 ? null : (DisplayItem)this.displayItems.elementAt(this.selectedItemIndex);
   }

   public final void removeEmptyGroup(String var1) {
      String var3 = var1;
      ContactDataSource var2 = this.contactDataSource;

      for (int var4 = this.contactDataSource.groups.size() - 1; var4 >= 0; var4--) {
         ContactGroup var5;
         if ((var5 = (ContactGroup)var2.groups.elementAt(var4)).getGroupName().equals(var3) && var5.contacts.size() == 0) {
            var2.groups.removeElementAt(var4);
         }
      }

      if (this.isFilterActive) {
         this.rebuildVisibleItems();
      } else {
         for (int var6 = this.selectedItemIndex; var6 >= 0; var6--) {
            DisplayItem var7;
            if ((var7 = (DisplayItem)this.displayItems.elementAt(var6)).itemType == 1 && var7.displayName.equals(var1)) {
               this.displayItems.removeElementAt(var6);
               if (this.selectedItemIndex >= this.displayItems.size()) {
                  this.selectedItemIndex = this.displayItems.size() - 1;
               }
            }
         }
      }
   }

   public final void removeContact(String var1) {
      if (this.contactDataSource != null) {
         String var3 = var1;
         ContactDataSource var2 = this.contactDataSource;

         label46:
         for (int var4 = this.contactDataSource.groups.size() - 1; var4 >= 0; var4--) {
            ContactGroup var5;
            for (int var6 = (var5 = (ContactGroup)var2.groups.elementAt(var4)).contacts.size() - 1; var6 >= 0; var6--) {
               if (((ContactEntry)var5.contacts.elementAt(var6)).contactId.equals(var3)) {
                  var5.contacts.removeElementAt(var6);
                  break label46;
               }
            }
         }

         if (this.isFilterActive) {
            this.rebuildVisibleItems();
         } else {
            for (int var7 = this.selectedItemIndex; var7 >= 0; var7--) {
               DisplayItem var8;
               if ((var8 = (DisplayItem)this.displayItems.elementAt(var7)).itemType == 0 && var8.displayName.equals(var1)) {
                  this.displayItems.removeElementAt(var7);
                  if (this.selectedItemIndex >= this.displayItems.size()) {
                     this.selectedItemIndex = this.displayItems.size() - 1;
                  }
               }
            }
         }
      }
   }

   public final void renameGroup(String var1, String var2) {
      String var4 = var1;
      ContactDataSource var3 = this.contactDataSource;

      for (int var6 = this.contactDataSource.groups.size() - 1; var6 >= 0; var6--) {
         ContactGroup var7;
         if ((var7 = (ContactGroup)var3.groups.elementAt(var6)).getGroupName().equals(var4)) {
            var7.setGroupName(var2);
            break;
         }
      }

      for (int var8 = this.displayItems.size() - 1; var8 >= 0; var8--) {
         DisplayItem var9;
         if ((var9 = (DisplayItem)this.displayItems.elementAt(var8)).itemType == 1 && var9.displayName.equals(var1)) {
            var9.displayName = var2;
            return;
         }
      }
   }

   public final boolean hasGroup(String var1) {
      for (int var2 = this.displayItems.size() - 1; var2 >= 0; var2--) {
         DisplayItem var3;
         if ((var3 = (DisplayItem)this.displayItems.elementAt(var2)).itemType == 1 && var3.displayName.equals(var1)) {
            return true;
         }
      }

      return false;
   }

   public final void setSearchFilter(String var1) {
      if (var1.equals("")) {
         this.hasSearchResults = false;
      } else {
         this.hasSearchResults = true;
         this.searchKeyword = var1;
         this.isFilterActive = false;
      }

      this.rebuildVisibleItems();
   }

   public final String[] getGroupNames() {
      int var1;
      String[] var2 = new String[var1 = this.contactDataSource.groups.size()];

      for (int var3 = 0; var3 < var1; var3++) {
         var2[var3] = ((ContactGroup)this.contactDataSource.groups.elementAt(var3)).getGroupName();
      }

      return var2;
   }

   public final void moveContactToGroup(String var1, String var2) {
      var2 = var1;
      ContactDataSource var9 = this.contactDataSource;
      ContactEntry var4 = null;

      for (int var5 = var9.groups.size() - 1; var5 >= 0; var5--) {
         ContactGroup var6;
         for (int var7 = (var6 = (ContactGroup)var9.groups.elementAt(var5)).contacts.size() - 1; var7 >= 0; var7--) {
            ContactEntry var8;
            if ((var8 = (ContactEntry)var6.contacts.elementAt(var7)).contactId.equals(var2)) {
               var4 = var8;
               var6.contacts.removeElementAt(var7);
               break;
            }
         }
      }

      if (var4 != null) {
         var9.addContactToGroup(var2, var4);
      }

      this.rebuildVisibleItems();
   }

   public final DisplayItem findDisplayItem(String var1) {
      for (int var2 = this.displayItems.size() - 1; var2 >= 0; var2--) {
         DisplayItem var3;
         if ((var3 = (DisplayItem)this.displayItems.elementAt(var2)).itemType == 0 && var3.displayName.equals(var1)) {
            return var3;
         }
      }

      return null;
   }

   public static DisplayItem getSelectedDisplayItem(BuddyListControl var0) {
      return var0.selectedDisplayItem;
   }
}
