package com.maipu.xmall.user.dao;


import com.maipu.Xmall.bean.UmsMember;
import tk.mybatis.mapper.common.Mapper;

public interface UmsMemberMapper extends Mapper<UmsMember> {
    int deleteByPrimaryKey(Long id);

    int insert(UmsMember record);

    int insertSelective(UmsMember record);

    UmsMember selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsMember record);

    int updateByPrimaryKey(UmsMember record);
}