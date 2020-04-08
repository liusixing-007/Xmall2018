package com.maipu.Xmall.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

public class PmsProductSaleAttr  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;

    private Long saleAttrId;

    private String saleAttrName;
    @Transient
    private List<PmsProductSaleAttrValue> pmsProductSaleAttrValues;

    public List<PmsProductSaleAttrValue> getPmsProductSaleAttrValues() {
        return pmsProductSaleAttrValues;
    }

    public void setPmsProductSaleAttrValues(List<PmsProductSaleAttrValue> pmsProductSaleAttrValues) {
        this.pmsProductSaleAttrValues = pmsProductSaleAttrValues;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSaleAttrId() {
        return saleAttrId;
    }

    public void setSaleAttrId(Long saleAttrId) {
        this.saleAttrId = saleAttrId;
    }

    public String getSaleAttrName() {
        return saleAttrName;
    }

    public void setSaleAttrName(String saleAttrName) {
        this.saleAttrName = saleAttrName == null ? null : saleAttrName.trim();
    }
}