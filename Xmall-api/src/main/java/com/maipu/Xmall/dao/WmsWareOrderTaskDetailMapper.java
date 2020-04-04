package com.maipu.Xmall.dao;


import com.maipu.Xmall.bean.WmsWareOrderTaskDetail;
import tk.mybatis.mapper.common.Mapper;

public interface WmsWareOrderTaskDetailMapper extends Mapper<WmsWareOrderTaskDetail> {
    int deleteByPrimaryKey(Long id);

    int insert(WmsWareOrderTaskDetail record);

    int insertSelective(WmsWareOrderTaskDetail record);

    WmsWareOrderTaskDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WmsWareOrderTaskDetail record);

    int updateByPrimaryKey(WmsWareOrderTaskDetail record);
}