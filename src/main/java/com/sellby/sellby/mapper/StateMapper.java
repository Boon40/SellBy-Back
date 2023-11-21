package com.sellby.sellby.mapper;

import com.sellby.sellby.model.entity.Product;
import com.sellby.sellby.model.entity.State;
import com.sellby.sellby.model.request.ProductRequest;
import com.sellby.sellby.model.request.StateRequest;
import com.sellby.sellby.model.response.ProductResponse;
import com.sellby.sellby.model.response.StateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StateMapper {

    public StateResponse toResponse(State state){
        return new StateResponse(
                state.getId(),
                state.getState(),
                state.ToString()
        );
    }

    public State toEntity(StateRequest request){
        return State.builder()
                .state(request.getState())
                .build();
    }
}
