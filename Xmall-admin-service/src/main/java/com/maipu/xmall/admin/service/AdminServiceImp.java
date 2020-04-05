package com.maipu.xmall.admin.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.maipu.Xmall.bean.PmsBaseCatalog1;
import com.maipu.Xmall.bean.PmsBaseCatalog2;
import com.maipu.Xmall.bean.PmsBaseCatalog3;
import com.maipu.Xmall.service.AdminService;
import com.maipu.xmall.admin.mapper.BaseCatalog1Mapper;
import com.maipu.xmall.admin.mapper.BaseCatalog2Mapper;
import com.maipu.xmall.admin.mapper.BaseCatalog3Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @title: 后台管理服务实现类
 * @description: 实现相关服务
 * @author: Asing
 * @date: 2020-04-06 01:02:02
 */
@Service
public class AdminServiceImp implements AdminService {

    @Autowired
    private BaseCatalog1Mapper baseCatalog1Mapper;
    @Autowired
    private BaseCatalog2Mapper baseCatalog2Mapper;
    @Autowired
    private BaseCatalog3Mapper baseCatalog3Mapper;
    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        List<PmsBaseCatalog1> pmsBaseCatalog1s = baseCatalog1Mapper.selectAll();
        return pmsBaseCatalog1s;
    }

    @Override
    public List<PmsBaseCatalog2> getCatalog2(Integer id) {
        List<PmsBaseCatalog2> pmsBaseCatalog2s = baseCatalog2Mapper.selectAll();
        return pmsBaseCatalog2s;
    }

    @Override
    public List<PmsBaseCatalog3> getCatalog3(Integer id) {
        List<PmsBaseCatalog3> pmsBaseCatalog3s = baseCatalog3Mapper.selectAll();
        return pmsBaseCatalog3s;
    }

}
