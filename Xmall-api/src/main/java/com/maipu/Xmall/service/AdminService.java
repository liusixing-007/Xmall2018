package com.maipu.Xmall.service;

import com.maipu.Xmall.bean.PmsBaseCatalog1;
import com.maipu.Xmall.bean.PmsBaseCatalog2;
import com.maipu.Xmall.bean.PmsBaseCatalog3;

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

    List<PmsBaseCatalog3> getCatalog3(Integer id);
}
