package com.ctgu.springmvc.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

/**
 * �ļ��ϴ����߰�
 */
public class FileUtils {

    /**
     *
     * @param file �ļ�
     * @param path �ļ����·��
     * @param fileName Դ�ļ���
     * @return
     */
    public static boolean upload(MultipartFile file, String path, String fileName){

        // �����µ��ļ���
        //String realPath = path + "/" + FileNameUtils.getFileName(fileName);

        //ʹ��ԭ�ļ���
        String realPath = path + "/" + fileName;
        System.out.println(path);
        System.out.println(fileName);

        File dest = new File(realPath);

        //�ж��ļ���Ŀ¼�Ƿ����
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }

        try {
            //�����ļ�
            file.transferTo(dest);
            return true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
}