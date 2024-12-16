package com.ecommerce.microservices.dto;

import java.math.BigDecimal;

public record ProductResponse(String Id, String skuCode, String name, String description, BigDecimal price) {
}
