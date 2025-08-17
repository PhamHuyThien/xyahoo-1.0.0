package home.thienph.xyahoo;

import javax.microedition.io.Connector;
import javax.wireless.messaging.Message;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;

final class thien_go
implements Runnable {
    private final String a;
    private final String b;
    private final thien_ae c;
    private final boolean d;
    private final thien_ae e;

    thien_go(String string, String string2, thien_ae thien_ae2, boolean bl, thien_ae thien_ae3) {
        this.a = string;
        this.b = string2;
        this.c = thien_ae2;
        this.d = bl;
        this.e = thien_ae3;
    }

    public final void run() {
        try {
            MessageConnection messageConnection = null;
            messageConnection = (MessageConnection)Connector.open((String)this.a);
            TextMessage textMessage = (TextMessage)messageConnection.newMessage("text");
            textMessage.setAddress(this.a);
            textMessage.setPayloadText(this.b);
            messageConnection.send((Message)textMessage);
            if (this.c == null) {
                thien_di.c.c();
                thien_di.c.b(thien_as.N());
                return;
            }
            this.c.a();
            return;
        }
        catch (Exception exception) {
            if (this.d) {
                thien_di.c.c();
            }
            if (this.e == null) {
                thien_di.c.b(thien_as.O());
                return;
            }
            this.e.a();
            return;
        }
    }
}
