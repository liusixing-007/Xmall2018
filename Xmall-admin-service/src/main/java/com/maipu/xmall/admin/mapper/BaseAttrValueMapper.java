package com.maipu.xmall.admin.mapper;


import com.maipu.Xmall.bean.PmsBaseAttrInfo;
import com.maipu.Xmall.bean.PmsBaseAttrValue;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BaseAttrValueMapper extends Mapper<PmsBaseAttrValue> {
    List<PmsBaseAttrInfo> selectAttrListByValueIds(@Param("ids") String join);
}
