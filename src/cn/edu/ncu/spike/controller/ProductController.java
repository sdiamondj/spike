package cn.edu.ncu.spike.controller;

import cn.edu.ncu.spike.entity.Product;
import cn.edu.ncu.spike.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/main")
    public String getAll(Model model){
        List<Product> products = productService.getAll();
        model.addAttribute("products",products);
        return "main";
    }

    @RequestMapping("/detail")
    public String productDetail(
            Model model, @RequestParam("product_id")String product_id){
        Product product = productService.getById(product_id);
        model.addAttribute("product",product);
        return "detail";
    }
}
