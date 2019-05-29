package cn.edu.ncu.spike.service;

import cn.edu.ncu.spike.dao.ProductDao;
import cn.edu.ncu.spike.dao.Success_infoDao;
import cn.edu.ncu.spike.entity.Product;
import cn.edu.ncu.spike.entity.Success_info;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

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

    public boolean redis(@Param("product_id")String product_id,
                              @Param("username")String username){
        Jedis jedis = new Jedis("localhost");
        Product product = productDao.getById(product_id);
        int num = product.getNumber();
        List<String> list = jedis.lrange(product_id,0,num-1);
        int suc;
        if(jedis.get(product_id+"successs")==null)
            suc = 0;
        else
            suc = Integer.parseInt(jedis.get(product_id+"success"));
        if(list.size()<num+suc){
            int flag = 0;
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).equals(username)){
                    flag = 1;
                    break;
                }
            }
            if (flag == 0){
                jedis.lpush(product_id,username);
                jedis.close();
                return true;
            }
            else {
                jedis.close();
                return false;
            }
        }
        else {
            jedis.close();
            return false;
        }
    }


    @Transactional(rollbackFor=RuntimeException.class)
    public Success_info addSuccessInfo(@Param("product_id")String product_id,
                       @Param("username")String username){
        try{
            if(success_infoDao.addSuccessInfo(product_id,username) <= 0){
                throw new RuntimeException("重复秒杀!");
            }
            else{
                if(productDao.reduceNumber(product_id)<=0){
                    throw new RuntimeException("库存不足!");
                }
                else{
                    Jedis jedis = new Jedis("localhost");
                    if(jedis.get(product_id+"success")==null)
                        jedis.set(product_id+"success",0+"");
                    jedis.set(product_id+"success",(Integer.parseInt(jedis.get(product_id+"success"))+1)+"");
                    jedis.close();
                    return success_infoDao.getSuccessInfo(product_id,username);
                }
            }
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
