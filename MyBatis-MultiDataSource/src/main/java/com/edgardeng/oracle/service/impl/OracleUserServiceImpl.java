package com.edgardeng.oracle.service.impl;
import com.edgardeng.oracle.dao.OracleUserMapper;
import com.edgardeng.oracle.domain.OracleUser;
import com.edgardeng.oracle.service.OracleUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service("oracleUserService")
//@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OracleUserServiceImpl implements OracleUserService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public OracleUser findByNameOrMobile(String var) {
        Example example = new Example(OracleUser.class);
        boolean isMobile = false;
        if (isMobile) {
            example.createCriteria().andCondition("mobile=", var);
        } else {
            example.createCriteria().andCondition("lower(username)=", var.toLowerCase());
        }
        List<OracleUser> list = new ArrayList<>();// userMapper.se.(example);
        return list.isEmpty() ? null : list.get(0);
    }

    @Autowired
    private OracleUserMapper userMapper;

    @Override
    public OracleUser findByName(String userName) {
        Example example = new Example(OracleUser.class);
        example.createCriteria().andCondition("lower(username)=", userName.toLowerCase());
        List<OracleUser> list = new ArrayList<>(); // this.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public
    OracleUser findById(Long userId) {
        return userMapper.findUserWithId(userId);
    }

}
