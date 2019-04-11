package com.sky.interview.RaresUrs.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int id;

    public String name;

    public String ageRestriction;

    public Movie() {
        // Needed for jpa
    }

    public Movie(String name, String ageRestriction) {
        this.name = name;
        this.ageRestriction = ageRestriction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(String ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id &&
                Objects.equals(name, movie.name) &&
                Objects.equals(ageRestriction, movie.ageRestriction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ageRestriction);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ageRestriction='" + ageRestriction + '\'' +
                '}';
    }
}
