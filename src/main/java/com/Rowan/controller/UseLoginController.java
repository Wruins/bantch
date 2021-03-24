package com.Rowan.controller;

import com.Rowan.dto.ReturnMap;
import com.Rowan.service.UserLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class UseLoginController {
    @Autowired
    private UserLoginService userLoginService;
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @PostMapping("/login")
    @ResponseBody
    public ReturnMap<String> login(String username, String pass, HttpSession session) {
        return userLoginService.login(username, pass, session);
    }

    @RequestMapping("/loginSuccess")
    public String toIndex() {
        return "index";
    }

    @GetMapping("/login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:login";
    }

}
