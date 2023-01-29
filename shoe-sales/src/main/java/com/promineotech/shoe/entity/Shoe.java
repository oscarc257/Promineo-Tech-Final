package com.promineotech.shoe.entity;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author cbarb
 *
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Shoe {

  private Long brandPK;
  private ShoeBrand brandId;
  private String modelType;
  private String gender;
  private BigDecimal basePrice;
  
  @JsonIgnore
  public Long getBrandPK() {
    return brandPK;
  }
}
