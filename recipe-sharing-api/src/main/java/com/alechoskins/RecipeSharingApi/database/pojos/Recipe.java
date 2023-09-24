package com.alechoskins.RecipeSharingApi.database.pojos;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Recipe {

    //region PROPERTIES

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = true)
    private String description;
    @Column(nullable = false)
    private int minutes;
    @Column(nullable = false)
    private double servings;
    @Column(nullable = false)
    private double price;
    @Column(nullable = true)
    private String link;
    @Column(nullable = true)
    private String imageUrl;


    /*
    ingredients: IngredientDTO[];
    instructions: InstructionDTO[];
    tags: string[];
    * */
    //endregion

    //region RELATIONSHIPS

//    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
//    private List<User_Role> userRoles;

    //endregion
}
