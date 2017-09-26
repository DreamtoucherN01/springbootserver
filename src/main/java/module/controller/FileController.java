package module.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import module.bean.Customer;
import module.service.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping(value = "/file")
public class FileController
{
	
	public static String PATH = "/root/server/m-mall-admin-master/public/web/picture/";
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String toLogin(@RequestParam("name") String name,  
            @RequestParam("file") MultipartFile file) {
		
		if (!file.isEmpty()) {  
            try {  
            	if(file.getSize() > 5000000)
            		return " 上传失败，图片尺寸过大";
                byte[] bytes = file.getBytes();  
                File f = new File(PATH + name + ".jpg");
                if(f.exists()) f.delete();
                System.out.println(f.getAbsolutePath());
                BufferedOutputStream stream =  new BufferedOutputStream(new FileOutputStream(f));  
                stream.write(bytes);  
                stream.close();  
                return "You successfully uploaded " + name + " into " + name + ".jpg ! "
                		+ "+\r\n please accsess the file by url https://84251159.sysfashionxiaoziyi.com/web/picture/"+name+".jpg" ;  
            } catch (Exception e) {  
                return "You failed to upload " + name + " => " + e.getMessage();  
            }  
        } else {  
            return "You failed to upload " + name + " because the file was empty.";  
        }  
	}
	
}
