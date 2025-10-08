package io.github.pedro_alves_arruda.States.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.pedro_alves_arruda.States.dto.States;
import io.github.pedro_alves_arruda.States.repository.StateRepository;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    /**
     * Returns a list of State DTOs for a given country name.
     * The search is case-insensitive and mapping is performed here.
     */
    public List<States> getStatesByCountryName(String countryName) {
        try {
            return stateRepository.findByCountryName(countryName)
                    .stream()
                    .map(s -> new States(s.getName()))
                    .toList();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get states for country: " + countryName, e);
        }
    }
}
