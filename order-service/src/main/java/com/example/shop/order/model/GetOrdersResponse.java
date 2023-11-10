package com.example.shop.order.model;

import com.example.shop.order.model.dto.OrderDTO;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetOrdersResponse {
    @Singular
    private List<OrderDTO> orders;
}
