package home.thienph.xyahoo.components;

import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.BigTwoGameScreen;
import home.thienph.xyahoo.screens.Screen;
import home.thienph.xyahoo.utils.TextRenderer;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import java.util.Vector;

public final class GamePlayer extends UIControlBase
{
    public String playerName;
    public long playerBalance;
    public int cardCount;
    private boolean isHost;
    public String statusText;
    public int x;
    public int y;
    public boolean isReady;
    public boolean isPlaying;
    public byte[] cards;
    public boolean isHidden;
    public byte position;
    public boolean isMyTurn;
    private String displayName;
    private boolean isOnline;
    private String chatMessage;
    public boolean isShowingEmote;
    public byte emoteTime;
    public int emoteIndex;
    public String rankText;
    public int scoreValue;
    public Integer textColor;
    public int avatarIndex;
    private int imageAnchor;
    private int avatarWidth;
    private int avatarHeight;
    private long countdownDuration;
    public boolean isCountingDown;
    private int remainingTime;
    private long countdownStartTime;
    
    static {
        final int e = Screen.e;
        final int f = Screen.formHeight;
        final int b = Screen.topMargin;
        final int f2 = GameManager.headerHeight;
    }
    
    public GamePlayer() {
        this.statusText = "";
        this.chatMessage = "";
        this.avatarWidth = 20;
        this.avatarHeight = 32;
        this.isHidden = false;
        new Vector();
        new Vector();
        new Vector();
    }
    
    public GamePlayer(final String playerName, final long playerBalance, final int emoteTime, final int cardCount, final boolean isHost, final String c2, final int statusText, final Integer x) {
        this.statusText = "";
        this.chatMessage = "";
        this.avatarWidth = 20;
        this.avatarHeight = 32;
        this.isHidden = false;
        this.isHost = isHost;
        if (playerName == null) {
            this.playerName = "";
        }
        else {
            this.playerName = playerName;
        }
        this.cardCount = cardCount;
        this.playerBalance = playerBalance;
        this.position = (byte) emoteTime;
        if (this.cardCount == -1) {
            final Image[] a2 = BuddyListControl.statusIcons;
        }
        final int n2 = Screen.formHeight - GameManager.headerHeight - 40 - ((32 > TextRenderer.fontHeight << 1) ? 32 : (TextRenderer.fontHeight << 1)) - 5;
        if (emoteTime % 2 == 0) {
            this.x = (Screen.e >> 1) - 10;
            this.imageAnchor = 6;
            this.y = ((emoteTime == 0) ? n2 : TextRenderer.fontHeight);
        }
        else {
            this.y = n2 >> 1;
            this.imageAnchor = 20;
            this.x = ((emoteTime == 1) ? (Screen.e - TextRenderer.computeTextWidth("100000 " + getCurrencyName(), TextRenderer.charWidth)) : 10);
        }
        this.displayName = TextRenderer.truncate(this.playerName, 9);
        this.rankText = c2;
        this.scoreValue = statusText;
        this.textColor = x;
    }
    
    private static String getCurrencyName() {
        if (BigTwoGameScreen.instance.isInitialized) {
            return "gold";
        }
        return "xuxu";
    }
    
    public final void drawEmote(final Graphics graphics, final int n, int n2) {
        if (5 - (byte)(System.currentTimeMillis() / 1000L - this.emoteTime) > 0) {
            final int n3 = n2 - 10;
            n2 = n;
            graphics.setColor(14545919);
            graphics.drawRoundRect(n2 - 4, n3 - 4, 26, 26, 5, 5);
            graphics.setColor(872315);
            graphics.fillTriangle(n2 - 3, n3 - 3, n2 + 10, n3 + 30, n2 + 13, n3 - 3);
            graphics.setColor(14545919);
            graphics.drawLine(n2 - 3, n3 - 3, n2 + 10, n3 + 30);
            graphics.drawLine(n2 + 10, n3 + 30, n2 + 13, n3 - 3);
            graphics.setColor(872315);
            graphics.fillRoundRect(n2 - 3, n3 - 3, 25, 25, 5, 5);
            graphics.drawRegion(GameManager.smileyIcons, this.emoteIndex * 18, 0, 18, 18, 0, n2, n3, 20);
            graphics.setColor(0);
            return;
        }
        this.isShowingEmote = false;
    }
    
    private void drawRankInfo(final Graphics graphics, final int n, final int n2) {
        if (BigTwoGameScreen.instance.isInitialized && this.rankText != null) {
            graphics.setColor(((Integer)this.textColor).intValue());
            TextRenderer.getFontRenderer(this.textColor).drawText(this.rankText, n, n2, 2, graphics, TextRenderer.charWidth, TextRenderer.fontHeight);
            TextRenderer.getFontRenderer(this.textColor).drawText(String.valueOf(this.scoreValue) + "\u0111", n, n2 + 13, 2, graphics, TextRenderer.charWidth, TextRenderer.fontHeight);
        }
    }
    
    public final void draw(final Graphics graphics) {
        if (this.playerName != null && !this.isHidden) {
            graphics.drawImage(BigTwoGameScreen.avatarImages[this.avatarIndex], this.x, this.y, this.imageAnchor);
            graphics.setColor(16777215);
            TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(String.valueOf(TextConstant.bet()) + ": " + BigTwoGameScreen.instance.playerBalance + " " + getCurrencyName(), 5, 2 - TextRenderer.fontHeight, graphics);
            if (!BigTwoGameScreen.instance.isWaitingResponse) {
                if (this.isHost) {
                    this.statusText = TextConstant.host();
                }
                else if (this.isReady) {
                    this.statusText = TextConstant.ready();
                }
                else {
                    this.statusText = "";
                }
                if (this.isShowingEmote) {
                    this.drawEmote(graphics, this.x, this.y - 20);
                }
            }
            else if (!this.isPlaying) {
                this.statusText = "";
            }
            graphics.setColor(16777215);
            if (this.position == 1 || this.position == 3) {
                TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(this.statusText, this.x, this.y - 15, graphics);
                this.drawRankInfo(graphics, this.x + 20, this.y - 45);
            }
            else {
                TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(this.statusText, this.x - 64, this.y - 10, graphics);
                this.drawRankInfo(graphics, this.x - 30, this.y + 5);
            }
            if (this.isMyTurn) {
                if (this.position == 1 || this.position == 3) {
                    graphics.drawImage(Card.lostTurnImage, this.x + (this.avatarWidth >> 1), this.y - 2, 33);
                }
                else {
                    graphics.drawImage(Card.lostTurnImage, this.x - 13, this.y, 0);
                }
            }
            graphics.setColor(16777215);
            if (this.position == 1 || this.position == 3) {
                TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(this.displayName, this.x, this.y + this.avatarHeight, graphics);
                TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(String.valueOf(this.playerBalance) + " " + getCurrencyName(), this.x, this.y + this.avatarHeight + TextRenderer.fontHeight, graphics);
            }
            else {
                TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(this.displayName, this.x + 7 + this.avatarWidth, this.y - 7, graphics);
                TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(String.valueOf(this.playerBalance) + " " + getCurrencyName(), this.x + 7 + this.avatarWidth, this.y + 7, graphics);
            }
            if (this.isCountingDown && this.remainingTime >= 0) {
                graphics.setColor(16726823);
                if (this.position == 1 || this.position == 3) {
                    BigTwoGameScreen.instance.rightCommand.label = "";
                    BigTwoGameScreen.instance.centerCommand.label = "";
                    TextRenderer.getFontRenderer(TextRenderer.colorPrimary).drawText(new StringBuffer(String.valueOf(this.remainingTime)).toString(), this.x + 2, this.y - 15, graphics);
                    return;
                }
                if (this.position == 2) {
                    BigTwoGameScreen.instance.rightCommand.label = "";
                    BigTwoGameScreen.instance.centerCommand.label = "";
                    TextRenderer.getFontRenderer(TextRenderer.colorPrimary).drawText(new StringBuffer(String.valueOf(this.remainingTime)).toString(), this.x - 17, this.y - 5, graphics);
                    return;
                }
                BigTwoGameScreen.instance.rightCommand.label = TextConstant.deny();
                BigTwoGameScreen.instance.centerCommand.label = TextConstant.dropCard();
                TextRenderer.getFontRenderer(TextRenderer.colorPrimary).drawText(new StringBuffer(String.valueOf(this.remainingTime)).toString(), this.x - 17, this.y - 5, graphics);
            }
        }
    }
    
    public final void setReadyState(final boolean b) {
        this.isReady = false;
        this.isOnline = false;
    }
    
    public final void startCountdown(final int n) {
        this.isCountingDown = true;
        this.countdownDuration = 30L;
        this.countdownStartTime = System.currentTimeMillis();
    }
    
    public final boolean handleKeyInput(final int n) {
        return true;
    }
    
    public final void update() {
        if (this.isCountingDown) {
            this.remainingTime = (int)(this.countdownDuration - (int)((System.currentTimeMillis() - this.countdownStartTime) / 1000L));
            if (this.remainingTime == 0) {
                this.isCountingDown = false;
            }
        }
    }
    
    public final boolean handleSoftKey(final int n) {
        return false;
    }
}
