package home.thienph.xyahoo.components;

import home.thienph.xyahoo.screens.BigTwoGameScreen;
import home.thienph.xyahoo.screens.Screen;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.utils.TextRenderer;

import javax.microedition.lcdui.Graphics;

public final class GameBoardControl extends UIControlBase
{
    private static int selectedCardCount;
    private static int totalCardCount;
    private static Card[] tempSelectedCards;
    private static Card[] allCards;
    private static String[] playerNames;
    private byte[] playerCards;
    private byte[] selectedCards;
    private int selectedCardIndex;
    private int cardAreaY;
    public String playerId;
    public String playerName;
    private static int moveType;
    public int cardCount;
    public Card[] currentPlayedCards;
    private Card[] animationCards;
    public boolean isMyTurn;
    public boolean isValidMove;
    public boolean isGameStarted;
    public boolean isSpectatorMode;
    public int playerScore;
    public int playerRank;
    public String lastMoveInfo;
    public static boolean isGameEnded;
    private boolean isAnimatingMove;
    private int animationCardIndex;
    private int animationFrame;
    private long animationDelay;
    private long lastAnimationTime;
    private static int cardSpacingX;
    private static int cardSpacingY;
    private static boolean isAnimating;
    private int targetX;
    private int targetY;
    private int deltaX;
    private int deltaY;
    private int currentX;
    private int currentY;
    public Card[] previousCards;
    public boolean isMoveSubmitted;
    public static boolean isShowingAllCards;
    private Card[][] allPlayersCards;
    private int tempCardCount;
    private int tempPlayerCardCount;

    static {
        GameBoardControl.isShowingAllCards = false;
    }
    
    public GameBoardControl(final byte[] playerCards) {
        Card.loadCardImages();
        this.cardAreaY = Screen.formHeight - 60;
        if (Screen.e > 130) {
            GameBoardControl.cardSpacingX = Screen.e - Card.CARD_WIDTH - (Card.CARD_WIDTH >> 2) * 12 >> 1;
        }
        else {
            GameBoardControl.cardSpacingX = 0;
        }
        GameBoardControl.cardSpacingY = 70;
        GameBoardControl.playerNames = null;
        GameBoardControl.allCards = null;
        GameBoardControl.tempSelectedCards = null;
        this.currentPlayedCards = null;
        this.animationCards = null;
        System.gc();
        GameBoardControl.playerNames = new String[4];
        GameBoardControl.selectedCardCount = 0;
        this.playerCards = playerCards;
        GameBoardControl.isAnimating = true;
        this.isMoveSubmitted = false;
        GameBoardControl.allCards = new Card[GameBoardControl.totalCardCount = this.playerCards.length];
        GameBoardControl.tempSelectedCards = new Card[GameBoardControl.selectedCardCount];
        this.currentPlayedCards = new Card[GameBoardControl.selectedCardCount];
        this.animationCards = new Card[3];
        for (int i = 0; i < this.animationCards.length; ++i) {
            (this.animationCards[i] = new Card()).setPosition((Screen.e >> 1) - 30 + i * 10, Screen.formHeight - 130 >> 1);
        }
        for (int j = 0; j < GameBoardControl.selectedCardCount; ++j) {
            this.currentPlayedCards[j] = new Card();
        }
        for (byte b = 0; b < BigTwoGameScreen.instance.playerCount; ++b) {
            GameBoardControl.playerNames[b] = BigTwoGameScreen.instance.playerNames[b];
        }
        for (int k = 0; k < GameBoardControl.totalCardCount; ++k) {
            GameBoardControl.allCards[k] = new Card();
            GameBoardControl.allCards[k].cardValue = this.playerCards[k];
            GameBoardControl.allCards[k].rank = (byte)(this.playerCards[k] >> 2);
            GameBoardControl.allCards[k].suit = (byte)(this.playerCards[k] % 4);
            GameBoardControl.allCards[k].setPosition(50 + k * 14, Screen.formHeight - 100);
            if (k == GameBoardControl.totalCardCount - 1) {
                GameBoardControl.allCards[k].isVisible = true;
            }
        }
        this.selectedCardIndex = 0;
        arrangeCards();
        this.animationCardIndex = 0;
        this.animationFrame = 0;
        this.animationDelay = 10L;
        this.lastAnimationTime = System.currentTimeMillis();
        super.baseX = 0;
        super.baseY = 0;
        super.width = Screen.e;
        super.height = Screen.formHeight;
        super.isEnabled = true;
    }
    
    public final void handleKeyPress(final int n, final int n2) {
        if (!GameBoardControl.isShowingAllCards && GameBoardControl.totalCardCount > 0) {
            int i = 0;
            while (true) {
                while (i < GameBoardControl.totalCardCount) {
                    final int j = GameBoardControl.allCards[i].cX;
                    final int k = GameBoardControl.allCards[i].cY;
                    if (n > j && n < j + 11 && n2 > k && n2 < k + Card.CARD_HEIGHT) {
                        final int n4;
                        final int n3 = n4 = i;
                        final int l = n4;
                        if (n3 == -1) {
                            return;
                        }
                        this.selectedCardIndex = l;
                        if (!GameBoardControl.allCards[this.selectedCardIndex].isSelected) {
                            this.handleKeyInput(12);
                        }
                        else {
                            this.handleKeyInput(13);
                        }
                        final int a = TextRenderer.computeTextWidth(BigTwoGameScreen.instance.centerCommand.label, TextRenderer.charWidth);
                        final int n5 = (super.width >> 1) - (a >> 1);
                        final int t = super.height;
                        if (n > n5 && n < n5 + a && n2 > t && n2 < t + Screen.topMargin) {
                            this.handleKeyInput(16);
                        }
                        return;
                    }
                    else {
                        ++i;
                    }
                }
                int n4;
                final int n3 = n4 = -1;
                continue;
            }
        }
    }
    
    public final boolean handleKeyInput(int i) {
        if (GameBoardControl.isGameEnded) {
            return false;
        }
        boolean b = true;
        Label_1049: {
            switch (i) {
                case 12: {
                    if (!GameBoardControl.isShowingAllCards && GameBoardControl.totalCardCount > 0 && !GameBoardControl.allCards[this.selectedCardIndex].isSelected) {
                        GameBoardControl.allCards[this.selectedCardIndex].isSelected = true;
                        final Card Card = GameBoardControl.allCards[this.selectedCardIndex];
                        Card.cY -= 20;
                        GameBoardControl.allCards[this.selectedCardIndex].isVisible = true;
                        if (this.selectedCardIndex > 0) {
                            GameBoardControl.allCards[this.selectedCardIndex - 1].isVisible = true;
                        }
                    }
                    b = false;
                    break;
                }
                case 13: {
                    if (!GameBoardControl.isShowingAllCards && GameBoardControl.totalCardCount > 0 && GameBoardControl.allCards[this.selectedCardIndex].isSelected) {
                        GameBoardControl.allCards[this.selectedCardIndex].isSelected = false;
                        final Card card2 = GameBoardControl.allCards[this.selectedCardIndex];
                        card2.cY += 20;
                        if (this.selectedCardIndex != GameBoardControl.totalCardCount - 1) {
                            GameBoardControl.allCards[this.selectedCardIndex].isVisible = true;
                        }
                        if (this.selectedCardIndex > 0) {
                            GameBoardControl.allCards[this.selectedCardIndex - 1].isVisible = true;
                        }
                        b = false;
                        break;
                    }
                    if (!BigTwoGameScreen.isChatVisible) {
                        b = false;
                        break;
                    }
                    break;
                }
                case 14: {
                    --this.selectedCardIndex;
                    if (this.selectedCardIndex < 0) {
                        this.selectedCardIndex = 0;
                        break Label_1049;
                    }
                    b = false;
                    break;
                }
                case 15: {
                    ++this.selectedCardIndex;
                    if (this.selectedCardIndex > GameBoardControl.totalCardCount - 1) {
                        this.selectedCardIndex = GameBoardControl.totalCardCount - 1;
                        break Label_1049;
                    }
                    b = false;
                    break;
                }
                case 16: {
                    if (!GameBoardControl.isShowingAllCards) {
                        for (i = 0; i < GameBoardControl.totalCardCount; ++i) {
                            if (GameBoardControl.allCards[i].isSelected) {
                                ++GameBoardControl.selectedCardCount;
                            }
                        }
                        GameBoardControl.tempSelectedCards = new Card[GameBoardControl.selectedCardCount];
                        this.selectedCards = new byte[GameBoardControl.selectedCardCount];
                        i = 0;
                        for (int j = 0; j < GameBoardControl.totalCardCount; ++j) {
                            if (GameBoardControl.allCards[j].isSelected) {
                                GameBoardControl.tempSelectedCards[i] = GameBoardControl.allCards[j];
                                ++i;
                            }
                        }
                        if (!this.isMoveSubmitted) {
                            final Card[] e = GameBoardControl.tempSelectedCards;
                            int n = 0;
                            final byte[] a = Card.getCardValues(e);
                            if (!this.isGameStarted && BigTwoGameScreen.currentGroupName.equals(this.playerName)) {
                                if (this.isMyTurn && getCardValue(e) == getCardValue(GameBoardControl.allCards)) {
                                    if ((n = (this.checkMoveValid(a, 0) ? 1 : 0)) != 0) {
                                        this.isMyTurn = false;
                                    }
                                }
                                else if (!this.isMyTurn && (n = (this.checkMoveValid(a, 0) ? 1 : 0)) != 0 && !this.isSpectatorMode) {
                                    final int l = GameBoardControl.moveType;
                                    final Card[] e2 = GameBoardControl.tempSelectedCards;
                                    final int c = this.cardCount;
                                    final Card[] d = this.currentPlayedCards;
                                    final boolean b2 = false;
                                    final Card[] array = d;
                                    final int n2 = c;
                                    final Card[] array2 = e2;
                                    final int n3 = l;
                                    int n4 = 0;
                                    if (n3 == n2) {
                                        if (array2.length == array.length && array2[array2.length - 1].cardValue > array[array.length - 1].cardValue) {
                                            n4 = 1;
                                            if (b2) {
                                                if (n3 == 1 && array2[0].suit != array[0].suit && array2[0].rank != 15) {
                                                    n4 = 0;
                                                }
                                                else if (n3 == 2 && array2[0].suit != array[0].suit && array2[0].rank != 15) {
                                                    n4 = 0;
                                                }
                                                else if (n3 == 3 && (array2[0].suit != array[0].suit || array2[1].suit != array[1].suit || array2[2].suit != array[2].suit) && array2[0].rank != 15) {
                                                    n4 = 0;
                                                }
                                                else if (n3 == 4 && array2[0].suit != array[0].suit) {
                                                    n4 = 0;
                                                }
                                            }
                                        }
                                    }
                                    else if (array[array.length - 1].rank == 15) {
                                        if (array.length == 1 && (n3 == 10 || n3 == 11 || n3 == 12)) {
                                            n4 = 1;
                                        }
                                        else if (array.length == 2 && (n3 == 11 || n3 == 12)) {
                                            n4 = 1;
                                        }
                                    }
                                    else if (n2 == 10 && (n3 == 12 || n3 == 11)) {
                                        n4 = 1;
                                    }
                                    else if (n2 == 11 && n3 == 12) {
                                        n4 = 1;
                                    }
                                    n = n4;
                                }
                            }
                            else {
                                final byte[] array3 = a;
                                final int n5 = 0;
                                final byte[] array4 = array3;
                                boolean b3 = false;
                                if (array4.length == 8 && isDoubleStraight(array4, n5)) {
                                    b3 = true;
                                }
                                if (b3) {
                                    if (this.cardCount == 10 || this.cardCount == 11 || ((this.currentPlayedCards.length == 1 || this.currentPlayedCards.length == 2) && this.currentPlayedCards[this.currentPlayedCards.length - 1].rank == 15)) {
                                        GameBoardControl.moveType = 12;
                                        n = 1;
                                    }
                                    else {
                                        n = 0;
                                    }
                                }
                                else {
                                    n = 0;
                                }
                            }
                            if (n != 0) {
                                for (int k = 0; k < GameBoardControl.selectedCardCount; ++k) {
                                    this.selectedCards[k] = GameBoardControl.tempSelectedCards[k].cardValue;
                                }
                                MessageHandler.a(BigTwoGameScreen.gameRoomId, BigTwoGameScreen.currentGroupName, GameBoardControl.moveType, this.selectedCards);
                                this.isMoveSubmitted = true;
                                break Label_1049;
                            }
                        }
                        this.resetSelection();
                    }
                    break Label_1049;
                }
                case 17: {
                    b = true;
                    break;
                }
            }
        }
        return b;
    }
    
    public final void resetSelection() {
        for (int i = 0; i < GameBoardControl.totalCardCount; ++i) {
            if (GameBoardControl.allCards[i].isSelected) {
                GameBoardControl.allCards[i].isSelected = false;
            }
        }
        arrangeCards();
        GameBoardControl.selectedCardCount = 0;
        if (this.selectedCardIndex >= GameBoardControl.totalCardCount) {
            this.selectedCardIndex = GameBoardControl.totalCardCount - 1;
        }
        this.isMoveSubmitted = false;
    }
    
    public final void updatePlayedCards(final byte[] array) {
        int n = 0;
        for (int i = 0; i < GameBoardControl.totalCardCount; ++i) {
            for (int j = 0; j < array.length; ++j) {
                if (GameBoardControl.allCards[i].cardValue == array[j]) {
                    GameBoardControl.allCards[i].isSelected = true;
                    GameBoardControl.allCards[i].isPlayed = true;
                }
                else {
                    GameBoardControl.allCards[i].isSelected = false;
                }
            }
        }
        for (int k = 0; k < GameBoardControl.totalCardCount; ++k) {
            if (!GameBoardControl.allCards[k].isPlayed) {
                GameBoardControl.allCards[n] = GameBoardControl.allCards[k];
                ++n;
            }
        }
        GameBoardControl.totalCardCount -= array.length;
        arrangeCards();
        for (int l = 0; l < GameBoardControl.selectedCardCount; ++l) {
            GameBoardControl.tempSelectedCards[l].setPosition((Screen.e >> 1) - 30 + l * 10, Screen.formHeight - 130 >> 1);
            if (l == GameBoardControl.selectedCardCount - 1) {
                GameBoardControl.tempSelectedCards[l].isVisible = true;
            }
        }
        GameBoardControl.selectedCardCount = 0;
        this.selectedCardIndex = 0;
    }
    
    public final void draw(final Graphics graphics) {
        graphics.setClip(0, -5, Screen.e, Screen.formHeight);
        if (GameBoardControl.isGameEnded) {
            final int n = (Screen.e >> 1) - 50;
            final int n2 = Screen.formHeight - 140 >> 1;
            Card.drawCardBack(graphics, n, n2);
            if (this.animationCardIndex < GameBoardControl.totalCardCount) {
                Card.drawCardBack(graphics, n + (GameBoardControl.allCards[this.animationCardIndex].cX - n) * (this.animationFrame + 1) / 3, n2 + (GameBoardControl.allCards[this.animationCardIndex].cY - n2) * (this.animationFrame + 1) / 3);
            }
            for (int i = 0; i < this.animationCardIndex; ++i) {
                if (!GameBoardControl.allCards[i].isPlayed && this.animationCardIndex < GameBoardControl.totalCardCount) {
                    GameBoardControl.allCards[i].draw(graphics);
                }
            }
            return;
        }
        if (GameBoardControl.isShowingAllCards) {
            this.tempCardCount = this.allPlayersCards.length;
            for (int j = 0; j < this.tempCardCount; ++j) {
                this.tempPlayerCardCount = this.allPlayersCards[j].length;
                for (int k = 0; k < this.tempPlayerCardCount; ++k) {
                    if (this.allPlayersCards[j][k] != null) {
                        this.allPlayersCards[j][k].draw(graphics);
                    }
                }
            }
        }
        else {
            for (int l = 0; l < GameBoardControl.totalCardCount; ++l) {
                if (!GameBoardControl.allCards[l].isPlayed) {
                    GameBoardControl.allCards[l].draw(graphics);
                }
            }
        }
        if (BigTwoGameScreen.instance.isAnimating && GameBoardControl.isAnimating) {
            if (this.isSpectatorMode) {
                this.tempCardCount = this.animationCards.length;
                for (int n3 = 0; n3 < this.tempCardCount; ++n3) {
                    if (this.animationCards[n3] != null) {
                        final int n4 = this.animationCards.length - 1;
                        this.animationCards[n3].drawBack(graphics);
                    }
                }
            }
            else {
                try {
                    if (this.previousCards != null) {
                        this.a(graphics, this.previousCards);
                    }
                    if (this.currentPlayedCards != null) {
                        this.a(graphics, this.currentPlayedCards);
                    }
                }
                catch (final NullPointerException ex) {
                    final Throwable t;
                    ex.printStackTrace();
                }
            }
        }
        if (!GameBoardControl.isShowingAllCards) {
            graphics.drawImage(Card.handImage, GameBoardControl.cardSpacingX + 2 + this.selectedCardIndex * 11, this.cardAreaY, 0);
        }
        for (int n5 = 0; n5 < BigTwoGameScreen.instance.players.length; ++n5) {
            final GamePlayer GamePlayer;
            if ((GamePlayer = BigTwoGameScreen.instance.players[n5]).isShowingEmote) {
                GamePlayer.drawEmote(graphics, GamePlayer.x, GamePlayer.y - 5);
            }
        }
    }
    
    public final void animateCardMove(final byte[] array, final int z, final int aa) {
        this.isAnimatingMove = true;
        this.previousCards = this.currentPlayedCards;
        this.tempCardCount = array.length;
        this.currentPlayedCards = new Card[this.tempCardCount];
        for (int i = 0; i < this.tempCardCount; ++i) {
            this.currentPlayedCards[i] = new Card();
            this.currentPlayedCards[i].cardValue = array[i];
            this.currentPlayedCards[i].rank = (byte)(array[i] >> 2);
            this.currentPlayedCards[i].suit = (byte)(array[i] % 4);
            this.currentPlayedCards[i].cX = (Screen.e >> 1) - 50 + i * 14;
            this.currentPlayedCards[i].cY = Screen.formHeight - 140 >> 1;
            if (i == array.length - 1) {
                this.currentPlayedCards[i].isVisible = true;
            }
        }
        this.targetX = Screen.e / 3;
        this.targetY = Screen.formHeight - 140 >> 1;
        this.deltaX = (this.targetX - z) / 5;
        this.deltaY = (this.targetY - aa) / 5;
        this.currentX = z;
        this.currentY = aa;
        this.tempCardCount = this.currentPlayedCards.length;
        for (int j = 0; j < this.tempCardCount; ++j) {
            this.currentPlayedCards[j].setPosition(z + j * 10, aa);
        }
    }
    
    private void a(final Graphics graphics, final Card[] array) {
        try {
            this.tempCardCount = array.length;
            for (int i = 0; i < this.tempCardCount; ++i) {
                if (array[i] != null) {
                    array[i].draw(graphics);
                }
            }
        }
        catch (final NullPointerException ex) {
            final Throwable t;
            ex.printStackTrace();
        }
    }
    
    public final void update() {
        final long currentTimeMillis;
        if (GameBoardControl.isGameEnded && (currentTimeMillis = System.currentTimeMillis()) - this.lastAnimationTime >= this.animationDelay) {
            this.lastAnimationTime = currentTimeMillis;
            this.animationFrame = (this.animationFrame + 1) % 2;
            if (this.animationFrame == 0) {
                ++this.animationCardIndex;
                if (this.animationCardIndex > GameBoardControl.totalCardCount) {
                    GameBoardControl.isGameEnded = false;
                    this.animationCardIndex = 0;
                }
            }
        }
        if (this.isAnimatingMove && !GameBoardControl.isShowingAllCards) {
            final int z = this.currentX;
            final int aa = this.currentY;
            Label_0155: {
                if (UIBuddyListControl.c(this.targetX - this.currentX) > UIBuddyListControl.c(this.deltaX)) {
                    this.currentX += this.deltaX;
                    if (this.currentX != z) {
                        break Label_0155;
                    }
                }
                this.currentX = this.targetX;
            }
            Label_0206: {
                if (UIBuddyListControl.c(this.targetY - this.currentY) > UIBuddyListControl.c(this.deltaY)) {
                    this.currentY += this.deltaY;
                    if (this.currentY != aa) {
                        break Label_0206;
                    }
                }
                this.currentY = this.targetY;
            }
            this.tempCardCount = this.currentPlayedCards.length;
            for (int i = 0; i < this.tempCardCount; ++i) {
                this.currentPlayedCards[i].setPosition(this.currentX + i * 10, this.currentY);
            }
            if (this.currentX == this.targetX && this.currentY == this.targetY) {
                this.previousCards = null;
                this.isAnimatingMove = false;
            }
        }
        ++BigTwoGameScreen.frameCounter;
    }
    
    private static void arrangeCards() {
        for (int i = 0; i < GameBoardControl.totalCardCount; ++i) {
            GameBoardControl.allCards[i].setPosition(GameBoardControl.cardSpacingX + i * 11, Screen.formHeight - GameBoardControl.cardSpacingY);
        }
    }
    
    public final void validateMove() {
        this.allPlayersCards = null;
        System.gc();
        this.allPlayersCards = new Card[BigTwoGameScreen.instance.totalPlayers][];
        GameBoardControl.isShowingAllCards = true;
        this.tempCardCount = BigTwoGameScreen.instance.gamePlayerNames.length;
        for (byte b = 0; b < BigTwoGameScreen.instance.totalPlayers; ++b) {
            final String a = BigTwoGameScreen.instance.players[b].playerName;
            final byte k = BigTwoGameScreen.instance.players[b].position;
            for (int i = 0; i < this.tempCardCount; ++i) {
                if (BigTwoGameScreen.instance.gamePlayerNames[i].equals(a)) {
                    this.allPlayersCards[b] = new Card[BigTwoGameScreen.instance.allPlayerCards[i].length];
                    int n = 0;
                    int j = 0;
                    if (k == 0) {
                        n = GameBoardControl.cardSpacingX;
                        j = Screen.formHeight - GameBoardControl.cardSpacingY;
                    }
                    else if (k == 1) {
                        n = Screen.e - this.allPlayersCards[b].length * 10 - 20;
                        j = (Screen.formHeight >> 1) - 5;
                    }
                    else if (k == 2) {
                        n = GameBoardControl.cardSpacingX;
                        j = 0;
                    }
                    else if (k == 3) {
                        n = 0;
                        j = (Screen.formHeight >> 1) - 15;
                    }
                    this.tempPlayerCardCount = this.allPlayersCards[b].length;
                    for (int l = 0; l < this.tempPlayerCardCount; ++l) {
                        this.allPlayersCards[b][l] = new Card();
                        this.allPlayersCards[b][l].cardValue = BigTwoGameScreen.instance.allPlayerCards[i][l];
                        this.allPlayersCards[b][l].rank = (byte)(BigTwoGameScreen.instance.allPlayerCards[i][l] >> 2);
                        this.allPlayersCards[b][l].suit = (byte)(BigTwoGameScreen.instance.allPlayerCards[i][l] % 4);
                        this.allPlayersCards[b][l].cX = n + l * 11;
                        this.allPlayersCards[b][l].cY = j;
                        if (l == this.allPlayersCards[b].length - 1) {
                            this.allPlayersCards[b][l].isVisible = true;
                        }
                    }
                    break;
                }
            }
        }
        BigTwoGameScreen.instance.showGameResults();
    }
    
    private static int getCardValue(final Card[] array) {
        if (array.length == 0) {
            return 0;
        }
        return array[0].cardValue;
    }
    
    private boolean checkMoveValid(final byte[] array, final int n) {
        boolean b = false;
        if (n == 1) {
            final int[] array2 = new int[GameBoardControl.totalCardCount - array.length];
            int n2 = 0;
            for (int i = 0; i < GameBoardControl.totalCardCount; ++i) {
                if (!GameBoardControl.allCards[i].isSelected) {
                    array2[n2] = GameBoardControl.allCards[i].rank;
                    ++n2;
                }
            }
            this.tempCardCount = array2.length;
            for (int j = 0; j < this.tempCardCount; ++j) {
                if (array2[j] != 15) {
                    b = true;
                    break;
                }
            }
            if (array2.length == 0) {
                b = true;
            }
            b = (b && validateCardCombination(array, n));
        }
        else if (n == 0) {
            b = validateCardCombination(array, n);
        }
        return b;
    }
    
    private static boolean validateCardCombination(byte[] var0, int var1) {
      boolean var2;
      if (var0.length == 1) {
         moveType = 1;
         var2 = true;
      } else if (var0.length == 2) {
         var2 = false;
         byte[] var3;
         if ((var3 = Card.getRanksFromValues(var0)).length == 2 && var3[0] == var3[1]) {
            var2 = true;
         }

         if (var2 && var1 == 1 && !Card.areOppositeColors(var0[0], var0[1]) && var3[0] != 15) {
            var2 = false;
         }

         if (var2 = var2) {
            moveType = 2;
         }
      } else if (var0.length == 3) {
         if (var2 = isStraight(var0, var1)) {
            moveType = 4;
         } else {
            byte[] var5;
            if (var2 = (var5 = Card.getRanksFromValues(var0)).length == 3 && var5[0] == var5[1] && var5[1] == var5[2]) {
               moveType = 3;
            }
         }
      } else if (var0.length == 4) {
         if (var2 = isStraight(var0, var1)) {
            moveType = 4;
         } else {
            var2 = false;
            byte[] var7;
            if ((var7 = Card.getRanksFromValues(var0)).length == 4 && var7[0] == var7[1] && var7[2] == var7[3] && var7[0] == var7[2]) {
               var2 = true;
            }

            if (var2 = var2) {
               moveType = 11;
            }
         }
      } else if (var0.length == 5) {
         if (var2 = isStraight(var0, var1)) {
            moveType = 4;
         }
      } else if (var0.length == 6) {
         if (var2 = isStraight(var0, var1)) {
            moveType = 4;
         } else if (var2 = isDoubleStraight(var0, var1)) {
            moveType = 10;
         }
      } else if (var0.length == 7) {
         if (var2 = isStraight(var0, var1)) {
            moveType = 4;
         }
      } else if (var0.length == 8) {
         if (var2 = isStraight(var0, var1)) {
            moveType = 4;
         } else if (var2 = isDoubleStraight(var0, var1)) {
            moveType = 12;
         }
      } else if (var0.length == 9) {
         if (var2 = isStraight(var0, var1)) {
            moveType = 4;
         }
      } else if (var0.length == 10) {
         if (var2 = isStraight(var0, var1)) {
            moveType = 4;
         }
      } else if (var0.length == 11) {
         if (var2 = isStraight(var0, var1)) {
            moveType = 4;
         }
      } else if (var0.length == 12) {
         if (var2 = isStraight(var0, var1)) {
            moveType = 4;
         }
      } else {
         var2 = false;
      }

      return var2;
   }
    
    private static boolean isDoubleStraight(final byte[] array, final int n) {
        boolean b = false;
        if (array.length % 2 == 0) {
            final int n2;
            final byte[] array2 = new byte[n2 = array.length >> 1];
            final byte[] array3 = new byte[n2];
            for (int i = 0; i < n2; ++i) {
                array2[i] = array[i << 1];
                array3[i] = array[1 + (i << 1)];
            }
            if (isStraight(array2, n) && isStraight(array3, n) && Card.getRankFromValue(array2[0]) == Card.getRankFromValue(array3[0])) {
                b = true;
                if (n == 1 && !Card.areOppositeColors(array2[0], array3[0])) {
                    b = false;
                }
            }
        }
        return b;
    }
    
    private static boolean isStraight(final byte[] array, final int n) {
        boolean b = true;
        final byte[] a;
        if ((a = Card.getRanksFromValues(array))[a.length - 1] == 15) {
            b = false;
        }
        else {
            for (int i = 0; i < a.length - 1; ++i) {
                if (a[i + 1] - 1 != a[i]) {
                    b = false;
                    break;
                }
            }
        }
        if (n == 1 && b) {
            for (int length = array.length, j = 1; j < length; ++j) {
                if (Card.getSuitFromValue((int)array[j]) != Card.getSuitFromValue((int)array[j - 1])) {
                    b = false;
                    break;
                }
            }
        }
        return b;
    }
    
    public final boolean handleSoftKey(final int n) {
        return false;
    }
}
