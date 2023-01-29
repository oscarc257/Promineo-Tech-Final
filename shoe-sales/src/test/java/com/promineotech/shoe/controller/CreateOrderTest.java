package com.promineotech.shoe.controller;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import com.promineotech.shoe.entity.ShoeBrand;
import com.promineotech.shoe.entity.Order;

/**
 * 
 * @author cbarb
 *
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {"classpath:flyway/migrations/V1.0__Shoe_Schema.sql",
    "classpath:flyway/migrations/V1.1__Shoe_Data.sql"}, config = @SqlConfig(encoding = "utf-8"))
public class CreateOrderTest {

  @LocalServerPort
  private int serverPort;
  
  @Autowired
  private TestRestTemplate restTemplate;
  
  @Test
  void testCreateOrderReturnsSuccess201() {
    String body = createOrderBody();
    String uri = String.format("http://localhost:%d/orders", serverPort);
    
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    
    HttpEntity<String> bodyEntity = new HttpEntity<>(body, headers);
    
    ResponseEntity<Order> response = restTemplate.exchange(
        uri, HttpMethod.POST, bodyEntity, Order.class);
    
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    assertThat(response.getBody()).isNotNull();
    
    Order order = response.getBody();
    assertThat(order.getCustomer().getCustomerId()).isEqualTo("PENNYPACKER_YASMINE");
    assertThat(order.getBrand().getBrandId()).isEqualTo(ShoeBrand.NIKE);
    assertThat(order.getBrand().getModelType()).isEqualTo("Air Jordan 1 Retro High");
    assertThat(order.getBrand().getGender()).isEqualTo("Men");
    assertThat(order.getColor().getColorId()).isEqualTo("EXT_ONYX_BLACK");
    assertThat(order.getSize().getSizeId()).isEqualTo("211_NIKE");
    assertThat(order.getSize().getSizeSize()).isEqualTo("8 sizes");
  }
  
  protected String createOrderBody() {
    return "{\n"
        + "  \"customer\":\"PENNYPACKER_YASMINE\",\n"
        + "  \"brand\":\"NIKE\",\n"
        + "  \"model\":\"Air Jordan 1 Retro High\",\n"
        + "  \"gender\":\"Men\",\n"
        + "  \"color\":\"EXT_ONYX_BLACK\",\n"
        + "  \"size\":\"211_NIKE\",\n"
        + "  \"size\":\"8 sizes\",\n"
        + "  ]\n"
        + "}";
  }
}