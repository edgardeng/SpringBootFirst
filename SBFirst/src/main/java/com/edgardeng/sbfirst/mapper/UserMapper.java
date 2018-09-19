package com.edgardeng.sbfirst.mapper;

import com.edgardeng.sbfirst.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.LinkedList;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user")
    LinkedList<User> getAllUsers();

    @Insert("INSERT INTO user (name, mail) VALUES(#{name}, #{mail})")
    int insert(@Param("name") String name,
               @Param("mail") String mail);

    @Select("select * FROM user WHERE id = #{id}")
    User getUser(@Param("id") Integer id);

    @Update("UPDATE user SET name = #{name} WHERE id = #{id}")
    void updateUser(@Param("id") String id, @Param("name") String name);

    @Delete("DELETE FROM user WHERE id = #{id}")
    void deleteUser(User user);

}