package com.maipu.Xmall.dao;

import com.maipu.Xmall.bean.PmsProductVertifyRecord;
import tk.mybatis.mapper.common.Mapper;

public interface PmsProductVertifyRecordMapper extends Mapper<PmsProductVertifyRecord> {
    int deleteByPrimaryKey(Long id);

    int insert(PmsProductVertifyRecord record);

    int insertSelective(PmsProductVertifyRecord record);

    PmsProductVertifyRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsProductVertifyRecord record);

    int updateByPrimaryKey(PmsProductVertifyRecord record);
}