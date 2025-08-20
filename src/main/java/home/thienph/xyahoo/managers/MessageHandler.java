package home.thienph.xyahoo.managers;

import home.thienph.xyahoo.actions.*;
import home.thienph.xyahoo.components.*;
import home.thienph.xyahoo.conections.ConnectionManager;
import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.data.networks.ByteBuffer;
import home.thienph.xyahoo.data.networks.Packet;
import home.thienph.xyahoo.screens.*;
import home.thienph.xyahoo.components.PopupDialogLayout;
import home.thienph.xyahoo.data.data.PopupSideElementData;
import home.thienph.xyahoo.main.Xuka;
import home.thienph.xyahoo.utils.Base64Encoder;
import home.thienph.xyahoo.utils.UIFormBuilder;

import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.Image;
import java.util.Vector;

public class MessageHandler {
   public String a;
   public Image b;
   public long c;
   public long d;
   public boolean e;

   public MessageHandler(int var1, String var2, byte[] var3, long var4, long var6, String var8) {
      try {
         this.b = Image.createImage(var3, 0, var3.length);
      } catch (Exception var9) {
      }

      this.a = var2;
      this.c = var4;
      this.d = var6;
      this.e = false;
   }

   public static String decodePacket(Packet var0) {
      return readString(var0);
   }

   public static void processRawPacket(byte[] var0) {
      if (var0 != null) {
         Packet var1 = new Packet(0, 0);
         var1.setPayload(new ByteBuffer(var0));
         while (true) {
            switch (readInt(var1)) {
               case 0:
                  int var147 = readInt(var1);
                  GameManager.instance.removeScreen(GameManager.instance.findScreenById(var147));
                  break;
               case 1:
                  boolean var184 = readBool(var1);
                  String var146 = decodePacket(var1);
                  GameManager.instance.showMessage(var146).setExtraOption(var184);
                  break;
               case 2:
                  GameManager.instance.closeTopDialog();
                  break;
               case 3:
                  int var144 = readInt(var1);
                  Packet var165 = new Packet(0, 0);
                  writeInt(var144, var165);
                  int var145 = readInt(var1);
                  int var175 = 0;

                  for (; var175 < var145; var175++) {
                     int var180 = var1.getPayload().readByte();
                     byte var186 = var1.getPayload().readByte();
                     if (var180 == 0) {
                        if (var186 == 0) {
                           writeInt(readInt(var1), var165);
                        } else if (var186 == 1) {
                           var180 = readInt(var1);
                           Screen var189 = GameManager.instance.findScreenById(var180);
                           int var196 = readInt(var1);
                           UIControlBase var199 = var189.getControlById(var196);
                           boolean var206 = readBool(var1);
                           int var213 = 0;
                           if (var199 instanceof TextField) {
                              String var219 = ((TextField)var199).getText();
                              if (var206 && var219.equals("")) {
                                 var189.selectControl(var199);
                                 return;
                              }

                              try {
                                 var213 = Integer.parseInt(var219);
                              } catch (Exception var117) {
                                 var189.selectControl(var199);
                                 return;
                              }
                           } else if (var199 instanceof UIDropdown) {
                              var213 = ((UIDropdown)var199).a();
                           } else if (var199 instanceof UIGridMenu) {
                              var213 = ((UIGridMenu)var199).getSelectedItemId();
                           }

                           writeInt(var213, var165);
                        }
                     } else if (var180 == 1) {
                        if (var186 == 0) {
                           writeString(decodePacket(var1), var165);
                        } else if (var186 == 1) {
                           var180 = readInt(var1);
                           Screen var190 = GameManager.instance.findScreenById(var180);
                           int var197 = readInt(var1);
                           boolean var200 = readBool(var1);
                           UIControlBase var207;
                           if ((var207 = var190.getControlById(var197)) instanceof TextField) {
                              String var214 = ((TextField)var207).getText();
                              if (var200 && var214.equals("")) {
                                 var190.selectControl(var207);
                                 return;
                              }

                              writeString(var214, var165);
                           } else if (var207 instanceof UIDropdown) {
                              writeString(((UIDropdown)var207).b(), var165);
                           }
                        }
                     } else if (var180 == 2) {
                        if (var186 == 0) {
                           writeBool(readBool(var1), var165);
                        } else if (var186 == 1) {
                           var180 = readInt(var1);
                           Screen var191 = GameManager.instance.findScreenById(var180);
                           int var198 = readInt(var1);
                           UIControlBase var201;
                           if ((var201 = var191.getControlById(var198)) instanceof UICheckBox) {
                              boolean var208 = ((UICheckBox)var201).a;
                              writeBool(((UICheckBox)var201).a, var165);
                           }
                        }
                     }
                  }

                  b(var165.getPayload().getBuffer());
                  break;
               case 4:
                  FormScreen formScreen = new FormScreen();
                  formScreen.isScrolling = true;
                  String var105 = decodePacket(var1);
                  formScreen.title = var105;
                  int var106 = readInt(var1);
                  formScreen.padding = var106;
                  boolean var107 = readBool(var1);
                  Screen var108;
                  if ((var108 = GameManager.instance.findScreenById(var106)) != null) {
                     GameManager.instance.removeScreen(var108);
                  }

                  if (var106 == -1) {
                     GameManager.instance.displayHomeScreen();
                  }

                  formScreen.startSlide(1);
                  GameManager.instance.showScreen(formScreen);
                  if (var107) {
                     GameManager.instance.goToLastScreen();
                  }
                  break;
               case 5:
                  int var188 = readInt(var1);
                  Screen var195 = GameManager.instance.findScreenById(var188);
                  switch (var1.getPayload().readByte()) {
                     case 0:
                        UIAction var205 = parseMenuEntry(var1);
                        if (GameManager.isTextFieldControl(var188)) {
                           Vector var212;
                           (var212 = new Vector()).addElement(new UIAction(TextConstant.smileys(), new thien_m()));
                           var212.addElement(var205);
                           PopupSideElementData var218 = new PopupSideElementData(var212);
                           var195.leftCommand = new UIAction("Menu", new thien_n(var218));
                        } else {
                           var195.leftCommand = var205;
                        }
                        continue;
                     case 1:
                        var195.centerCommand = parseMenuEntry(var1);
                        continue;
                     case 2:
                        var195.rightCommand = parseMenuEntry(var1);
                     default:
                        continue;
                  }
               case 6:
                  int var161 = readInt(var1);
                  FormScreen var174 = (FormScreen) GameManager.instance.findScreenById(var161);
                  byte var194 = var1.getPayload().readByte();
                  Object var142 = null;
                  switch (var194) {
                     case 0:
                        String var220 = decodePacket(var1);
                        int var221 = readInt(var1);
                        int var222 = readInt(var1);
                        var142 = UIFormBuilder.addTextFieldWithLabel(var174, var220, var221, var222);
                        break;
                     case 1:
                        String var223 = decodePacket(var1);
                        int var224 = readInt(var1);
                        if (var223.equals("")) {
                           thien_ai var226;
                           (var226 = UIFormBuilder.addLabel(var174, var224)).a = c(readInt(var1));
                           var226.b = new Integer(var226.a);
                           var226.isVisible = !var223.trim().equals("");
                           var142 = var226;
                        } else {
                           var142 = UIFormBuilder.addWrappedLabels(var223, var174, var224, c(readInt(var1)), true, true)[0];
                        }
                        break;
                     case 4:
                        String var163 = decodePacket(var1);
                        int var143 = readInt(var1);
                        int var225 = c(readInt(var1));
                        byte[] var227 = readByteArray(var1);
                        thien_aj var228;
                        (var228 = UIFormBuilder.addCheckBox(var174, var163, var143, new thien_o(var227), var174.w, var174.x, var174.y)).a = new Integer(var225);
                        var142 = var228;
                        break;
                     case 5:
                        String var229 = decodePacket(var1);
                        readInt(var1);
                        var142 = UIFormBuilder.addLabelsAuto(var174, var229)[0];
                        break;
                     case 6:
                        int var232 = readInt(var1);
                        byte[] var233 = readByteArray(var1);

                        try {
                           var142 = UIFormBuilder.addImage(var174, var233, var232);
                        } catch (Exception var115) {
                        }
                        break;
                     case 7:
                        String var93 = decodePacket(var1);
                        int var94 = readInt(var1);
                        int var95;
                        String[] var96 = new String[var95 = readInt(var1)];

                        for (int var97 = 0; var97 < var95; var97++) {
                           var96[var97] = decodePacket(var1);
                        }

                        byte[] var237 = readByteArray(var1);
                        UIDropdown var98;
                        (var98 = UIFormBuilder.addDropdown(var174, var93, var96, var94)).a(new thien_g(var237));
                        var142 = var98;
                        break;
                     case 8:
                        int var234 = readInt(var1);
                        byte var80;
                        int[] var81 = new int[var80 = var1.getPayload().readByte()];

                        for (int var82 = 0; var82 < var80; var82++) {
                           var81[var82] = readInt(var1);
                        }

                        int var235 = readInt(var1);
                        int var83 = readInt(var1);
                        boolean var84 = readBool(var1);

                        try {
                           ((UIControlBase)(var142 = UIFormBuilder.addImage(var174, var81, var235, var83, var234))).isVisible = var84;
                        } catch (Exception var113) {
                        }
                        break;
                     case 10:
                        int var85 = readInt(var1);
                        int var86 = readInt(var1);
                        int var87 = readInt(var1);
                        int[] var88 = new int[var85];
                        int[] var89 = new int[var85];
                        String[] var90 = new String[var85];

                        for (int var91 = 0; var91 < var85; var91++) {
                           var90[var91] = readString(var1);
                           var88[var91] = readInt(var1);
                           var89[var91] = readInt(var1);
                        }

                        boolean var236 = readBool(var1);
                        UIGridMenu var110 = new UIGridMenu(
                           0, Screen.headerHeight + 7, Screen.e - 3, Screen.formHeight - 3 - GameManager.topMargin, var85, var90, var88, var89, var86, var87, false, 1
                        );
                        var174.addControl(var110);
                        var174.selectControl(var110);
                        UIAction var112 = new UIAction(TextConstant.select(), new thien_q(var236, var110, var1));
                        var110.actionTertiary = var112;
                        break;
                     case 12:
                        int var231 = readInt(var1);
                        byte[] var77 = readByteArray(var1);
                        thien_ag var78 = null;

                        try {
                           var78 = UIFormBuilder.addImage(var174, var77, var231);
                           byte[] var79 = readByteArray(var1);
                           var78.b = new thien_p(var79);
                        } catch (Exception var114) {
                        }

                        var142 = var78;
                        break;
                     case 13:
                        String var162 = decodePacket(var1);
                        readInt(var1);
                        var142 = UIFormBuilder.addCheckBox(var174, var162, (IAction)null);
                        break;
                     case 41:
                        int var99 = readInt(var1);
                        int var100 = readInt(var1);
                        int var101 = readInt(var1);
                        ((UIDropdown) GameManager.instance.findScreenById(var99).getControlById(var100)).c(var101);
                  }

                  var161 = readInt(var1);
                  ((UIControlBase)var142).zIndex = var161;
                  if (((UIControlBase)var142).zIndex > 1000 && var142 instanceof TextField) {
                     ((TextField)var142).useSystemInputBox = true;
                  }
                  break;
               case 7:
                  int var141 = readInt(var1);
                  Screen var64 = GameManager.instance.findScreenById(var141);
                  int var65 = readInt(var1);
                  UIControlBase var66 = var64.getControlById(var65);
                  var64.selectControl(var66);
                  if (var64.equals(GameManager.instance.getCurrentScreen())) {
                     var64.updateLayout();
                  }
                  break;
               case 8:
                  return;
               case 9:
               case 10:
               case 27:
               case 30:
               case 31:
               case 32:
               case 33:
               case 34:
               case 36:
               case 37:
               case 38:
               default:
                  return;
               case 11:
                  byte var70 = var1.getPayload().readByte();
                  Vector var71 = new Vector();
                  int var72 = readInt(var1);

                  for (int var73 = 0; var73 < var72; var73++) {
                     String var74 = decodePacket(var1);
                     byte[] var75 = readByteArray(var1);
                     UIAction var76 = new UIAction(var74, new thien_h(var75));
                     var71.addElement(var76);
                  }

                  PopupSideElementData var230 = new PopupSideElementData(var71);
                  GameManager.instance.showSideMenu(var230, var70);
                  break;
               case 12:
                  int var204 = readInt(var1);
                  FormScreen var211 = (FormScreen) GameManager.instance.findScreenById(var204);
                  int var217;
                  String[] var140 = new String[var217 = readInt(var1)];

                  for (int var160 = 0; var160 < var217; var160++) {
                     var140[var160] = decodePacket(var1);
                  }

                  var211.setSections(var140);
                  break;
               case 13:
                  int var67 = readInt(var1);
                  FormScreen var68 = (FormScreen) GameManager.instance.findScreenById(var67);
                  int var69 = readInt(var1);
                  var68.toggleSection(var69);
                  break;
               case 14:
                  byte var135 = var1.getPayload().readByte();
                  String var159 = "";
                  if (var135 == 0) {
                     var159 = readString(var1);
                  } else {
                     int var136 = readInt(var1);
                     Screen var173 = GameManager.instance.findScreenById(var136);
                     int var137 = readInt(var1);
                     boolean var179 = readBool(var1);
                     UIControlBase var138;
                     if ((var138 = var173.getControlById(var137)) instanceof TextField) {
                        var159 = ((TextField)var138).getText();
                        if (var179 && var159.equals("")) {
                           var173.selectControl(var138);
                           return;
                        }
                     }
                  }

                  String var139 = readString(var1);
                  GameManager.instance.showConfirmDialog("Gửi tin nhắn: " + var159 + Xuka.refCode + " => " + var139.substring(6), new thien_l(var159, var139));
                  break;
               case 15:
                  try {
                     Xuka.instance.platformRequest(readString(var1));
                  } catch (ConnectionNotFoundException var118) {
                  }
                  break;
               case 16:
                  GameManager.instance.findScreenById(readInt(var1)).getControlById(readInt(var1)).baseX = readInt(var1);
                  break;
               case 17:
                  Screen var133;
                  UIControlBase var158 = (var133 = GameManager.instance.findScreenById(readInt(var1))).getControlById(readInt(var1));
                  UIControlBase var134 = var133.getControlById(readInt(var1));
                  var158.baseX = var134.baseX + var134.width + 10;
                  break;
               case 18:
                  FormScreen var132;
                  UIControlBase var157;
                  (var157 = (var132 = (FormScreen) GameManager.instance.findScreenById(readInt(var1))).getControlById(readInt(var1))).baseY = readInt(var1);
                  var132.x = var157.baseY + var157.height + 2;
                  break;
               case 19:
                  FormScreen var131;
                  UIControlBase var156 = (var131 = (FormScreen) GameManager.instance.findScreenById(readInt(var1))).getControlById(readInt(var1));
                  UIControlBase var172 = var131.getControlById(readInt(var1));
                  var156.baseY = var172.baseY + var172.height + 2;
                  var131.x = var156.baseY + var156.height + 2;
                  break;
               case 20:
                  FormScreen var130;
                  UIControlBase var155 = (var130 = (FormScreen) GameManager.instance.findScreenById(readInt(var1))).getControlById(readInt(var1));
                  UIControlBase var171 = var130.getControlById(readInt(var1));
                  var155.baseY = var171.baseY;
                  var130.x = var155.baseY + var155.height + 2;
                  break;
               case 21:
                  String var129 = readString(var1);
                  Packet var154 = new Packet(0, 0);
                  writeInt(0, var154);
                  writeString(var129, var154);
                  b(var154.getPayload().getBuffer());
                  break;
               case 22:
                  GameManager.instance.removeScreen(GameManager.instance.findScreenByTitle(readString(var1)));
                  break;
               case 23:
                  GameManager.instance.closeTopDialog();
                  break;
               case 24:
                  int var128 = readInt(var1);
                  int var153 = readInt(var1);
                  String var170 = readString(var1);

                  try {
                     ((TextField) GameManager.instance.findScreenById(var128).getControlById(var153)).setText(var170);
                  } catch (Exception var119) {
                  }
                  break;
               case 25:
                  String var127 = readString(var1);
                  GameManager.instance.buddyListScreen.showAddFriendScreen(var127);
                  break;
               case 26:
                  String var125 = readString(var1);
                  ChatRoomScreen var126 = GameManager.getInstance().createChatRoom(var125);
                  GameManager.getInstance().switchToScreenByTitle(var126.title);
                  break;
               case 28:
                  if (GameManager.instance.dialogQueue.size() > 0 && ((PopupDialogLayout) GameManager.instance.dialogQueue.elementAt(0)).showExtraOption) {
                     GameManager.instance.closeTopDialog();
                  }

                  GameManager.instance.showSimpleDialog(readString(var1));
                  break;
               case 29:
                  String title = readString(var1);
                  String leftActionName = readString(var1);
                  byte[] leftActionData = readByteArray(var1);
                  String centerActionName = readString(var1);
                  byte[] centerActionData = readByteArray(var1);
                  String rightActionName = readString(var1);
                  byte[] rightActionData = readByteArray(var1);
                  UIAction leftAction = new UIAction(leftActionName, new LeftButtonAction(leftActionData));
                  UIAction centerAction = new UIAction(centerActionName, new CenterButtonAction(centerActionData));
                  UIAction rightAction = new UIAction(rightActionName, new RightButtonAction(rightActionData));
                  if (GameManager.instance.dialogQueue.size() > 0 && ((PopupDialogLayout) GameManager.instance.dialogQueue.elementAt(0)).showExtraOption) {
                     GameManager.instance.closeTopDialog();
                  }

                  GameManager.instance.showCenterDialog(title, leftAction, centerAction, rightAction);
                  break;
               case 35:
                  int var3 = readInt(var1);
                  int var4 = readInt(var1);
                  Packet var5 = new Packet(var3, var4);
                  var4 = readInt(var1);

                  for (int var6 = 0; var6 < var4; var6++) {
                     byte var7 = var1.getPayload().readByte();
                     byte var8 = var1.getPayload().readByte();
                     if (var7 == 0) {
                        if (var8 == 0) {
                           writeInt(readInt(var1), var5);
                        } else if (var8 == 1) {
                           int var9 = readInt(var1);
                           Screen var10 = GameManager.instance.findScreenById(var9);
                           int var11 = readInt(var1);
                           UIControlBase var121 = var10.getControlById(var11);
                           boolean var148 = readBool(var1);
                           var3 = 0;
                           if (var121 instanceof TextField) {
                              String var192 = ((TextField)var121).getText();
                              if (var148 && var192.equals("")) {
                                 var10.selectControl(var121);
                                 return;
                              }

                              try {
                                 var3 = Integer.parseInt(var192);
                              } catch (Exception var116) {
                                 var10.selectControl(var121);
                                 return;
                              }
                           } else if (var121 instanceof UIDropdown) {
                              var3 = ((UIDropdown)var121).a();
                           } else if (var121 instanceof UIGridMenu) {
                              var3 = ((UIGridMenu)var121).getSelectedItemId();
                           }

                           writeInt(var3, var5);
                        }
                     } else if (var7 == 1) {
                        if (var8 == 0) {
                           writeString(decodePacket(var1), var5);
                        } else if (var8 == 1) {
                           int var202 = readInt(var1);
                           Screen var209 = GameManager.instance.findScreenById(var202);
                           int var215 = readInt(var1);
                           boolean var122 = readBool(var1);
                           UIControlBase var149;
                           if ((var149 = var209.getControlById(var215)) instanceof TextField) {
                              String var167 = ((TextField)var149).getText();
                              if (var122 && var167.equals("")) {
                                 var209.selectControl(var149);
                                 return;
                              }

                              writeString(var167, var5);
                           } else if (var149 instanceof UIDropdown) {
                              writeString(((UIDropdown)var149).b(), var5);
                           }
                        }
                     } else if (var7 == 2) {
                        if (var8 == 0) {
                           writeBool(readBool(var1), var5);
                        } else if (var8 == 1) {
                           int var203 = readInt(var1);
                           Screen var210 = GameManager.instance.findScreenById(var203);
                           int var216 = readInt(var1);
                           UIControlBase var123;
                           if ((var123 = var210.getControlById(var216)) instanceof UICheckBox) {
                              boolean var150 = ((UICheckBox)var123).a;
                              writeBool(((UICheckBox)var123).a, var5);
                           }
                        }
                     }
                  }

                  ConnectionManager.sendPacket(var5);
                  break;
               case 39:
                  processRawPacket(readByteArray(var1));
                  break;
               case 40:
                  String var120 = readString(var1);
                  byte var2 = var1.getPayload().readByte();
                  GameManager.instance.buddyListScreen.handleChatAction(var120, var2);
            }
         }
      }
   }

   private static UIAction parseMenuEntry(Packet var0) {
      byte[] var1 = readByteArray(var0);
      return new UIAction(decodePacket(var0), new thien_i(var1));
   }

   public static void a(String var0) {
      Packet var1 = new Packet(6000000, 48);
      writeString(var0, var1);
      ConnectionManager.sendPacket(var1);
   }

   public static void a() {
      ConnectionManager.sendPacket(new Packet(5000009, 39));
   }

   public static void b(String var0) {
      Packet var1 = new Packet(GameManager.isTestMode ? 5000011 : 3402, 39);
      writeString(var0, var1);
      ConnectionManager.sendPacket(var1);
   }

   public static void c(String var0) {
      Packet var1 = new Packet(5023, 2);
      writeString(var0, var1);
      ConnectionManager.sendPacket(var1);
   }

   public static void a(int var0) {
      Packet var1 = new Packet(var0, var0 == 5000008 ? 8 : 2);
      if (var0 == 5000008) {
         writeString("", var1);
      } else if (var0 == 321) {
         writeString(BuddyListScreen.currentGroupName, var1);
      }

      ConnectionManager.sendPacket(var1);
   }

   public static void a(int var0, String var1, long var2) {
      Packet var4 = new Packet();
      if (var0 == 3) {
         var4 = new Packet(4514, 45);
      }

      writeString(var1, var4);
      writeLong(var2, var4);
      ConnectionManager.sendPacket(var4);
   }

   public static void a(String var0, String var1) {
      Packet var2 = new Packet(3403, 39);
      writeString(var0, var2);
      writeString(var1, var2);
      ConnectionManager.sendPacket(var2);
   }

   public static void d(String var0) {
      Packet var1 = new Packet(3404, 39);
      writeString(var0, var1);
      ConnectionManager.sendPacket(var1);
   }

   public static void b(String var0, String var1) {
      Packet var2 = new Packet(3405, 39);
      writeString(var0, var2);
      writeString(var1, var2);
      ConnectionManager.sendPacket(var2);
   }

   public static void c(String var0, String var1) {
      Packet var2 = new Packet(3406, 39);
      writeString(var0, var2);
      writeString(var1, var2);
      ConnectionManager.sendPacket(var2);
   }

   public static void d(String var0, String var1) {
      Packet var2 = new Packet(3407, 39);
      writeString(var0, var2);
      writeString(var1, var2);
      ConnectionManager.sendPacket(var2);
   }

   public static void a(String var0, String var1, int var2, byte[] var3) {
      Packet var4 = new Packet(3408, 39);
      writeString(var0, var4);
      writeString(var1, var4);
      writeInt(var2, var4);
      int var7;
      writeInt(var7 = var3.length, var4);

      for (int var8 = 0; var8 < var7; var8++) {
         byte var9 = var3[var8];
         var4.getPayload().ensureCapacity(1);
         var4.getPayload().writeByte(var9);
      }

      ConnectionManager.sendPacket(var4);
   }

   public static void a(String var0, String var1, String var2) {
      Packet var3 = new Packet(3412, 39);
      writeString(var0, var3);
      writeString(var1, var3);
      writeString(var2, var3);
      ConnectionManager.sendPacket(var3);
   }

   public static void a(int var0, String var1, String var2, boolean var3) {
      Packet var4 = new Packet();
      if (var0 == 1) {
         var4 = new Packet(3409, 39);
      } else if (var0 == 3) {
         var4 = new Packet(4512, 45);
      }

      writeString(var1, var4);
      if (var0 == 1) {
         writeString(var2, var4);
      }

      writeBool(var3, var4);
      ConnectionManager.sendPacket(var4);
   }

   public static void a(int var0, String var1, String var2, String var3) {
      Packet var4 = new Packet();
      if (var0 == 1) {
         var4 = new Packet(3411, 39);
      } else if (var0 == 3) {
         var4 = new Packet(4515, 45);
      }

      writeString(var1, var4);
      if (var0 == 1 || var0 == 42) {
         writeString(var2, var4);
      }

      writeString(var3, var4);
      ConnectionManager.sendPacket(var4);
   }

   public static void a(int var0, String var1) {
      Packet var2 = new Packet();
      if (var0 == 1) {
         var2 = new Packet(314, 39);
      } else if (var0 == 3) {
         var2 = new Packet(4504, 45);
      }

      writeString(var1, var2);
      ConnectionManager.sendPacket(var2);
   }

   public static void a(int var0, int var1, String var2) {
      Packet var3 = new Packet();
      if (var0 == 1) {
         var3 = new Packet(302, 39);
         writeInt(0, var3);
      } else if (var0 == 3) {
         var3 = new Packet(4502, 45);
      }

      writeString(var2, var3);
      ConnectionManager.sendPacket(var3);
   }

   public static void a(int var0, String var1, String var2, long var3) {
      Packet var5 = new Packet();
      if (var0 == 1) {
         var5 = new Packet(3410, 39);
      }

      writeString(var1, var5);
      writeString(var2, var5);
      writeLong(var3, var5);
      ConnectionManager.sendPacket(var5);
   }

   public static void b() {
      Packet var0 = new Packet(324, 13);
      writeInt(Xuka.partnerId, var0);
      writeInt(Xuka.appId, var0);
      ConnectionManager.sendPacket(var0);
      var0 = new Packet(5030, 2);
      writeInt(1, var0);
      ConnectionManager.sendPacket(var0);
   }

   public static void a(String var0, String var1, int var2) {
      Packet var3 = new Packet(27, var2 == 2 ? 7 : 2);
      writeString(var0, var3);
      writeString(var1, var3);
      ConnectionManager.sendPacket(var3);
   }

   public static void b(String var0, String var1, int var2) {
      Packet var3 = new Packet(1009, 1002);
      writeString(var0, var3);
      writeString(var1, var3);
      ConnectionManager.sendPacket(var3);
   }

   public static void a(boolean var0, String var1, String var2) {
      Packet var3 = new Packet(1010, 1001);
      writeBool(var0, var3);
      writeString(var2, var3);
      writeString(var1, var3);
      ConnectionManager.sendPacket(var3);
   }

   public static void e(String var0, String var1) {
      Packet var2 = new Packet(5000010, 13);
      writeString(Base64Encoder.encodeAndReverse(var0), var2);
      writeString(Base64Encoder.encodeAndReverse(var1), var2);
      writeInt(Xuka.partnerId, var2);
      writeInt(Xuka.appId, var2);
      ConnectionManager.sendPacket(var2);
   }

   public static void a(int var0, int var1) {
      Packet var2 = new Packet(var1 == 1 ? 15 : 5000016, var1 == 1 ? 2 : 20);
      writeInt(var0, var2);
      ConnectionManager.sendPacket(var2);
   }

   public static void a(String var0, int var1) {
      Packet var2 = new Packet(8, var1 == 1 ? 2 : 20);
      if (var1 == 2) {
         LoginYahooScreen.A = var0;
         Xuka.saveCustomStr(LoginYahooScreen.x, var0, true);
      }

      writeString(var0, var2);
      ConnectionManager.sendPacket(var2);
   }

   public static void login(String username, String password, int var2, int var3, int var4) {
      Packet var6;
      if (var3 == 1) {
         Packet var5 = new Packet(1016, 13);
         if (TextConstant.languageId == 1) {
            writeInt(2, var5);
         } else {
            writeInt(TextConstant.languageId, var5);
         }

         ConnectionManager.sendPacket(var5);
         var6 = new Packet(5000007, 13);
      } else {
         var6 = new Packet(61, 20);
      }

      writeString(Base64Encoder.encodeAndReverse(username), var6);
      writeString(Base64Encoder.encodeAndReverse(password), var6);
      writeInt(var2, var6);
      writeString("", var6);
      writeInt(var4, var6);
      ConnectionManager.sendPacket(var6);
   }

   public static void a(String var0, String var1, String var2, int var3) {
      Packet var4;
      if (var3 == 1) {
         var4 = new Packet(3, 2);
      } else {
         var4 = new Packet(3, 20);
      }

      writeString(var0, var4);
      writeString(var1, var4);
      writeString(var2, var4);
      ConnectionManager.sendPacket(var4);
   }

   public static void e(String var0) {
      Packet var1 = new Packet(13, 2);
      writeString(var0, var1);
      ConnectionManager.sendPacket(var1);
   }

   public static void f(String var0) {
      Packet var1 = new Packet(1020, 1002);
      writeString(var0, var1);
      ConnectionManager.sendPacket(var1);
   }

   public static void g(String var0) {
      Packet var1 = new Packet(1000, 1000);
      writeString(var0, var1);
      writeBool(false, var1);
      writeString("", var1);
      ConnectionManager.sendPacket(var1);
   }

   public static void a(String var0, String[] var1) {
      Packet var2 = new Packet(1002, 1000);
      writeString(var0, var2);
      writeInt(var1.length, var2);

      for (int var3 = 0; var3 < var1.length; var3++) {
         writeString(var1[var3], var2);
      }

      ConnectionManager.sendPacket(var2);
   }

   public static void h(String var0) {
      Packet var1 = new Packet(1008, 1000);
      writeString(var0, var1);
      ConnectionManager.sendPacket(var1);
   }

   public static void a(String var0, boolean var1, String var2, String var3) {
      Packet var4 = new Packet(1003, 1000);
      writeString(var0, var4);
      writeBool(var1, var4);
      writeString(var2, var4);
      writeString(var3, var4);
      ConnectionManager.sendPacket(var4);
   }

   public static void f(String var0, String var1) {
      Packet var2 = new Packet(1005, 1000);
      writeString(var0, var2);
      writeString(var1, var2);
      ConnectionManager.sendPacket(var2);
   }

   public static void i(String var0) {
      Packet var1 = new Packet(37, 10);
      writeString(var0, var1);
      ConnectionManager.sendPacket(var1);
   }

   public static void b(String var0, int var1) {
      Packet var2 = new Packet(28, 20);
      writeString(var0, var2);
      ConnectionManager.sendPacket(var2);
   }

   public static void g(String var0, String var1) {
      Packet var2 = new Packet(1021, 1002);
      writeString(var0, var2);
      writeString(var1, var2);
      ConnectionManager.sendPacket(var2);
   }

   public static void h(String var0, String var1) {
      Packet var2 = new Packet(1022, 1002);
      writeString(var0, var2);
      writeString(var1, var2);
      ConnectionManager.sendPacket(var2);
   }

   public static void c() {
      if (GameHandler.a != null) {
         Packet var0 = new Packet(50, 2);
         writeString(GameHandler.a, var0);
         ConnectionManager.sendPacket(var0);
      }
   }

   public static void b(String var0, String var1, String var2) {
      Packet var3 = new Packet(51, 2);
      writeString(var0, var3);
      writeString(var1, var3);
      writeString(var2, var3);
      ConnectionManager.sendPacket(var3);
   }

   public static void i(String var0, String var1) {
      Packet var2 = new Packet(62, 2);
      writeString(var0, var2);
      writeString(var1, var2);
      ConnectionManager.sendPacket(var2);
   }

   public static void d() {
      ConnectionManager.sendPacket(new Packet(63, 2));
   }

   public static void j(String var0, String var1) {
      Packet var2 = new Packet(79, 2);
      writeString(var0, var2);
      writeString(var1, var2);
      ConnectionManager.sendPacket(var2);
   }

   public static void c(String var0, String var1, int var2) {
      Packet var3 = new Packet(78, 20);
      writeString(var0, var3);
      writeString(var1, var3);
      writeInt(var2, var3);
      ConnectionManager.sendPacket(var3);
   }

   public static void a(int var0, String var1, int var2, String var3) {
      Packet var4 = new Packet(88, 21);
      writeInt(0, var4);
      writeString(var1, var4);
      writeInt(var2, var4);
      writeString(var3, var4);
      ConnectionManager.sendPacket(var4);
   }

   public static void b(byte[] var0) {
      Packet var1 = new Packet(115, 2);
      int var2 = var0.length;
      boolean var5 = false;
      var1.getPayload().ensureCapacity(var2 + 4);
      writeIntToBuffer(var2, var1);
      var1.getPayload().writeBytes(var0, 0, var2);
      ConnectionManager.sendPacket(var1);
   }

   public static void b(int var0) {
      Packet var1 = new Packet(119, 2);
      writeInt(var0, var1);
      ConnectionManager.sendPacket(var1);
   }

   public static int c(int var0) {
      return var0 != 0 && var0 != 0 ? var0 : 16777215;
   }

   public static short readShort(Packet var0) {
      short var1 = 0;

      for (int var2 = 0; var2 < 2; var2++) {
         short var3;
         var1 = (short)((var3 = (short)(var1 << 8)) | 255 & var0.getPayload().readByte());
      }

      return var1;
   }

   public static byte[] readByteArray(Packet var0) {
      int var1 = readInt(var0);
      return var0.getPayload().readBytes(var1);
   }

   public static long readLong(Packet var0) {
      long var1 = 0L;

      for (int var3 = 0; var3 < 8; var3++) {
         long var4;
         var1 = (var4 = var1 << 8) | (long)(255 & var0.getPayload().readByte());
      }

      return var1;
   }

   public static int readInt(Packet var0) {
      int var1 = 0;

      for (int var2 = 0; var2 < 4; var2++) {
         int var3;
         var1 = (var3 = var1 << 8) | 255 & var0.getPayload().readByte();
      }

      return var1;
   }

   public static thien_hg readUserInfo(Packet var0) {
      int var1 = readInt(var0);
      int var2 = readInt(var0);
      int var3 = readInt(var0);
      int var4 = readInt(var0);
      int var5 = readInt(var0);
      int var6 = readInt(var0);
      int var7 = readInt(var0);
      return new thien_hg(var1, var2, var3, var4, var5, var6, var7);
   }

   public static boolean readBool(Packet var0) {
      return var0.getPayload().readByte() == 1;
   }

   public static char readChar(Packet var0) {
      return (char) readShort(var0);
   }

   public static String readString(Packet var0) {
      int var1 = readInt(var0);
      StringBuffer var2 = new StringBuffer(var1);

      for (int var3 = 0; var3 < var1; var3++) {
         var2.append(readChar(var0));
      }

      return var2.toString();
   }

   private static void writeIntToBuffer(int var0, Packet var1) {
      for (int var2 = 3; var2 >= 0; var2--) {
         var1.getPayload().writeByte((byte)(var0 >> (var2 << 3)));
      }
   }

   public static void writeBool(boolean var0, Packet var1) {
      var1.getPayload().ensureCapacity(1);
      if (var0) {
         var1.getPayload().writeByte((byte)1);
      } else {
         var1.getPayload().writeByte((byte)0);
      }
   }

   public static void writeInt(int var0, Packet var1) {
      var1.getPayload().ensureCapacity(4);

      for (int var2 = 3; var2 >= 0; var2--) {
         var1.getPayload().writeByte((byte)(var0 >> (var2 << 3)));
      }
   }

   public static void writeLong(long var0, Packet var2) {
      var2.getPayload().ensureCapacity(8);

      for (int var3 = 7; var3 >= 0; var3--) {
         var2.getPayload().writeByte((byte)((int)(var0 >> (var3 << 3))));
      }
   }

   public static void writeString(String value, Packet packet) {
      ByteBuffer byteBuffer = packet.getPayload();
      int valueLength = value.length();
      byteBuffer.ensureCapacity(4 + 2 * valueLength);
      writeIntToBuffer(valueLength, packet);

      for (int var7 = 0; var7 < valueLength; var7++) {
         short var10000 = (short) value.charAt(var7);
         Packet var5 = packet;
         short var4 = var10000;

         for (int var6 = 1; var6 >= 0; var6--) {
            var5.getPayload().writeByte((byte)(var4 >> (var6 << 3)));
         }
      }
   }
}
