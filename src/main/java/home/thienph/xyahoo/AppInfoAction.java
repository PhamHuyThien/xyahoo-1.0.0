package home.thienph.xyahoo;

final class AppInfoAction
implements IAction {
    AppInfoAction() {
    }

    public final void action() {
        GameManager.getInstance().showCenterPopup(new String[]{"X Yahoo! " + GameManager.serverMessage, "Build ID: 2012-08-9-PM", "Website: mxuka.com", "hotro.xyahoo@gmail.com", "Phone: 0969728701"});
    }
}
