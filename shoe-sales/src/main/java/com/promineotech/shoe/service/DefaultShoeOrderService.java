package com.promineotech.shoe.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.shoe.dao.ShoeOrderDao;
import com.promineotech.shoe.entity.Color;
import com.promineotech.shoe.entity.Customer;
import com.promineotech.shoe.entity.Shoe;
import com.promineotech.shoe.entity.Order;
import com.promineotech.shoe.entity.OrderRequest;
import com.promineotech.shoe.entity.Size;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultShoeOrderService implements ShoeOrderService {

  /**
   * 
   * @author cbarb
   * 
   */
  
  @Autowired
  private ShoeOrderDao shoeOrderDao;
  
  @Transactional
  public Order createOrder(OrderRequest orderRequest) {
    log.info("service layer createOrder={}", orderRequest);
    
    Customer customer = getCustomer(orderRequest);
    Shoe shoe = getBrand(orderRequest);
    Color color = getColor(orderRequest);
    Size size = getSize(orderRequest);
    
    BigDecimal price = shoe.getBasePrice().add(color.getPrice()).add(size.getPrice());
    
    return shoeOrderDao.saveOrder(customer, shoe, color, size, price);
  }
  
  /**
   * 
   * @param orderRequestfetch
   * @return
   */
  private Size getSize(OrderRequest orderRequest) {
    return shoeOrderDao.fetchSize(orderRequest.getSize())
        .orElseThrow(() -> new NoSuchElementException(
            "Size with ID=" + orderRequest.getSize() + " was not found"));
  }

  /**
   * 
   * @param orderRequest
   * @return
   */
  private Color getColor(OrderRequest orderRequest) {
    return shoeOrderDao.fetchColor(orderRequest.getColor())
        .orElseThrow(() -> new NoSuchElementException(
            "Color with ID=" + orderRequest.getColor() + " was not found"));
  }

  /**
   * 
   * @param orderRequest
   * @return
   */
  private Shoe getBrand(OrderRequest orderRequest) {
    return shoeOrderDao
        .fetchBrand(orderRequest.getBrand(), orderRequest.getModel(), null)
        .orElseThrow(() -> new NoSuchElementException("brand with ID="
            + orderRequest.getBrand() + ", model=" + orderRequest.getModel()
            + " was not found"));
  }

  /**
   * 
   * @param orderRequest
   * @return
   */
  private Customer getCustomer(OrderRequest orderRequest) {
    return shoeOrderDao.fetchCustomer(orderRequest.getCustomer())
        .orElseThrow(() -> new NoSuchElementException("Customer with ID="
            + orderRequest.getCustomer() + " was not found"));
  }


}