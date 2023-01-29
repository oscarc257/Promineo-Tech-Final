/**
 * 
 */
package com.promineotech.shoe.dao;

import java.util.List;
import com.promineotech.shoe.entity.Shoe;
import com.promineotech.shoe.entity.ShoeBrand;

/**
 * @author Ozcar
 *
 */
//Will implement the DAO method under default.
public interface ShoeSalesDao {

  /**
   * @param brand
   * @param model
   * @return
   */
  List<Shoe> fetchShoes(ShoeBrand brand, String model);

}