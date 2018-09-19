package com.edgardeng.sbfirst.controller;

import com.edgardeng.sbfirst.bean.ProjectProperties;
import com.edgardeng.sbfirst.bean.User;
import com.edgardeng.sbfirst.mapper.UserMapper;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@EnableAutoConfiguration
public class WebController {

    @Autowired
    private ProjectProperties projectProperties;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/")
    private String index() {
        return "hello,spring boot. --- " + projectProperties.getAuthor();
    }

    @RequestMapping("/users")
    public ModelAndView users() {
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("name", "用户列表");
        String names[] = {"wang","qian","li"};

        modelAndView.addObject("users", userMapper.getAllUsers());
        return modelAndView;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user) {
        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        // users.put(user.getId(), user);
        return "success";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Integer id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
//        return users.get(id);
        User user = userMapper.getUser(id);
        return user;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息
//        User u = users.get(id);
//        u.setName(user.getName());
//        u.setAge(user.getAge());
//        users.put(id, u);
        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
//        users.remove(id);
        return "success";
    }


}
