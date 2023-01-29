/**
 * 
 */
package com.promineotech.shoe.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import com.promineotech.shoe.dao.DefaultShoeSalesDao;
import com.promineotech.shoe.entity.Shoe;
import com.promineotech.shoe.entity.ShoeBrand;

/**
 * @author Ozcar
 *
 */
@Service
@Slf4j
public class DefaultShoeSalesDao implements ShoeSalesDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jbdcTemplate;
  

  @Override
  public List<Shoe> fetchShoes(ShoeBrand brand, String model) {
    log.info("DAO: brand={}, model={}", brand, model);
    
 // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM brands "
        + "WHERE brand_id = :brand_id AND model_type = :model_type";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("brand_id", brand.toString());
    params.put("model_type", model);
        
    return jbdcTemplate.query(sql, params,
        new RowMapper<>() {

      // query method on the NamedParameterJdbcTemplate instance variable to return a list of Jeep model objects.
          @Override
          public Shoe mapRow(ResultSet rs, int rowNum) throws SQLException {
            // @formatter:off
            return Shoe.builder()
                .basePrice(new BigDecimal(rs.getString("base_price")))
                .brandId(ShoeBrand.valueOf(rs.getString("brand_id")))
                .brandPK(rs.getLong("brand_pk"))
                .modelType(rs.getString("model_type"))
                .gender(rs.getString("gender"))
                .build();
           // @formatter:on     
          }});
    
  }

}