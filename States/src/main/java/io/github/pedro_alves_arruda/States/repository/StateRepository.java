package io.github.pedro_alves_arruda.States.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.github.pedro_alves_arruda.States.model.State;

@Repository
public interface StateRepository extends JpaRepository<State, UUID> {

    @Query("select s from State s join s.country c where lower(c.name) = lower(:countryName)")
    List<State> findByCountryName(@Param("countryName") String countryName);
}
