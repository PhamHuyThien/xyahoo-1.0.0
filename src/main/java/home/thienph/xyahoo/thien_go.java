package home.thienph.xyahoo;

import javax.microedition.io.Connector;
import javax.wireless.messaging.Message;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;

final class thien_go
implements Runnable {
    private final String a;
    private final String b;
    private final IAction c;
    private final boolean d;
    private final IAction e;

    thien_go(String string, String string2, IAction IAction2, boolean bl, IAction IAction3) {
        this.a = string;
        this.b = string2;
        this.c = IAction2;
        this.d = bl;
        this.e = IAction3;
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
                thien_di.instance.c();
                thien_di.instance.b(TextConstant.sendSmsCompleted());
                return;
            }
            this.c.action();
            return;
        }
        catch (Exception exception) {
            if (this.d) {
                thien_di.instance.c();
            }
            if (this.e == null) {
                thien_di.instance.b(TextConstant.sendSmsFailed());
                return;
            }
            this.e.action();
            return;
        }
    }
}
