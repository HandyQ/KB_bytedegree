package com.kb.shop.service;

import lombok.AllArgsConstructor;
import com.kb.shop.domain.ShippingInfo;
import org.example.repository.ShippingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class ShippingService {
  
  private final ShippingRepository ShippingRepository;

  public ShippingInfo add(ShippingRequest request) {
      ShippingInfo shippingInfo = new ShippingInfo();
      shippingInfo.setOrder(request.getOrder());
      shippingInfo.setCompleted(request.getCompleted());
      return this.shippingRepository.save(shippingInfo);
  }
  public ShippingEntity searchById(Long id) {
       return this.shippingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }
  public ShippingEntity updateById(Long id, ShippingRequest request) {
      ShippingInfo shippingInfo = this.searchById(id);
      if (request.getTitle() != null) {
          shippingEntity.setTitle(request.getTitle());
      }
      if (request.getOrder() != null) {
          shippingEntity.setOrder(request.getOrder());
      }
      if (request.getCompleted() != null) {
          shippingEntity.setCompleted(request.getCompleted());
      }
      return this.shippingRepository.save(shippingEntity);
  }
}
