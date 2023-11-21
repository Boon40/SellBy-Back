package com.sellby.sellby.repository;

import com.sellby.sellby.model.entity.Comment;
import com.sellby.sellby.model.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
}
