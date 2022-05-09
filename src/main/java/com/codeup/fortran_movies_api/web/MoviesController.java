package com.codeup.fortran_movies_api.web;

import com.codeup.fortran_movies_api.data.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin //this is to help with local dev testing
@RestController
@RequestMapping(value = "/api/movies", headers = "Accept=application/json")
public class MoviesController {

    private ArrayList<Movie> moviesList = setMovies();

    @GetMapping("all") // Path becomes: /api/movies/all
    public ArrayList<Movie> getAll(){
        return moviesList;
    }

    // TODO: REVIEW getById METHOD FOR BETTER UNDERSTANDING
    @GetMapping("{id}") // Define the path variable to use here
    public Movie getById(@PathVariable long id) { // Actually use the path variable here by annotating a parameter with @PathVariable
        return moviesList.stream().filter((movie) -> {
                    return movie.getId() == id; // filter out non-matching movies
                })
                .findFirst() // isolate to first match
                .orElse(null); // prevent errors by returning null... not the greatest practice, but it'll do for now
    }

    private ArrayList<Movie> setMovies() {

        ArrayList<Movie> movies = new ArrayList<>();

        movies.add(new Movie(2, "Pulp Fiction", "1994", "Quentin Tarantino",
                "Samuel L. Jackson, Uma Therman, Bruce Willis, John Travolta, Ving Rhames",
                "10", "action, drama, suspense, cult classic, crime",
                "Vincent Vega (John Travolta) and Jules Winnfield (Samuel L. Jackson) are hitmen with a penchant for philosophical discussions. " +
                        "In this ultra-hip, multi-strand crime movie, their storyline is interwoven with those of their boss, " +
                        "gangster Marsellus Wallace (Ving Rhames) ; his actress wife, Mia (Uma Thurman) ; " +
                        "struggling boxer Butch Coolidge (Bruce Willis) ; master fixer Winston Wolfe (Harvey Keitel) and a nervous pair of armed robbers, " +
                        "\"Pumpkin\" (Tim Roth) and \"Honey Bunny\" (Amanda Plummer)."));

        movies.add(new Movie(2, "Land Before Time", "1990", "Jack Foreman",
                "Dwane Johnson",
                "3", "drama",
                "Dinosaurs must travel through unknown lands to find salvation."));

        return movies;
    }



    @PostMapping
    public void create(@RequestBody Movie newMovie){
//        System.out.println(newMovie);
        moviesList.add(newMovie);
    }

//    @PostMapping
//    public void create(@RequestBody Movie movie){
//        System.out.println(movie);
//    }

    @PostMapping("all")
    public void createAll(@RequestBody List<Movie> moviesToAdd){
//        System.out.println(moviesToAdd);

        moviesList.addAll(moviesToAdd);
    }
}