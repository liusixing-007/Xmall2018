package com.maipu.Xmall.dao;

import com.maipu.Xmall.bean.PmsCommentReplay;
import tk.mybatis.mapper.common.Mapper;

public interface PmsCommentReplayMapper extends Mapper<PmsCommentReplay> {
    int deleteByPrimaryKey(Long id);

    int insert(PmsCommentReplay record);

    int insertSelective(PmsCommentReplay record);

    PmsCommentReplay selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsCommentReplay record);

    int updateByPrimaryKey(PmsCommentReplay record);
}