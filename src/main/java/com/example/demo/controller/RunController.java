package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Run;
import com.example.demo.repository.RunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RunController {

    @Autowired
    RunRepository runRepository;

    @GetMapping("/runs")
    public List<Run> getRuns() {return runRepository.findAll();}

    @GetMapping("/runs/{id}")
    public Optional<Run> getRunsById(@PathVariable(value="id") Long id ){
        Run run = runRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("COULD NOT FIND RUN W ID: " + id));
        return runRepository.findById(id);
    }




}
