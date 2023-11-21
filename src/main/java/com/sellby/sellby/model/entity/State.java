package com.sellby.sellby.model.entity;

import com.sellby.sellby.model.enums.StateEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private StateEnum state;

    public String ToString(){
        return this.state.toString();
    }
}
