package com.bookmyshow.Service;

import com.bookmyshow.Model.Movie;
import com.bookmyshow.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public ResponseEntity<String> addMovie(Movie movie) {
        try{
            movieRepository.save(movie);
            return new ResponseEntity<>("success", HttpStatus.CREATED);


        }catch (Exception e){
            e.printStackTrace();
           return new ResponseEntity<>("bad request", HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<List<Movie>>getMovie(){
        try {
            List<Movie>movies= movieRepository.findAll();
            return new ResponseEntity<>(movies,HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }

    }
}
