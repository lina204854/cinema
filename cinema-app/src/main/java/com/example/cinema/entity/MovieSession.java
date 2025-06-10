package com.example.cinema.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Entity
@Table(name = "movie_sessions")
public class MovieSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Название фильма не может быть пустым")
    @Column(name = "movie_title")
    private String movieTitle;

    private String studio;

    @NotNull(message = "Дата и время сеанса не могут быть пустыми")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "session_date_time")
    private LocalDateTime sessionDateTime;

    @NotNull(message = "Количество билетов не может быть пустым")
    @Column(name = "ticket_count")
    private Integer ticketCount;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getMovieTitle() { return movieTitle; }
    public void setMovieTitle(String movieTitle) { this.movieTitle = movieTitle; }
    public String getStudio() { return studio; }
    public void setStudio(String studio) { this.studio = studio; }
    public LocalDateTime getSessionDateTime() { return sessionDateTime; }
    public void setSessionDateTime(LocalDateTime sessionDateTime) { this.sessionDateTime = sessionDateTime; }
    public Integer getTicketCount() { return ticketCount; }
    public void setTicketCount(Integer ticketCount) { this.ticketCount = ticketCount; }
}
