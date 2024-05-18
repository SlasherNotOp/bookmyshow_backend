package com.bookmyshow.Repository;

import com.bookmyshow.Model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema,Long> {

    @Query("SELECT DISTINCT u.address FROM Cinema u")
    public List<String> findDistinctAddress();
}
