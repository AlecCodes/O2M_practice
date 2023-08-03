package com.example.demo.controller;
import java.util.List;
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



}
