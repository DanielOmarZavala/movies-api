package com.codeup.fortran_movies_api.data;

import javax.persistence.*;

@Entity
@Table(name="movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /* -------- FIELDS -------- */
    private int id;
    private String title;
    private String year;
    @ManyToOne
    private Director director;
    private String plot;

    /* -------- CONSTRUCTOR -------- */
    public Movie(int id, String title, String year, String director, String actors, String imdbId, String genre, String plot) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.plot = plot;
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

//    public String getDirector() {
//        return director;
//    }
//
//    public void setDirector(String director) {
//        this.director = director;
//    }
//
//    public String getActors() {
//        return actors;
//    }
//
//    public void setActors(String actors) {
//        this.actors = actors;
//    }
//
//    public String getGenre() {
//        return genre;
//    }
//
//    public void setGenre(String genre) {
//        this.genre = genre;
//    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
//                ", director='" + director + '\'' +
//                ", actors='" + actors + '\'' +
//                ", genre='" + genre + '\'' +
                ", plot='" + plot + '\'' +
                '}';
    }
}
