package com.maipu.Xmall.dao;


import com.maipu.Xmall.bean.WmsWareOrderTask;
import tk.mybatis.mapper.common.Mapper;

public interface WmsWareOrderTaskMapper extends Mapper<WmsWareOrderTask> {
    int deleteByPrimaryKey(Long id);

    int insert(WmsWareOrderTask record);

    int insertSelective(WmsWareOrderTask record);

    WmsWareOrderTask selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WmsWareOrderTask record);

    int updateByPrimaryKey(WmsWareOrderTask record);
}