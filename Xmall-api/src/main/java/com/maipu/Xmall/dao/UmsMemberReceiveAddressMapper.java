package com.maipu.Xmall.dao;


import com.maipu.Xmall.bean.UmsMemberReceiveAddress;
import tk.mybatis.mapper.common.Mapper;

public interface UmsMemberReceiveAddressMapper extends Mapper<UmsMemberReceiveAddress> {
    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberReceiveAddress record);

    int insertSelective(UmsMemberReceiveAddress record);

    UmsMemberReceiveAddress selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsMemberReceiveAddress record);

    int updateByPrimaryKey(UmsMemberReceiveAddress record);
}