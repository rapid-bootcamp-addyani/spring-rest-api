package com.rapidtech.restapi.repository;

import com.rapidtech.restapi.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepo extends JpaRepository<SupplierEntity, Long> {
}
