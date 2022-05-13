package com.codeup.fortran_movies_api.web;

import com.codeup.fortran_movies_api.data.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin //this is to help with local dev testing
@RestController
@RequestMapping(value = "/api/movies", headers = "Accept=application/json")
public class MoviesController {

    private final MoviesRepository moviesRepository;
    private final DirectorsRepository directorsRepository;
    private final GenresRepository genresRepository;
    private final ActorsRepository actorsRepository;

    public MoviesController(MoviesRepository moviesRepository, DirectorsRepository directorsRepository, GenresRepository genresRepository, ActorsRepository actorsRepository) {
        this.moviesRepository = moviesRepository;
        this.directorsRepository = directorsRepository;
        this.genresRepository = genresRepository;
        this.actorsRepository = actorsRepository;
    }

    // /api/movies/3 <- 3 is the path variable for id
    @GetMapping("{id}") // Define the path variable to use here
    public Movie getById(@PathVariable int id) { // Actually use the path variable here by annotating a parameter with @PathVariable
        return moviesRepository.findById(id).orElse(null); // prevent errors by returning null... not the greatest practice, but it'll do for now
    }

    // TODO: put the expected path out to the side of the method annotation
    //  -> this helps to keep track so we don't have to guess if methods conflict on the same path
    @GetMapping("all") // /api/movies/all
    public List<MovieDto> getAll() {

        List<Movie> movieEntities = moviesRepository.findAll(); // TODO: findAll() will return a list of objects and is provided by the JpaRepository
        List<MovieDto> movieDtos = new ArrayList<>();

        for (Movie movie : movieEntities) {
            movieDtos.add(new MovieDto(movie.getId(),
                    movie.getTitle(),
                    movie.getRating(),
                    movie.getPoster(),
                    movie.getYear(),
                    movie.getGenres().stream().map(Genre::getName).collect(Collectors.joining(", ")),
                    movie.getDirector().getName(),
                    movie.getPlot()));
//                    movie.getActors()));
        }

        return movieDtos;
    }

    @GetMapping("search") // /api/movies/search?title=<movieTitle>
    public List<Movie> getByTitle(@RequestParam("title") String title) {
        // TODO: we need to create the findByTitle() method in our MoviesRepository - magic!
        return moviesRepository.findByTitle(title);
    }

    @GetMapping("search/year") // api/movies/search/year
    public List<Movie> getByYearRange(@RequestParam("startYear") int startYear, @RequestParam("endYear") int endYear) {
        // TODO: @RequestParam expects a query parameter in the request URL
        //  to have a param matching what is in the annotation (ie: @RequestParam("startYear"))
        return moviesRepository.findByYearRange(startYear, endYear);
    }

    @GetMapping("search/director")
    public List<Director> getByDirector(@RequestParam("directorName") String directorName) {
        return directorsRepository.findByName(directorName);
    }

    @GetMapping("search/genre")
    public List<Genre> getByGenre(@RequestParam("genres") String genres) {
        return genresRepository.findByName(genres);
    }

    @GetMapping("search/actor")
    public List<Actor> getByActor(@RequestParam("actorName") String actorName) {
        return actorsRepository.findByName(actorName);
    }

    @PostMapping // /api/movies POST
    public void create(@RequestBody Movie movie) {
        // add to our movies list (fake db)
        moviesRepository.save(movie);
    }

    @PostMapping("many")// /api/movies/many POST
    public void createMany(@RequestBody List<Movie> movies) { // @RequestBody is very important to knowing how the Request's body maps
        // saveAll() lets you pass a collection as an argument and commit all the objects to the database
        moviesRepository.saveAll(movies); // addAll (on the Collection object) allows us to add all the elements from one collection to another in a single line
    }

    @PutMapping
    public void updateOne(@RequestBody Movie movie) {
        moviesRepository.save(movie);
    }

    // TODO: make a delete request method here!
    @DeleteMapping("{id}") // api/movies/{id} -> api/movies/3 DELETE
    public void deleteById(@PathVariable int id) throws IOException {
        try {
            moviesRepository.deleteById(id);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No Matching movie with ID: " + id);
        }
    }
}