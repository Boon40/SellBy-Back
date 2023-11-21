package com.sellby.sellby.service;


import com.sellby.sellby.mapper.StateMapper;
import com.sellby.sellby.model.entity.Category;
import com.sellby.sellby.model.entity.Product;
import com.sellby.sellby.model.entity.State;
import com.sellby.sellby.model.response.ProductResponse;
import com.sellby.sellby.model.response.StateResponse;
import com.sellby.sellby.repository.CategoryRepository;
import com.sellby.sellby.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StateService {

    private final StateRepository stateRepository;
    private final StateMapper stateMapper;

    public List<StateResponse> getAllStates(){
        return((List<State>) stateRepository.findAll())
                .stream()
                .map(stateMapper::toResponse)
                .toList();
    }
    public StateResponse getStateById(int id){
        Optional<State> state = stateRepository.findById((long) id);
        return stateMapper.toResponse(state.orElseThrow());
    }
    public State getStateEntityById(int id){
        Optional<State> state = stateRepository.findById((long) id);
        return state.orElse(null);
    }

}
