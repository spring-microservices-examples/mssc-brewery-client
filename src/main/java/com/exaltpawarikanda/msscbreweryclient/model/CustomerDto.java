package com.exaltpawarikanda.msscbreweryclient.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Created by Exalt Pawarikanda on 7/25/21
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CustomerDto {
    private UUID customerId;
    private String name;
}
