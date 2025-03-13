package com.example.Blockbuster_API.utility;

import com.example.Blockbuster_API.models.Movie;
import com.example.Blockbuster_API.models.MovieGenre;
import com.example.Blockbuster_API.repository.MovieRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader {
    private final MovieRepository movieRepository;

    public DataLoader(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @PostConstruct
    public void loadData() {
        movieRepository.saveAll(
                List.of(
                        new Movie("Inception", 2009, true, MovieGenre.ACTION),
                        new Movie("GoodFellas", 1990, true, MovieGenre.HORROR)

                )
        );
    }
}