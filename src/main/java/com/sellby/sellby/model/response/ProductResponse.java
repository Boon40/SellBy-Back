package com.sellby.sellby.model.response;


import com.sellby.sellby.model.entity.Category;
import com.sellby.sellby.model.entity.ProductPhoto;
import com.sellby.sellby.model.entity.State;
import com.sellby.sellby.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class ProductResponse {
    private final int id;
    private final String name;
    private final String description;
    private final float price;
    private final UserResponse seller;
    private final StateResponse state;
    private final CategoryResponse category;
    private final boolean isBuyerPayingDelivery;
    private final LocalDate createdDate;
}
