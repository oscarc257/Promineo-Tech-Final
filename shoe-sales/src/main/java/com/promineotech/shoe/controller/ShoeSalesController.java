package com.promineotech.shoe.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.shoe.entity.Shoe;
import com.promineotech.shoe.entity.ShoeBrand;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

/**
 * @author Ozcar
 *
 */

@Validated
@RequestMapping("/shoes")
@OpenAPIDefinition(info = @Info(title = "Shoe Sales Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server")}) 

public interface ShoeSalesController {
  //Determines what will return when connecting to the local server. 
  @Operation(
        summary = "Returns a list of Shoes",
        description = "Returns a list of Shoes given an optional brand and/or model",
        responses = {
            
            @ApiResponse(responseCode = "200", 
                description = "A list of Shoes is returned", 
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = Shoe.class))),
            
            @ApiResponse(responseCode = "400", 
            description = "The request parmaters are invalid", 
            content = @Content(
                mediaType = "application/json")),
            
            
            @ApiResponse(responseCode = "404", 
            description = "No Shoes were found with the input criteria", 
            content = @Content(
                mediaType = "application/json")),
            
            
            @ApiResponse(responseCode = "500", 
            description = "An unplanned error occurred", 
            content = @Content(
                mediaType = "application/json")) 
            
        },
        parameters = {
            @Parameter(
                name ="brand", 
                allowEmptyValue = false, 
                required = false, 
                description = "The brand name (i.e., 'NIKE')"),
            @Parameter(
                name ="model", 
                allowEmptyValue = false, 
                required = false, 
                description = "The model level (i.e., 'Air Force 1')"),
        }
      
       )
    
    
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<Shoe> fetchShoes(
        @RequestParam (required = false)
        ShoeBrand brand,
        @RequestParam (required = false)
        String model);

}