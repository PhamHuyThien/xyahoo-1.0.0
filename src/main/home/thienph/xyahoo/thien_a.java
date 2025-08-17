package home.thienph.xyahoo;

import java.util.Vector;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.Image;

public class thien_a {
   public String a;
   public Image b;
   public long c;
   public long d;
   public boolean e;

   public thien_a(int var1, String var2, byte[] var3, long var4, long var6, String var8) {
      try {
         this.b = Image.createImage(var3, 0, var3.length);
      } catch (Exception var9) {
      }

      this.a = var2;
      this.c = var4;
      this.d = var6;
      this.e = false;
   }

   public static String a(thien_hb var0) {
      return i(var0);
   }

   public static void a(byte[] var0) {
      if (var0 != null) {
         thien_hb var1;
         (var1 = new thien_hb(0, 0)).a(new thien_ha(var0));

         while (true) {
            switch (e(var1)) {
               case 0:
                  int var147 = e(var1);
                  thien_di.c.c(thien_di.c.d(var147));
                  break;
               case 1:
                  boolean var184 = g(var1);
                  String var146 = a(var1);
                  thien_di.c.a(var146).a(var184);
                  break;
               case 2:
                  thien_di.c.c();
                  break;
               case 3:
                  int var144 = e(var1);
                  thien_hb var165 = new thien_hb(0, 0);
                  a(var144, var165);
                  int var145 = e(var1);
                  int var175 = 0;

                  for (; var175 < var145; var175++) {
                     int var180 = var1.b().a();
                     byte var186 = var1.b().a();
                     if (var180 == 0) {
                        if (var186 == 0) {
                           a(e(var1), var165);
                        } else if (var186 == 1) {
                           var180 = e(var1);
                           thien_an var189 = thien_di.c.d(var180);
                           int var196 = e(var1);
                           thien_ac var199 = var189.c(var196);
                           boolean var206 = g(var1);
                           int var213 = 0;
                           if (var199 instanceof thien_at) {
                              String var219 = ((thien_at)var199).c();
                              if (var206 && var219.equals("")) {
                                 var189.c(var199);
                                 return;
                              }

                              try {
                                 var213 = Integer.parseInt(var219);
                              } catch (Exception var117) {
                                 var189.c(var199);
                                 return;
                              }
                           } else if (var199 instanceof thien_z) {
                              var213 = ((thien_z)var199).a();
                           } else if (var199 instanceof thien_af) {
                              var213 = ((thien_af)var199).a();
                           }

                           a(var213, var165);
                        }
                     } else if (var180 == 1) {
                        if (var186 == 0) {
                           a(a(var1), var165);
                        } else if (var186 == 1) {
                           var180 = e(var1);
                           thien_an var190 = thien_di.c.d(var180);
                           int var197 = e(var1);
                           boolean var200 = g(var1);
                           thien_ac var207;
                           if ((var207 = var190.c(var197)) instanceof thien_at) {
                              String var214 = ((thien_at)var207).c();
                              if (var200 && var214.equals("")) {
                                 var190.c(var207);
                                 return;
                              }

                              a(var214, var165);
                           } else if (var207 instanceof thien_z) {
                              a(((thien_z)var207).b(), var165);
                           }
                        }
                     } else if (var180 == 2) {
                        if (var186 == 0) {
                           a(g(var1), var165);
                        } else if (var186 == 1) {
                           var180 = e(var1);
                           thien_an var191 = thien_di.c.d(var180);
                           int var198 = e(var1);
                           thien_ac var201;
                           if ((var201 = var191.c(var198)) instanceof thien_x) {
                              boolean var208 = ((thien_x)var201).a;
                              a(((thien_x)var201).a, var165);
                           }
                        }
                     }
                  }

                  b(var165.b().b());
                  break;
               case 4:
                  thien_ap var104;
                  (var104 = new thien_ap()).t = true;
                  String var105 = a(var1);
                  var104.g = var105;
                  int var106 = e(var1);
                  var104.s = var106;
                  boolean var107 = g(var1);
                  thien_an var108;
                  if ((var108 = thien_di.c.d(var106)) != null) {
                     thien_di.c.c(var108);
                  }

                  if (var106 == -1) {
                     thien_di.c.A();
                  }

                  var104.a(1);
                  thien_di.c.b(var104);
                  if (var107) {
                     thien_di.c.j();
                  }
                  break;
               case 5:
                  int var188 = e(var1);
                  thien_an var195 = thien_di.c.d(var188);
                  switch (var1.b().a()) {
                     case 0:
                        thien_ab var205 = j(var1);
                        if (thien_di.c(var188)) {
                           Vector var212;
                           (var212 = new Vector()).addElement(new thien_ab(thien_as.F(), new thien_m()));
                           var212.addElement(var205);
                           thien_am var218 = new thien_am(var212);
                           var195.k = new thien_ab("Menu", new thien_n(var218));
                        } else {
                           var195.k = var205;
                        }
                        continue;
                     case 1:
                        var195.m = j(var1);
                        continue;
                     case 2:
                        var195.l = j(var1);
                     default:
                        continue;
                  }
               case 6:
                  int var161 = e(var1);
                  thien_ap var174 = (thien_ap)thien_di.c.d(var161);
                  byte var194 = var1.b().a();
                  Object var142 = null;
                  switch (var194) {
                     case 0:
                        String var220 = a(var1);
                        int var221 = e(var1);
                        int var222 = e(var1);
                        var142 = thien_y.b(var174, var220, var221, var222);
                        break;
                     case 1:
                        String var223 = a(var1);
                        int var224 = e(var1);
                        if (var223.equals("")) {
                           thien_ai var226;
                           (var226 = thien_y.a(var174, var224)).a = c(e(var1));
                           var226.b = new Integer(var226.a);
                           var226.o = !var223.trim().equals("");
                           var142 = var226;
                        } else {
                           var142 = thien_y.a(var223, var174, var224, c(e(var1)), true, true)[0];
                        }
                        break;
                     case 4:
                        String var163 = a(var1);
                        int var143 = e(var1);
                        int var225 = c(e(var1));
                        byte[] var227 = c(var1);
                        thien_aj var228;
                        (var228 = thien_y.b(var174, var163, var143, new thien_o(var227), var174.w, var174.x, var174.y)).a = new Integer(var225);
                        var142 = var228;
                        break;
                     case 5:
                        String var229 = a(var1);
                        e(var1);
                        var142 = thien_y.a(var174, var229)[0];
                        break;
                     case 6:
                        int var232 = e(var1);
                        byte[] var233 = c(var1);

                        try {
                           var142 = thien_y.a(var174, var233, var232);
                        } catch (Exception var115) {
                        }
                        break;
                     case 7:
                        String var93 = a(var1);
                        int var94 = e(var1);
                        int var95;
                        String[] var96 = new String[var95 = e(var1)];

                        for (int var97 = 0; var97 < var95; var97++) {
                           var96[var97] = a(var1);
                        }

                        byte[] var237 = c(var1);
                        thien_z var98;
                        (var98 = thien_y.a(var174, var93, var96, var94)).a(new thien_g(var237));
                        var142 = var98;
                        break;
                     case 8:
                        int var234 = e(var1);
                        byte var80;
                        int[] var81 = new int[var80 = var1.b().a()];

                        for (int var82 = 0; var82 < var80; var82++) {
                           var81[var82] = e(var1);
                        }

                        int var235 = e(var1);
                        int var83 = e(var1);
                        boolean var84 = g(var1);

                        try {
                           ((thien_ac)(var142 = thien_y.a(var174, var81, var235, var83, var234))).o = var84;
                        } catch (Exception var113) {
                        }
                        break;
                     case 10:
                        int var85 = e(var1);
                        int var86 = e(var1);
                        int var87 = e(var1);
                        int[] var88 = new int[var85];
                        int[] var89 = new int[var85];
                        String[] var90 = new String[var85];

                        for (int var91 = 0; var91 < var85; var91++) {
                           var90[var91] = i(var1);
                           var88[var91] = e(var1);
                           var89[var91] = e(var1);
                        }

                        boolean var236 = g(var1);
                        thien_af var110 = new thien_af(
                           0, thien_an.d + 7, thien_an.e - 3, thien_an.f - 3 - thien_di.g, var85, var90, var88, var89, var86, var87, false, 1
                        );
                        var174.a(var110);
                        var174.c(var110);
                        thien_ab var112 = new thien_ab(thien_as.P(), new thien_q(var236, var110, var1));
                        var110.y = var112;
                        break;
                     case 12:
                        int var231 = e(var1);
                        byte[] var77 = c(var1);
                        thien_ag var78 = null;

                        try {
                           var78 = thien_y.a(var174, var77, var231);
                           byte[] var79 = c(var1);
                           var78.b = new thien_p(var79);
                        } catch (Exception var114) {
                        }

                        var142 = var78;
                        break;
                     case 13:
                        String var162 = a(var1);
                        e(var1);
                        var142 = thien_y.a(var174, var162, (thien_ae)null);
                        break;
                     case 41:
                        int var99 = e(var1);
                        int var100 = e(var1);
                        int var101 = e(var1);
                        ((thien_z)thien_di.c.d(var99).c(var100)).c(var101);
                  }

                  var161 = e(var1);
                  ((thien_ac)var142).u = var161;
                  if (((thien_ac)var142).u > 1000 && var142 instanceof thien_at) {
                     ((thien_at)var142).d = true;
                  }
                  break;
               case 7:
                  int var141 = e(var1);
                  thien_an var64 = thien_di.c.d(var141);
                  int var65 = e(var1);
                  thien_ac var66 = var64.c(var65);
                  var64.c(var66);
                  if (var64.equals(thien_di.c.u())) {
                     var64.d();
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
                  byte var70 = var1.b().a();
                  Vector var71 = new Vector();
                  int var72 = e(var1);

                  for (int var73 = 0; var73 < var72; var73++) {
                     String var74 = a(var1);
                     byte[] var75 = c(var1);
                     thien_ab var76 = new thien_ab(var74, new thien_h(var75));
                     var71.addElement(var76);
                  }

                  thien_am var230 = new thien_am(var71);
                  thien_di.c.a(var230, var70);
                  break;
               case 12:
                  int var204 = e(var1);
                  thien_ap var211 = (thien_ap)thien_di.c.d(var204);
                  int var217;
                  String[] var140 = new String[var217 = e(var1)];

                  for (int var160 = 0; var160 < var217; var160++) {
                     var140[var160] = a(var1);
                  }

                  var211.a(var140);
                  break;
               case 13:
                  int var67 = e(var1);
                  thien_ap var68 = (thien_ap)thien_di.c.d(var67);
                  int var69 = e(var1);
                  var68.d(var69);
                  break;
               case 14:
                  byte var135 = var1.b().a();
                  String var159 = "";
                  if (var135 == 0) {
                     var159 = i(var1);
                  } else {
                     int var136 = e(var1);
                     thien_an var173 = thien_di.c.d(var136);
                     int var137 = e(var1);
                     boolean var179 = g(var1);
                     thien_ac var138;
                     if ((var138 = var173.c(var137)) instanceof thien_at) {
                        var159 = ((thien_at)var138).c();
                        if (var179 && var159.equals("")) {
                           var173.c(var138);
                           return;
                        }
                     }
                  }

                  String var139 = i(var1);
                  thien_di.c.a("Gửi tin nhắn: " + var159 + Xuka.f + " => " + var139.substring(6), new thien_l(var159, var139));
                  break;
               case 15:
                  try {
                     Xuka.g.platformRequest(i(var1));
                  } catch (ConnectionNotFoundException var118) {
                  }
                  break;
               case 16:
                  thien_di.c.d(e(var1)).c(e(var1)).q = e(var1);
                  break;
               case 17:
                  thien_an var133;
                  thien_ac var158 = (var133 = thien_di.c.d(e(var1))).c(e(var1));
                  thien_ac var134 = var133.c(e(var1));
                  var158.q = var134.q + var134.s + 10;
                  break;
               case 18:
                  thien_ap var132;
                  thien_ac var157;
                  (var157 = (var132 = (thien_ap)thien_di.c.d(e(var1))).c(e(var1))).r = e(var1);
                  var132.x = var157.r + var157.t + 2;
                  break;
               case 19:
                  thien_ap var131;
                  thien_ac var156 = (var131 = (thien_ap)thien_di.c.d(e(var1))).c(e(var1));
                  thien_ac var172 = var131.c(e(var1));
                  var156.r = var172.r + var172.t + 2;
                  var131.x = var156.r + var156.t + 2;
                  break;
               case 20:
                  thien_ap var130;
                  thien_ac var155 = (var130 = (thien_ap)thien_di.c.d(e(var1))).c(e(var1));
                  thien_ac var171 = var130.c(e(var1));
                  var155.r = var171.r;
                  var130.x = var155.r + var155.t + 2;
                  break;
               case 21:
                  String var129 = i(var1);
                  thien_hb var154 = new thien_hb(0, 0);
                  a(0, var154);
                  a(var129, var154);
                  b(var154.b().b());
                  break;
               case 22:
                  thien_di.c.c(thien_di.c.c(i(var1)));
                  break;
               case 23:
                  thien_di.c.c();
                  break;
               case 24:
                  int var128 = e(var1);
                  int var153 = e(var1);
                  String var170 = i(var1);

                  try {
                     ((thien_at)thien_di.c.d(var128).c(var153)).a(var170);
                  } catch (Exception var119) {
                  }
                  break;
               case 25:
                  String var127 = i(var1);
                  thien_di.c.j.b(var127);
                  break;
               case 26:
                  String var125 = i(var1);
                  thien_ew var126 = thien_di.b().e(var125);
                  thien_di.b().d(var126.g);
                  break;
               case 28:
                  if (thien_di.c.n.size() > 0 && ((thien_ad)thien_di.c.n.elementAt(0)).d) {
                     thien_di.c.c();
                  }

                  thien_di.c.b(i(var1));
                  break;
               case 29:
                  String var124 = i(var1);
                  String var151 = i(var1);
                  byte[] var168 = c(var1);
                  String var177 = i(var1);
                  byte[] var185 = c(var1);
                  String var187 = i(var1);
                  byte[] var193 = c(var1);
                  thien_ab var152 = new thien_ab(var151, new thien_f(var168));
                  thien_ab var169 = new thien_ab(var177, new thien_j(var185));
                  thien_ab var178 = new thien_ab(var187, new thien_k(var193));
                  if (thien_di.c.n.size() > 0 && ((thien_ad)thien_di.c.n.elementAt(0)).d) {
                     thien_di.c.c();
                  }

                  thien_di.c.a(var124, var152, var169, var178);
                  break;
               case 35:
                  int var3 = e(var1);
                  int var4 = e(var1);
                  thien_hb var5 = new thien_hb(var3, var4);
                  var4 = e(var1);

                  for (int var6 = 0; var6 < var4; var6++) {
                     byte var7 = var1.b().a();
                     byte var8 = var1.b().a();
                     if (var7 == 0) {
                        if (var8 == 0) {
                           a(e(var1), var5);
                        } else if (var8 == 1) {
                           int var9 = e(var1);
                           thien_an var10 = thien_di.c.d(var9);
                           int var11 = e(var1);
                           thien_ac var121 = var10.c(var11);
                           boolean var148 = g(var1);
                           var3 = 0;
                           if (var121 instanceof thien_at) {
                              String var192 = ((thien_at)var121).c();
                              if (var148 && var192.equals("")) {
                                 var10.c(var121);
                                 return;
                              }

                              try {
                                 var3 = Integer.parseInt(var192);
                              } catch (Exception var116) {
                                 var10.c(var121);
                                 return;
                              }
                           } else if (var121 instanceof thien_z) {
                              var3 = ((thien_z)var121).a();
                           } else if (var121 instanceof thien_af) {
                              var3 = ((thien_af)var121).a();
                           }

                           a(var3, var5);
                        }
                     } else if (var7 == 1) {
                        if (var8 == 0) {
                           a(a(var1), var5);
                        } else if (var8 == 1) {
                           int var202 = e(var1);
                           thien_an var209 = thien_di.c.d(var202);
                           int var215 = e(var1);
                           boolean var122 = g(var1);
                           thien_ac var149;
                           if ((var149 = var209.c(var215)) instanceof thien_at) {
                              String var167 = ((thien_at)var149).c();
                              if (var122 && var167.equals("")) {
                                 var209.c(var149);
                                 return;
                              }

                              a(var167, var5);
                           } else if (var149 instanceof thien_z) {
                              a(((thien_z)var149).b(), var5);
                           }
                        }
                     } else if (var7 == 2) {
                        if (var8 == 0) {
                           a(g(var1), var5);
                        } else if (var8 == 1) {
                           int var203 = e(var1);
                           thien_an var210 = thien_di.c.d(var203);
                           int var216 = e(var1);
                           thien_ac var123;
                           if ((var123 = var210.c(var216)) instanceof thien_x) {
                              boolean var150 = ((thien_x)var123).a;
                              a(((thien_x)var123).a, var5);
                           }
                        }
                     }
                  }

                  thien_hc.a(var5);
                  break;
               case 39:
                  a(c(var1));
                  break;
               case 40:
                  String var120 = i(var1);
                  byte var2 = var1.b().a();
                  thien_di.c.j.a(var120, var2);
            }
         }
      }
   }

   private static thien_ab j(thien_hb var0) {
      byte[] var1 = c(var0);
      return new thien_ab(a(var0), new thien_i(var1));
   }

   public static void a(String var0) {
      thien_hb var1 = new thien_hb(6000000, 48);
      a(var0, var1);
      thien_hc.a(var1);
   }

   public static void a() {
      thien_hc.a(new thien_hb(5000009, 39));
   }

   public static void b(String var0) {
      thien_hb var1 = new thien_hb(thien_di.a ? 5000011 : 3402, 39);
      a(var0, var1);
      thien_hc.a(var1);
   }

   public static void c(String var0) {
      thien_hb var1 = new thien_hb(5023, 2);
      a(var0, var1);
      thien_hc.a(var1);
   }

   public static void a(int var0) {
      thien_hb var1 = new thien_hb(var0, var0 == 5000008 ? 8 : 2);
      if (var0 == 5000008) {
         a("", var1);
      } else if (var0 == 321) {
         a(thien_ff.y, var1);
      }

      thien_hc.a(var1);
   }

   public static void a(int var0, String var1, long var2) {
      thien_hb var4 = new thien_hb();
      if (var0 == 3) {
         var4 = new thien_hb(4514, 45);
      }

      a(var1, var4);
      a(var2, var4);
      thien_hc.a(var4);
   }

   public static void a(String var0, String var1) {
      thien_hb var2 = new thien_hb(3403, 39);
      a(var0, var2);
      a(var1, var2);
      thien_hc.a(var2);
   }

   public static void d(String var0) {
      thien_hb var1 = new thien_hb(3404, 39);
      a(var0, var1);
      thien_hc.a(var1);
   }

   public static void b(String var0, String var1) {
      thien_hb var2 = new thien_hb(3405, 39);
      a(var0, var2);
      a(var1, var2);
      thien_hc.a(var2);
   }

   public static void c(String var0, String var1) {
      thien_hb var2 = new thien_hb(3406, 39);
      a(var0, var2);
      a(var1, var2);
      thien_hc.a(var2);
   }

   public static void d(String var0, String var1) {
      thien_hb var2 = new thien_hb(3407, 39);
      a(var0, var2);
      a(var1, var2);
      thien_hc.a(var2);
   }

   public static void a(String var0, String var1, int var2, byte[] var3) {
      thien_hb var4 = new thien_hb(3408, 39);
      a(var0, var4);
      a(var1, var4);
      a(var2, var4);
      int var7;
      a(var7 = var3.length, var4);

      for (int var8 = 0; var8 < var7; var8++) {
         byte var9 = var3[var8];
         var4.b().a(1);
         var4.b().a(var9);
      }

      thien_hc.a(var4);
   }

   public static void a(String var0, String var1, String var2) {
      thien_hb var3 = new thien_hb(3412, 39);
      a(var0, var3);
      a(var1, var3);
      a(var2, var3);
      thien_hc.a(var3);
   }

   public static void a(int var0, String var1, String var2, boolean var3) {
      thien_hb var4 = new thien_hb();
      if (var0 == 1) {
         var4 = new thien_hb(3409, 39);
      } else if (var0 == 3) {
         var4 = new thien_hb(4512, 45);
      }

      a(var1, var4);
      if (var0 == 1) {
         a(var2, var4);
      }

      a(var3, var4);
      thien_hc.a(var4);
   }

   public static void a(int var0, String var1, String var2, String var3) {
      thien_hb var4 = new thien_hb();
      if (var0 == 1) {
         var4 = new thien_hb(3411, 39);
      } else if (var0 == 3) {
         var4 = new thien_hb(4515, 45);
      }

      a(var1, var4);
      if (var0 == 1 || var0 == 42) {
         a(var2, var4);
      }

      a(var3, var4);
      thien_hc.a(var4);
   }

   public static void a(int var0, String var1) {
      thien_hb var2 = new thien_hb();
      if (var0 == 1) {
         var2 = new thien_hb(314, 39);
      } else if (var0 == 3) {
         var2 = new thien_hb(4504, 45);
      }

      a(var1, var2);
      thien_hc.a(var2);
   }

   public static void a(int var0, int var1, String var2) {
      thien_hb var3 = new thien_hb();
      if (var0 == 1) {
         var3 = new thien_hb(302, 39);
         a(0, var3);
      } else if (var0 == 3) {
         var3 = new thien_hb(4502, 45);
      }

      a(var2, var3);
      thien_hc.a(var3);
   }

   public static void a(int var0, String var1, String var2, long var3) {
      thien_hb var5 = new thien_hb();
      if (var0 == 1) {
         var5 = new thien_hb(3410, 39);
      }

      a(var1, var5);
      a(var2, var5);
      a(var3, var5);
      thien_hc.a(var5);
   }

   public static void b() {
      thien_hb var0 = new thien_hb(324, 13);
      a(Xuka.d, var0);
      a(Xuka.e, var0);
      thien_hc.a(var0);
      var0 = new thien_hb(5030, 2);
      a(1, var0);
      thien_hc.a(var0);
   }

   public static void a(String var0, String var1, int var2) {
      thien_hb var3 = new thien_hb(27, var2 == 2 ? 7 : 2);
      a(var0, var3);
      a(var1, var3);
      thien_hc.a(var3);
   }

   public static void b(String var0, String var1, int var2) {
      thien_hb var3 = new thien_hb(1009, 1002);
      a(var0, var3);
      a(var1, var3);
      thien_hc.a(var3);
   }

   public static void a(boolean var0, String var1, String var2) {
      thien_hb var3 = new thien_hb(1010, 1001);
      a(var0, var3);
      a(var2, var3);
      a(var1, var3);
      thien_hc.a(var3);
   }

   public static void e(String var0, String var1) {
      thien_hb var2 = new thien_hb(5000010, 13);
      a(thien_hj.a(var0), var2);
      a(thien_hj.a(var1), var2);
      a(Xuka.d, var2);
      a(Xuka.e, var2);
      thien_hc.a(var2);
   }

   public static void a(int var0, int var1) {
      thien_hb var2 = new thien_hb(var1 == 1 ? 15 : 5000016, var1 == 1 ? 2 : 20);
      a(var0, var2);
      thien_hc.a(var2);
   }

   public static void a(String var0, int var1) {
      thien_hb var2 = new thien_hb(8, var1 == 1 ? 2 : 20);
      if (var1 == 2) {
         thien_gp.A = var0;
         Xuka.a(thien_gp.x, var0, true);
      }

      a(var0, var2);
      thien_hc.a(var2);
   }

   public static void a(String var0, String var1, int var2, int var3, int var4) {
      thien_hb var6;
      if (var3 == 1) {
         thien_hb var5 = new thien_hb(1016, 13);
         if (thien_as.a == 1) {
            a(2, var5);
         } else {
            a(thien_as.a, var5);
         }

         thien_hc.a(var5);
         var6 = new thien_hb(5000007, 13);
      } else {
         var6 = new thien_hb(61, 20);
      }

      a(thien_hj.a(var0), var6);
      a(thien_hj.a(var1), var6);
      a(var2, var6);
      a("", var6);
      a(var4, var6);
      thien_hc.a(var6);
   }

   public static void a(String var0, String var1, String var2, int var3) {
      thien_hb var4;
      if (var3 == 1) {
         var4 = new thien_hb(3, 2);
      } else {
         var4 = new thien_hb(3, 20);
      }

      a(var0, var4);
      a(var1, var4);
      a(var2, var4);
      thien_hc.a(var4);
   }

   public static void e(String var0) {
      thien_hb var1 = new thien_hb(13, 2);
      a(var0, var1);
      thien_hc.a(var1);
   }

   public static void f(String var0) {
      thien_hb var1 = new thien_hb(1020, 1002);
      a(var0, var1);
      thien_hc.a(var1);
   }

   public static void g(String var0) {
      thien_hb var1 = new thien_hb(1000, 1000);
      a(var0, var1);
      a(false, var1);
      a("", var1);
      thien_hc.a(var1);
   }

   public static void a(String var0, String[] var1) {
      thien_hb var2 = new thien_hb(1002, 1000);
      a(var0, var2);
      a(var1.length, var2);

      for (int var3 = 0; var3 < var1.length; var3++) {
         a(var1[var3], var2);
      }

      thien_hc.a(var2);
   }

   public static void h(String var0) {
      thien_hb var1 = new thien_hb(1008, 1000);
      a(var0, var1);
      thien_hc.a(var1);
   }

   public static void a(String var0, boolean var1, String var2, String var3) {
      thien_hb var4 = new thien_hb(1003, 1000);
      a(var0, var4);
      a(var1, var4);
      a(var2, var4);
      a(var3, var4);
      thien_hc.a(var4);
   }

   public static void f(String var0, String var1) {
      thien_hb var2 = new thien_hb(1005, 1000);
      a(var0, var2);
      a(var1, var2);
      thien_hc.a(var2);
   }

   public static void i(String var0) {
      thien_hb var1 = new thien_hb(37, 10);
      a(var0, var1);
      thien_hc.a(var1);
   }

   public static void b(String var0, int var1) {
      thien_hb var2 = new thien_hb(28, 20);
      a(var0, var2);
      thien_hc.a(var2);
   }

   public static void g(String var0, String var1) {
      thien_hb var2 = new thien_hb(1021, 1002);
      a(var0, var2);
      a(var1, var2);
      thien_hc.a(var2);
   }

   public static void h(String var0, String var1) {
      thien_hb var2 = new thien_hb(1022, 1002);
      a(var0, var2);
      a(var1, var2);
      thien_hc.a(var2);
   }

   public static void c() {
      if (thien_es.a != null) {
         thien_hb var0 = new thien_hb(50, 2);
         a(thien_es.a, var0);
         thien_hc.a(var0);
      }
   }

   public static void b(String var0, String var1, String var2) {
      thien_hb var3 = new thien_hb(51, 2);
      a(var0, var3);
      a(var1, var3);
      a(var2, var3);
      thien_hc.a(var3);
   }

   public static void i(String var0, String var1) {
      thien_hb var2 = new thien_hb(62, 2);
      a(var0, var2);
      a(var1, var2);
      thien_hc.a(var2);
   }

   public static void d() {
      thien_hc.a(new thien_hb(63, 2));
   }

   public static void j(String var0, String var1) {
      thien_hb var2 = new thien_hb(79, 2);
      a(var0, var2);
      a(var1, var2);
      thien_hc.a(var2);
   }

   public static void c(String var0, String var1, int var2) {
      thien_hb var3 = new thien_hb(78, 20);
      a(var0, var3);
      a(var1, var3);
      a(var2, var3);
      thien_hc.a(var3);
   }

   public static void a(int var0, String var1, int var2, String var3) {
      thien_hb var4 = new thien_hb(88, 21);
      a(0, var4);
      a(var1, var4);
      a(var2, var4);
      a(var3, var4);
      thien_hc.a(var4);
   }

   public static void b(byte[] var0) {
      thien_hb var1 = new thien_hb(115, 2);
      int var2 = var0.length;
      boolean var5 = false;
      var1.b().a(var2 + 4);
      b(var2, var1);
      var1.b().a(var0, 0, var2);
      thien_hc.a(var1);
   }

   public static void b(int var0) {
      thien_hb var1 = new thien_hb(119, 2);
      a(var0, var1);
      thien_hc.a(var1);
   }

   public static int c(int var0) {
      return var0 != 0 && var0 != 0 ? var0 : 16777215;
   }

   public static short b(thien_hb var0) {
      short var1 = 0;

      for (int var2 = 0; var2 < 2; var2++) {
         short var3;
         var1 = (short)((var3 = (short)(var1 << 8)) | 255 & var0.b().a());
      }

      return var1;
   }

   public static byte[] c(thien_hb var0) {
      int var1 = e(var0);
      return var0.b().b(var1);
   }

   public static long d(thien_hb var0) {
      long var1 = 0L;

      for (int var3 = 0; var3 < 8; var3++) {
         long var4;
         var1 = (var4 = var1 << 8) | (long)(255 & var0.b().a());
      }

      return var1;
   }

   public static int e(thien_hb var0) {
      int var1 = 0;

      for (int var2 = 0; var2 < 4; var2++) {
         int var3;
         var1 = (var3 = var1 << 8) | 255 & var0.b().a();
      }

      return var1;
   }

   public static thien_hg f(thien_hb var0) {
      int var1 = e(var0);
      int var2 = e(var0);
      int var3 = e(var0);
      int var4 = e(var0);
      int var5 = e(var0);
      int var6 = e(var0);
      int var7 = e(var0);
      return new thien_hg(var1, var2, var3, var4, var5, var6, var7);
   }

   public static boolean g(thien_hb var0) {
      return var0.b().a() == 1;
   }

   public static char h(thien_hb var0) {
      return (char)b(var0);
   }

   public static String i(thien_hb var0) {
      int var1 = e(var0);
      StringBuffer var2 = new StringBuffer(var1);

      for (int var3 = 0; var3 < var1; var3++) {
         var2.append(h(var0));
      }

      return var2.toString();
   }

   private static void b(int var0, thien_hb var1) {
      for (int var2 = 3; var2 >= 0; var2--) {
         var1.b().a((byte)(var0 >> (var2 << 3)));
      }
   }

   public static void a(boolean var0, thien_hb var1) {
      var1.b().a(1);
      if (var0) {
         var1.b().a((byte)1);
      } else {
         var1.b().a((byte)0);
      }
   }

   public static void a(int var0, thien_hb var1) {
      var1.b().a(4);

      for (int var2 = 3; var2 >= 0; var2--) {
         var1.b().a((byte)(var0 >> (var2 << 3)));
      }
   }

   public static void a(long var0, thien_hb var2) {
      var2.b().a(8);

      for (int var3 = 7; var3 >= 0; var3--) {
         var2.b().a((byte)((int)(var0 >> (var3 << 3))));
      }
   }

   public static void a(String var0, thien_hb var1) {
      thien_ha var2 = var1.b();
      int var3 = var0.length();
      var2.a(4 + 2 * var3);
      b(var3, var1);

      for (int var7 = 0; var7 < var3; var7++) {
         short var10000 = (short)var0.charAt(var7);
         thien_hb var5 = var1;
         short var4 = var10000;

         for (int var6 = 1; var6 >= 0; var6--) {
            var5.b().a((byte)(var4 >> (var6 << 3)));
         }
      }
   }
}
