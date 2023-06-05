package com.book.mapper;

import com.book.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from admin where username = #{username} and password = #{password}")
    User getUser(@Param("username") String username, @Param("password") String password);


    @Select("select * from admin where username = #{username}")
    User getUserByName(String username);
    @Insert("insert into admin(username,nickname,password) value(#{username},#{nickname},#{password})")
    void addUser(@Param("username")String username, @Param("nickname")String nickname, @Param("password")String password);
}
