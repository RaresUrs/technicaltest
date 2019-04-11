package com.sky.interview.RaresUrs.service.parentalcontrol;

import com.sky.interview.RaresUrs.exception.TitleNotFoundException;
import com.sky.interview.RaresUrs.repository.Movie;
import com.sky.interview.RaresUrs.service.movie.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentalControlServiceImpl {

    @Autowired
    private MovieServiceImpl movieService;

    public boolean getParentalControl(int movieId, String parentalControlLevel) throws TitleNotFoundException {

        Movie movie = movieService.findById(movieId);
        if (movie == null) {
            throw new TitleNotFoundException("The movie with the id " + movieId + " does not exist");
        }

        // logic to handle age restrictions
        return movie.getAgeRestriction().equals(parentalControlLevel);
    }

    public void save(Movie movie) {
        movieService.save(movie);
    }
}
