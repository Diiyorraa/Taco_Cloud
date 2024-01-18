package com.example.Test1.Models;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import lombok.*;

import java.util.ArrayList;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "taco")
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