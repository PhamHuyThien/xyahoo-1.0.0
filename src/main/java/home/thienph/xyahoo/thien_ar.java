package home.thienph.xyahoo;

import javax.microedition.lcdui.Graphics;

public final class thien_ar {
    private static int b = 15;
    public static boolean a = false;
    private static final int c = Screen.formHeight - Screen.topMargin;
    private static int d;
    private static int e;
    private static int f;
    private static int g;
    private static boolean h;
    private static int i;

    static {
        f = Screen.e - 3 - 1;
        g = Screen.topMargin + 2;
        h = false;
        i = 0;
    }

    public static void a(int n) {
        d = 100 * c / n;
        b = d > 600 ? d / 100 : 5;
        e = g + c - b;
    }

    public static void a(boolean bl) {
        h = bl;
        i = 0;
    }

    public static void a(Graphics graphics, int n) {
        if (h && d > 1 && a) {
            if ((n = g + n * d / 100) > e) {
                n = e;
            }
            graphics.setColor(7179448);
            graphics.fillRoundRect(f, n, 3, b, 4, 4);
            if (++i > 10) {
                thien_ar.a(false);
            }
        }
    }
}
