package home.thienph.xyahoo.managers;

import home.thienph.xyahoo.data.data.ContactInfo;
import home.thienph.xyahoo.data.data.ContactDataSource;
import home.thienph.xyahoo.data.networks.Packet;
import home.thienph.xyahoo.screens.BigTwoGameScreen;
import home.thienph.xyahoo.conections.PacketHandler;
import home.thienph.xyahoo.data.data.TableInfo;
import home.thienph.xyahoo.main.Xuka;
import home.thienph.xyahoo.utils.ContentFilter;

import java.util.Vector;
import javax.microedition.lcdui.Image;

public final class GameHandler extends PacketHandler {
   private static IGameManager gameManager;
   private static GameHandler instance = null;
   public static String a;

   private GameHandler() {
   }

   public static GameHandler getInstance() {
      if (instance == null) {
         instance = new GameHandler();
      }

      return instance;
   }

   public static void setGameManager(IGameManager var0) {
      gameManager = var0;
   }

   public final void onConnect() {
      gameManager.connectionError();
   }

   public final void onDisconnect() {
      gameManager.handleDisconnect();
   }

   public final void shutdown() {
   }

   public final void handle(Packet packet, int commandId) {
      int typeId = packet.getType();
      switch (commandId) {
         case -6:
            int var245;
            String[] var257 = new String[var245 = MessageHandler.readInt(packet)];
            int[] var39 = new int[var245];

            for (int var259 = 0; var259 < var245; var259++) {
               var257[var259] = MessageHandler.readString(packet);
               var39[var259] = MessageHandler.readInt(packet);
            }

            gameManager.saveServerConfig(var257, var39);
            return;
         case -5:
            gameManager.loginSuccess();
            return;
         case -3:
            gameManager.registrationError();
            return;
         case -2:
            gameManager.registrationSuccess();
            return;
         case -1:
            gameManager.wrongCredentials();
            return;
         case 3:
            String var207 = MessageHandler.readString(packet);
            MessageHandler.readString(packet);
            String var192 = MessageHandler.readString(packet);
            gameManager.receivePrivateMessage(var207, var192);
            return;
         case 8:
            String var206 = MessageHandler.readString(packet);
            String var191 = MessageHandler.readString(packet);
            gameManager.updateBuddyStatus(var206, var191, 1);
            return;
         case 9:
            commandId = MessageHandler.readInt(packet);

            for (int var218 = 0; var218 < commandId; var218++) {
               String var226 = MessageHandler.readString(packet);
               String var236 = MessageHandler.readString(packet);
               String var244 = MessageHandler.readString(packet);
               gameManager.handlePrivateMessage(var226, var236, var244);
            }

            return;
         case 15:
            String var204 = MessageHandler.readString(packet);
            int var190 = MessageHandler.readInt(packet);
            gameManager.setBuddyOnlineStatus(var204, var190, 1);
            return;
         case 27: //buzzz
            String var217 = MessageHandler.readString(packet);
            MessageHandler.readString(packet);
            gameManager.sendBuzz(var217);
            return;
         case 37: // update new Version
            String var235 = MessageHandler.readString(packet);
            String var243 = MessageHandler.readString(packet);
            gameManager.showUpdateDialog(var235, var243);
            return;
         case 39: // show popup
            String var203 = MessageHandler.readString(packet);
            int var189;
            if ((var189 = MessageHandler.readInt(packet)) == 0) {
               gameManager.handlePlayerMoveAdvanced(0, var203, null, 20L, 20L, null);
               return;
            }

            if (var189 == 1) {
               gameManager.showErrorMessage(var203);
               return;
            }
            break;
         case 44:
            a = MessageHandler.readString(packet);
            return;
         case 45: // soan tin nap tien
            String var202 = MessageHandler.readString(packet);
            String var216 = MessageHandler.readString(packet);
            String var225 = "";
            if (GameManager.isTestMode) {
               var225 = MessageHandler.readString(packet);
            }

            gameManager.showTopUpMessage(var225, var202, var216);
            return;
         case 49:
            String var201 = MessageHandler.readString(packet);
            MessageHandler.readInt(packet);
            byte var215 = packet.getPayload().readByte();
            String var224 = MessageHandler.readString(packet);
            int var234 = MessageHandler.readInt(packet);
            int var242 = MessageHandler.readInt(packet);
            packet.getPayload().readByte();
            packet.getPayload().readByte();
            packet.getPayload().readByte();
            packet.getPayload().readByte();
            MessageHandler.readInt(packet);
            MessageHandler.readInt(packet);
            gameManager.setUserSessionData(var201, var215, var224, var234, var242);
            return;
         case 63:
            typeId = MessageHandler.readInt(packet);
            Vector var223 = new Vector();

            for (int var233 = 0; var233 < typeId; var233++) {
               String var241 = MessageHandler.readString(packet);
               var223.addElement(var241);
            }

            GameManager.blockedUsers = var223;
            return;
         case 64:
            boolean var232 = MessageHandler.readBool(packet);
            gameManager.changeUserPassword(var232);
            return;
         case 113:
            int var258;
            ContentFilter.profanityWords = new String[var258 = MessageHandler.readInt(packet)];

            for (int var260 = 0; var260 < var258; var260++) {
               ContentFilter.profanityWords[var260] = MessageHandler.readString(packet);
            }

            return;
         case 116:
            System.gc();
            byte[] var41 = MessageHandler.readByteArray(packet);
            gameManager.processRawData(var41);
            return;
         case 117:
            commandId = MessageHandler.readInt(packet);

            for (int var213 = 0; var213 < commandId; var213++) {
               int var222 = MessageHandler.readInt(packet);
               String var231 = MessageHandler.readString(packet);
               byte[] var240 = MessageHandler.readByteArray(packet);
               MessageHandler.readUserInfo(packet);
               MessageHandler.readUserInfo(packet);
               long var38 = MessageHandler.readLong(packet);
               long var40 = MessageHandler.readLong(packet);
               String var252 = MessageHandler.readString(packet);
               gameManager.handlePlayerMoveAdvanced(var222, var231, var240, var40, var38, var252);
            }

            return;
         case 120:
            commandId = MessageHandler.readInt(packet);
            byte[] var188 = MessageHandler.readByteArray(packet);
            gameManager.handleBinaryData(commandId, var188);
            return;
         case 121: // exec raw packet
            System.gc();
            byte[] var251 = MessageHandler.readByteArray(packet);
            gameManager.processRawData(var251);
            return;
         case 122:
            commandId = MessageHandler.readInt(packet);
            int var187 = MessageHandler.readInt(packet);
            gameManager.loadCachedData(commandId, var187);
            return;
         case 123:
            commandId = MessageHandler.readInt(packet);
            typeId = MessageHandler.readInt(packet);
            byte[] var186 = MessageHandler.readByteArray(packet);
            gameManager.saveCachedData(commandId, typeId, var186);
            return;
         case 269:
            String var254 = MessageHandler.readString(packet);
            String var256 = MessageHandler.readString(packet);
            gameManager.setRecoveryInfo(var254, var256);
            return;
         case 317:
            int var239;
            String[] var250 = new String[var239 = MessageHandler.readInt(packet)];

            for (int var253 = 0; var253 < var239; var253++) {
               var250[var253] = MessageHandler.readString(packet);
            }

            gameManager.handleRegistrationData(var250);
            return;
         case 1001: // moi vao nhom
            String var304 = MessageHandler.readString(packet);
            String var164 = MessageHandler.readString(packet);
            if (!var304.equals("")) {
               gameManager.inviteToConference(var304, var164);
               return;
            }

            gameManager.cannotCreateConference();
            return;
         case 1004:
            String var168 = MessageHandler.readString(packet);
            String var169 = MessageHandler.readString(packet);
            int var170;
            if ((var170 = MessageHandler.readInt(packet)) == 0) {
               gameManager.handleUserRefusedConference(var169, var168);
               return;
            }

            if (var170 == 1) {
               gameManager.handleUserJoinedConference(var169, var168);
               return;
            }

            if (var170 == 2) {
               gameManager.handleUserLeftConference(var169, var168);
               return;
            }
            break;
         case 1005:
            String var305 = MessageHandler.readString(packet);
            String var175 = MessageHandler.readString(packet);
            String var176 = MessageHandler.readString(packet);
            gameManager.handleConferenceMessage(var175, var305, var176);
            return;
         case 1006: // phong chat
            String roomId = MessageHandler.readString(packet);
            String groupChatName = MessageHandler.readString(packet);
            String userInvite = MessageHandler.readString(packet);
            gameManager.showConferenceInviteDialog(userInvite, roomId, groupChatName);
            return;
         case 1007:
            String var171 = MessageHandler.readString(packet);
            int var172 = MessageHandler.readInt(packet)  ;
            String[] var173 = new String[var172];

            for (byte var174 = 0; var174 < var172; var174 += 1) {
               var173[var174] = MessageHandler.readString(packet);
            }

            gameManager.handleMultipleUsersJoinedConference(var171, var173);
            return;
         case 1009:
            String var132 = MessageHandler.readString(packet);
            gameManager.showAddFriendDialog(var132);
            return;
         case 1010: // xx dong y them ban vao danh sach bạn be
            boolean dongY = MessageHandler.readBool(packet); // dong y, khong dong y
            String var123 = MessageHandler.readString(packet); // user dong y
            if (dongY) {
               String var294 = MessageHandler.readString(packet);
               int var295 = MessageHandler.readInt(packet);
               String var296 = MessageHandler.readString(packet);
               int var185 = MessageHandler.readInt(packet);
               gameManager.dongYKetBan(var123, var295, var296, var294, var185);
               return;
            }

            gameManager.tuChoiKetBan(var123);
            return;
         case 1017:
            int var124 = MessageHandler.readInt(packet);
            String var125 = MessageHandler.readString(packet);
            String var126 = MessageHandler.readString(packet);
            byte var127;
            int[] var128 = new int[var127 = packet.getPayload().readByte()];

            for (byte var129 = 0; var129 < var127; var129 += 1) {
               var128[var129] = MessageHandler.readInt(packet);
            }

            int var297 = MessageHandler.readInt(packet);
            ContactInfo var130 = new ContactInfo(var125, "", 0, "", var128, 0, var297);
            packet.getPayload().readByte();
            MessageHandler.readString(packet);
            var130.setTextColor(MessageHandler.readInt(packet));
            var130.additionalFlags = MessageHandler.readInt(packet);
            packet.getPayload().readByte();
            packet.getPayload().readByte();
            packet.getPayload().readByte();
            packet.getPayload().readByte();
            MessageHandler.readInt(packet);
            MessageHandler.readInt(packet);
            gameManager.addFriendToGroup(var124, var130, var126);
            return;
         case 1020: // xoa ban be thanh cong
            int var120 = MessageHandler.readInt(packet);
            String var121 = MessageHandler.readString(packet);
            gameManager.deleteBuddy(var121, var120);
            return;
         case 1021:
            int var293 = MessageHandler.readInt(packet);
            String var118 = MessageHandler.readString(packet);
            String var119 = MessageHandler.readString(packet);
            gameManager.moveBuddy(var293, var118, var119);
            return;
         case 1022: // rename group
            int var290 = MessageHandler.readInt(packet);
            String var291 = MessageHandler.readString(packet);
            String var292 = MessageHandler.readString(packet);
            gameManager.renameGroup(var290, var291, var292);
            return;
         case 1023:
            String var133 = MessageHandler.readString(packet);
            int var134;
            int[] var135 = new int[var134 = MessageHandler.readInt(packet)];

            for (byte var298 = 0; var298 < var134; var298 += 1) {
               var135[var298] = MessageHandler.readInt(packet);
            }

            gameManager.updateStatusIcons(var133, var135);
            return;
         case 1029: // khong the them ban
            String var131 = MessageHandler.readString(packet);
            gameManager.khongTheThemBan(var131);
            return;
         case 1045:
            int var151 = MessageHandler.readInt(packet);
            ContactDataSource contactDataSource = new ContactDataSource();
            int contactSize = MessageHandler.readInt(packet);
            ContactInfo[] contactInfos = new ContactInfo[contactSize];
            String[] contactIds = new String[contactSize];
            Vector contactList = new Vector();

            for (byte i = 0; i < contactSize; i += 1) {
               contactIds[i] = MessageHandler.readString(packet);
               String contactId = MessageHandler.readString(packet);
               short _1045roomId = MessageHandler.readShort(packet);
               contactInfos[i] = new ContactInfo(contactId, "", 0, "", new int[0], _1045roomId, i);
               if (contactInfos[i].roomId == 8 || contactInfos[i].roomId == 4) {
                  contactDataSource.addContactToGroup(contactIds[i], contactInfos[i]);
               } else if (contactInfos[i].roomId == 32) {
                  contactList.addElement(contactInfos[i]);
               }
            }

            gameManager.setBuddyListData(contactDataSource, var151);
            return;
         case 1046:
            String var136 = MessageHandler.readString(packet);
            String var137 = MessageHandler.readString(packet);
            byte var138;
            int[] var139 = new int[var138 = packet.getPayload().readByte()];

            for (byte var140 = 0; var140 < var138; var140 += 1) {
               var139[var140] = MessageHandler.readInt(packet);
            }

            byte var299 = packet.getPayload().readByte();
            String var141 = MessageHandler.readString(packet);
            int var142 = MessageHandler.readInt(packet);
            byte var143 = packet.getPayload().readByte();
            byte var144 = packet.getPayload().readByte();
            byte var145 = packet.getPayload().readByte();
            byte var146 = packet.getPayload().readByte();
            int var147 = MessageHandler.readInt(packet);
            int var148 = MessageHandler.readInt(packet);
            byte var149 = packet.getPayload().readByte();
            String var150 = "";
            if (var149 == 2) {
               var150 = MessageHandler.readString(packet);
            }

            gameManager.a(var136, var137, var139, var299, var141, var142, var143, var144, var145, var146, var147, var148, var150, var149);
            return;
         case 1047:
            int var157;
            String[] var158 = new String[var157 = MessageHandler.readInt(packet)];

            for (byte var302 = 0; var302 < var157; var302 += 1) {
               var158[var302] = MessageHandler.readString(packet);
            }

            gameManager.updateMultipleBuddyStatus(var158, null, null);
            return;
         case 1048:
            int var159;
            String[] var160 = new String[var159 = MessageHandler.readInt(packet)];
            int[] var161 = new int[var159];
            String[] var162 = new String[var159];

            for (byte var163 = 0; var163 < var159; var163 += 1) {
               var160[var163] = MessageHandler.readString(packet);
               var161[var163] = MessageHandler.readInt(packet);
               var162[var163] = MessageHandler.readString(packet);
            }

            gameManager.updateMultipleBuddyStatus(var160, var161, var162);
            return;
         case 3402:
         case 5000011:
            String var211 = MessageHandler.readString(packet);
            String var196;
            if (commandId == 3402) {
               var196 = "TL";
               MessageHandler.readInt(packet);
            } else {
               var196 = MessageHandler.readString(packet);
            }

            int var221;
            TableInfo[] var230 = new TableInfo[var221 = MessageHandler.readInt(packet)];

            for (int var238 = 0; var238 < var221; var238++) {
               var230[var238] = new TableInfo();
               var230[var238].tableId = MessageHandler.readString(packet);
               var230[var238].gameStatus = packet.getPayload().readByte();
               TableInfo var10000 = var230[var238];
               long var306 = MessageHandler.readLong(packet);
               var10000.tableName = var306 + "$";
               var230[var238].setPlayerCount((byte) MessageHandler.readInt(packet));
            }

            gameManager.showGameTables(var211, var230, 1, var196);
            return;
         case 3403:
            String var237 = MessageHandler.readString(packet);
            if (!MessageHandler.readBool(packet)) {
               b(packet);
               return;
            }

            MessageHandler.readString(packet);
            String var195 = MessageHandler.readString(packet);
            long var57 = MessageHandler.readLong(packet);
            String[] var220 = new String[typeId = MessageHandler.readInt(packet)];
            long[] var229 = new long[typeId];
            int[] var249 = new int[typeId];
            boolean[] var262 = new boolean[typeId];

            for (int var264 = 0; var264 < typeId; var264++) {
               var220[var264] = MessageHandler.readString(packet);
               var262[var264] = MessageHandler.readBool(packet);
               var229[var264] = MessageHandler.readLong(packet);
               var249[var264] = MessageHandler.readInt(packet);
               if (var249[var264] != -1) {
                  var249[var264] = (short)var249[var264];
               }
            }

            BigTwoGameScreen.gameRoomId = var237;
            BigTwoGameScreen.instance.playerBalance = var57;
            BigTwoGameScreen.instance.isInitialized = MessageHandler.readBool(packet);
            BigTwoGameScreen var178 = BigTwoGameScreen.instance;
            String var307 = MessageHandler.readString(packet);
            String var309 = MessageHandler.readString(packet);
            var178.setWrappedText(var307 + " - " + var309);
            String[] var265 = new String[typeId];
            int[] var266 = new int[typeId];
            Integer[] var267 = new Integer[typeId];

            for (int var268 = 0; var268 < typeId; var268++) {
               var265[var268] = MessageHandler.readString(packet);
               var266[var268] = MessageHandler.readInt(packet);
               var267[var268] = new Integer(MessageHandler.readInt(packet));
            }

            gameManager.handleSpectatorGameJoin(var237, var57, var220, var229, var249, var262, var195, var265, var266, var267);
            return;
         case 3405:
            MessageHandler.readString(packet);
            if (MessageHandler.readBool(packet)) {
               String[] var219 = new String[typeId = MessageHandler.readInt(packet)];
               boolean[] var228 = new boolean[typeId];

               for (int var248 = 0; var248 < typeId; var248++) {
                  var219[var248] = MessageHandler.readString(packet);
                  var228[var248] = MessageHandler.readBool(packet);
               }

               gameManager.updatePlayerReadyStates(var219, var228);
               return;
            }
            break;
         case 3406:
            MessageHandler.readString(packet);
            if (MessageHandler.readBool(packet)) {
               MessageHandler.readString(packet);
               byte[] var247 = MessageHandler.readByteArray(packet);
               String var261 = MessageHandler.readString(packet);
               boolean var263 = MessageHandler.readBool(packet);
               MessageHandler.readLong(packet);
               gameManager.startGamePlay(var247, var261, var263);
               return;
            }

            b(packet);
            return;
         case 3407:
            String var270 = MessageHandler.readString(packet);
            if (MessageHandler.readBool(packet)) {
               String var271 = MessageHandler.readString(packet);
               String var76 = MessageHandler.readString(packet);
               boolean var274 = MessageHandler.readBool(packet);
               if (MessageHandler.readBool(packet)) {
                  MessageHandler.readString(packet);
                  MessageHandler.readString(packet);
                  MessageHandler.readLong(packet);
               }

               gameManager.handlePlayerPass(var270, var271, var76, var274);
               return;
            }
            break;
         case 3408:
            String var75 = MessageHandler.readString(packet);
            if (MessageHandler.readBool(packet)) {
               String var273 = MessageHandler.readString(packet);
               int var275 = MessageHandler.readInt(packet);
               byte[] var276 = MessageHandler.readByteArray(packet);
               String var277 = MessageHandler.readString(packet);
               boolean var278 = MessageHandler.readBool(packet);
               if (MessageHandler.readBool(packet)) {
                  int var279 = MessageHandler.readInt(packet);
                  gameManager.handlePlayerMoveWithTurn(var75, var273, var275, var276, var277, var278, var279);
                  return;
               }

               gameManager.handlePlayerMove(var75, var273, var275, var276, var277, var278);
               return;
            }

            String var272 = MessageHandler.readString(packet);
            GameManager.getInstance().showNotification(var272, (Image)null, 1);
            MessageHandler.readInt(packet);
            MessageHandler.readByteArray(packet);
            if (BigTwoGameScreen.gameRoomId.equals(var75)) {
               gameManager.resetGameSelection();
               return;
            }
            break;
         case 3409:
            String var281 = MessageHandler.readString(packet);
            if (MessageHandler.readBool(packet)) {
               String var282 = MessageHandler.readString(packet);
               if (MessageHandler.readBool(packet)) {
                  String var284 = MessageHandler.readString(packet);
                  boolean var286 = MessageHandler.readBool(packet);
                  MessageHandler.readByteArray(packet);
                  if (MessageHandler.readBool(packet)) {
                     MessageHandler.readString(packet);
                     MessageHandler.readString(packet);
                     MessageHandler.readLong(packet);
                  }

                  gameManager.handleTurnChange(var281, var282, var284, var286);
                  return;
               }

               String var94 = MessageHandler.readString(packet);
               int var283;
               String[] var285 = new String[var283 = MessageHandler.readInt(packet)];

               for (int var287 = 0; var287 < var283; var287++) {
                  var285[var287] = MessageHandler.readString(packet);
               }

               gameManager.handlePlayerLeave(var281, var282, var94, var285, 0);
               return;
            }
            break;
         case 3410:
            MessageHandler.readString(packet);
            if (!MessageHandler.readBool(packet)) {
               b(packet);
               return;
            }

            MessageHandler.readString(packet);
            long var308 = MessageHandler.readLong(packet);
            if (typeId != 39) {
               return;
            }

            BigTwoGameScreen.instance.playerBalance = var308;
            break;
         case 3411: // noi tu duoi len tren
            MessageHandler.readString(packet);
            String var180 = MessageHandler.readString(packet);
            String var181 = MessageHandler.readString(packet);
            gameManager.handleGameChat(var180, var181, typeId);
            break;
         case 3412:
            String var112 = MessageHandler.readString(packet);
            if (MessageHandler.readBool(packet)) {
               String var114 = MessageHandler.readString(packet);
               int var115;
               String[] var116 = new String[var115 = MessageHandler.readInt(packet)];

               for (int var117 = 0; var117 < var115; var117++) {
                  var116[var117] = MessageHandler.readString(packet);
               }

               gameManager.handlePlayerLeave(var112, var114, BigTwoGameScreen.instance.currentPlayerId, var116, 1);
               return;
            }
            break;
         case 3416:
            MessageHandler.readString(packet);
            long var289 = MessageHandler.readLong(packet);
            MessageHandler.readLong(packet);
            gameManager.showMoneyUpdate(var289);
            return;
         case 3417:
            b(packet);
            return;
         case 34061:
            String var227 = MessageHandler.readString(packet);
            String var246 = MessageHandler.readString(packet);
            int var64;
            String[] var65 = new String[var64 = MessageHandler.readInt(packet)];
            int[] var66 = new int[var64];
            long[] var67 = new long[var64];
            long[] var68 = new long[var64];
            byte[][] var69 = new byte[var64][];
            System.out.println("hostFinish = " + var246 + "; numStartF = " + var64);

            for (int var70 = 0; var70 < var64; var70++) {
               var65[var70] = MessageHandler.readString(packet);
               var66[var70] = MessageHandler.readInt(packet);
               var67[var70] = MessageHandler.readLong(packet);
               var68[var70] = MessageHandler.readLong(packet);
               var69[var70] = MessageHandler.readByteArray(packet);
               System.out
                  .println(
                     "playerStartF "
                        + var70
                        + "= "
                        + var65[var70]
                        + "; orderStartF = "
                        + var66[var70]
                        + "; winMoneyStartF = "
                        + var67[var70]
                        + "; accountStartF = "
                        + var68[var70]
                        + "; leftCards = "
                        + var69[var70]
                  );
            }

            String[] var269 = new String[var64];
            int[] var71 = new int[var64];
            Integer[] var72 = new Integer[var64];

            for (int var73 = 0; var73 < var64; var73++) {
               var269[var73] = MessageHandler.readString(packet);
               var71[var73] = MessageHandler.readInt(packet);
               var72[var73] = new Integer(MessageHandler.readInt(packet));
               System.out.println("tRank " + var73 + "= " + var269[var73] + "; Scoring = " + var71[var73] + "; color = " + var72[var73]);
            }

            gameManager.handleGameEndResult(var227, var246, (byte)var64, var65, var66, var67, var68, var69, var269, var71, var72);
            return;
         case 34081:
            String var77 = MessageHandler.readString(packet);
            String var78 = MessageHandler.readString(packet);
            int var79 = MessageHandler.readInt(packet);
            byte[] var80 = MessageHandler.readByteArray(packet);
            int var81 = MessageHandler.readInt(packet);
            String var194 = MessageHandler.readString(packet);
            BigTwoGameScreen.instance.currentPlayerId = var194;
            int var82;
            String[] var83 = new String[var82 = MessageHandler.readInt(packet)];
            int[] var84 = new int[var82];
            long[] var85 = new long[var82];
            long[] var86 = new long[var82];
            byte[][] var87 = new byte[var82][];
            boolean[] var88 = new boolean[var82];

            for (int var89 = 0; var89 < var82; var89++) {
               var83[var89] = MessageHandler.readString(packet);
               var84[var89] = MessageHandler.readInt(packet);
               var85[var89] = MessageHandler.readLong(packet);
               var86[var89] = MessageHandler.readLong(packet);
               var87[var89] = MessageHandler.readByteArray(packet);
               var88[var89] = MessageHandler.readBool(packet);
            }

            String[] var280 = new String[var82];
            int[] var90 = new int[var82];
            Integer[] var91 = new Integer[var82];

            for (int var92 = 0; var92 < var82; var92++) {
               var280[var92] = MessageHandler.readString(packet);
               var90[var92] = MessageHandler.readInt(packet);
               var91[var92] = new Integer(MessageHandler.readInt(packet));
            }

            gameManager.handleCompleteGameResult(var77, var78, var79, var80, var81, var83, var84, var85, var86, var87, var88, var280, var90, var91);
            return;
         case 34091:
            String var95 = MessageHandler.readString(packet);
            String var96 = MessageHandler.readString(packet);
            int var97 = MessageHandler.readInt(packet);
            String var98 = MessageHandler.readString(packet);
            BigTwoGameScreen.instance.currentPlayerId = var98;
            byte[] var99 = new byte[0];
            int var100;
            String[] var101 = new String[var100 = MessageHandler.readInt(packet)];
            int[] var102 = new int[var100];
            long[] var103 = new long[var100];
            long[] var104 = new long[var100];
            byte[][] var105 = new byte[var100][];
            boolean[] var106 = new boolean[var100];

            for (int var107 = 0; var107 < var100; var107++) {
               var101[var107] = MessageHandler.readString(packet);
               var102[var107] = MessageHandler.readInt(packet);
               var103[var107] = MessageHandler.readLong(packet);
               var104[var107] = MessageHandler.readLong(packet);
               var105[var107] = MessageHandler.readByteArray(packet);
               var106[var107] = MessageHandler.readBool(packet);
            }

            String[] var288 = new String[var100];
            int[] var108 = new int[var100];
            Integer[] var109 = new Integer[var100];

            for (int var110 = 0; var110 < var100; var110++) {
               var288[var110] = MessageHandler.readString(packet);
               var108[var110] = MessageHandler.readInt(packet);
               var109[var110] = new Integer(MessageHandler.readInt(packet));
            }

            gameManager.handleCompleteGameResult(var95, var96, 0, var99, var97, var101, var102, var103, var104, var105, var106, var288, var108, var109);
            return;
         case 5000009:
            ContactDataSource contactDataSource1 = new ContactDataSource();
            typeId = MessageHandler.readInt(packet);
            ContactInfo[] contactInfos1 = new ContactInfo[typeId];
            String[] var5 = new String[typeId];

            for (int i = 0; i < typeId; i++) {
               try {
                  var5[i] = MessageHandler.readString(packet);
               } catch (Exception var184) {
                  var5[i] = "";
               }

               String contactId = MessageHandler.readString(packet);
               String displayName = MessageHandler.readString(packet);
               int statusCode = MessageHandler.readInt(packet);
               statusCode = statusCode == 0 ? 2 : (statusCode == 1 ? 3 : 4);
               contactInfos1[i] = new ContactInfo(contactId, displayName, statusCode, null, null, -1, i);
               contactDataSource1.addContactToGroup(var5[i], contactInfos1[i]);
            }

            gameManager.setCachedBuddyList(contactDataSource1);
            return;
         case 6000000:
            MessageHandler.a(Xuka.refCode);
            return;
      }
   }

   private static void b(Packet var0) {
      String var1 = MessageHandler.readString(var0);
      GameManager.instance.showNotification(var1, (Image)null, 1);
   }
}
