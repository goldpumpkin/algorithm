package com.gold.algorithm.leetcode;

public class ValidIPAddress_468 {

    public static void main(String[] args) {
        String s = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        System.out.println(validIPAddress(s));
    }

    /**
     * IPV4: 最大255 都是数字 . 分割 注意前导0
     * IPV6： 可以有前导0  字母a-f之间 lowercase
     */
    public static String validIPAddress(String queryIP) {
        String ipv4 = "IPv4";
        String ipv6 = "IPv6";
        String neither = "Neither";

        if (queryIP.contains(".")) {
            // ipv4
            String[] part = queryIP.split("\\.", -1);
            if (part.length != 4) {
                return neither;
            }

            for (int i = 0; i < 4; i++) {
                String s = part[i];

                if (s.length() > 3 || s.length() == 0) {
                    return neither;
                }

                char[] c = s.toCharArray();
                for (int j = 0; j < c.length; j++) {
                    if (j == 0 && c[j] - '0' == 0 && c.length != 1){
                        return neither;
                    }
                    if (c[j] - '0'< 0 ||!Character.isDigit(c[j])) {
                        return neither;
                    }
                }

                if (Integer.valueOf(s) > 255) {
                    return neither;
                }

            }
            return ipv4;

        } else if (queryIP.contains(":")) {
            // ipv6
            String[] part = queryIP.split(":", -1);
            if (part.length != 8) {
                return neither;
            }

            for (int i = 0; i < 8; i++) {
                String s = part[i];
                if (s.length() > 4 || s.length() == 0) {
                    return neither;
                }
                char[] c = s.toCharArray();
                for (int j = 0; j < c.length; j++) {
                    char cc = c[j];
                    if (!Character.isDigit(cc)) {
                        char lc = Character.toLowerCase(cc);
                        if (lc - 'a' < 0 || lc - 'f' > 0) {
                            return neither;
                        }
                    } else if(cc - '0' < 0) {
                        return neither;
                    }
                }
            }
            return ipv6;
        } else {
            return neither;
        }

    }
}
