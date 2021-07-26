package com.exaltpawarikanda.msscbreweryclient.client;

import com.exaltpawarikanda.msscbreweryclient.model.BeerDto;
import com.exaltpawarikanda.msscbreweryclient.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Exalt Pawarikanda on 7/26/21
 */
@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void given_beerId_when_getById_then_return_beerDto() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void given_beerDto_when_createBeer_then_return_createdBeerUrl() {
        BeerDto newBeerDto = BeerDto.builder()
                .beerName("New Beer")
                .build();

        URI url = client.createBeer(newBeerDto);
        assertNotNull(url);
        System.out.println(url);
    }

    @Test
    void given_updatedDto_when_updateBeer_then_success() {
        BeerDto updatedDto = BeerDto.builder()
                .beerName("Updated Beer Name ")
                .build();
        client.updateBeer(UUID.randomUUID(),updatedDto);
    }

    @Test
    void given_beerId_when_deleteById_then_success() {
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void given_CustomerId_when_GetById_then_CustomerDto() {
        CustomerDto customerDto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void given_CustomerDto_when_CreateCustomer_then_CreatedCustomerUri() {
        CustomerDto newCustomerDto = CustomerDto.builder()
                .name("Test Customer")
                .build();

        URI uri = client.createCustomer(newCustomerDto);
        assertNotNull(uri);
    }

    @Test
    void given_UpdatedCustomerDto_when_UpdateCustomerById_then_Success () {
    CustomerDto updatedCustomerDto = CustomerDto.builder()
            .name("Updated Customer")
            .build();
    client.updateCustomer(UUID.randomUUID(),updatedCustomerDto);
    }

    @Test
    void given_CustomerId_when_DeleteCustomer_then_Success() {
    client.deleteCustomer(UUID.randomUUID());
    }
}