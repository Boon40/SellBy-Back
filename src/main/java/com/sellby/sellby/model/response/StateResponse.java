package com.sellby.sellby.model.response;

import com.sellby.sellby.model.enums.StateEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StateResponse {
    private int id;
    private StateEnum state;
    private String stateString;
}
