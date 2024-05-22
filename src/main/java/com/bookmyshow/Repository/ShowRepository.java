package com.bookmyshow.Repository;

import com.bookmyshow.Model.Movie;
import com.bookmyshow.Model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show,Long> {

//    @Query(name = "SELECT DISTINCT s.movie FROM show s JOIN cinema c ON s.cinema_id = c.cinemaId WHERE c.address = :cinemaAddress;")
//    public List<Movie>getMovieByAddress(@Param("cinemaAddress") String cinemaAddress);

//    select m.movie_id FROM show s JOIN cinema c ON s.cinema_id=c.cinema_id JOIN movie m ON s
//.movie_id=m.movie_id where c.address='dhule';
    @Query("SELECT s.movie FROM Show s JOIN s.cinema c JOIN s.movie m WHERE c.address = :cinemaAddress")
    public List<Movie>getMovieByAddress(@Param("cinemaAddress") String cinemaAddress);
}
