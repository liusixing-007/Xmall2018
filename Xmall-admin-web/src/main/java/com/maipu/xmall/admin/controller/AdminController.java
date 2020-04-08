package com.maipu.xmall.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.maipu.Xmall.bean.*;
import com.maipu.Xmall.service.AdminService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import upload.UploadUtils;

import java.util.List;

/**
 * @title: 后台管理前台接口
 * @description: 负责管理后台相关
 * @author: Asing
 * @date: 2020-04-06 00:41:01
 */
@RestController
@CrossOrigin
public class AdminController {
    @Reference
    AdminService adminService;

    @PostMapping(value = "/getCatalog1")
    public List<PmsBaseCatalog1> getCatalog1(){

        List<PmsBaseCatalog1> catalog1 = adminService.getCatalog1();
        return catalog1;
    }

    @PostMapping(value = "/getCatalog2")
    public List<PmsBaseCatalog2> getCatalog2( Integer catalog1Id){
        List<PmsBaseCatalog2> catalog2 = adminService.getCatalog2(catalog1Id);
        return catalog2;
    }


    @PostMapping(value = "/getCatalog3")
    public List<PmsBaseCatalog3> getCatalog3(Long catalog2Id){
        List<PmsBaseCatalog3> catalog3 = adminService.getCatalog3(catalog2Id);
        return catalog3;
    }


    //根据三级分类id查询所有spu商品
    @GetMapping(value = "/spuList")
    public List<PmsProductInfo> spuList(Long catalog3Id){
        List<PmsProductInfo> pmsProductInfos = adminService.getSpuList(catalog3Id);
        return pmsProductInfos;
    }

    //编辑spu时候获得的平台基本属性
    @PostMapping(value = "/baseSaleAttrList")
    public List<PmsBaseSaleAttr> baseSaleAttrList(){
        List<PmsBaseSaleAttr> pmsBaseSaleAttrs = adminService.getBaseSaleAttrList();
        return pmsBaseSaleAttrs;
    }


    //管理员spu图片上传接口
    @PostMapping(value = "/fileUpload")
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile) {
        String uploadfiles = UploadUtils.uploadfiles(multipartFile);
        System.out.println(uploadfiles);
        return uploadfiles;
    }


    //spu 商品信息保存接口
    @PostMapping(value = "/saveSpuInfo")
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo) {
        String s=null;
        try{
            s=adminService.savaSpuInfo(pmsProductInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }

    //获取相应三级id的平台属性信息
    @GetMapping(value = "/attrInfoList")
    public List<PmsBaseAttrInfo> getAttrInfoList(Long catalog3Id) {
         List<PmsBaseAttrInfo> pmsBaseAttrInfos=null;
        try{
             pmsBaseAttrInfos=adminService.getAttrInfoList(catalog3Id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return pmsBaseAttrInfos;
    }

    @PostMapping(value = "/getAttrValueList")
    public List<PmsBaseAttrValue> getAttrValueList(Long attrId) {
        List<PmsBaseAttrValue> pmsBaseAttrValues=null;
        try{
            pmsBaseAttrValues=adminService.getAttrValueList(attrId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return pmsBaseAttrValues;
    }


    @PostMapping(value = "/saveAttrInfo")
    public List<PmsBaseAttrValue> saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo) {
        List<PmsBaseAttrValue> pmsBaseAttrValues=null;
        try{
            pmsBaseAttrValues=adminService.saveAttrInfo(pmsBaseAttrInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return pmsBaseAttrValues;
    }


    //
    @GetMapping(value = "/spuSaleAttrList")
    public List<PmsProductSaleAttr> spuSaleAttrList(Long spuId) {
        List<PmsProductSaleAttr> pmsProductSaleAttrs=null;
        try{
            pmsProductSaleAttrs=adminService.spuSaleAttrList(spuId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return pmsProductSaleAttrs;
    }


    @GetMapping(value = "/spuImageList")
    public List<PmsProductImage> spuImageList(Long spuId) {
        List<PmsProductImage> pmsProductImages=null;
        try{
            pmsProductImages=adminService.spuImageList(spuId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return pmsProductImages;
    }

}
