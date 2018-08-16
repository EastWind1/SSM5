package test.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import test.entity.User;
import test.service.UserService;

@Controller
@RequestMapping("/data")
public class DataController {
	@Autowired
	private UserService userService;
	@RequestMapping("ajax")
	@ResponseBody
	public List<User> getUsers(){
		List<User> users = userService.list();
		return users;
	}
	
	/**  
     * �ļ��ϴ�����  
     * @param file  
     * @return  
     * @throws IOException   
     */  
    @RequestMapping(value="/upload",method=RequestMethod.POST)  
    @ResponseBody  
    public String upload(MultipartFile file,HttpServletRequest request) throws IOException{  
        String path = request.getSession().getServletContext().getRealPath("upload");  
        String fileName = file.getOriginalFilename();    
        File dir = new File(path,fileName);          
        if(!dir.exists()){  
            dir.createNewFile();  
        }  
        //MultipartFile�Դ��Ľ������� 
        try{
        	file.transferTo(dir);  
        }
        catch(IOException e){
        	
        }
        return "ok!";  
    }  
      
    /**  
     * �ļ����ع���  
     * @param request  
     * @param response  
     * @throws Exception  
     */  
    @RequestMapping("/down")  
    public void down(HttpServletRequest request,HttpServletResponse response,String filename) throws Exception{  
        //ģ���ļ���myfile.txtΪ��Ҫ���ص��ļ�  
        String url = request.getSession().getServletContext().getRealPath("upload")+"\\"+filename;  
        //��ȡ������  
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(url)));  
        //���������������صĻ�   
        filename = URLEncoder.encode(filename,"UTF-8");  
        //�����ļ�����ͷ  
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);    
        //1.�����ļ�ContentType���ͣ��������ã����Զ��ж������ļ�����    
        response.setContentType("multipart/form-data");   
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());  
        int len = 0;  
        while((len = bis.read()) != -1){  
            out.write(len);  
            out.flush();  
        }  
        bis.close();
        out.close();  
    }  
}
