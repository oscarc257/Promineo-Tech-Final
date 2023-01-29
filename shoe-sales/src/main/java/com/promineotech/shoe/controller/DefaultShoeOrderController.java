package com.promineotech.shoe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.shoe.entity.Order;
import com.promineotech.shoe.entity.OrderRequest;
import com.promineotech.shoe.service.ShoeOrderService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultShoeOrderController implements ShoeOrderController {

  /**
   * 
   * @author cbarb
   * 
   */
  
  @Autowired
  private ShoeOrderService shoeOrderService;
  
  @Override
  public Order createOrder(OrderRequest orderRequest) {
    log.info("Order Request ={}", orderRequest);
    return shoeOrderService.createOrder(orderRequest);
  }

}