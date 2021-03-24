package com.Rowan.service;

import com.Rowan.po.Account;

import java.util.List;

/**
 * @Author: Rowan
 * @Date: 2021/3/19 - 23:59
 * @Description: com.Rowan.service
 * @Version: 1.0
 */
public interface IAccountService {

    List<Account> findAll();

    Account findByName(String name);

    void saveAccount(Account account);

    //转账name1-money,name2+money
    void referMoney(String name1,String name2,Double money);
}
