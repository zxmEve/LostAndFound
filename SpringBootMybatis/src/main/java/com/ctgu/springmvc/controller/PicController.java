package com.ctgu.springmvc.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ctgu.springmvc.util.FileUtils;

@Controller
public class PicController {
	
	private final ResourceLoader resourceLoader;
	
	@Autowired
	public PicController(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
	
	@Value("${web.upload-path}")
	private String path;
	
	@RequestMapping("/fileUpload")
    public String upload(@RequestParam("image") MultipartFile file, Map<String, Object> map, HttpServletRequest request){
		// Ҫ�ϴ���Ŀ���ļ����·��
        String localPath = path;
        // �ϴ��ɹ�����ʧ�ܵ���ʾ
        String msg = "";
        if (FileUtils.upload(file, localPath, file.getOriginalFilename())){
            // �ϴ��ɹ�������ҳ����ʾ
            msg = "�ϴ��ɹ���";
        }else {
            msg = "�ϴ�ʧ�ܣ�";
        }

        // ��ʾͼƬ
        map.put("msg", msg);
        map.put("fileName", file.getOriginalFilename());
        request.getSession().setAttribute("fileName", file.getOriginalFilename());
        return "lostPub";
    }
	
	 /**
     * ��ʾ����ͼƬ
     * @return
     */
    @RequestMapping("/show{fileName}")
    @ResponseBody
    public ResponseEntity<?> showPhotos(@PathVariable String fileName){
//    	System.out.println(fileName);
    	try {
            // �����Ƕ�ȡ�������ļ���file��һ��Ҫ���ϵģ� path����application�����ļ��е�·��
            return ResponseEntity.ok(resourceLoader.getResource("file:" + path + "/" + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @RequestMapping("/fileUpload_found")
    public String upload_found(@RequestParam("image") MultipartFile file, Map<String, Object> map, HttpServletRequest request){
		// Ҫ�ϴ���Ŀ���ļ����·��
        String localPath = path;
        // �ϴ��ɹ�����ʧ�ܵ���ʾ
        String msg = "";
        if (FileUtils.upload(file, localPath, file.getOriginalFilename())){
            // �ϴ��ɹ�������ҳ����ʾ
            msg = "�ϴ��ɹ���";
        }else {
            msg = "�ϴ�ʧ�ܣ�";
        }

        // ��ʾͼƬ
        map.put("msg", msg);
        map.put("fileName", file.getOriginalFilename());
        request.getSession().setAttribute("fileName", file.getOriginalFilename());
        return "foundPub";
    }
}
