package home.thienph.xyahoo;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.TextBox;
import javax.microedition.midlet.MIDlet;

final class thien_au
implements CommandListener {
    private TextField a;
    private final TextBox b;

    thien_au(TextField textField2, TextBox textBox) {
        this.a = textField2;
        this.b = textBox;
    }

    public final void commandAction(Command command, Displayable displayable) {
        if (command.getLabel().equals("OK")) {
            this.a.setText(this.b.getString());
        }
        Display.getDisplay((MIDlet) TextField.mainMidlet).setCurrent((Displayable) TextField.uiCanvas);
        TextField.uiCanvas.setFullScreenMode(true);
    }
}
