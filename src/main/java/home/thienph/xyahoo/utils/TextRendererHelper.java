package home.thienph.xyahoo.utils;

import java.io.IOException;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class TextRendererHelper {
    private static Image logoImage;
    public static int defaultFontSize;
    private static int defaultCharWidth;
    private static int charIndex;
    private static String digitChars;
    private static byte[] charWidths;
    private static Font textFont;

    static {
        defaultFontSize = 30;
        defaultCharWidth = 4;
        digitChars = "0123456789";
        charWidths = new byte[]{8, 8, 8, 8, 8, 8, 8, 8, 8, 8};
        textFont = Font.getFont((int)0, (int)0, (int)8);
        textFont.getHeight();
        String string = " 1234567890_-+=\\~`!@#$%^&*()|qwertyuiop[]{}asdfghjkl;':\"zxcvbnm,./<>?ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        textFont.stringWidth(string);
        string.length();
    }

    public static int computeTextWidth(String string) {
        return textFont.stringWidth(string);
    }

    public static int getFontHeight() {
        return textFont.getHeight();
    }

    public static void releaseLogo() {
        logoImage = null;
        System.gc();
    }

    public static Image getLogo() {
        if (logoImage == null) {
            try {
                logoImage = Image.createImage((String)"/Logo.png");
            }
            catch (IOException iOException) {}
        }
        return logoImage;
    }

    public static int computeTextWidthWithOffset(String string, int n) {
        char c = '\u0001';
        n = string.length();
        boolean bl = false;
        String string2 = string;
        int n2 = 0;
        if ((n += 0) > string2.length()) {
            n = string2.length();
        }
        int n3 = 0;
        while (n3 < n) {
            char c2 = string2.charAt(n3);
            if (c2 == '\n') break;
            int n4 = n2;
            char c3 = c2;
            c2 = c;
            n2 = c3;
            n2 = c3;
            charIndex = digitChars.indexOf(n2);
            n2 = n4 + (charIndex != -1 ? charWidths[charIndex] - (c2 == '\u0000' ? 1 : 2) : TextRendererHelper.defaultCharWidth);
            ++n3;
        }
        return n2;
    }

    public static void drawText(Graphics graphics, String string, int n, int n2, int n3) {
        graphics.setFont(textFont);
        int n4 = 0;
        if (n3 == 0) {
            n4 = 20;
        } else if (n3 == 1) {
            n4 = 17;
        } else if (n3 == 2) {
            n4 = 24;
        }
        graphics.drawString(string, n, n2, n4);
    }
}
