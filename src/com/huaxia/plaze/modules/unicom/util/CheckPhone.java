package com.huaxia.plaze.modules.unicom.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 根据手机号码判断运营商工具
 * <p>
 * 手机号码必须是明文,不支持带国际区号的手机号码
 */
public abstract class CheckPhone {
    private static final String UNICOM_CELLPHONE_REGEX = "^1(3[0-2]|4[56]|5[56]|6[67]|7(0[4789]|1|5|6)|8[56])\\d{7,8}$";
    private static final String TELECOM_CELLPHONE_REGEX = "^1(3(3|49)|4[19]|53|7(7|0[0-2]|3|4)|8[019]|9[19])\\d{7,8}$";
    private static final String MOBILE_CELLPHONE_REGEX = "^1(34[0-8]|3[5-9]|4[478]|5[012789]|65|7(0[356]|2|8)|8[23478]|98)\\d{7,8}$";
    private static final Pattern UNICOM_CELLPHONE_PATTERN = Pattern.compile(UNICOM_CELLPHONE_REGEX);
    private static final Pattern TELECOM_CELLPHONE_PATTERN = Pattern.compile(TELECOM_CELLPHONE_REGEX);
    private static final Pattern MOBILE_CELLPHONE_PATTERN = Pattern.compile(MOBILE_CELLPHONE_REGEX);

    public static String getCarrier(String cellphoneNum) {
        if (isUnicom(cellphoneNum)) {
            return "UNICOM";
        } else if (isTelecom(cellphoneNum)) {
            return "TELECOM";
        } else if (isMobile(cellphoneNum)) {
            return "MOBILE";
        } else {
            return "";
        }
    }

    public static boolean isUnicom(String cellphoneNum) {
        Matcher matcher = UNICOM_CELLPHONE_PATTERN.matcher(cellphoneNum);
        return matcher.find();
    }

    public static boolean isTelecom(String cellphoneNum) {
        Matcher matcher = TELECOM_CELLPHONE_PATTERN.matcher(cellphoneNum);
        return matcher.find();
    }

    public static boolean isMobile(String cellphoneNum) {
        Matcher matcher = MOBILE_CELLPHONE_PATTERN.matcher(cellphoneNum);
        return matcher.find();
    }
}
