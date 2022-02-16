package com.example.flightlistservice.controller;


import com.example.flightlistservice.entity.FlightList;
import com.example.flightlistservice.repository.FlightListRepository;
import com.example.flightlistservice.service.FlightListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flightList")
public class FlightListController {

    @Autowired
    private FlightListService flightListService;


    @PostMapping("/")
    public FlightList saveFlight(@RequestBody FlightList flightList)
    {

        return flightListService.saveFlight(flightList);
    }

    @GetMapping("/allFlights")
    public ResponseEntity<List<FlightList>>  getFlightList()
    {
        return flightListService.getFlightList();
    }


    @GetMapping("/{id}")
    public FlightList findFlightById(@PathVariable("id") String id){

        return flightListService.findFlightById(id);
    }

    @PutMapping("/flights/{id}")
    public ResponseEntity<FlightList> updateFlight(@PathVariable("id") String id, @RequestBody FlightList flight)
    {
        return flightListService.updateFlight(id,flight);

        }



    @DeleteMapping("/deleteFlights")
    public ResponseEntity<HttpStatus> deleteAllFlights(){
        return flightListService.deleteAllFlights();
    }

    @DeleteMapping("/deleteFlight/{id}")
    public ResponseEntity<HttpStatus> deleteFlight(@PathVariable("id") String id) {
       return flightListService.deleteFlight(id);
    }



}





