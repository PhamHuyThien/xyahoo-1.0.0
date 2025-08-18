package home.thienph.xyahoo;

import java.io.IOException;
import java.util.Vector;

final class thien_he implements Runnable {
    private final Vector a = new Vector();

    public thien_he() {
    }

    public final void a(Packet var1) {
        this.a.addElement(var1);
    }

    private static byte[] a(int var0) {
        byte[] var1 = new byte[4];

        for (int var2 = 3; var2 >= 0; var2--) {
            var1[var2] = (byte) var0;
            var0 >>= 8;
        }

        return var1;
    }

    public final void run() {
        while (thien_hc.a()) {
            try {
                while (this.a.size() > 0) {
                    long var1 = System.currentTimeMillis();
                    Packet var3 = (Packet) this.a.elementAt(0);
                    this.a.removeElementAt(0);
                    ByteBuffer var4 = var3.getPayload();
                    int var5;
                    byte[] var6 = a(var5 = 8 + var4.getLength());
                    thien_hc.e().write(var6, 0, 4);
                    thien_hc.e().write(a(var3.getCommandId()), 0, 4);
                    thien_hc.e().write(a(var3.getType()), 0, 4);
                    thien_hc.e().write(var4.getBuffer(), 0, var5 - 8);
                    thien_hc.g += var5 + 4;
                    thien_hc.e().flush();
                    long var7;
                    if ((var7 = 100L - (System.currentTimeMillis() - var1)) > 0L) {
                        Thread.sleep(var7);
                    }
                }

                Thread.sleep(50L);
            } catch (IOException var9) {
                var9.printStackTrace();
                thien_hc.b();
            } catch (Exception var10) {
            }
        }

        if (thien_hc.c && thien_hc.b != null) {
            thien_hc.b.c();
        }
    }
}
