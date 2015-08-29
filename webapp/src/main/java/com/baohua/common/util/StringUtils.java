package com.baohua.common.util;

import java.util.Random;

/**
 * @author $Id$
 */
public class StringUtils {

    public static final String ALLCHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LETTERCHARS = "abcdefghijkllmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERCHARS = "0123456789";

    public static String generateMixedString(int length) {
        StringBuilder stringBuffer = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            stringBuffer.append(ALLCHARS.charAt(random.nextInt(ALLCHARS.length())));
        }
        return stringBuffer.toString();
    }

    public static String generateLetterString(int length) {
        StringBuilder stringBuffer = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            stringBuffer.append(LETTERCHARS.charAt(random.nextInt(LETTERCHARS.length())));
        }
        return stringBuffer.toString();
    }

    public static String generateNumberString(int length) {
        StringBuilder stringBuffer = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            stringBuffer.append(NUMBERCHARS.charAt(random.nextInt(NUMBERCHARS.length())));
        }
        return stringBuffer.toString();
    }


}
