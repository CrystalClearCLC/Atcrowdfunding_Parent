package com.clc.atcrowdfunding.controller;

import com.clc.atcrowdfunding.bean.User;
import com.clc.atcrowdfunding.manager.service.UserService;
import com.clc.atcrowdfunding.util.AjaxResult;
import com.clc.atcrowdfunding.util.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
/*@RequestMapping("/dispatcher")*/
public class DispatcherController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index.htm")
    public String index(){
        return "index";
    }
    @RequestMapping("/login.htm")
    public String login(){
        return "login";
    }
    @RequestMapping("/main.htm")
    public String main(){
        return "main";
    }

    //异步请求
   //结合JSON组件，奖返回结果转换为字符串，将JSON流的形式返回给客户端
    @ResponseBody
    @RequestMapping("/doLogin.do")
    public Object dologin(@RequestParam(name = "loginacct",required = true) String username,
                          @RequestParam(name = "userpswd",required = true) String password,
                          @RequestParam(name = "type",required = true) String type,
                          HttpSession session){

        System.out.println("doLogin");

        AjaxResult result= null;
        try {
            result = new AjaxResult();
            Map<String,Object> paramMap =new HashMap<String,Object>();
            paramMap.put("username",username);
            paramMap.put("password",password);
            paramMap.put("type",type);
            User user=userService.queryUserLogin(paramMap);

            session.setAttribute(Const.LOGIN_USER,user);
            result.setSuccess(true);
            //{"success":true}
        } catch (Exception e) {
            result.setMessage("LoginError");
            e.printStackTrace();
            result.setSuccess(false);
        }
        System.out.println(result);
        return result;

         /*ModelAndView mv=new ModelAndView();
        return mv;*/
    }

  /*  //同步请求
    @RequestMapping("/doLogin.do")
    public String dologin(@RequestParam(name = "loginacct",required = true) String username,
                                @RequestParam(name = "userpswd",required = true) String password,
                                @RequestParam(name = "type",required = true) String type,
                                HttpSession session){
        //不进行参数绑定的话  只需要奖参数名和表单保持一致即可
        Map<String,Object> paramMap =new HashMap<String,Object>();
        paramMap.put("username",username);
        paramMap.put("password",password);
        paramMap.put("type",type);
        User user=userService.queryUserLogin(paramMap);

        session.setAttribute(Const.LOGIN_USER,user);
        return "redirect:/main.htm";

        *//*ModelAndView mv=new ModelAndView();
        return mv;*//*
    }*/
}
