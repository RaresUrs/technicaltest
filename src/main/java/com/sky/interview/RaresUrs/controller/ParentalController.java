package com.sky.interview.RaresUrs.controller;

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
    private boolean checkParentalControl(@PathVariable int id, @PathVariable String age) throws TitleNotFoundException {
        return parentalControlService.getParentalControl(id, age);
    }

    @PostMapping("/request")
    public ResponseEntity saveMovie(@RequestBody Movie movie) {
        parentalControlService.save(movie);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
