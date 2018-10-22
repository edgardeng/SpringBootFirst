package com.edgardeng.mysql.service.impl;
import com.edgardeng.mysql.dao.UserMapper;
import com.edgardeng.mysql.domain.User;
import com.edgardeng.mysql.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
//@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public User findByNameOrMobile(String var) {
        Example example = new Example(User.class);
        boolean isMobile = false;
        if (isMobile) {
            example.createCriteria().andCondition("mobile=", var);
        } else {
            example.createCriteria().andCondition("lower(username)=", var.toLowerCase());
        }
        List<User> list = new ArrayList<>();// userMapper.se.(example);
        return list.isEmpty() ? null : list.get(0);
    }

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByName(String userName) {
        Example example = new Example(User.class);
        example.createCriteria().andCondition("lower(username)=", userName.toLowerCase());
        List<User> list = new ArrayList<>(); // this.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public
    User findById(Long userId) {
        return userMapper.findUserWithId(userId);
    }

}
