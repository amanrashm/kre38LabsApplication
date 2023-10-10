package org.kre38Labs.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
}