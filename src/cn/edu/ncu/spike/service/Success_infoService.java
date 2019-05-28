package cn.edu.ncu.spike.service;

import cn.edu.ncu.spike.dao.ProductDao;
import cn.edu.ncu.spike.dao.Success_infoDao;
import cn.edu.ncu.spike.entity.Success_info;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Success_infoService {
    @Autowired
    private Success_infoDao success_infoDao;
    @Autowired
    private ProductDao productDao;

    public List<Success_info> getByUser(@Param("username")String username){
        return success_infoDao.getByUser(username);
    }

    @Transactional(rollbackFor=RuntimeException.class)
    public Success_info addSuccessInfo(@Param("product_id")String product_id,
                       @Param("username")String username){
        try{
            if(productDao.reduceNumber(product_id)<=0){
                throw new RuntimeException("库存不足!");
            }
            else{
                if(success_infoDao.addSuccessInfo(product_id,username) <= 0){
                    throw new RuntimeException("重复秒杀!");
                }
                else{
                     return success_infoDao.getSuccessInfo(product_id,username);
                }
            }
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
