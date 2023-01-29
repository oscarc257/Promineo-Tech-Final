package com.promineotech.shoe.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.shoe.entity.Color;
import com.promineotech.shoe.entity.Customer;
import com.promineotech.shoe.entity.Order;
import com.promineotech.shoe.entity.OrderRequest;
import com.promineotech.shoe.entity.Shoe;
import com.promineotech.shoe.entity.ShoeBrand;
import com.promineotech.shoe.entity.Size;

@Component
public class DefaultShoeOrderDao implements ShoeOrderDao {
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  /**
   * 
   * @author cbarb
   * 
   */
  @SuppressWarnings("unused")
  private SqlParams generateInsertSql(Long orderPK) {
    SqlParams params = new SqlParams();
    
    // @formatter:off
    params.sql = ""
        + "INSERT INTO order_options ("
        + "order_fk"
        + ") VALUES ("
        + ":order_fk"
        + ")";
    // @formatter:on
    
    params.source.addValue("order_fk", orderPK);
    
    return params;
  }

  /**
   * 
   * @param customer
   * @param shoe
   * @param color
   * @param size
   * @param price
   * @return
   */
  
  private SqlParams generateInsertSql(Customer customer, Shoe shoe, Color color,
      Size size, BigDecimal price) {
    // @formatter:off
    String sql = ""
        + "INSERT INTO orders ("
        + "customer_fk, color_fk, size_fk, brand_fk, price"
        + ") VALUES ("
        + ":customer_fk, :color_fk, :size_fk, :brand_fk, :price"
        + ")";
    // @formatter:on
    
    SqlParams params = new SqlParams();
    
    params.sql = sql;
    params.source.addValue("customer_fk", customer.getCustomerPK());
    params.source.addValue("color_fk", color.getColorPK());
    params.source.addValue("size_fk", size.getSizePK());
    params.source.addValue("brand_fk", shoe.getBrandPK());
    params.source.addValue("price", price);
    
    return params;
  }


  /**
   * 
   */
  @Override
  public Optional<Customer> fetchCustomer(String customerId) {
    // @formatter:off
    String sql = "" 
        + "SELECT * " 
        + "FROM customers "
        + "WHERE customer_id = :customer_id";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("customer_id", customerId);

    return Optional.ofNullable(
        jdbcTemplate.query(sql, params, new CustomerResultSetExtractor()));
  }

  /**
   * 
   */
  @Override
  public Optional<Shoe> fetchBrand(ShoeBrand brand, String model, String gender) {
    // @formatter:off
    String sql = "" 
        + "SELECT * " 
        + "FROM brands "
        + "WHERE brand_id = :brand_id "
        + "AND model_level = :model_level "
        + "AND gender = :gender ";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("brand_id", brand.toString());
    params.put("model_level", model);
    params.put("gender", gender);

    return Optional.ofNullable(
        jdbcTemplate.query(sql, params, new BrandResultSetExtractor()));
  }

  /**
   * 
   */
  @Override
  public Optional<Color> fetchColor(String colorId) {
    // @formatter:off
    String sql = "" 
        + "SELECT * " 
        + "FROM colors " 
        + "WHERE color_id = :color_id";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("color_id", colorId);

    return Optional.ofNullable(
        jdbcTemplate.query(sql, params, new ColorResultSetExtractor()));
  }

  /**
   * 
   */
  @Override
  public Optional<Size> fetchSize(String sizeId) {
    // @formatter:off
    String sql = "" 
        + "SELECT * " 
        + "FROM sizes " 
        + "WHERE size_id = :size_id";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("size_id", sizeId);

    return Optional.ofNullable(
        jdbcTemplate.query(sql, params, new SizeResultSetExtractor()));
  }

  /**
   * 
   * @author Promineo
   *
   */
  class SizeResultSetExtractor implements ResultSetExtractor<Size> {
    @Override
    public Size extractData(ResultSet rs) throws SQLException {
      rs.next();

      // @formatter:off
      return Size.builder()
          .price(rs.getBigDecimal("price"))
          .sizeId(rs.getString("size_id"))
          .sizePK(rs.getLong("size_pk"))
          .sizeSize(rs.getString("size_size"))
          .inStock(rs.getString("in_stock"))
          .build();
      // @formatter:on
    }
  }

  /**
   * 
   * @author Promineo
   *
   */
  class ColorResultSetExtractor implements ResultSetExtractor<Color> {
    @Override
    public Color extractData(ResultSet rs) throws SQLException {
      rs.next();

      // @formatter:off
      return Color.builder()
          .color(rs.getString("color"))
          .colorId(rs.getString("color_id"))
          .colorPK(rs.getLong("color_pk"))
          .isExterior(rs.getBoolean("is_exterior"))
          .price(rs.getBigDecimal("price"))
          .build();
      // @formatter:on
    }
  }

  /**
   * 
   * @author Promineo
   *
   */
  class BrandResultSetExtractor implements ResultSetExtractor<Shoe> {
    @Override
    public Shoe extractData(ResultSet rs) throws SQLException {
      rs.next();

      // @formatter:off
      return Shoe.builder()
          .basePrice(rs.getBigDecimal("base_price"))
          .brandId(ShoeBrand.valueOf(rs.getString("model_id")))
          .brandPK(rs.getLong("model_pk"))
          .gender(rs.getString("gender"))
          .build();
      // @formatter:on
    }
  }

  /**
   * 
   * @author Promineo
   *
   */
  class CustomerResultSetExtractor implements ResultSetExtractor<Customer> {
    @Override
    public Customer extractData(ResultSet rs) throws SQLException {
      rs.next();

      // @formatter:off
      return Customer.builder()
          .customerId(rs.getString("customer_id"))
          .customerPK(rs.getLong("customer_pk"))
          .firstName(rs.getString("first_name"))
          .lastName(rs.getString("last_name"))
          .phone(rs.getString("phone"))
          .build();
      // @formatter:on

    }
  }

  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }

  public Order saveOrder(Customer customer, Shoe shoe, Color color, Size size,
      BigDecimal price) {
    SqlParams params = generateInsertSql(customer, shoe, color, size, price);
    
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
    Long orderPK = keyHolder.getKey().longValue();
    
    //formatter:off
    return Order.builder()
        .orderPK(orderPK)
        .customer(customer)
        .brand(shoe)
        .color(color)
        .size(size)
        .price(price)
        .build();
    //formatter:off
  }

  @Override
  public Order createOrder(OrderRequest orderRequest) {
    // TODO Auto-generated method stub
    return null;
  } 
  

}