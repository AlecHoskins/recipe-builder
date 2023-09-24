package com.alechoskins.RecipeSharingApi.database.pojos;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class StoreLocation_Ingredient {

    //region PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false, unique = true)
    private String sku;
    @Column(nullable = false)
    private BigDecimal pricePerUnit;
    @Column(nullable = true)
    private String description;
    @Column(nullable = true)
    private String url;
    @Column
    private String imageUrl;
    //endregion

    //region RELATIONSHIPS
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;
    @ManyToOne
    @JoinColumn(name = "store_location_id")
    private StoreLocation storeLocation;
    //endregion

}