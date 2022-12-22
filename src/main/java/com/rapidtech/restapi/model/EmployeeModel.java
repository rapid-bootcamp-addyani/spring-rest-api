package com.rapidtech.restapi.model;

import com.rapidtech.restapi.entity.EmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {
    private Long id;
    private String employeeName;
    private String address;

    private String gender;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    private String placeOfBirth;

    private String city;

    private String country;

    private String postalCode;
    private String notes;

    public EmployeeModel(EmployeeEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
