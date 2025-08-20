package home.thienph.xyahoo;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.TextBox;
import javax.microedition.midlet.MIDlet;

final class SystemInputHandler
implements CommandListener {
    private TextField targetTextField;
    private final TextBox systemTextBox;

    SystemInputHandler(TextField textField2, TextBox textBox) {
        this.targetTextField = textField2;
        this.systemTextBox = textBox;
    }

    public final void commandAction(Command command, Displayable displayable) {
        if (command.getLabel().equals("OK")) {
            this.targetTextField.setText(this.systemTextBox.getString());
        }
        Display.getDisplay((MIDlet) TextField.mainMidlet).setCurrent((Displayable) TextField.uiCanvas);
        TextField.uiCanvas.setFullScreenMode(true);
    }
}
