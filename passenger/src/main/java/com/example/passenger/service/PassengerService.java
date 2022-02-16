package com.example.passenger.service;

import com.example.passenger.entity.Passenger;
import com.example.passenger.repository.PassengerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PassengerService {

    @Autowired
    private PassengerRepository passRepo;

    public List<Passenger> findAllPassenger(){
        return passRepo.findAll();
    }

    public Passenger savePassenger(Passenger passenger){
        log.info("Inside Passenger- save passenger");
//        System.out.println(passenger.toString());
        return passRepo.save(passenger);
    }

    public Passenger findPassengerByPId(String pId){
        return passRepo.findPassengerBypId(pId);
    }

    public Passenger updatePassenger(String pId, Passenger pass){
        System.out.println(pId);
        Passenger passenger = passRepo.findPassengerBypId(pId);

            passenger.setName(pass.getName());
            passenger.setfId(pass.getfId());
            passenger.setCountry(pass.getCountry());
            passenger.setPassportNo(pass.getPassportNo());
            passenger.setAadharNo(pass.getAadharNo());

            return passRepo.save(passenger);

    }



    public String deleteAllPassenger(){
        try {
            passRepo.deleteAll();
            return "EMPTY";
        }
        catch(Exception ex)
        {
            return "ERROR";
        }
    }

    public String deletePassenger(String id) {
        try {
            passRepo.deleteById(id);
            return "Deleted the ID";
        } catch (Exception ex) {
            return "Error";
        }
    }

}
