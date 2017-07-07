package com.winnertel.ems.epon.iad.framework.util;

import java.util.StringTokenizer;

public class VersionUtil {
    
    public static boolean isSupported(String criteria, String version) {
        if (criteria == null || criteria.equals("")) {
            return false;
        }

        criteria = criteria.trim().replace(',', ';');

        //it means that all the version is supported.
        if (criteria.equals("*")) {
            return true;
        }

        StringTokenizer st1 = new StringTokenizer(criteria, ";");
        while (st1.hasMoreTokens()) {
            String ver = st1.nextToken();

            if (ver.indexOf("-") != -1) {
                StringTokenizer st = new StringTokenizer(ver, "-");
                String minVer = st.nextToken();
                String maxVer = st.nextToken();
                if (version.compareTo(minVer) >= 0 && version.compareTo(maxVer) <= 0) {
                    return true;
                }
            } else {
                if (ver.equals(version)) {
                    return true;
                }
            }
        }

        return false;
    }
}
