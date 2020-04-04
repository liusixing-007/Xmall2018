package com.maipu.Xmall.dao;


import com.maipu.Xmall.bean.PmsSkuAttrValue;
import tk.mybatis.mapper.common.Mapper;

public interface PmsSkuAttrValueMapper extends Mapper<PmsSkuAttrValue> {
    int deleteByPrimaryKey(Long id);

    int insert(PmsSkuAttrValue record);

    int insertSelective(PmsSkuAttrValue record);

    PmsSkuAttrValue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsSkuAttrValue record);

    int updateByPrimaryKey(PmsSkuAttrValue record);
}