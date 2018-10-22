package com.edgardeng.oracle.service;

import com.edgardeng.oracle.domain.OracleUser;

public interface OracleUserService {

    OracleUser findByNameOrMobile(String username);

    OracleUser findById(Long userId);

    OracleUser findByName(String userName);

}
