package com.maipu.Xmall.dao;


import com.maipu.Xmall.bean.PmsSkuImage;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

public interface PmsSkuImageMapper extends Mapper<PmsSkuImage> {
    int deleteByPrimaryKey(Long id);

    int insert(PmsSkuImage record);

    int insertSelective(PmsSkuImage record);

    PmsSkuImage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsSkuImage record);

    int updateByPrimaryKey(PmsSkuImage record);
}