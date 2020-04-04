package com.maipu.Xmall.dao;


import com.maipu.Xmall.bean.PmsProductImage;
import tk.mybatis.mapper.common.Mapper;

public interface PmsProductImageMapper extends Mapper<PmsProductImage> {
    int deleteByPrimaryKey(Long id);

    int insert(PmsProductImage record);

    int insertSelective(PmsProductImage record);

    PmsProductImage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsProductImage record);

    int updateByPrimaryKey(PmsProductImage record);
}