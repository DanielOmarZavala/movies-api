package com.codeup.fortran_movies_api.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoviesRepository extends JpaRepository <Movie, Integer>{

    // TODO: Spring Data is pretty neat in that it reads your method name and interprets how to build the actual implementation of the query!
    List<Movie> findByTitle(String title);
    // If a query could possibly return more than one object, you should probably account for that by having the return type of your method be a List<T>

}
