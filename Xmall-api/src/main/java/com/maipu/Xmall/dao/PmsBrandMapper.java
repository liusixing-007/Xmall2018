package com.maipu.Xmall.dao;


import com.maipu.Xmall.bean.PmsBrand;
import tk.mybatis.mapper.common.Mapper;

public interface PmsBrandMapper extends Mapper<PmsBrand> {
    int deleteByPrimaryKey(Long id);

    int insert(PmsBrand record);

    int insertSelective(PmsBrand record);

    PmsBrand selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsBrand record);

    int updateByPrimaryKeyWithBLOBs(PmsBrand record);

    int updateByPrimaryKey(PmsBrand record);
}