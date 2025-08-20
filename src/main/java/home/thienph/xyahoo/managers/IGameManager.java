package home.thienph.xyahoo.managers;

import home.thienph.xyahoo.actions.thien_r;
import home.thienph.xyahoo.actions.thien_s;
import home.thienph.xyahoo.data.data.TableInfo;

public interface IGameManager {
    public void saveServerConfig(String[] var1, int[] var2);

    public void setBuddyListData(thien_s var1, int var2);

    public void a(String var1, String var2, int[] var3, byte var4, String var5, int var6, byte var7, byte var8, byte var9, byte var10, int var11, int var12, String var13, int var14);

    public void updateMultipleBuddyStatus(String[] var1, int[] var2, String[] var3);

    public void setYahooBuddyList(thien_s var1);

    public void wrongCredentials();

    public void receivePrivateMessage(String var1, String var2);

    public void receiveYahooMessage(String var1, String var2);

    public void handlePrivateMessage(String var1, String var2, String var3);

    public void registrationSuccess();

    public void registrationError();

    public void connectionError();

    public void updateBuddyStatus(String var1, String var2, int var3);

    public void handleDisconnect();

    public void showErrorMessage(String var1);

    public void handlePlayerMoveAdvanced(int var1, String var2, byte[] var3, long var4, long var6, String var8);

    public void dongYKetBan(String var1, int var2, String var3, String var4, int var5);

    public void khongTheThemBan(String var1);

    public void inviteToConference(String var1, String var2);

    public void cannotCreateConference();

    public void showConferenceInviteDialog(String var1, String var2, String var3);

    public void handleUserJoinedConference(String var1, String var2);

    public void handleUserRefusedConference(String var1, String var2);

    public void handleUserLeftConference(String var1, String var2);

    public void handleMultipleUsersJoinedConference(String var1, String[] var2);

    public void addFriendToGroup(int var1, thien_r var2, String var3);

    public void tuChoiKetBan(String var1);

    public void handleConferenceMessage(String var1, String var2, String var3);

    public void setBuddyOnlineStatus(String var1, int var2, int var3);

    public void handleYahooMessage(String var1, String var2, String var3);

    public void yahooLoginFailed();

    public void yahooDisconnected();

    public void receiveBuzz(String var1);

    public void sendBuzz(String var1);

    public void showUpdateDialog(String var1, String var2);

    public void showTopUpMessage(String var1, String var2, String var3);

    public void setUserSessionData(String var1, byte var2, String var3, int var4, int var5);

    public void loginSuccess();

    public void yahooLoginSuccess();

    public void saveYahooChecksum(int var1);

    public void showAddFriendDialog(String var1);

    public void changeUserPassword(boolean var1);

    public void acceptAddFriend(String var1);

    public void processRawData(byte[] var1);

    public void loadCachedData(int var1, int var2);

    public void saveCachedData(int var1, int var2, byte[] var3);

    public void handleBinaryData(int var1, byte[] var2);

    public void updateStatusIcons(String var1, int[] var2);

    public void deleteBuddy(String var1, int var2);

    public void moveBuddy(int var1, String var2, String var3);

    public void renameGroup(int var1, String var2, String var3);

    public void setRecoveryInfo(String var1, String var2);

    public void handleRegistrationData(String[] var1);

    public void handleSpectatorGameJoin(String var1, long var2, String[] var4, long[] var5, int[] var6, boolean[] var7, String var8, String[] var9, int[] var10, Integer[] var11);

    public void updatePlayerReadyStates(String[] var1, boolean[] var2);

    public void startGamePlay(byte[] var1, String var2, boolean var3);

    public void handleGameEndResult(String var1, String var2, byte var3, String[] var4, int[] var5, long[] var6, long[] var7, byte[][] var8, String[] var9, int[] var10, Integer[] var11);

    public void handlePlayerPass(String var1, String var2, String var3, boolean var4);

    public void handlePlayerMove(String var1, String var2, int var3, byte[] var4, String var5, boolean var6);

    public void handlePlayerMoveWithTurn(String var1, String var2, int var3, byte[] var4, String var5, boolean var6, int var7);

    public void resetGameSelection();

    public void handleCompleteGameResult(String var1, String var2, int var3, byte[] var4, int var5, String[] var6, int[] var7, long[] var8, long[] var9, byte[][] var10, boolean[] var11, String[] var12, int[] var13, Integer[] var14);

    public void handlePlayerLeave(String var1, String var2, String var3, String[] var4, int var5);

    public void handleTurnChange(String var1, String var2, String var3, boolean var4);

    public void handleGameChat(String var1, String var2, int var3);

    public void showMoneyUpdate(long var1);

    public void showGameTables(String var1, TableInfo[] var2, int var3, String var4);

    public void setCachedBuddyList(thien_s var1);
}
