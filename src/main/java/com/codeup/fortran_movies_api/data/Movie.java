package com.codeup.fortran_movies_api.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /* -------- FIELDS -------- */
    private int id;
    private String title;
    private String year;
    private String plot;
    private String poster;

    @ManyToOne
    @JsonIgnoreProperties("ratedMovies")
    private Rating rating;

    @ManyToOne // Many movies have the same director
    @JsonIgnoreProperties("directedMovies")
    private Director director;

    // TODO: We need to define the same many-to-many relationship, but from the Movie side (with a little less annotation fun)
    @ManyToMany(mappedBy = "movies") // <- maps to the Genre class' movies property
    @JsonIgnoreProperties("movies")
    // <- keeps Jackson from making a list of genres with a list of movies with a list of genres with a list of movies...
    private List<Genre> genres;

    @ManyToMany(mappedBy = "movies") // <- maps to the Genre class' movies property
    @JsonIgnoreProperties("movies")
    // <- keeps Jackson from making a list of actors with a list of movies with a list of actors with a list of movies...
    private List<Actor> actors;

    /* -------- CONSTRUCTOR -------- */
    public Movie(int id, String title, String year, String plot, String poster) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.plot = plot;
        this.poster = poster;
    }

    public Movie(String title, String year, String plot, String poster) {
        this.title = title;
        this.year = year;
        this.plot = plot;
        this.poster = poster;
    }

    /* -------- EMPTY CONSTRUCTOR -------- */
    public Movie() {
    }

    /* -------- GETTERS & SETTERS -------- */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", director=" + director.getName() +
                ", plot='" + plot + '\'' +
                ", poster='" + poster + '\'' +
                ", rating='" + rating.getRating() + '\'' +
                '}';
    }
}
