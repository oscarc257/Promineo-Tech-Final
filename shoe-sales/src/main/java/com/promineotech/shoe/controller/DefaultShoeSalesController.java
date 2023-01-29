package com.promineotech.shoe.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.shoe.entity.Shoe;
import com.promineotech.shoe.entity.ShoeBrand;
import com.promineotech.shoe.service.ShoeSalesService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultShoeSalesController implements ShoeSalesController {

  /**
   * 
   * @author cbarb
   * 
   */
  
  @Autowired
  private ShoeSalesService shoeSalesService;
  
  @Override
  public List<Shoe> fetchShoes(ShoeBrand brand, String model) {
    log.info("brand={}, model={}", brand, model);
    return shoeSalesService.fetchShoes(brand, model);
  }
 
}