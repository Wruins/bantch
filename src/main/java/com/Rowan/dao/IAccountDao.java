package com.Rowan.dao;

import com.Rowan.po.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Rowan
 * @Date: 2021/3/19 - 23:56
 * @Description: com.Rowan.dao
 * @Version: 1.0
 */
@Repository("accountDao")
@Mapper
public interface IAccountDao {

//    @Select("select * from account")
//    List<Account> findAll();

    List<Account> findAll();

    @Insert("insert into account(name,money) values(#{name},#{money})")
    void saveAccount(Account account);

    @Update("update account set id=#{id},name=#{name},money=#{money} where id=#{id}")
    void updateAccount(Account account);

    @Select("select * from account where name=#{name}")
    Account findByName(String name);
}
