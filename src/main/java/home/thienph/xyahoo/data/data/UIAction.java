package home.thienph.xyahoo.data.data;

import home.thienph.xyahoo.actions.IAction;

public final class UIAction {
    public String label;
    public IAction actionHandler;
    public PopupSideElementData popupSideElementData;

    public UIAction(String string, IAction IAction2) {
        this.label = string;
        this.actionHandler = IAction2;
    }
}
