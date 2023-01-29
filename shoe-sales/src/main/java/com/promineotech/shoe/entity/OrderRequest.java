
package com.promineotech.shoe.entity;

import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;
import lombok.Data;

/**
 * 
 * @author cbarb, @author Ozcar
 *
 */

@Data
public class OrderRequest {
  @NotNull
  @Length(max = 30)
  @Pattern(regexp = "[\\w\\s]*")
  private String customer;
  @NotNull
  private ShoeBrand brand;
  @NotNull
  @Length(max = 30)
  @Pattern(regexp = "[\\w\\s]*")
  private String model;
  @NotNull
  @Length(max = 30)
  private String color;
  @NotNull
  @Length(max = 30)
  @Pattern(regexp = "[\\w\\s]*")
  private String size;

  private List<@NotNull @Length(max = 30) @Pattern(regexp = "[\\w\\s]*") String> options;
}