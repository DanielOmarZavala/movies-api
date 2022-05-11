package com.codeup.fortran_movies_api.web;

import com.codeup.fortran_movies_api.data.Movie;
import com.codeup.fortran_movies_api.data.MoviesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin //this is to help with local dev testing
@RestController
@RequestMapping(value = "/api/movies", headers = "Accept=application/json")
public class MoviesController {

    private List<Movie> moviesList = setMovies();
    private final MoviesRepository moviesRepository;

    public MoviesController(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    @GetMapping("all") // Path becomes: /api/movies/all
    public List<Movie> getAll() {
        return moviesRepository.findAll(); // TODO: findAll() will return a list of objects and is provided by the JpaRepository
    }

    // /api/movies/3 <- 3 is the path variable for id
    @GetMapping("{id}") // Define the path variable to use here
    public Movie getById(@PathVariable int id) { // Actually use the path variable here by annotating a parameter with @PathVariable
        return moviesRepository.findById(id).orElse(null); // prevent errors by returning null... not the greatest practice, but it'll do for now
    }

    @GetMapping("search") // /api/movies/search?title=<movieTitle>
    public List<Movie> getByTitle(@RequestParam("title") String title) {
        // TODO: we need to create the findByTitle() method in our MoviesRepository - magic!
        return moviesRepository.findByTitle(title);
    }

    @PostMapping
    public void create(@RequestBody Movie movie) {
        // add to our movies list (fake db)
        moviesRepository.save(movie);
    }

    @PostMapping("many")// /api/movies/many POST
    public void createMany(@RequestBody List<Movie> movies) { // @RequestBody is very important to knowing how the Request's body maps
        System.out.println(movies.getClass());
        moviesList.addAll(movies); // addAll (on the Collection object) allows us to add all the elements from one collection to another in a single line
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable int id, HttpServletResponse response) throws IOException {
        try {
            moviesRepository.deleteById(id);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No Matching movie with ID: " + id);
        }
    }

    // This utility method simply sets up and populates our sampleMovies backing field
    // Will remove once we integrate with the database
    private List<Movie> setMovies() {

        List<Movie> movies = new ArrayList<>();

//        movies.add(new Movie(2, "Pulp Fiction", "1994", "Quentin Tarantino",
//                "Samuel L. Jackson, Uma Therman, Bruce Willis, John Travolta, Ving Rhames",
//                "10", "action, drama, suspense, cult classic, crime",
//                "Vincent Vega (John Travolta) and Jules Winnfield (Samuel L. Jackson) are hitmen with a penchant for philosophical discussions. " +
//                        "In this ultra-hip, multi-strand crime movie, their storyline is interwoven with those of their boss, " +
//                        "gangster Marsellus Wallace (Ving Rhames) ; his actress wife, Mia (Uma Thurman) ; " +
//                        "struggling boxer Butch Coolidge (Bruce Willis) ; master fixer Winston Wolfe (Harvey Keitel) and a nervous pair of armed robbers, " +
//                        "\"Pumpkin\" (Tim Roth) and \"Honey Bunny\" (Amanda Plummer)."));
//
//        movies.add(new Movie(2, "Land Before Time", "1990", "Jack Foreman",
//                "Dwane Johnson",
//                "3", "drama",
//                "Dinosaurs must travel through unknown lands to find salvation."));

        return movies;
    }
}