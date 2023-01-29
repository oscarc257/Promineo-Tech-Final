package com.promineotech.shoe.entity;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.boot.context.config.ConfigData.Option;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

/**
 * @author Ozcar
 *
 */

@Data
@Builder
public class Order {
  private Long orderPK;
  private Customer customer;
  private Color color;
  private Size size;
  private Shoe brand;
  private List<Option> options;
  private BigDecimal price;
  
  @JsonIgnore
  public Long getOrderPK() {
    return orderPK;
  }
}
