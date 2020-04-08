package com.maipu.Xmall.service;

import com.maipu.Xmall.bean.*;

import javax.persistence.Id;
import java.util.List;

/**
 * @title:
 * @description:
 * @author: Asing
 * @date: 2020-04-06 00:50:58
 */
public interface AdminService {
    List<PmsBaseCatalog1> getCatalog1();

    List<PmsBaseCatalog2> getCatalog2(Integer id);

    List<PmsBaseCatalog3> getCatalog3(Long id);

    List<PmsProductInfo> getSpuList(Long id);

    List<PmsBaseSaleAttr> getBaseSaleAttrList();

    String savaSpuInfo(PmsProductInfo pmsProductInfo);

    List<PmsBaseAttrInfo> getAttrInfoList(Long catalog3Id);

    List<PmsBaseAttrValue> getAttrValueList(Long attrId);

    List<PmsBaseAttrValue> saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsProductSaleAttr> spuSaleAttrList(Long spuId);

    List<PmsProductImage> spuImageList(Long spuId);
}
