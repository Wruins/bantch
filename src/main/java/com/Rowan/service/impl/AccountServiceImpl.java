package com.Rowan.service.impl;

import com.Rowan.dao.IAccountDao;
import com.Rowan.po.Account;
import com.Rowan.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Rowan
 * @Date: 2021/3/20 - 0:01
 * @Description: com.Rowan.service.impl
 * @Version: 1.0
 */
@Service("AccountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;


    @Override
    public void referMoney(String name1, String name2, Double money){
        Account reduceAccount = accountDao.findByName(name1);
        Account addAccount = accountDao.findByName(name2);
        System.out.println(reduceAccount);
        System.out.println(addAccount);
        reduceAccount.setMoney(reduceAccount.getMoney()-money);
        addAccount.setMoney(addAccount.getMoney()+money);
        accountDao.updateAccount(reduceAccount);
 //       int i=1/0;
        accountDao.updateAccount(addAccount);
        System.out.println(accountDao.findByName(name1));
        System.out.println(accountDao.findByName(name2));
    }

    @Override
    public List<Account> findAll() {
  //      System.out.println("业务层:查询所有账户");
        return accountDao.findAll();
    }

    @Override
    public Account findByName(String name) {
        return accountDao.findByName(name);
    }


    @Override
    public void saveAccount(Account account) {
 //       System.out.println("业务层:保存一个账户");
        accountDao.saveAccount(account);
    }
}
