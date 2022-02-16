package com.example.passenger.controller;

import com.example.passenger.entity.Passenger;
import com.example.passenger.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/passenger")

public class PassengerController {
    @Autowired
    private PassengerService passService;

    @PostMapping("/")
    public Passenger savePassenger(@RequestBody Passenger passenger){
        System.out.println(passenger.toString());
        return passService.savePassenger(passenger);
    }

    @GetMapping("/")
    public List<Passenger> findAllPassenger(){
        return passService.findAllPassenger();
    }

    @GetMapping("/{pId}")
    public Passenger findPassengerByPid(@PathVariable("pId") String id){
        return passService.findPassengerByPId(id);
    }

    @PutMapping("/{pId}")
    public Passenger updateFlight(@PathVariable("pId") String pId, @RequestBody Passenger pass)
    {
        return passService.updatePassenger(pId,pass);

    }



    @DeleteMapping("/")
    public String deleteAllPassenger(){
        return passService.deleteAllPassenger();
   }

    @DeleteMapping("/{pId}")
    public String deleteFlight(@PathVariable("pId") String id) {
        return passService.deletePassenger(id);
    }

}
