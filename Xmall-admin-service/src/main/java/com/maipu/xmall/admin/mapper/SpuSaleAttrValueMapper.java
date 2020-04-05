package com.maipu.xmall.admin.mapper;


import com.maipu.Xmall.bean.PmsProductSaleAttr;
import com.maipu.Xmall.bean.PmsProductSaleAttrValue;
import com.maipu.Xmall.bean.PmsSkuInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SpuSaleAttrValueMapper extends Mapper<PmsProductSaleAttrValue> {

    List<PmsProductSaleAttr> selectSpuSaleAttrListCheckBySku(Map<String, String> map);

    List<PmsSkuInfo> selectSkuSaleAttrValueListBySpu(@Param("spuId") String spuId);

}
