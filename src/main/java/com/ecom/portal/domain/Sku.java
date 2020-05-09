package com.ecom.portal.domain;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Builder
public class Sku {
  private String skuId;
  private String brand;
  private String color;
  private String price;
  private String size;
}
