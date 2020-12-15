package com.joezhou.util;

/**
 * @author JoeZhou
 */
public class NullUtil {

    /**
     * Test whether the parameters contains a null object
     * @param params object array
     * @return contains a null object or empty string if true
     */
    public static boolean isNull(Object... params) {
        for (Object param : params) {
            if (param == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Test whether the parameters contains a null object or empty string
     * @param params string array
     * @return contains a null object or empty string if true
     */
    public static boolean isBlank(String... params) {
        for (String param : params) {
            if (param == null || "".equals(param)) {
                return true;
            }
        }
        return false;
    }


}
