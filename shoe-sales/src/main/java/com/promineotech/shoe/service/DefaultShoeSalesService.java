package com.promineotech.shoe.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.shoe.dao.ShoeSalesDao;
import com.promineotech.shoe.entity.Shoe;
import com.promineotech.shoe.entity.ShoeBrand;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author cbarb
 *
 */

@Service
@Slf4j
public class DefaultShoeSalesService implements ShoeSalesService {

  @Autowired
  private ShoeSalesDao shoeSalesDao;
  
  @Override
  public List<Shoe> fetchShoes(ShoeBrand brand, String model) {
    log.info("The method fetchShoes was called with brand={} and model={}",
        brand, model);
    return shoeSalesDao.fetchShoes(brand, model);
  }

}