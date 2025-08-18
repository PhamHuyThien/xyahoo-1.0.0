package home.thienph.xyahoo;

import java.io.IOException;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class thien_aq {
    private static Image b;
    public static int a;
    private static int c;
    private static int d;
    private static String e;
    private static byte[] f;
    private static Font g;

    static {
        a = 30;
        c = 4;
        e = "0123456789";
        f = new byte[]{8, 8, 8, 8, 8, 8, 8, 8, 8, 8};
        g = Font.getFont((int)0, (int)0, (int)8);
        g.getHeight();
        String string = " 1234567890_-+=\\~`!@#$%^&*()|qwertyuiop[]{}asdfghjkl;':\"zxcvbnm,./<>?ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        g.stringWidth(string);
        string.length();
    }

    public static int a(String string) {
        return g.stringWidth(string);
    }

    public static int a() {
        return g.getHeight();
    }

    public static void b() {
        b = null;
        System.gc();
    }

    public static Image c() {
        if (b == null) {
            try {
                b = Image.createImage((String)"/Logo.png");
            }
            catch (IOException iOException) {}
        }
        return b;
    }

    public static int a(String string, int n) {
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
            d = e.indexOf(n2);
            n2 = n4 + (d != -1 ? f[d] - (c2 == '\u0000' ? 1 : 2) : thien_aq.c);
            ++n3;
        }
        return n2;
    }

    public static void a(Graphics graphics, String string, int n, int n2, int n3) {
        graphics.setFont(g);
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
