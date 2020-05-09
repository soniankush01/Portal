package com.ecom.portal.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.ecom.portal.domain.Sku;
import com.ecom.portal.repository.MySearchException;
import com.ecom.portal.service.SearchService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SearchResourceTest {

  @InjectMocks
  SearchResource searchResource;

  @Mock
  SearchService searchService;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void shouldAbleToreturnBasedOnSkuId() throws MySearchException {
    Sku sku = getSkuRecored();
    when(searchService.getDetailsBySkuId(any())).thenReturn(sku);
    ResponseEntity expected = new ResponseEntity(sku, HttpStatus.OK);
    assertEquals(expected, searchResource.getDetailsBySKUId("skuId"));
  }

  @Test
  public void shouldAbleToHandleException() throws MySearchException {
    Sku sku = getSkuRecored();
    try {
      when(searchService.getDetailsBySkuId(any())).thenThrow(new MySearchException("Error Code", "Error Message"));
      searchResource.getDetailsBySKUId("skuId");
      fail();
    } catch (MySearchException e) { }
  }

  @Test(expected = MySearchException.class)
  public void shouldAbleToHandleExceptionOne() throws MySearchException {
    Sku sku = getSkuRecored();
      when(searchService.getDetailsBySkuId(any())).thenThrow(new MySearchException("Error Code", "Error Message"));
      searchResource.getDetailsBySKUId("skuId");
  }

  private Sku getSkuRecored() {
    return Sku.builder().skuId("skuId").build();
  }


}
