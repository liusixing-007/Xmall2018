package com.maipu.Xmall.dao;

import com.maipu.Xmall.bean.OmsCartItem;
import tk.mybatis.mapper.common.Mapper;

public interface OmsCartItemMapper  extends Mapper<OmsCartItem> {
    int deleteByPrimaryKey(Long id);

    int insert(OmsCartItem record);

    int insertSelective(OmsCartItem record);

    OmsCartItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OmsCartItem record);

    int updateByPrimaryKey(OmsCartItem record);
}