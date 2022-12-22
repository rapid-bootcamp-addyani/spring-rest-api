package com.rapidtech.restapi.service;

import com.rapidtech.restapi.model.PurchaseOrderDetailModel;
import com.rapidtech.restapi.model.PurchaseOrderModel;

import java.util.List;
import java.util.Optional;

public interface PurchaseOrderService {
    Optional<PurchaseOrderModel> save(PurchaseOrderModel model);
}
