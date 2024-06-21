package com.bookmyshow.Controller;


import com.bookmyshow.Model.Cinema;
import com.bookmyshow.Model.Movie;
import com.bookmyshow.Service.CinemaService;
import com.bookmyshow.Service.ShowService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinema")
@CrossOrigin(
        value = "http://localhost:3000/"
)
public class cinemaController {
    @Autowired
    CinemaService cinemaService;

    @PostMapping("/add")
    public ResponseEntity<String> addCinema(@RequestBody Cinema cinema){

        return cinemaService.addCinema(cinema);
    }

    @GetMapping("/getCity")
    public ResponseEntity<?>getCity(){
        return cinemaService.getCity();
    }
}
