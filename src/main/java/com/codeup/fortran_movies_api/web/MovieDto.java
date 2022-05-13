package com.codeup.fortran_movies_api.web;

import com.codeup.fortran_movies_api.data.Actor;

import java.util.List;

public class MovieDto {

    /* -------- FIELDS -------- */
//    private int id;
//    private String actors;
//    private String director;
//    private String genre;
//    private String plot;
//    private String poster;
//    private String rating;
//    private String title;
//    private String year;

    private int id;
    private String title;
    private String rating;
    private String poster;
    private String year;
    private String genre;
    private String director;
    private String plot;
    private String actors;

    /* -------- CONSTRUCTORS -------- */
    public MovieDto(int id, String title, String rating, String poster, String year, String genre, String director, String plot) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.poster = poster;
        this.year = year;
        this.genre = genre;
        this.director = director;
        this.plot = plot;
//        this.actors = actors;
    }

    public MovieDto() {
    }

    /* -------- GETTERS & SETTERS -------- */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getActors() {
//        return actors;
//    }
//
//    public void setActors(String actors) {
//        this.actors = actors;
//    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "id=" + id +
                ", actors='" + actors + '\'' +
                ", director='" + director + '\'' +
                ", genre='" + genre + '\'' +
                ", plot='" + plot + '\'' +
                ", poster='" + poster + '\'' +
                ", rating='" + rating + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}

/*
* {
      "title": "tenet",
      "rating": "5",
      "poster": "https://m.media-amazon.com/images/M/MV5BYzg0NGM2NjAtNmIxOC00MDJmLTg5ZmYtYzM0MTE4NWE2NzlhXkEyXkFqcGdeQXVyMTA4NjE0NjEy._V1_SX300.jpg",
      "year": "2020",
      "genre": "Action, Sci-Fi",
      "director": "Christopher Nolan",
      "plot": "Armed with only one word, Tenet, and fighting for the survival of the entire world, a Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.",
      "actors": "Elizabeth Debicki, Robert Pattinson, John David Washington, Aaron Taylor-Johnson",
      "id": 3
    }
* */

