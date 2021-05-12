package com.example.distributedquartzdemo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue
    private int id;

    private String title;

    private String isbn;

    private String description;
}
