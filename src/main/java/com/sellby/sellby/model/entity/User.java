package com.sellby.sellby.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String number;
    private String first_name;
    private String last_name;
    private String password_hash;
    @OneToMany(mappedBy = "seller")
    private List<Product> products = new ArrayList<>();
    @OneToMany(mappedBy = "sender")
    private List<Comment> sendComments = new ArrayList<>();
    @OneToMany(mappedBy = "receiver")
    private List<Comment> receivedComments = new ArrayList<>();
    /*@ManyToMany
    @JoinTable(
            name = "favourite_products",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> favouriteProducts = new ArrayList<>();*/
    private String country;
    private String city;
    private LocalDate createdDate;

}
