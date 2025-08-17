package home.thienph.xyahoo;

public final class thien_fe {
    public static String[] a = new String[]{"dm", "cl", "vl", "dkm", "vkl", "clmm", "loz", "xlon", "cailon", "dkmm", "qhtd", "cai lon", "lon me", "lon ma", "xao lon", "vai lon", "di me", "con cho", "cho de", "du ma", "du me", "dit me", "dis me", "dit con me", "dis con me", "con dj", "dj me", "djt me", "djt con me", "djs me", "dj.t me", "di.t me", "bu lon", "pu lon", "bu cac", "pu cac", "con cac", "l0n", "djt", "dit", "di me", "du m", "con cac", "chet me", "dj me", "chet me", "fuck"};

    public static final int a(String string) {
        if (string.length() == 0 || string.length() < 6 || string.length() > 64) {
            return 1;
        }
        int n = 0;
        while (n < 9) {
            String string2 = String.valueOf((char)(n + 48));
            if (string.startsWith(string2)) {
                return 2;
            }
            ++n;
        }
        n = 0;
        while (n < string.length()) {
            char c = string.charAt(n);
            if (!('A' <= c && c <= 'Z' || 'a' <= c && c <= 'z' || '0' <= c && c <= '9')) {
                return 3;
            }
            ++n;
        }
        return 0;
    }

    public static String b(String string) {
        String string2 = string.toLowerCase();
        int n = 0;
        while (n < a.length) {
            int n2 = string2.indexOf(a[n]);
            if (n2 >= 0) {
                String string3;
                boolean bl = false;
                boolean bl2 = false;
                try {
                    string3 = string.substring(n2 - 1, n2 + a[n].length());
                    if (string3.equals(" " + a[n])) {
                        bl = true;
                    }
                }
                catch (Exception exception) {
                    bl = true;
                }
                try {
                    string3 = string.substring(n2, n2 + a[n].length() + 1);
                    if (string3.equals(String.valueOf(a[n]) + " ")) {
                        bl2 = true;
                    }
                }
                catch (Exception exception) {
                    bl2 = true;
                }
                if (bl && bl2) {
                    string = String.valueOf(string.substring(0, n2)) + "***" + string.substring(n2 + a[n].length());
                    string2 = String.valueOf(string2.substring(0, n2)) + "***" + string2.substring(n2 + a[n].length());
                }
            }
            ++n;
        }
        return string;
    }
}
