package com.promineotech.shoe.entity;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

/**
 * 
 * @author cbarb
 *
 */

@Data
@Builder
public class Size {
  private Long sizePK;
  private String sizeId;
  private String sizeSize;
  private BigDecimal price;
  private String inStock;
}
