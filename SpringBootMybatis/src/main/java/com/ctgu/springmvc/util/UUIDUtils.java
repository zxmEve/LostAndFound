package com.ctgu.springmvc.util;

import java.util.UUID;

/**
 * �����ļ���
 */
public class UUIDUtils {

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

}
