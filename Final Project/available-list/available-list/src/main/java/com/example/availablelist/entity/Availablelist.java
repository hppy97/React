package com.example.availablelist.entity;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.*;

//@Entity
@Document(collection = "lists")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Availablelist {

//   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String flightId;
    private String flightName;
    private String flightFrom;
    private String flightTo;
    private String date;
    private Long price;

}
