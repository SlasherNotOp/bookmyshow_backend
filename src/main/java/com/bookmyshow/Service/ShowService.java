package com.bookmyshow.Service;

import com.bookmyshow.Model.Movie;
import com.bookmyshow.Model.Show;
import com.bookmyshow.Repository.CinemaRepository;
import com.bookmyshow.Repository.MovieRepository;
import com.bookmyshow.Repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    ShowRepository showRepository;
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    CinemaRepository cinemaRepository;

    public ResponseEntity<String> addShow(Show show,long movieId,long cinemaId) {
        try {
            show.setMovie(movieRepository.findById(movieId).get());
            show.setCinema(cinemaRepository.findById(cinemaId).get());
            showRepository.save(show);
            return new ResponseEntity<>("sucess",HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
       return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
    }
//    public ResponseEntity<List<Movie>> getMovieByAddress(String city) {
//        try {
//            return new ResponseEntity<>(showRepository.getMovieByAddress(city),HttpStatus.OK);
//
//        }catch (Exception e){
//            e.printStackTrace();
//
//        }
//        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
//    }
}
