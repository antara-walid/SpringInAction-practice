package com.example.tacos;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class Taco {
    @NotNull
    @Size(min=5 ,message = "name must be at lest 5 characters long ")
    private String name;
    @NotNull
    @Size(min = 1 ,message = "select at least one ingredient")
    private List<Ingredient> ingredients;
}