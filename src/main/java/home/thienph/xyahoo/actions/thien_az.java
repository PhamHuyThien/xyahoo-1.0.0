package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.TableListControl;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.BigTwoGameScreen;

public final class thien_az
        implements IAction {
    private TableListControl tableListControl;

    public thien_az(TableListControl tableListControl2) {
        this.tableListControl = tableListControl2;
    }

    public final void action() {
        String string = TableListControl.tableList[TableListControl.getSelectedTableIndex((TableListControl) this.tableListControl)].tableId;
        if (TableListControl.getRoomType(this.tableListControl) == 1) {
            MessageHandler.a(string, BigTwoGameScreen.currentGroupName);
        }
    }
}
