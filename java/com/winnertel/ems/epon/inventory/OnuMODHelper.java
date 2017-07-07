package com.winnertel.ems.epon.inventory;

public class OnuMODHelper {

    public static String convertHwType(String type) {
        if (type == null || "null".equals(type))
            return "";

        type = type.trim();
        if (type.equalsIgnoreCase("1"))
            return "ONU100";
        else if (type.equalsIgnoreCase("2"))
            return "ONU1000b";
        else if (type.equalsIgnoreCase("3"))
            return "ONU1000c";
        else if (type.equalsIgnoreCase("4"))
            return "ONU200a";
        else if (type.equalsIgnoreCase("5"))
            return "ONU200b";
        else if (type.equalsIgnoreCase("6"))
            return "ONU2024";
        else if (type.equalsIgnoreCase("7"))
            return "ONU2004";
        else if (type.equalsIgnoreCase("8"))
            return "ONU101k";
        else if (type.equalsIgnoreCase("9"))
            return "ONU301";
        else if (type.equalsIgnoreCase("10"))
            return "ONU301c";
        else if (type.equalsIgnoreCase("11"))
            return "ONU404";
        else if (type.equalsIgnoreCase("12"))
            return "ONU404c";
        else if (type.equalsIgnoreCase("13"))
            return "ONU804";
        else if (type.equalsIgnoreCase("14"))
            return "ONU804c";
        else if (type.equalsIgnoreCase("15"))
            return "ONU1001c";
        else if (type.equalsIgnoreCase("16"))
            return "ONU3004";
        else if (type.equalsIgnoreCase("17"))
            return "ONU1001i";
        else if (type.equalsIgnoreCase("18"))
            return "ONU2004i";
        else if (type.equalsIgnoreCase("19"))
            return "ONU404i"; // "ONU404i" (New Postcom: "Postcom_T103")
        else if (type.equalsIgnoreCase("20"))
            return "CLT2060";
        else if (type.equalsIgnoreCase("21"))
            return "ONU204i";
        else if (type.equalsIgnoreCase("22"))
            return "ONU208i";
        else if (type.equalsIgnoreCase("23"))
            return "ONU204h";
        else if (type.equalsIgnoreCase("24"))
            return "ONU408t"; // "ONU408t" / (New Postcom: "Postcom_T138")
        else if (type.equalsIgnoreCase("25"))
            return "ONU2024i";
        else if (type.equalsIgnoreCase("26"))
            return "ONUB210"; // "B1205-Y" / (New Postcom: "Postcom_T232") / "ONUB210"
        else if (type.equalsIgnoreCase("27"))
            return "ONU1001h";
        else if (type.equalsIgnoreCase("28"))
            return "ONUb220";
        else if (type.equalsIgnoreCase("29"))
            return "ONU804i";
        else if (type.equalsIgnoreCase("30"))
            return "ONU101";
        else if (type.equalsIgnoreCase("31"))
            return "ONU1001b";
        else if (type.equalsIgnoreCase("32"))
            return "ONU2004h";
        else if (type.equalsIgnoreCase("33"))
            return "ONU204d"; // "ONU204i-e" / "ONU204d"
        else if (type.equalsIgnoreCase("34"))
            return "ONU404t";
        else if (type.equalsIgnoreCase("35"))
            return "ONU4024t";
        else if (type.equalsIgnoreCase("36"))
            return "ONU4024i"; //"ONU408T" / "ONU4024i"
        else if (type.equalsIgnoreCase("38"))
            return "ONU101i";
        else if (type.equalsIgnoreCase("39"))
            return "B1205-Y"; // "B1205-Y" / (New Postcom: "Postcom_T232")
        else if (type.equalsIgnoreCase("40"))
            return "B1205-D";
        else if (type.equalsIgnoreCase("41"))
            return "B130";
        else if (type.equalsIgnoreCase("42"))
            return "ONUB1205";
        else if (type.equalsIgnoreCase("61"))
            return "ONU1001t";
        else if (type.equalsIgnoreCase("62"))
            return "ONU404t";
        else if (type.equalsIgnoreCase("71"))
            return "ONU2004-2";
        else if (type.equalsIgnoreCase("72"))
            return "ONU404h";
        else if (type.equalsIgnoreCase("73"))
            return "ONU208h";
        else if (type.equalsIgnoreCase("74"))
            return "ONU4016i";
        else if (type.equalsIgnoreCase("75"))
            return "ONU4016i-t";
        else if (type.equalsIgnoreCase("76"))
            return "ONU2016i-e";
        else if (type.equalsIgnoreCase("77"))
            return "ONU4016i-t A1B";
        else if (type.equalsIgnoreCase("78"))
            return "ONU4016i-t A1S";
        else if (type.equalsIgnoreCase("79"))
            return "ONU208p";
        else if (type.equalsIgnoreCase("80"))
            return "ONU4024i A1B";
        else if (type.equalsIgnoreCase("81"))
            return "ONU4024i A1S";
        else if (type.equalsIgnoreCase("82"))
            return "ONU4024i A2B";
        else if (type.equalsIgnoreCase("83"))
            return "ONU4024i A2S";
        else if (type.equalsIgnoreCase("84"))
            return "ONUB1202";
        else if (type.equalsIgnoreCase("85"))
            return "ONU204i-e";
        else if (type.equalsIgnoreCase("86"))
            return "ONU204i-h";
        else if (type.equalsIgnoreCase("87"))
            return "ONU204i-h R.c1";
        else if (type.equalsIgnoreCase("88"))
            return "ONU4024i-C1";
        else if (type.equalsIgnoreCase("89"))
            return "ONU204i-h R.c1";
        else if (type.equalsIgnoreCase("91"))
            return "ONU404i R.c1";
        else if (type.equalsIgnoreCase("93"))
            return "ONU204i-h R.h1";
        else if (type.equalsIgnoreCase("94"))
            return "ONU204i-k7 R.a1";
        else if (type.equalsIgnoreCase("95"))
            return "ONU204i-k7 R.a2";
        else if (type.equalsIgnoreCase("96"))
            return "ONU204i-k7 R.a3";
        else if (type.equalsIgnoreCase("97"))
            return "ONU204i-k7 R.a4";
        else if (type.equalsIgnoreCase("98"))
            return "ONU804i R.c1";
        else if (type.equalsIgnoreCase("99"))
            return "ONU804i-c2";
        else if (type.equalsIgnoreCase("100"))
            return "TK ONU";
        else if (type.equalsIgnoreCase("101"))
            return "PMC ONU";
        else if (type.equalsIgnoreCase("103"))
            return "ONU204i-k7 R.a7";
        else if (type.equalsIgnoreCase("104"))
            return "ONU204i-k7 R.a5";
        else if (type.equalsIgnoreCase("105"))
            return "CLT2168";
        else if (type.equalsIgnoreCase("A001"))
            return "ONU1001i";
        else if (type.equalsIgnoreCase("A002"))
            return "ONU204i";
        else if (type.equalsIgnoreCase("A003"))
            return "ONU404i"; // "ONU404i" / (New Postcom: "Postcom_T103")
        else if (type.equalsIgnoreCase("A004"))
            return "ONU804i";
        else if (type.equalsIgnoreCase("A005"))
            return "ONU208i";
        else if (type.equalsIgnoreCase("A006"))
            return "ONU101i";
        else if (type.equalsIgnoreCase("A007"))
            return "ONU2004i";
        else if (type.equalsIgnoreCase("A008"))
            return "CLT2060";
        else if (type.equalsIgnoreCase("A009"))
            return "ONU2024i";
        else if (type.equalsIgnoreCase("A00A"))
            return "ONU4024i";
        else if (type.equalsIgnoreCase("A00B"))
            return "ONUB1205"; //changed by zengtian 2012/02/23 for NMS00072144 
        else if (type.equalsIgnoreCase("A00C"))
            return "B1205-D";
        else if (type.equalsIgnoreCase("A00D"))
            return "B130";
        else if (type.equalsIgnoreCase("A00E"))
            return "ONU2004-2";
        else if (type.equalsIgnoreCase("A013"))
            return "ONU404h";
        else if (type.equalsIgnoreCase("A015"))
            return "ONU804h";
        else if (type.equalsIgnoreCase("A017"))
            return "ONU204h";
        else if (type.equalsIgnoreCase("A018"))
            return "ONU408t"; // "ONU408t" / (New Postcom: "Postcom_T138")
        else if (type.equalsIgnoreCase("A019"))
            return "B1205-Y"; // "B1205-Y" / (New Postcom: "Postcom_T232")
        else if (type.equalsIgnoreCase("A01A"))
            return "ONU1001h";
        else if (type.equalsIgnoreCase("A01F"))
            return "ONU2004h";
        else if (type.equalsIgnoreCase("A020"))
            return "ONU204i-e";
        else if (type.equalsIgnoreCase("A021"))
            return "ONU404t";
        else if (type.equalsIgnoreCase("A022"))
            return "ONU4024t";
        else if (type.equalsIgnoreCase("A024"))
            return "ONU4016i-t";
        else if (type.equalsIgnoreCase("A101"))
            return "ONU204i-e";
        else if (type.equalsIgnoreCase("A107"))
            return "ONUB1202";
        else if (type.equalsIgnoreCase("A108"))
            return "ONU204i-h";
        else if (type.equalsIgnoreCase("A109"))
            return "ONU204i-h R.c1";
        else if (type.equalsIgnoreCase("A10B"))
            return "ONU204i-c2";
        else if (type.equalsIgnoreCase("A10C"))
            return "ONU404i R.c1";
        else if (type.equalsIgnoreCase("A10E"))
            return "ONU204i-h R.h1";
        else if (type.equalsIgnoreCase("A10F"))
            return "ONU204i-k7 R.a1";
        else if (type.equalsIgnoreCase("A110"))
            return "ONU204i-k7 R.a2";
        else if (type.equalsIgnoreCase("A111"))
            return "ONU204i-k7 R.a3";
        else if (type.equalsIgnoreCase("A112"))
            return "ONU204i-k7 R.a4";
        else if (type.equalsIgnoreCase("A113"))
            return "ONU804i R.c1";
        else if (type.equalsIgnoreCase("A114"))
            return "ONU804i-c2";
        else if (type.equalsIgnoreCase("A115"))
            return "ONU204i-k7 R.a7";
        else if (type.equalsIgnoreCase("A116"))
            return "ONU204i-k7 R.a5";
        else if (type.equalsIgnoreCase("A117"))
            return "ONU204i-k7 R.b2";
        else if (type.equalsIgnoreCase("A120"))
            return "CLT2168";
        else if (type.equalsIgnoreCase("A121"))
            return "CLT2170";
        else if (type.equalsIgnoreCase("A122"))
            return "C3160";
        else if (type.equalsIgnoreCase("B141"))
            return "ONU4016i-t";
        else if (type.equalsIgnoreCase("B142"))
            return "ONU4016i-t A1S";
        else if (type.equalsIgnoreCase("B341"))
            return "ONU2016i-e";
        else if (type.equalsIgnoreCase("D001")) 
            return "JS04H-v";
        else if (type.equalsIgnoreCase("D002")) 
            return "JS16B-v";
        else if (type.equalsIgnoreCase("D003")) 
            return "JS24B-v";
        else if (type.equalsIgnoreCase("8011")) 
            return "S1201";
        else if (type.equalsIgnoreCase("8012")) 
            return "S1202";
        else
            return type;
    }

    public static int getHwType(String type) {
        if (type == null)
            return 200; //Unknown
        else if (type.equalsIgnoreCase("ONU100"))
            return 1;
        else if (type.equalsIgnoreCase("ONU1000b"))
            return 2;
        else if (type.equalsIgnoreCase("ONU1000c"))
            return 3;
        else if (type.equalsIgnoreCase("ONU200a"))
            return 4;
        else if (type.equalsIgnoreCase("ONU200b"))
            return 5;
        else if (type.equalsIgnoreCase("ONU2024"))
            return 6;
        else if (type.equalsIgnoreCase("ONU2004"))
            return 7;
        else if (type.equalsIgnoreCase("ONU101k"))
            return 8;
        else if (type.equalsIgnoreCase("ONU301"))
            return 9;
        else if (type.equalsIgnoreCase("ONU301c"))
            return 10;
        else if (type.equalsIgnoreCase("ONU404"))
            return 11;
        else if (type.equalsIgnoreCase("ONU404c"))
            return 12;
        else if (type.equalsIgnoreCase("ONU804"))
            return 13;
        else if (type.equalsIgnoreCase("ONU804c"))
            return 14;
        else if (type.equalsIgnoreCase("ONU1001c"))
            return 15;
        else if (type.equalsIgnoreCase("ONU3004"))
            return 16;
        else if (type.equalsIgnoreCase("ONU1001i"))
            return 17;
        else if (type.equalsIgnoreCase("ONU2004i"))
            return 18;
        else if (type.equalsIgnoreCase("ONU404i") || type.equalsIgnoreCase("Postcom_T103"))
            return 19;
        else if (type.equalsIgnoreCase("CLT2060"))
            return 20;
        else if (type.equalsIgnoreCase("ONU204i"))
            return 21;
        else if (type.equalsIgnoreCase("ONU208i"))
            return 22;
        else if (type.equalsIgnoreCase("ONU204h"))
            return 23;
        else if (type.equalsIgnoreCase("ONU408t") || type.equalsIgnoreCase("Postcom_T138"))
            return 24;
        else if (type.equalsIgnoreCase("ONU2024i"))
            return 25;
        else if (type.equalsIgnoreCase("ONUB210"))
            return 26;
        else if (type.equalsIgnoreCase("ONU1001h"))
            return 27;
        else if (type.equalsIgnoreCase("ONUb220"))
            return 28;
        else if (type.equalsIgnoreCase("ONU804i"))
            return 29;
        else if (type.equalsIgnoreCase("ONU101"))
            return 30;
        else if (type.equalsIgnoreCase("ONU1001b"))
            return 31;
        else if (type.equalsIgnoreCase("ONU2004h"))
            return 32;
        else if (type.equalsIgnoreCase("ONU204d"))
            return 33;
        else if (type.equalsIgnoreCase("ONU404t"))
            return 34;
        else if (type.equalsIgnoreCase("ONU4024t"))
            return 35;
        else if (type.equalsIgnoreCase("ONU4024i"))
            return 36;
        else if (type.equalsIgnoreCase("ONU101i"))
            return 38;
        else if (type.equalsIgnoreCase("B1205-Y") || type.equalsIgnoreCase("Postcom_T232"))
            return 39;
        else if (type.equalsIgnoreCase("B1205-D"))
            return 40;
        else if (type.equalsIgnoreCase("B130"))
            return 41;
        else if (type.equalsIgnoreCase("B1205"))
            return 42;
        else if (type.equalsIgnoreCase("ONU1001t"))
            return 61;
        else if (type.equalsIgnoreCase("ONU404t"))
            return 62;
        else if (type.equalsIgnoreCase("ONU2004-2"))
            return 71;
        else if (type.equalsIgnoreCase("ONU404h"))
            return 72;
        else if (type.equalsIgnoreCase("ONU208h"))
            return 73;
        else if (type.equalsIgnoreCase("ONU4016i"))
            return 74;
        else if (type.equalsIgnoreCase("ONU4016i-t"))
            return 75;
        else if (type.equalsIgnoreCase("ONU2016i-e"))
            return 76;
        else if (type.equalsIgnoreCase("ONU4016i-t A1B"))
            return 77;
        else if (type.equalsIgnoreCase("ONU4016i-t A1S"))
            return 78;
        else if (type.equalsIgnoreCase("ONU208p"))
            return 79;
        else if (type.equalsIgnoreCase("ONU4024i A1B"))
            return 80;
        else if (type.equalsIgnoreCase("ONU4024i A1S"))
            return 81;
        else if (type.equalsIgnoreCase("ONU4024i A2B"))
            return 82;
        else if (type.equalsIgnoreCase("ONU4024i A2S"))
            return 83;
        else if (type.equalsIgnoreCase("B1202"))
            return 84;
        else if (type.equalsIgnoreCase("ONU204i-e"))
            return 85;
        else if (type.equalsIgnoreCase("ONU204i-h"))
            return 86;
        else if (type.equalsIgnoreCase("ONU4024i-C1"))
            return 88;
        else if (type.equalsIgnoreCase("ONU204i-h R.c1"))
            return 89;//87
        else if ( type.equalsIgnoreCase("ONU404i R.c1")) 
            return 91;
        else if ( type.equalsIgnoreCase("ONU204i-h R.h1")) 
            return 93;
        else if ( type.equalsIgnoreCase("ONU204i-k7 R.a1"))
            return 94;
        else if ( type.equalsIgnoreCase("ONU204i-k7 R.a2"))
            return 95;
        else if ( type.equalsIgnoreCase("ONU204i-k7 R.a3"))
            return 96;
        else if ( type.equalsIgnoreCase("ONU204i-k7 R.a4"))
            return 97;
        else if ( type.equalsIgnoreCase("ONU804i R.c1"))
            return 98;
        else if ( type.equalsIgnoreCase("ONU804i-c2"))
            return 99;
        else if (type.equalsIgnoreCase("TK ONU"))
            return 100;
        else if (type.equalsIgnoreCase("PMC ONU"))
            return 101;
        else if (type.equalsIgnoreCase("ONU204i-k7 R.a7"))
            return 103;
        else if (type.equalsIgnoreCase("ONU204i-k7 R.a5"))
            return 104;
        else if(type.equalsIgnoreCase("CLT2168"))
        	return 105;
        else if(type.equalsIgnoreCase("CLT2170"))
        	return 106;
        else if(type.equalsIgnoreCase("C3160"))
        	return 107;
        else if(type.equalsIgnoreCase("ONU204i-k7 R.b2"))
        	return 108;
        else if(type.equalsIgnoreCase("JS24B-v"))
        	return 301;
        else if(type.equalsIgnoreCase("JS04H-v"))
        	return 302;
        else if(type.equalsIgnoreCase("JS16B-v"))
        	return 303;
        else if(type.equalsIgnoreCase("s1201"))
        	return 401;
        else if(type.equalsIgnoreCase("s1202"))
        	return 402;
        else
            return 200; //Unknown
    }

    public static int getOnuSwitchCount(String type) {
        int count = 1;

        if (type != null) {
            if(type.equals("ONT232") || type.equals("ONT432")) {
                count = 2;
            } else if (type.equals("ONU200a") || type.equals("ONU200b") || type.equals("ONU2004") || type.equals("ONU301")
                    || type.equals("ONU301c") || type.startsWith("ONU404") || type.equals("ONU404c") || type.equals("ONU804")
                    || type.equals("ONU804c") || type.equals("ONU3004") || type.startsWith("ONU204i") || type.equals("ONU404i")
                    || type.startsWith("ONU804i") || type.equals("ONU2004i") || type.equals("ONU2004-2") || type.equals("ONT234")
                    || type.equals("ONT434") || type.equals("ONT834") || type.equals("ONT634")) {
                count = 4;
            } else if (type.equals("ONU208") || type.equals("ONU208i") || type.equals("ONU408t") || type.equals("ONT408t")) {
                count = 8;
            } else if (type.equals("ONU2024") || type.equals("ONU2024i") || type.equals("ONU408T") || type.equals("ONU4024t") || type.equals("ONU4024i")) {
                count = 24;
            }
        }

        return count;
    }

    public static boolean hasSwitch(String type) {
        if (type == null || type.equals(""))
            return false;

        return type.startsWith("ONU20") || type.startsWith("ONU300") || type.startsWith("ONU40") || type.startsWith("ONU80") || type.startsWith("B");
    }

    public static String convertOntHwType(String type) {
        if (type == null)
            return "";

        type = type.trim();
        if (type.equalsIgnoreCase("1"))
            return "ONT1001t";
        else if (type.equalsIgnoreCase("2"))
            return "ONT408t";
        else if (type.equalsIgnoreCase("3"))
            return "B1205";
        else if (type.equalsIgnoreCase("4"))
            return "ONT404t";
        else
            return type;
    }

//            1:General,reserved for unknown ONT type;
//            2 ONT 232
//            3 ONT 234
//            4 ONT
//            5 ONT
//            6 ONT
//            7 ONT
//            8 ONT
//            9 ONT
//1-General, 2-ONT1001t, 3-ONT404t
    public static String convertGponOntHwType(String type) {
        if (type == null)
            return "";

        type = type.trim();
        if (type.equalsIgnoreCase("1"))
            return "General";
        else if (type.equalsIgnoreCase("2"))
            return "ONT232";
        else if (type.equalsIgnoreCase("3"))
            return "ONT234";
        else if (type.equalsIgnoreCase("4"))
            return "ONT431";
        else if (type.equalsIgnoreCase("5"))
            return "ONT432";
        else if (type.equalsIgnoreCase("6"))
            return "ONT434";
        else if (type.equalsIgnoreCase("7"))
            return "ONT834";
        else if (type.equalsIgnoreCase("8"))
            return "B1202";
        else if (type.equalsIgnoreCase("9"))
            return "B1205";
        else
            return type;
    }

    public static int getOnuInterfaceType(String model) {
        if (model != null) {
            if (model.equals("A001")) // ONU1001i
                return 17;
            if (model.equals("A002")) // ONU204i
                return 21;
            if (model.equals("A003")) // ONU404i
                return 19;
            if (model.equals("A004")) // ONU804i
                return 29;
            if (model.equals("A005")) // ONU208i
                return 22;
            if (model.equals("A006")) // ONU101i
                return 38;
            if (model.equals("A007")) // ONU2004i
                return 18;
            if (model.equals("A008")) // CLT2060
                return 20;
            if (model.equals("A009")) // ONU2024i
                return 25;
            if (model.equals("A00A")) // ONU4024i
                return 36;
            if (model.equals("A00B")) // B1205
                return 42;
            if (model.equalsIgnoreCase("A00C")) // B1205-D
                return 39;
            if (model.equalsIgnoreCase("A00D")) // B130
                return 40;
            if (model.equalsIgnoreCase("A00E"))// ONU2004-2
                return 43;
            if (model.equalsIgnoreCase("A013"))// ONU404h
                return 72;
            if (model.equalsIgnoreCase("A017"))// ONU204h
                return 23;
            if (model.equals("A018")) // ONU408t
                return 24;
            if (model.equals("A019")) // B1205-Y
                return 26;
            if (model.equals("A01A")) // ONU1001h
                return 27;
            if (model.equals("A01F")) // ONU2004h
                return 32;
            if (model.equals("A020")) // ONU204i-e
                return 85;
            if (model.equals("A021")) // ONU404t
                return 34;
            if (model.equals("A022")) // ONU4024t
                return 35;
            if (model.equalsIgnoreCase("A024"))// ONU4016i-t
                return 75;
            if (model.equalsIgnoreCase("A101"))// ONU204i-e
                return 85;
            if (model.equalsIgnoreCase("A107"))// ONUB1202
                return 84;
            if (model.equalsIgnoreCase("A108"))// ONU204i-h
                return 86;
            if (model.equalsIgnoreCase("A109"))// ONU204i-h R.c1
                return 87;
            if (model.equalsIgnoreCase("A10B"))// ONU204i-c2
                return 88;
            if (model.equalsIgnoreCase("A10C"))// ONU404i R.c1
                return 91;
            if (model.equalsIgnoreCase("A10E"))// ONU204i-h R.h1
                return 93;
            if (model.equalsIgnoreCase("A10F"))// ONU204i-k7 R.a1
                return 94;
            if (model.equalsIgnoreCase("A110"))// ONU204i-k7 R.a2
                return 95;
            if (model.equalsIgnoreCase("A111"))// ONU204i-k7 R.a3
                return 96;
            if (model.equalsIgnoreCase("A112"))// ONU204i-k7 R.a4
                return 97;
            if (model.equalsIgnoreCase("A113"))// ONU804i R.c1
                return 98;
            if (model.equalsIgnoreCase("A114"))// ONU804i-c2
                return 99;
            if (model.equalsIgnoreCase("A115"))// ONU204i-k7 R.a7
                return 103;
            if (model.equalsIgnoreCase("A116"))// ONU204i-k7 R.a5
                return 104;
            if (model.equalsIgnoreCase("A117"))// ONU204i-k7 R.b2
                return 108;
            if (model.equalsIgnoreCase("A120"))// CLT2168
                return 105;
            if (model.equalsIgnoreCase("A121"))// CLT2170
                return 106;
            if (model.equalsIgnoreCase("A122"))// C3160
                return 107;
            if (model.equalsIgnoreCase("B141"))// onu4016i-tA1B
                return 77;
            if (model.equalsIgnoreCase("B142"))// onu4016i-tA1S
                return 78;
            if (model.equalsIgnoreCase("B341"))// ONU2016i-e
                return 76;
            if (model.equalsIgnoreCase("D001"))// JS04H-v
                return 302;
            if (model.equalsIgnoreCase("D002"))// JS16B-v
                return 303;
            if (model.equalsIgnoreCase("D003"))// JS24B-v
                return 301;
            if (model.equalsIgnoreCase("8011"))// S1201
                return 401;
            if (model.equalsIgnoreCase("8012"))// S1202
                return 402;
        }
        return 200; // Unknown
    }

}