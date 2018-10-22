package com.edgardeng.oracle.dao;

import com.edgardeng.oracle.domain.OracleUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OracleUserMapper {
    OracleUser findUserWithId(Long userId);
}