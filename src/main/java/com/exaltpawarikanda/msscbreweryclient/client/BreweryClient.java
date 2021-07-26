package com.exaltpawarikanda.msscbreweryclient.client;

import com.exaltpawarikanda.msscbreweryclient.model.BeerDto;
import com.exaltpawarikanda.msscbreweryclient.model.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

/**
 * Created by Exalt Pawarikanda on 7/26/21
 */
@Component
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "sfg.brewery",ignoreUnknownFields = false)
public class BreweryClient {
    public final String BEER_PATH_V1= "/api/v1/beer/";
    public final String CUSTOMER_PATH_V1= "/api/v1/customers/";
    private String apihost;

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    private final RestTemplate restTemplate;

    public BeerDto getBeerById(UUID uuid){
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + uuid.toString(),BeerDto.class);
    }

    public URI createBeer(BeerDto beerDto){
        return restTemplate.postForLocation(apihost + BEER_PATH_V1,beerDto);
    }

    public void updateBeer(UUID uuid,BeerDto beerDto){
        restTemplate.put(apihost + BEER_PATH_V1 + uuid.toString(),beerDto);
    }

    public void deleteBeer(UUID uuid){
        restTemplate.delete(apihost + BEER_PATH_V1 + uuid.toString());
    }

    public CustomerDto getCustomerById(UUID randomUUID) {
        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 +randomUUID.toString(),CustomerDto.class);
    }

    public URI createCustomer(CustomerDto newCustomerDto) {
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1,newCustomerDto);
    }

    public void updateCustomer(UUID randomUUID, CustomerDto updatedCustomerDto) {
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + randomUUID.toString(),updatedCustomerDto);
    }

    public void deleteCustomer(UUID randomUUID) {
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + randomUUID.toString());
    }
}
