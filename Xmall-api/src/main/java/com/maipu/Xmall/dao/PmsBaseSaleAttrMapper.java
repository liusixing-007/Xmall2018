package com.maipu.Xmall.dao;

import com.maipu.Xmall.bean.PmsBaseSaleAttr;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import tk.mybatis.mapper.common.Mapper;

public interface PmsBaseSaleAttrMapper extends Mapper<PmsBaseSaleAttr> {
    int deleteByPrimaryKey(Long id);

    int insert(PmsBaseSaleAttr record);

    int insertSelective(PmsBaseSaleAttr record);

    PmsBaseSaleAttr selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsBaseSaleAttr record);

    int updateByPrimaryKey(PmsBaseSaleAttr record);
}