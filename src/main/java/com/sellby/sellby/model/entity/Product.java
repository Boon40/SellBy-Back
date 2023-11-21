package com.sellby.sellby.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column(length = 1000)
    @Lob
    private String description;

    @Column
    private float price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seller_id")
    private User seller;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state_id")
    private State state;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<ProductPhoto> photos = new ArrayList<>();

    /*@ManyToMany(mappedBy = "favouriteProducts")
    private List<User> users = new ArrayList<>();*/

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column
    private boolean isBuyerPayingDelivery;

    @Column
    private LocalDate createdDate;

    public Product(String name, String description, float price, User seller, State state, Category category, boolean isBuyerPayingDelivery) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.seller = seller;
        this.state = state;
        this.photos = new ArrayList<>();
        this.category = category;
        this.isBuyerPayingDelivery = isBuyerPayingDelivery;
        this.createdDate = LocalDate.now();
    }

    public boolean getIsBuyerPayingDelivery() {
        return this.isBuyerPayingDelivery;
    }
}
