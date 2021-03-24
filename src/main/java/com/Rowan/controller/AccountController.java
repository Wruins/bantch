package com.Rowan.controller;

import com.Rowan.po.Account;
import com.Rowan.service.IAccountService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: Rowan
 * @Date: 2021/3/20 - 0:03
 * @Description: com.Rowan.controller
 * @Version: 1.0
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;
    private Logger logger = LogManager.getLogger(this.getClass().getName());

    @RequestMapping("/findAll")
    public String findAll(Model model){
        logger.info("测试");
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts",accounts);
        System.out.println("mybatis+ss环境整合成功");
        return "success";
    }

    @RequestMapping("/save")
    public String saveAccount(Account account){
        accountService.saveAccount(account);
        return "redirect:/account/findAll";
    }

    /**
     * 转账测试事务控制
     * name1的用户给name2的用户转1000块钱
     * @return
     */
    @RequestMapping("/refer")
    public String refer(String name1,String name2,Model model){
        Account reduceAccount = accountService.findByName(name1);
        Account addAccount = accountService.findByName(name2);
        model.addAttribute("reduceAccount1",reduceAccount);
        model.addAttribute("addAccount1",addAccount);
        accountService.referMoney(name1,name2,1000d);
        reduceAccount = accountService.findByName(name1);
        addAccount = accountService.findByName(name2);
        model.addAttribute("reduceAccount2",reduceAccount);
        model.addAttribute("addAccount2",addAccount);
        return "referInfo";
    }

}
