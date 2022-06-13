package com.genpt.springdatajpa.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Items {
    @Id
    private int id;
    private String description;
    private String brand;
    private double price;
}
