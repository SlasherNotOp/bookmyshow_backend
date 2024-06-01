package com.bookmyshow.Controller;

import com.bookmyshow.Model.Movie;
import com.bookmyshow.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@CrossOrigin("http://localhost:5173/")
public class movieController {

    @Autowired
    MovieService movieService;
    @PostMapping("/add")
    public ResponseEntity<String>addMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Movie>>getMovie(){
        return movieService.getMovie();
    }

}
