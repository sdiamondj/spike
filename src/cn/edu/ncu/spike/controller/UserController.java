package cn.edu.ncu.spike.controller;

import cn.edu.ncu.spike.entity.Product;
import cn.edu.ncu.spike.entity.Success_info;
import cn.edu.ncu.spike.service.ProductService;
import cn.edu.ncu.spike.service.Success_infoService;
import cn.edu.ncu.spike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private Success_infoService success_infoService;
    @Autowired
    private ProductService productService;

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
                        @RequestParam("password")String password,
                        HttpSession session){
        if(userService.login(username,password)!=null) {
            session.setAttribute("username",username);
            return "redirect:/product/main";
        }
        else
            return "index";
    }

    @RequestMapping(value = "/my/{username}",method = RequestMethod.GET)
    public String my(@PathVariable("username")String username, Model model){
        List<Success_info> success_infos = success_infoService.getByUser(username);
        model.addAttribute("info",success_infos);
        return "success";
    }
}
