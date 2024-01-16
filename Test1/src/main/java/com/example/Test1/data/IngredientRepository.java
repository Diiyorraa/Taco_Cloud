package com.example.Test1.data;
import org.springframework.data.repository.CrudRepository;
import com.example.Test1.Ingredient;
public interface IngredientRepository extends CrudRepository<Ingredient,String>{
}