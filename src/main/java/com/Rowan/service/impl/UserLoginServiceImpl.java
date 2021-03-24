package com.Rowan.service.impl;

import com.Rowan.dao.UserDao;
import com.Rowan.dto.ReturnMap;
import com.Rowan.po.User;
import com.Rowan.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public ReturnMap<String> login(String username, String pass, HttpSession session) {
        ReturnMap<String> rm = new ReturnMap<>();
        User user = new User();
        user.setStaffId(username);
        user.setStaffPassword(pass);
        rm.setCode(userDao.login(user)>0?0:1);
        rm.setMsg(rm.getCode()==0?"登录成功~":"用户名或密码错误!");
        if (rm.getCode()==0){
            session.setAttribute("user",userDao.findLoginUser(user.getStaffId()));
        }
        return rm;
    }
}
