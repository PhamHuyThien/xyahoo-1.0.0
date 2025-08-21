package home.thienph.xyahoo.managers;

import home.thienph.xyahoo.data.data.ContactInfo;
import home.thienph.xyahoo.data.data.ContactDataSource;
import home.thienph.xyahoo.data.data.ContactGroup;
import home.thienph.xyahoo.data.networks.Packet;
import home.thienph.xyahoo.conections.PacketHandler;

public final class Game2Handler extends PacketHandler {
   private static Game2Handler instance = null;
   private static IGameManager gameManager;

   public final void onConnect() {
      gameManager.connectionError();
   }

   public final void onDisconnect() {
      gameManager.handleDisconnect();
   }

   protected final void handle(Packet packet, int commandId) {
      switch (commandId) {
         case -5:
            gameManager.yahooLoginSuccess();
            return;
         case 3:
            String var20 = MessageHandler.readString(packet);
            MessageHandler.readString(packet);
            String var22 = MessageHandler.readString(packet);
            gameManager.receiveYahooMessage(var20, var22);
            return;
         case 5:
            String var17 = MessageHandler.readString(packet);
            int var19 = MessageHandler.readInt(packet);
            String var21 = MessageHandler.readString(packet);
            MessageHandler.readString(packet);
            MessageHandler.readString(packet);
            MessageHandler.readString(packet);
            gameManager.setBuddyOnlineStatus(var17, var19, 2);
            gameManager.updateBuddyStatus(var17, var21, 2);
            return;
         case 6:
            ContactDataSource var16 = new ContactDataSource();
            int var3 = MessageHandler.readInt(packet);

            for (int var4 = 0; var4 < var3; var4++) {
               String var5 = MessageHandler.readString(packet);
               ContactGroup var6 = new ContactGroup(var5);
               int var18 = MessageHandler.readInt(packet);

               for (int var7 = 0; var7 < var18; var7++) {
                  String contactId = MessageHandler.readString(packet);
                  int statusCode = MessageHandler.readInt(packet);
                  String var25 = MessageHandler.readString(packet);
                  MessageHandler.readString(packet);
                  String var26 = MessageHandler.readString(packet);
                  MessageHandler.readString(packet);
                  var6.addContact(new ContactInfo(contactId, var26, statusCode, var25, new int[0], 0, 0));
               }

               var16.groups.addElement(var6);
            }

            gameManager.setYahooBuddyList(var16);
            return;
         case 27:
            String var15 = MessageHandler.readString(packet);
            String var13 = MessageHandler.readString(packet);
            System.out.println("fromUser = " + var15 + "; toUser = " + var13);
            gameManager.receiveBuzz(var15);
            return;
         case 32:
            String var8 = MessageHandler.readString(packet);
            MessageHandler.readString(packet);
            String var9 = MessageHandler.readString(packet);
            String var10 = MessageHandler.readString(packet);
            gameManager.handleYahooMessage(var8, var9, var10);
            return;
         case 34:
            int var12;
            if ((var12 = MessageHandler.readInt(packet)) == -1) {
               gameManager.yahooLoginFailed();
               return;
            }

            if (var12 == -2 || var12 == 34) {
               gameManager.yahooDisconnected();
               return;
            }
            break;
         case 55:
            return;
         case 56:
            int var11 = MessageHandler.readInt(packet);
            gameManager.saveYahooChecksum(var11);
            return;
         case 77:
            String var14 = MessageHandler.readString(packet);
            MessageHandler.readString(packet);
            MessageHandler.readString(packet);
            gameManager.acceptAddFriend(var14);
      }
   }

   public static Game2Handler getInstance() {
      if (instance == null) {
         instance = new Game2Handler();
      }

      return instance;
   }

   public static void setGameManager(IGameManager var0) {
      gameManager = var0;
   }

   public final void shutdown() {
   }
}
