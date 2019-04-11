package com.sky.interview.RaresUrs.service.movie;

import com.sky.interview.RaresUrs.repository.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
    Movie findById(int id);
}
