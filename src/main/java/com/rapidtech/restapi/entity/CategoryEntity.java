package com.rapidtech.restapi.entity;

import com.rapidtech.restapi.model.CategoryModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "category_tab")
public class CategoryEntity {
    @Id
    @TableGenerator(name = "category_id_generator", table = "sequence_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue="category_id", initialValue=0, allocationSize=0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "category_id_generator")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_code", length = 20, nullable = false)
    private String code;

    @Column(name = "category_name", length = 100, nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<ProductEntity> products = new HashSet<>();

    public CategoryEntity(CategoryModel model) {
        BeanUtils.copyProperties(model, this);
    }
}
