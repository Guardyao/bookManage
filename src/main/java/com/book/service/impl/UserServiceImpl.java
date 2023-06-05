package com.book.service.impl;

import com.book.entity.User;
import com.book.mapper.UserMapper;
import com.book.service.UserService;
import com.book.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.http.HttpSession;

public class UserServiceImpl implements UserService {
    @Override
    public boolean register(String username, String nickname, String password) {
        try (SqlSession session = MybatisUtil.getSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.getUserByName(username);
            if (user != null) {
                return false;
            } else {
                mapper.addUser(username,nickname,password);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean auth(String username, String password, HttpSession session) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUser(username,password);
            if (user == null) return false;
            session.setAttribute("user",user);
            return true;
        }
    }
}
