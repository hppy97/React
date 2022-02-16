package com.example.flightlistservice.service;


import com.example.flightlistservice.controller.FlightListController;
import com.example.flightlistservice.entity.FlightList;
import com.example.flightlistservice.repository.FlightListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class FlightListService {

    @Autowired
    private FlightListRepository repo;


    public FlightList saveFlight(FlightList flightList) {

        return repo.save(flightList);
    }

    public ResponseEntity<List<FlightList>> getFlightList() {
        try {
            List<FlightList> flights = new ArrayList<FlightList>();
            repo.findAll().forEach(flights::add);
            if (flights.isEmpty()) {
                return new ResponseEntity<>(flights, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(flights, HttpStatus.OK);
            }
        } catch (Exception ex) {
            System.out.println("Exception " + ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    public FlightList findFlightById(String id) {
        Optional<FlightList> flightData = repo.findById(id);
        if(flightData.isPresent()){
            FlightList _flight = flightData.get();
            return _flight;
        }
        else{
            return null;
        }

    }

    public ResponseEntity<FlightList> updateFlight(String id, FlightList flight) {

        Optional<FlightList> flightData = repo.findById(id);

        if (flightData.isPresent()) {
            FlightList _flight = flightData.get();

            _flight.setId(flight.getId());
            _flight.setName(flight.getName());

            _flight.setTotalPassengers(flight.getTotalPassengers());

            return new ResponseEntity<>(repo.save(_flight), HttpStatus.OK);
        }

        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    public ResponseEntity<HttpStatus> deleteAllFlights() {
        try {
            repo.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception ex)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<HttpStatus> deleteFlight(String id) {

        try {
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
