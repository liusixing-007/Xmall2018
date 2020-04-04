package com.maipu.Xmall.dao;


import com.maipu.Xmall.bean.PmsProductInfo;
import tk.mybatis.mapper.common.Mapper;

public interface PmsProductInfoMapper extends Mapper<PmsProductInfo> {
    int deleteByPrimaryKey(Long id);

    int insert(PmsProductInfo record);

    int insertSelective(PmsProductInfo record);

    PmsProductInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsProductInfo record);

    int updateByPrimaryKey(PmsProductInfo record);
}