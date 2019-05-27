package cn.edu.ncu.spike.dao;

import cn.edu.ncu.spike.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {

    int reduceNumber(@Param("product_id")String product_id);

    List<Product> getAll();

    Product getById(@Param("product_id")String product_id);
}
