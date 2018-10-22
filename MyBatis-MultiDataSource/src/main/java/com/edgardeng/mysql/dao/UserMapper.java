package com.edgardeng.mysql.dao;

import com.edgardeng.mysql.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper  {
    User findUserWithId(Long userId);
}