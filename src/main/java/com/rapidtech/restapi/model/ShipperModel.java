package com.rapidtech.restapi.model;

import com.rapidtech.restapi.entity.ShipperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipperModel {
    private Long id;
    private String shipperName;
    private String phone;

    public ShipperModel(ShipperEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
