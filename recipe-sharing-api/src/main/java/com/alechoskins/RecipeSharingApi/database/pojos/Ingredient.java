package com.alechoskins.RecipeSharingApi.database.pojos;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Ingredient {

    //region PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String upc;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private BigDecimal ozPerUnit;
    //endregion

    //region RELATIONSHIPS
    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL)
    private List<StoreLocation_Ingredient> storeLocation_ingredient;
    //endregion

}
