package com.winnertel.lct.batch.gui;

import com.winnertel.em.standard.util.gui.input.IntegerTextField;

import java.nio.charset.StandardCharsets;

/**
 * Created by Lewis
 * 2017-07-15.
 */
public class TransformUtils {
    public static String toHex(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) {
            sb.append(String.format("%02X", aByte));
        }
        return sb.toString();
    }

    public static String fromHex(String hexStr) {
        if (hexStr == null || "null".equals(hexStr) || "".equals(hexStr) || "".equals(hexStr)) {
            return "";
        }
        byte[] bytes = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length(); i += 2) {
            bytes[i / 2] = Byte.parseByte(hexStr.substring(i, i + 2), 16);
        }
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public static String toHexByte(int b) {
        return String.format("0x%02X", b);
    }

    public static int fromHexByte(String hexStr) {
        if (hexStr == null || "null".equals(hexStr) || "".equals(hexStr) || hexStr.length() <= 2) {
            return 0;
        }
        return Byte.parseByte(hexStr.substring(2), 16);
    }

    public static String toHexShort(int b) {
        return String.format("0x%04X", b);
    }

    public static int fromHexShort(String hexStr) {
        if (hexStr == null || "null".equals(hexStr) || "".equals(hexStr) || hexStr.length() <= 2) {
            return 0;
        }
        return Integer.parseInt(hexStr.substring(2), 16);
    }

    public static String toHexIp(byte[] bytes) {
        return String.format("0x%02X%02X%02X%02X", bytes[0], bytes[1], bytes[2], bytes[3]);
    }

    public static byte[] fromHexIp(String hexIp) {
        if (hexIp == null || "null".equals(hexIp) || "".equals(hexIp) || hexIp.length() <= 2) {
            return new byte[4];
        }
        String delete0X = hexIp.substring(2);
        byte[] bytes = new byte[delete0X.length() / 2];
        for (int i = 0; i < delete0X.length(); i += 2) {
            bytes[i / 2] = (byte) (Integer.parseInt(delete0X.substring(i, i + 2), 16) & 0xff);
        }
        return bytes;
    }

    public static String toIp(byte[] bytes) {
        return String.format("%d.%d.%d.%d", bytes[0] & 0xff, bytes[1] & 0xff, bytes[2] & 0xff, bytes[3] & 0xff);
    }

    public static byte[] fromIp(String ip) {
        String[] split = ip.split("\\.");
        byte[] bytes = new byte[4];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = Byte.valueOf(split[i]);
        }
        return bytes;
    }

    public static void setNullableIntField(IntegerTextField integerTextField, String intVal) {
        if (intVal != null) {
            integerTextField.setValue(Integer.valueOf(intVal));
        }
    }

    public static String saveOnuId(String display) {
        String[] split = display.split("/");
        return String.format("%s-%s", split[1], split[2]);
    }

    public static String displayOnuId(String save) {
        String[] split = save.split("-");
        return String.format("1/%s/%s", split[0], split[1]);
    }

    public static String saveUniId(String display) {
        String[] split = display.split("/");
        return String.format("%s-%s-%s", split[1], split[2], split[3]);
    }

    public static String displayUniId(String save) {
        String[] split = save.split("-");
        return String.format("1/%s/%s/%s", split[0], split[1], split[2]);
    }

    public static String displayProfilePonId(String id) {
        String[] split = id.split("-");
        return String.format("PON 1/%s", split[0]);
    }

    public static String displayProfileUniId(String id) {
        String[] split = id.split("-");
        return String.format("PON 1/%s ONU UNI %s", split[0], split[2]);
    }

    public static void main(String[] args) {
        byte b = (byte) 255;
        int x = b & 0xff;
        System.out.println(x);
        System.out.println(String.format("0x%02X", x));
//        System.out.println(fromHex("485a"));
//        System.out.println(toHex(fromHex("485a")));

//        String hexIp = "0x0101020b";
//        System.out.println(fromHexIp(hexIp));
//        System.out.println(toIp(fromHexIp(hexIp)));
//        System.out.println(fromIp(toIp(fromHexIp(hexIp))));
//        System.out.println(toHexIp(fromHexIp(hexIp)));

        System.out.println(fromHexShort("0x0fb4"));
        System.out.println(toHexShort(fromHexShort("0x0fb4")));
    }

    public static String valueOf(Object o) {
        if (o == null) {
            return null;
        } else {
            return String.valueOf(o);
        }
    }

    public static int idSortNum(String id) {
        String[] split = id.split("-");
        int i = 0;
        for (String s : split) {
            if (i == 0) {
                i = Integer.valueOf(s);
            } else {
                i = i * 10000 + Integer.valueOf(s);
            }
        }
        return i;
    }
}
