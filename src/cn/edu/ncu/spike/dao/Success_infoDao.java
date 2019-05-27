package cn.edu.ncu.spike.dao;

import cn.edu.ncu.spike.entity.Success_info;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Success_infoDao {
    int addSuccessInfo(@Param("product_id")String product_id,
                       @Param("username")String username);

    Success_info getSuccessInfo(@Param("product_id")String product_id
            ,@Param("username")String username);
}
