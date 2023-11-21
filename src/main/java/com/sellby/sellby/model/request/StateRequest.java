package com.sellby.sellby.model.request;


import com.sellby.sellby.model.enums.StateEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StateRequest {
    @NotNull(message = "State is required")
    private StateEnum state;
}
