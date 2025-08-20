package home.thienph.xyahoo;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class Card {
    public static int CARD_WIDTH = 40;
    public static int CARD_HEIGHT = 54;
    public byte cardValue;
    public byte rank; //Chất bài (A, 2, 3...K), 90%
    public byte suit;
    private static Image[] redCardImages;
    private static Image[] blackCardImages;
    private static Image[] suitImages;
    public boolean isVisible;
    public boolean isSelected;
    public boolean isPlayed;
    public int cX;
    public int cY;
    private static int RANK_OFFSET_X;
    private static int RANK_OFFSET_Y;
    private static int SUIT_OFFSET_X;
    private static int SUIT_OFFSET_Y;
    private static int RANK_X;
    private static int RANK_Y;
    private static int SUIT_X;
    private static int SUIT_Y;
    private static Image cardBackImage;
    private static Image cardFrontImage;
    public static Image lostTurnImage;
    public static Image handImage;

    static {
        RANK_OFFSET_X = 12;
        RANK_OFFSET_Y = 16;
        SUIT_OFFSET_X = 12;
        SUIT_OFFSET_Y = 38;
        RANK_X = 6;
        RANK_Y = 8;
        SUIT_X = 6;
        SUIT_Y = 21;
    }

    public static byte[] getCardValues(Card[] cardArray) {
        int n = cardArray.length;
        byte[] byArray = new byte[n];
        while (--n >= 0) {
            byArray[n] = cardArray[n].cardValue;
        }
        return byArray;
    }

    public static byte[] getRanksFromValues(byte[] byArray) {
        int n = byArray.length;
        byte[] byArray2 = new byte[n];
        while (--n >= 0) {
            byte by = byArray[n];
            byArray2[n] = (byte)(by >> 2);
        }
        return byArray2;
    }

    public static byte getRankFromValue(byte by) {
        return (byte)(by >> 2);
    }

    public static int getSuitFromValue(int n) {
        return n % 4;
    }

    public static boolean areOppositeColors(int n, int n2) {
        block3: {
            block2: {
                int n3 = n;
                if (n3 % 4 + (n3 = n2) % 4 == 1) break block2;
                n3 = n;
                if (n3 % 4 + (n3 = n2) % 4 != 5) break block3;
            }
            return true;
        }
        return false;
    }

    public final void setPosition(int n, int n2) {
        this.cX = n;
        this.cY = n2;
    }

    public static void loadCardImages() {
        try {
            if (cardBackImage == null) {
                redCardImages = new Image[16];
                blackCardImages = new Image[16];
                suitImages = new Image[4];
                cardFrontImage = Image.createImage((String) "/Card.png");
                handImage = Image.createImage((String) "/Hand.png");
                cardBackImage = Image.createImage((String) "/CardBack.png");
                int n = 0;
                while (n < 16) {
                    if (n < 4) {
                        Card.suitImages[n] = Image.createImage((String) ("/Suit" + (n + 4) + ".png"));
                    }
                    if (n > 2) {
                        Card.blackCardImages[n] = Image.createImage((String) ("/b" + (n - 3) + ".png"));
                        Card.redCardImages[n] = Image.createImage((String) ("/r" + (n - 3) + ".png"));
                    }
                    ++n;
                }
                lostTurnImage = Image.createImage((String) "/LostTurn.png");
                return;
            }
        }
        catch (Exception exception) {
            System.err.println("Card.loadCardImages Exception: " + exception);
            exception.printStackTrace();
        }
    }

    public final void draw(Graphics graphics) {
        int n = this.cY;
        int n2 = this.cX;
        Graphics graphics2 = graphics;
        graphics2.drawImage(cardFrontImage, n2, n, 0);
        boolean bl = this.isVisible;
        int n3 = this.cY + RANK_Y;
        int n4 = this.cX + RANK_X;
        n = this.suit;
        n2 = this.rank;
        graphics2 = graphics;
        if (n == 0 || n == 1) {
            int n5 = n4;
            int n6 = n3;
            n3 = n2;
            n4 = bl ? 1 : 0;
            n = n6;
            n2 = n5;
            graphics2.drawImage(Card.blackCardImages[n3], n2, n, 3);
            if (n4 != 0) {
                graphics2.drawRegion(Card.blackCardImages[n3], 0, 0, 8, 9, 3, CARD_WIDTH + n2 - RANK_OFFSET_X, CARD_HEIGHT + n - RANK_OFFSET_Y, 3);
            }
        } else {
            int n7 = n4;
            int n8 = n3;
            n3 = n2;
            n4 = bl ? 1 : 0;
            n = n8;
            n2 = n7;
            graphics2.drawImage(redCardImages[n3], n2, n, 3);
            if (n4 != 0) {
                graphics2.drawRegion(redCardImages[n3], 0, 0, 8, 9, 3, CARD_WIDTH + n2 - RANK_OFFSET_X, CARD_HEIGHT + n - RANK_OFFSET_Y, 3);
            }
        }
        n3 = this.isVisible ? 1 : 0;
        n4 = this.cY + SUIT_Y;
        n = this.cX + SUIT_X;
        n2 = this.suit;
        graphics2 = graphics;
        int n9 = n;
        int n10 = n4;
        n4 = n2;
        n = n3;
        n2 = n10;
        int n11 = n9;
        Graphics graphics3 = graphics2;
        graphics2.drawImage(suitImages[n4], n11, n2, 3);
        if (n != 0) {
            graphics3.drawRegion(suitImages[n4], 0, 0, 8, 8, 3, CARD_WIDTH + n11 - SUIT_OFFSET_X, CARD_HEIGHT + n2 - SUIT_OFFSET_Y, 3);
        }
    }

    public final void drawBack(Graphics graphics) {
        Card.drawCardBack(graphics, this.cX, this.cY);
    }

    public static void drawCardBack(Graphics graphics, int n, int n2) {
        graphics.drawImage(cardBackImage, n, n2, 20);
    }
}
