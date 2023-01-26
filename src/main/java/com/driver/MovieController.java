package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie) {
        return movieService.add_Movie(movie);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity addDirector(@RequestBody Director director) {
        return movieService.add_Director(director);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam String movieName, @RequestParam String dirName) {
        return movieService.add_MovieDirectorPair(movieName, dirName);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable String name) {
        return movieService.get_MovieByName(name);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable String name) {
        return movieService.get_DirectorByName(name);
    }

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable String dirName) {
        return movieService.get_MoviesByDirectorName(dirName);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity findAllMovies() {
        return movieService.find_AllMovies();
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam String dirName) {
        return movieService.delete_DirectorByName(dirName);
    }

    @DeleteMapping(" /movies/delete-all-directors")
    public ResponseEntity deleteAllDirectors() {
        return movieService.delete_AllDirectors();
    }


}
