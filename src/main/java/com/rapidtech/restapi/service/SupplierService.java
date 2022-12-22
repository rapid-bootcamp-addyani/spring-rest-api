package com.rapidtech.restapi.service;

import com.rapidtech.restapi.model.SupplierModel;

import java.util.List;
import java.util.Optional;

public interface SupplierService {
    List<SupplierModel> getAll();
    Optional<SupplierModel> getById(Long id);
    Optional<SupplierModel> save(SupplierModel model);
    Optional<SupplierModel> update(Long id, SupplierModel model);
    Optional<SupplierModel> delete(Long id);
}
