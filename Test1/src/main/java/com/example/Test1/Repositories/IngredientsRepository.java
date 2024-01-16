package com.example.Test1.Repositories;
import org.springframework.data.repository.CrudRepository;
import com.example.Test1.Models.Ingredients;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientsRepository extends CrudRepository<Ingredients,String>{
}