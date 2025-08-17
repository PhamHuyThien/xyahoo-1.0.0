package home.thienph.xyahoo;

import java.io.InputStream;

final class thien_hd
implements Runnable {
    thien_hd() {
    }

    public final void run() {
        try {
            while (thien_hc.a()) {
                Object object;
                int n;
                Object object2 = this;
                object2 = thien_hc.a;
                int n2 = thien_hc.h();
                byte[] byArray = new byte[n2];
                int n3 = 0;
                while (n3 >= 0 && n3 < n2) {
                    n = ((InputStream)object2).read(byArray, n3, n2 - n3);
                    n3 += n;
                }
                if (n3 == -1) {
                    object = null;
                } else {
                    int n4;
                    n = thien_hd.a(byArray);
                    n3 = 0;
                    while (n3 >= 0 && n3 < 4) {
                        n4 = ((InputStream)object2).read(byArray, n3, n2 - n3);
                        n3 += n4;
                    }
                    if (n3 == -1) {
                        object = null;
                    } else {
                        int n5;
                        n4 = thien_hd.a(byArray);
                        n3 = 0;
                        while (n3 >= 0 && n3 < 4) {
                            n5 = ((InputStream)object2).read(byArray, n3, n2 - n3);
                            n3 += n5;
                        }
                        if (n3 == -1) {
                            object = null;
                        } else {
                            n5 = thien_hd.a(byArray);
                            int n6 = n - 8;
                            byte[] byArray2 = new byte[n6];
                            n3 = 0;
                            while (n3 >= 0 && n3 < n6) {
                                int n7 = ((InputStream)object2).read(byArray2, n3, n6 - n3);
                                if (n7 <= 0) continue;
                                n3 += n7;
                            }
                            if (n3 == -1) {
                                object = null;
                            } else {
                                thien_hc.h += n2 + n6;
                                object = object2 = new thien_hb(n4, n5, byArray2);
                            }
                        }
                    }
                }
                if (object != null) {
                    Integer n8 = new Integer(((thien_hb)object2).c());
                    thien_hc.b = (thien_hh)thien_hc.f().get(n8);
                    if (thien_hc.b == null) continue;
                    thien_hc.b.a((thien_hb)object2);
                    continue;
                }
                break;
            }
        }
        catch (Exception exception) {}
        try {
            if (thien_hc.c && thien_hc.b != null) {
                thien_hc.b.c();
            }
            if (thien_hc.c() != null) {
                thien_hc.g();
                return;
            }
        }
        catch (Exception exception) {}
    }

    private static int a(byte[] byArray) {
        int n = 0;
        int n2 = 0;
        while (n2 < 4) {
            n <<= 8;
            n |= 0xFF & byArray[n2];
            ++n2;
        }
        return n;
    }
}
