package com.ecom.portal.service;

import com.ecom.portal.repository.MySearchException;
import com.ecom.portal.domain.Sku;

import java.util.List;

public interface SearchService {
   Sku getDetailsBySkuId(String skuId) throws MySearchException;

  List<Sku> getAllSKUBySearchId(String skuId, String parameter);
}
