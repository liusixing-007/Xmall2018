package com.maipu.Xmall.dao;


import com.maipu.Xmall.bean.PmsProductSaleAttrValue;
import tk.mybatis.mapper.common.Mapper;

public interface PmsProductSaleAttrValueMapper extends Mapper<PmsProductSaleAttrValue> {
    int deleteByPrimaryKey(Long id);

    int insert(PmsProductSaleAttrValue record);

    int insertSelective(PmsProductSaleAttrValue record);

    PmsProductSaleAttrValue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsProductSaleAttrValue record);

    int updateByPrimaryKey(PmsProductSaleAttrValue record);
}