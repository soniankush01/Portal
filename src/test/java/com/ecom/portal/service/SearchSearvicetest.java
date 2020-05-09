package com.ecom.portal.service;

import static org.junit.Assert.assertEquals;

import com.ecom.portal.domain.Sku;
import com.ecom.portal.repository.SearchRepository;
import com.ecom.portal.repository.model.SKU;
import com.ecom.portal.service.impl.SearchServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

public class SearchSearvicetest {

  @InjectMocks
  SearchServiceImpl searchService;

  @Mock
  SearchRepository searchRepository;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    List<SKU> allSku = new ArrayList<>();
    SKU sku = new SKU();
    sku.setBrand("abc");
    sku.setSize("size");
    sku.setSkuId("Skuid");
    allSku.add(sku);
    ReflectionTestUtils.setField(searchService, "allSku", allSku);
  }

  @Test
  public void shouldAbleToGetSkuForBrand() {
    List<Sku> brandSku = searchService.getAllSKUBySearchId("abc","brand");
    assertEquals("abc", brandSku.get(0).getBrand());
  }




}
