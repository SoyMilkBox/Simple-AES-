import java.nio.charset.StandardCharsets;

public class Round_Function {   //第一轮轮密钥
    public static String Half_Byte_Replace(String a){    //a是16位二进制数  D2.2半字节代替
        String k = bin2hex(a); //转换为4位16进制数
        String C = k.substring(0,2);
        String D = k.substring(2,4);
        Integer Ci = Integer.parseInt(C,16);
        Integer Di = Integer.parseInt(D,16);
        int c = Ci.intValue();
        int d = Di.intValue();
        int c2 = S_Box.s_box(c);
        int d2 = S_Box.s_box(d);
        StringBuffer out = new StringBuffer();
        out.append(c2);
        out.append(d2);
        return out.toString();  //跑得通，不知道对不对
    }

    public static String bin2hex(String input) {
        StringBuilder sb = new StringBuilder();
        int len = input.length();
        System.out.println("原数据长度：" + (len / 8) + "字节");

        for (int i = 0; i < len / 4; i++) {
            //每4个二进制位转换为1个十六进制位
            String temp = input.substring(i * 4, (i + 1) * 4);
            int tempInt = Integer.parseInt(temp, 2);
            String tempHex = Integer.toHexString(tempInt).toUpperCase();
            sb.append(tempHex);
        }

        return sb.toString();
    }

    public static String Line_Shift(String a){   //行移位
        String []a1 = a.split("");
        String temp = a1[2];
        a1[2] = a1[3];
        a1[3] = temp;
        return a1.toString();
    }

    public static String Column_Confusion(String a){   //列混淆
        return "0";
    }
}
