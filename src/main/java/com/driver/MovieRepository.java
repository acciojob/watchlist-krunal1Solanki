package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Repository
public class MovieRepository {
    List<Movie> moviesList = new ArrayList<>();
    List<Director> directorList = new ArrayList<>();

    HashMap<String, List<String>> dirMoviePair = new HashMap<>();
    public boolean add_Movie(Movie movie) {
        moviesList.add(movie);
        return true;
    }

    public boolean add_Director(Director director) {
        directorList.add(director);
        return true;
    }

    public boolean add_MovieDirectorPair(String movieName, String dirName) {
        if(dirMoviePair.containsKey(dirName)) {
            dirMoviePair.get(dirName).add(movieName);
        } else {
            List<String> list = new ArrayList<>();
            list.add(movieName);
            dirMoviePair.put(dirName, list);
        }

        return true;
    }

    public Movie get_MovieByName(String name) {
        System.out.println(name);
        for(Movie m : moviesList) {
            if(m.getName().equals(name)) {
                System.out.print(m.getName());
                return m;
            }
        }
        return null;
    }

    public Director get_DirectorByName(@PathVariable String name) {
        for(Director d : directorList) {
            if(d.getName().equals(name))
                return d;
        }
        return null;
    }

    public List<String> get_MoviesByDirectorName(@PathVariable String dirName) {
        return dirMoviePair.get(dirName);
    }

    public List<Movie> find_AllMovies() {
        return moviesList;
    }

    public boolean delete_DirectorByName(@RequestParam String dirName) {
        for(int i = 0; i < directorList.size(); i ++) {
            if(directorList.get(i).getName().equals(dirName)) {
                directorList.remove(i);
                break;
            }
        }
        return true;
    }

    public boolean delete_AllDirectors() {
        directorList = new ArrayList<>();
        return true;
    }
}
