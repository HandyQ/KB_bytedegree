package com.kb.shop.controller;

import lombok.AllArgsConstructor;
import com.kb.shop.domain.ShippingInfo;
import com.kb.shop.service;
import org.example.repository.ShippingRepository;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ShippingController {
	
    private final ShippingService service;
    
    // 배송 정보를 생성하는 POST 호출을 생성합니다. (path : /shipping)
    @PostMapping("/shipping/{id}")
    public ResponseEntity<ShippingResponse> create(@RequestBody ShippingRequest request) {
        //System.out.println("CREATE");
        ShippingEntity result = this.service.add(request);
    }
    
    // 배송 Status를 변경하는 PUT 호출을 생성합니다. (path : /shipping)
    @PatchMapping("/shipping/{id}")
    public ResponseEntity<List<ShippingResponse>> update(@PathVariable("id") Long id, @RequestBody ShippingRequest request) {
        //System.out.println("UPDATE");
        ShippingEntity result = this.service.updateById(id, request);
        return ResponseEntity.ok(new ShippingResponse(result));
    }
    // 배송 정보를 확인하는 GET 호출을 생성합니다.  (path : /shipping)
    @GetMapping("/shipping/{id}")
    public ResponseEntity<ShippingResponse> readOne(@PathVariable("id") Long id) {
        //System.out.println("READ ONE");
        ShippingEntity result = this.service.searchById(id);
        return ResponseEntity.ok(new ShippingResponse(result));
    }
}
