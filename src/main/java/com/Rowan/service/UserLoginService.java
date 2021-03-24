package com.Rowan.service;


import com.Rowan.dto.ReturnMap;
import com.Rowan.po.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserLoginService {

    List<User> findAll();

    ReturnMap<String> login(String username, String pass, HttpSession session);
}
