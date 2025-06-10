package com.example.cinema.controller;

import com.example.cinema.entity.MovieSession;
import com.example.cinema.repository.SessionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class SessionController {

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping("/sessions")
    public String listSessions(Model model,
                               @RequestParam(value = "keyword", required = false) String keyword,
                               @RequestParam(value = "sort", defaultValue = "sessionDateTime") String sortField) {
        List<MovieSession> sessions;
        if (keyword != null && !keyword.trim().isEmpty()) {
            sessions = sessionRepository.findByMovieTitleContainingIgnoreCaseOrStudioContainingIgnoreCase(keyword, keyword);
            model.addAttribute("keyword", keyword);
        } else {
            Sort.Direction direction = sortField.endsWith(",desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
            String property = sortField.split(",")[0];
            sessions = sessionRepository.findAll(Sort.by(direction, property));
        }
        model.addAttribute("sessions", sessions);
        model.addAttribute("sortField", sortField);
        return "session-list";
    }

    @GetMapping("/sessions/new")
    public String showCreateForm(Model model) {
        model.addAttribute("session", new MovieSession());
        return "session-form";
    }

    @PostMapping("/sessions/save")
    public String saveSession(@Valid @ModelAttribute("session") MovieSession session, BindingResult result) {
        if (result.hasErrors()) {
            return "session-form";
        }
        sessionRepository.save(session);
        return "redirect:/sessions";
    }

    @GetMapping("/sessions/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        MovieSession session = sessionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid session Id:" + id));
        model.addAttribute("session", session);
        return "session-form";
    }

    @GetMapping("/sessions/delete/{id}")
    public String deleteSession(@PathVariable("id") Long id) {
        sessionRepository.deleteById(id);
        return "redirect:/sessions";
    }

    @GetMapping("/api/sessions/daily-stats")
    @ResponseBody
    public List<Map<String, Object>> getDailySessionStats() {
        return sessionRepository.countSessionsByDay().stream()
                .map(record -> Map.of("sessionDate", record[0], "sessionCount", record[1]))
                .collect(Collectors.toList());
    }
}
