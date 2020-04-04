package com.maipu.Xmall.dao;


import com.maipu.Xmall.bean.PmsProductSaleAttr;
import tk.mybatis.mapper.common.Mapper;

public interface PmsProductSaleAttrMapper extends Mapper<PmsProductSaleAttr> {
    int deleteByPrimaryKey(Long id);

    int insert(PmsProductSaleAttr record);

    int insertSelective(PmsProductSaleAttr record);

    PmsProductSaleAttr selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsProductSaleAttr record);

    int updateByPrimaryKey(PmsProductSaleAttr record);
}