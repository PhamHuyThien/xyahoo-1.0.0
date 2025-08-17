package home.thienph.xyahoo;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.util.Hashtable;
import javax.microedition.io.SocketConnection;

public final class thien_hc {
    private static DataOutputStream i;
    public static InputStream a;
    public static thien_hh b;
    private static SocketConnection j;
    public static boolean c;
    public static boolean d;
    private static thien_he k;
    private static Thread l;
    public static Thread e;
    public static Thread f;
    public static int g;
    public static int h;
    private static int m;
    private static Hashtable n;

    static {
        m = 4;
        k = new thien_he();
        n = new Hashtable();
    }

    public static boolean a() {
        return c;
    }

    public static void a(int n, thien_hh thien_hh2) {
        Integer n2 = new Integer(n);
        if (thien_hc.n.containsKey(n2)) {
            thien_hc.n.remove(n2);
        }
        thien_hc.n.put(n2, thien_hh2);
    }

    public static void a(String string, String string2, int n, int n2) {
        if (c || d) {
            return;
        }
        j = null;
        l = new Thread(new thien_hf(string, string2, n, n2));
        l.start();
    }

    public static void a(thien_hb thien_hb2) {
        k.a(thien_hb2);
    }

    public static void b() {
        thien_hc.i();
    }

    private static void i() {
        try {
            c = false;
            d = false;
            if (j != null) {
                j.close();
                j = null;
            }
            if (i != null) {
                i.close();
                i = null;
            }
            if (a != null) {
                a.close();
                a = null;
            }
            f = null;
            e = null;
            System.gc();
            return;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
            return;
        }
    }

    static void a(SocketConnection socketConnection) {
        j = socketConnection;
    }

    static SocketConnection c() {
        return j;
    }

    static void a(DataOutputStream dataOutputStream) {
        i = dataOutputStream;
    }

    static thien_he d() {
        return k;
    }

    static DataOutputStream e() {
        return i;
    }

    static Hashtable f() {
        return n;
    }

    static void g() {
        thien_hc.i();
    }

    static int h() {
        return m;
    }
}
