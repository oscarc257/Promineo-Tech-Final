package com.promineotech.shoe.service;

import java.util.List;
import com.promineotech.shoe.entity.Shoe;
import com.promineotech.shoe.entity.ShoeBrand;

/**
 * @author Ozcar
 *
 */
public interface ShoeSalesService {

  /**
   * @param brand
   * @param model
   * @return
   */
  List<Shoe> fetchShoes(ShoeBrand brand, String model);

  /**
   * @param brand
   * @param model
   * @return
   */

}