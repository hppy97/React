package com.example.passenger.repository;

import com.example.passenger.entity.Passenger;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends MongoRepository<Passenger, String> {
    Passenger findPassengerBypId(String pId);
}
