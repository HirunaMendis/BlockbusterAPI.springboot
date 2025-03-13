package com.example.Blockbuster_API.models;

import jakarta.persistence.*;

@Entity(name = "MovieTable")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID ;
    private String title;
    private int releaseYear;
    private boolean available;
    @Enumerated(EnumType.STRING)
    private MovieGenre movieGenre;

    public Movie(String title, int releaseYear, boolean available, MovieGenre movieGenre) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.available = available;
        this.movieGenre = movieGenre;
    }

    public Movie() {
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public MovieGenre getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(MovieGenre movieGenre) {
        this.movieGenre = movieGenre;
    }
}
