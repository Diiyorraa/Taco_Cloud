package com.example.Test1.Models;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import lombok.*;

import java.util.ArrayList;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tacos {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;

    private Date createdAt;

    @ManyToMany(targetEntity= Ingredients.class)
    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<Ingredients>ingredients=new ArrayList<>();

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}