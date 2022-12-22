package com.rapidtech.restapi.controller;

import com.rapidtech.restapi.model.PurchaseOrderModel;
import com.rapidtech.restapi.model.ResponseModel;
import com.rapidtech.restapi.service.PurchaseOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/po")

public class PoController {
    private PurchaseOrderService poService;

    @Autowired
    public PoController(PurchaseOrderService poService) {
        this.poService = poService;
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveCategory(@RequestBody PurchaseOrderModel request){
        Optional<PurchaseOrderModel> result = poService.save(request);
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS", result)
        );
    }

}
