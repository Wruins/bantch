package com.Rowan.test;

import com.Rowan.dao.IAccountDao;
import com.Rowan.po.Account;
import com.Rowan.service.IAccountService;
import com.Rowan.service.impl.AccountServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Rowan
 * @Date: 2021/3/20 - 0:14
 * @Description: com.Rowan.test
 * @Version: 1.0
 */
public class test {



    private Account account = new Account();

    @Test
    public void spring() {
        //加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //获取对象
        IAccountService as = ac.getBean(IAccountService.class);
        //调用方法
        List<Account> accounts = as.findAll();
    }

    @Test
    public void mybatis() throws Exception {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession(true);
        IAccountDao accountDao = session.getMapper(IAccountDao.class);
        /*account.setName("薛总");
        account.setMoney(10000d);
        accountDao.saveAccount(account);
        System.out.println("存薛总成功");
        account.setName("海总");
        account.setMoney(10001d);
        accountDao.saveAccount(account);
        System.out.println("存海总成功");*/
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts)
            System.out.println(account);
    }



}
