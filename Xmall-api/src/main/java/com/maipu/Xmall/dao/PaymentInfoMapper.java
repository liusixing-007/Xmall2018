package com.maipu.Xmall.dao;


import com.maipu.Xmall.bean.PaymentInfo;
import tk.mybatis.mapper.common.Mapper;

public interface PaymentInfoMapper extends Mapper<PaymentInfo> {
    int deleteByPrimaryKey(Long id);

    int insert(PaymentInfo record);

    int insertSelective(PaymentInfo record);

    PaymentInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PaymentInfo record);

    int updateByPrimaryKey(PaymentInfo record);
}