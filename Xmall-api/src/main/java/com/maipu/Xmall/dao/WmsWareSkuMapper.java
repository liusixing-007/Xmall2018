package com.maipu.Xmall.dao;

import com.maipu.Xmall.bean.WmsWareSku;
import tk.mybatis.mapper.common.Mapper;

public interface WmsWareSkuMapper extends Mapper<WmsWareSku> {
    int deleteByPrimaryKey(Long id);

    int insert(WmsWareSku record);

    int insertSelective(WmsWareSku record);

    WmsWareSku selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WmsWareSku record);

    int updateByPrimaryKey(WmsWareSku record);
}