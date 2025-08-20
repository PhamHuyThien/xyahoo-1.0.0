package home.thienph.xyahoo.components;

import home.thienph.xyahoo.actions.IAction;
import home.thienph.xyahoo.data.data.PopupSideElementData;

public final class UIAction {
    public String label;
    public IAction actionHandler;
    public PopupSideElementData popupSideElementData;

    public UIAction(String string, IAction IAction2) {
        this.label = string;
        this.actionHandler = IAction2;
    }
}
