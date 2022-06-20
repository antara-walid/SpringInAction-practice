package com.example.tacos;

import lombok.*;
import org.hibernate.validator.constraints.ISBN;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
public class Ingredient implements Persistable<String> {
    @Id
    private  String id;
    private  String name;
    private  Type type;
    @Override
    public boolean isNew() {
        return true;
    }
    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }


}
