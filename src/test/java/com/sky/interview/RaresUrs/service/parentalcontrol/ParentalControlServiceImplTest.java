package com.sky.interview.RaresUrs.service.parentalcontrol;

import com.sky.interview.RaresUrs.exception.TechnicalFailureException;
import com.sky.interview.RaresUrs.exception.TitleNotFoundException;
import com.sky.interview.RaresUrs.repository.Movie;
import com.sky.interview.RaresUrs.service.movie.MovieRepository;
import com.sky.interview.RaresUrs.service.movie.MovieServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class ParentalControlServiceImplTest {

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private MovieServiceImpl movieService;

    @InjectMocks
    private ParentalControlServiceImpl parentalControlService;

    @Test(expected = TechnicalFailureException.class)
    public void testWhenTheCustomerIsNowAllowedToWatchTheMovie() throws TitleNotFoundException, TechnicalFailureException {
        Movie movie = new Movie();
        movie.setAgeRestriction("12");
        movie.setId(1);

        when(movieRepository.findById(1)).thenReturn(movie);
        when(movieService.findById(1)).thenReturn(movie);

        parentalControlService.getParentalControl(1, "U");
    }

    @Test
    public void testWhenCustomerIsAllowedToWatchTheMovie() throws TitleNotFoundException, TechnicalFailureException {
        Movie movie = new Movie();
        movie.setAgeRestriction("12");
        movie.setId(1);

        when(movieRepository.findById(1)).thenReturn(movie);
        when(movieService.findById(1)).thenReturn(movie);

        boolean isCustomerAllowed = parentalControlService.getParentalControl(1, "15");
        assertTrue(isCustomerAllowed);
    }

    @Test(expected = TitleNotFoundException.class)
    public void testWhenMovieIsNotFound() throws TitleNotFoundException, TechnicalFailureException {
        Movie movie = new Movie();
        movie.setAgeRestriction("12");
        movie.setId(1);

        when(movieRepository.findById(1)).thenReturn(movie);
        when(movieService.findById(1)).thenReturn(movie);

        parentalControlService.getParentalControl(2, "15");
    }
}