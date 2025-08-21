package home.thienph.xyahoo.screens;

import home.thienph.xyahoo.actions.*;
import home.thienph.xyahoo.components.*;
import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.data.data.PopupSideElementData;
import home.thienph.xyahoo.data.data.TableInfo;
import home.thienph.xyahoo.data.data.UIAction;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.utils.TextRenderer;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class BigTwoGameScreen extends Screen {
   public String currentPlayerId;
   public static boolean isGameStarted;
   public static int frameCounter;
   private TableInfo[] tableInfos;
   private TableListControl tableListControl;
   public static String currentGroupName;
   public String[] playerNames = new String[4];
   private long[] playerScores = new long[4];
   private static int currentPlayerScore;
   private static int currentPlayerRank;
   public static String gameRoomId;
   public long playerBalance = 0L;
   public Object currentPlayerName;
   public boolean isWaitingResponse;
   public GamePlayer[] players;
   public String[] playerStatuses;
   private static TextField betTextField;
   public static boolean isChatting;
   public static TextField chatTextField;
   public static boolean isChatVisible;
   public byte playerCount;
   public int[] playerCardCounts;
   public int[] playerRanks;
   public boolean[] playerReadyStates;
   public boolean[] playerGameStates;
   public GameBoardControl gameBoardControl;
   private boolean isMyTurn;
   public boolean isAnimating;
   public boolean isInitialized;
   public static BigTwoGameScreen instance;
   public static boolean isGamePaused;
   public byte totalPlayers;
   public String[] gamePlayerNames;
   private long[] gamePlayerScores;
   private long[] gamePlayerBalances;
   private byte gamePlayerCount;
   private String[] finishedPlayerNames;
   public byte[][] allPlayerCards;
   public boolean showTableList = true;
   public boolean isSpectatorMode;
   public int activePlayerCount;
   public String[] resultPlayerNames;
   public long[] resultPlayerScores;
   public long resultTimestamp;
   public int[] resultPlayerCards;
   public String[] resultPlayerStatuses;
   public int[] resultPlayerRanks;
   public Integer[] resultPlayerRewards;
   public static int selectedTableType;
   private UIControlBase selectedControl;
   public static String currentRoomName;
   private UIAction kickAction;
   private Vector kickMenuItems;
   private PopupSideElementData kickMenuData;
   private Vector gameMenuItems;
   private PopupSideElementData gameMenuData;
   private UIAction gameMenuAction;
   private Vector playerMenuItems;
   private PopupSideElementData playerMenuData;
   public static Image[] avatarImages;
   private int selectedAvatarIndex = -1;
   private UIAction smileyAction = new UIAction(TextConstant.smileys(), new thien_bb(this));
   private UIAction chatAction = new UIAction("Chat", new thien_bm(this));
   private UIAction betAction = new UIAction("Đặt cược", new thien_br(this));
   private static int lastScrollY = -1;
   private PopupSideElementData contextMenuData;
   private UIAction cancelChatAction;
   private UIAction sendChatAction;
   private UIAction closeBetAction;
   private UIAction placeBetAction;
   private UIAction updateAction;
   private UIAction findTableAction;

   public static BigTwoGameScreen getInstance(int var0) {
      if (instance == null) {
         instance = new BigTwoGameScreen(var0);
      }

      return instance;
   }

   public final void removeMenuAction(String var1) {
      Vector var10000 = this.kickMenuItems;
      String var2 = var1;
      BigTwoGameScreen var5 = this;
      byte var3 = 0;

      UIAction var10001;
      while (true) {
         if (var3 >= var5.kickMenuItems.size()) {
            var10001 = null;
            break;
         }

         UIAction var4;
         if ((var4 = (UIAction)var5.kickMenuItems.elementAt(var3)).label.equals(var2)) {
            var10001 = var4;
            break;
         }

         var3++;
      }

      var10000.removeElement(var10001);
   }

   private BigTwoGameScreen(int var1) {
      new UIAction("Tài khoản", new AccountInfoAction(this));
      this.updateAction = new UIAction(TextConstant.update(), new UpdateAction(this));
      this.findTableAction = new UIAction("Tìm bàn", new TimBanAction(this));
      currentGroupName = BuddyListScreen.currentGroupName;
      if (var1 == 1) {
         super.title = TextConstant.bigTwo();
      }

      this.gameMenuItems = new Vector();
      this.gameMenuData = new PopupSideElementData(this.gameMenuItems);
      this.gameMenuAction = new UIAction("Menu", new thien_bv(this));
      super.scrollLock = true;
      GameManager.loadGameBackground();
      this.isInitialized = false;
   }

   public final void draw(Graphics var1) {
      super.draw(var1);
   }

   public final boolean handleInput(boolean[] var1, boolean[] var2, int[] var3) {
      if (var3[0] > 32 && isGameStarted && !isChatting) {
         this.addControl(chatTextField);
         isChatVisible = true;
         this.selectControl(chatTextField);
      }

      return super.handleInput(var1, var2, var3);
   }

   public final void updateLayout() {
      this.tableListControl.handleFocus();
   }

   public final void drawOverlay(Graphics var1) {
      this.tableListControl.drawScrollbar(var1);
   }

   public final void showTableList(TableInfo[] var1, int var2) {
      selectedTableType = var2;
      isChatVisible = false;
      isGameStarted = false;
      GameManager.instance.closeTopDialog();
      this.showTableList = true;
      this.gameBoardControl = null;
      this.tableInfos = null;
      this.tableInfos = new TableInfo[var1.length];
      var2 = this.tableInfos.length;

      while (--var2 >= 0) {
         this.tableInfos[var2] = var1[var2];
      }

      this.adjustScrollPosition();
      super.isLocked = true;
      TableListControl.tableList = this.tableInfos;
      this.clearControls();
      System.gc();
      this.tableListControl = new TableListControl(Screen.e - 3, Screen.formHeight - 3 - GameManager.topMargin, selectedTableType);
      this.addControl(this.tableListControl);
      this.selectControl(this.tableListControl);
      super.rightCommand = this.findTableAction;
      this.gameMenuItems.removeAllElements();
      this.gameMenuItems.addElement(this.updateAction);
      this.gameMenuItems.addElement(GameRoomListScreen.cashInAction);
      this.gameMenuItems.addElement(new UIAction("Rời phòng", new thien_bw(this)));
      super.leftCommand = this.gameMenuAction;
      System.gc();
   }

   public static void leaveGame() {
      isGameStarted = false;
      MessageHandler.b(currentRoomName);
   }

   private static void loadAvatarImages() {
      if (avatarImages == null) {
         avatarImages = new Image[4];

         try {
            for (int var0 = 0; var0 < 4; var0++) {
               avatarImages[var0] = Image.createImage("/av" + var0 + ".png");
            }

            return;
         } catch (Exception var1) {
            System.out.println("sdsdsdsd = " + var1.toString());
         }
      }
   }

   public final void initializeGameSession(byte var1, String[] var2, long[] var3, int[] var4, String[] var5, int[] var6, Integer[] var7, String var8) {
      isGameStarted = true;
      selectedTableType = 1;
      GameManager.instance.closeTopDialog();
      this.clearControls();
      isChatVisible = false;
      TableListControl.tableList = null;
      this.gameBoardControl = null;
      this.showTableList = true;
      this.players = null;
      byte var9 = 0;
      System.gc();
      if (this.kickAction == null) {
         this.kickMenuItems = new Vector();
         this.kickMenuData = new PopupSideElementData(this.kickMenuItems);
         this.kickAction = new UIAction(TextConstant.kick(), null);
         this.kickAction.popupSideElementData = this.kickMenuData;
      }

      this.players = new GamePlayer[var1];
      this.playerCount = var1;
      this.playerCardCounts = var4;
      boolean var10 = false;

      for (byte var11 = 0; var11 < var2.length; var11++) {
         this.playerNames[var11] = var2[var11];
         this.playerScores[var11] = var3[var11];
      }

      for (byte var17 = 0; var17 < var1; var17++) {
         if (var2[var17] != null) {
            var9++;
         }
      }

      byte[] var18 = new byte[var1];
      byte var12 = 0;
      byte var13 = 0;

      for (byte var14 = 0; var14 < var1; var14++) {
         if (currentGroupName.equals(var2[var14])) {
            var12 = var14;
            break;
         }
      }

      for (byte var20 = 0; var20 < var1; var20++) {
         var18[var20] = var12;
         if (var12 == var1 - 1) {
            var12 = 0;
         } else {
            var12++;
         }

         var13 = var18[var20];
         if (var2[var13] != null) {
            this.players[var20] = new GamePlayer(var2[var13], var3[var13], var20, var4[var13], var2[var13].equals(this.currentPlayerId), var5[var13], var6[var13], var7[var13]);
            this.players[var20].isReady = this.playerGameStates[var13];
         }

         if (currentGroupName.equals(this.players[var20].playerName)) {
            currentPlayerScore = this.players[var20].x;
            currentPlayerRank = this.players[var20].y;
            var10 = this.players[var20].isReady;
         }

         if (this.players[var20] != null) {
            this.addControl(this.players[var20]);
         }
      }

      loadAvatarImages();
      if (var1 > 0) {
         if (this.selectedAvatarIndex == -1 || !var8.equals(gameRoomId)) {
            this.selectedAvatarIndex = (int)(System.currentTimeMillis() % 4L);
         }

         int var21 = this.selectedAvatarIndex;
         this.players[0].avatarIndex = this.selectedAvatarIndex;

         for (int var16 = 1; var16 < var1; var16++) {
            if (var21 == 3) {
               var21 = 0;
            } else {
               var21++;
            }

            this.players[var16].avatarIndex = var21;
         }
      }

      if (this.playerMenuItems == null) {
         this.playerMenuItems = new Vector();
         this.playerMenuData = new PopupSideElementData(this.playerMenuItems);
      } else {
         this.playerMenuItems.removeAllElements();
      }

      if (currentGroupName.equals(this.currentPlayerId) && this.players.length > 1) {
         this.kickMenuItems.removeAllElements();

         for (byte var22 = 0; var22 < this.players.length; var22++) {
            if (var22 != 0) {
               UIAction var15 = new UIAction(this.players[var22].playerName, new thien_bx(this, var22));
               this.kickMenuItems.addElement(var15);
            }
         }

         this.playerMenuItems.addElement(this.kickAction);
      }

      this.playerMenuItems.addElement(this.smileyAction);
      this.playerMenuItems.addElement(this.chatAction);
      if (var9 == 1) {
         this.playerMenuItems.addElement(this.betAction);
      }

      this.playerMenuItems.addElement(GameRoomListScreen.cashInAction);
      this.playerMenuItems.addElement(new UIAction("Rời bàn", new thien_bc(this)));
      super.leftCommand = new UIAction("Menu", new thien_bd(this));
      super.rightCommand = null;
      if (currentGroupName.equals(this.currentPlayerId)) {
         super.centerCommand = new UIAction(TextConstant.playNow(), new thien_be(this));
      } else if (!var10) {
         super.centerCommand = new UIAction(TextConstant.ready(), new thien_bf(this));
      }

      this.selectedControl = this.players[0];
      betTextField = null;
      (betTextField = new TextField("", 9, 1)).setBounds(0, Screen.formHeight - GameManager.topMargin - (TextRenderer.fontHeight << 1) - 10, Screen.e - 1, TextRenderer.fontHeight + 6);
      if (this.closeBetAction == null) {
         this.closeBetAction = new UIAction(TextConstant.close(), new thien_bp(this));
      }

      betTextField.actionPrimary = this.closeBetAction;
      if (this.placeBetAction == null) {
         this.placeBetAction = new UIAction(TextConstant.bet(), new thien_bq(this));
      }

      betTextField.actionTertiary = this.placeBetAction;
      this.initializeChatField();
      this.selectControl(this.selectedControl);
      this.adjustScrollPosition();
      System.gc();
   }

   private void adjustScrollPosition() {
      if (lastScrollY != super.scrollTargetY) {
         super.scrollTargetY = -Screen.headerHeight + 2;
         lastScrollY = super.scrollTargetY;
      }
   }

   public final void startGamePlay(byte[] var1, String var2, boolean var3, boolean var4) {
      this.gameBoardControl = null;
      if (chatTextField != null) {
         this.removeControl(chatTextField);
      }

      isChatVisible = false;
      System.gc();
      this.gameBoardControl = new GameBoardControl(var1);
      GameBoardControl.isGameEnded = var4;
      this.gameBoardControl.playerName = var2;
      this.currentPlayerName = var2;
      if (currentGroupName.equals(var2)) {
         this.isMyTurn = var3;
         this.gameBoardControl.isMyTurn = var3;
      }

      this.gameBoardControl.isSpectatorMode = true;
      this.gameBoardControl.isGameStarted = false;
      this.gameBoardControl.playerScore = currentPlayerScore;
      this.gameBoardControl.playerRank = currentPlayerRank + 8;
      GameBoardControl var7 = this.gameBoardControl;
      BigTwoGameScreen var5 = this;

      for (byte var8 = 0; var8 < var5.players.length; var8++) {
         if (var5.players[var8] != null) {
            var5.players[var8].setReadyState(false);
         }
      }

      var5.isSpectatorMode = false;
      var5.showTableList = false;
      var5.isAnimating = false;
      if (var7 != null) {
         var7.isMyTurn = var5.isMyTurn;
         var7.isValidMove = false;
         var5.addControl(var7);
         var5.selectControl(var7);
      }

      System.gc();
      var5.rightCommand = new UIAction(TextConstant.deny(), new thien_bg(var5, var7));
      var5.selectedControl = var5.gameBoardControl;
      var5.initializeChatField();
      var5.leftCommand = new UIAction("Menu", new thien_bh(var5));
      System.gc();

      for (byte var6 = 0; var6 < instance.playerCount; var6++) {
         if (instance.players[var6].playerName != null && instance.players[var6].playerName.equals(var2)) {
            instance.players[var6].startCountdown(30);
            return;
         }
      }
   }

   public final void handlePlayerMove(String var1, int var2, byte[] var3, String var4, boolean var5) {
      this.isAnimating = true;
      this.currentPlayerName = var4;
      if (this.gameBoardControl != null) {
         GamePlayer var6 = new GamePlayer();

         for (byte var7 = 0; var7 < this.playerCount; var7++) {
            if (this.players[var7].playerName != null && this.players[var7].playerName.equals(var1)) {
               var6 = this.players[var7];
            }
         }

         this.gameBoardControl.isValidMove = true;
         this.gameBoardControl.isSpectatorMode = var5;
         this.gameBoardControl.playerId = var1;
         this.gameBoardControl.playerName = var4;
         this.gameBoardControl.cardCount = var2;
         this.gameBoardControl.isMyTurn = false;
         this.gameBoardControl.isMoveSubmitted = false;
         if (this.gameBoardControl.isSpectatorMode) {
            this.gameBoardControl.isGameStarted = false;

            for (int var8 = 0; var8 < instance.playerCount; var8++) {
               this.players[var8].isMyTurn = false;
            }
         } else {
            var6.isMyTurn = false;
         }

         this.gameBoardControl.animateCardMove(var3, var6.x, var6.y);

         for (byte var9 = 0; var9 < this.playerCount; var9++) {
            if (this.players[var9].playerName != null) {
               if (this.players[var9].playerName.equals(this.currentPlayerName)) {
                  this.players[var9].startCountdown(30);
               } else {
                  this.players[var9].isCountingDown = false;
               }
            }
         }
      }
   }

   public final void handlePlayerPass(String var1, String var2, boolean var3) {
      this.gameBoardControl.isSpectatorMode = var3;
      this.gameBoardControl.playerName = var2;
      this.currentPlayerName = var2;
      this.gameBoardControl.lastMoveInfo = var1;
      if (this.gameBoardControl.isMyTurn) {
         this.gameBoardControl.isMyTurn = false;
      }

      if (this.gameBoardControl.isSpectatorMode) {
         this.gameBoardControl.isGameStarted = false;
         this.gameBoardControl.currentPlayedCards = null;
         this.gameBoardControl.previousCards = null;

         for (byte var4 = 0; var4 < this.playerCount; var4++) {
            this.players[var4].isMyTurn = false;
         }
      } else {
         for (byte var5 = 0; var5 < this.playerCount; var5++) {
            if (this.players[var5].playerName.equals(var1)) {
               this.players[var5].isMyTurn = true;
               break;
            }
         }
      }

      for (byte var6 = 0; var6 < this.playerCount; var6++) {
         if (this.players[var6].playerName.equals(var1)) {
            this.players[var6].isCountingDown = false;
         } else if (this.players[var6].playerName.equals(var2)) {
            this.players[var6].startCountdown(30);
         }
      }
   }

   public final void handleGameResult(
      String var1, byte var2, String[] var3, long[] var4, long[] var5, byte var6, String[] var7, byte[][] var8, String[] var9, int[] var10, Integer[] var11
   ) {
      if (gameRoomId.equals(var1)) {
         this.totalPlayers = var2;
         this.gamePlayerNames = var3;
         this.gamePlayerScores = var4;
         this.gamePlayerBalances = var5;
         this.gamePlayerCount = var6;
         this.finishedPlayerNames = var7;

         for (byte var12 = 0; var12 < this.playerCount; var12++) {
            if (this.players[var12] != null) {
               this.players[var12].isCountingDown = false;

               for (byte var13 = 0; var13 < var3.length; var13++) {
                  if (this.players[var12].playerName.equals(var3[var13])) {
                     this.players[var12].playerBalance = var5[var13];
                     this.players[var12].rankText = var9[var13];
                     this.players[var12].scoreValue = var10[var13];
                     this.players[var12].textColor = var11[var13];
                     break;
                  }
               }
            }
         }

         this.isWaitingResponse = false;
         if (var1.equals(var1)) {
            this.allPlayerCards = var8;
            this.gameBoardControl.validateMove();
         }
      }
   }

   public final void showGameResults() {
      String[] var1 = new String[this.gamePlayerCount];
      long[] var2 = new long[this.gamePlayerCount];
      int[] var3 = new int[this.gamePlayerCount];
      String var4 = TextConstant.finish() + "\n";

      for (int var5 = 0; var5 < this.gamePlayerNames.length; var5++) {
         String var6;
         if (this.playerRanks[var5] == 1) {
            var6 = "Tới nhất: ";
         } else if (this.playerRanks[var5] == 2) {
            var6 = "Tới nhì: ";
         } else if (this.playerRanks[var5] == 3) {
            var6 = "Tới ba: ";
         } else {
            var6 = "Tới bét: ";
         }

         var4 = var4 + var6 + TextRenderer.truncate(this.gamePlayerNames[var5], 14) + " " + this.gamePlayerScores[var5] + " xuxu" + "\n";
         if (BuddyListScreen.currentGroupName.equals(this.gamePlayerNames[var5]) && this.gamePlayerScores[var5] > 0L) {
            GameManager.instance.showNotification("Chúc mừng " + BuddyListScreen.currentGroupName + " đã thắng số tiền " + this.gamePlayerScores[var5] + " xuxu", (Image) null, 1);
         }
      }

      GameManager.instance.showCenterDialog(var4, null, null, new UIAction(TextConstant.close(), new thien_bk(this)));
      boolean var8 = false;

      for (int var9 = 0; var9 < this.gamePlayerCount; var9++) {
         for (int var7 = 0; var7 < this.playerCount; var7++) {
            if (!var8 && this.gamePlayerBalances[var7] < this.playerBalance && this.gamePlayerNames[var7] != null && currentGroupName.equals(this.gamePlayerNames[var7])) {
               var8 = true;
            }

            if (this.players[var7].playerName != null && this.players[var7].playerName.equals(this.finishedPlayerNames[var9])) {
               var1[var9] = this.players[var7].playerName;
               var2[var9] = this.players[var7].playerBalance;
               var3[var9] = this.players[var7].cardCount;
               break;
            }
         }
      }

      super.centerCommand.label = "";
      super.rightCommand = new UIAction(TextConstant.resume(), new thien_bl(this));
   }

   public final void prepareNextRound() {
      Vector var1 = new Vector();

      for (int var2 = 0; var2 < this.playerReadyStates.length; var2++) {
         if (!this.playerReadyStates[var2]) {
            var1.addElement(this.finishedPlayerNames[var2]);
         }
      }

      String[] var4 = new String[var1.size()];
      var1.copyInto(var4);
      this.players = GameManager.createGamePlayers(var4);
      this.activePlayerCount = var4.length;

      for (int var3 = 0; var3 < var4.length; var3++) {
         this.resultPlayerNames[var3] = instance.players[var3].playerName;
         this.resultPlayerScores[var3] = instance.players[var3].playerBalance;
         this.resultPlayerCards[var3] = instance.players[var3].cardCount;
         this.resultPlayerStatuses[var3] = instance.players[var3].rankText;
         this.resultPlayerRanks[var3] = instance.players[var3].scoreValue;
         this.resultPlayerRewards[var3] = instance.players[var3].textColor;
         this.playerGameStates[var3] = false;
      }
   }

   public final void handleTurnChange(String var1, String var2, boolean var3) {
      this.gameBoardControl.playerName = var2;
      this.gameBoardControl.isSpectatorMode = var3;
      instance.currentPlayerName = var2;
      if (this.gameBoardControl.isSpectatorMode) {
         this.gameBoardControl.isGameStarted = false;
         this.gameBoardControl.currentPlayedCards = null;
         this.gameBoardControl.previousCards = null;
      }

      for (int var4 = 0; var4 < this.players.length; var4++) {
         if (this.players[var4] != null) {
            this.players[var4].isMyTurn = false;
            if (!this.gameBoardControl.isMyTurn && this.players[var4].playerName.equals(var2)) {
               this.players[var4].startCountdown(30);
            }
         }
      }

      for (byte var5 = 0; var5 < this.players.length; var5++) {
         if (this.players[var5].playerName.equals(var1)) {
            this.players[var5].isHidden = true;
         }
      }
   }

   private void initializeChatField() {
      chatTextField = null;
      (chatTextField = new TextField("", 50, 0)).setBounds(0, Screen.formHeight - GameManager.topMargin - (TextRenderer.fontHeight << 1) - 10, Screen.e - 1, TextRenderer.fontHeight + 6);
      if (this.cancelChatAction == null) {
         this.cancelChatAction = new UIAction(TextConstant.cancel(), new thien_bn(this));
      }

      chatTextField.actionPrimary = this.cancelChatAction;
      if (this.sendChatAction == null) {
         this.sendChatAction = new UIAction(TextConstant.send(), new thien_bo(this));
      }

      chatTextField.actionTertiary = this.sendChatAction;
   }

   public static void exitGame(int var0) {
      isGameStarted = false;
      MessageHandler.a(var0, 0, currentRoomName);
   }

   public static void adjustScrollPosition(BigTwoGameScreen var0) {
      var0.adjustScrollPosition();
   }

   public static TextField getBetTextField() {
      return betTextField;
   }

   public static PopupSideElementData getGameMenuData(BigTwoGameScreen var0) {
      return var0.gameMenuData;
   }

   public static void setTableListControl(BigTwoGameScreen var0, TableListControl var1) {
      var0.tableListControl = null;
   }

   public static PopupSideElementData getPlayerMenuData(BigTwoGameScreen var0) {
      return var0.playerMenuData;
   }

   public static PopupSideElementData getContextMenuData(BigTwoGameScreen var0) {
      return var0.contextMenuData;
   }

   public static void setContextMenuData(BigTwoGameScreen var0, PopupSideElementData var1) {
      var0.contextMenuData = var1;
   }

   public static UIAction getChatAction(BigTwoGameScreen var0) {
      return var0.chatAction;
   }

   public static UIAction getSmileyAction(BigTwoGameScreen var0) {
      return var0.smileyAction;
   }

   public static UIControlBase getSelectedControl(BigTwoGameScreen var0) {
      return var0.selectedControl;
   }
}
