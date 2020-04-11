package com.maipu.xmall.admin.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.maipu.Xmall.bean.*;
import com.maipu.Xmall.service.AdminService;
import com.maipu.xmall.admin.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @title: 后台管理服务实现类
 * @description: 实现相关服务
 * @author: Asing
 * @date: 2020-04-06 01:02:02
 */
@Service
public class AdminServiceImp implements AdminService {

    @Autowired
    private BaseCatalog1Mapper baseCatalog1Mapper;
    @Autowired
    private BaseCatalog2Mapper baseCatalog2Mapper;
    @Autowired
    private BaseCatalog3Mapper baseCatalog3Mapper;
    @Autowired
    private BaseSaleAttrMapper baseSaleAttrMapper;
    @Autowired
    private BaseAttrInfoMapper baseAttrInfoMapper;
    @Autowired
    private BaseAttrValueMapper baseAttrValueMapper;
    @Autowired
    private SpuImageMapper spuImageMapper;
    @Autowired
    private SpuInfoMapper spuInfoMapper;
    @Autowired
    private SpuSaleAttrValueMapper spuSaleAttrValueMapper;
    @Autowired
    private SpuSaleAttrMapper spuSaleAttrMapper;
    @Autowired
    private SkuAttrValueMapper skuAttrValueMapper;
    @Autowired
    private SkuImageMapper skuImageMapper;
    @Autowired
    private SkuSaleAttrValueMapper skuSaleAttrValueMapper;
    @Autowired
    private SkuInfoMapper skuInfoMapper;


    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        List<PmsBaseCatalog1> pmsBaseCatalog1s = baseCatalog1Mapper.selectAll();
        return pmsBaseCatalog1s;
    }

    @Override
    public List<PmsBaseCatalog2> getCatalog2(Integer id) {
        PmsBaseCatalog2 pmsBaseCatalog2 = new PmsBaseCatalog2();
        pmsBaseCatalog2.setCatalog1Id(id);
        List<PmsBaseCatalog2> pmsBaseCatalog2s = baseCatalog2Mapper.select(pmsBaseCatalog2);
        return pmsBaseCatalog2s;
    }

    @Override
    public List<PmsBaseCatalog3> getCatalog3(Long id) {
        PmsBaseCatalog3 pmsBaseCatalog3 = new PmsBaseCatalog3();
        pmsBaseCatalog3.setCatalog2Id(id);
        List<PmsBaseCatalog3> pmsBaseCatalog3s = baseCatalog3Mapper.select(pmsBaseCatalog3);
        return pmsBaseCatalog3s;
    }

    @Override
    public List<PmsProductInfo> getSpuList(Long id) {

        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(id);
        List<PmsProductInfo> pmsProductInfos = spuInfoMapper.select(pmsProductInfo);
        return pmsProductInfos;
    }

    @Override
    public List<PmsBaseSaleAttr> getBaseSaleAttrList() {
        List<PmsBaseSaleAttr> pmsBaseSaleAttrs = baseSaleAttrMapper.selectAll();
        return pmsBaseSaleAttrs;
    }

    @Override
    @Transactional
    public String savaSpuInfo(PmsProductInfo pmsProductInfo) {
//        PmsProductInfo pmsProductInfo1 = new PmsProductInfo();
//        pmsProductInfo.
        //将商品信息保存并且拿到保存后的主键Id
        System.out.println("jinru:");
        int insert = spuInfoMapper.insert(pmsProductInfo);
        List<PmsProductInfo> select = spuInfoMapper.select(pmsProductInfo);
        PmsProductInfo pmsProductInfo1 = select.get(0);
        Long id = pmsProductInfo1.getId();
        System.out.println("已经将商品信息保存并且拿到保存后的主键Id");

        //将此spu的Id值保存到对应的spuImage表
        List<PmsProductImage> spuImageList = pmsProductInfo.getSpuImageList();
        for (PmsProductImage pmsProductImages : spuImageList) {
            pmsProductImages.setProductId(id);
            pmsProductImages.setImgUrl("http://" + pmsProductImages.getImgUrl());
            int insert1 = spuImageMapper.insert(pmsProductImages);
        }
        System.out.println("已经将此spu的Id值保存到对应的spuImage表");

        //将基本属性绑定到spu销售属性
        List<PmsBaseSaleAttr> pmsBaseSaleAttrs = pmsProductInfo.getSpuSaleAttrList();

        for (PmsBaseSaleAttr pmsBaseSaleAttr : pmsBaseSaleAttrs) {
            PmsProductSaleAttr pmsProductSaleAttr = new PmsProductSaleAttr();
            pmsProductSaleAttr.setSaleAttrName(pmsBaseSaleAttr.getSaleAttrName());
            pmsProductSaleAttr.setProductId(id);
            pmsProductSaleAttr.setSaleAttrId(pmsBaseSaleAttr.getSaleAttrId());
            pmsProductSaleAttr.setId(null);
            spuSaleAttrMapper.insert(pmsProductSaleAttr);
            System.out.println("已经将基本属性" + pmsBaseSaleAttr.getSaleAttrName() + "绑定到spu销售属性");

            //将商品销售属性id，商品属性名字和商品id注入商品销售属性值详情表
            for (PmsProductSaleAttrValue pmsProductSaleAttrValue : pmsBaseSaleAttr.getSpuSaleAttrValueList()
            ) {
                PmsProductSaleAttrValue pmsProductSaleAttrValue1 = new PmsProductSaleAttrValue();
                pmsProductSaleAttrValue1.setProductId(id);
                pmsProductSaleAttrValue1.setSaleAttrId(pmsProductSaleAttrValue.getSaleAttrId());
                pmsProductSaleAttrValue1.setSaleAttrValueName(pmsProductSaleAttrValue.getSaleAttrValueName());
                pmsProductSaleAttrValue1.setId(null);
                int insert1 = spuSaleAttrValueMapper.insert(pmsProductSaleAttrValue1);
                System.out.println("将商品销售属性id，商品属性名字和商品id注入商品销售属性值详情表");
            }
        }

        return "sucess!";
    }

    @Override
    @Transactional
    public List<PmsBaseAttrInfo> getAttrInfoList(Long catalog3Id) {
        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = baseAttrInfoMapper.select(pmsBaseAttrInfo);
        //将value表封装进去

        for (int i = 0; i < pmsBaseAttrInfos.size(); i++) {
            PmsBaseAttrValue pmsBaseAttrValue1 = new PmsBaseAttrValue();
            PmsBaseAttrInfo pmsBaseAttrInfo2 = pmsBaseAttrInfos.get(i);
            Long id = pmsBaseAttrInfo2.getId();
            pmsBaseAttrValue1.setAttrId(id);
            List<PmsBaseAttrValue> select = baseAttrValueMapper.select(pmsBaseAttrValue1);
            pmsBaseAttrInfos.get(i).setAttrValueList(select);
        }
        return pmsBaseAttrInfos;
    }

    @Override
    public List<PmsBaseAttrValue> getAttrValueList(Long attrId) {
        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);
        List<PmsBaseAttrValue> select = baseAttrValueMapper.select(pmsBaseAttrValue);
        return select;
    }

    @Override
    @Transactional
    public List<PmsBaseAttrValue> saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
        //删除所有此id下的属性值
        Long id = pmsBaseAttrInfo.getId();
        //更新名字
        if (id != null) {
            baseAttrInfoMapper.updateByPrimaryKeySelective(pmsBaseAttrInfo);
            PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
            pmsBaseAttrValue.setAttrId(id);
            int delete = baseAttrValueMapper.delete(pmsBaseAttrValue);
        } else {
            int insert = baseAttrInfoMapper.insert(pmsBaseAttrInfo);
            List<PmsBaseAttrInfo> select = baseAttrInfoMapper.select(pmsBaseAttrInfo);
            PmsBaseAttrInfo pmsBaseAttrInfo1 = select.get(0);
            id = pmsBaseAttrInfo1.getId();
            System.out.println(id);
        }

        //重新将现有属性值注入表中
        for (PmsBaseAttrValue pmsBaseAttrValue1 : attrValueList) {
            pmsBaseAttrValue1.setAttrId(pmsBaseAttrInfo.getId());
            pmsBaseAttrValue1.setId(null);
            int insert = baseAttrValueMapper.insert(pmsBaseAttrValue1);

        }
        return null;
    }

    @Override
    @Transactional
    public List<PmsProductSaleAttr> spuSaleAttrList(Long spuId) {
        PmsProductSaleAttr pmsProductSaleAttr = new PmsProductSaleAttr();
        pmsProductSaleAttr.setProductId(spuId);
        List<PmsProductSaleAttr> select = spuSaleAttrMapper.select(pmsProductSaleAttr);

        for (int i = 0; i < select.size(); i++) {
            PmsProductSaleAttrValue pmsProductSaleAttrValue = new PmsProductSaleAttrValue();
            PmsProductSaleAttr pmsProductSaleAttr2 = select.get(i);
            Long id = pmsProductSaleAttr2.getSaleAttrId();
            pmsProductSaleAttrValue.setSaleAttrId(id);
            pmsProductSaleAttrValue.setProductId(spuId);
            List<PmsProductSaleAttrValue> select1 = spuSaleAttrValueMapper.select(pmsProductSaleAttrValue);
            select.get(i).setSpuSaleAttrValueList(select1);
        }
        return select;
    }

    @Override
    public List<PmsProductImage> spuImageList(Long spuId) {
        PmsProductImage pmsProductImage = new PmsProductImage();
        pmsProductImage.setProductId(spuId);
        List<PmsProductImage> select = spuImageMapper.select(pmsProductImage);
        return select;
    }

    @Override
    @Transactional
    public String saveSkuInfo(PmsSkuInfo pmsSkuInfo) {

        pmsSkuInfo.setProductId(pmsSkuInfo.getSpuId());

        skuInfoMapper.insert(pmsSkuInfo);

        List<PmsSkuInfo> select = skuInfoMapper.select(pmsSkuInfo);
        Long id = select.get(0).getId();
        List<PmsSkuAttrValue> skuAttrValueList = pmsSkuInfo.getSkuAttrValueList();
        for (PmsSkuAttrValue pms :
                skuAttrValueList) {
            pms.setSkuId(id);
            skuAttrValueMapper.insert(pms);
        }

        List<PmsSkuImage> skuImages = pmsSkuInfo.getSkuImageList();
        for (PmsSkuImage pms :
                skuImages) {
            pms.setSkuId(id);
            pms.setProductImgId(pmsSkuInfo.getSpuId());
            skuImageMapper.insert(pms);
        }

        List<PmsSkuSaleAttrValue> skuSaleAttrValueList = pmsSkuInfo.getSkuSaleAttrValueList();
        for (PmsSkuSaleAttrValue pms :
                skuSaleAttrValueList) {
            pms.setSkuId(id);
            skuSaleAttrValueMapper.insert(pms);
        }
        return "success!";
    }

    @Override
    public PmsSkuInfo getSkuInfoFromDB(Long id) {
        PmsSkuInfo pmsSkuInfo1 = new PmsSkuInfo();
        pmsSkuInfo1.setId(id);
        PmsSkuInfo pmsSkuInfo = skuInfoMapper.selectOne(pmsSkuInfo1);
        PmsSkuImage pmsSkuImage = new PmsSkuImage();
        pmsSkuImage.setSkuId(id);
        List<PmsSkuImage> select = skuImageMapper.select(pmsSkuImage);
        pmsSkuInfo.setSkuImageList(select);
        return pmsSkuInfo;
    }

    @Transactional
    @Override
    public PmsSkuInfo getSkuInfo(Long id) {
        PmsSkuInfo pmsSkuInfo = new PmsSkuInfo();

        return pmsSkuInfo;
    }

    @Override
    @Transactional
    public List<PmsProductSaleAttr> spuSaleAttrListCheckBySku(Long productId,Long skuId) {
        PmsProductSaleAttr pmsProductSaleAttr = new PmsProductSaleAttr();
        pmsProductSaleAttr.setProductId(productId);
        List<PmsProductSaleAttr> select = spuSaleAttrMapper.select(pmsProductSaleAttr);
        for (PmsProductSaleAttr pms:select
             ) {
            PmsProductSaleAttrValue pmsProductSaleAttrValue = new PmsProductSaleAttrValue();
            pmsProductSaleAttrValue.setProductId(productId);
            pmsProductSaleAttrValue.setSaleAttrId(pms.getSaleAttrId());
            List<PmsProductSaleAttrValue> select1 = spuSaleAttrValueMapper.select(pmsProductSaleAttrValue);

            for(PmsProductSaleAttrValue pms1:select1){
                PmsSkuSaleAttrValue pmsSkuSaleAttrValue = new PmsSkuSaleAttrValue();
                pmsSkuSaleAttrValue.setSkuId(skuId);
                pmsSkuSaleAttrValue.setSaleAttrValueName(pms1.getSaleAttrValueName());
                int size = skuSaleAttrValueMapper.select(pmsSkuSaleAttrValue).size();
                if(size==1){
                    pms1.setIsChecked("1");
                }else{
                    pms1.setIsChecked(null);
                }
            }
            pms.setSpuSaleAttrValueList(select1);
        }
        return select;
    }

    @Override
    public List<PmsSkuInfo> getSkuSaleAttrValueList(Long productId) {
        List<PmsSkuInfo> pmsSkuInfos = skuInfoMapper.selectSkuSaleAttrValueListBySkuId(productId);

        return pmsSkuInfos;
    }

}
