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
		// 要上传的目标文件存放路径
        String localPath = path;
        // 上传成功或者失败的提示
        String msg = "";
        if (FileUtils.upload(file, localPath, file.getOriginalFilename())){
            // 上传成功，给出页面提示
            msg = "上传成功！";
        }else {
            msg = "上传失败！";
        }

        // 显示图片
        map.put("msg", msg);
        map.put("fileName", file.getOriginalFilename());
        request.getSession().setAttribute("fileName", file.getOriginalFilename());
        return "lostPub";
    }
	
	 /**
     * 显示单张图片
     * @return
     */
    @RequestMapping("/show{fileName}")
    @ResponseBody
    public ResponseEntity<?> showPhotos(@PathVariable String fileName){
//    	System.out.println(fileName);
    	try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            return ResponseEntity.ok(resourceLoader.getResource("file:" + path + "/" + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @RequestMapping("/fileUpload_found")
    public String upload_found(@RequestParam("image") MultipartFile file, Map<String, Object> map, HttpServletRequest request){
		// 要上传的目标文件存放路径
        String localPath = path;
        // 上传成功或者失败的提示
        String msg = "";
        if (FileUtils.upload(file, localPath, file.getOriginalFilename())){
            // 上传成功，给出页面提示
            msg = "上传成功！";
        }else {
            msg = "上传失败！";
        }

        // 显示图片
        map.put("msg", msg);
        map.put("fileName", file.getOriginalFilename());
        request.getSession().setAttribute("fileName", file.getOriginalFilename());
        return "foundPub";
    }
}
