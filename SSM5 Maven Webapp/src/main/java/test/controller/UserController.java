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
    public ModelAndView toIndex(HttpServletRequest request, ModelAndView model) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        model = new ModelAndView("showUser", "user", user);
        /* 或写为
         * model = new ModelAndView("showUser");
         * model.addObject("user",user);
         *
         * 或者
         * model = new ModelAndView();
         * model.setViewName("showUser");
         * model.addObject("user",user);
         */
        return model;
        /*
         * 此处可采用多种方式实现跳转与传值
         * 注：重定向发生在客户端，表示去访问另一个地址；转发表示将转向地址内容传输至当前位置
         * 1、重定向方法
         * public void toIndex(HttpServletRequest request)
         * ......
         * request.setAttribute("user", user);
         * request.getRequestDispatcher("showUser.jsp").forward(request, response);
         * 2、转发方法
         * public String toIndex(ModelMap modelMap){
         * ......
         * modelMap.addAttribute("user", user);
         * return "showUser";
         * 3、转发方法
         * public String toIndex(Model model){
         * ......
         * model.addAttribute("user", user);
         * return "showUser";
         * 4、重定向方法
         * public void down(HttpServletResponse response, ModelMap model)
         * 。。。。。。
         * modelMap.addAttribute("user", user);
         * response.sendRedirect("error");
         * 5、注解实现（此注解若位于方法之上，表示控制器默认加载该方法）
         * public String toIndex(@ModelAttribute("user") User user){
         * ......
         * return "showUser";
         *
         * 注：方法头包含@ResponseBody表示该方法返回值加入至http响应中，若返回值为String，则不会被解析为跳转路径，一般用于Ajax请求方法之上。
         */
    }

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password, ModelAndView model) {
        User user = this.userService.getUserByUserName(username);
        if (user != null)
            if (user.getPassword().equals(password))
                model = new ModelAndView("showUser", "user", user);

        return model;
    }

    @RequestMapping("/newlogin")
    @ResponseBody
    public boolean newlogin(@RequestBody User user) {
        boolean result = false;
        User localuser = this.userService.getUserByUserName(user.getUserName());
        if (localuser != null)
            if (localuser.getPassword().equals(user.getPassword()))
                result = true;

        return result;
    }

    @RequestMapping("/zhuce")
    public ModelAndView zhuce(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("age") Integer age) {
        ModelAndView m = null;
        if (userService.newUser(username, password, age) == 1) {
            m = new ModelAndView("index");
        }
        return m;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public int add(@RequestBody User user) { //@RequestBody 常用于解析json
        int result = 0;
        if (!user.getUserName().equals("") && userService.getUserByUserName(user.getUserName()) == null) {
            userService.newUser(user);
            result = user.getId();
        }

        return result;
    }

    @RequestMapping(value = "/isExist")
    @ResponseBody
    public boolean isExist(String username) {
        boolean result = true;
        try {
            userService.getUserByUserName(username).getId();
            result = true;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    @RequestMapping("/list")
    public ModelAndView listUser(UserList allUser, ModelAndView model) {
        allUser.setList(userService.list());
        model = new ModelAndView("List", "UserList", allUser.getList());
        return model;


    }

}