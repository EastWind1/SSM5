package test.controller;


import javax.annotation.Resource;  
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import test.entity.User;
import test.entity.UserList;
import test.service.UserService;
  
  
@Controller  
@RequestMapping("/user")  
public class UserController {  
    @Resource 	
    private UserService userService;  
      
    @RequestMapping("/showUser")  
    public ModelAndView toIndex(HttpServletRequest request,ModelAndView model){  
        int userId = Integer.parseInt(request.getParameter("id"));  
        User user = this.userService.getUserById(userId);  
        model = new ModelAndView("showUser","user",user);
        /* ��дΪ
       	 * model = new ModelAndView("showUser");
       	 * model.addObject("user",user);
       	 * 
       	 * ����
       	 * model = new ModelAndView();
       	 * model.setViewName("showUser");
       	 * model.addObject("user",user);
       	 */
        return model;
        /*
         * �˴��ɲ��ö��ַ�ʽʵ����ת�봫ֵ
         * ע���ض������ڿͻ��ˣ���ʾȥ������һ����ַ��ת����ʾ��ת���ַ���ݴ�������ǰλ��
         * 1���ض��򷽷�
         * public void toIndex(HttpServletRequest request)
         * ......
         * request.setAttribute("user", user);
         * request.getRequestDispatcher("showUser.jsp").forward(request, response);
         * 2��ת������
         * public String toIndex(ModelMap modelMap){
         * ......
         * modelMap.addAttribute("user", user);
         * return "showUser";
         * 3��ת������
         * public String toIndex(Model model){
         * ......
         * model.addAttribute("user", user);
         * return "showUser";
         * 4���ض��򷽷�
         * public void down(HttpServletResponse response, ModelMap model)
         * ������������
         * modelMap.addAttribute("user", user);
         * response.sendRedirect("error");
         * 5��ע��ʵ�֣���ע����λ�ڷ���֮�ϣ���ʾ������Ĭ�ϼ��ظ÷�����
         * public String toIndex(@ModelAttribute("user") User user){
         * ......
         * return "showUser";
         * 
         * ע������ͷ����@ResponseBody��ʾ�÷�������ֵ������http��Ӧ�У�������ֵΪString���򲻻ᱻ����Ϊ��ת·����һ������Ajax���󷽷�֮�ϡ�
         */
    }  
    @RequestMapping("/login")  
    public ModelAndView login(@RequestParam("username")String username,@RequestParam("password")String password,ModelAndView model){   
    	User user = this.userService.getUserByUserName(username);
        if(user!=null)
        	if(user.getPassword().equals(password))
        		model = new ModelAndView("showUser","user",user);
        
        return model;
    }  
    @RequestMapping("/newlogin")  
    @ResponseBody
    public boolean newlogin(@RequestBody User user){   
    	boolean result = false;
    	User localuser = this.userService.getUserByUserName(user.getUserName());
        if(localuser!=null)
        	if(localuser.getPassword().equals(user.getPassword()))
        		result = true;
        
        return result;
    } 
    @RequestMapping("/zhuce")  
    public ModelAndView zhuce(@RequestParam("username")String username,@RequestParam("password")String password,@RequestParam("age") Integer age){   
	   ModelAndView m = null;
        if(userService.newUser(username, password,age)==1){
        	m = new ModelAndView("index");
        }
      return m;
   } 	
   @RequestMapping(value="/add",method=RequestMethod.POST)  
   @ResponseBody
   public int add(@RequestBody User user){ //@RequestBody �����ڽ���json
	   int result = 0;
	   if (!user.getUserName().equals("") && userService.getUserByUserName(user.getUserName())==null){
		   userService.newUser(user);
		   result = user.getId();
	   }
			 
	   return result;
  } 	
   @RequestMapping(value="/isExist")  
   @ResponseBody
   public boolean isExist(String username){ 
	   boolean result = true;
	   try{
		   userService.getUserByUserName(username).getId();
		   result = true;
	   }
	   catch (Exception e){
		   result = false;
	   }
	   return result;
  } 	
   @RequestMapping("/list")
   public ModelAndView listUser(UserList allUser,ModelAndView model){
	   allUser.setList(userService.list());
	   model= new ModelAndView("List","UserList",allUser.getList());
	   return model;

	   
   }
    
}  
