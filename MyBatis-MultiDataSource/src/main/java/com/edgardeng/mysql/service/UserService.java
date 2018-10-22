package com.edgardeng.mysql.service;


import com.edgardeng.mysql.domain.User;
public interface UserService {

    User findByNameOrMobile(String username);

    User findById(Long userId);

    User findByName(String userName);

}
