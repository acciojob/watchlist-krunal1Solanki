package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;


    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        String message = movieService.addMovie(movie);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        String message = movieService.addDirector(director);
        return new ResponseEntity<>(message,HttpStatus.CREATED);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movieName,@RequestParam("director") String directorName){
        String message = movieService.addMovieDirectorPair(movieName,directorName);
        return new ResponseEntity<>(message,HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        Movie m = movieService.getMovieByName(name);
        return new ResponseEntity<>(m,HttpStatus.CREATED);

    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director d = movieService.getDirectorByName(name);
        return new ResponseEntity<>(d,HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movies-by-director-name/{name}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String name){
        List<String> ar = movieService.getMoviesByDirectorName(name);
        return new ResponseEntity<>(ar,HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> ar = movieService.findAllMovies();
        return new ResponseEntity<>(ar,HttpStatus.CREATED);
    }

    @DeleteMapping("movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name") String name){
        String message = movieService.deleteDirectorByName(name);
        return new ResponseEntity<>(message,HttpStatus.CREATED);
    }

    @DeleteMapping("movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        String message =  movieService.deleteAllDirectors();
        return new ResponseEntity<>(message,HttpStatus.CREATED);
    }
}