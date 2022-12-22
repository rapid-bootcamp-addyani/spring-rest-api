package com.rapidtech.restapi.repository;

import com.rapidtech.restapi.entity.PurchaseOrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderDetailRepo extends JpaRepository<PurchaseOrderDetailEntity, Long> {
}
