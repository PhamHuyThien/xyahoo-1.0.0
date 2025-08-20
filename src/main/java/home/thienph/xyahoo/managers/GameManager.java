package home.thienph.xyahoo.managers;

import home.thienph.xyahoo.actions.*;
import home.thienph.xyahoo.components.*;
import home.thienph.xyahoo.conections.ConnectionManager;
import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.data.data.*;
import home.thienph.xyahoo.data.networks.Packet;
import home.thienph.xyahoo.screens.*;
import home.thienph.xyahoo.main.*;
import home.thienph.xyahoo.utils.ContentFilter;
import home.thienph.xyahoo.utils.TextRenderer;
import home.thienph.xyahoo.utils.TextRendererHelper;
import home.thienph.xyahoo.utils.UIFormBuilder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class GameManager implements IGameManager {
   private static boolean isLocalServer;
   public static boolean isTestMode;
   public static String serverMessage;
   private String recoveryEmail;
   private String cardSyntax;
   private static String emptyString = "";
   public static GameManager instance = new GameManager();
   public Vector messageQueue;
   private Vector screenStack;
   public static Screen currentScreen;
   private int itemHeight;
   public static int headerHeight;
   private static int leftBorder;
   public static int topMargin;
   private static int rightBorder;
   private static int screenTop;
   private static int touchAreaWidth = 15;
   public int frameCounter;
   private int topOffset;
   private int centerOffset;
   private int animationFrame;
   private int screenWidth;
   private int screenHeight;
   public IAction loginAction;
   private int currentScreenIndex;
   public BuddyListScreen buddyListScreen;
   public LoginYahooScreen loginYahooScreen;
   public LoginScreen loginScreen;
   private RegisterScreen registerScreen;
   public InviteConferenceScreen inviteConferenceScreen;
   private boolean isShowingDialog;
   public Vector dialogQueue = new Vector();
   private int[] notificationStates = new int[3];
   private String[] notificationTexts = new String[3];
   private int[] notificationWidths = new int[3];
   private int[] notificationX = new int[3];
   private int[] notificationY = new int[3];
   private int[] notificationHeights = new int[3];
   private int[] notificationEndY = new int[3];
   private int[] notificationSpeeds = new int[3];
   private Image[] notificationIcons = new Image[3];
   private boolean isShowingSidePopup;
   private Vector sidePopupQueue;
   public static String statusMessage = "";
   private boolean isShowingCustomDialog;
   private Image customDialogImage;
   private String[] customDialogText;
   private int customDialogTimer;
   private boolean isShowingEmoticonPicker;
   private int emoticonX;
   private int emoticonY;
   private int emoticonAreaX;
   private int emoticonAreaY;
   private int emoticonAreaWidth;
   private int emoticonAreaHeight;
   private int emoticonDrawY;
   public static boolean soundEnabled = false;
   public static boolean vibrateEnabled = true;
   public static boolean autoLogin = true;
   public static boolean autoLoginYahoo = false;
   private static Image loadImage;
   private static Image backgroundImage;
   public static Vector blockedUsers;
   public static Image smileyIcons;
   public static Image tabBarImage;
   public static Image dialogBackground;
   public static Image dialogTop;
   public static Image[] chatIcons;
   private static Image gameBackground;
   private UIAction cancelAction;
   private UIAction okAction;
   private IAction closeAction;
   private int inviteeCount;
   private Screen activeScreen;
   private int screenCount;
   private int leftSlideAnimation = 0;
   private int rightSlideAnimation = 0;
   private boolean isRightAligned;
   public static boolean isShowingAnimation;
   private static int animationCounter;
   private static byte[] nullByte;
   private boolean hasConnectionError;
   public boolean isLoggedIn;
   public String lastMessageSender = "";
   public int messageRepeatCount = 0;
   public static String recoveryPhone;
   public static String promoMessage;
   public HomeScreen homeScreen;
   public static RoomListScreen roomListScreen;

   static {
      try {
         loadImage = Image.createImage("/Load.png");
      } catch (Exception var0) {
      }

      nullByte = new byte[1];
   }

   private void addScreen(Screen var1) {
      this.screenStack.addElement(var1);
      this.screenCount = this.screenStack.size();
      var1.wrapTitle(this.screenWidth - 30);
      if (this.screenCount == 1) {
         this.currentScreenIndex = 0;
         this.updateActiveScreen();
      }
   }

   private void updateActiveScreen() {
      this.activeScreen = (Screen)this.screenStack.elementAt(this.currentScreenIndex);
      if (this.activeScreen.isScrolling) {
         this.activeScreen.isScrolling = false;
         this.leftSlideAnimation = 0;
         this.rightSlideAnimation = 0;
      }

      thien_ar.a = false;
      this.activeScreen.updateLayout();
   }

   public final void pushScreen(Screen var1) {
      this.addScreen(var1);
   }

   public final void showScreen(Screen var1) {
      Screen var3 = var1;
      GameManager var2 = this;
      int var4 = this.screenCount;

      boolean var10000;
      while (true) {
         if (--var4 < 0) {
            var10000 = false;
            break;
         }

         if (((Screen)var2.screenStack.elementAt(var4)).title.equals(var3.title)) {
            var10000 = true;
            break;
         }
      }

      if (!var10000) {
         this.addScreen(var1);
      }
   }

   public final void drawLoadingAnimation(Graphics var1, int var2, int var3) {
      var1.drawRegion(loadImage, 0, this.frameCounter % 4 == 0 ? this.animationFrame++ * 6 : this.animationFrame * 6, 46, 6, 0, var2, var3, 3);
      this.animationFrame = this.animationFrame > 4 ? 0 : this.animationFrame;
   }

   private void drawEmoticonPicker(Graphics var1) {
      if (this.isShowingEmoticonPicker) {
         var1.setClip(this.emoticonAreaX + 1, this.emoticonAreaY + 1, this.emoticonAreaWidth - 1, this.emoticonAreaHeight - 1);
         int var2 = this.emoticonAreaWidth / 50 + 1;

         while (--var2 >= 0) {
            int var3 = this.emoticonAreaHeight / 50 + 1;

            while (--var3 >= 0) {
               var1.drawImage(dialogBackground, this.emoticonAreaX + var2 * 50, this.emoticonDrawY + var3 * 50, 0);
            }
         }

         var1.setClip(this.emoticonAreaX - 1, this.emoticonAreaY, this.emoticonAreaWidth + 2, this.emoticonAreaHeight + 2);
         var1.setColor(14545919);
         UIButton.drawBorder(var1, this.emoticonAreaX, this.emoticonDrawY, this.emoticonAreaWidth, this.emoticonAreaHeight);
         var1.setColor(10278388);
         var1.fillRoundRect(5 + this.emoticonAreaX + this.emoticonX * 20, 5 + this.emoticonDrawY + this.emoticonY * 20, 20, 20, 5, 5);
         int var5 = 7;

         while (--var5 >= 0) {
            var2 = 6;

            while (--var2 >= 0) {
               var1.drawRegion(smileyIcons, (var5 * 6 + var2) * 18, 0, 18, 18, 0, 5 + this.emoticonAreaX + var2 * 20 + 10, 5 + this.emoticonDrawY + var5 * 20 + 10, 3);
            }
         }

         var1.translate(-var1.getTranslateX(), -var1.getTranslateY());
         var1.setClip(-1000, -1000, 2000, 2000);
         Screen.drawFooter(var1);
         var1.setColor(16777215);
         TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(TextConstant.select(), 4, GameCanvas.screenHeight - (topMargin >> 1) - (TextRenderer.fontHeight >> 1), var1);
         TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(TextConstant.cancel(), this.screenWidth - 4, GameCanvas.screenHeight - (topMargin >> 1) - (TextRenderer.fontHeight >> 1), 1, var1, TextRenderer.charWidth, TextRenderer.fontHeight);
      }
   }

   public final void showNotification(String var1, Image var2, int var3) {
      if (this.notificationStates[var3] == 0) {
         this.notificationIcons[var3] = var2;
         int var4 = this.notificationIcons[var3] != null ? this.notificationIcons[var3].getWidth() : 0;
         this.notificationTexts[var3] = var1;
         this.notificationWidths[var3] = TextRenderer.computeTextWidth(var1, TextRenderer.charWidth) + 15 + var4;
         if (this.notificationStates[var3] == 0) {
            this.notificationStates[var3] = 1;
         }

         this.notificationHeights[var3] = TextRenderer.fontHeight + 6;
         if (this.notificationIcons[var3] != null && this.notificationHeights[var3] < this.notificationIcons[var3].getHeight() + 6) {
            this.notificationHeights[var3] = this.notificationIcons[var3].getHeight() + 6;
         }

         if (var3 == 0) {
            this.notificationX[var3] = GameCanvas.screenWidth - this.notificationWidths[var3] - 2;
            this.notificationEndY[var3] = this.notificationY[var3] + this.notificationHeights[var3];
         } else if (var3 == 1) {
            this.notificationX[var3] = GameCanvas.screenWidth;
            this.notificationEndY[var3] = this.notificationY[var3];
         } else {
            this.notificationX[var3] = GameCanvas.screenWidth - this.notificationWidths[var3] - 2;
            this.notificationEndY[var3] = this.notificationY[var3] - this.notificationHeights[var3] + 1;
         }
      }
   }

   public final void vibrate() {
      if (vibrateEnabled) {
         Display.getDisplay(Xuka.instance).vibrate(500);
      }
   }

   public final void showEmoticonPicker(int var1) {
      if (!this.isShowingDialog) {
         this.emoticonAreaWidth = 129;
         this.emoticonAreaHeight = 149;
         this.emoticonAreaX = 2;
         this.emoticonAreaY = this.screenHeight - topMargin - this.emoticonAreaHeight - 2;
         this.emoticonDrawY = this.screenHeight - topMargin - 2;
         this.isShowingEmoticonPicker = true;
      }
   }

   public static GameManager getInstance() {
      return instance;
   }

   public final PopupDialogLayout showCenterDialog(String var1, UIAction var2, UIAction var3, UIAction var4) {
      this.isShowingSidePopup = false;
      PopupDialogLayout var5 = new PopupDialogLayout(var1, var2, var3, var4);
      this.dialogQueue.addElement(var5);
      this.isShowingDialog = true;
      return var5;
   }

   private PopupDialogLayout showCenterDialog(String[] contents, UIAction leftBtn, UIAction centerBtn, UIAction rightBtn) {
      this.isShowingSidePopup = false;
      PopupDialogLayout var5 = new PopupDialogLayout(contents, leftBtn, centerBtn, rightBtn);
      this.dialogQueue.addElement(var5);
      this.isShowingDialog = true;
      return var5;
   }

   public final void closeTopDialog() {
      if (this.dialogQueue.size() > 0) {
         this.dialogQueue.removeElementAt(0);
      }

      if (this.dialogQueue.size() == 0) {
         this.isShowingDialog = false;
      }
   }

   protected GameManager() {
   }

   public final void initialize(int var1, int var2) {
      isLocalServer = Xuka.serverIPs[0].startsWith("10.") || Xuka.serverIPs[0].endsWith(".0.1");
      isTestMode = Xuka.serverIPs[0].endsWith("113") || isLocalServer;
      System.out.println("X Yahoo! = " + isTestMode);
      System.gc();
      this.screenWidth = var1;
      this.screenHeight = var2;
      this.screenStack = new Vector();
      this.sidePopupQueue = new Vector();
      blockedUsers = new Vector();

      try {
         Image var3 = Image.createImage("/TabBar.png");
         Graphics var4 = (tabBarImage = Image.createImage(GameCanvas.screenWidth, 18)).getGraphics();
         int var5 = (GameCanvas.screenWidth - 128 >> 5) + 1;

         while (--var5 >= 0) {
            var4.drawRegion(var3, 64, 0, 32, 18, 0, 64 + (var5 << 5), 0, 20);
         }

         var4.drawRegion(var3, 0, 0, 64, 18, 0, 0, 0, 20);
         var4.drawRegion(var3, 0, 0, 64, 18, 2, GameCanvas.screenWidth - 64, 0, 20);
         System.gc();
      } catch (Exception var11) {
      }

      this.itemHeight = TextRenderer.fontHeight + 3;
      leftBorder = 1;
      rightBorder = 1;
      topMargin = TextRenderer.useCustomFont ? tabBarImage.getHeight() : TextRenderer.fontHeight + 3;
      Screen.topMargin = headerHeight = topMargin = TextRenderer.useCustomFont ? 18 : TextRenderer.fontHeight + 3;
      screenTop = topMargin + 1;
      this.notificationY[0] = GameCanvas.screenHeight - topMargin - TextRenderer.fontHeight - 8;
      this.notificationY[1] = this.notificationY[2] = rightBorder + topMargin + 1;
      this.notificationSpeeds[0] = 1;
      this.notificationSpeeds[1] = 2;
      this.notificationSpeeds[2] = 1;
      soundEnabled = Xuka.readFlag("sound", false);
      vibrateEnabled = Xuka.readFlag("vibrate", true);
      autoLogin = Xuka.readFlag("atlog", true);
      autoLoginYahoo = Xuka.readFlag("atlogY", false);

      try {
         smileyIcons = Image.createImage("/Smileys.png");
         dialogTop = Image.createImage("/DlgTop.png");
         dialogBackground = Image.createImage("/DlgBg.png");
         Image var12 = Image.createImage("/bg.png");
         int var13 = GameCanvas.screenHeight - (topMargin << 1);
         Graphics var14 = (backgroundImage = Image.createImage(GameCanvas.screenWidth, var13)).getGraphics();
         int var6 = GameCanvas.screenWidth / 32 + 1;
         int var7 = (var13 - var12.getHeight()) / 32 + 1;

         for (int var8 = 0; var8 < var6; var8++) {
            for (int var9 = 0; var9 < var7; var9++) {
               var14.drawRegion(var12, 0, 0, 32, 32, 0, var8 << 5, var9 << 5, 0);
            }
         }

         for (int var15 = 0; var15 < var6; var15++) {
            var14.drawImage(var12, var15 << 5, var13 - var12.getHeight(), 0);
         }

         System.gc();
         chatIcons = new Image[2];

         for (int var16 = 0; var16 < 2; var16++) {
            chatIcons[var16] = Image.createImage("/ch" + var16 + ".png");
         }
      } catch (Exception var10) {
      }

      BuddyListControl.loadIcons();
      backgroundImage.getHeight();
      this.topOffset = topMargin;
      this.centerOffset = topMargin - 7 >> 1;
      Screen.leftMargin = 0;
      Screen.headerHeight = screenTop;
      Screen.e = var1;
      Screen.formHeight = var2 - screenTop;
      Screen.footerY = screenTop + Screen.formHeight - (topMargin >> 1) - (TextRenderer.fontHeight >> 1) + (TextRenderer.useCustomFont ? 0 : 1);
      this.loginScreen = new LoginScreen();
      this.loginScreen.startSlide(1);
      this.showScreen(this.loginScreen);
      this.currentScreenIndex = 0;
      this.updateActiveScreen();
      if (GameCanvas.isNokiaMapping) {
         TextField.setKeyMappingStyle(1);
      } else if (Xuka.platformName != null && Xuka.platformName.toLowerCase().indexOf("nokia") != -1) {
         TextField.setKeyMappingStyle(0);
      } else {
         TextField.setKeyMappingStyle(2);
      }

      TextField.uiCanvas = GameCanvas.instance;
      TextField.mainMidlet = Xuka.instance;
      TextField.multiTapSpeedIndex = Xuka.readCaret();
      GameCanvas.isGameStarted = true;
   }

   public final void handleConnectionStatus() {
      if (ConnectionManager.isConnecting) {
         this.showCenterDialog(TextConstant.checkingConnection(), null, null, new UIAction(TextConstant.close(), new thien_dj(this))).setExtraOption(true);
      } else if (this.hasConnectionError) {
         this.closeTopDialog();
         this.showCenterDialog(TextConstant.connectionError(), null, null, new UIAction(TextConstant.close(), new thien_du(this)));
      }
   }

   public final void showRegisterScreen() {
      if (this.registerScreen == null) {
         this.registerScreen = new RegisterScreen();
      }

      this.registerScreen.b((String[]) null);
      this.showScreen(this.registerScreen);
      this.switchToScreen(this.registerScreen);
      this.registerScreen.startSlide(-1);
      this.removeScreen(this.loginScreen);
   }

   public static void loadGameBackground() {
      try {
         if (gameBackground == null) {
            gameBackground = Image.createImage("/GBg.png");
            return;
         }
      } catch (IOException var0) {
      }
   }

   public final void paint(Graphics var1) {
      var1.setColor(0);
      var1.fillRect(0, 0, this.screenWidth, this.screenHeight);
      GameManager var2 = this;
      if (TextRenderer.useCustomFont) {
         var1.drawImage(tabBarImage, 0, 0, 20);
      } else {
         int var5 = topMargin >> 1;
         var1.setColor(1404853);
         var1.fillRect(0, 0, Screen.e, var5);
         var1.setColor(1334695);
         var1.fillRect(0, var5 + 0, Screen.e, var5);
         var1.setColor(537185);
         var1.fillRect(0, 2 * var5, Screen.e, 1);
         var1.setColor(6796786);
         var1.fillRect(0, 1, Screen.e, 1);
      }

      var1.setColor(16777215);
      TextRenderer var10000 = TextRenderer.getFontRenderer(TextRenderer.colorWhite);
      int var10002 = Screen.e >> 1;
      int var10003 = TextRenderer.useCustomFont ? 1 : rightBorder + 1;
      var10000.drawText(((Screen)this.screenStack.elementAt(this.currentScreenIndex)).wrappedText, var10002, var10003, 2, var1, TextRenderer.charWidth, TextRenderer.fontHeight);
      if (this.screenCount > 1) {
         for (int var4 = 0; var4 < var2.screenCount; var4++) {
            if (((Screen)var2.screenStack.elementAt(var4)).isScrolling) {
               if (var4 < var2.currentScreenIndex) {
                  if (var2.leftSlideAnimation++ > 20) {
                     var2.leftSlideAnimation = 0;
                  }
               } else if (var2.rightSlideAnimation++ > 20) {
                  var2.rightSlideAnimation = 0;
               }
            }
         }

         if (var2.currentScreenIndex > 0 && var2.leftSlideAnimation < 10) {
            var1.drawImage(BuddyListControl.groupIcons[2], 4, var2.centerOffset, 20);
         }

         if (var2.currentScreenIndex < var2.screenCount - 1 && var2.rightSlideAnimation < 10) {
            var1.drawImage(BuddyListControl.groupIcons[3], var2.screenWidth - 10, var2.centerOffset, 20);
         }
      }

      if (this.activeScreen.scrollLock) {
         var1.setClip(0, topMargin + 1, this.screenWidth, this.screenHeight);
         var1.setColor(396304);
         var1.fillRect(0, 0, this.screenWidth, this.screenHeight);
         int var30 = this.screenWidth - 248 >> 1;
         int var3 = this.screenHeight - 248 >> 1;
         int var11 = var30;
         var1.drawImage(gameBackground, var11, var3, 20);
         var1.drawRegion(gameBackground, 0, 0, 124, 248, 2, var11 + 124, var3, 20);
      } else {
         var1.setClip(0, topMargin, this.screenWidth, this.screenHeight);
         var1.drawImage(backgroundImage, 0, this.topOffset, 0);
      }

      if (this.activeScreen.isSliding) {
         var1.translate(-this.activeScreen.slideOffset, 0);
      }

      this.activeScreen.draw(var1);
      var1.translate(-var1.getTranslateX(), -var1.getTranslateY());
      Graphics var15 = var1;
      var2 = this;

      for (int var19 = 0; var19 < 3; var19++) {
         if (var2.notificationStates[var19] != 0) {
            var15.setClip(0, var2.notificationY[var19], GameCanvas.screenWidth, var2.notificationHeights[var19] + 2);
            var15.setColor(872315);
            var15.fillRect(var2.notificationX[var19] + 1, var2.notificationEndY[var19] + 1, var2.notificationWidths[var19] - 1, var2.notificationHeights[var19] - 1);
            var15.setColor(14545919);
            UIButton.drawBorder(var15, var2.notificationX[var19], var2.notificationEndY[var19], var2.notificationWidths[var19], var2.notificationHeights[var19]);
            int var24 = 5;
            if (var2.notificationIcons[var19] != null) {
               var15.drawImage(var2.notificationIcons[var19], var2.notificationX[var19] + 7 + (var2.notificationIcons[var19].getWidth() >> 1), var2.notificationEndY[var19] + (var2.notificationHeights[var19] >> 1), 3);
               var24 = 5 + var2.notificationIcons[var19].getWidth() + 1;
            }

            var15.setColor(16777215);
            TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(var2.notificationTexts[var19], var2.notificationX[var19] + 3 + var24, var2.notificationEndY[var19] + 3, var15);
         }
      }

      var1.setClip(-1000, -1000, 2000, 2000);
      if (this.isShowingDialog) {
         ((PopupDialogLayout)this.dialogQueue.elementAt(0)).paint(var1);
      } else if (this.isShowingSidePopup) {
         var15 = var1;
         var2 = this;
         int var20 = 0;
         int var25 = this.sidePopupQueue.size();

         for (int var6 = 0; var6 < var25; var6++) {
            PopupSideElementData var7 = (PopupSideElementData)var2.sidePopupQueue.elementAt(var6);
            var20 = var2.isRightAligned ? BuddyListControl.absoluteValue(var7.d + var7.f - var7.h) : BuddyListControl.absoluteValue(var7.f - (var7.d - var7.h));
            var15.setClip((var2.isRightAligned ? var7.h : var7.d) + 2, var7.i + 2, var20 - 3, var7.g - 3);
            int var8 = var7.f / 50 + 1;

            while (--var8 >= 0) {
               int var9 = var7.g / 50 + 1;

               while (--var9 >= 0) {
                  var15.drawImage(dialogBackground, (var2.isRightAligned ? var7.h : var7.d) + var8 * 50, var7.i + var9 * 50, 0);
               }
            }

            var15.drawImage(dialogTop, (var2.isRightAligned ? var7.h : var7.d) + (var7.f >> 1), var7.i, 17);
            var15.setClip(var7.d, var7.e, var7.f + 1, var7.g + 1);
            var15.setColor(14545919);
            UIButton.drawBorder(
               var15,
                    (var2.isRightAligned ? var7.h : var7.d) + 1,
               var7.i + 1,
                    (var2.isRightAligned ? BuddyListControl.absoluteValue(var7.d + var7.f - var7.h) : BuddyListControl.absoluteValue(var7.f - (var7.d - var7.h))) - 2,
               var7.g - 2
            );
            var15.setClip(var2.isRightAligned ? var7.d : var7.d + 2, var7.e, var2.isRightAligned ? var7.f - 1 : var7.f, var7.g);
            var15.translate(var7.h + 5, var7.i + 5);
            var8 = var7.popupSideElements.size();

            for (int var27 = 0; var27 < var8; var27++) {
               var20 = 2 + var27 * var2.itemHeight + (TextRenderer.useCustomFont ? 0 : 1);
               String var10 = ((UIAction)var7.popupSideElements.elementAt(var27)).label;
               if (((UIAction)var7.popupSideElements.elementAt(var27)).popupSideElementData != null) {
                  var10 = var10 + " >";
               }

               if (var27 == var7.c) {
                  var15.setColor(10278388);
                  var15.fillRoundRect(0, var27 * var2.itemHeight, (var2.isRightAligned ? BuddyListControl.absoluteValue(var7.d + var7.f - var7.h) : var7.f) - 9, var2.itemHeight + 1, 5, 5);
                  var15.setColor(0);
                  TextRenderer.getFontRenderer(TextRenderer.colorSecondary).drawText(var10, 3, var20, var15);
               } else {
                  var15.setColor(16777215);
                  TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(var10, 3, var20, var15);
               }
            }

            var15.translate(-(var7.h + 5), -(var7.i + 5));
         }

         var15.setClip(-1000, -1000, 5000, 5000);
         Screen.drawFooter(var15);
         var15.setColor(16777215);
         var20 = GameCanvas.screenHeight - (topMargin >> 1) - (TextRenderer.fontHeight >> 1) + (TextRenderer.useCustomFont ? 0 : 1);
         TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(TextConstant.select(), 4, var20, var15);
         TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(TextConstant.cancel(), var2.screenWidth - 4, var20, 1, var15, TextRenderer.charWidth, TextRenderer.fontHeight);
      } else if (this.isShowingEmoticonPicker) {
         this.drawEmoticonPicker(var1);
      }

      if (this.isShowingCustomDialog) {
         int var14 = topMargin + 2;
         int var17 = TextRenderer.useCustomFont ? 0 : 1;
         var1.setColor(16777215);
         var1.fillRect(10, var14 + var17, GameCanvas.screenWidth - 20, GameCanvas.screenHeight - (var14 << 1));
         var1.setColor(0);
         var1.drawRect(10, var14 + var17, GameCanvas.screenWidth - 20, GameCanvas.screenHeight - (var14 << 1));
         var1.setClip(11, 11, GameCanvas.screenWidth - 22, GameCanvas.screenHeight - 22);
         if (this.customDialogImage != null) {
            var1.drawImage(this.customDialogImage, GameCanvas.screenWidth - this.customDialogImage.getWidth() >> 1, var14 + 6, 0);
            var14 += this.customDialogImage.getHeight() + TextRenderer.fontHeight + var17;
         }

         for (int var18 = 0; var18 < this.customDialogText.length; var18++) {
            TextRenderer.getFontRenderer(TextRenderer.colorHighlight).drawText(this.customDialogText[var18], GameCanvas.screenWidth >> 1, var14 + var18 * TextRenderer.fontHeight, 2, var1, TextRenderer.charWidth, TextRenderer.fontHeight);
         }
      }

      var1.setClip(-1000, -1000, 2000, 2000);
   }

   public final void logout() {
      this.isLoggedIn = false;
      BigTwoGameScreen.instance = null;
      BuddyListScreen.resetPendingChat();
      this.clearAllScreens();
      this.showScreen(this.loginScreen);
      this.loginScreen.startSlide(-1);
      this.inviteConferenceScreen.clearBuddyList();
      this.buddyListScreen.o();
      if (this.loginYahooScreen != null) {
         this.loginYahooScreen.g();
      }

      int var1 = ConnectionManager.dataUsage;
      int var2 = ConnectionManager.zeroDataUsage;
      int var3 = ConnectionManager.zeroDataUsage + var1;
      Packet var4 = new Packet(42, 2);
      MessageHandler.writeInt(var3, var4);
      ConnectionManager.sendPacket(var4);
      if (var1 > 0) {
         var1 = var1 / 1024 + 1;
      }

      if (var2 > 0) {
         var2 = var2 / 1024 + 1;
      }

      this.showCenterPopup(new String[]{"Dung lượng internet", var1 + var2 + " Kb"});
      ConnectionManager.dataUsage = 0;
      ConnectionManager.zeroDataUsage = 0;
      ConnectionManager.disconnect();

      try {
         Thread.sleep(50L);
      } catch (InterruptedException var5) {
      }

      System.gc();
   }

   public final void showChatRoomList() {
      this.inviteConferenceScreen.wrapTitle(this.screenWidth - 30);
      this.showScreen(this.inviteConferenceScreen);
      this.removeScreen(this.buddyListScreen);
      this.buddyListScreen.buddyList.setMarkMode(true);
      this.buddyListScreen.buddyList.actionTertiary = this.buddyListScreen.buddyList.markAction;
      this.switchToScreen(this.inviteConferenceScreen);
   }

   public final void showFriendsList() {
      this.buddyListScreen.wrapTitle(this.screenWidth - 30);
      this.removeScreen(this.inviteConferenceScreen);
      this.showScreen(this.buddyListScreen);
      this.buddyListScreen.buddyList.setMarkMode(false);
      this.buddyListScreen.buddyList.actionTertiary = this.buddyListScreen.buddyList.selectAction;
   }

   private IAction getCloseAction() {
      if (this.closeAction == null) {
         this.closeAction = new thien_ea(this);
      }

      return this.closeAction;
   }

   private UIAction createCancelAction(String var1) {
      if (this.cancelAction == null) {
         this.cancelAction = new UIAction("", this.getCloseAction());
      }

      this.cancelAction.label = var1;
      return this.cancelAction;
   }

   public final PopupDialogLayout showMessage(String var1) {
      return this.showCenterDialog(var1, null, this.createCancelAction(TextConstant.cancel()), null);
   }

   public final PopupDialogLayout showConfirmDialog(String var1, IAction var2) {
      return this.showCenterDialog(TextRenderer.splitText(var1, GameCanvas.screenWidth - 30, TextRenderer.charWidth), new UIAction("OK", var2), new UIAction("", var2), this.createCancelAction(TextConstant.cancel()));
   }

   public final void showInfoDialog(String var1, IAction var2) {
      this.showCenterDialog(var1, null, new UIAction("OK", var2), null);
   }

   public final void showSimpleDialog(String var1) {
      this.showCenterPopup(TextRenderer.splitText(var1, GameCanvas.screenWidth - 30, TextRenderer.charWidth));
   }

   public final void showCenterPopup(String[] var1) {
      if (this.okAction == null) {
         this.okAction = new UIAction("", this.getCloseAction());
      }

      this.showCenterDialog(var1, this.okAction, this.createCancelAction("OK"), null);
   }

   public final void removeScreen(Screen var1) {
      int var2 = this.screenStack.size();

      while (--var2 >= 0) {
         if (this.screenStack.elementAt(var2).equals(var1)) {
            if (var2 <= this.currentScreenIndex) {
               this.currentScreenIndex--;
               if (this.currentScreenIndex < 0) {
                  this.currentScreenIndex = 0;
               }
            }

            this.screenStack.removeElementAt(var2);
            System.gc();
            this.screenCount = this.screenStack.size();
         }
      }

      this.updateActiveScreen();
   }

   private void clearAllScreens() {
      this.screenStack.removeAllElements();
      this.currentScreenIndex = 0;
      this.screenCount = 0;
      this.activeScreen = null;
   }

   public final Screen findScreenByTitle(String var1) {
      int var2 = this.screenCount;

      while (--var2 >= 0) {
         if (((Screen)this.screenStack.elementAt(var2)).title.equals(var1)) {
            return (Screen)this.screenStack.elementAt(var2);
         }
      }

      return null;
   }

   private void closeSidePopup(boolean var1) {
      if (!var1 && this.sidePopupQueue.size() > 1) {
         this.sidePopupQueue.removeElementAt(this.sidePopupQueue.size() - 1);
      } else {
         this.sidePopupQueue.removeAllElements();
         this.isShowingSidePopup = false;
      }
   }

   //Chế độ layout (0 = left, 1 = right, 2 = center)
   public final void showSideMenu(PopupSideElementData popupSideElementData, int positionMode) {
      if (!this.isShowingDialog) {
         if (!this.isShowingSidePopup) {
            this.sidePopupQueue.removeAllElements();
         }

         this.isShowingSidePopup = true;
         popupSideElementData.positionMode = positionMode;
         byte var3;
         if (this.screenWidth > 300) {
            var3 = 0;
         } else if (this.screenWidth <= 300 && this.screenWidth >= 170) {
            var3 = 70;
         } else {
            var3 = 100;
         }

         int var4 = 0;
         int var5 = 0;
         if (this.sidePopupQueue.size() > 0) {
            PopupSideElementData var6;
            var4 = (var6 = (PopupSideElementData)this.sidePopupQueue.lastElement()).d;
            var5 = var6.e;
         }

         popupSideElementData.g = 10 + popupSideElementData.popupSideElements.size() * this.itemHeight;
         popupSideElementData.f = 126;
         if (this.sidePopupQueue.size() == 0) {
            if (positionMode == 0) {
               this.isRightAligned = false;
               popupSideElementData.d = 1;
            } else if (positionMode == 1) {
               this.isRightAligned = true;
               popupSideElementData.d = this.screenWidth - popupSideElementData.f - 2;
            } else if (positionMode == 2) {
               this.isRightAligned = false;
               popupSideElementData.d = (this.screenWidth >> 1) - (popupSideElementData.f >> 1);
            }

            popupSideElementData.e = this.screenHeight - topMargin - popupSideElementData.g;
            popupSideElementData.h = popupSideElementData.d;
            popupSideElementData.i = this.screenHeight - topMargin;
         } else if (this.sidePopupQueue.size() > 0) {
            if (this.isRightAligned) {
               if (this.sidePopupQueue.size() > 1 && var4 - popupSideElementData.f + var3 < 0) {
                  this.isRightAligned = false;
                  popupSideElementData.d = var4 + 126 - var3;
               } else {
                  popupSideElementData.d = var4 - popupSideElementData.f + var3;
               }
            } else {
               if (this.sidePopupQueue.size() > 1 && var4 + 126 - var3 + popupSideElementData.f > this.screenWidth) {
                  this.isRightAligned = true;
                  popupSideElementData.d = var4 - popupSideElementData.f + var3;
               } else {
                  popupSideElementData.d = var4 + 126 - var3;
               }

               if (((PopupSideElementData)this.sidePopupQueue.firstElement()).positionMode == 2) {
                  popupSideElementData.d = (this.screenWidth >> 1) - (popupSideElementData.f >> 1);
               }
            }

            if (popupSideElementData.d < 0) {
               popupSideElementData.d = 0;
            }

            PopupSideElementData var8 = (PopupSideElementData)this.sidePopupQueue.lastElement();
            if ((positionMode = var5 + var8.c * this.itemHeight) + popupSideElementData.g > this.screenHeight - topMargin) {
               popupSideElementData.e = this.screenHeight - topMargin - popupSideElementData.g;
            } else {
               popupSideElementData.e = positionMode;
            }

            popupSideElementData.i = popupSideElementData.e;
            if (this.isRightAligned) {
               popupSideElementData.h = popupSideElementData.d + popupSideElementData.f;
            } else {
               popupSideElementData.h = popupSideElementData.d - popupSideElementData.f;
            }
         }

         popupSideElementData.c = 0;
         this.sidePopupQueue.addElement(popupSideElementData);
      }
   }

   public final void handleInput(boolean[] var1, boolean[] var2, int[] var3) {
      this.frameCounter++;
      if (this.frameCounter >= 100000) {
         this.frameCounter = 0;
      }

      if (this.frameCounter % 500 == 0 && ConnectionManager.isConnected) {
         MessageHandler.c();
      }

      if (this.loginAction != null) {
         this.loginAction.action();
         this.loginAction = null;
      }

      if (isShowingAnimation && ++animationCounter == 270) {
         animationCounter = 0;
         isShowingAnimation = false;
      }

      GameManager var4 = this;
      if (this.isShowingCustomDialog) {
         this.customDialogTimer--;
         if (this.customDialogTimer <= 0) {
            this.isShowingCustomDialog = false;
         }
      }

      if (this.messageQueue != null) {
         for (int var5 = this.messageQueue.size() - 1; var5 >= 0; var5--) {
            MessageHandler var6;
            if ((var6 = (MessageHandler)var4.messageQueue.elementAt(var5)) != null) {
               if ((long)var4.frameCounter % var6.c == 0L) {
                  var6.e = true;
               }

               if (var6.e && var4.notificationStates[1] == 0) {
                  var6.e = false;
                  var4.showNotification(var6.a, var6.b, 1);
                  var4.notificationSpeeds[1] = (int)var6.d;
               }
            }
         }
      }

      var4 = this;

      for (int var18 = 0; var18 < 3; var18++) {
         if (var4.notificationStates[var18] > 0) {
            if (var18 == 1) {
               var4.notificationX[var18] = var4.notificationX[var18] - var4.notificationSpeeds[var18];
               if (var4.notificationX[var18] < -var4.notificationWidths[var18]) {
                  var4.notificationStates[var18] = 0;
               }
            } else if (var18 == 0) {
               if (var4.notificationStates[var18] < var4.notificationHeights[var18]) {
                  if (var4.notificationEndY[var18] > var4.notificationY[var18]) {
                     var4.notificationEndY[var18]--;
                  }
               } else if (var4.notificationStates[var18] > 100 - var4.notificationHeights[var18]) {
                  var4.notificationEndY[var18]++;
               }

               var4.notificationStates[var18]++;
               if (var4.notificationStates[var18] > 100) {
                  var4.notificationStates[var18] = 0;
               }
            } else if (var18 == 2) {
               if (var4.notificationStates[var18] < var4.notificationHeights[var18]) {
                  if (var4.notificationEndY[var18] < var4.notificationY[var18]) {
                     var4.notificationEndY[var18]++;
                  }
               } else if (var4.notificationStates[var18] > 100 - var4.notificationHeights[var18]) {
                  var4.notificationEndY[var18]--;
               }

               var4.notificationStates[var18]++;
               if (var4.notificationStates[var18] > 100) {
                  var4.notificationStates[var18] = 0;
               }
            }
         }
      }

      if (this.sidePopupQueue.size() > 0) {
         PopupSideElementData var19;
         if ((var19 = (PopupSideElementData)this.sidePopupQueue.lastElement()).i > var19.e) {
            int var28;
            if ((var28 = var19.i - var19.e >> 1) <= 0) {
               var28 = 1;
            }

            var19.i -= var28;
         }

         if (var19.h != var19.d) {
            int var29;
            if ((var29 = BuddyListControl.absoluteValue(var19.d - var19.h) >> 1) <= 0) {
               var29 = 1;
            }

            var19.h = var19.h + (this.isRightAligned ? -var29 : var29);
         }
      }

      if (this.emoticonDrawY > this.emoticonAreaY) {
         int var20;
         if ((var20 = this.emoticonDrawY - this.emoticonAreaY >> 1) <= 0) {
            var20 = 1;
         }

         this.emoticonDrawY -= var20;
      }

      this.activeScreen.updateSlideAnimation();
      if (GameCanvas.isTouchReleased) {
         if (GameCanvas.touchY > GameCanvas.screenHeight - topMargin) {
            if (GameCanvas.touchX < GameCanvas.screenWidth / 3) {
               var1[17] = true;
            } else if (GameCanvas.touchX > 2 * GameCanvas.screenWidth / 3) {
               var1[18] = true;
            } else {
               var1[16] = true;
            }
         } else if (!this.isShowingDialog) {
            if (this.isShowingSidePopup) {
               PopupSideElementData var10 = (PopupSideElementData)this.sidePopupQueue.lastElement();
               if (GameCanvas.touchX >= var10.d && GameCanvas.touchX <= var10.d + var10.f && GameCanvas.touchY <= var10.e + var10.g && GameCanvas.touchY >= var10.e) {
                  int var22;
                  if ((var22 = (GameCanvas.touchY - var10.e) / this.itemHeight) < 0) {
                     var22 = 0;
                  }

                  if (var22 >= var10.popupSideElements.size()) {
                     var22 = var10.popupSideElements.size() - 1;
                  }

                  var10.c = var22;
                  var1[16] = true;
               } else {
                  this.closeSidePopup(false);
               }
            } else if (this.isShowingEmoticonPicker) {
               if (GameCanvas.touchX >= this.emoticonAreaX && GameCanvas.touchX <= this.emoticonAreaX + this.emoticonAreaWidth && GameCanvas.touchY <= this.emoticonAreaY + this.emoticonAreaHeight && GameCanvas.touchY >= this.emoticonAreaY) {
                  int var9 = (GameCanvas.touchX - this.emoticonAreaX - 5) / 18;
                  int var21 = (GameCanvas.touchY - this.emoticonAreaY - 5) / 18;
                  if (var9 < 0) {
                     var9 = 0;
                  }

                  if (var9 > 5) {
                     var9 = 5;
                  }

                  if (var21 < 0) {
                     var21 = 0;
                  }

                  if (var21 > 6) {
                     var21 = 6;
                  }

                  if (var9 == this.emoticonX && var21 == this.emoticonY) {
                     var1[16] = true;
                  } else {
                     this.emoticonX = var9;
                     this.emoticonY = var21;
                  }
               } else {
                  this.isShowingEmoticonPicker = false;
               }
            } else if (GameCanvas.touchY <= 0 || GameCanvas.touchY >= topMargin) {
               this.activeScreen.onTouchPress(GameCanvas.touchX, GameCanvas.touchY - Screen.headerHeight);
            } else if (GameCanvas.touchX < touchAreaWidth) {
               this.previousScreen();
               var1[14] = false;
            } else if (GameCanvas.touchX > GameCanvas.screenWidth - touchAreaWidth) {
               this.nextScreen();
               var1[15] = false;
            }
         }

         GameCanvas.isTouchReleased = false;
      }

      if (GameCanvas.isTouchPressed && !this.isShowingDialog) {
         this.activeScreen.onTouchRelease(GameCanvas.touchX, GameCanvas.touchY - Screen.headerHeight);
         GameCanvas.isTouchPressed = false;
      }

      if (GameCanvas.isTouchActive && !this.isShowingDialog) {
         this.activeScreen.onTouchDrag(GameCanvas.touchX, GameCanvas.touchY - Screen.headerHeight);
      }

      if (GameCanvas.isTouchDragged && !this.isShowingDialog) {
         this.activeScreen.onTouchMove(GameCanvas.touchX, GameCanvas.touchY - Screen.headerHeight);
         GameCanvas.isTouchDragged = false;
      }

      if (this.isShowingDialog) {
         PopupDialogLayout var17 = (PopupDialogLayout)this.dialogQueue.elementAt(0);
         if (var1[17] && var17.leftAction != null) {
            var17.leftAction.actionHandler.action();
         }

         if (var1[18] && var17.rightAction != null) {
            var17.rightAction.actionHandler.action();
         }

         if (var1[16] && var17.centerAction != null) {
            var17.centerAction.actionHandler.action();
         }

         GameCanvas.resetKeys();
      } else if (this.isShowingSidePopup) {
         if (var1[12] || var2[12]) {
            PopupSideElementData var16;
            (var16 = (PopupSideElementData)this.sidePopupQueue.lastElement()).c--;
            if (var16.c < 0) {
               var16.c = var16.popupSideElements.size() - 1;
            }
         } else if (var1[13] || var2[13]) {
            PopupSideElementData var15;
            (var15 = (PopupSideElementData)this.sidePopupQueue.lastElement()).c++;
            if (var15.c > var15.popupSideElements.size() - 1) {
               var15.c = 0;
            }
         } else if (var1[14]) {
            this.closeSidePopup(false);
         } else if (var1[15]) {
            PopupSideElementData var13;
            UIAction var26;
            if ((var26 = (UIAction)(var13 = (PopupSideElementData)this.sidePopupQueue.lastElement()).popupSideElements.elementAt(var13.c)).popupSideElementData != null) {
               this.showSideMenu(var26.popupSideElementData, -1);
            }
         } else if (var1[16] || var1[17]) {
            PopupSideElementData var14;
            UIAction var27;
            if ((var27 = (UIAction)(var14 = (PopupSideElementData)this.sidePopupQueue.lastElement()).popupSideElements.elementAt(var14.c)).popupSideElementData == null) {
               if (var27.actionHandler != null) {
                  var27.actionHandler.action();
                  this.closeSidePopup(true);
               }
            } else {
               this.showSideMenu(var27.popupSideElementData, -1);
            }
         } else if (var1[18]) {
            this.closeSidePopup(true);
         }

         GameCanvas.resetKeys();
      } else if (!this.isShowingEmoticonPicker) {
         boolean var12 = var1[14];
         boolean var25 = var1[15];
         this.activeScreen.isVisible = false;
         if (this.activeScreen.handleInput(var1, var2, var3)) {
            if (var12) {
               var1[14] = false;
               this.previousScreen();
               return;
            }

            if (var25) {
               var1[15] = false;
               this.nextScreen();
            }
         }
      } else {
         if (var1[17] || var1[16]) {
            this.isShowingEmoticonPicker = false;

            try {
               Screen var11 = this.activeScreen;
               if (this.activeScreen == BigTwoGameScreen.instance && BigTwoGameScreen.isGameStarted) {
                  String var23 = TextRenderer.emoticons[this.emoticonY * 6 + this.emoticonX];
                  if (BigTwoGameScreen.selectedTableType == 1) {
                     MessageHandler.a(1, BigTwoGameScreen.gameRoomId, BuddyListScreen.currentGroupName, var23);
                  }
               }

               if (isTextFieldControl(var11.padding)) {
                  ((TextField)var11.getControlById(2)).insertText(TextRenderer.emoticons[this.emoticonY * 6 + this.emoticonX]);
               } else {
                  ChatRoomScreen var24;
                  (var24 = (ChatRoomScreen)this.activeScreen).inputTextField.insertText(TextRenderer.emoticons[this.emoticonY * 6 + this.emoticonX]);
               }
            } catch (Exception var7) {
            }
         }

         if (var1[18]) {
            this.isShowingEmoticonPicker = false;
         }

         if (var1[12] || var2[12]) {
            this.navigateEmoticonUp(true);
         }

         if (var1[13] || var2[13]) {
            this.emoticonY++;
            if (this.emoticonY > 6) {
               this.emoticonY = 0;
               this.navigateEmoticonRight(false);
            }
         }

         if (var1[14] || var2[14]) {
            this.emoticonX--;
            if (this.emoticonX < 0) {
               this.emoticonX = 5;
               this.navigateEmoticonUp(false);
            }
         }

         if (var1[15] || var2[15]) {
            this.navigateEmoticonRight(true);
         }

         GameCanvas.resetKeys();
      }
   }

   private void navigateEmoticonUp(boolean var1) {
      this.emoticonY--;
      if (this.emoticonY < 0) {
         this.emoticonY = 6;
         if (var1) {
            this.emoticonX--;
            if (this.emoticonX < 0) {
               this.emoticonX = 5;
            }
         }
      }
   }

   private void navigateEmoticonRight(boolean var1) {
      this.emoticonX++;
      if (this.emoticonX > 5) {
         this.emoticonX = 0;
         if (var1) {
            this.emoticonY++;
            if (this.emoticonY > 6) {
               this.emoticonY = 0;
            }
         }
      }
   }

   private void nextScreen() {
      if (this.screenCount > 1) {
         this.currentScreenIndex++;
         if (this.currentScreenIndex >= this.screenCount) {
            this.currentScreenIndex = 0;
         }

         this.updateActiveScreen();
         this.activeScreen.startSlide(1);
      }
   }

   private void previousScreen() {
      if (this.screenCount > 1) {
         this.currentScreenIndex--;
         if (this.currentScreenIndex < 0) {
            this.currentScreenIndex = this.screenCount - 1;
         }

         this.updateActiveScreen();
         this.activeScreen.startSlide(-1);
      }
   }

   private void goToScreen(int var1) {
      this.currentScreenIndex = var1;
      this.updateActiveScreen();
   }

   public final void goToLastScreen() {
      this.goToScreen(this.screenCount - 1);
   }

   public final void goToFirstScreen() {
      this.goToScreen(0);
   }

   public static void focusBuddyList() {
      instance.switchToScreen(instance.buddyListScreen);
   }

   public final void switchToScreenByTitle(String var1) {
      int var2 = this.screenCount;

      do {
         var2--;
      } while (var2 >= 0 && !((Screen)this.screenStack.elementAt(var2)).title.equals(var1));

      this.currentScreenIndex = var2;
      this.updateActiveScreen();
   }

   public final void switchToScreen(Screen var1) {
      if (var1 == null) {
         this.goToScreen(0);
      } else {
         int var2 = this.screenCount;

         do {
            var2--;
         } while (var2 >= 0 && !((Screen)this.screenStack.elementAt(var2)).equals(var1));

         if (var2 == -1) {
            this.goToScreen(0);
         } else {
            this.currentScreenIndex = var2;
            this.updateActiveScreen();
         }
      }
   }

   private boolean containsScreen(Screen var1) {
      int var2 = this.screenCount;

      while (--var2 >= 0) {
         if (((Screen)this.screenStack.elementAt(var2)).equals(var1)) {
            return true;
         }
      }

      return false;
   }

   public static int bytesToInt(byte var0, byte var1, byte var2, byte var3) {
      return var0 << 24 & 0xFF000000 | var1 << 16 & 0xFF0000 | var2 << 8 & 0xFF00 | var3 & 0xFF;
   }

   private static byte[] intToBytes(int var0) {
      byte[] var1;
      (var1 = new byte[4])[0] = (byte)(var0 >> 24);
      var1[1] = (byte)(var0 >> 16 & 0xFF);
      var1[2] = (byte)(var0 >> 8 & 0xFF);
      var1[3] = (byte)var0;
      return var1;
   }

   private static void writeString(ByteArrayOutputStream var0, String var1) throws IOException {
      var0.write(var1.getBytes());
      var0.write(nullByte);
   }

   private static void writeInt(ByteArrayOutputStream var0, int var1) throws IOException {
      var0.write(intToBytes(var1));
   }

   private static int readInt(ByteArrayInputStream var0) {
      return bytesToInt((byte)var0.read(), (byte)var0.read(), (byte)var0.read(), (byte)var0.read());
   }

   private static String readString(ByteArrayInputStream var0) {
      String var1 = "";

      int var2;
      while ((var2 = var0.read()) != 0) {
         var1 = var1 + (char)((byte)var2);
      }

      return var1;
   }

   private static void saveChecksum(int var0, boolean var1) {
      Xuka.writeRecord(var1 ? "yahoocs" : "vitalkcs", intToBytes(var0));
   }

   public static int getChecksumValue(boolean var0) {
      return Xuka.readIP4toInt(var0 ? "yahoocs" : "vitalkcs");
   }

   private static boolean loadChecksum(ContactDataSource var0, boolean var1, String var2) {
      ByteArrayOutputStream var3 = new ByteArrayOutputStream();
      Vector var9 = var0.groups;

      try {
         writeInt(var3, var9.size());

         for (int var4 = 0; var4 < var9.size(); var4++) {
            ContactGroup var5 = (ContactGroup)var9.elementAt(var4);
            writeString(var3, var5.getGroupName());
            Vector var10 = var5.contacts;
            writeInt(var3, var10.size());

            for (int var6 = 0; var6 < var10.size(); var6++) {
               ContactEntry var7 = (ContactEntry)var10.elementAt(var6);
               writeString(var3, var7.contactId);
               writeString(var3, var7.displayName);
               writeInt(var3, var7.userLevel);
            }
         }

         Xuka.writeRecord((var1 ? "ybuddy" : "vbuddy") + var2, var3.toByteArray());
         return true;
      } catch (Exception var8) {
         return false;
      }
   }

   public static ContactDataSource loadBuddyList(boolean var0, String var1) {
      byte[] var9;
      if ((var9 = Xuka.readRecord((var0 ? "ybuddy" : "vbuddy") + var1)) == null) {
         return null;
      } else {
         ByteArrayInputStream var10 = new ByteArrayInputStream(var9);
         ContactDataSource var11 = new ContactDataSource();

         try {
            var11.groups = new Vector();
            int var2 = readInt(var10);

            for (int var3 = 0; var3 < var2; var3++) {
               ContactGroup var4;
               (var4 = new ContactGroup(readString(var10))).contacts = new Vector();
               int var5 = readInt(var10);

               for (int var6 = 0; var6 < var5; var6++) {
                  ContactEntry var7;
                  (var7 = new ContactEntry()).contactId = readString(var10);
                  var7.displayName = readString(var10);
                  var7.userLevel = readInt(var10);
                  var4.addContact(var7);
               }

               var11.groups.addElement(var4);
            }

            return var11;
         } catch (Exception var8) {
            return null;
         }
      }
   }

   public final void handleYahooMessage(String var1, String var2, String var3) {
      String var4 = "Y! " + var1;
      ChatRoomScreen var5;
      if ((var5 = (ChatRoomScreen)this.findScreenByTitle(var4)) == null) {
         (var5 = new ChatRoomScreen(var4, true, false, null)).chatPartnerStatus = var1;
         var5.chatPartnerName = var1;
         this.showScreen(var5);
      }

      if (!var5.title.equals(this.activeScreen.title)) {
         this.vibrate();
      }

      var5.messageList.addUserMessage(var1 + " (" + var3 + ")", var2, 1);
      var5.messageList.scrollToBottom();
      var5.isVisible = true;
   }

   public final void handlePrivateMessage(String var1, String var2, String var3) {
      if (!isUserBlocked(var1)) {
         ChatRoomScreen var4;
         if (!(var4 = this.createChatRoom(var1)).title.equals(this.activeScreen.title)) {
            this.vibrate();
         }

         var4.messageList.addUserMessage(var4.chatPartnerStatus + " (" + var3 + ")", var2, 1);
         var4.messageList.scrollToBottom();
         var4.isVisible = true;
      }
   }

   public final ChatRoomScreen createChatRoom(String var1) {
      ChatRoomScreen var2;
      if ((var2 = (ChatRoomScreen)this.findScreenByTitle(var1)) == null) {
         DisplayItem var3;
         if ((var3 = this.buddyListScreen.buddyList.findDisplayItem(var1)) == null) {
            var2 = new ChatRoomScreen(var1, false, false, null);
         } else {
            (var2 = new ChatRoomScreen(var1, false, false, var3.additionalData)).setCurrentRoomName(Integer.toString(var3.sourceEntry.additionalFlags));
         }

         if (var3 != null && var3.statusText != null && !var3.statusText.equals("")) {
            var2.chatPartnerStatus = var3.statusText;
         } else {
            var2.chatPartnerStatus = var1;
         }

         this.showScreen(var2);
      }

      return var2;
   }

   public final void receivePrivateMessage(String var1, String var2) {
      if (!isUserBlocked(var1)) {
         ChatRoomScreen var3;
         if (!(var3 = this.createChatRoom(var1)).title.equals(this.activeScreen.title)) {
            String var4 = TextRenderer.wrapText(var2, GameCanvas.screenWidth - GameCanvas.screenWidth / 3, TextRenderer.charWidth);
            this.showNotification(var1 + " chat: " + var4 + "...", (Image) null, 1);
            var3.isScrolling = true;
            this.vibrate();
         }

         boolean var5 = var3.messageList.isAtBottom();
         var3.messageList.addUserMessage(var3.chatPartnerStatus, var2, 1);
         if (var5) {
            var3.messageList.scrollToBottom();
         }

         var3.isVisible = true;
      }
   }

   public final void receiveYahooMessage(String var1, String var2) {
      String var3 = "Y! " + var1;
      ChatRoomScreen var4;
      if ((var4 = (ChatRoomScreen)this.findScreenByTitle(var3)) == null) {
         (var4 = new ChatRoomScreen(var3, true, false, null)).chatPartnerStatus = var1;
         var4.chatPartnerName = var1;
         this.showScreen(var4);
      }

      if (!var4.title.equals(this.activeScreen.title)) {
         var3 = TextRenderer.wrapText(var2, GameCanvas.screenWidth - GameCanvas.screenWidth / 3, TextRenderer.charWidth);
         this.showNotification(var1 + " chat: " + var3 + "...", (Image)null, 1);
         var4.isScrolling = true;
         this.vibrate();
      }

      boolean var6 = var4.messageList.isAtBottom();
      var4.messageList.addUserMessage(var1, var2, 1);
      if (var6) {
         var4.messageList.scrollToBottom();
      }

      var4.isVisible = true;
   }

   public final void registrationError() {
      this.closeTopDialog();
      this.showCenterDialog(TextConstant.registrationError(), null, new UIAction("OK", new thien_eb(this)), null);
   }

   public final void registrationSuccess() {
      this.closeTopDialog();
      this.loginScreen.usernameField.setText(this.registerScreen.G);
      this.loginScreen.passwordField.setText(this.registerScreen.F);
      Xuka.saveUserID(this.registerScreen.G);
      Xuka.savePassword(this.registerScreen.F);
      this.showScreen(this.loginScreen);
      this.loginScreen.selectControl(this.loginScreen.usernameField);
      this.removeScreen(this.registerScreen);
   }

   public final void wrongCredentials() {
      this.closeTopDialog();
      this.showSimpleDialog(TextConstant.wrongNameOrPassword());
   }

   public final void connectionError() {
      this.hasConnectionError = true;
      if (GameCanvas.gameState == 1) {
         this.closeTopDialog();
         this.showCenterDialog(TextConstant.connectionError(), null, null, new UIAction(TextConstant.close(), new thien_ec(this)));
      }
   }

   public final void updateBuddyStatus(String var1, String var2, int var3) {
      var2 = ContentFilter.filterProfanity(var2);
      switch (var3) {
         case 1:
            if (this.buddyListScreen.buddyList != null) {
               this.buddyListScreen.buddyList.updateContactMessage(var1, var2, 1);
               return;
            }
            break;
         case 2:
            try {
               this.loginYahooScreen.w.updateContactMessage(var1, var2, 1);
               return;
            } catch (Exception var4) {
            }
      }
   }

   public final void setBuddyOnlineStatus(String var1, int var2, int var3) {
      switch (var3) {
         case 1:
            if (this.buddyListScreen.buddyList.updateContactStatus(var1, var2)) {
               String var9 = var2 == 1 ? TextConstant.isOnline() : TextConstant.isOffline();
               int var11 = this.activeScreen instanceof ChatRoomScreen ? 2 : 0;
               this.showNotification(var1 + var9, var2 == 1 ? BuddyListControl.statusIcons[1] : BuddyListControl.statusIcons[0], var11);

               try {
                  ChatRoomScreen var12;
                  if ((var12 = (ChatRoomScreen)this.findScreenByTitle(var1)) != null) {
                     var12.messageList.addMessage(var1 + var9, var2 == 1 ? 1 : 2);
                     var12.messageList.scrollToBottom();
                     return;
                  }
               } catch (Exception var7) {
                  return;
               }
            }
            break;
         case 2:
            try {
               if (this.loginYahooScreen != null && this.loginYahooScreen.w != null && this.loginYahooScreen.w.updateContactStatus(var1, var2)) {
                  String var8 = var2 == 1 ? TextConstant.isOnline() : TextConstant.isOffline();
                  int var4 = this.activeScreen instanceof ChatRoomScreen ? 2 : 0;
                  this.showNotification("Y! " + var1 + var8, var2 == 1 ? BuddyListControl.statusIcons[1] : BuddyListControl.statusIcons[0], var4);

                  try {
                     ChatRoomScreen var10;
                     if ((var10 = (ChatRoomScreen)this.findScreenByTitle("Y! " + var1)) != null) {
                        var10.messageList.addMessage(var1 + var8, var2 == 1 ? 1 : 2);
                        var10.messageList.scrollToBottom();
                        return;
                     }
                  } catch (Exception var5) {
                     return;
                  }
               }
            } catch (Exception var6) {
            }
      }
   }

   public final void showErrorMessage(String var1) {
      this.showSimpleDialog(var1);
   }

   public final void handleDisconnect() {
      BigTwoGameScreen.instance = null;
      this.clearAllScreens();
      this.showScreen(this.loginScreen);
      this.closeTopDialog();
      this.showNotification(TextConstant.disconnected(), (Image)null, 0);
   }

   public final void khongTheThemBan(String var1) {
      this.showSimpleDialog(TextConstant.addFriendFailed() + var1);
   }

   public final void tuChoiKetBan(String var1) {
      this.showSimpleDialog(var1 + TextConstant.refusedToBeAdded());
   }

   public final void addFriendToGroup(int var1, ContactEntry var2, String var3) {
      this.buddyListScreen.buddyList.contactDataSource.addContactToGroup(var3, var2);
      this.buddyListScreen.buddyList.rebuildVisibleItems();
      BuddyListControl.cleanup();
      loadChecksum(this.buddyListScreen.buddyList.contactDataSource, false, BuddyListScreen.currentGroupName);
      saveChecksum(var1, false);
   }

   public final void dongYKetBan(String var1, int var2, String var3, String var4, int var5) {
      this.buddyListScreen.buddyList.updateContactMessage(var1, var4, 2);
      this.buddyListScreen.buddyList.updateContactStatus(var1, var2);
      this.buddyListScreen.buddyList.updateContactMessage(var1, var3, 1);
      saveChecksum(var5, false);
      this.showSimpleDialog(TextConstant.add2() + var1 + TextConstant.success());
   }

   public final void cannotCreateConference() {
      this.showSimpleDialog(TextConstant.cannotCreateConference());
   }

   public final void inviteToConference(String var1, String var2) {
      this.closeTopDialog();
      this.inviteConferenceScreen.roomId = var1;
      this.inviteConferenceScreen.roomName = var2;
      this.showChatRoomList();
   }

   public final void createOrJoinConference(String var1, String[] var2, String var3) {
      var3 = var3 + " " + var1;
      ChatRoomScreen var4;
      (var4 = new ChatRoomScreen(var3, false, true, null)).subtitle = var1;
      int var5 = this.screenCount;

      while (--var5 >= 0) {
         Screen var6;
         if ((var6 = (Screen)this.screenStack.elementAt(var5)).subtitle == var1) {
            var4 = (ChatRoomScreen)var6;
         }
      }

      if (var2 != null) {
         this.inviteeCount = var2.length;

         for (int var8 = 0; var8 < this.inviteeCount; var8++) {
            var4.messageList.addMessage(TextConstant.inviting() + var2[var8] + "...", 1);
         }

         var4.messageList.scrollToBottom();
      }

      this.showScreen(var4);
      this.switchToScreenByTitle(var3);
   }

   public final void showConferenceInviteDialog(String var1, String var2, String var3) {
      if (!isUserBlocked(var1)) {
         this.showCenterDialog(
            new String[]{var1 + TextConstant.inviteConference2(), var3},
            new UIAction(TextConstant.cancel(), new thien_ed(this)),
            new UIAction("OK", new thien_ee(this, var2, var1, var3)),
            new UIAction(TextConstant.cancel(), new thien_ef(this, var2, var1))
         );
      }
   }

   public final void handleUserJoinedConference(String var1, String var2) {
      int var3 = this.screenCount;

      while (--var3 >= 0) {
         Screen var4;
         if ((var4 = (Screen)this.screenStack.elementAt(var3)).subtitle.equals(var2)) {
            ChatRoomScreen var5;
            (var5 = (ChatRoomScreen)var4).messageList.addMessage(var1 + TextConstant.hasJoined(), 2);
            var5.messageList.scrollToBottom();
         }
      }
   }

   public final void handleUserRefusedConference(String var1, String var2) {
      int var3 = this.screenCount;

      while (--var3 >= 0) {
         Screen var4;
         if ((var4 = (Screen)this.screenStack.elementAt(var3)).subtitle.equals(var2)) {
            ChatRoomScreen var5;
            (var5 = (ChatRoomScreen)var4).messageList.addMessage(var1 + TextConstant.hasRefused(), 2);
            var5.messageList.scrollToBottom();
         }
      }
   }

   public final void handleUserLeftConference(String var1, String var2) {
      int var3 = this.screenCount;

      while (--var3 >= 0) {
         Screen var4;
         if ((var4 = (Screen)this.screenStack.elementAt(var3)).subtitle.equals(var2)) {
            ChatRoomScreen var5;
            (var5 = (ChatRoomScreen)var4).messageList.addMessage(var1 + TextConstant.hasLeft(), 2);
            var5.messageList.scrollToBottom();
         }
      }
   }

   public final void handleConferenceMessage(String var1, String var2, String var3) {
      if (var1.equals(this.lastMessageSender)) {
         this.messageRepeatCount++;
         if (this.messageRepeatCount > 3) {
            return;
         }
      } else {
         this.lastMessageSender = var1;
         this.messageRepeatCount = 0;
      }

      int var4 = this.screenCount;

      while (--var4 >= 0) {
         Screen var5;
         if ((var5 = (Screen)this.screenStack.elementAt(var4)).subtitle.equals(var2)) {
            ChatRoomScreen var6 = (ChatRoomScreen)var5;
            if (var3.length() > 100) {
               var3 = var3.substring(0, 99) + "...";
            }

            var6.messageList.addUserMessage(var1, var3, 1);
            var6.messageList.scrollToBottom();
            var6.isVisible = true;
         }
      }
   }

   public final void handleMultipleUsersJoinedConference(String var1, String[] var2) {
      int var3 = this.screenCount;

      while (--var3 >= 0) {
         Screen var4;
         if ((var4 = (Screen)this.screenStack.elementAt(var3)).subtitle.equals(var1)) {
            ChatRoomScreen var5 = (ChatRoomScreen)var4;
            this.inviteeCount = var2.length;

            for (int var6 = 0; var6 < this.inviteeCount; var6++) {
               var5.messageList.addMessage(var2[var6] + TextConstant.hasJoined(), 1);
            }

            var5.messageList.scrollToBottom();
            return;
         }
      }
   }

   public final void yahooDisconnected() {
      this.loginYahooScreen.C = false;
      this.loginYahooScreen.a(false);
      this.showNotification(TextConstant.disconnectYahoo(), (Image)null, 0);
   }

   public final void yahooLoginFailed() {
      this.loginYahooScreen.a(false);
      this.showSimpleDialog(TextConstant.wrongYahooIdOrPassword());
   }

   public final void receiveBuzz(String var1) {
      this.receiveYahooMessage(var1, TextConstant.buzz[0]);
      this.vibrate();
   }

   public final Screen getCurrentScreen() {
      return this.activeScreen;
   }

   public final void sendBuzz(String var1) {
      this.receivePrivateMessage(var1, TextConstant.buzz());
      this.vibrate();
   }

   public final void showUpdateDialog(String var1, String var2) {
      this.showCenterDialog(TextConstant.updateNewVersionXYahoo() + var1, new UIAction(TextConstant.download(), new thien_eg(this, var2)), null, new UIAction(TextConstant.cancel(), new thien_dk(this)));
   }

   public final String getCardSyntax() {
      return this.cardSyntax == null ? emptyString : this.cardSyntax;
   }

   public final String getRecoveryInfo() {
      return this.recoveryEmail == null ? emptyString : this.recoveryEmail;
   }

   public final void showTopUpMessage(String var1, String var2, String var3) {
      this.closeTopDialog();
      this.cardSyntax = var2;
      thien_dl var4 = new thien_dl(this);
      thien_dm var5 = new thien_dm(this, var3, var4);
      String var7 = var3 + Xuka.refCode;
      this.showCenterDialog(
         TextRenderer.splitText(var1 + TextConstant.syntax() + var7 + " => " + var2.substring(6), GameCanvas.screenWidth - 30, TextRenderer.charWidth),
         new UIAction("OK", var5),
         null,
         new UIAction(TextConstant.cancel(), var4)
      );
   }

   public final void setRecoveryInfo(String var1, String var2) {
      this.recoveryEmail = var1;
      recoveryPhone = var2;
      if (this.loginScreen != null) {
         this.loginScreen.recoverPassword();
      }
   }

   public final void setUserSessionData(String var1, byte var2, String var3, int var4, int var5) {
      BuddyListScreen.userFullName = var1;
      if (!var1.equals("")) {
         BuddyListScreen.userStatusMessage = BuddyListScreen.userFullName;
      }

      BuddyListScreen.selectedAction = var2;
      BuddyListScreen.lastErrorMessage = var3;
      BuddyListScreen.scrollOffset = var4;
      BuddyListScreen.pendingChatTarget = Integer.toString(var5);
      ChatRoomScreen.refreshPendingChatTarget();
   }

   private static boolean isUserBlocked(String var0) {
      int var1 = blockedUsers.size();

      while (--var1 >= 0) {
         if (((String) blockedUsers.elementAt(var1)).equals(var0)) {
            return true;
         }
      }

      return false;
   }

   public final void showRoomList() {
      if (roomListScreen != null && this.containsScreen(roomListScreen)) {
         roomListScreen.startSlide(1);
         this.switchToScreen(roomListScreen);
      } else {
         MessageHandler.updateRoomList();
      }
   }

   public final void displayYahooLogin() {
      this.initializeYahooLogin();
      if (this.containsScreen(this.loginYahooScreen)) {
         this.switchToScreen(this.loginYahooScreen);
      } else {
         this.loginYahooScreen.a(false);
         this.showScreen(this.loginYahooScreen);
         this.switchToScreen(this.loginYahooScreen);
      }
   }

   private void initializeYahooLogin() {
      if (this.loginYahooScreen == null) {
         this.loginYahooScreen = new LoginYahooScreen();
      }

      this.loginYahooScreen.startSlide(1);
   }

   public final void loginSuccess() {
      String var2;
      if ((var2 = Xuka.readCustomStr(BuddyListScreen.currentGroupName, false)) != null) {
         BuddyListScreen.tempStatusMessage = var2;
         if (BuddyListScreen.userStatus == 1) {
            MessageHandler.a(BuddyListScreen.tempStatusMessage, 1);
         }
      } else {
         BuddyListScreen.tempStatusMessage = "";
      }

      if (BuddyListScreen.tempStatusMessage.length() > 0) {
         MessageHandler.a(BuddyListScreen.tempStatusMessage, 1);
      }

      blockedUsers.removeAllElements();
      MessageHandler.d();
      int var1 = TextConstant.languageId;
      Packet var3 = new Packet(59, 14);
      MessageHandler.writeInt(var1, var3);
      ConnectionManager.sendPacket(var3);
      this.displayHomeScreen();
   }

   public final void displayHomeScreen() {
      this.closeTopDialog();
      if (this.homeScreen == null) {
         this.homeScreen = new HomeScreen();
      }

      this.showScreen(this.homeScreen);
      this.removeScreen(this.loginScreen);
      if (autoLoginYahoo) {
         this.initializeYahooLogin();
         this.loginYahooScreen.a(false);
         this.showScreen(this.loginYahooScreen);
         this.loginYahooScreen.f();
      }

      TextRendererHelper.releaseLogo();
   }

   public final void setBuddyListData(ContactDataSource var1, int var2) {
      saveChecksum(var2, false);
      loadChecksum(var1, false, BuddyListScreen.currentGroupName);
      this.buddyListScreen.buddyList.pleaseWait = TextRenderer.splitText(TextConstant.welcomeToXYahoo(), GameCanvas.screenWidth - 40, TextRenderer.charWidth);
      this.buddyListScreen.buddyList.setDataSource(var1, -1);
      this.closeTopDialog();
   }

   public final void saveYahooChecksum(int var1) {
      saveChecksum(var1, true);
   }

   public final void yahooLoginSuccess() {
      if (LoginYahooScreen.z == 0 && LoginYahooScreen.A != null && LoginYahooScreen.A.length() > 0) {
         MessageHandler.a(LoginYahooScreen.A, 2);
      }

      this.loginYahooScreen.C = true;
      this.loginYahooScreen.a(true);
      if (Xuka.readXpamFlag(LoginYahooScreen.x) == 0) {
         this.loginYahooScreen.h();
      }
   }

   public final void setYahooBuddyList(ContactDataSource var1) {
      loadChecksum(var1, true, LoginYahooScreen.x);
      this.loginYahooScreen.w.setDataSource(var1, -1);
      this.loginYahooScreen.isVisible = true;
      this.loginYahooScreen.w.isLoading = false;
   }

   public final void showAddFriendDialog(String var1) {
      FormScreen var2 = new FormScreen();
      var2.title = TextConstant.addFriend();
      UIFormBuilder.addLabelsAuto(var2, var1 + TextConstant.wantToAddYou());
      TextField var3 = UIFormBuilder.addTextField(var2, TextConstant.toNewGroup(), 0);
      UIDropdown var4 = UIFormBuilder.addDropdown(var2, TextConstant.orExisting(), this.buddyListScreen.buddyList.getGroupNames());
      var4.setChangeHandler(new thien_dq(this, var4, var3));
      if (var4.options != null && var4.options.length != 0) {
         var3.setText(var4.getSelectedItem());
      } else {
         var3.setText("Friends");
      }

      var2.leftCommand = new UIAction(TextConstant.cancel(), new thien_dr(this, var3, var1, var2));
      var2.centerCommand = new UIAction("OK", new thien_ds(this, var3, var1, var2));
      var2.rightCommand = new UIAction(TextConstant.close(), new thien_dt(this, var2));
      var2.selectControl((UIControlBase)var2.controls.elementAt(0));
      this.addScreen(var2);
   }

   public final void a(Vector var1) {
      Screen var2;
      (var2 = new Screen()).title = TextConstant.ignoreList();
      int var3;
      if ((var3 = GameCanvas.screenWidth - 30) > 150) {
         var3 = 180;
      }

      if (var3 < 100) {
         var3 = 100;
      }

      int var4 = GameCanvas.screenWidth - var3 >> 1;
      UITextLabel var6 = new UITextLabel(TextConstant.ignoreList(), var4, 10, TextRenderer.fontHeight);
      int var5 = 10 + 1 + var6.height;
      String[] var7;
      if (var1.size() == 0) {
         (var7 = new String[1])[0] = "---";
      } else {
         var7 = new String[var1.size()];

         for (int var8 = 0; var8 < var1.size(); var8++) {
            var7[var8] = (String)var1.elementAt(var8);
         }
      }

      UIDropdown var16 = new UIDropdown(var7, var4, var5, var3, TextRenderer.fontHeight + 6);
      var5 += 8 + var16.height;
      UITextLabel var9 = new UITextLabel(TextConstant.typeIdToAddDelete(), var4, var5, TextRenderer.fontHeight);
      var5 += 3 + var6.height;
      TextField var15;
      (var15 = new TextField()).setBounds(var4, var5, var3, TextRenderer.fontHeight + 6);
      var5 += 10 + var15.height;
      UIButton var10 = new UIButton(TextConstant.add() + "/" + TextConstant.delete(), var4, var5, var3, TextRenderer.fontHeight + 6);
      var16.changeHandler = new thien_dv(this, var16, var15);
      String var11;
      if (!(var11 = var16.getSelectedItem()).equals("---")) {
         var15.setText(var11);
      }

      var10.actionHandler = new thien_dw(this, var15, var2, var16);
      var2.addControl(var6);
      var2.addControl(var16);
      var2.addControl(var9);
      var2.addControl(var15);
      var2.addControl(var10);
      var2.selectControl(var16);
      var2.leftCommand = new UIAction(TextConstant.cancel(), new thien_dx(this, var2));
      this.showScreen(var2);
      this.goToLastScreen();
      this.closeTopDialog();
   }

   public final void changeUserPassword(boolean var1) {
      if (var1) {
         this.showSimpleDialog(TextConstant.changeSuccess());
      } else {
         this.showSimpleDialog(TextConstant.wrongOldPassword());
      }
   }

   public static boolean isTextFieldControl(int var0) {
      return var0 == 2000 || var0 == 2002 || var0 == 2003 || var0 == 2001;
   }

   public final void handlePlayerMoveAdvanced(int var1, String var2, byte[] var3, long var4, long var6, String var8) {
      try {
         if (var1 == 0) {
            if (var4 <= 0L) {
               var4 = 1L;
            }

            MessageHandler var10 = new MessageHandler(var1, var2, var3, var4 * 25L, var6, var8);
            this.messageQueue.addElement(var10);
            return;
         }

         if (var1 != 1) {
            if (var1 == 2) {
               promoMessage = var2;
               return;
            }

            if (var1 == 3) {
               this.isShowingCustomDialog = true;
               this.customDialogImage = Image.createImage(var3, 0, var3.length);
               this.customDialogText = TextRenderer.splitText(var2, GameCanvas.screenWidth - 50, TextRenderer.charWidth);
               this.customDialogTimer = (int)var6;
               return;
            }
         }
      } catch (Exception var9) {
      }
   }

   public final void acceptAddFriend(String var1) {
      this.showCenterDialog(var1 + TextConstant.addYouHisFriendlist(), new UIAction("OK", new thien_dy(this, var1)), null, new UIAction(TextConstant.cancel(), new thien_dz(this, var1)));
   }

   public final void saveServerConfig(String[] var1, int[] var2) {
      Xuka.saveAllIPs(var1);
      Xuka.saveAllPorts(var2);
      if (!Xuka.readFlag("report", false)) {
         Xuka.saveFlag("report", true);
         if (Xuka.platformName == null) {
            Xuka.platformName = "null";
         }

         MessageHandler.a(0, Xuka.platformName, GameCanvas.screenHeight, Xuka.version);
      }

      MessageHandler.b();
   }

   public final Screen findScreenById(int var1) {
      int var2 = this.screenCount;

      while (--var2 >= 0) {
         Screen var3;
         if ((var3 = (Screen)this.screenStack.elementAt(var2)).padding == var1) {
            return var3;
         }
      }

      return null;
   }

   public final void processRawData(byte[] var1) {
      MessageHandler.processRawPacket(var1);
   }

   public final void handleBinaryData(int var1, byte[] var2) {
      ImageCacheManager.storeImage(var1, var2);
   }

   public final void updateStatusIcons(String var1, int[] var2) {
      if (var1.equals(BuddyListScreen.currentGroupName)) {
         BuddyListScreen.onlineStatusIcons = var2;
      } else {
         int[] var3 = var2;
         String var9 = var1;
         ContactDataSource var8 = this.buddyListScreen.buddyList.contactDataSource;

         for (int var4 = this.buddyListScreen.buddyList.contactDataSource.groups.size() - 1; var4 >= 0; var4--) {
            ContactEntry var5;
            if ((var5 = ((ContactGroup)var8.groups.elementAt(var4)).findContactByName(var9)) != null) {
               var5.permissions = var3;
            }
         }

         this.buddyListScreen.buddyList.rebuildVisibleItems();
      }
   }

   public final void deleteBuddy(String var1, int var2) {
      this.buddyListScreen.buddyList.removeContact(var1);
      loadChecksum(this.buddyListScreen.buddyList.contactDataSource, false, BuddyListScreen.currentGroupName);
      saveChecksum(var2, false);
      this.showSimpleDialog(TextConstant.deleteSuccess());
   }

   public final void moveBuddy(int var1, String var2, String var3) {
      this.showSimpleDialog(TextConstant.moveIdSuccess());
      this.buddyListScreen.buddyList.moveContactToGroup(var2, var3);
      loadChecksum(this.buddyListScreen.buddyList.contactDataSource, false, BuddyListScreen.currentGroupName);
      saveChecksum(var1, false);
   }

   public final void renameGroup(int var1, String var2, String var3) {
      this.buddyListScreen.buddyList.renameGroup(var2, var3);
      this.showSimpleDialog(TextConstant.renameGroupSuccess());
      loadChecksum(this.buddyListScreen.buddyList.contactDataSource, false, BuddyListScreen.currentGroupName);
      saveChecksum(var1, false);
   }

   public final void handleRegistrationData(String[] var1) {
      Screen var2 = this.activeScreen;
      if (this.activeScreen != null && var2 instanceof RegisterScreen) {
         RegisterScreen var3;
         (var3 = (RegisterScreen)var2).b(var1);
      }
   }

   public final void handleCompleteGameResult(
      String var1,
      String var2,
      int var3,
      byte[] var4,
      int var5,
      String[] var6,
      int[] var7,
      long[] var8,
      long[] var9,
      byte[][] var10,
      boolean[] var11,
      String[] var12,
      int[] var13,
      Integer[] var14
   ) {
      BigTwoGameScreen.instance.handlePlayerMove(var2, var3, var4, null, false);
      BigTwoGameScreen.instance.playerReadyStates = var11;
      BigTwoGameScreen.instance.playerRanks = var7;
      BigTwoGameScreen.instance.handleGameResult(var1, (byte)var6.length, var6, var8, var9, (byte)var6.length, var6, var10, var12, var13, var14);
   }

   public final void handlePlayerMove(String var1, String var2, int var3, byte[] var4, String var5, boolean var6) {
      if (BigTwoGameScreen.currentGroupName.equals(var2)) {
         BigTwoGameScreen.instance.gameBoardControl.updatePlayedCards(var4);
      }

      BigTwoGameScreen.instance.handlePlayerMove(var2, var3, var4, var5, var6);
   }

   public final void handlePlayerMoveWithTurn(String var1, String var2, int var3, byte[] var4, String var5, boolean var6, int var7) {
      this.handlePlayerMove(var1, var2, var3, var4, var5, var6);

      for (int var8 = 0; var8 < BigTwoGameScreen.instance.players.length; var8++) {
         if (BigTwoGameScreen.instance.players[var8].playerName.equals(var2)) {
            BigTwoGameScreen.instance.players[var8].statusText = TextConstant.go() + var7;
            BigTwoGameScreen.instance.players[var8].isPlaying = true;
         }
      }
   }

   public final void resetGameSelection() {
      BigTwoGameScreen.instance.gameBoardControl.resetSelection();
   }

   public final void handlePlayerLeave(String var1, String var2, String var3, String[] var4, int var5) {
      if (var2.equals(BigTwoGameScreen.currentGroupName)) {
         if (var5 == 1) {
            this.showNotification(TextConstant.beKickByHost(), (Image)null, 1);
         }

         BigTwoGameScreen.leaveGame();
      } else {
         if (var4.length > 0) {
            BigTwoGameScreen.instance.players = createGamePlayers(var4);
            BigTwoGameScreen.instance.currentPlayerId = var3;
            long[] var11 = new long[var4.length];
            int[] var6 = new int[var4.length];
            String[] var7 = new String[var4.length];
            int[] var8 = new int[var4.length];
            Integer[] var9 = new Integer[var4.length];
            BigTwoGameScreen.instance.playerGameStates = new boolean[var4.length];

            for (int var10 = 0; var10 < var4.length; var10++) {
               var11[var10] = BigTwoGameScreen.instance.players[var10].playerBalance;
               var6[var10] = BigTwoGameScreen.instance.players[var10].cardCount;
               BigTwoGameScreen.instance.playerGameStates[var10] = BigTwoGameScreen.instance.players[var10].isReady;
               var7[var10] = BigTwoGameScreen.instance.players[var10].rankText;
               var8[var10] = BigTwoGameScreen.instance.players[var10].scoreValue;
               var9[var10] = BigTwoGameScreen.instance.players[var10].textColor;
               if (var4[var10].equals(var3)) {
                  BigTwoGameScreen.instance.removeMenuAction(var2);
               }
            }

            BigTwoGameScreen.instance.initializeGameSession((byte)var4.length, var4, var11, var6, var7, var8, var9, var1);
         }
      }
   }

   public final void handlePlayerPass(String var1, String var2, String var3, boolean var4) {
      BigTwoGameScreen.instance.handlePlayerPass(var2, var3, var4);
   }

   public final void handleSpectatorGameJoin(String var1, long var2, String[] var4, long[] var5, int[] var6, boolean[] var7, String var8, String[] var9, int[] var10, Integer[] var11) {
      BigTwoGameScreen var12 = BigTwoGameScreen.instance;
      BigTwoGameScreen.instance.isSpectatorMode = true;
      var12.activePlayerCount = var4.length;
      var12.resultPlayerNames = var4;
      var12.resultPlayerScores = var5;
      var12.resultTimestamp = var2;
      var12.resultPlayerCards = var6;
      var12.currentPlayerId = var8;
      var12.playerGameStates = new boolean[var4.length];
      var12.resultPlayerStatuses = var9;
      var12.resultPlayerRanks = var10;
      var12.resultPlayerRewards = var11;
      if (var12.showTableList) {
         var12.playerCount = (byte)var4.length;
         var12.playerBalance = var2;
         var12.playerStatuses = new String[var4.length];
         var12.playerCardCounts = new int[var4.length];

         for (byte var13 = 0; var13 < var4.length; var13++) {
            var12.playerStatuses[var13] = var4[var13];
            var12.playerCardCounts[var13] = var6[var13];
            var12.playerGameStates[var13] = var7[var13];
         }

         this.closeTopDialog();
         var12.initializeGameSession((byte)var4.length, var4, var5, var6, var9, var10, var11, var1);
      }
   }

   public final void startGamePlay(byte[] var1, String var2, boolean var3) {
      GameBoardControl.isShowingAllCards = false;
      BigTwoGameScreen.isGamePaused = false;
      BigTwoGameScreen.instance.isWaitingResponse = true;
      BigTwoGameScreen.instance.startGamePlay(var1, var2, var3, true);
   }

   public final void updatePlayerReadyStates(String[] var1, boolean[] var2) {
      for (byte var3 = 0; var3 < BigTwoGameScreen.instance.players.length; var3++) {
         for (int var4 = 0; var4 < var1.length; var4++) {
            if (BigTwoGameScreen.instance.players[var3].playerName.equals(var1[var4])) {
               BigTwoGameScreen.instance.players[var3].isReady = var2[var4];
               break;
            }
         }
      }
   }

   public static GamePlayer[] createGamePlayers(String[] var0) {
      GamePlayer[] var1 = new GamePlayer[var0.length];

      for (byte var2 = 0; var2 < var0.length; var2++) {
         for (byte var3 = 0; var3 < BigTwoGameScreen.instance.players.length; var3++) {
            if (var0[var2].equals(BigTwoGameScreen.instance.players[var3].playerName)) {
               var1[var2] = BigTwoGameScreen.instance.players[var3];
            }
         }
      }

      return var1;
   }

   public final void handleTurnChange(String var1, String var2, String var3, boolean var4) {
      BigTwoGameScreen.instance.handleTurnChange(var2, var3, var4);
   }

   public final void handleGameEndResult(
      String var1, String var2, byte var3, String[] var4, int[] var5, long[] var6, long[] var7, byte[][] var8, String[] var9, int[] var10, Integer[] var11
   ) {
      BigTwoGameScreen.instance.playerReadyStates = new boolean[var4.length];

      for (int var12 = 0; var12 < var4.length; var12++) {
         BigTwoGameScreen.instance.playerReadyStates[var12] = false;
         if (var4[var12].equals(BigTwoGameScreen.currentGroupName)) {
            for (int var13 = 0; var13 < var4.length; var13++) {
               if (BigTwoGameScreen.instance.players[var13].playerName.equals(var4[var12])) {
                  BigTwoGameScreen.instance.players[var13].cards = var8[var12];
                  BigTwoGameScreen.instance.startGamePlay(var8[var12], var2, false, false);
                  break;
               }
            }
         }
      }

      BigTwoGameScreen.instance.playerRanks = var5;
      BigTwoGameScreen.instance.handleGameResult(var1, var3, var4, var6, var7, var3, var4, var8, var9, var10, var11);
   }

   public final void showMoneyUpdate(long var1) {
      this.showNotification(TextConstant.yourMoneys() + var1 + " xuxu", (Image)null, 1);
   }

   public final void handleGameChat(String var1, String var2, int var3) {
      if (var2.length() >= 5) {
         this.showNotification(var1 + ": " + var2, (Image)null, 0);
      } else {
         int var4;
         if ((var4 = TextRenderer.findEmoticonIndex(var2)) != 100) {
            GamePlayer[] var5 = null;
            if (var3 == 39) {
               var5 = BigTwoGameScreen.instance.players;
            }

            if (var5 != null) {
               var3 = 0;

               for (int var6 = var5.length; var3 < var6; var3++) {
                  if (var5[var3].playerName.equals(var1)) {
                     var5[var3].isShowingEmote = true;
                     var5[var3].emoteIndex = var4;
                     var5[var3].emoteTime = (byte)((int)(System.currentTimeMillis() / 1000L));
                     return;
                  }
               }
            }

            this.showNotification(var1 + ": " + var2, (Image)null, 0);
         } else {
            this.showNotification(var1 + ": " + var2, (Image)null, 0);
         }
      }
   }

   public final void showGameTables(String var1, TableInfo[] var2, int var3, String var4) {
      if (BigTwoGameScreen.instance != null && !BigTwoGameScreen.isGameStarted) {
         this.removeScreen(BigTwoGameScreen.instance);
         BigTwoGameScreen.instance = null;
      }

      BigTwoGameScreen var5 = BigTwoGameScreen.getInstance(1);
      if (this.screenStack.contains(var5) && BigTwoGameScreen.isGameStarted) {
         this.showSimpleDialog(TextConstant.pleaseQuitYourCurrentGame());
      } else {
         BigTwoGameScreen.currentRoomName = var1;
         BigTwoGameScreen.instance.title = var4;
         BigTwoGameScreen.instance.setWrappedText(var4);
         BigTwoGameScreen var6 = BigTwoGameScreen.instance;
         this.addScreen(var6);
         BigTwoGameScreen.instance.showTableList(var2, 1);
         this.switchToScreen(BigTwoGameScreen.instance);
      }
   }

   public final void a(
      String var1,
      String var2,
      int[] var3,
      byte var4,
      String var5,
      int var6,
      byte var7,
      byte var8,
      byte var9,
      byte var10,
      int var11,
      int var12,
      String var13,
      int var14
   ) {
      Object var15 = null;
      Vector var18 = null;
      if (var14 == 1) {
         var18 = this.buddyListScreen.buddyList.displayItems;
      }

      var7 = (byte) var18.size();

      while (--var7 >= 0) {
         DisplayItem var16;
         if ((var16 = (DisplayItem)var18.elementAt(var7)).displayName.equals(var1)) {
            var16.statusText = var2;
            var16.additionalData = var3;
            if (var14 == 2) {
               var16.detailText = var13;
            }

            ContactEntry var17;
            (var17 = var16.sourceEntry).displayName = var2;
            var17.permissions = var3;
            var17.additionalFlags = var6;
         }
      }

      if (var14 == 1) {
         BuddyListControl.cleanup();
      }
   }

   public final void updateMultipleBuddyStatus(String[] var1, int[] var2, String[] var3) {
      ContactDataSource var4;
      int var5 = (var4 = this.buddyListScreen.buddyList.getDataModel()).groups.size();

      while (--var5 >= 0) {
         ContactGroup var6;
         int var7 = (var6 = (ContactGroup)var4.groups.elementAt(var5)).contacts.size();

         while (--var7 >= 0) {
            ContactEntry var8 = (ContactEntry)var6.contacts.elementAt(var7);
            int var9 = var1.length;

            while (--var9 >= 0) {
               if (var8.contactId.equals(var1[var9])) {
                  if (var2 != null) {
                     var8.setTextColor(var2[var9]);
                     var8.statusMessage = var3[var9];
                  } else {
                     var8.statusCode = 1;
                  }
                  break;
               }
            }
         }
      }

      this.buddyListScreen.buddyList.setDataSource(var4, -1);
   }

   private static String getCacheKey1(int var0) {
      return "cs" + var0;
   }

   private static String getCacheKey2(int var0) {
      return "cs2" + var0;
   }

   public final void loadCachedData(int var1, int var2) {
      byte[] var7;
      if (Xuka.readIP4toInt(getCacheKey1(var1)) == var2 && (var7 = Xuka.readRecord(getCacheKey2(var1))) != null) {
         try {
            MessageHandler.processRawPacket(var7);
            return;
         } catch (Exception var4) {
         }
      }

      boolean var5 = false;
      Packet var8 = new Packet(123, 2);
      MessageHandler.writeInt(var1, var8);
      ConnectionManager.sendPacket(var8);
   }

   public final void saveCachedData(int var1, int var2, byte[] var3) {
      MessageHandler.processRawPacket(var3);
      Xuka.writeRecord(getCacheKey1(var1), intToBytes(var2));
      Xuka.writeRecord(getCacheKey2(var1), var3);
   }

   public final void setCachedBuddyList(ContactDataSource var1) {
      if (roomListScreen == null) {
         (roomListScreen = new RoomListScreen()).contactListUI.itemSelectCallback = new thien_dp(this);
         roomListScreen.contactListUI.selectAction.label = "Vào phòng";
         roomListScreen.title = "Tiến Lên Miền Nam";
         roomListScreen.selectedRoomIndex = 0;
         roomListScreen.setWrappedText(roomListScreen.title);
      }

      roomListScreen.contactListUI.setDataSource(var1, 0);
      roomListScreen.startSlide(1);
      if (!this.containsScreen(roomListScreen)) {
         this.showScreen(roomListScreen);
      }

      this.switchToScreen(roomListScreen);
   }
}
