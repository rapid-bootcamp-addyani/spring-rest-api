package com.rapidtech.restapi.entity;

import com.rapidtech.restapi.model.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_tab")
public class ProductEntity {
    @Id
    @TableGenerator(name = "product_id_generator", table = "sequence_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue="product_id", initialValue=0, allocationSize=0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "product_id_generator")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_code", length = 20, nullable = false)
    private String code;

    @Column(name = "product_name", length = 100, nullable = false)
    private String name;

    @Column(name = "product_price")
    private Double price;

    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private CategoryEntity category;

    @Column(name = "supplier_id", nullable = true)
    private Long supplierId;

    @ManyToOne
    @JoinColumn(name = "supplier_id", insertable = false, updatable = false)
    private SupplierEntity supplier;

    @OneToMany(mappedBy = "product")
    private Set<PurchaseOrderDetailEntity> purchaseOrderDetails = new HashSet<>();

    public ProductEntity(ProductModel model) {
        BeanUtils.copyProperties(model, this);
    }
}
