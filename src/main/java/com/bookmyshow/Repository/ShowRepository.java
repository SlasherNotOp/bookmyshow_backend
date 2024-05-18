package com.bookmyshow.Repository;

import com.bookmyshow.Model.Movie;
import com.bookmyshow.Model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show,Long> {

//    @Query(name = "SELECT DISTINCT s.movie FROM show s JOIN s.cinema c WHERE c.address=:cinemaAddress")
//    public List<Movie>getMovieByAddress(@Param("cinemaAddress") String cinemaAddress);
}
