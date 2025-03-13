package com.example.Blockbuster_API.Controllers;

import com.example.Blockbuster_API.models.Movie;
import com.example.Blockbuster_API.models.MovieGenre;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/movies")

public class MovieController {
    //define a hashmap with movies and add movies
    //use Atomiclong class to get IDs for movie objects

    private Map<Long, Movie> movies = new HashMap<>();
    private  final AtomicLong idCounter = new AtomicLong();

    public MovieController() {
        Movie M1 = new Movie("Eternals" , 2022 , true , MovieGenre.FANTASY);
        M1.setID(idCounter.incrementAndGet());
        movies.put(M1.getID(), M1);

        Movie M2 = new Movie("Maze Runner" , 2021 , true , MovieGenre.ACTION);
        M2.setID(idCounter.incrementAndGet());
        movies.put(M2.getID(), M2);

        Movie M3 = new Movie("Dune" , 2024 , false , MovieGenre.FANTASY);
        M3.setID(idCounter.incrementAndGet());
        movies.put(M3.getID(), M3);
        //create movie objects add them to hashmap
    }
    @GetMapping
    public ResponseEntity<Map<Long, Movie>> getMovies(){
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{ID}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long ID){
        Movie movie = movies.get(ID);
        if(movie!= null){
            return ResponseEntity.ok(movie);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Movie> createNewMovie(@RequestBody Movie movieDetails){
        movieDetails.setID(idCounter.incrementAndGet());
        movies.put(movieDetails.getID(),movieDetails);
        return ResponseEntity.ok(movieDetails);
    }

    @PutMapping("/{ID}")
    public ResponseEntity<Movie> updateMovieById(@PathVariable long ID , @RequestBody Movie movieDetails){
        Movie movie = movies.get(ID);
        if(movie==null){
            return ResponseEntity.notFound().build();
        }
        movieDetails.setID(ID);
        movies.put(ID, movieDetails);
        return ResponseEntity.ok(movieDetails);

    }

    @DeleteMapping("/{ID}")
    public void deleteMovieByID(@PathVariable long ID){
        movies.remove(ID);
    }
}

