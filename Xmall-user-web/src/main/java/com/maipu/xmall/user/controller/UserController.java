package com.maipu.xmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.maipu.Xmall.bean.UmsMember;
import com.maipu.Xmall.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @title: 用户服务web
 * @description:
 * @author: Asing
 * @date: 2020-04-05 12:09:34
 */
@RestController
public class UserController {
    @Reference()
    UserService userService;

    @GetMapping(value = "getAllUser")
    public List<UmsMember> getAll(){
        List<UmsMember> allMembers = userService.getAllMembers();
        return allMembers;
    }

}
