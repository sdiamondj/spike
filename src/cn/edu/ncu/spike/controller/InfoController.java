package cn.edu.ncu.spike.controller;

import cn.edu.ncu.spike.entity.Product;
import cn.edu.ncu.spike.entity.Success_info;
import cn.edu.ncu.spike.service.ProductService;
import cn.edu.ncu.spike.service.Success_infoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/info")
public class InfoController {
    @Autowired
    private Success_infoService success_infoService;
    @Autowired
    private ProductService productService;

    @RequestMapping("/submit")
    public String submit( @RequestParam("product_id")String product_id,
                          HttpSession session, Model model){
        String username = (String)session.getAttribute("username");
        Success_info success_info = success_infoService.addSuccessInfo(product_id,username);
        if (success_info!=null){
            model.addAttribute("success_info",success_info);
            return "success";
        }
        else{
            Product product = productService.getById(product_id);
            model.addAttribute("product",product);
            return "detail";
        }
    }
}
