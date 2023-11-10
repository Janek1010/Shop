package com.example.shop.customer.model;

import com.example.shop.customer.model.dto.CustomerDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetCustomersResponse {
    private List<CustomerDTO> customers;
}
