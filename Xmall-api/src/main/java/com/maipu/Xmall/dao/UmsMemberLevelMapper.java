package com.maipu.Xmall.dao;


import com.maipu.Xmall.bean.UmsMemberLevel;
import tk.mybatis.mapper.common.Mapper;

public interface UmsMemberLevelMapper extends Mapper<UmsMemberLevel> {
    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberLevel record);

    int insertSelective(UmsMemberLevel record);

    UmsMemberLevel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsMemberLevel record);

    int updateByPrimaryKey(UmsMemberLevel record);
}