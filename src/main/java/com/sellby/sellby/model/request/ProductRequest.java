package com.sellby.sellby.model.request;

import com.sellby.sellby.model.entity.Category;
import com.sellby.sellby.model.entity.ProductPhoto;
import com.sellby.sellby.model.entity.State;
import com.sellby.sellby.model.entity.User;
import io.micrometer.common.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Price is required")
    private float price;

    @NotNull(message = "Seller is required")
    private int sellerId;

    @NotNull(message = "State is required")
    private int stateId;

    @NotNull(message = "Caregory is required")
    private int categoryId;

    @NotNull(message = "Marking who is paying the delivery is required")
    private boolean isBuyerPayingDelivery;
    public boolean GetIsBuyerPayingDelivery() {
        return isBuyerPayingDelivery;
    }
}
