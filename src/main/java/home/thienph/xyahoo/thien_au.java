package home.thienph.xyahoo;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.TextBox;
import javax.microedition.midlet.MIDlet;

final class thien_au
implements CommandListener {
    private thien_at a;
    private final TextBox b;

    thien_au(thien_at thien_at2, TextBox textBox) {
        this.a = thien_at2;
        this.b = textBox;
    }

    public final void commandAction(Command command, Displayable displayable) {
        if (command.getLabel().equals("OK")) {
            this.a.a(this.b.getString());
        }
        Display.getDisplay((MIDlet)thien_at.f).setCurrent((Displayable)thien_at.e);
        thien_at.e.setFullScreenMode(true);
    }
}
