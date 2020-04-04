package com.maipu.Xmall.dao;

import com.maipu.Xmall.bean.PmsBaseCatalog3;
import tk.mybatis.mapper.common.Mapper;

public interface PmsBaseCatalog3Mapper extends Mapper<PmsBaseCatalog3> {
    int deleteByPrimaryKey(Long id);

    int insert(PmsBaseCatalog3 record);

    int insertSelective(PmsBaseCatalog3 record);

    PmsBaseCatalog3 selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsBaseCatalog3 record);

    int updateByPrimaryKey(PmsBaseCatalog3 record);
}