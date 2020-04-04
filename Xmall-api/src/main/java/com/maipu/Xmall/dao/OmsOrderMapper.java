package com.maipu.Xmall.dao;

import com.maipu.Xmall.bean.OmsOrder;
import tk.mybatis.mapper.common.Mapper;

public interface OmsOrderMapper extends Mapper<OmsOrder> {
    int deleteByPrimaryKey(Long id);

    int insert(OmsOrder record);

    int insertSelective(OmsOrder record);

    OmsOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OmsOrder record);

    int updateByPrimaryKey(OmsOrder record);
}