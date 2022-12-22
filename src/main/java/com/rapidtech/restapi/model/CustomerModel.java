package com.rapidtech.restapi.model;

import com.rapidtech.restapi.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerModel {
    private Long id;
    private String fullName;
    private String address;

    private String gender;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    private String placeOfBirth;

    private String city;

    private String country;

    private String postalCode;

    public CustomerModel(CustomerEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
