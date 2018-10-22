package com.edgardeng.controller;

import com.edgardeng.oracle.domain.OracleUser;
import com.edgardeng.oracle.service.OracleUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class OracleUserController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private static final String ON = "on";

    @Autowired
    private OracleUserService oracleUserService;

    @RequestMapping(value = "oracle/user/check", method = RequestMethod.GET)
    @ResponseBody
    public String checkUserName(@RequestParam String username) {

        OracleUser result = this.oracleUserService.findByName(username);
        return result == null ? result.toString():"error";
    }

    @RequestMapping(value = "oracle/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public OracleUser info(@PathVariable Long id) {
        try {
            OracleUser user = this.oracleUserService.findById(id);
            return user;
        } catch (Exception e) {
            log.error("获取用户失败", e);
            return null;
        }
    }


}
