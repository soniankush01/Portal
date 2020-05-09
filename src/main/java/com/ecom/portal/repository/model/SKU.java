package com.ecom.portal.repository.model;

import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("product")
@Data
public class SKU {

  @PrimaryKey
  private String skuId;

  @Column("brand")
  private String brand;

  @Column("price")
  private String price;

  @Column("color")
  private String color;

  @Column("size")
  private String size;
}
