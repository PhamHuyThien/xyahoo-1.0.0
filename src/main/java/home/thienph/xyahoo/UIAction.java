package home.thienph.xyahoo;

public final class UIAction {
    public String label;
    public IAction actionHandler;
    public thien_am icon;

    public UIAction(String string, IAction IAction2) {
        this.label = string;
        this.actionHandler = IAction2;
    }
}
