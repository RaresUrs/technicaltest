package com.sky.interview.RaresUrs.service.parentalcontrol;

import com.sky.interview.RaresUrs.exception.TitleNotFoundException;
import com.sky.interview.RaresUrs.repository.Movie;
import com.sky.interview.RaresUrs.service.movie.MovieRepository;
import com.sky.interview.RaresUrs.service.movie.MovieServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


@RunWith(SpringJUnit4ClassRunner.class)
public class MovieServiceImplTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieServiceImpl movieService;

    private Movie movie;

    @Before
    public void setUp() {
        movie = new Movie();
        movie.setAgeRestriction("12");
        movie.setId(1);
    }

    @Test
    public void testWhenTheMovieCanBeFound() throws TitleNotFoundException {
        when(movieRepository.findById(1)).thenReturn(movie);

        Movie response = movieService.findById(1);
        assertEquals(response.getAgeRestriction(), movie.getAgeRestriction());
    }

    @Test(expected = TitleNotFoundException.class)
    public void testExceptionWhenMovieCannotBeFound() throws TitleNotFoundException {
        when(movieRepository.findById(1)).thenReturn(movie);

        Movie response = movieService.findById(2);
        assertEquals(response.getAgeRestriction(), movie.getAgeRestriction());
    }
}