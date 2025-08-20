package home.thienph.xyahoo;

final class thien_az
implements IAction {
    private TableListControl a;

    thien_az(TableListControl tableListControl2) {
        this.a = tableListControl2;
    }

    public final void action() {
        String string = TableListControl.tableList[TableListControl.getSelectedTableIndex((TableListControl)this.a)].tableId;
        if (TableListControl.getRoomType(this.a) == 1) {
            MessageHandler.a(string, BigTwoGameScreen.currentGroupName);
        }
    }
}
