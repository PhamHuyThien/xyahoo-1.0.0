package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.TableListControl;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.BigTwoGameScreen;

public final class thien_bw implements IAction {
    private BigTwoGameScreen bigTwoGameScreen;

    public thien_bw(final BigTwoGameScreen bigTwoGameScreen) {
        this.bigTwoGameScreen = bigTwoGameScreen;
    }

    public final void action() {
        GameManager.instance.removeScreen(BigTwoGameScreen.instance);
        TableListControl.playIcon = null;
        TableListControl.tableImage = null;
        BigTwoGameScreen.setTableListControl(this.bigTwoGameScreen, (TableListControl) null);
        System.gc();
    }
}
