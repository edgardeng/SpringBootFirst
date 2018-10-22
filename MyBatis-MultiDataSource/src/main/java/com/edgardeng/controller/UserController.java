package com.edgardeng.controller;

import com.edgardeng.mysql.domain.User;
import com.edgardeng.mysql.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController  {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "user/check", method = RequestMethod.GET)
    @ResponseBody
    public String checkUserName(@RequestParam String username) {

        User result = this.userService.findByName(username);
        return result == null ? result.toString():"error";
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User info(@PathVariable Long id) {
        try {
            User user = this.userService.findById(id);
            return user;
        } catch (Exception e) {
            log.error("获取用户失败", e);
            return null;
        }
    }


}
