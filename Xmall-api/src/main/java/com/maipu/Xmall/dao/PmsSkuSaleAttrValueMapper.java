package com.maipu.Xmall.dao;


import com.maipu.Xmall.bean.PmsSkuSaleAttrValue;
import tk.mybatis.mapper.common.Mapper;

public interface PmsSkuSaleAttrValueMapper extends Mapper<PmsSkuSaleAttrValue> {
    int deleteByPrimaryKey(Long id);

    int insert(PmsSkuSaleAttrValue record);

    int insertSelective(PmsSkuSaleAttrValue record);

    PmsSkuSaleAttrValue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsSkuSaleAttrValue record);

    int updateByPrimaryKey(PmsSkuSaleAttrValue record);
}