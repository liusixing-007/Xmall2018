package com.maipu.Xmall.dao;


import com.maipu.Xmall.bean.PmsBaseCatalog1;
import tk.mybatis.mapper.common.Mapper;

public interface PmsBaseCatalog1Mapper extends Mapper<PmsBaseCatalog1> {
    int deleteByPrimaryKey(Integer id);

    int insert(PmsBaseCatalog1 record);

    int insertSelective(PmsBaseCatalog1 record);

    PmsBaseCatalog1 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PmsBaseCatalog1 record);

    int updateByPrimaryKey(PmsBaseCatalog1 record);
}