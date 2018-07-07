package com.ctgu.springmvc.util;

public class FileNameUtils {

    /**
     * ��ȡ�ļ���׺
     * @param fileName
     * @return
     */
    public static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * �����µ��ļ���
     * @param fileOriginName Դ�ļ���
     * @return
     */
    public static String getFileName(String fileOriginName){
        return UUIDUtils.getUUID() + FileNameUtils.getSuffix(fileOriginName);
    }

}