package com.example.Test1.Models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Entity
@Table(name = "ingredient")
public class Ingredients {

    @Id
    @Column(length = 4)
    private final String id;
    private final String name;

    @Enumerated(EnumType.STRING)
    private final Type type;

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

    // Additional methods or code can be added here

}
