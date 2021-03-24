package com.Rowan.dao;

import com.Rowan.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserDao {

    @Select("select * from uos_staff")
    List<User>  findAll();

    @Select("select count(0) from uos_staff where staff_id=#{staffId} and staff_password=#{staffPassword}")
    int login(User user);

    @Select("select id, staff_id, staff_name, staff_sex, staff_age, staff_address, staff_iphone, staff_avator from uos_staff where staff_id=#{staffId}")
    User findLoginUser(String staffId);
}
