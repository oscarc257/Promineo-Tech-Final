/**
 * 
 */
package com.promineotech.shoe.dao;

import java.math.BigDecimal;
import java.util.Optional;
import com.promineotech.shoe.entity.Color;
import com.promineotech.shoe.entity.Customer;
import com.promineotech.shoe.entity.Size;
import com.promineotech.shoe.entity.Order;
import com.promineotech.shoe.entity.OrderRequest;
import com.promineotech.shoe.entity.Shoe;
import com.promineotech.shoe.entity.ShoeBrand;

/**
 * @author Ozcar
 *
 */
public interface ShoeOrderDao {
  
  Optional<Customer> fetchCustomer(String customerId);
  Optional<Shoe> fetchBrand(ShoeBrand brand, String model, String gender);
  Optional<Color> fetchColor(String colorId);
  Optional<Size> fetchSize(String sizeId);
  

/**
 * @param orderRequest
 * @return
 */
Order createOrder(OrderRequest orderRequest);

Order saveOrder(Customer customer, Shoe shoe, Color color, Size size, BigDecimal price);

  
  

}
