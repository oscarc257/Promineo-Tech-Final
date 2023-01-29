/**
* 
*/
package com.promineotech.shoe.service;

import com.promineotech.shoe.entity.Order;
import com.promineotech.shoe.entity.OrderRequest;

/**
* @author Ozcar
*
*/
public interface ShoeOrderService {

 /**
  * @param orderRequest
  * @return+.
  */
 Order createOrder(OrderRequest orderRequest);
}