package com.maipu.xmall.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.maipu.Xmall.bean.PmsBaseCatalog1;
import com.maipu.Xmall.bean.PmsBaseCatalog2;
import com.maipu.Xmall.bean.PmsBaseCatalog3;
import com.maipu.Xmall.service.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @title: 后台管理前台接口
 * @description: 负责管理后台相关
 * @author: Asing
 * @date: 2020-04-06 00:41:01
 */
@RestController
public class AdminController {
    @Reference
    AdminService adminService;

    @GetMapping(value = "/getCatalog1")
    public List<PmsBaseCatalog1> getCatalog1(){
        List<PmsBaseCatalog1> catalog1 = adminService.getCatalog1();
        return catalog1;
    }

    @GetMapping(value = "/getCatalog2")
    public List<PmsBaseCatalog2> getCatalog2(Integer id){
        List<PmsBaseCatalog2> catalog2 = adminService.getCatalog2(id);
        return catalog2;
    }


    @GetMapping(value = "/getCatalog3")
    public List<PmsBaseCatalog3> getCatalog3(Integer id){
        List<PmsBaseCatalog3> catalog3 = adminService.getCatalog3(id);
        return catalog3;
    }



}
