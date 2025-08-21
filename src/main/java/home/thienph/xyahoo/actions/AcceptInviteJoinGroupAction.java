package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;

public final class AcceptInviteJoinGroupAction
implements IAction {
    private GameManager gameManager;
    private final String roomId;
    private final String userInvite;
    private final String groupChatName;

    public AcceptInviteJoinGroupAction(GameManager gameManager2, String string, String string2, String string3) {
        this.gameManager = gameManager2;
        this.roomId = string;
        this.userInvite = string2;
        this.groupChatName = string3;
    }

    public final void action() {
        MessageHandler.a(this.roomId, true, "", this.userInvite);
        this.gameManager.createOrJoinConference(this.roomId, (String[])null, this.groupChatName);
        this.gameManager.closeTopDialog();
    }
}
