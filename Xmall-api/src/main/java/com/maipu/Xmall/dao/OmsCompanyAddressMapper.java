package com.maipu.Xmall.dao;

import com.maipu.Xmall.bean.OmsCompanyAddress;
import tk.mybatis.mapper.common.Mapper;

public interface OmsCompanyAddressMapper extends Mapper<OmsCompanyAddress> {
    int deleteByPrimaryKey(Long id);

    int insert(OmsCompanyAddress record);

    int insertSelective(OmsCompanyAddress record);

    OmsCompanyAddress selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OmsCompanyAddress record);

    int updateByPrimaryKey(OmsCompanyAddress record);
}