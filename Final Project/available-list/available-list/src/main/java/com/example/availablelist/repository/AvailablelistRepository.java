package com.example.availablelist.repository;

import com.example.availablelist.entity.Availablelist;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AvailablelistRepository extends MongoRepository<Availablelist,Long> {
Optional<List<Availablelist>> findByDate(String date);


}
