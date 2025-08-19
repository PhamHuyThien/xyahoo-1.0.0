package home.thienph.xyahoo;

import java.util.Vector;

public class FormScreen
extends Screen {
    public int w;
    public int x;
    public int y;
    private thien_ao[] sectionHeaders;
    private int selectedSectionIndex = -1;
    private Vector formControls = new Vector();
    public static int formXOffset;
    public static int formStartX;
    public static int formMarginLeft;
    public static int formWidth;

    public FormScreen() {
        this.initLayout();
    }

    public final void initLayout() {
        this.y = Screen.e - 30;
        if (this.y < 100) {
            this.y = 100;
        }
        if (this.y > 180) {
            this.y = 180;
        }
        this.w = Screen.e - this.y >> 1;
        this.x = 5;
    }

    public static void calculateFormDimensions(int n, int n2) {
        formWidth = Screen.e * 6 / 10;
        if (formWidth > 150) {
            formWidth = 150;
        }
        if ((formMarginLeft = Screen.e - formWidth - 15) > 70) {
            formMarginLeft = 70;
        }
        formXOffset = Screen.e - (formWidth + formMarginLeft + 5) >> 1;
        formStartX = formXOffset + formMarginLeft + 5;
    }

    public final void addControl(UIControlBase UIControlBase2, boolean bl) {
        if (this.formControls.contains(UIControlBase2)) {
            return;
        }
        UIControlBase2.parentScreen = this;
        this.formControls.addElement(UIControlBase2);
        this.controls.addElement(UIControlBase2);
        if (bl) {
            this.x = UIControlBase2.baseY + UIControlBase2.height + 2;
        }
    }

    public final void addControl(UIControlBase UIControlBase2) {
        if (this.formControls.contains(UIControlBase2)) {
            return;
        }
        UIControlBase2.parentScreen = this;
        this.formControls.addElement(UIControlBase2);
        this.controls.addElement(UIControlBase2);
        this.x = UIControlBase2.baseY + UIControlBase2.height + 2;
    }

    public final void removeControl(UIControlBase UIControlBase2) {
        this.formControls.removeElement(UIControlBase2);
        super.removeControl(UIControlBase2);
    }

    public final void clearControls() {
        this.formControls.removeAllElements();
        super.clearControls();
    }

    public final void setSections(String[] stringArray) {
        int n = stringArray.length;
        this.sectionHeaders = new thien_ao[n];
        int n2 = 0;
        while (n2 < n) {
            this.sectionHeaders[n2] = new thien_ao(stringArray[n2], 0, 0, Screen.e - 1, TextRenderer.fontHeight + 2);
            this.sectionHeaders[n2].a = this;
            this.sectionHeaders[n2].b = n2;
            ++n2;
        }
    }

    public final void toggleSection(int n) {
        if (this.selectedSectionIndex != -1) {
            this.sectionHeaders[this.selectedSectionIndex].c = false;
        }
        if (this.selectedSectionIndex == n) {
            this.selectedSectionIndex = -1;
        } else {
            this.selectedSectionIndex = n;
            this.sectionHeaders[this.selectedSectionIndex].c = true;
        }
        FormScreen formScreen2 = this;
        super.clearControls();
        int n2 = 10;
        int n3 = 0;
        int n4 = formScreen2.formControls.size();
        int n5 = 0;
        while (n5 < n4) {
            UIControlBase UIControlBase2 = (UIControlBase) formScreen2.formControls.elementAt(n5);
            if (UIControlBase2.selectedIndex == -1) {
                if (n2 < UIControlBase2.baseY + UIControlBase2.height) {
                    n2 = UIControlBase2.baseY + UIControlBase2.height;
                }
                super.addControl(UIControlBase2);
            } else {
                if (n3 == UIControlBase2.selectedIndex) {
                    if (formScreen2.controls.size() > 0 && !(formScreen2.controls.lastElement() instanceof thien_ao)) {
                        n2 += 10;
                    }
                    formScreen2.sectionHeaders[n3].baseY = n2;
                    super.addControl(formScreen2.sectionHeaders[n3]);
                    if (formScreen2.selectedSectionIndex == UIControlBase2.selectedIndex) {
                        formScreen2.selectControl(formScreen2.sectionHeaders[n3]);
                    }
                    n2 += formScreen2.sectionHeaders[n3].height;
                    ++n3;
                }
                if (formScreen2.selectedSectionIndex == UIControlBase2.selectedIndex) {
                    if (UIControlBase2 instanceof UIButton) {
                        // empty if block
                    }
                    UIControlBase2.baseY = ++n2;
                    super.addControl(UIControlBase2);
                    n2 += UIControlBase2.height;
                    if (UIControlBase2 instanceof TextField) {
                        n2 += 5;
                    }
                }
            }
            ++n5;
        }
        formScreen2.adjustScrollToSelection();
        formScreen2.scrollY = formScreen2.scrollTargetY;
        formScreen2.updateLayout();
    }

    public final UIControlBase getControlById(int n) {
        int n2 = this.formControls.size();
        int n3 = 0;
        while (n3 < n2) {
            UIControlBase UIControlBase2 = (UIControlBase)this.formControls.elementAt(n3);
            if (UIControlBase2.zIndex == n) {
                return UIControlBase2;
            }
            ++n3;
        }
        return null;
    }
}
