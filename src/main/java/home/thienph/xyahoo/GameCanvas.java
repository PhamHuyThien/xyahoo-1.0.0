package home.thienph.xyahoo;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;

public final class GameCanvas extends Canvas implements Runnable {
   public static GameCanvas instance;
   static boolean running;
   private static boolean[] keyPressedState = new boolean[21];
   private static boolean[] keyRepeatedState = new boolean[21];
   private static int[] lastKeyCode = new int[1];
   static boolean isTouchActive;
   static boolean isTouchReleased;
   static boolean isTouchPressed;
   static boolean isTouchDragged;
   public static int touchX;
   public static int touchY;
   public static int gameState;
   public static int screenWidth;
   public static int screenHeight;
   public static boolean isNokiaMapping;
   private static int numberKeyPressCount;
   public static boolean isGameStarted = false;

   static {
      new Object();
   }

   public GameCanvas() {
      System.gc();
      this.setFullScreenMode(true);
      instance = this;
      isNokiaMapping = this.getKeyCode(8) == -20;
      screenWidth = this.getWidth();
      screenHeight = this.getHeight();
      gameState = 0;
      TextRenderer.initFont();
      GameHandler var1 = GameHandler.getInstance();
      ConnectionManager.registerCallback(1, var1);
      ConnectionManager.registerCallback(1001, var1);
      ConnectionManager.registerCallback(1000, var1);
      ConnectionManager.registerCallback(39, var1);
      ConnectionManager.registerCallback(2, thien_eu.a());
      ConnectionManager.registerCallback(48, var1);
      ConnectionManager.registerCallback(1001, var1);
      ConnectionManager.ConnectionListener = var1;
      GameManager var2;
      GameHandler.a(var2 = GameManager.getInstance());
      thien_eu.a(var2);
      ConnectionManager.sendPacket(new Packet(-2, -1));
      new Thread(this).start();
   }

   public final void connectToServer() {
      if (!ConnectionManager.isConnected && !ConnectionManager.isConnecting) {
         Xuka.readAllIPs();
         Xuka.readAllPorts();
         String[] var1 = Xuka.serverIPs;
         int[] var2 = Xuka.DEFAULT_PORTS;
         int var3 = (int)(System.currentTimeMillis() % (long)var1.length);
         int var4 = (int)(System.currentTimeMillis() % (long)Xuka.serverIPs.length);
         ConnectionManager.connect(var1[var3], Xuka.serverIPs[var4], var2[var3], Xuka.DEFAULT_PORTS[var4]);
      }
   }

   public final void run() {
      running = true;

      while (running) {
         long var1 = System.currentTimeMillis();

         try {
            switch (gameState) {
               case 0:
                  screenWidth = instance.getWidth();
                  screenHeight = instance.getHeight();
                  if (thien_ev.a == 35) {
                     GameManager.getInstance().a(screenWidth, screenHeight);
                  }

                  if (isGameStarted) {
                     System.gc();
                     gameState = 1;
                  }

                  thien_ev.a++;
                  break;
               case 1:
                  GameManager.instance.a(keyPressedState, keyRepeatedState, lastKeyCode);
            }
         } catch (Exception var5) {
            var5.printStackTrace();
         }

         this.repaint();
         this.serviceRepaints();
         long var6;
         var1 = (var6 = System.currentTimeMillis() - var1) < 35L ? 35L - var6 : 1L;

         try {
            Thread.sleep(var1);
         } catch (Exception var4) {
         }
      }

      Xuka.instance.destroyApp(false);
      Xuka.instance.notifyDestroyed();
   }

   protected final void keyPressed(int var1) {
      if (isNokiaMapping) {
         switch (var1) {
            case -23:
               var1 = -8;
               break;
            case -22:
            case 22:
               var1 = -7;
               break;
            case -21:
            case 21:
               var1 = -6;
               break;
            case -20:
               var1 = -5;
               break;
            case -6:
               var1 = -2;
               break;
            case -5:
               var1 = -4;
               break;
            case -2:
               var1 = -3;
         }
      }

      if (var1 >= 32) {
         lastKeyCode[0] = var1;
      }

      switch (var1) {
         case -204:
         case -8:
         case 8:
            keyPressedState[19] = true;
            return;
         case -203:
         case -22:
         case -7:
            keyPressedState[18] = true;
            return;
         case -202:
         case -21:
         case -6:
            keyPressedState[17] = true;
            return;
         case -39:
         case -2:
            keyPressedState[13] = true;
            return;
         case -38:
         case -1:
            keyPressedState[12] = true;
            return;
         case -11:
            keyPressedState[20] = true;
            return;
         case -5:
         case 10:
         case 13:
            keyPressedState[16] = true;
            return;
         case -4:
            keyPressedState[15] = true;
            return;
         case -3:
            keyPressedState[14] = true;
            return;
         case 35:
            keyPressedState[11] = true;
            return;
         case 42:
            keyPressedState[10] = true;
            return;
         case 48:
         case 49:
         case 50:
         case 51:
         case 52:
         case 53:
         case 54:
         case 55:
         case 56:
         case 57:
            keyPressedState[var1 - 48] = true;
            return;
      }
   }

   protected final void keyRepeated(int var1) {
      if (isNokiaMapping) {
         switch (var1) {
            case -23:
               var1 = -8;
               break;
            case -22:
            case 22:
               var1 = -7;
               break;
            case -21:
            case 21:
               var1 = -6;
               break;
            case -20:
               var1 = -5;
               break;
            case -6:
               var1 = -2;
               break;
            case -5:
               var1 = -4;
               break;
            case -2:
               var1 = -3;
         }
      }

      if (var1 >= 32) {
         lastKeyCode[0] = var1;
      }

      switch (var1) {
         case -204:
         case -8:
         case 8:
            keyRepeatedState[19] = true;
            return;
         case -203:
         case -22:
         case -7:
            keyRepeatedState[18] = true;
            return;
         case -202:
         case -21:
         case -6:
            keyRepeatedState[17] = true;
            return;
         case -39:
         case -2:
            keyRepeatedState[13] = true;
            return;
         case -38:
         case -1:
            keyRepeatedState[12] = true;
            return;
         case -11:
            keyRepeatedState[20] = true;
            return;
         case -5:
         case 10:
         case 13:
            keyRepeatedState[16] = true;
            return;
         case -4:
            keyRepeatedState[15] = true;
            return;
         case -3:
            keyRepeatedState[14] = true;
            return;
         case 35:
            keyRepeatedState[11] = true;
            return;
         case 42:
            keyRepeatedState[10] = true;
            return;
         case 48:
         case 49:
         case 50:
         case 51:
         case 52:
         case 53:
         case 54:
         case 55:
         case 56:
         case 57:
            keyRepeatedState[var1 - 48] = true;
            return;
      }
   }

   protected final void keyReleased(int var1) {
      if (isNokiaMapping) {
         switch (var1) {
            case -23:
               var1 = -8;
               break;
            case -22:
               var1 = -7;
               break;
            case -21:
               var1 = -6;
               break;
            case -20:
               var1 = -5;
               break;
            case -6:
               var1 = -2;
               break;
            case -5:
               var1 = -4;
               break;
            case -2:
               var1 = -3;
         }
      }

      switch (var1) {
         case -39:
         case -2:
            keyRepeatedState[13] = false;
            return;
         case -38:
         case -1:
            keyRepeatedState[12] = false;
            return;
         case -22:
         case -7:
            keyRepeatedState[18] = false;
            return;
         case -21:
         case -6:
            keyRepeatedState[17] = false;
            return;
         case -11:
            keyRepeatedState[20] = false;
            return;
         case -8:
         case 8:
            keyRepeatedState[19] = false;
            return;
         case -5:
         case 10:
         case 13:
            keyRepeatedState[16] = false;
            return;
         case -4:
            keyRepeatedState[15] = false;
            return;
         case -3:
            keyRepeatedState[14] = false;
            return;
         case 35:
            keyRepeatedState[11] = false;
            return;
         case 42:
            keyRepeatedState[10] = false;
            return;
         case 48:
         case 49:
            numberKeyPressCount++;
         case 50:
         case 51:
         case 52:
         case 53:
         case 54:
         case 55:
         case 56:
         case 57:
            keyRepeatedState[var1 - 48] = false;
            return;
      }
   }

   public static void resetKeys() {
      for (int var0 = 0; var0 < 21; var0++) {
         keyPressedState[var0] = false;
      }
   }

   protected final void pointerDragged(int var1, int var2) {
      isTouchActive = true;
      isTouchDragged = true;
      touchX = var1;
      touchY = var2;
   }

   protected final void pointerPressed(int var1, int var2) {
      isTouchActive = true;
      isTouchPressed = true;
      touchX = var1;
      touchY = var2;
   }

   protected final void pointerReleased(int var1, int var2) {
      isTouchActive = false;
      isTouchReleased = true;
      touchX = var1;
      touchY = var2;
   }

   protected final void paint(Graphics var1) {
      try {
         switch (gameState) {
            case 0:
               var1.setColor(1055519);
               var1.fillRect(0, 0, screenWidth, screenHeight);
               if (!isGameStarted) {
                  var1.drawImage(TextRendererHelper.getLogo(), screenWidth >> 1, (screenHeight >> 1) - 15, 3);
                  var1.setColor(16777215);
                  GameManager.instance.drawLoadingAnimation(var1, screenWidth >> 1, (screenHeight + TextRendererHelper.defaultFontSize >> 1) + 3);
                  TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(GameManager.serverMessage, screenWidth - 8, screenHeight - TextRenderer.fontHeight - 8, 1, var1, TextRenderer.charWidth, TextRenderer.fontHeight);
                  GameManager.instance.h++;
               }
            default:
               return;
            case 1:
               GameManager.instance.a(var1);
         }
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }
}
