package home.thienph.xyahoo;

import javax.microedition.rms.RecordStore;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Display;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.midlet.MIDlet;

public class Xuka extends MIDlet
{
    public static final int[] a;
    public static String b;
    public static String[] c;
    public static int d;
    public static int e;
    public static String f;
    public static Xuka g;
    public static String h;
    
    static {
        a = new int[] { 11886 };
        Xuka.h = null;
    }
    
    public Xuka() {
        final String appProperty = this.getAppProperty("IP-Address");
        String appProperty2 = this.getAppProperty("App-ID");
        String appProperty3 = this.getAppProperty("Parner-ID");
        Xuka.b = this.getAppProperty("MIDlet-Version");
        Xuka.f = this.getAppProperty("RefCode");
        System.out.println("VERSION = " + Xuka.b + "\nIP = " + appProperty + "\nPARTNER_ID = " + appProperty3 + "\nAPP_ID = " + appProperty2 + "\nREF_CODE = " + Xuka.f);
        Xuka.c = new String[] { (appProperty == null || appProperty.length() == 0) ? "112.78.10.113" : appProperty };
        Xuka.b = ((Xuka.b == null || Xuka.b.length() == 0) ? "1.0.0" : Xuka.b);
        thien_di.b = String.valueOf(Xuka.b) + " Beta";
        Xuka.f = ((Xuka.f == null || Xuka.f.equalsIgnoreCase("200487")) ? "" : (" " + Xuka.f));
        if (appProperty3 == null || appProperty3.length() == 0) {
            appProperty3 = "1";
        }
        if (appProperty2 == null || appProperty2.length() == 0) {
            appProperty2 = "0";
        }
        try {
            Xuka.d = Integer.parseInt(appProperty3);
        }
        catch (final Exception ex) {
            Xuka.d = 1;
        }
        try {
            Xuka.e = Integer.parseInt(appProperty2);
        }
        catch (final Exception ex2) {
            Xuka.e = 0;
        }
        Xuka.h = System.getProperty("microedition.platform");
        new thien_d();
        Xuka.g = this;
    }
    
    public final void a(final String str) {
        try {
            this.platformRequest("tel:" + str);
        }
        catch (final ConnectionNotFoundException ex) {}
    }
    
    protected void startApp() {
        Display.getDisplay((MIDlet)this).setCurrent((Displayable)thien_d.a);
    }
    
    protected void pauseApp() {
    }
    
    protected void destroyApp(final boolean b) {
        thien_d.b = false;
    }
    
    public static void a() {
        thien_d.b = false;
    }
    
    public static void a(String string, String str, final thien_ae thien_ae, final thien_ae thien_ae2, final boolean b) {
        string = String.valueOf(string) + Xuka.f;
        str = str;
        System.out.println("syntax = " + string + "; gate = " + str);
        new Thread(new thien_go(str, string, thien_ae, b, thien_ae2)).start();
    }
    
    public static byte[] b(final String str) {
        byte[] record;
        try {
            final RecordStore openRecordStore;
            record = (openRecordStore = RecordStore.openRecordStore("xk" + str, (boolean)(0 != 0))).getRecord(1);
            openRecordStore.closeRecordStore();
        }
        catch (final Exception ex) {
            return null;
        }
        return record;
    }
    
    public static void a(final String str, final byte[] array) {
        try {
            final RecordStore openRecordStore;
            if ((openRecordStore = RecordStore.openRecordStore("xk" + str, true)).getNumRecords() > 0) {
                openRecordStore.setRecord(1, array, 0, array.length);
            }
            else {
                openRecordStore.addRecord(array, 0, array.length);
            }
            openRecordStore.closeRecordStore();
        }
        catch (final Exception ex) {}
    }
    
    public static void c(final String s) {
        a("xkPW", s.getBytes());
    }
    
    public static void d(final String s) {
        a("YahooID", s.getBytes());
    }
    
    public static void e(final String s) {
        a("YahooPW", s.getBytes());
    }
    
    public static void a(final String s, final boolean b) {
        a(s, new byte[] { (byte)(b ? 1 : 0) });
    }
    
    public static boolean b(String s, final boolean b) {
        final byte[] b2;
        int n2;
        final int n = ((b2 = b(s = s)) == null) ? (n2 = -1) : ((b2[0] == 1) ? (n2 = 1) : (n2 = 0));
        final int n3 = n2;
        if (n == -1) {
            return b;
        }
        return n3 != 0;
    }
    
    public static void f(final String s) {
        a("xkID", s.getBytes());
    }
    
    public static String b() {
        final byte[] b;
        if ((b = b("xkID")) == null) {
            return null;
        }
        return new String(b);
    }
    
    public static void a(final String str, final String s, final boolean b) {
        a(String.valueOf(b ? "yststr" : "ststr") + str, s.getBytes());
    }
    
    public static String c(final String str, final boolean b) {
        final byte[] b2;
        if ((b2 = b(String.valueOf(b ? "yststr" : "ststr") + str)) == null) {
            return null;
        }
        return new String(b2);
    }
    
    public static String c() {
        final byte[] b;
        if ((b = b("xkPW")) == null) {
            return null;
        }
        return new String(b);
    }
    
    public static String d() {
        final byte[] b;
        if ((b = b("YahooID")) == null) {
            return "";
        }
        return new String(b);
    }
    
    public static String e() {
        final byte[] b;
        if ((b = b("YahooPW")) == null) {
            return "";
        }
        return new String(b);
    }
    
    public static void a(final int n) {
        a("domainYahoo", new byte[] { (byte)n });
    }
    
    public static int f() {
        final byte[] b;
        if ((b = b("domainYahoo")) == null) {
            return 0;
        }
        return b[0];
    }
    
    public static void b(final int n) {
        a("caret", new byte[] { (byte)n });
    }
    
    public static int g() {
        final byte[] b;
        if ((b = b("caret")) == null) {
            return 2;
        }
        return b[0];
    }
    
    public static int g(final String str) {
        final byte[] b;
        if ((b = b("xpam" + str)) == null) {
            return 0;
        }
        return b[0];
    }
    
    public static void h(final String str) {
        a("xpam" + str, new byte[] { 1 });
    }
    
    private static int j() {
        final byte[] b;
        if ((b = b("nIP")) == null) {
            return -1;
        }
        return b[0];
    }
    
    public static int i(final String s) {
        final byte[] b;
        if ((b = b(s)) == null || b.length != 4) {
            return -1;
        }
        return thien_di.a(b[0], b[1], b[2], b[3]);
    }
    
    public static String[] h() {
        final int j;
        if ((j = j()) < 0) {
            return new String[0];
        }
        final String[] array = new String[j];
        for (int i = 0; i < j; ++i) {
            final byte[] b;
            array[i] = (((b = b("_IP" + i)) == null) ? null : new String(b));
        }
        return array;
    }
    
    public static int[] i() {
        final int j;
        if ((j = j()) < 0) {
            return new int[0];
        }
        final int[] array = new int[j];
        for (int i = 0; i < j; ++i) {
            final byte[] b;
            array[i] = Integer.parseInt(((b = b("_Port" + i)) == null) ? null : new String(b));
        }
        return array;
    }
    
    public static void a(final String[] array) {
        a("nIP", new byte[] { (byte)array.length });
        for (int i = 0; i < array.length; ++i) {
            a("_IP" + i, array[i].getBytes());
        }
    }
    
    public static void a(final int[] array) {
        for (int i = 0; i < array.length; ++i) {
            a("_Port" + i, new StringBuffer(String.valueOf(array[i])).toString().getBytes());
        }
    }
}
