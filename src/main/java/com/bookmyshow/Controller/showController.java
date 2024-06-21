package com.bookmyshow.Controller;

import com.bookmyshow.Model.Movie;
import com.bookmyshow.Model.Show;
import com.bookmyshow.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("show")
@CrossOrigin(
        value = "http://localhost:3000/"
)
public class showController {

    @Autowired
    ShowService showService;

    @GetMapping("/{city}")
    public ResponseEntity<List<Movie>>getMovieByAddress(@PathVariable String city){
        return showService.getMovieByAddress(city);
    }

    @PostMapping("/add")
    public ResponseEntity<String>addShow(@RequestBody Show show,@RequestParam long movieId,@RequestParam long cinemaId){

        return showService.addShow(show,movieId,cinemaId);
    }


}
