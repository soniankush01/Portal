package com.ecom.portal.service.impl;

import com.ecom.portal.repository.MySearchException;
import com.ecom.portal.domain.Sku;
import com.ecom.portal.repository.SearchRepository;
import com.ecom.portal.repository.model.SKU;
import com.ecom.portal.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class SearchServiceImpl implements SearchService {

  @Autowired
  SearchRepository searchRepository;

  // this can be done in cache (EH cacche or other memory cache)
  List<SKU> allSku = new ArrayList<>();

  @PostConstruct
  //this will load data at time of server startup and save Db calls;
  //Can be implemented to clear if data is beign updated.
  public void  SearchServiceImpl () {
    allSku = searchRepository.findAll();
  }

  @Override
  public Sku getDetailsBySkuId(String skuId) throws MySearchException {
    log.info("Search for SKU", skuId);
    Optional<SKU> sku = searchRepository.findById(skuId);
    if (sku.isPresent()) {
      return getSku(sku.get());
    } else {
      throw new MySearchException("404", "Requested SKU Not found");
    }
  }

  @Override
  public List<Sku> getAllSKUBySearchId(String brand, String parameter) {
    List<Sku> brandSku = new ArrayList<>();
    log.info("Request to get Sku for ", parameter);
    allSku.stream().forEach(prd -> {
      if (getDynamicParameter(parameter, prd).equalsIgnoreCase(brand)) {
        brandSku.add(getSku(prd));
      }
    });
    return brandSku;
  }

  private String getDynamicParameter(String parameter, SKU prd) {
    if (parameter.equalsIgnoreCase("brand")) {
     return prd.getBrand();
    } else if (parameter.equalsIgnoreCase("color")) {
      return prd.getColor();
    } else if (parameter.equalsIgnoreCase("size")) {
      return prd.getSize();
    }
    return "";
  }


  private Sku getSku(SKU sku) {
    return Sku.builder().brand(sku.getBrand()).
            color(sku.getColor()).
            size(sku.getSize()).
            price(sku.getPrice()).
            skuId(sku.getSkuId()).build();
  }
}
