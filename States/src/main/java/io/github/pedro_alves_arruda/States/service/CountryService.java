package io.github.pedro_alves_arruda.States.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.pedro_alves_arruda.States.dto.CountryDto;
import io.github.pedro_alves_arruda.States.repository.CountryRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<CountryDto> getAllCountries() {
        try {
            return countryRepository.findAll()
                    .stream()
                    .map(c -> new CountryDto(c.getId(), c.getName()))
                    .toList();
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve countries", e);
        }
    }
}
