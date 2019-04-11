package com.sky.interview.RaresUrs.service.parentalcontrol;

import com.sky.interview.RaresUrs.exception.TechnicalFailureException;
import com.sky.interview.RaresUrs.exception.TitleNotFoundException;
import com.sky.interview.RaresUrs.helper.AgeRestrictionComparator;
import com.sky.interview.RaresUrs.repository.Movie;
import com.sky.interview.RaresUrs.service.movie.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentalControlServiceImpl {

    @Autowired
    private MovieServiceImpl movieService;

    private AgeRestrictionComparator comparator = new AgeRestrictionComparator();

    public boolean getParentalControl(int movieId, String parentalControlLevel) throws TitleNotFoundException, TechnicalFailureException {

        Movie movie = movieService.findById(movieId);
        if (movie == null) {
            throw new TitleNotFoundException("The movie with the id " + movieId + " does not exist");
        }

        final int compare = comparator.compare(parentalControlLevel, movie.getAgeRestriction());
        if(compare < 0) {
            throw new TechnicalFailureException("Sorry, you are now allowed to watch the movie" + movie.getName());
        }
        return compare > 0;
    }

    public void save(Movie movie) {
        movieService.save(movie);
    }
}
