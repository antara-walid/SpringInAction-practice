package com.example.tacos;

import lombok.*;
import org.springframework.data.domain.Persistable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PUBLIC, force=true)
public class Ingredient {
    @Id
    private  String id;
    private  String name;
    private  Type type;
    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }


}
