package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public ResponseEntity add_Movie(@RequestBody Movie movie) {
        movieRepository.add_Movie(movie);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity add_Director(@RequestBody Director director) {
        movieRepository.add_Director(director);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity add_MovieDirectorPair(@RequestParam String movieName, @RequestParam String dirName) {
        movieRepository.add_MovieDirectorPair(movieName, dirName);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity get_MovieByName(@PathVariable String name) {
        Object o = movieRepository.get_MovieByName(name);
        return o == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(o, HttpStatus.FOUND);
    }

    public ResponseEntity get_DirectorByName(@PathVariable String name) {
        Object o = movieRepository.get_DirectorByName(name);
        return o == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(o, HttpStatus.FOUND);

    }

    public ResponseEntity get_MoviesByDirectorName(@PathVariable String dirName) {
        Object o = movieRepository.get_MoviesByDirectorName(dirName);
        return o == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(o, HttpStatus.FOUND);
    }

    public ResponseEntity find_AllMovies() {
        return new ResponseEntity<>(movieRepository.find_AllMovies(), HttpStatus.FOUND);
    }

    public ResponseEntity delete_DirectorByName(@RequestParam String dirName) {
        movieRepository.delete_DirectorByName(dirName);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity delete_AllDirectors() {
        movieRepository.delete_AllDirectors();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
