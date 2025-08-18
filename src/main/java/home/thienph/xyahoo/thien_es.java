package home.thienph.xyahoo;

import java.util.Vector;
import javax.microedition.lcdui.Image;

public final class thien_es extends thien_hh {
   private static thien_et b;
   private static thien_es c = null;
   public static String a;

   private thien_es() {
   }

   public static thien_es a() {
      if (c == null) {
         c = new thien_es();
      }

      return c;
   }

   public static void a(thien_et var0) {
      b = var0;
   }

   public final void b() {
      b.p();
   }

   public final void c() {
      b.q();
   }

   public final void d() {
   }

   public final void a(Packet var1, int var2) {
      int var3 = var1.getType();
      switch (var2) {
         case -6:
            int var245;
            String[] var257 = new String[var245 = MessageHandler.readInt(var1)];
            int[] var39 = new int[var245];

            for (int var259 = 0; var259 < var245; var259++) {
               var257[var259] = MessageHandler.readString(var1);
               var39[var259] = MessageHandler.readInt(var1);
            }

            b.a(var257, var39);
            return;
         case -5:
            b.z();
            return;
         case -3:
            b.m();
            return;
         case -2:
            b.n();
            return;
         case -1:
            b.o();
            return;
         case 3:
            String var207 = MessageHandler.readString(var1);
            MessageHandler.readString(var1);
            String var192 = MessageHandler.readString(var1);
            b.a(var207, var192);
            return;
         case 8:
            String var206 = MessageHandler.readString(var1);
            String var191 = MessageHandler.readString(var1);
            b.a(var206, var191, 1);
            return;
         case 9:
            var2 = MessageHandler.readInt(var1);

            for (int var218 = 0; var218 < var2; var218++) {
               String var226 = MessageHandler.readString(var1);
               String var236 = MessageHandler.readString(var1);
               String var244 = MessageHandler.readString(var1);
               b.b(var226, var236, var244);
            }

            return;
         case 15:
            String var204 = MessageHandler.readString(var1);
            int var190 = MessageHandler.readInt(var1);
            b.a(var204, var190, 1);
            return;
         case 27:
            String var217 = MessageHandler.readString(var1);
            MessageHandler.readString(var1);
            b.j(var217);
            return;
         case 37:
            String var235 = MessageHandler.readString(var1);
            String var243 = MessageHandler.readString(var1);
            b.g(var235, var243);
            return;
         case 39:
            String var203 = MessageHandler.readString(var1);
            int var189;
            if ((var189 = MessageHandler.readInt(var1)) == 0) {
               b.a(0, var203, null, 20L, 20L, null);
               return;
            }

            if (var189 == 1) {
               b.f(var203);
               return;
            }
            break;
         case 44:
            a = MessageHandler.readString(var1);
            return;
         case 45:
            String var202 = MessageHandler.readString(var1);
            String var216 = MessageHandler.readString(var1);
            String var225 = "";
            if (thien_di.a) {
               var225 = MessageHandler.readString(var1);
            }

            b.e(var225, var202, var216);
            return;
         case 49:
            String var201 = MessageHandler.readString(var1);
            MessageHandler.readInt(var1);
            byte var215 = var1.getPayload().readByte();
            String var224 = MessageHandler.readString(var1);
            int var234 = MessageHandler.readInt(var1);
            int var242 = MessageHandler.readInt(var1);
            var1.getPayload().readByte();
            var1.getPayload().readByte();
            var1.getPayload().readByte();
            var1.getPayload().readByte();
            MessageHandler.readInt(var1);
            MessageHandler.readInt(var1);
            b.a(var201, var215, var224, var234, var242);
            return;
         case 63:
            var3 = MessageHandler.readInt(var1);
            Vector var223 = new Vector();

            for (int var233 = 0; var233 < var3; var233++) {
               String var241 = MessageHandler.readString(var1);
               var223.addElement(var241);
            }

            thien_di.t = var223;
            return;
         case 64:
            boolean var232 = MessageHandler.readBool(var1);
            b.b(var232);
            return;
         case 113:
            int var258;
            thien_fe.a = new String[var258 = MessageHandler.readInt(var1)];

            for (int var260 = 0; var260 < var258; var260++) {
               thien_fe.a[var260] = MessageHandler.readString(var1);
            }

            return;
         case 116:
            System.gc();
            byte[] var41 = MessageHandler.readByteArray(var1);
            b.a(var41);
            return;
         case 117:
            var2 = MessageHandler.readInt(var1);

            for (int var213 = 0; var213 < var2; var213++) {
               int var222 = MessageHandler.readInt(var1);
               String var231 = MessageHandler.readString(var1);
               byte[] var240 = MessageHandler.readByteArray(var1);
               MessageHandler.readUserInfo(var1);
               MessageHandler.readUserInfo(var1);
               long var38 = MessageHandler.readLong(var1);
               long var40 = MessageHandler.readLong(var1);
               String var252 = MessageHandler.readString(var1);
               b.a(var222, var231, var240, var40, var38, var252);
            }

            return;
         case 120:
            var2 = MessageHandler.readInt(var1);
            byte[] var188 = MessageHandler.readByteArray(var1);
            b.a(var2, var188);
            return;
         case 121:
            System.gc();
            byte[] var251 = MessageHandler.readByteArray(var1);
            b.a(var251);
            return;
         case 122:
            var2 = MessageHandler.readInt(var1);
            int var187 = MessageHandler.readInt(var1);
            b.b(var2, var187);
            return;
         case 123:
            var2 = MessageHandler.readInt(var1);
            var3 = MessageHandler.readInt(var1);
            byte[] var186 = MessageHandler.readByteArray(var1);
            b.a(var2, var3, var186);
            return;
         case 269:
            String var254 = MessageHandler.readString(var1);
            String var256 = MessageHandler.readString(var1);
            b.h(var254, var256);
            return;
         case 317:
            int var239;
            String[] var250 = new String[var239 = MessageHandler.readInt(var1)];

            for (int var253 = 0; var253 < var239; var253++) {
               var250[var253] = MessageHandler.readString(var1);
            }

            b.b(var250);
            return;
         case 1001:
            String var304 = MessageHandler.readString(var1);
            String var164 = MessageHandler.readString(var1);
            if (!var304.equals("")) {
               b.c(var304, var164);
               return;
            }

            b.r();
            return;
         case 1004:
            String var168 = MessageHandler.readString(var1);
            String var169 = MessageHandler.readString(var1);
            int var170;
            if ((var170 = MessageHandler.readInt(var1)) == 0) {
               b.e(var169, var168);
               return;
            }

            if (var170 == 1) {
               b.d(var169, var168);
               return;
            }

            if (var170 == 2) {
               b.f(var169, var168);
               return;
            }
            break;
         case 1005:
            String var305 = MessageHandler.readString(var1);
            String var175 = MessageHandler.readString(var1);
            String var176 = MessageHandler.readString(var1);
            b.d(var175, var305, var176);
            return;
         case 1006:
            String var165 = MessageHandler.readString(var1);
            String var166 = MessageHandler.readString(var1);
            String var167 = MessageHandler.readString(var1);
            b.c(var167, var165, var166);
            return;
         case 1007:
            String var171 = MessageHandler.readString(var1);
            int var172;
            String[] var173 = new String[var172 = MessageHandler.readInt(var1)];

            for (byte var174 = 0; var174 < var172; var174 += 1) {
               var173[var174] = MessageHandler.readString(var1);
            }

            b.a(var171, var173);
            return;
         case 1009:
            String var132 = MessageHandler.readString(var1);
            b.k(var132);
            return;
         case 1010:
            boolean var122 = MessageHandler.readBool(var1);
            String var123 = MessageHandler.readString(var1);
            if (var122) {
               String var294 = MessageHandler.readString(var1);
               int var295 = MessageHandler.readInt(var1);
               String var296 = MessageHandler.readString(var1);
               int var185 = MessageHandler.readInt(var1);
               b.a(var123, var295, var296, var294, var185);
               return;
            }

            b.h(var123);
            return;
         case 1017:
            int var124 = MessageHandler.readInt(var1);
            String var125 = MessageHandler.readString(var1);
            String var126 = MessageHandler.readString(var1);
            byte var127;
            int[] var128 = new int[var127 = var1.getPayload().readByte()];

            for (byte var129 = 0; var129 < var127; var129 += 1) {
               var128[var129] = MessageHandler.readInt(var1);
            }

            int var297 = MessageHandler.readInt(var1);
            thien_r var130 = new thien_r(var125, "", 0, "", var128, 0, var297);
            var1.getPayload().readByte();
            MessageHandler.readString(var1);
            var130.a(MessageHandler.readInt(var1));
            var130.i = MessageHandler.readInt(var1);
            var1.getPayload().readByte();
            var1.getPayload().readByte();
            var1.getPayload().readByte();
            var1.getPayload().readByte();
            MessageHandler.readInt(var1);
            MessageHandler.readInt(var1);
            b.a(var124, var130, var126);
            return;
         case 1020:
            int var120 = MessageHandler.readInt(var1);
            String var121 = MessageHandler.readString(var1);
            b.a(var121, var120);
            return;
         case 1021:
            int var293 = MessageHandler.readInt(var1);
            String var118 = MessageHandler.readString(var1);
            String var119 = MessageHandler.readString(var1);
            b.a(var293, var118, var119);
            return;
         case 1022:
            int var290 = MessageHandler.readInt(var1);
            String var291 = MessageHandler.readString(var1);
            String var292 = MessageHandler.readString(var1);
            b.b(var290, var291, var292);
            return;
         case 1023:
            String var133 = MessageHandler.readString(var1);
            int var134;
            int[] var135 = new int[var134 = MessageHandler.readInt(var1)];

            for (byte var298 = 0; var298 < var134; var298 += 1) {
               var135[var298] = MessageHandler.readInt(var1);
            }

            b.a(var133, var135);
            return;
         case 1029:
            String var131 = MessageHandler.readString(var1);
            b.g(var131);
            return;
         case 1045:
            int var151 = MessageHandler.readInt(var1);
            thien_s var152 = new thien_s();
            int var153;
            thien_r[] var154 = new thien_r[var153 = MessageHandler.readInt(var1)];
            String[] var155 = new String[var153];
            Vector var156 = new Vector();

            for (byte var300 = 0; var300 < var153; var300 += 1) {
               var155[var300] = MessageHandler.readString(var1);
               String var301 = MessageHandler.readString(var1);
               short var303 = MessageHandler.readShort(var1);
               var154[var300] = new thien_r(var301, "", 0, "", new int[0], var303, var300);
               if (var154[var300].g == 8 || var154[var300].g == 4) {
                  var152.a(var155[var300], var154[var300]);
               } else if (var154[var300].g == 32) {
                  var156.addElement(var154[var300]);
               }
            }

            b.a(var152, var151);
            return;
         case 1046:
            String var136 = MessageHandler.readString(var1);
            String var137 = MessageHandler.readString(var1);
            byte var138;
            int[] var139 = new int[var138 = var1.getPayload().readByte()];

            for (byte var140 = 0; var140 < var138; var140 += 1) {
               var139[var140] = MessageHandler.readInt(var1);
            }

            byte var299 = var1.getPayload().readByte();
            String var141 = MessageHandler.readString(var1);
            int var142 = MessageHandler.readInt(var1);
            byte var143 = var1.getPayload().readByte();
            byte var144 = var1.getPayload().readByte();
            byte var145 = var1.getPayload().readByte();
            byte var146 = var1.getPayload().readByte();
            int var147 = MessageHandler.readInt(var1);
            int var148 = MessageHandler.readInt(var1);
            byte var149 = var1.getPayload().readByte();
            String var150 = "";
            if (var149 == 2) {
               var150 = MessageHandler.readString(var1);
            }

            b.a(var136, var137, var139, var299, var141, var142, var143, var144, var145, var146, var147, var148, var150, var149);
            return;
         case 1047:
            int var157;
            String[] var158 = new String[var157 = MessageHandler.readInt(var1)];

            for (byte var302 = 0; var302 < var157; var302 += 1) {
               var158[var302] = MessageHandler.readString(var1);
            }

            b.a(var158, null, null);
            return;
         case 1048:
            int var159;
            String[] var160 = new String[var159 = MessageHandler.readInt(var1)];
            int[] var161 = new int[var159];
            String[] var162 = new String[var159];

            for (byte var163 = 0; var163 < var159; var163 += 1) {
               var160[var163] = MessageHandler.readString(var1);
               var161[var163] = MessageHandler.readInt(var1);
               var162[var163] = MessageHandler.readString(var1);
            }

            b.a(var160, var161, var162);
            return;
         case 3402:
         case 5000011:
            String var211 = MessageHandler.readString(var1);
            String var196;
            if (var2 == 3402) {
               var196 = "TL";
               MessageHandler.readInt(var1);
            } else {
               var196 = MessageHandler.readString(var1);
            }

            int var221;
            thien_aw[] var230 = new thien_aw[var221 = MessageHandler.readInt(var1)];

            for (int var238 = 0; var238 < var221; var238++) {
               var230[var238] = new thien_aw();
               var230[var238].a = MessageHandler.readString(var1);
               var230[var238].b = var1.getPayload().readByte();
               thien_aw var10000 = var230[var238];
               long var306 = MessageHandler.readLong(var1);
               var10000.c = var306 + "$";
               var230[var238].a((byte) MessageHandler.readInt(var1));
            }

            b.a(var211, var230, 1, var196);
            return;
         case 3403:
            String var237 = MessageHandler.readString(var1);
            if (!MessageHandler.readBool(var1)) {
               b(var1);
               return;
            }

            MessageHandler.readString(var1);
            String var195 = MessageHandler.readString(var1);
            long var57 = MessageHandler.readLong(var1);
            String[] var220 = new String[var3 = MessageHandler.readInt(var1)];
            long[] var229 = new long[var3];
            int[] var249 = new int[var3];
            boolean[] var262 = new boolean[var3];

            for (int var264 = 0; var264 < var3; var264++) {
               var220[var264] = MessageHandler.readString(var1);
               var262[var264] = MessageHandler.readBool(var1);
               var229[var264] = MessageHandler.readLong(var1);
               var249[var264] = MessageHandler.readInt(var1);
               if (var249[var264] != -1) {
                  var249[var264] = (short)var249[var264];
               }
            }

            thien_ba.B = var237;
            thien_ba.S.C = var57;
            thien_ba.S.R = MessageHandler.readBool(var1);
            thien_ba var178 = thien_ba.S;
            String var307 = MessageHandler.readString(var1);
            String var309 = MessageHandler.readString(var1);
            var178.a(var307 + " - " + var309);
            String[] var265 = new String[var3];
            int[] var266 = new int[var3];
            Integer[] var267 = new Integer[var3];

            for (int var268 = 0; var268 < var3; var268++) {
               var265[var268] = MessageHandler.readString(var1);
               var266[var268] = MessageHandler.readInt(var1);
               var267[var268] = new Integer(MessageHandler.readInt(var1));
            }

            b.a(var237, var57, var220, var229, var249, var262, var195, var265, var266, var267);
            return;
         case 3405:
            MessageHandler.readString(var1);
            if (MessageHandler.readBool(var1)) {
               String[] var219 = new String[var3 = MessageHandler.readInt(var1)];
               boolean[] var228 = new boolean[var3];

               for (int var248 = 0; var248 < var3; var248++) {
                  var219[var248] = MessageHandler.readString(var1);
                  var228[var248] = MessageHandler.readBool(var1);
               }

               b.a(var219, var228);
               return;
            }
            break;
         case 3406:
            MessageHandler.readString(var1);
            if (MessageHandler.readBool(var1)) {
               MessageHandler.readString(var1);
               byte[] var247 = MessageHandler.readByteArray(var1);
               String var261 = MessageHandler.readString(var1);
               boolean var263 = MessageHandler.readBool(var1);
               MessageHandler.readLong(var1);
               b.a(var247, var261, var263);
               return;
            }

            b(var1);
            return;
         case 3407:
            String var270 = MessageHandler.readString(var1);
            if (MessageHandler.readBool(var1)) {
               String var271 = MessageHandler.readString(var1);
               String var76 = MessageHandler.readString(var1);
               boolean var274 = MessageHandler.readBool(var1);
               if (MessageHandler.readBool(var1)) {
                  MessageHandler.readString(var1);
                  MessageHandler.readString(var1);
                  MessageHandler.readLong(var1);
               }

               b.a(var270, var271, var76, var274);
               return;
            }
            break;
         case 3408:
            String var75 = MessageHandler.readString(var1);
            if (MessageHandler.readBool(var1)) {
               String var273 = MessageHandler.readString(var1);
               int var275 = MessageHandler.readInt(var1);
               byte[] var276 = MessageHandler.readByteArray(var1);
               String var277 = MessageHandler.readString(var1);
               boolean var278 = MessageHandler.readBool(var1);
               if (MessageHandler.readBool(var1)) {
                  int var279 = MessageHandler.readInt(var1);
                  b.a(var75, var273, var275, var276, var277, var278, var279);
                  return;
               }

               b.a(var75, var273, var275, var276, var277, var278);
               return;
            }

            String var272 = MessageHandler.readString(var1);
            thien_di.b().a(var272, (Image)null, 1);
            MessageHandler.readInt(var1);
            MessageHandler.readByteArray(var1);
            if (thien_ba.B.equals(var75)) {
               b.C();
               return;
            }
            break;
         case 3409:
            String var281 = MessageHandler.readString(var1);
            if (MessageHandler.readBool(var1)) {
               String var282 = MessageHandler.readString(var1);
               if (MessageHandler.readBool(var1)) {
                  String var284 = MessageHandler.readString(var1);
                  boolean var286 = MessageHandler.readBool(var1);
                  MessageHandler.readByteArray(var1);
                  if (MessageHandler.readBool(var1)) {
                     MessageHandler.readString(var1);
                     MessageHandler.readString(var1);
                     MessageHandler.readLong(var1);
                  }

                  b.b(var281, var282, var284, var286);
                  return;
               }

               String var94 = MessageHandler.readString(var1);
               int var283;
               String[] var285 = new String[var283 = MessageHandler.readInt(var1)];

               for (int var287 = 0; var287 < var283; var287++) {
                  var285[var287] = MessageHandler.readString(var1);
               }

               b.a(var281, var282, var94, var285, 0);
               return;
            }
            break;
         case 3410:
            MessageHandler.readString(var1);
            if (!MessageHandler.readBool(var1)) {
               b(var1);
               return;
            }

            MessageHandler.readString(var1);
            long var308 = MessageHandler.readLong(var1);
            if (var3 != 39) {
               return;
            }

            thien_ba.S.C = var308;
            break;
         case 3411:
            MessageHandler.readString(var1);
            String var180 = MessageHandler.readString(var1);
            String var181 = MessageHandler.readString(var1);
            b.b(var180, var181, var3);
            break;
         case 3412:
            String var112 = MessageHandler.readString(var1);
            if (MessageHandler.readBool(var1)) {
               String var114 = MessageHandler.readString(var1);
               int var115;
               String[] var116 = new String[var115 = MessageHandler.readInt(var1)];

               for (int var117 = 0; var117 < var115; var117++) {
                  var116[var117] = MessageHandler.readString(var1);
               }

               b.a(var112, var114, thien_ba.S.w, var116, 1);
               return;
            }
            break;
         case 3416:
            MessageHandler.readString(var1);
            long var289 = MessageHandler.readLong(var1);
            MessageHandler.readLong(var1);
            b.a(var289);
            return;
         case 3417:
            b(var1);
            return;
         case 34061:
            String var227 = MessageHandler.readString(var1);
            String var246 = MessageHandler.readString(var1);
            int var64;
            String[] var65 = new String[var64 = MessageHandler.readInt(var1)];
            int[] var66 = new int[var64];
            long[] var67 = new long[var64];
            long[] var68 = new long[var64];
            byte[][] var69 = new byte[var64][];
            System.out.println("hostFinish = " + var246 + "; numStartF = " + var64);

            for (int var70 = 0; var70 < var64; var70++) {
               var65[var70] = MessageHandler.readString(var1);
               var66[var70] = MessageHandler.readInt(var1);
               var67[var70] = MessageHandler.readLong(var1);
               var68[var70] = MessageHandler.readLong(var1);
               var69[var70] = MessageHandler.readByteArray(var1);
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
               var269[var73] = MessageHandler.readString(var1);
               var71[var73] = MessageHandler.readInt(var1);
               var72[var73] = new Integer(MessageHandler.readInt(var1));
               System.out.println("tRank " + var73 + "= " + var269[var73] + "; Scoring = " + var71[var73] + "; color = " + var72[var73]);
            }

            b.a(var227, var246, (byte)var64, var65, var66, var67, var68, var69, var269, var71, var72);
            return;
         case 34081:
            String var77 = MessageHandler.readString(var1);
            String var78 = MessageHandler.readString(var1);
            int var79 = MessageHandler.readInt(var1);
            byte[] var80 = MessageHandler.readByteArray(var1);
            int var81 = MessageHandler.readInt(var1);
            String var194 = MessageHandler.readString(var1);
            thien_ba.S.w = var194;
            int var82;
            String[] var83 = new String[var82 = MessageHandler.readInt(var1)];
            int[] var84 = new int[var82];
            long[] var85 = new long[var82];
            long[] var86 = new long[var82];
            byte[][] var87 = new byte[var82][];
            boolean[] var88 = new boolean[var82];

            for (int var89 = 0; var89 < var82; var89++) {
               var83[var89] = MessageHandler.readString(var1);
               var84[var89] = MessageHandler.readInt(var1);
               var85[var89] = MessageHandler.readLong(var1);
               var86[var89] = MessageHandler.readLong(var1);
               var87[var89] = MessageHandler.readByteArray(var1);
               var88[var89] = MessageHandler.readBool(var1);
            }

            String[] var280 = new String[var82];
            int[] var90 = new int[var82];
            Integer[] var91 = new Integer[var82];

            for (int var92 = 0; var92 < var82; var92++) {
               var280[var92] = MessageHandler.readString(var1);
               var90[var92] = MessageHandler.readInt(var1);
               var91[var92] = new Integer(MessageHandler.readInt(var1));
            }

            b.a(var77, var78, var79, var80, var81, var83, var84, var85, var86, var87, var88, var280, var90, var91);
            return;
         case 34091:
            String var95 = MessageHandler.readString(var1);
            String var96 = MessageHandler.readString(var1);
            int var97 = MessageHandler.readInt(var1);
            String var98 = MessageHandler.readString(var1);
            thien_ba.S.w = var98;
            byte[] var99 = new byte[0];
            int var100;
            String[] var101 = new String[var100 = MessageHandler.readInt(var1)];
            int[] var102 = new int[var100];
            long[] var103 = new long[var100];
            long[] var104 = new long[var100];
            byte[][] var105 = new byte[var100][];
            boolean[] var106 = new boolean[var100];

            for (int var107 = 0; var107 < var100; var107++) {
               var101[var107] = MessageHandler.readString(var1);
               var102[var107] = MessageHandler.readInt(var1);
               var103[var107] = MessageHandler.readLong(var1);
               var104[var107] = MessageHandler.readLong(var1);
               var105[var107] = MessageHandler.readByteArray(var1);
               var106[var107] = MessageHandler.readBool(var1);
            }

            String[] var288 = new String[var100];
            int[] var108 = new int[var100];
            Integer[] var109 = new Integer[var100];

            for (int var110 = 0; var110 < var100; var110++) {
               var288[var110] = MessageHandler.readString(var1);
               var108[var110] = MessageHandler.readInt(var1);
               var109[var110] = new Integer(MessageHandler.readInt(var1));
            }

            b.a(var95, var96, 0, var99, var97, var101, var102, var103, var104, var105, var106, var288, var108, var109);
            return;
         case 5000009:
            thien_s var193 = new thien_s();
            thien_r[] var4 = new thien_r[var3 = MessageHandler.readInt(var1)];
            String[] var5 = new String[var3];

            for (int var6 = 0; var6 < var3; var6++) {
               try {
                  var5[var6] = MessageHandler.readString(var1);
               } catch (Exception var184) {
                  var5[var6] = "";
               }

               String var7 = MessageHandler.readString(var1);
               String var8 = MessageHandler.readString(var1);
               int var9;
               var9 = (var9 = MessageHandler.readInt(var1)) == 0 ? 2 : (var9 == 1 ? 3 : 4);
               var4[var6] = new thien_r(var7, var8, var9, null, null, -1, var6);
               var193.a(var5[var6], var4[var6]);
            }

            b.b(var193);
            return;
         case 6000000:
            MessageHandler.a(Xuka.refCode);
            return;
      }
   }

   private static void b(Packet var0) {
      String var1 = MessageHandler.readString(var0);
      thien_di.c.a(var1, (Image)null, 1);
   }
}
