package cn.edu.ncu.spike.dao;

import cn.edu.ncu.spike.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    int register(@Param("username")String username,@Param("password")String password);

    User login(@Param("username")String username,@Param("password")String password);
}
