package cn.edu.ncu.spike.service;

import cn.edu.ncu.spike.dao.ProductDao;
import cn.edu.ncu.spike.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    public int reduceNumber(@Param("product_id")String product_id){
        return productDao.reduceNumber(product_id);
    }

    public List<Product> getAll(){
        return productDao.getAll();
    }

    public Product getById(@Param("product_id")String product_id){
        return productDao.getById(product_id);
    }

}
