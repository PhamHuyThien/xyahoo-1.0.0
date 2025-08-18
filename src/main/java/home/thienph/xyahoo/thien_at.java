package home.thienph.xyahoo;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.TextBox;
import javax.microedition.midlet.MIDlet;

public final class thien_at
extends thien_ac {
    public boolean a = false;
    public boolean b = true;
    public static int c = 2;
    private static final int[] h = new int[]{18, 14, 11, 9, 6, 4, 2};
    private static int i = 0;
    public boolean d;
    private static String[] j = new String[]{" 0", ".,@?!_1'/$-():*+<=>;%&#%^&*[];'/1", "abc2\u00e1\u00e0\u1ea3\u00e3\u1ea1\u00e2\u1ea5\u1ea7\u1ea9\u1eab\u1ead\u0103\u1eaf\u1eb1\u1eb3\u1eb5\u1eb72", "def3\u0111\u00e9\u00e8\u1ebb\u1ebd\u1eb9\u00ea\u1ebf\u1ec1\u1ec3\u1ec5\u1ec73", "ghi4\u00ed\u00ec\u1ec9\u0129\u1ecb4", "jkl5", "mno6\u00f3\u00f2\u1ecf\u00f5\u1ecd\u00f4\u1ed1\u1ed3\u1ed5\u1ed7\u1ed9\u01a1\u1edb\u1edd\u1edf\u1ee1\u1ee36", "pqrs7", "tuv8\u00fa\u00f9\u1ee7\u0169\u1ee5\u01b0\u1ee9\u1eeb\u1eed\u1eef\u1ef18", "wxyz9\u00fd\u1ef3\u1ef7\u1ef9\u1ef59", "*", "#"};
    private String k = "";
    private String l = "";
    private String m = "";
    private int n = 0;
    private int B = 0;
    private int C = 50000;
    private int D = 0;
    private int E = -1984;
    private int F = 0;
    private int G = 0;
    private int H = 10;
    private int I = 0;
    private static boolean J;
    private static int K;
    private int L = 0;
    private static String[] M;
    private static int N;
    public static Canvas e;
    public static MIDlet f;
    private boolean O;
    public int g = 20;
    private int P;

    static {
        M = new String[]{"abc", "Abc", "ABC", "123"};
        N = 11;
    }

    public final void a() {
        Object object;
        TextBox textBox = new TextBox("", "", 500, 0);
        textBox.addCommand(new Command("OK", 4, 0));
        textBox.addCommand(new Command(thien_as.z(), 3, 0));
        textBox.setCommandListener((CommandListener)new thien_au(this, textBox));
        try {
            if (this.d) {
                textBox.setConstraints(3);
            } else if (this.I == 2) {
                textBox.setConstraints(65536);
            } else if (this.I == 1) {
                textBox.setConstraints(2);
            } else {
                textBox.setConstraints(0);
            }
        }
        catch (Exception exception) {
            object = exception;
            exception.printStackTrace();
        }
        object = this;
        textBox.setString(((thien_at)object).k);
        textBox.setMaxSize(this.C);
        Display.getDisplay((MIDlet)f).setCurrent((Displayable)textBox);
    }

    public static void c(int n) {
        if (n == 1) {
            thien_at.j[0] = "0";
            thien_at.j[10] = " *";
            thien_at.j[11] = "#";
            N = 35;
            return;
        }
        if (n == 0) {
            thien_at.j[0] = " 0";
            thien_at.j[10] = "*";
            thien_at.j[11] = "#";
            N = 35;
            return;
        }
        if (n == 2) {
            thien_at.j[0] = "0";
            thien_at.j[10] = "*";
            thien_at.j[11] = " #";
            N = 42;
        }
    }

    private void d() {
        i = thien_w.f + 1;
        this.x = new thien_ab(thien_as.aD(), new thien_av(this));
        K = thien_w.a("ABC", thien_w.j) + 1;
    }

    public thien_at() {
        UIColorPalette.getTextColor();
        this.k = "";
        this.d();
    }

    public thien_at(String string, int n, int n2) {
        UIColorPalette.getTextColor();
        this.k = string;
        this.C = n;
        this.I = n2;
        this.d();
    }

    public final void b() {
        if (this.n > 0 && this.k.length() > 0) {
            this.k = String.valueOf(this.k.substring(0, this.n - 1)) + this.k.substring(this.n, this.k.length());
            --this.n;
            this.g();
            this.h();
        }
    }

    private void g() {
        this.m = this.I == 2 ? this.l : this.k;
        if (this.D < 0 && thien_w.a(this.m, thien_w.j) + this.D < this.s - 4 - 13 - K) {
            this.D = this.s - 10 - K - thien_w.a(this.m, thien_w.j);
        }
        if (this.D + thien_w.a(this.m.substring(0, this.n), thien_w.j) <= 0) {
            this.D = -thien_w.a(this.m.substring(0, this.n), thien_w.j);
            this.D += 40;
        } else if (this.D + thien_w.a(this.m.substring(0, this.n), thien_w.j) >= this.s - 12 - K) {
            this.D = this.s + this.g - K - thien_w.a(this.m.substring(0, this.n), thien_w.j) - 8;
        }
        if (this.D > 0) {
            this.D = 0;
        }
    }

    private void f(int n) {
        this.O = true;
        if (this.d) {
            this.a();
            return;
        }
        if (this.k.length() < this.C) {
            String string = String.valueOf(this.k.substring(0, this.n)) + (char)n;
            if (this.n < this.k.length()) {
                string = String.valueOf(string) + this.k.substring(this.n, this.k.length());
            }
            this.k = string;
            ++this.n;
            this.h();
            this.g();
        }
    }

    public final boolean b(int n) {
        if (this.k.length() <= 0 && n == 16) {
            this.a();
            return false;
        }
        if (n >= 65 && n <= 122) {
            if (this.I == 1) {
                return false;
            }
            J = true;
        }
        if (J) {
            this.O = true;
            if (n == 45) {
                if (n == this.E && this.F < h[c]) {
                    this.m = this.k = String.valueOf(this.k.substring(0, this.n - 1)) + '_';
                    this.h();
                    this.g();
                    this.E = -1984;
                    return false;
                }
                this.E = 45;
            }
            if (n >= 32) {
                this.f(n);
                return false;
            }
        }
        if (n == N) {
            ++this.L;
            if (this.L > 3) {
                this.L = 0;
            }
            this.F = 1;
            this.E = n;
            return false;
        }
        if (n == 42) {
            n = 58;
        }
        if (n == 35) {
            n = 59;
        }
        if (n >= 48 && n <= 59) {
            if (this.I == 0 || this.I == 2) {
                int n2 = n;
                thien_at thien_at2 = this;
                this.O = false;
                if (thien_at2.d) {
                    thien_at2.a();
                } else {
                    if (n2 == thien_at2.E) {
                        thien_at2.G = (thien_at2.G + 1) % j[n2 - 48].length();
                        char c = j[n2 - 48].charAt(thien_at2.G);
                        c = thien_at2.L == 0 ? Character.toLowerCase(c) : (thien_at2.L == 1 ? Character.toUpperCase(c) : (thien_at2.L == 2 ? Character.toUpperCase(c) : j[n2 - 48].charAt(j[n2 - 48].length() - 1)));
                        String string = String.valueOf(thien_at2.k.substring(0, thien_at2.n - 1)) + c;
                        if (thien_at2.n < thien_at2.k.length()) {
                            string = String.valueOf(string) + thien_at2.k.substring(thien_at2.n, thien_at2.k.length());
                        }
                        thien_at2.k = string;
                        thien_at2.F = h[thien_at.c];
                        thien_at2.h();
                    } else if (thien_at2.k.length() < thien_at2.C) {
                        if (thien_at2.L == 1 && thien_at2.E != -1984) {
                            thien_at2.L = 0;
                        }
                        thien_at2.G = 0;
                        char c = j[n2 - 48].charAt(thien_at2.G);
                        c = thien_at2.L == 0 ? Character.toLowerCase(c) : (thien_at2.L == 1 ? Character.toUpperCase(c) : (thien_at2.L == 2 ? Character.toUpperCase(c) : j[n2 - 48].charAt(j[n2 - 48].length() - 1)));
                        String string = String.valueOf(thien_at2.k.substring(0, thien_at2.n)) + c;
                        if (thien_at2.n < thien_at2.k.length()) {
                            string = String.valueOf(string) + thien_at2.k.substring(thien_at2.n, thien_at2.k.length());
                        }
                        thien_at2.k = string;
                        thien_at2.F = h[thien_at.c];
                        ++thien_at2.n;
                        thien_at2.h();
                        thien_at2.g();
                    }
                    thien_at2.E = n2;
                }
            } else if (this.I == 1) {
                this.f(n);
                this.F = 1;
            }
        } else {
            this.G = 0;
            this.E = -1984;
            if (n == 14 && !this.a) {
                if (this.n > 0) {
                    --this.n;
                    this.g();
                    this.H = 10;
                    return false;
                }
            } else {
                if (n == 15) {
                    if (!this.a && this.n < this.k.length()) {
                        ++this.n;
                        this.g();
                        this.H = 10;
                        return false;
                    }
                    boolean bl = this.O = !this.O;
                    return !this.O;
                }
                if (n == 19) {
                    this.b();
                    return false;
                }
                this.E = n;
            }
        }
        return true;
    }

    public final boolean a(int n) {
        if (!J && n < j.length) {
            this.b();
            this.f(j[n].charAt(j[n].length() - 1));
            this.F = h[c];
        }
        if (n == 19) {
            this.a("");
        }
        return true;
    }

    public final void b(int n, int n2) {
        if (this.j()) {
            this.a();
            return;
        }
        this.v.c(this);
    }

    public final void a(Graphics graphics) {
        int n;
        Graphics graphics2;
        int n2 = 0;
        int n3 = this.r + (this.t - thien_w.f >> 1);
        boolean bl = this.j();
        this.m = this.I == 2 ? this.l : this.k;
        graphics.setColor(UIColorPalette.getSecondaryColor());
        if (bl && this.b) {
            n2 = this.q + this.s - 3;
            graphics.setColor(2580);
            graphics.fillRect(this.q + 2, this.r + 2, this.s - 3, this.t - 3);
            if (!J) {
                graphics.setColor(9478569);
                thien_v.a(graphics, n2 - K, this.r + 3, K, this.t - 6);
                graphics.setColor(0xFFFFFF);
                thien_w.a(thien_w.d).a(M[this.L], n2 - (K >> 1) + (thien_w.a ? 0 : 1), n3, 2, graphics, thien_w.j, thien_w.f);
            }
        }
        if (bl) {
        }
        if (!bl) {
            graphics2 = graphics;
            n = 9478569;
        } else {
            graphics2 = graphics;
            n = bl && !this.b ? 11320516 : 14675958;
        }
        graphics2.setColor(n);
        thien_v.a(graphics, this.q + 1, this.r + 1, this.s - 2, this.t - 2);
        n2 = this.r + 1;
        this.P = 4 + this.D + this.q;
        graphics.setClip(this.q + 3, n2 > this.v.r ? n2 : this.v.r, this.s, this.t - 4);
        thien_w.a(thien_w.d).a(this.m, this.P, n3, graphics);
        if (bl) {
            if (this.F == 0 && (this.H > 0 || this.B / 5 % 2 == 0)) {
                graphics.setColor(3981823);
            } else {
                graphics.setColor(0xAAAAFF);
            }
            graphics.fillRect(this.P + thien_w.a(this.m.substring(0, this.n), thien_w.j) + (thien_w.a ? 1 : 0), this.r + (this.t - i) / 2 + 1, 1, i);
        }
    }

    private void h() {
        if (this.I == 2) {
            this.l = "";
            int n = 0;
            while (n < this.k.length()) {
                this.l = String.valueOf(this.l) + "*";
                ++n;
            }
            if (this.F > 0 && this.n > 0) {
                this.l = String.valueOf(this.l.substring(0, this.n - 1)) + this.k.charAt(this.n - 1) + this.l.substring(this.n, this.l.length());
            }
        }
    }

    public final void b(Graphics graphics) {
    }

    public final void e() {
        ++this.B;
        if (this.F > 0) {
            --this.F;
            if (this.F == 0) {
                this.G = 0;
                if (this.L == 1 && this.E != N) {
                    this.L = 0;
                }
                this.E = -1984;
                this.h();
            }
        }
        if (this.H > 0) {
            --this.H;
        }
    }

    public final String c() {
        return this.k;
    }

    public final void a(String string) {
        if (string == null) {
            return;
        }
        this.E = -1984;
        this.F = 0;
        this.G = 0;
        this.k = string;
        this.m = string;
        this.h();
        this.n = string.length();
        this.g();
    }

    public final void b(String string) {
        this.k = String.valueOf(this.k.substring(0, this.n)) + string + this.k.substring(this.n);
        this.h();
        this.n += string.length();
        this.g();
    }

    public final void d(int n) {
        this.C = n;
    }

    public final void e(int n) {
        this.I = n;
    }
}
