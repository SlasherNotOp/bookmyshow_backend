package com.bookmyshow.Repository;

import com.bookmyshow.Model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieRepositoryTest {
    @Autowired
    MovieRepository movieRepository;

    @Test
    public void deleteMovie(){
        String abc="A journey undertaken by a single man over a span of 10 years in the pursuit of making a name for the nation. `Maidaan`, a true story of India`s greatest football coach, Syed Abdul Rahim -a story of the Golden Era of Indian Football, a story of true grit and unfathomable passion.";
       System.out.println(abc.length());

        }

}