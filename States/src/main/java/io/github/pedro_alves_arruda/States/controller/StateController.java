package io.github.pedro_alves_arruda.States.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.pedro_alves_arruda.States.dto.States;
import io.github.pedro_alves_arruda.States.service.StateService;

@RestController
@RequestMapping("/api/v1/states")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping
    public ResponseEntity<List<States>> getStatesByCountry(@RequestParam(name = "country") String country) {
        try {
            List<States> states = stateService.getStatesByCountryName(country);
            return ResponseEntity.ok(states);
        } catch (Exception e) {
            throw new RuntimeException("Error while getting states for country: " + country, e);
        }
    }
}
