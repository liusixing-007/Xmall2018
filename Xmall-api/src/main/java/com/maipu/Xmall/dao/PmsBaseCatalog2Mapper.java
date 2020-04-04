package com.maipu.Xmall.dao;


import com.maipu.Xmall.bean.PmsBaseCatalog2;
import tk.mybatis.mapper.common.Mapper;

public interface PmsBaseCatalog2Mapper extends Mapper<PmsBaseCatalog2> {
    int deleteByPrimaryKey(Integer id);

    int insert(PmsBaseCatalog2 record);

    int insertSelective(PmsBaseCatalog2 record);

    PmsBaseCatalog2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PmsBaseCatalog2 record);

    int updateByPrimaryKey(PmsBaseCatalog2 record);
}