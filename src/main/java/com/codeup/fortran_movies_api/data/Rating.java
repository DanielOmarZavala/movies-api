package com.codeup.fortran_movies_api.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ratings")
public class Rating {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String score;

    @OneToMany(mappedBy = "rating")
    @JsonIgnoreProperties("rating")
    private List<Movie> ratedMovies;

    public Rating(int id, String score) {
        this.id = id;
        this.score = score;
    }

    public Rating() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //TODO: Finish getScore (RATING) functionality
    public String getScore() {
        return score;
    }

    public void setScore(String rating) {
        this.score = rating;
    }

    public List<Movie> getRatedMovies() {
        return ratedMovies;
    }

    public void setRatedMovies(List<Movie> ratedMovies) {
        this.ratedMovies = ratedMovies;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", rating=" + score +
                '}';
    }
}
