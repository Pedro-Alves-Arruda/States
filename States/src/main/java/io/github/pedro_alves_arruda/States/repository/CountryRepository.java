package io.github.pedro_alves_arruda.States.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.pedro_alves_arruda.States.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, UUID> {
    Optional<Country> findByNameIgnoreCase(String name);
    List<Country> findAll();
}
