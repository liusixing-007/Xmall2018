package com.maipu.Xmall.dao;

import com.maipu.Xmall.bean.PmsComment;
import tk.mybatis.mapper.common.Mapper;

public interface PmsCommentMapper extends Mapper<PmsComment> {
    int deleteByPrimaryKey(Long id);

    int insert(PmsComment record);

    int insertSelective(PmsComment record);

    PmsComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsComment record);

    int updateByPrimaryKeyWithBLOBs(PmsComment record);

    int updateByPrimaryKey(PmsComment record);
}