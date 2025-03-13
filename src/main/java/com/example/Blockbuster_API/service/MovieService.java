package com.example.Blockbuster_API.service;


import com.example.Blockbuster_API.models.Movie;
import com.example.Blockbuster_API.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public Iterable<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Long id){
        return movieRepository.findById(id);
    }
}
