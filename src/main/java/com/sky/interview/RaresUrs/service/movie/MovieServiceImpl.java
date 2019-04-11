package com.sky.interview.RaresUrs.service.movie;

import com.sky.interview.RaresUrs.repository.Movie;
import com.sky.interview.RaresUrs.exception.TitleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl {

    @Autowired
    private MovieRepository movieRepository;

    public Movie findById(int id) throws TitleNotFoundException {
        Movie movie = movieRepository.findById(id);
        if(movie == null) {
            throw new TitleNotFoundException("Movie does not exist: " + id);
        }
        return movieRepository.findById(id);

    }

    public void save(Movie movie) {
        movieRepository.save(movie);
    }
}
