package com.example.flightlistservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "flights")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightList {


  @Id

    private String id;
    private String name;
    private int totalPassengers;


}
