package com.rapidtech.restapi.model;

import com.rapidtech.restapi.entity.SupplierEntity;
import org.springframework.beans.BeanUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SupplierModel {
    private Long id;
    private String supplierName;
    private String contactName;
    private String address;
    private String city;
    private String country;
    private String postalCode;
    private String phone;

    public SupplierModel(SupplierEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
