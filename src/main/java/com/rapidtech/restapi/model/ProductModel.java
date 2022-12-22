package com.rapidtech.restapi.model;

import com.rapidtech.restapi.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
    private Long id;
    private String code;
    private String name;
    private Double price;
    private Long categoryId;
    private String categoryName;

    private Long supplierId;
    private String supplierName;

    public ProductModel(ProductEntity entity){
        BeanUtils.copyProperties(entity, this);
        if(entity.getCategory() != null) {
            this.categoryName = entity.getCategory().getName();
        }
        if(entity.getSupplier() != null) {
            this.supplierName = entity.getSupplier().getSupplierName();
        }
    }

    public ProductModel(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

}
