package com.exaltpawarikanda.msscbreweryclient.client;

import com.exaltpawarikanda.msscbreweryclient.model.BeerDto;
import com.exaltpawarikanda.msscbreweryclient.model.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

/**
 * Created by Exalt Pawarikanda on 7/26/21
 */
@Component
public class BreweryClient {
    @Value("${sfg.brewery.beer-path}")
    private  String BEER_PATH_V1;

    @Value("${sfg.brewery.customer-path}")
    private  String CUSTOMER_PATH_V1;

    @Value("${sfg.brewery.apihost}")
    private  String apihost;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


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
