package com.rapidtech.restapi.entity;

import com.rapidtech.restapi.model.PurchaseOrderDetailModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "po_detail_tab")
public class PurchaseOrderDetailEntity {
    @Id
    @TableGenerator(name = "po_detail_id_generator", table = "sequence_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue="po_detail_id", initialValue=0, allocationSize=0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "po_detail_id_generator")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "po_id")
    private Long poId;
    @ManyToOne
    @JoinColumn(name = "po_id", insertable = false, updatable = false)
    private PurchaseOrderEntity purchaseOrder;

    @Column(name = "product_id", nullable = false)
    private Long productId;
    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductEntity product;

    @Column(name = "quantity", nullable = false)
    private Double quantity;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "sub_amount", nullable = false)
    private Double subAmount;

    public PurchaseOrderDetailEntity(PurchaseOrderDetailModel model) {
        this.productId = model.getProductId();
        this.quantity = model.getQuantity();
        this.price = model.getPrice();
        this.subAmount = model.getPrice() * model.getQuantity();
    }
//    public PurchaseOrderDetailEntity(PurchaseOrderDetailModel model) {
//        BeanUtils.copyProperties(model, this);
//    }

}
