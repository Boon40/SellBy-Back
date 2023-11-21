package com.sellby.sellby.controller;


import com.sellby.sellby.model.entity.State;
import com.sellby.sellby.model.response.ProductResponse;
import com.sellby.sellby.model.response.StateResponse;
import com.sellby.sellby.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/states")
@RequiredArgsConstructor
public class StateController {

    private final StateService stateService;

    @GetMapping
    public ResponseEntity<List<StateResponse>> getAllStates() {
        return ResponseEntity.ok(stateService.getAllStates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StateResponse> getStateById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(stateService.getStateById(Integer.valueOf(id)));
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
