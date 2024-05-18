package com.bookmyshow.Service;

import com.bookmyshow.Model.Cinema;
import com.bookmyshow.Repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class CinemaService {
    @Autowired
    CinemaRepository cinemaRepository;
    public ResponseEntity<String> addCinema(Cinema cinema) {
        try{
            cinemaRepository.save(cinema);
            return new ResponseEntity<>("sucess",HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> getCity() {
        try {

        return new ResponseEntity<>(cinemaRepository.findDistinctAddress(),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("error",HttpStatus.BAD_REQUEST);

    }
}
