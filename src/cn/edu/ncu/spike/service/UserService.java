package cn.edu.ncu.spike.service;

import cn.edu.ncu.spike.dao.UserDao;
import cn.edu.ncu.spike.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public int register(@Param("username")String username,@Param("password")String password){
        return userDao.register(username,password);
    }

    public User login(@Param("username")String username,@Param("password")String password){
        return userDao.login(username,password);
    }

}
