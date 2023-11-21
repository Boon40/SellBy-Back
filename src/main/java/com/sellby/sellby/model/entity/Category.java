package com.sellby.sellby.model.entity;

import com.sellby.sellby.model.enums.CategoryEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private CategoryEnum category;

    public String ToString(){
        return this.category.toString();
    }
}
