package com.kb.shop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ShippingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Order id
    @Column(name = "orderId", nullable = false)
    private Long order;
    
    // OrderItem id
    @Column(name = "orderItemId", nullable = false)
    private Long item;
    
    // shippingStatus
	@Column(nullable = false)
    private Boolean completed;

}
