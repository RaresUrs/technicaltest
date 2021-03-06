package com.sky.interview.RaresUrs.controller;

import com.sky.interview.RaresUrs.exception.TechnicalFailureException;
import com.sky.interview.RaresUrs.repository.Movie;
import com.sky.interview.RaresUrs.service.parentalcontrol.ParentalControlServiceImpl;
import com.sky.interview.RaresUrs.exception.TitleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParentalController {

    @Autowired
    private ParentalControlServiceImpl parentalControlService;

    @GetMapping("/check/movie/{age}/{id}")
    private ResponseEntity<String> checkParentalControl(@PathVariable int id, @PathVariable String age) throws TitleNotFoundException {
        try {
            parentalControlService.getParentalControl(id, age);
            return new ResponseEntity<>("You can watch this movie: " + id, HttpStatus.OK);
        } catch (TechnicalFailureException e) {
            return new ResponseEntity<>("Sorry, due to your age you are now allowed to see the movie with the id:  "
                    + id, HttpStatus.OK);
        } catch (TitleNotFoundException movieNotFound) {
            return new ResponseEntity<>("Sorry, the move you are looking for does not exist  "
                    + id, HttpStatus.OK);
        }
    }

    @PostMapping("/add/movie")
    public ResponseEntity saveMovie(@RequestBody Movie movie) {
        parentalControlService.save(movie);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
