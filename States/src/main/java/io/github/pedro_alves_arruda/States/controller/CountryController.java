package io.github.pedro_alves_arruda.States.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.pedro_alves_arruda.States.dto.CountryDto;
import io.github.pedro_alves_arruda.States.service.CountryService;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity<List<CountryDto>> getAllCountries() {
        try {
            List<CountryDto> dtos = countryService.getAllCountries();
            return ResponseEntity.ok(dtos);
        } catch (Exception e) {
            throw new RuntimeException("Error while retrieving countries", e);
        }
    }
}
