package com.maipu.Xmall.dao;

import com.maipu.Xmall.bean.OmsOrderItem;
import tk.mybatis.mapper.common.Mapper;

public interface OmsOrderItemMapper extends Mapper<OmsOrderItem> {
    int deleteByPrimaryKey(Long id);

    int insert(OmsOrderItem record);

    int insertSelective(OmsOrderItem record);

    OmsOrderItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OmsOrderItem record);

    int updateByPrimaryKey(OmsOrderItem record);
}