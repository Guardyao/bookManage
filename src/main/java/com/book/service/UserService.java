package com.book.service;

import javax.servlet.http.HttpSession;

public interface UserService {
    //判断登录
    boolean auth(String username, String password, HttpSession session);
    boolean register(String username,String nickname,String password);
}
