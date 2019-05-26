package cn.edu.ncu.spike.controller;

import cn.edu.ncu.spike.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(@RequestParam("username")String username,
                           @RequestParam("password")String password){
        if(userService.register(username,password)!= 0)
            return "index";
        else
            return  "register";
    }

    @RequestMapping("/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password){
        if(userService.login(username,password)!=null)
            return "main";
        else
            return "index";
    }
}
