package com.example.availablelist.service;


import com.example.availablelist.entity.Availablelist;
import com.example.availablelist.repository.AvailablelistRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AvailablelistService {

    @Autowired
    private AvailablelistRepository listRepository;


    public Availablelist saveList(Availablelist list) {
//        log.info("Inside Game Service - Save Game");
        return listRepository.save(list);
    }


    public ResponseEntity<List<Availablelist>> getFlightList() {
        try {
            List<Availablelist> flights = new ArrayList<Availablelist>();
            listRepository.findAll().forEach(flights::add);
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

    public Availablelist findFlightById(Long id) {
        Optional<Availablelist> flightData = listRepository.findById(id);
        if (flightData.isPresent()) {
            Availablelist _flight = flightData.get();
            return _flight;
        } else {
            return null;
        }

    }


    public ResponseEntity<Availablelist> updateFlight(Long id, Availablelist flight) {

        Optional<Availablelist> flightData = listRepository.findById(id);

        if (flightData.isPresent()) {
            Availablelist _flight = flightData.get();

            _flight.setId(flight.getId());
            _flight.setFlightId(flight.getFlightId());
            _flight.setFlightName(flight.getFlightName());
            _flight.setFlightFrom(flight.getFlightFrom());
            _flight.setFlightTo(flight.getFlightTo());
            _flight.setDate(flight.getDate());
            _flight.setPrice(flight.getPrice());

            return new ResponseEntity<>(listRepository.save(_flight), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    public ResponseEntity<HttpStatus> deleteAllFlights() {
        try {
            listRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<HttpStatus> deleteFlight(Long id) {

        try {
            listRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    //validate
    public ResponseEntity<List<Availablelist>> validateFlight(Availablelist list) {
        List<Availablelist> flights = new ArrayList<Availablelist>();
        String date = list.getDate();
        String from = list.getFlightFrom();
        String to = list.getFlightTo();
        Optional<List<Availablelist>> u1 = listRepository.findByDate(date);
        if (u1.isPresent()) {
            List<Availablelist> us1 = u1.get();
            for (Availablelist i:us1) {
                String check=i.getFlightFrom();

//                System.out.println(check);
                String check1=i.getFlightTo();
//                System.out.println(check1);
                if(check.equalsIgnoreCase(from) && check1.equalsIgnoreCase(to))
                {
                    System.out.println("success");
                    flights.add(i);

                }
                else
                {
                    System.out.println("fail");
                }
            }


System.out.println(flights);
}
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

}
