package com.maipu.Xmall.dao;


import com.maipu.Xmall.bean.WmsWareInfo;
import tk.mybatis.mapper.common.Mapper;

public interface WmsWareInfoMapper extends Mapper<WmsWareInfo> {
    int deleteByPrimaryKey(Long id);

    int insert(WmsWareInfo record);

    int insertSelective(WmsWareInfo record);

    WmsWareInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WmsWareInfo record);

    int updateByPrimaryKey(WmsWareInfo record);
}