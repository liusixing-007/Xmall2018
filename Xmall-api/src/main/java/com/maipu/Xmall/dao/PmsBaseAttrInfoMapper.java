package com.maipu.Xmall.dao;


import com.maipu.Xmall.bean.PmsBaseAttrInfo;
import tk.mybatis.mapper.common.Mapper;

public interface PmsBaseAttrInfoMapper extends Mapper<PmsBaseAttrInfo> {
    int deleteByPrimaryKey(Long id);

    int insert(PmsBaseAttrInfo record);

    int insertSelective(PmsBaseAttrInfo record);

    PmsBaseAttrInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsBaseAttrInfo record);

    int updateByPrimaryKey(PmsBaseAttrInfo record);
}