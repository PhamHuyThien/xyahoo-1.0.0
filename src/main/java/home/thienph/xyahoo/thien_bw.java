package home.thienph.xyahoo;

final class thien_bw implements IAction
{
    private BigTwoGameScreen a;
    
    thien_bw(final BigTwoGameScreen a) {
        this.a = a;
    }
    
    public final void action() {
        GameManager.instance.c(BigTwoGameScreen.instance);
        TableListControl.playIcon = null;
        TableListControl.tableImage = null;
        BigTwoGameScreen.setTableListControl(this.a, (TableListControl)null);
        System.gc();
    }
}
