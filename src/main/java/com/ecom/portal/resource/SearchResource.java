package com.ecom.portal.resource;

import com.ecom.portal.repository.MySearchException;
import com.ecom.portal.domain.Sku;
import com.ecom.portal.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchResource {

  @Autowired
  SearchService searchService;

  @RequestMapping(method = RequestMethod.GET, path="/skuId/{skuId}")
  public ResponseEntity getDetailsBySKUId (@PathVariable("skuId") String skuId) throws MySearchException {
    //validation can be done for SKU iD
    Sku sku = searchService.getDetailsBySkuId(skuId);
    ResponseEntity responseEntity = new ResponseEntity(sku, HttpStatus.OK);
    return responseEntity;
  }

  @RequestMapping(method = RequestMethod.GET, path="/brand/{brandName}")
  public List<Sku> getDetailsByBrand(@PathVariable("brandName") String brandName) throws MySearchException {
    //validation can be done for SKU iD
    List<Sku> sku = searchService.getAllSKUBySearchId(brandName, "brand");
    return sku;
  }

  @RequestMapping(method = RequestMethod.GET, path="/color/{color}")
  public List<Sku> getDetailsByColor(@PathVariable("color") String color) throws MySearchException {
    //validation can be done for SKU iD
    List<Sku> sku = searchService.getAllSKUBySearchId(color,"color");
    return sku;
  }

  @RequestMapping(method = RequestMethod.GET, path="/size/{size}")
  public List<Sku> getDetailsBySize(@PathVariable("size") String size) throws MySearchException {
    //validation can be done for SKU iD
    List<Sku> sku = searchService.getAllSKUBySearchId(size,"size");
    return sku;
  }

}
