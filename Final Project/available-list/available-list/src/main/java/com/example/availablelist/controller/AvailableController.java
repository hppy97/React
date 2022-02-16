package com.example.availablelist.controller;


import com.example.availablelist.entity.Availablelist;
import com.example.availablelist.service.AvailablelistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins="*")
@RequestMapping("/lists")
@Slf4j
public class AvailableController {

    @Autowired
    private AvailablelistService availService;

    @PostMapping("/")
    public Availablelist saveList(@RequestBody Availablelist list) {
//        log.info("Within Game Controller - save Game");
        return availService.saveList(list);
    }


    @GetMapping("/allFlights")
    public ResponseEntity<List<Availablelist>> getFlightList() {
        return availService.getFlightList();
    }


    @GetMapping("/{id}")
    public Availablelist findFlightById(@PathVariable("id") Long id) {

        return availService.findFlightById(id);
    }

    @PutMapping("/flights/{id}")
    public ResponseEntity<Availablelist> updateFlight(@PathVariable("id") Long id, @RequestBody Availablelist flight) {
        return availService.updateFlight(id, flight);

    }


    @DeleteMapping("/deleteFlights")
    public ResponseEntity<HttpStatus> deleteAllFlights() {
        return availService.deleteAllFlights();
    }

    @DeleteMapping("/deleteFlight/{id}")
    public ResponseEntity<HttpStatus> deleteFlight(@PathVariable("id") Long id) {
        return availService.deleteFlight(id);
    }

//validation

    @PostMapping("/validate")
    public ResponseEntity<List<Availablelist>> validateFlight(@RequestBody Availablelist list) {
          return availService.validateFlight(list);
    }
}