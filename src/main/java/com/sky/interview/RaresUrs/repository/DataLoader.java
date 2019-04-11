package com.sky.interview.RaresUrs.repository;

import com.sky.interview.RaresUrs.service.movie.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private MovieServiceImpl movie;

    @Autowired
    public DataLoader(MovieServiceImpl movie) {
        this.movie = movie;
    }

    public void run(ApplicationArguments args) {
        movie.save(new Movie("Terminator", "12"));
        movie.save(new Movie("Pirates", "15"));
        movie.save(new Movie("Deadpool", "12"));
        movie.save(new Movie("Gladiator", "U"));
        movie.save(new Movie("Titanic", "PG"));
        movie.save(new Movie("Titanic", "15"));
    }
}