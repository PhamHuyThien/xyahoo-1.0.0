package home.thienph.xyahoo;

import javax.microedition.rms.RecordStore;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Display;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.midlet.MIDlet;

public class Xuka extends MIDlet
{
    public static final int[] DEFAULT_PORTS;
    public static String version;
    public static String[] serverIPs;
    public static int partnerId;
    public static int appId;
    public static String refCode;
    public static Xuka instance;
    public static String platformName;
    
    static {
        DEFAULT_PORTS = new int[] { 11886 };
        Xuka.platformName = null;
    }
    
    public Xuka() {
        final String appProperty = this.getAppProperty("IP-Address");
        String appProperty2 = this.getAppProperty("App-ID");
        String appProperty3 = this.getAppProperty("Parner-ID");
        Xuka.version = this.getAppProperty("MIDlet-Version");
        Xuka.refCode = this.getAppProperty("RefCode");
        System.out.println("VERSION = " + Xuka.version + "\nIP = " + appProperty + "\nPARTNER_ID = " + appProperty3 + "\nAPP_ID = " + appProperty2 + "\nREF_CODE = " + Xuka.refCode);
        Xuka.serverIPs = new String[] { (appProperty == null || appProperty.length() == 0) ? "112.78.10.113" : appProperty };
        Xuka.version = ((Xuka.version == null || Xuka.version.length() == 0) ? "1.0.0" : Xuka.version);
        GameManager.b = String.valueOf(Xuka.version) + " Beta";
        Xuka.refCode = ((Xuka.refCode == null || Xuka.refCode.equalsIgnoreCase("200487")) ? "" : (" " + Xuka.refCode));
        if (appProperty3 == null || appProperty3.length() == 0) {
            appProperty3 = "1";
        }
        if (appProperty2 == null || appProperty2.length() == 0) {
            appProperty2 = "0";
        }
        try {
            Xuka.partnerId = Integer.parseInt(appProperty3);
        }
        catch (final Exception ex) {
            Xuka.partnerId = 1;
        }
        try {
            Xuka.appId = Integer.parseInt(appProperty2);
        }
        catch (final Exception ex2) {
            Xuka.appId = 0;
        }
        Xuka.platformName = System.getProperty("microedition.platform");
        new GameCanvas();
        Xuka.instance = this;
    }
    
    public final void callPhone(final String str) {
        try {
            this.platformRequest("tel:" + str);
        }
        catch (final ConnectionNotFoundException ex) {}
    }
    
    protected void startApp() {
        Display.getDisplay((MIDlet)this).setCurrent((Displayable) GameCanvas.instance);
    }
    
    protected void pauseApp() {
    }
    
    protected void destroyApp(final boolean b) {
        GameCanvas.running = false;
    }
    
    public static void stopApp() {
        GameCanvas.running = false;
    }
    
    public static void startThread(String string, String str, final IAction IAction, final IAction IAction2, final boolean b) {
        string = String.valueOf(string) + Xuka.refCode;
        str = str;
        System.out.println("syntax = " + string + "; gate = " + str);
        new Thread(new thien_go(str, string, IAction, b, IAction2)).start();
    }
    
    public static byte[] readRecord(final String str) {
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
    
    public static void writeRecord(final String str, final byte[] array) {
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
    
    public static void savePassword(final String s) {
        writeRecord("xkPW", s.getBytes());
    }
    
    public static void saveYahooID(final String s) {
        writeRecord("YahooID", s.getBytes());
    }
    
    public static void saveYahooPW(final String s) {
        writeRecord("YahooPW", s.getBytes());
    }
    
    public static void saveFlag(final String s, final boolean b) {
        writeRecord(s, new byte[] { (byte)(b ? 1 : 0) });
    }
    
    public static boolean readFlag(String s, final boolean b) {
        final byte[] b2;
        int n2;
        final int n = ((b2 = readRecord(s = s)) == null) ? (n2 = -1) : ((b2[0] == 1) ? (n2 = 1) : (n2 = 0));
        final int n3 = n2;
        if (n == -1) {
            return b;
        }
        return n3 != 0;
    }
    
    public static void saveUserID(final String s) {
        writeRecord("xkID", s.getBytes());
    }
    
    public static String readUserID() {
        final byte[] b;
        if ((b = readRecord("xkID")) == null) {
            return null;
        }
        return new String(b);
    }
    
    public static void saveCustomStr(final String str, final String s, final boolean b) {
        writeRecord(String.valueOf(b ? "yststr" : "ststr") + str, s.getBytes());
    }
    
    public static String readCustomStr(final String str, final boolean b) {
        final byte[] b2;
        if ((b2 = readRecord(String.valueOf(b ? "yststr" : "ststr") + str)) == null) {
            return null;
        }
        return new String(b2);
    }
    
    public static String c() {
        final byte[] b;
        if ((b = readRecord("xkPW")) == null) {
            return null;
        }
        return new String(b);
    }
    
    public static String d() {
        final byte[] b;
        if ((b = readRecord("YahooID")) == null) {
            return "";
        }
        return new String(b);
    }
    
    public static String e() {
        final byte[] b;
        if ((b = readRecord("YahooPW")) == null) {
            return "";
        }
        return new String(b);
    }
    
    public static void saveDomainYahoo(final int n) {
        writeRecord("domainYahoo", new byte[] { (byte)n });
    }
    
    public static int readDomainYahoo() {
        final byte[] b;
        if ((b = readRecord("domainYahoo")) == null) {
            return 0;
        }
        return b[0];
    }
    
    public static void saveCaret(final int n) {
        writeRecord("caret", new byte[] { (byte)n });
    }
    
    public static int readCaret() {
        final byte[] b;
        if ((b = readRecord("caret")) == null) {
            return 2;
        }
        return b[0];
    }
    
    public static int readXpamFlag(final String str) {
        final byte[] b;
        if ((b = readRecord("xpam" + str)) == null) {
            return 0;
        }
        return b[0];
    }
    
    public static void setXpamFlag(final String str) {
        writeRecord("xpam" + str, new byte[] { 1 });
    }
    
    private static int getNumIPs() {
        final byte[] b;
        if ((b = readRecord("nIP")) == null) {
            return -1;
        }
        return b[0];
    }
    
    public static int readIP4toInt(final String s) {
        final byte[] b;
        if ((b = readRecord(s)) == null || b.length != 4) {
            return -1;
        }
        return GameManager.a(b[0], b[1], b[2], b[3]);
    }
    
    public static String[] readAllIPs() {
        final int j;
        if ((j = getNumIPs()) < 0) {
            return new String[0];
        }
        final String[] array = new String[j];
        for (int i = 0; i < j; ++i) {
            final byte[] b;
            array[i] = (((b = readRecord("_IP" + i)) == null) ? null : new String(b));
        }
        return array;
    }
    
    public static int[] readAllPorts() {
        final int j;
        if ((j = getNumIPs()) < 0) {
            return new int[0];
        }
        final int[] array = new int[j];
        for (int i = 0; i < j; ++i) {
            final byte[] b;
            array[i] = Integer.parseInt(((b = readRecord("_Port" + i)) == null) ? null : new String(b));
        }
        return array;
    }
    
    public static void saveAllIPs(final String[] array) {
        writeRecord("nIP", new byte[] { (byte)array.length });
        for (int i = 0; i < array.length; ++i) {
            writeRecord("_IP" + i, array[i].getBytes());
        }
    }
    
    public static void saveAllPorts(final int[] array) {
        for (int i = 0; i < array.length; ++i) {
            writeRecord("_Port" + i, new StringBuffer(String.valueOf(array[i])).toString().getBytes());
        }
    }
}
