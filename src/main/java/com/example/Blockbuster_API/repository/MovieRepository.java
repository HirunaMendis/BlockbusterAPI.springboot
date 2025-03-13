package com.example.Blockbuster_API.repository;


import com.example.Blockbuster_API.models.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie , Long> {

}
