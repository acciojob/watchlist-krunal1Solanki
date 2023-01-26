package com.driver;

import java.util.*;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {

    public ArrayList<Movie> mv = new ArrayList<>();
    public ArrayList<Director> dr = new ArrayList<>();
    public Map<Director,ArrayList<Movie>> mp = new HashMap<>();

    public String addMovie(Movie movie){
        for(int i=0;i<mv.size();i++){
            Movie m = mv.get(i);
            if(m.getName().equals(movie.getName()) && m.getDurationInMinutes() == movie.getDurationInMinutes() && m.getImdbRating() == movie.getImdbRating()){
                return "Movie already added.";
            }
        }
        mv.add(movie);
        return "Movie successfully added.";
    }

    public String addDirector(Director director){
        for(int i=0;i<dr.size();i++){
            Director d = dr.get(i);
            if(d.getName().equals(director.getName())){
                return "Director already added.";
            }
        }
        dr.add(director);
        return "Director successfully added.";
    }

    public String addMovieDirectorPair(String movieName, String directorName){
        Movie m = null;
        Director d = null;
        for(int i=0;i<mv.size();i++){
            if(mv.get(i).getName().equals(movieName)){
                m = mv.get(i);
            }
        }
        for(int i=0;i<dr.size();i++){
            if(dr.get(i).getName().equals(directorName)){
                d = dr.get(i);
            }
        }

        if(!mp.containsKey(d)){
            ArrayList<Movie> ar = new ArrayList<>();
            ar.add(m);
            mp.put(d,ar);
            return "Pair added successfully";
        }
        ArrayList<Movie> movie = mp.get(d);
        movie.add(m);
        mp.put(d,movie);
        return "Pair added successfully.";
    }

    public Movie getMovieByName(String name){
        for(int i=0;i<mv.size();i++){
            if(mv.get(i).getName().equals(name)){
                return mv.get(i);
            }
        }
        return null;
    }

    public Director getDirectorByName(String name){
        for(int i=0;i<dr.size();i++){
            if(dr.get(i).getName().equals(name)){
                return dr.get(i);
            }
        }
        return null;
    }

    public List<String> getMoviesByDirectorName(String name){
        Director d = null;
        for(int i=0;i<dr.size();i++){
            if(dr.get(i).getName().equals(name)){
                d = dr.get(i);
                break;
            }
        }
        ArrayList<Movie> am= mp.get(d);
        List<String> ar = new ArrayList<>();
        for(int i=0;i<am.size();i++){
            ar.add(am.get(i).getName());
        }
        return ar;
    }

    public List<String> findAllMovies(){
        List<String> ar = new ArrayList<>();
        for(int i=0;i<mv.size();i++){
            ar.add(mv.get(i).getName());
        }
        return ar;
    }

    public String deleteDirectorByName(String name){
        Director d = null;
        for(int i=0;i<dr.size();i++){
            if(dr.get(i).getName().equals(name)){
                d = dr.get(i);
                break;
            }
        }
        ArrayList<Movie> ar = mp.get(d);
        mp.remove(d);
        dr.remove(d);
        for(int i=0;i<ar.size();i++){
            mv.remove(ar.get(i));
        }
        return "Director movies removed successfully.";
    }

    public String deleteAllDirectors(){
        for(int i=0;i<dr.size();i++){
            ArrayList<Movie> ar = mp.get(dr.get(i));
            for(int j=0;j<ar.size();j++){
                mv.remove(ar.get(j));
            }
        }
        mp.clear();
        dr.clear();
        return "All the directors and movies removed successfully.";
    }



}