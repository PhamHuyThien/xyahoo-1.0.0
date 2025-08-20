package home.thienph.xyahoo;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.TextBox;
import javax.microedition.midlet.MIDlet;

public final class TextField
extends UIControlBase {
    public boolean isShiftMode = false;
    public boolean isEditable = true;
    public static int multiTapSpeedIndex = 2;
    private static final int[] multiTapDelays = new int[]{18, 14, 11, 9, 6, 4, 2};
    private static int cursorHeight = 0;
    public boolean useSystemInputBox;
    private static String[] keyMap = new String[]{
            " 0",
            ".,@?!_1'/$-():*+<=>;%&#%^&*[];'/1",
            "abc2áàảãạâấầẩẫậăắằẳẵặ2",
            "def3đéèẻẽẹêếềểễệ3",
            "ghi4íìỉĩị4",
            "jkl5",
            "mno6óòỏõọôốồổỗộơớờởỡợ6",
            "pqrs7",
            "tuv8úùủũụưứừửữự8",
            "wxyz9ýỳỷỹỵ9",
            "*",
            "#"
    };
    private String textContent = "";
    private String maskedText = "";
    private String displayText = "";
    private int cursorPos = 0;
    private int tickCounter = 0;
    private int maxLength = 50000;
    private int scrollOffset = 0;
    private int lastKey = -1984;
    private int multiTapIndex = 0;
    private int lastKeyPressTime = 0;
    private int cursorBlinkTimer = 10;
    private int inputType = 0;
    private static boolean hasAlphaInput;
    private static int fontWidth;
    private int inputModeIndex = 0;
    private static String[] inputModes;
    private static int modeSwitchKey;
    public static Canvas uiCanvas;
    public static MIDlet mainMidlet;
    private boolean isDirty;
    public int lineSpacing = 20;
    private int textStartX;

    static {
        inputModes = new String[]{"abc", "Abc", "ABC", "123"};
        modeSwitchKey = 11;
    }

    public final void openSystemTextBox() {
        Object object;
        TextBox textBox = new TextBox("", "", 500, 0);
        textBox.addCommand(new Command("OK", 4, 0));
        textBox.addCommand(new Command(TextConstant.cancel(), 3, 0));
        textBox.setCommandListener((CommandListener)new SystemInputHandler(this, textBox));
        try {
            if (this.useSystemInputBox) {
                textBox.setConstraints(3);
            } else if (this.inputType == 2) {
                textBox.setConstraints(65536);
            } else if (this.inputType == 1) {
                textBox.setConstraints(2);
            } else {
                textBox.setConstraints(0);
            }
        }
        catch (Exception exception) {
            object = exception;
            exception.printStackTrace();
        }
        object = this;
        textBox.setString(((TextField)object).textContent);
        textBox.setMaxSize(this.maxLength);
        Display.getDisplay((MIDlet) mainMidlet).setCurrent((Displayable)textBox);
    }

    public static void setKeyMappingStyle(int style) {
        if (style == 1) {
            TextField.keyMap[0] = "0";
            TextField.keyMap[10] = " *";
            TextField.keyMap[11] = "#";
            modeSwitchKey = 35;
            return;
        }
        if (style == 0) {
            TextField.keyMap[0] = " 0";
            TextField.keyMap[10] = "*";
            TextField.keyMap[11] = "#";
            modeSwitchKey = 35;
            return;
        }
        if (style == 2) {
            TextField.keyMap[0] = "0";
            TextField.keyMap[10] = "*";
            TextField.keyMap[11] = " #";
            modeSwitchKey = 42;
        }
    }

    private void initClearButton() {
        cursorHeight = TextRenderer.fontHeight + 1;
        this.actionSecondary = new UIAction(TextConstant.clear(), new DeleteCharBeforeCursorAction(this));
        fontWidth = TextRenderer.computeTextWidth("ABC", TextRenderer.charWidth) + 1;
    }

    public TextField() {
        UIColorConstant.getTextColor();
        this.textContent = "";
        this.initClearButton();
    }

    public TextField(String string, int cursorPos, int n2) {
        UIColorConstant.getTextColor();
        this.textContent = string;
        this.maxLength = cursorPos;
        this.inputType = n2;
        this.initClearButton();
    }

    public final void deleteCharBeforeCursor() {
        if (this.cursorPos > 0 && this.textContent.length() > 0) {
            this.textContent = String.valueOf(this.textContent.substring(0, this.cursorPos - 1)) + this.textContent.substring(this.cursorPos, this.textContent.length());
            --this.cursorPos;
            this.updateScrollOffset();
            this.updateMaskedText();
        }
    }

    private void updateScrollOffset() {
        this.displayText = this.inputType == 2 ? this.maskedText : this.textContent;
        if (this.scrollOffset < 0 && TextRenderer.computeTextWidth(this.displayText, TextRenderer.charWidth) + this.scrollOffset < this.width - 4 - 13 - fontWidth) {
            this.scrollOffset = this.width - 10 - fontWidth - TextRenderer.computeTextWidth(this.displayText, TextRenderer.charWidth);
        }
        if (this.scrollOffset + TextRenderer.computeTextWidth(this.displayText.substring(0, this.cursorPos), TextRenderer.charWidth) <= 0) {
            this.scrollOffset = -TextRenderer.computeTextWidth(this.displayText.substring(0, this.cursorPos), TextRenderer.charWidth);
            this.scrollOffset += 40;
        } else if (this.scrollOffset + TextRenderer.computeTextWidth(this.displayText.substring(0, this.cursorPos), TextRenderer.charWidth) >= this.width - 12 - fontWidth) {
            this.scrollOffset = this.width + this.lineSpacing - fontWidth - TextRenderer.computeTextWidth(this.displayText.substring(0, this.cursorPos), TextRenderer.charWidth) - 8;
        }
        if (this.scrollOffset > 0) {
            this.scrollOffset = 0;
        }
    }

    private void insertCharAtCursor(int n) {
        this.isDirty = true;
        if (this.useSystemInputBox) {
            this.openSystemTextBox();
            return;
        }
        if (this.textContent.length() < this.maxLength) {
            String string = String.valueOf(this.textContent.substring(0, this.cursorPos)) + (char)n;
            if (this.cursorPos < this.textContent.length()) {
                string = String.valueOf(string) + this.textContent.substring(this.cursorPos, this.textContent.length());
            }
            this.textContent = string;
            ++this.cursorPos;
            this.updateMaskedText();
            this.updateScrollOffset();
        }
    }

    public final boolean handleKeyInput(int n) {
        if (this.textContent.length() <= 0 && n == 16) {
            this.openSystemTextBox();
            return false;
        }
        if (n >= 65 && n <= 122) {
            if (this.inputType == 1) {
                return false;
            }
            hasAlphaInput = true;
        }
        if (hasAlphaInput) {
            this.isDirty = true;
            if (n == 45) {
                if (n == this.lastKey && this.multiTapIndex < multiTapDelays[multiTapSpeedIndex]) {
                    this.displayText = this.textContent = String.valueOf(this.textContent.substring(0, this.cursorPos - 1)) + '_';
                    this.updateMaskedText();
                    this.updateScrollOffset();
                    this.lastKey = -1984;
                    return false;
                }
                this.lastKey = 45;
            }
            if (n >= 32) {
                this.insertCharAtCursor(n);
                return false;
            }
        }
        if (n == modeSwitchKey) {
            ++this.inputModeIndex;
            if (this.inputModeIndex > 3) {
                this.inputModeIndex = 0;
            }
            this.multiTapIndex = 1;
            this.lastKey = n;
            return false;
        }
        if (n == 42) {
            n = 58;
        }
        if (n == 35) {
            n = 59;
        }
        if (n >= 48 && n <= 59) {
            if (this.inputType == 0 || this.inputType == 2) {
                int n2 = n;
                TextField textField2 = this;
                this.isDirty = false;
                if (textField2.useSystemInputBox) {
                    textField2.openSystemTextBox();
                } else {
                    if (n2 == textField2.lastKey) {
                        textField2.lastKeyPressTime = (textField2.lastKeyPressTime + 1) % keyMap[n2 - 48].length();
                        char c = keyMap[n2 - 48].charAt(textField2.lastKeyPressTime);
                        c = textField2.inputModeIndex == 0 ? Character.toLowerCase(c) : (textField2.inputModeIndex == 1 ? Character.toUpperCase(c) : (textField2.inputModeIndex == 2 ? Character.toUpperCase(c) : keyMap[n2 - 48].charAt(keyMap[n2 - 48].length() - 1)));
                        String string = String.valueOf(textField2.textContent.substring(0, textField2.cursorPos - 1)) + c;
                        if (textField2.cursorPos < textField2.textContent.length()) {
                            string = String.valueOf(string) + textField2.textContent.substring(textField2.cursorPos, textField2.textContent.length());
                        }
                        textField2.textContent = string;
                        textField2.multiTapIndex = multiTapDelays[TextField.multiTapSpeedIndex];
                        textField2.updateMaskedText();
                    } else if (textField2.textContent.length() < textField2.maxLength) {
                        if (textField2.inputModeIndex == 1 && textField2.lastKey != -1984) {
                            textField2.inputModeIndex = 0;
                        }
                        textField2.lastKeyPressTime = 0;
                        char c = keyMap[n2 - 48].charAt(textField2.lastKeyPressTime);
                        c = textField2.inputModeIndex == 0 ? Character.toLowerCase(c) : (textField2.inputModeIndex == 1 ? Character.toUpperCase(c) : (textField2.inputModeIndex == 2 ? Character.toUpperCase(c) : keyMap[n2 - 48].charAt(keyMap[n2 - 48].length() - 1)));
                        String string = String.valueOf(textField2.textContent.substring(0, textField2.cursorPos)) + c;
                        if (textField2.cursorPos < textField2.textContent.length()) {
                            string = String.valueOf(string) + textField2.textContent.substring(textField2.cursorPos, textField2.textContent.length());
                        }
                        textField2.textContent = string;
                        textField2.multiTapIndex = multiTapDelays[TextField.multiTapSpeedIndex];
                        ++textField2.cursorPos;
                        textField2.updateMaskedText();
                        textField2.updateScrollOffset();
                    }
                    textField2.lastKey = n2;
                }
            } else if (this.inputType == 1) {
                this.insertCharAtCursor(n);
                this.multiTapIndex = 1;
            }
        } else {
            this.lastKeyPressTime = 0;
            this.lastKey = -1984;
            if (n == 14 && !this.isShiftMode) {
                if (this.cursorPos > 0) {
                    --this.cursorPos;
                    this.updateScrollOffset();
                    this.cursorBlinkTimer = 10;
                    return false;
                }
            } else {
                if (n == 15) {
                    if (!this.isShiftMode && this.cursorPos < this.textContent.length()) {
                        ++this.cursorPos;
                        this.updateScrollOffset();
                        this.cursorBlinkTimer = 10;
                        return false;
                    }
                    boolean bl = this.isDirty = !this.isDirty;
                    return !this.isDirty;
                }
                if (n == 19) {
                    this.deleteCharBeforeCursor();
                    return false;
                }
                this.lastKey = n;
            }
        }
        return true;
    }

    public final boolean handleSoftKey(int n) {
        if (!hasAlphaInput && n < keyMap.length) {
            this.deleteCharBeforeCursor();
            this.insertCharAtCursor(keyMap[n].charAt(keyMap[n].length() - 1));
            this.multiTapIndex = multiTapDelays[multiTapSpeedIndex];
        }
        if (n == 19) {
            this.setText("");
        }
        return true;
    }

    public final void handleKeyPress(int n, int n2) {
        if (this.isSelected()) {
            this.openSystemTextBox();
            return;
        }
        this.parentScreen.selectControl(this);
    }

    public final void draw(Graphics graphics) {
        int n;
        Graphics graphics2;
        int n2 = 0;
        int n3 = this.baseY + (this.height - TextRenderer.fontHeight >> 1);
        boolean bl = this.isSelected();
        this.displayText = this.inputType == 2 ? this.maskedText : this.textContent;
        graphics.setColor(UIColorConstant.getSecondaryColor());
        if (bl && this.isEditable) {
            n2 = this.baseX + this.width - 3;
            graphics.setColor(2580);
            graphics.fillRect(this.baseX + 2, this.baseY + 2, this.width - 3, this.height - 3);
            if (!hasAlphaInput) {
                graphics.setColor(9478569);
                UIButton.a(graphics, n2 - fontWidth, this.baseY + 3, fontWidth, this.height - 6);
                graphics.setColor(0xFFFFFF);
                TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(inputModes[this.inputModeIndex], n2 - (fontWidth >> 1) + (TextRenderer.useCustomFont ? 0 : 1), n3, 2, graphics, TextRenderer.charWidth, TextRenderer.fontHeight);
            }
        }
        if (bl) {
        }
        if (!bl) {
            graphics2 = graphics;
            n = 9478569;
        } else {
            graphics2 = graphics;
            n = bl && !this.isEditable ? 11320516 : 14675958;
        }
        graphics2.setColor(n);
        UIButton.a(graphics, this.baseX + 1, this.baseY + 1, this.width - 2, this.height - 2);
        n2 = this.baseY + 1;
        this.textStartX = 4 + this.scrollOffset + this.baseX;
        graphics.setClip(this.baseX + 3, n2 > this.parentScreen.scrollY ? n2 : this.parentScreen.scrollY, this.width, this.height - 4);
        TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(this.displayText, this.textStartX, n3, graphics);
        if (bl) {
            if (this.multiTapIndex == 0 && (this.cursorBlinkTimer > 0 || this.tickCounter / 5 % 2 == 0)) {
                graphics.setColor(3981823);
            } else {
                graphics.setColor(0xAAAAFF);
            }
            graphics.fillRect(this.textStartX + TextRenderer.computeTextWidth(this.displayText.substring(0, this.cursorPos), TextRenderer.charWidth) + (TextRenderer.useCustomFont ? 1 : 0), this.baseY + (this.height - cursorHeight) / 2 + 1, 1, cursorHeight);
        }
    }

    private void updateMaskedText() {
        if (this.inputType == 2) {
            this.maskedText = "";
            int n = 0;
            while (n < this.textContent.length()) {
                this.maskedText = String.valueOf(this.maskedText) + "*";
                ++n;
            }
            if (this.multiTapIndex > 0 && this.cursorPos > 0) {
                this.maskedText = String.valueOf(this.maskedText.substring(0, this.cursorPos - 1)) + this.textContent.charAt(this.cursorPos - 1) + this.maskedText.substring(this.cursorPos, this.maskedText.length());
            }
        }
    }

    public final void drawBackground(Graphics graphics) {
    }

    public final void update() {
        ++this.tickCounter;
        if (this.multiTapIndex > 0) {
            --this.multiTapIndex;
            if (this.multiTapIndex == 0) {
                this.lastKeyPressTime = 0;
                if (this.inputModeIndex == 1 && this.lastKey != modeSwitchKey) {
                    this.inputModeIndex = 0;
                }
                this.lastKey = -1984;
                this.updateMaskedText();
            }
        }
        if (this.cursorBlinkTimer > 0) {
            --this.cursorBlinkTimer;
        }
    }

    public final String getText() {
        return this.textContent;
    }

    public final void setText(String string) {
        if (string == null) {
            return;
        }
        this.lastKey = -1984;
        this.multiTapIndex = 0;
        this.lastKeyPressTime = 0;
        this.textContent = string;
        this.displayText = string;
        this.updateMaskedText();
        this.cursorPos = string.length();
        this.updateScrollOffset();
    }

    public final void insertText(String string) {
        this.textContent = String.valueOf(this.textContent.substring(0, this.cursorPos)) + string + this.textContent.substring(this.cursorPos);
        this.updateMaskedText();
        this.cursorPos += string.length();
        this.updateScrollOffset();
    }

    public final void setMaxLength(int n) {
        this.maxLength = n;
    }

    public final void setInputType(int n) {
        this.inputType = n;
    }
}
