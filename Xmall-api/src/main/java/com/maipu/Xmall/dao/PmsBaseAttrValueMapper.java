package com.maipu.Xmall.dao;

import com.maipu.Xmall.bean.PmsBaseAttrValue;
import tk.mybatis.mapper.common.Mapper;

public interface PmsBaseAttrValueMapper extends Mapper<PmsBaseAttrValue> {
    int deleteByPrimaryKey(Long id);

    int insert(PmsBaseAttrValue record);

    int insertSelective(PmsBaseAttrValue record);

    PmsBaseAttrValue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsBaseAttrValue record);

    int updateByPrimaryKey(PmsBaseAttrValue record);
}