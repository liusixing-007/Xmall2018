package com.maipu.Xmall.dao;


import com.maipu.Xmall.bean.PmsSkuInfo;
import tk.mybatis.mapper.common.Mapper;

public interface PmsSkuInfoMapper extends Mapper<PmsSkuInfo> {
    int deleteByPrimaryKey(Long id);

    int insert(PmsSkuInfo record);

    int insertSelective(PmsSkuInfo record);

    PmsSkuInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsSkuInfo record);

    int updateByPrimaryKey(PmsSkuInfo record);
}