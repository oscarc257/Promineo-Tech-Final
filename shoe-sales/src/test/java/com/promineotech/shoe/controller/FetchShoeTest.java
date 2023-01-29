/**
 * 
 */
package com.promineotech.shoe.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.promineotech.shoe.entity.Shoe;
import com.promineotech.shoe.entity.ShoeBrand;
import lombok.Getter;

/**
 * @author Ozcar
 *
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FetchShoeTest {

  @Test
  void testThatShoesAreReturnedWhenAValidBrandAndModelAreSupplied() {
    //Given: a valid model, trim and URI
    ShoeBrand brand = ShoeBrand.NIKE;
    String model = "Air Force 1";
    String uri = 
        String.format("http://localhost:%d/shoes?brand=%s&model=%s", serverPort, brand, model);

    // When: a connection is made to the URI
    ResponseEntity<List<Shoe>> response = restTemplate.exchange(uri, 
        HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
    
    // Then: a success (OK - 200) status code is returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    
    // And: the actual list returned is the same as the expected list
    List<Shoe> expected = buildExpected();
    assertThat(response.getBody()).isEqualTo(expected);
  }
  
  /**
   * @return
   */
  private List<Shoe> buildExpected() {
    // TODO Auto-generated method stub
    return null;
  }


  @LocalServerPort
  private int serverPort;


  @Autowired
  @Getter
  private TestRestTemplate restTemplate;
  
/*
 * 
 * @return
 */
  
  protected String getBaseUri() {
    return String.format("http://localhost:%d/shoes", serverPort);
  }
}
