package home.thienph.xyahoo.screens;

import home.thienph.xyahoo.actions.*;
import home.thienph.xyahoo.components.ChatMessageList;
import home.thienph.xyahoo.components.TextField;
import home.thienph.xyahoo.data.data.UIAction;
import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.data.data.PopupSideElementData;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.main.*;
import home.thienph.xyahoo.utils.ContentFilter;
import home.thienph.xyahoo.utils.TextRenderer;
import home.thienph.xyahoo.utils.TextRendererHelper;

import java.util.Vector;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.Graphics;

public final class ChatRoomScreen extends Screen {
   public boolean isPrivateChat;
   public String chatPartnerName;
   public String chatPartnerStatus;
   private String currentRoomName;
   public ChatMessageList messageList;
   public TextField inputTextField;
   private boolean isGroupChat;
   private final PopupSideElementData popupMenuData;
   private final Vector menuActions;

   public ChatRoomScreen(String var1, boolean isPrivateChat, boolean isGroupChat, int[] var4) {
      super.isLocked = true;
      this.isPrivateChat = isPrivateChat;
      this.isGroupChat = isGroupChat;
      super.title = var1;
      this.inputTextField = new TextField();
      this.inputTextField.isEditable = false;
      this.inputTextField.setBounds(1, Screen.formHeight - GameManager.topMargin - 2, Screen.e - 3, TextRenderer.fontHeight + 6);
      this.messageList = new ChatMessageList(1, 1, Screen.e - 3, Screen.formHeight - GameManager.topMargin - TextRenderer.fontHeight - 7);
      this.addControl(this.messageList);
      this.addControl(this.inputTextField);
      this.selectControl(this.inputTextField);
      this.menuActions = new Vector();
      this.menuActions.addElement(new UIAction(TextConstant.smileys(), new ShowSmileyAction(this)));
      this.menuActions.addElement(new UIAction(TextConstant.buzz(), new BuzzAction(this, isPrivateChat)));
      if (isGroupChat) {
         this.menuActions.addElement(new UIAction(TextConstant.invite(), new InviteFriendAction(this)));
      }

      this.menuActions.addElement(new UIAction("Copy", new CopyAction(this)));
      this.menuActions.addElement(new UIAction(TextConstant.paste(), new PasteAction(this)));
      this.menuActions.addElement(new UIAction(TextConstant.close(), new ChatRoomCLoseMenuAction(this, isGroupChat)));
      this.popupMenuData = new PopupSideElementData(this.menuActions);
      super.leftCommand = new UIAction("Menu", new chatRoomOpenMenuAction(this));
      super.centerCommand = new UIAction("Chat", null);
      if (GameManager.promoMessage != null) {
         this.messageList.addMessage(GameManager.promoMessage, 2);
      }
   }

   public static void refreshPendingChatTarget() {
      if (BuddyListScreen.pendingChatTarget != null) {
         TextRendererHelper.computeTextWidthWithOffset(BuddyListScreen.pendingChatTarget, 1);
      }
   }

   public final void setCurrentRoomName(String var1) {
      this.currentRoomName = var1;
      if (this.currentRoomName != null) {
         TextRendererHelper.computeTextWidthWithOffset(this.currentRoomName, 1);
      }

      if (BuddyListScreen.pendingChatTarget != null) {
         TextRendererHelper.computeTextWidthWithOffset(BuddyListScreen.pendingChatTarget, 1);
      }
   }

   public final boolean handleInput(boolean[] var1, boolean[] var2, int[] var3) {
      if (var1[16]) {
         var1[16] = false;
         this.inputTextField.setText(ContentFilter.filterProfanity(this.inputTextField.getText()));
         if (this.inputTextField.getText().equals("")) {
            String var8;
            int var10;
            if ((var10 = (var8 = this.messageList.getSelectedLine()).indexOf("http://")) >= 0) {
               String var9 = var8.substring(var10);

               try {
                  Xuka.instance.platformRequest(var9);
               } catch (ConnectionNotFoundException var4) {
               }

               return false;
            } else {
               this.inputTextField.openSystemTextBox();
               return false;
            }
         } else {
            if (this.inputTextField.getText().equals("plf")) {
               this.messageList.addUserMessage("", Xuka.platformName, 0);
            }

            Object var5 = null;
            if (this.isGroupChat) {
               GameManager.instance.lastMessageSender = BuddyListScreen.currentGroupName;
               GameManager.instance.messageRepeatCount++;
               if (GameManager.instance.messageRepeatCount > 5) {
//                  this.messageList.addMessage("Bạn chỉ có thể chat 5 câu liên tục khi chat nhóm", 1);
//                  return false;
               }

               MessageHandler.f(super.subtitle, this.inputTextField.getText());
            } else if (this.isPrivateChat) {
               MessageHandler.a((String)(var5 = LoginYahooScreen.x), this.chatPartnerName, this.inputTextField.getText(), 2);
            } else {
               MessageHandler.a((String)(var5 = BuddyListScreen.currentGroupName), super.title, this.inputTextField.getText(), 1);
            }

            this.messageList.addUserMessage(this.isPrivateChat ? LoginYahooScreen.y : BuddyListScreen.userStatusMessage, this.inputTextField.getText(), 0);
            this.messageList.scrollToBottom();
            this.inputTextField.setText("");
            return false;
         }
      } else if (var1[12] || var2[12]) {
         var1[12] = false;
         this.messageList.handleSoftKey(12);
         return false;
      } else if (!var1[13] && !var2[13]) {
         return super.handleInput(var1, var2, var3);
      } else {
         var1[13] = false;
         this.messageList.handleSoftKey(13);
         return false;
      }
   }

   public final void updateLayout() {
      this.messageList.handleFocus();
   }

   public final void drawOverlay(Graphics var1) {
      this.messageList.drawScrollbar(var1);
   }

   public static PopupSideElementData getPopupMenuData(ChatRoomScreen var0) {
      return var0.popupMenuData;
   }
}
