package com.example.cinema.repository;

import com.example.cinema.entity.MovieSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<MovieSession, Long> {
    
    List<MovieSession> findByMovieTitleContainingIgnoreCaseOrStudioContainingIgnoreCase(String movieTitle, String studio);

    
    @Query("SELECT DATE(s.sessionDateTime), COUNT(s) FROM MovieSession s GROUP BY DATE(s.sessionDateTime) ORDER BY DATE(s.sessionDateTime) ASC")
    List<Object[]> countSessionsByDay();
}
