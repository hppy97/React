package com.example.flightlistservice.repository;


import com.example.flightlistservice.entity.FlightList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightListRepository extends MongoRepository<FlightList,String> {





}
