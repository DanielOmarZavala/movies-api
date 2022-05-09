package com.codeup.fortran_movies_api.web;

import com.codeup.fortran_movies_api.data.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {


    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello, from le Spring!";
    }


    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }


    @GetMapping("/increment/{number}")
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }


    // new stuff for today 5/9
    @GetMapping("{id}")
    public Movie getById(@PathVariable int id) {
        System.out.println(id);
        return null;
    }

    private List<Movie> sampleMovies = setMovies();

    @GetMapping
    public Movie one() {
        return new Movie(1, "director", "year");
    }

    @GetMapping("all") // Path becomes: /api/movies/all
    public list<Movie> getAll(){
        return new sampleMovies;
    }

    private List<Movie> setMovies() {
        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie(2, "Pulp Fiction", "1994", "some director", "Samuel L. Jackson, Uma Therman, Bruce Willis, John Travolta",
                "10", "action, drama, suspense, crime",
                "Vincent Vega (John Travolta) and Jules Winnfield (Samuel L. Jackson) are hitmen with a penchant for philosophical discussions. In this ultra-hip, multi-strand crime movie, their storyline is interwoven with those of their boss, gangster Marsellus Wallace (Ving Rhames) ; his actress wife, Mia (Uma Thurman) ; struggling boxer Butch Coolidge (Bruce Willis) ; master fixer Winston Wolfe (Harvey Keitel) and a nervous pair of armed robbers, \"Pumpkin\" (Tim Roth) and \"Honey Bunny\" (Amanda Plummer)."));

        return movies;
    }

}
