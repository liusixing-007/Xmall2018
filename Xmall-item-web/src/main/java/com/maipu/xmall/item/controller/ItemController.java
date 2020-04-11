package com.maipu.xmall.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.maipu.Xmall.bean.PmsProductSaleAttr;
import com.maipu.Xmall.bean.PmsSkuInfo;
import com.maipu.Xmall.bean.PmsSkuSaleAttrValue;
import com.maipu.Xmall.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title: 商品详情
 * @description: 商品详情的接口类
 * @author: Asing
 * @date: 2020-04-09 19:20:12
 */

@Controller
@CrossOrigin
public class ItemController {
    @Reference
    AdminService adminService;

    @RequestMapping(value = "{skuId}.html")
    public String item(@PathVariable Long skuId, ModelMap modelMap) {
        //拿到sku信息根据skuId
        PmsSkuInfo pmsSkuInfo=adminService.getSkuInfo(skuId);
        modelMap.put("skuInfo",pmsSkuInfo);
        //拿到spu的销售属性以及属性值
        List<PmsProductSaleAttr> pmsProductSaleAttrs=adminService.spuSaleAttrListCheckBySku(pmsSkuInfo.getProductId(),skuId);
        modelMap.put("spuSaleAttrListCheckBySku",pmsProductSaleAttrs);

        //根据已知信息拿到spu下所有sku组合信息
        Map<String,String> skuSaleAttrHash=new HashMap<>();
        List<PmsSkuInfo> pmsSkuInfos=adminService.getSkuSaleAttrValueList(pmsSkuInfo.getProductId());
        for (PmsSkuInfo pms:pmsSkuInfos
             ) {
            String v=pms.getId().toString();
            String k="";
            List<PmsSkuSaleAttrValue> skuSaleAttrValueList = pms.getSkuSaleAttrValueList();
            for (PmsSkuSaleAttrValue pms1:skuSaleAttrValueList
                 ) {
                k+=pms1.getId()+"|";
            }
            skuSaleAttrHash.put(k,v);
        }
        String skuSaleAttrHashJsonStr = JSON.toJSONString(skuSaleAttrHash);
        modelMap.put("skuSaleAttrHashJsonStr",skuSaleAttrHashJsonStr);
        return "item";
    }


}
