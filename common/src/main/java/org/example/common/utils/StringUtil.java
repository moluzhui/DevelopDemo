package org.example.common.utils;

/**
 * .
 *
 * @since 2024/6/6 0:45
 */
public class StringUtil {
    public static boolean isEmpty(Object obj) {

        if (obj == null) {
            return true;
        }

        if (obj.toString().isEmpty() || obj.toString().trim().isEmpty()){
            return true;
        }
        return false;
    }
}
